package utils;

import models.EmailValidationData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USER_NAME = "postgres";
    private final static String USER_PASS = "postgres";
    private final static String SELECT_QUEARY = "select * from EmailValidations";

    private final static String QUERY_INSERT = "insert into EmailValidations values(?,?,?,?)";
    private final static String QUERY_UPDATE = "update EmailValidations set name=? where id=?";
    private final static String QUERY_DELETE = "delete from EmailValidations where id=?";

    public static List<EmailValidationData> getDataFromDB(){

        List<EmailValidationData> formData = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASS)){
            Statement statement = connection.createStatement();
            ResultSet resSet = statement.executeQuery(SELECT_QUEARY);
            while (resSet.next()){
                EmailValidationData row = new EmailValidationData(resSet.getString("name"), resSet.getString("email"), resSet.getString("textArea"));
                formData.add(row);
            }

        }   catch (SQLException exception) {
            throw new RuntimeException("Check url, user name and password");
        }
        return formData;
    }

    public static void insert(int id, String name, String email, String textArea){

        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASS)){
            PreparedStatement prepSt = connection.prepareStatement(QUERY_INSERT);
            prepSt.setInt(1, id);
            prepSt.setString(2, name);
            prepSt.setString(3, email);
            prepSt.setString(4, textArea);
            prepSt.executeUpdate();

        }   catch (SQLException exception) {
            throw new RuntimeException("Check url, user name and password");
        }

    }

    public static void update(String name, int id){

        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASS)){
            PreparedStatement prepSt = connection.prepareStatement(QUERY_UPDATE);
            prepSt.setString(1, name);
            prepSt.setInt(2, id);
            prepSt.executeUpdate();

        }   catch (SQLException exception) {
            throw new RuntimeException("Check url, user name and password");
        }

    }

    public static void delete(int id){
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASS)){
            PreparedStatement prepSt = connection.prepareStatement(QUERY_DELETE);
            prepSt.setInt(1, id);
            prepSt.executeUpdate();

        }   catch (SQLException exception) {
            throw new RuntimeException("Check url, user name and password");
        }

    }





    public static void main(String[] args) {
        getDataFromDB();
        //insert(7, "Ben", "@@@@", "Some new text");
        //update("Cate", 3);
        //delete(3);
    }

}

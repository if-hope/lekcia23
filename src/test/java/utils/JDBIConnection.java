package utils;

import models.EmailValidationData;
import org.jdbi.v3.core.Jdbi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBIConnection {
    private final static String URL = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=postgres";
    private final static String SELECT_QUERY = "select * from EmailValidations";
    private final static String QUERY_INSERT = "insert into EmailValidations (name, email, textArea) values (:name, :email, :textArea)";
    private final static String QUERY_UPDATE = "update EmailValidations set name=:name where id=:id";
    private final static String QUERY_DELETE = "delete from EmailValidations where id=:id";

    public static List<EmailValidationData> getDataFromDB(){
        return Jdbi.create(URL).withHandle(handle -> {
            return handle.createQuery(SELECT_QUERY).mapToBean(EmailValidationData.class).list();
        });
    }

    public static int insert(EmailValidationData row){
        return Jdbi.create(URL).withHandle(handle -> {
            return handle.createUpdate(QUERY_INSERT).bindBean(row).executeAndReturnGeneratedKeys().mapTo(Integer.class).one();
        });
    }


    public static int update(EmailValidationData row){
        return Jdbi.create(URL).withHandle(handle -> {
            return handle.createUpdate(QUERY_UPDATE).bindBean(row).executeAndReturnGeneratedKeys().mapTo(Integer.class).one();
        });
    }

    public static int delete(EmailValidationData row){
        return Jdbi.create(URL).withHandle(handle -> {
            return handle.createUpdate(QUERY_DELETE).bindBean(row).executeAndReturnGeneratedKeys().mapTo(Integer.class).one();
        });
    }

    public static void deleteSecond(EmailValidationData row){
         Jdbi.create(URL).withHandle(handle -> {
            return handle.createUpdate(QUERY_DELETE).bindBean(row).execute();
        });
    }

    public static void main(String[] args) {
//        List<EmailValidationData> formData = getDataFromDB();
//        System.out.println(formData);
//        int number = insert(new EmailValidationData("John", "test", "text test test"));
//        System.out.println(number);
//        int number = update(new EmailValidationData(7, "Bob"));
//        System.out.println(number);
//        int number = delete(new EmailValidationData(11));
//        System.out.println(number);
        deleteSecond(new EmailValidationData(10));
    }
}

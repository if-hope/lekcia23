package dataprovider;

import org.testng.annotations.DataProvider;

import static utils.DBConnection.getDataFromDB;

public class EmailValidationDataProvider {
    @DataProvider(name = "email validation")
    public Object[][] createData() {
        return new Object[][] {
                {"Nadia", "email", "Some text message"},
                {"Hope", "email@", "Just for test message"},
                {"Tester", "@gmail.com", "Text to be shown in test"}
        };
    }


    @DataProvider(name = "formDataDB")
    public static Object[][] dataFromDB() {
        return getDataFromDB().stream().map(row -> new Object[]{row.getName(), row.getEmail(), row.getTextArea()})
                .toArray(Object[][]::new);
     }

}

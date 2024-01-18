package dataprovider;

import org.testng.annotations.DataProvider;

import static utils.DBConnection.getDataFromDB;

public class EmailValidationDataProvider {
    @DataProvider(name = "email validation")
    public Object[][] createData() {
        return new Object[][] {
                {"Nadia", "email", "Some text message", "Your e-mail address must be in the following format: name@domain.com"},
                {"Hope", "email@", "Just for test message", "Your e-mail address must be in the following format: name@domain.com"},
                {"Tester", "@gmail.com", "Text to be shown in test", "Your e-mail address must be in the following format: name@domain.com"},
                {"Tester", "", "Text to be shown in test", "We need your e-mail address to contact you"},
                {"Tester", "    ", "Text to be shown in test", "We need your e-mail address to contact you"}
        };
    }


    @DataProvider(name = "formDataDB")
    public static Object[][] dataFromDB() {
        return getDataFromDB().stream().map(row -> new Object[]{row.getName(), row.getEmail(), row.getTextArea()})
                .toArray(Object[][]::new);
     }

}

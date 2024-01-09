package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractTest {

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        //Configuration.timeout = 10000;
        //Configuration.browserSize = "1920x1080";

    }


    @AfterMethod
    public void tearDown(){
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
}

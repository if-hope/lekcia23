package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import dataprovider.EmailValidationDataProvider;
import io.qameta.allure.*;
import listeners.HTListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AbstractPage;
import pages.ContactUsPage;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.SeverityLevel.CRITICAL;

//@Listeners(HTListener.class)
public class ContactUsTest extends AbstractTest{

//private static final Logger LOGGER = LogManager.getLogger(ContactUsTest.class);

    @Test(dataProvider = "formDataDB", dataProviderClass = EmailValidationDataProvider.class)
    @Description("This is email validation test")
    @Severity(CRITICAL)
    @Owner("NHope")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    @Epic("First epic")
 @Feature("Second feature")
@Story("Third story")
    public void emailValidationTest(String name, String email, String textArea){
       //LOGGER.info("test has started");
        ContactUsPage contactUsPage = new ContactUsPage().openContactUsPage()
                .fillForm(name, email, textArea);

        contactUsPage.getEmailErrorMessage().shouldHave(Condition.exactText("Your e-mail address must be in the following format: name@domain.com"));

    }

    @Test
    public void captchaAppearingTest() {
        ContactUsPage contactUsPage = new ContactUsPage().openContactUsPage()
                .fillForm("Nadia", "tester234532@gmail.com", "Some text message")
                .checkPrivacyPolicy();

        contactUsPage.getCaptchaDiv().shouldBe(Condition.appear);

    }


}

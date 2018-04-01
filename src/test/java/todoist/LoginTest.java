package todoist;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import pages.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.AndroidSetupToDoist;

public class LoginTest extends AndroidSetupToDoist {

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
    }


    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.skipOtherEmails();
        loginPage.enterUsername();
        loginPage.continueWithEmail();
        loginPage.enterPassword();
        loginPage.clickLogin();
    }
}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AndroidSetupToDoist;




public class LoginPage extends BasePage {
    String app_package_name = "com.todoist:id/";

    By continueLogin = By.id(app_package_name + "btn_welcome_continue_with_email");
    By otherButton = By.id("com.google.android.gms:id/cancel");
    By emailInput = By.id(app_package_name + "email_exists_input");
    By continueWithEmailButton = By.id(app_package_name + "btn_continue_with_email");
    By passwordInput = By.id(app_package_name + "log_in_password");
    By loginButton = By.id(app_package_name + "btn_log_in");


    public LoginPage() {
        this.driver = AndroidSetupToDoist.getDriver();
    }

    public LoginPage open() {
       waitToBePresentAndClick(continueLogin);
        return this;
    }

    public LoginPage skipOtherEmails() {
        waitToBePresentAndClick(otherButton);
        return this;
    }

    public LoginPage enterUsername() {
        waitToBePresentAndSendKeys(emailInput, username);
        return this;
        }

    public LoginPage continueWithEmail() {
        waitToBePresentAndClick(continueWithEmailButton);
        return this;
    }

    public LoginPage enterPassword() {
        waitToBePresentAndSendKeys(passwordInput, password);
        return this;
        }

    public LoginPage clickLogin() {
        waitToBePresentAndClick(loginButton);
        return this;
    }

        //wait.until(ExpectedConditions.presenceOfElementLocated(emptyIcon));

        //assert driver.findElement(emptyIcon).isDisplayed();

}



package todoist;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ToDoistTests  extends AndroidSetupToDoist {
    String app_package_name = "com.todoist:id/";
    By continueLogin = By.id(app_package_name + "btn_welcome_continue_with_email");
    By otherButton = By.id("com.google.android.gms:id/cancel");
    By emailInput = By.id(app_package_name + "email_exists_input");
    By continueWithEmailButton = By.id(app_package_name + "btn_continue_with_email");
    By passwordInput = By.id(app_package_name + "log_in_password");
    By loginButton = By.id(app_package_name +  "btn_log_in");
    By emptyIcon = By.id(app_package_name + "empty_icon");
    By addNewTaskButton = By.id(app_package_name + "fab");
    By taskSummary = By.id("android:id/message");
    By saveTask = By.id("android:id/button1");
    By taskName = By.id(app_package_name + "text");



    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }


    @Test
    public void LoginTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(continueLogin).click();
//TODO replace sleep with wait.until
        Thread.sleep(5000);

        driver.findElement(otherButton).click();
        driver.findElement(emailInput).sendKeys("hillelqaauto52@gmail.com");
        driver.findElement(continueWithEmailButton).click();
        driver.findElement(passwordInput).sendKeys("welcome2hillel");
        driver.findElement(loginButton).click();
//TODO replace sleep with wait.until
        Thread.sleep(5000);
        driver.findElement(emptyIcon).isDisplayed();
    }

    @Test
    public void NewTask() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(addNewTaskButton).click();
        driver.findElement(taskSummary).sendKeys("test task");
        driver.findElement(saveTask).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(taskName));

        assert driver.findElement(taskName).isDisplayed();
    }


}
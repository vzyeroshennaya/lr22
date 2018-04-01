package pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AndroidSetupToDoist;

public class BasePage {
    final static Logger logger = Logger.getLogger(BasePage.class); // initialization of logger

    protected AndroidDriver driver;
    private int defaultExplicitWaitInSeconds = 10;
    public static int defaultImplicitWaitInSeconds = 10;
    protected String username = "hillelqaauto52@gmail.com";
    protected String password = "welcome2hillel";

    protected BasePage() {
        this.driver = AndroidSetupToDoist.getDriver();
    }

    /**
     * @param locator
     */
    protected void waitToBePresent(By locator) {
        logger.info("WAIT ELEMENT TO BE PRESENT: " + locator);
        (new WebDriverWait(driver, defaultExplicitWaitInSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void waitToBePresentAndClick(By locator) {
        logger.info("WAIT ELEMENT TO BE PRESENT AND CLICK: " + locator);
        WebElement element = null;

        try {
            element = (new WebDriverWait(driver, defaultExplicitWaitInSeconds)).
                    until(ExpectedConditions.presenceOfElementLocated(locator));
            element.click();
        } catch (StaleElementReferenceException ignored) {
            element = (new WebDriverWait(driver, defaultExplicitWaitInSeconds)).
                    until(ExpectedConditions.presenceOfElementLocated(locator));
            element.click();
        }

    }

    protected void waitToBePresentAndSendKeys(By locator, String keys) {
        logger.info("WAIT ELEMENT TO BE PRESENT AND SEND KEYS: SEND " + keys + " TO "+ locator);

        WebElement element = null;

        try {
            element = (new WebDriverWait(driver, defaultExplicitWaitInSeconds)).
                    until(ExpectedConditions.presenceOfElementLocated(locator));
            element.sendKeys(keys);
        } catch (StaleElementReferenceException ignored) {
            element = (new WebDriverWait(driver, defaultExplicitWaitInSeconds)).
                    until(ExpectedConditions.presenceOfElementLocated(locator));
            element.sendKeys(keys);
        }

    }

    protected void waitTillBeAbleToClick(By locator) {
        logger.info("WAIT ELEMENT TO BE CLICKABLE: " + locator);

        WebElement element = null;

        try {
            element = (new WebDriverWait(driver, defaultExplicitWaitInSeconds)).
                    until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (StaleElementReferenceException ignored) {
            element = (new WebDriverWait(driver, defaultExplicitWaitInSeconds)).
                    until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        }

    }

    protected void waitToBePresentAndSendSubmit(By locator) {
        logger.info("WAIT ELEMENT TO BE PRESENT AND SUBMIT: " + locator);
        WebElement element = null;

        try {
            element = (new WebDriverWait(driver, defaultExplicitWaitInSeconds)).
                    until(ExpectedConditions.presenceOfElementLocated(locator));
            element.submit();
        } catch (StaleElementReferenceException ignored) {
            element = (new WebDriverWait(driver, defaultExplicitWaitInSeconds)).
                    until(ExpectedConditions.presenceOfElementLocated(locator));
            element.submit();
        }

    }
}

package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidSetupToDoist {

    protected AndroidDriver driver;
    private static final ThreadLocal<AndroidDriver> androidDriver = new ThreadLocal<AndroidDriver>();
    public static AndroidDriver getDriver () {return androidDriver.get();}

    protected void prepareAndroidForAppium() throws MalformedURLException {
        File appDir = new File("app");
        File app = new File(appDir, "com.todoist.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("appActivity", "com.todoist.activity.HomeActivity");
        capabilities.setCapability("appPackage", "com.todoist");
        capabilities.setCapability("app", app.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
package com.lumatest.base;

import com.lumatest.utils.DriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public abstract class BaseTest {
//    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    private WebDriver driver;
//    private final String browser = "chromium";  //    private final String browser = "firefox";

    @BeforeSuite
    protected void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.chromiumdriver().setup();
    }

   @Parameters("browser")
    @BeforeMethod
    protected void setupDriver(String browser) {
        Reporter.log("------------------------------------------------------------------------", true);
        this.driver = DriverUtils.createDriver(browser, this.driver);

        if (getDriver() == null) {
            Reporter.log("Error: Unknown parameter 'browser' - " + browser + ". ", true);

            System.exit(1);
        }

        Reporter.log("INFO: " + browser.toUpperCase() +  " driver created.", true);
    }

    @Parameters("browser")
    @AfterMethod(alwaysRun = true)
    protected void tearDown(String browser) {
        if (this.driver != null) {
            getDriver().quit();
            Reporter.log("INFO: " + browser.toUpperCase() +  " driver closed.", true);

            this.driver = null;
        } else {
            Reporter.log("INFO: Driver is null.", true);
        }
    }
    public WebDriver getDriver() {

        return this.driver;
    }
}


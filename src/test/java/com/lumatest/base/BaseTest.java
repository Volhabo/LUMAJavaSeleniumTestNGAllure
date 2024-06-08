package com.lumatest.base;

import com.lumatest.utils.DriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public abstract class BaseTest {
    private WebDriver driver;
    private final String browser = "chrome";
//    private final String browser = "firefox";

    @BeforeSuite
    protected void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    protected void setupDriver() {
        Reporter.log("------------------------------------------------------------------------", true);
        this.driver = DriverUtils.createDriver(this.browser, this.driver);

        if (getDriver() == null) {
            Reporter.log("Error: Unknown parameter 'browser' - " + this.browser + ". ", true);

            System.exit(1);
        }

        Reporter.log("INFO: " + this.browser.toUpperCase() +  " driver created.", true);
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
        if (this.driver != null) {
            getDriver().quit();
            Reporter.log("INFO: " + this.browser.toUpperCase() +  " driver closed.", true);

            this.driver = null;
        } else {
            Reporter.log("INFO: Driver is null.", true);
        }
    }
    public WebDriver getDriver() {

        return this.driver;
    }
}


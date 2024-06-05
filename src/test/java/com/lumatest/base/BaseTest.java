package com.lumatest.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
    private WebDriver driver;

    @BeforeMethod
    protected  void setup() {
        WebDriverManager.chromedriver().setup();

        createChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
        if (this.driver != null) {
            getDriver().quit();
            this.driver = null;
        }
    }

    private void createChromeDriver() {
        if (this.driver == null) {
            this.driver = new ChromeDriver();
        }
    }

    public WebDriver getDriver(){

        return this.driver;
    }
}

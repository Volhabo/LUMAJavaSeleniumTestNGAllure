package com.lumatest.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
    private WebDriver driver;
    protected  void setup() {
        WebDriverManager.chromedriver().setup();

        createChromeDriver();
    }

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

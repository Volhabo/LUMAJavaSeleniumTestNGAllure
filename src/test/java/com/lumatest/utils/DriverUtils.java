package com.lumatest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtils {
    public static WebDriver createChromeDriver(WebDriver driver) {
        if (driver == null) {
            return new ChromeDriver();
        } else {
            driver.quit();
            return new ChromeDriver();
        }
    }

//    private WebDriver createFireFoxDriver(WebDriver driver) {
//        if (driver == null) {
//            driver = new FirefoxDriver();
//        } else {
//            driver.quit();
//            driver = new FirefoxDriver();
//        }
//
//        return driver;
//    }
}

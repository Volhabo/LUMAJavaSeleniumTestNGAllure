package com.lumatest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import java.util.Map;

public class DriverUtils {
    private static ChromeOptions chromeOptions;

    static {
        chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-web-security");
        chromeOptions.addArguments("--allow-running-insecure-content");
        chromeOptions.addArguments("--ignore-certificate-errors");
    }

    private static WebDriver createChromeDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();

            return driver;
        }
        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.executeCdpCommand("Network.enable", Map.of());
        chromeDriver.executeCdpCommand("Network.setExtraHTTPHeaders", Map.of("headers", Map.of("accept-language", "en-US,en;q=0.9")));

        return chromeDriver;
    }

    public static WebDriver createDriver(String browser, WebDriver driver) {
        if(browser.equals("chrome")){
            driver = DriverUtils.createChromeDriver(driver);

            return driver;
        } else {

            return null;
        }
    }
}
//    public static WebDriver createChromeDriver(WebDriver driver) {
//        if (driver == null) {
//            return new ChromeDriver(chromeOptions);
//        } else {
//            driver.quit();
//            return new ChromeDriver(chromeOptions);
//        }
//    }

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


package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BagsPage extends SideMenu{

    private final String productNameXpath = "//img[@alt='";
    private WebElement drivenBagpackImg;

    protected BagsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click + "'" + {productName} + "'" + Img.")
    public ProductPage clickDrivenBagpackImg(String productName) {
        String imgXpath = productNameXpath + productName + "']";
        getDriver().findElement(By.xpath(imgXpath)).click();

        return new ProductPage(getDriver());
    }
}

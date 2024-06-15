package com.lumatest.data;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class TestData {
    public static final String BASE_URL = "https://magento.softwaretestingboard.com";
    public static final String BASE_URL_TITLE = "Home Page";

    public static final By WHATS_NEW_MENU = By.xpath("//nav//span[text()=\"What's New\"]");
    public static final String WHATS_NEW_URL = BASE_URL + "/what-is-new.html";
    public static final String WHATS_NEW_TITLE = "What's New";

    public static final By WOMEN_MENU = By.xpath("//nav//span[text()=\"Women\"]");
    public static final String WOMEN_URL = BASE_URL + "/women.html";
    public static final String WOMEN_TITLE = "Women";

    public static final By MEN_MENU = By.xpath("//nav//span[text()=\"Men\"]");
    public static final String MEN_URL = BASE_URL + "/men.html";
    public static final String MEN_TITLE = "Men";

    public static final By GEAR_MENU = By.xpath("//nav//span[text()=\"Gear\"]");
    public static final String GEAR_URL = BASE_URL + "/gear.html";
    public static final String GEAR_TITLE = "Gear";

    public static final By TRAINING_MENU = By.xpath("//nav//span[text()=\"Training\"]");
    public static final String TRAINING_URL = BASE_URL + "/training.html";
    public static final String TRAINING_TITLE = "Training";

    public static final By SALE_MENU = By.xpath("//nav//span[text()='Sale']");
    public static final String SALE_URL = BASE_URL + "/sale.html";
    public static final String SALE_TITLE = "Sale";

    @DataProvider(name = "navigationData")
    public static final Object[][] getNavMenuData() {
        return new Object[][]{
                {BASE_URL, WHATS_NEW_MENU, WHATS_NEW_URL, WHATS_NEW_TITLE},
                {BASE_URL, WOMEN_MENU, WOMEN_URL, WOMEN_TITLE},
                {BASE_URL, MEN_MENU, MEN_URL, MEN_TITLE},
                {BASE_URL, GEAR_MENU, GEAR_URL, GEAR_TITLE},
                {BASE_URL, TRAINING_MENU, TRAINING_URL, TRAINING_TITLE},
                {BASE_URL, SALE_MENU, SALE_URL, SALE_TITLE}
        };
    }

    //ProductPage
    public static final String DRIVEN_BACKPACK_PRODUCT_URL = BASE_URL + "/driven-backpack.html";
    public static final String DRIVEN_BAGPACK_PRODUCT_NAME= "Driven Backpack";
    public static final String DRIVEN_BAGPACK_PRODUCT_PAGE_BREADCRUMPS_MENU_TEXT = "Home Gear Bags Driven Backpack";
}


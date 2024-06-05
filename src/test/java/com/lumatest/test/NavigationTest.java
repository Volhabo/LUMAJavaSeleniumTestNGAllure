package com.lumatest.test;

import com.lumatest.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void testOpenBaseURL() {

        final String expectedURL = "https://magento.softwaretestingboard.com/";
        final String expectedTitle = "Home Page";

        getDriver().get("https://magento.softwaretestingboard.com");
        final String actualURL = getDriver().getCurrentUrl();
        final String actualTitle = getDriver().getTitle();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}

package com.lumatest.test;

import com.lumatest.base.BaseTest;
import com.lumatest.data.TestData;
import com.lumatest.model.HomePage;
import com.lumatest.model.ProductPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {

    @Test(
            testName = "PRODUCT | Product Details",
            description = "TC-03 Verify Product Details on Product Page",
            groups = {"regression"}
    )
    @Story("Product Details")
    @Severity(SeverityLevel.NORMAL)
    @Description("To verify that the product page displays the correct product name and breadcrumb menu text " +
            "for the 'Driven Backpack'.")
    @Link(TestData.DRIVEN_BACKPACK_PRODUCT_URL)
    public void testProduct() {
        Allure.step("Open Base URL.");
        getDriver().get(TestData.BASE_URL);

        ProductPage productPage = new HomePage(getDriver())
                .clickGearTopMenu()
                .clickBagsSideMenu()
                .clickDrivenBagpackImg(TestData.DRIVEN_BAGPACK_PRODUCT_NAME);

        final String productName = productPage.getProductNameText();
        final String breadCrumbsMenuText = productPage.getBreadCrumbsMenuText();
        System.out.println(breadCrumbsMenuText);

        Allure.step("Verify actual " + "'" + productName + "'" + " equals " + "'" + TestData.DRIVEN_BAGPACK_PRODUCT_NAME + "'");
        Assert.assertEquals(productName, TestData.DRIVEN_BAGPACK_PRODUCT_NAME);

        Allure.step("Verify actual " + "'" + breadCrumbsMenuText + "'" + " equals " + "'" + TestData.DRIVEN_BAGPACK_PRODUCT_PAGE_BREADCRUMPS_MENU_TEXT + "'");
        Assert.assertEquals(breadCrumbsMenuText, TestData.DRIVEN_BAGPACK_PRODUCT_PAGE_BREADCRUMPS_MENU_TEXT);
    }
}

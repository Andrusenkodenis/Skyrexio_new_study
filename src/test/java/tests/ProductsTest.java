package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {
    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isTitleIsDisplayed();
        productsPage.addGoodsToCar("Sauce Labs Onesie");
        productsPage.addGoodsToCar("Sauce Labs Fleece Jacket");
        assertEquals(productsPage.checkCounterValue(), "2");
        assertEquals(productsPage.checkCounterColor(), "rgba(226, 35, 26, 1)");
    }
}

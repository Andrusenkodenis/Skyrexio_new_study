package tests;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class ProductsTest extends BaseTest {
    List<String> goodsList =
            List.of("Test.allTheThings() T-Shirt (Red)", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie");

    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        assertTrue(productsPage.isTitleIsDisplayed());
        assertEquals(productsPage.checkTitleName(), "Products");

        for (int i = 0; i < goodsList.size(); i++) {
            productsPage.addGoodsToCar(goodsList.get(i));
        }

        productsPage.addGoodsToCar(2);
        assertEquals(productsPage.checkCounterValue(), "4");
        assertEquals(productsPage.checkCounterColor(), "rgba(226, 35, 26, 1)");
    }
}

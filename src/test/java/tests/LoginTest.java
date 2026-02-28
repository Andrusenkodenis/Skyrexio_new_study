package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void correctLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertTrue(productsPage.isTitleIsDisplayed(), "Заголовок не виден");
        assertEquals(productsPage.getTitle(), "Products", "Не верный заголовок");
    }

    @Test
    public void incorrectLogin() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");

        assertTrue(loginPage.isErrorDisplayed(), "Нет сообщения об ошибке");
        assertEquals(loginPage.getErrorText(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Не верный текст сообщения об ошибке");
    }

    @Test
    public void invalidUsername() {
        loginPage.open();
        loginPage.login("Standard_user", "secret_sauce");

        assertTrue(loginPage.isErrorDisplayed(), "Нет сообщения об ошибке");
        assertEquals(loginPage.getErrorText(),
                "Epic sadface: Username and password do not match any user in this service",
                "Не верный текст сообщения об ошибке");
    }

    @Test
    public void emptyUser() {
        loginPage.open();
        loginPage.login("", "secret_sauce");

        assertTrue(loginPage.isErrorDisplayed(), "Нет сообщения об ошибке");
        assertEquals(loginPage.getErrorText(),
                "Epic sadface: Username is required",
                "Не верный текст сообщения об ошибке");
    }

    @Test
    public void emptyPassword() {
        loginPage.open();
        loginPage.login("Standard_user", "");

        assertTrue(loginPage.isErrorDisplayed(), "Нет сообщения об ошибке");
        assertEquals(loginPage.getErrorText(),
                "Epic sadface: Password is required",
                "Не верный текст сообщения об ошибке");
    }

    @Test
    public void emptyFields() {
        loginPage.open();
        loginPage.login("", "");

        assertTrue(loginPage.isErrorDisplayed(), "Нет сообщения об ошибке");
        assertEquals(loginPage.getErrorText(),
                "Epic sadface: Username is required",
                "Не верный текст сообщения об ошибке");
    }
}

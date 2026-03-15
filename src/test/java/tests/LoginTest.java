package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static user.UserFactory.withAdminPermission;

public class LoginTest extends BaseTest {
    @Test(description = "Валидная авторизация пользователя", invocationCount = 1)
    public void correctLogin() {
        loginPage.open();
        loginPage.login(withAdminPermission());

        assertTrue(productsPage.isTitleIsDisplayed(), "Заголовок не виден");
        assertEquals(productsPage.checkTitleName(), "Products", "Не верный заголовок");
    }

    @DataProvider(name = "incorrectLoginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"Standard_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"Standard_user", "", "Epic sadface: Password is required"},
                {"", "", "Epic sadface: Username is required"},
        };
    }

    @Test(dataProvider = "incorrectLoginData", description = "Тест проверяет, что авторизация корректно обрабатывает ошибки", invocationCount = 1)
    public void incorrectLogin(String user, String password, String errorMsg) {
        loginPage.open();
        loginPage.login(user, password);

        assertTrue(loginPage.isErrorDisplayed(), "Нет сообщения об ошибке");
        assertEquals(loginPage.getErrorText(), errorMsg, "Не верный текст сообщения об ошибке");
    }
}

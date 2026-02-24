import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void correctLogin() {

        browser.findElement(By.id("user-name")).sendKeys("standard_user");
        browser.findElement(By.xpath("//*[@data-test='password']")).sendKeys("secret_sauce");
        browser.findElement(By.cssSelector("[name='login-button']")).click();

        boolean titleIsDisplayed = browser.findElement(By.cssSelector("[data-test='title']")).isDisplayed();
        assertTrue(titleIsDisplayed);

        String titleName = browser.findElement(By.cssSelector("[data-test='title']")).getText();
        assertEquals(titleName, "Products", "Не верный заголовок");
    }

    @Test
    public void incorrectLogin() {

        browser.findElement(By.id("user-name")).sendKeys("locked_out_user");
        browser.findElement(By.xpath("//*[@data-test='password']")).sendKeys("secret_sauce");
        browser.findElement(By.cssSelector("[name='login-button']")).click();

        boolean errorIsDisplayed = browser.findElement(By.cssSelector("[data-test='error']")).isDisplayed();
        assertTrue(errorIsDisplayed, "Нет сообщения об ошибке");

        assertEquals(browser.findElement(By.cssSelector("[data-test='error']")).getText(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Не верный текст сообщения об ошибке");
    }
}

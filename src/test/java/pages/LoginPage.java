package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By loginInput = By.id("user-name");
    private final By loginButton = By.cssSelector("[name='login-button']");
    private final By passwordInput = By.cssSelector(DATA_TEST_PATTERN.formatted("password"));
    private final By errorMsg = By.cssSelector(DATA_TEST_PATTERN.formatted("error"));

    public LoginPage(WebDriver browser) {
        super(browser);
    }

    public void open() {
        browser.get(BASE_URL);
    }

    public void login(String user, String password) {
        browser.findElement(loginInput).sendKeys(user);
        browser.findElement(passwordInput).sendKeys(password);
        browser.findElement(loginButton).click();
    }

    public boolean isErrorDisplayed() {
        return browser.findElement(errorMsg).isDisplayed();
    }

    public String getErrorText() {
        return browser.findElement(errorMsg).getText();
    }
}

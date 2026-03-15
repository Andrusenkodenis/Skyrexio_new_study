package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

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
        fillLoginField(user);
        fillPasswordField(password);
        browser.findElement(loginButton).click();
    }
    public void login(User user) {
        fillLoginField(user.getEmail());
        fillPasswordField(user.getPassword());
        browser.findElement(loginButton).click();
    }

    public void fillLoginField(String user) {
        browser.findElement(loginInput).sendKeys(user);
    }

    public void fillPasswordField(String password) {
        browser.findElement(passwordInput).sendKeys(password);
    }

    public boolean isErrorDisplayed() {
        return browser.findElement(errorMsg).isDisplayed();
    }

    public String getErrorText() {
        return browser.findElement(errorMsg).getText();
    }
}

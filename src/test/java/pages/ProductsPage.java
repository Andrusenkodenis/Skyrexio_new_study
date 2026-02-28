package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private final By title = By.cssSelector("[data-test='title']");

    public ProductsPage(WebDriver browser) {

        super(browser);
    }

    public boolean isTitleIsDisplayed() {
        return browser.findElement(title).isDisplayed();
    }

    public String getTitle() {
        return browser.findElement(title).getText();
    }

}
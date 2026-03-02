package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private static final String ADD_TO_CART_PATTERN =
            "//*[text()='%s']//ancestor::div[@class='inventory_item']" +
                    "//child::button[text()='Add to cart']";
    private final By title = By.cssSelector("[data-test='title']");
    private final By cartCounter = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));

    public ProductsPage(WebDriver browser) {
        super(browser);
    }

    public boolean isTitleIsDisplayed() {
        return browser.findElement(title).isDisplayed();
    }

    public String getTitle() {
        return browser.findElement(title).getText();
    }

    public void addGoodsToCar(String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART_PATTERN.formatted(goodsName));
        browser.findElement(addToCart).click();
    }

    public String checkCounterValue() {
        return browser.findElement(cartCounter).getText();
    }

    public String checkCounterColor() {
        return browser.findElement(cartCounter).getCssValue("background-color");
    }
}
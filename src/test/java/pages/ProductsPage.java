package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private static final String ADD_TO_CART_PATTERN =
            "//*[text()='%s']//ancestor::div[@class='inventory_item']" +
                    "//child::button[text()='Add to cart']";
    private final By title = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By cartCounter = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));
    private final By cartLink = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-link"));

    public ProductsPage(WebDriver browser) {
        super(browser);
    }

    public boolean isTitleIsDisplayed() {
        return browser.findElement(title).isDisplayed();
    }

    public void addGoodsToCar(String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART_PATTERN.formatted(goodsName));
        browser.findElement(addToCart).click();
    }

    public void addGoodsToCar(int goodsIndex) {
        browser.findElements(By.xpath("//*[text()='Add to cart']")).get(goodsIndex).click();
    }

    public String checkCounterValue() {
        return browser.findElement(cartCounter).getText();
    }

    public String checkCounterColor() {
        return browser.findElement(cartCounter).getCssValue("background-color");
    }

    public void switchToCart() {
        browser.findElement(cartLink).click();
    }
}
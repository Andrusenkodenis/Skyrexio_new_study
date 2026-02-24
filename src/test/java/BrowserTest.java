import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserTest {
    @Test
    public void firstLogin() {

        WebDriver browser = new ChromeDriver();
        browser.get("https://www.saucedemo.com/");
        browser.quit();
    }
}

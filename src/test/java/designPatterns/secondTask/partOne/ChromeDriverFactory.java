package designPatterns.secondTask.partOne;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverFactory implements WebDriverFactory {

    @Override
    public WebDriver createWebDriver() {
        // Initialize Chrome driver with custom settings if needed
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        return new ChromeDriver();
    }
}
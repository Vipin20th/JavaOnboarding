package designPatterns.secondTask.partOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverFactory implements WebDriverFactory {

    @Override
    public WebDriver createWebDriver() {
        // Initialize Firefox driver with custom settings if needed
        System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
        return new FirefoxDriver();
    }
}
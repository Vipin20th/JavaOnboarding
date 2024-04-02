package designPatterns.secondTask.partOne;

import org.openqa.selenium.WebDriver;

public class BrowserInitializer {

    public static void main(String[] args) {
        WebDriverFactory factory = new ChromeDriverFactory(); // or FirefoxDriverFactory, InternetExplorerDriverFactory
        WebDriver driver = factory.createWebDriver();
    }
}
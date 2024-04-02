package designPatterns.secondTask.partTwo;

import org.openqa.selenium.WebDriver;

public class BrowserInitializer {

    public static void main(String[] args) {
        WebDriverFactory factory = new ChromeDriverFactory();
        WebDriver driver = factory.createWebDriver();

        // Use the WebDriver instance for further operations
    }
}

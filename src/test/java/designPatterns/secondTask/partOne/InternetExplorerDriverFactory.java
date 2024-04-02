package designPatterns.secondTask.partOne;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorerDriverFactory implements WebDriverFactory {

    @Override
    public WebDriver createWebDriver() {
        // Initialize Internet Explorer driver with custom settings if needed
        System.setProperty("webdriver.ie.driver", "path/to/IEDriverServer");
        return new InternetExplorerDriver();
    }
}
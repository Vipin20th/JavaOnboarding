package designPatterns.secondTask.partTwo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverFactory extends BaseWebDriverFactory {

    @Override
    public WebDriver createWebDriver() {
        return new MyChromeDriver(); // or MyChromeDriverWithCapabilities
    }
}

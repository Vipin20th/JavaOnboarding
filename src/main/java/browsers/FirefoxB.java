package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxB {

    public FirefoxOptions getFirefoxOptions(){
        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--test-type");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("disable-infobars");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-application-cache");
        options.addArguments("--start-maximized");
        options.setAcceptInsecureCerts(true);
        return options;
    }


    public WebDriver getFirefoxDriver() throws Exception {
        try {
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver(getFirefoxOptions());
            return driver;
        } catch (Exception e) {
            throw new Exception("firefox not initialize");
        }
    }
}

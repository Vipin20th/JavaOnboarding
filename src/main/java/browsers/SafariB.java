package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;


public class SafariB {

    public SafariOptions getSafariOptions() {

        SafariOptions option = new SafariOptions();
        option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        option.setCapability("safari.cleanSession", true);
        option.setUseTechnologyPreview(true);
        return option;
    }

    public WebDriver getSafariDriver() throws Exception {
        WebDriver driver;
        try{
            if (!System.getProperty("os.name").contains("Mac OS")) {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver(getSafariOptions());
            }
            driver = new SafariDriver();
            return driver;
        }catch(Exception e){
            throw new Exception("chrome not initialize");
        }
    }
}

package browsers;


import utilities.BaseObjects;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BrowserInit {

    private BaseObjects baseObjects = new BaseObjects();
    final int time = 40;

    WebDriver driver = null;

    public WebDriver browser() throws Exception {

        String browserName = baseObjects.baseUtil().getTestNGParameter("Browser");
        if(browserName == null || browserName.trim().isEmpty()){
            browserName ="chrome";
        }
        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                ChromeB obj = new ChromeB();
                driver = obj.getChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));
                DriverProvider.getInstance().setDriver(driver);
                return driver;
            } else if (browserName.equalsIgnoreCase("firefox")) {
                FirefoxB obj = new FirefoxB();
                driver = obj.getFirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));
                DriverProvider.getInstance().setDriver(driver);
                return driver;
            } else if (browserName.equalsIgnoreCase("safari")) {
                SafariB obj = new SafariB();
                driver = obj.getSafariDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));
                DriverProvider.getInstance().setDriver(driver);
                return driver;
            }
        }catch(Exception e) {
            throw new Exception("driver not initialize");
        }
     return driver;
    }


}

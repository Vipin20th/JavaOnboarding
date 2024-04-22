package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.BaseObjects;


import java.util.HashMap;
import java.util.Map;

public class ChromeB {

    private BaseObjects baseObjects = new BaseObjects();

    public ChromeOptions getchromeOptions() {
        String downloadFilePath = "";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilePath);

        ChromeOptions option = new ChromeOptions();
        String device =  baseObjects.baseUtil().getTestNGParameter("device");
        if(device!= null && !device.trim().isEmpty()) {
            Map<String, String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", device);
            option.setExperimentalOption("mobileEmulation", mobileEmulation);
        }
        //option.addArguments("--incognito");
        option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        option.addArguments("--test-type");
        option.addArguments("--disable-popup-blocking");
        option.addArguments("disable-infobars");
        option.addArguments("--dns-prefetch-disable");
        option.addArguments("--disable-application-cache");
        option.addArguments("--start-maximized");

        if (System.getProperty("os.name").contains("Linux")) {
            option.addArguments("--headless", "window-size-1024,768", "--no-sandbox");
        }

        return option;

    }

    public WebDriver getChromeDriver() throws Exception {
        try{
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver(getchromeOptions());
            return driver;
        }catch(Exception e){
            throw new Exception("chrome not initialize");
        }
    }
}

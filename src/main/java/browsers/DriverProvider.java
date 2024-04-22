package browsers;

import org.openqa.selenium.WebDriver;

public class DriverProvider {

    //Singleton design Pattern
    //private constructor so that no one else can create object of this class
    private DriverProvider() {

    }

    private static DriverProvider instance  = new DriverProvider();

    public static DriverProvider getInstance() {
        return instance;
    }


    //factory design pattern --> define separate factory methods for creating objects and create objects by calling that methods
    ThreadLocal<WebDriver> Tdriver = new ThreadLocal<WebDriver>();

    public WebDriver getDriver() {
        return Tdriver.get();
    }

    public void setDriver(WebDriver driverParm) {
        Tdriver.set(driverParm);
    }


    public void closeBrowser() {
        Tdriver.get().quit();
        Tdriver.remove();
    }

}

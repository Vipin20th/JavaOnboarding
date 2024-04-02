package designPatterns.secondTask.partTwo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyChromeDriverWithCapabilities extends ChromeDriver {
    // Custom capabilities for Chrome driver
    public MyChromeDriverWithCapabilities() {
        ChromeOptions options = new ChromeOptions();
        // Set additional capabilities as needed
        this.setChromeOptions(options);
    }
}


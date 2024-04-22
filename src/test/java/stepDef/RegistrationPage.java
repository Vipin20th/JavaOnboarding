package stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterRegistrationDetails(String email, String password) {
        // Enter registration details
    }

    public void clickRegisterButton() {
        // Click on the Register button
    }

    public boolean isRegistrationSuccessful() {
        // Check if registration is successful
        return driver.findElement(By.id("confirmation-message")).isDisplayed();
    }
}


package stepDef;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.junit.Assert;

public class RegistrationSteps {
    WebDriver driver = new ChromeDriver();

    @Given("User is on the registration page")
    public void user_is_on_the_registration_page() {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
    }

    @When("User enters valid registration details")
    public void user_enters_valid_registration_details() {
        // Enter valid registration details
    }

    @When("User clicks on the Register button")
    public void user_clicks_on_the_register_button() {
        // Click on the Register button
    }

    @Then("User should be registered successfully")
    public void user_should_be_registered_successfully() {
        // Verify registration success
    }
}

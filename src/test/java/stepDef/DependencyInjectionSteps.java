package stepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import io.cucumber.java.en.*;

public class DependencyInjectionSteps {
    private WebDriver driver;
    private RegistrationPage registrationPage;

    public DependencyInjectionSteps(RegistrationPage registrationPage) {
        this.registrationPage = registrationPage;
    }

    @Given("User is on the registration page")
    public void user_is_on_the_registration_page() {
        driver = new ChromeDriver();
        registrationPage = new RegistrationPage(driver);
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
    }

    // Other step definitions
}


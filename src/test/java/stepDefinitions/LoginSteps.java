
package stepDefinitions;

import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;
import utils.DriverFactory;

import java.time.Duration;

public class LoginSteps {
    private static final Logger logger = LogManager.getLogger(LoginSteps.class);
    LoginPage loginPage;

    @Given("the user is on the login page")
    public void i_am_on_the_login_page() {
        logger.info("Navigating to login page");
        loginPage = new LoginPage(DriverFactory.getDriver());
    }

    @When("the user enters username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.enterUsername(username.equals("empty") ? "" : username);
        loginPage.enterPassword(password.equals("empty") ? "" : password);
    }

    @And("the user clicks on login button")
    public void i_click_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("the user should see {string}")
    public void i_should_see(String expectedResult) {
        if (expectedResult.equalsIgnoreCase("dashboard")) {
            Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("inventory.html"));
        } else {
            Assert.assertTrue(loginPage.getErrorMessage().contains(expectedResult));
        }
    }
    @Then("the user should see {string} even if it takes longer")
    public void i_should_see_even_if_it_takes_longer(String expectedResult) {
        WebDriver driver = DriverFactory.getDriver();
        long startTime = System.currentTimeMillis();
        try {
            new WebDriverWait(driver, Duration.ofSeconds(15))
                    .until(d -> d.getCurrentUrl().contains("inventory.html"));
        } catch (Exception e) {
            Assert.fail("Dashboard did not load within expected time.");
        }

        long endTime = System.currentTimeMillis();
        long loadTime = endTime - startTime;

        // Validate that load time is at least 2 seconds (simulate performance expectation)
        Assert.assertTrue(loadTime <= 15 ,
                "Expected load time to be <= 15 seconds for performance_glitch_user, but was " + loadTime + " ms");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                "Dashboard URL not loaded correctly.");

    }
}

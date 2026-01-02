
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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginSteps {
    private static final Logger logger = LogManager.getLogger(LoginSteps.class);
    LoginPage loginPage;

    @Given("the user is on the login page")
    public void i_am_on_the_login_page() {
        logger.info("Navigating to login page");
        loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.navigateTo("https://www.saucedemo.com/");
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
            assertThat(loginPage.getCurrentUrl("inventory"), containsString("inventory.html"));
        }
       else {
            assertThat(loginPage.getErrorMessage(), containsString(expectedResult));
        }
    }
    @Then("the user should see {string} in less than {long} seconds")
    public void i_should_see_even_if_it_takes_longer(String expectedResult,long maxWaitSeconds) {
        long loadTime = loginPage.waitForDashboardAndValidateLoadTime();
        assertThat(loadTime,lessThanOrEqualTo(maxWaitSeconds));
        assertThat(loginPage.getCurrentUrl("inventory"), containsString("inventory.html"));
    }

    @Then("the user should see {string} button")
    public void the_user_should_see_button(String buttonName) {
        assertThat(loginPage.isButtonDisplayed(buttonName),equalTo(true));
     }

}

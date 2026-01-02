
package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.MenuPage;
import utils.DriverFactory;

public class MenuSteps {

    MenuPage menuPage = new MenuPage(DriverFactory.getDriver());

    @When("the user clicks on burger menu")
    public void the_user_clicks_on_burger_menu() {
        menuPage.openBurgerMenu();
    }

    @And("the user clicks on {string} option")
    public void the_user_clicks_on_option(String option) {
        menuPage.clickBurgerMenuOption(option);
    }
}

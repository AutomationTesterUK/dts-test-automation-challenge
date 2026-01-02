
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage {

    // Locator for burger menu button
    private By burgerMenuButton = By.id("react-burger-menu-btn");

    // Constructor
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    // Method to open the burger menu
    public void openBurgerMenu() {
        waitForElementClickable(burgerMenuButton).click();
    }

    // Method to click on a dynamic menu option (e.g., logout, about)
    public void clickBurgerMenuOption(String option) {
        String xpath = String.format("//a[@data-test='%s-sidebar-link']", option);
        waitForElementClickable(By.xpath(xpath)).click();
    }
}

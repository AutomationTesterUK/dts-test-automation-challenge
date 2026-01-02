
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    private By burgerMenu = By.xpath("//button[@id='react-burger-menu-btn']");

    private By burgerMenuOption = By.xpath("//a[@data-test='logout-sidebar-link']");


    // Constructor calls BasePage constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void enterUsername(String username) {
        waitForElementVisible(usernameField).clear();
        waitForElementVisible(usernameField).sendKeys(username);

    }

    public void enterPassword(String password) {
        waitForElementVisible(passwordField).clear();
        waitForElementVisible(passwordField).sendKeys(password);
    }


    public void clickLogin() {
        waitForElementClickable(loginButton).click();
    }

    public String getErrorMessage() {
        return waitForElementVisible(errorMessage).getText();
    }

    public void clickBurgerMenu() {
        waitForElementClickable(burgerMenu).click();
    }

    public void clickBurgerMenuOption(String option) {
        String xpath = String.format("//a[@data-test='%s-sidebar-link']", option);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement menuOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        menuOption.click();
    }
    public boolean isButtonDisplayed(String buttonName) {
        String xpath = String.format("//input[@value='%s' or @id='%s-button']", buttonName, buttonName.toLowerCase());
        // Use BasePage wait helper for stability
        return waitForElementVisible(By.xpath(xpath)).isDisplayed();
    }


    public long waitForDashboardAndValidateLoadTime() {
        long startTime = System.currentTimeMillis();
        wait.until(driver -> driver.getCurrentUrl().contains("inventory.html")); // Using BasePage's wait

        long endTime = System.currentTimeMillis();
        long loadTime = endTime - startTime;
       return loadTime;
      }


}


package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor to initialize WebDriver and WebDriverWait
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Default wait time
    }

    // Common method to get current URL

    public String getCurrentUrl(String s) {
        wait.until(ExpectedConditions.urlContains(s));
        return driver.getCurrentUrl();
    }


    // Common method to get page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Common method to navigate to a URL
    public void navigateTo(String url) {
        driver.get(url);
    }

    // Common method to refresh the page
    public void refreshPage() {
        driver.navigate().refresh();
    }

    // ✅ Explicit Wait Helpers
    public WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

   public boolean waitForTextToBePresent(By locator, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }


}

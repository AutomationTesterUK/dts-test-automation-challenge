
package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.ScreenshotUtil;

public class Hooks {
    private static final Logger logger = LogManager.getLogger(Hooks.class);
    @Before
    public void setUp() {
        logger.info("Initializing WebDriver");
        String browser = System.getProperty("browser", "chrome");
        WebDriver driver = DriverFactory.initDriver(browser);
        driver.get("https://www.saucedemo.com/");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            logger.error("Scenario failed: " + scenario.getName());
            ScreenshotUtil.takeScreenshot(DriverFactory.getDriver());
        }
        else {
            logger.info("Scenario passed: " + scenario.getName());
        }
        DriverFactory.quitDriver();
        logger.info("Closed WebDriver");
    }
}

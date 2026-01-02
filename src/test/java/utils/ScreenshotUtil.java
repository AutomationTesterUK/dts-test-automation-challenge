
package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtil {

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot(WebDriver driver) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        // Save screenshot to local folder
        try {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotDir = "screenshots";
            Files.createDirectories(Paths.get(screenshotDir)); // Create folder if not exists
            String filePath = screenshotDir + "/failed_" + System.currentTimeMillis() + ".png";
            Files.copy(file.toPath(), Paths.get(filePath));
            System.out.println("Screenshot saved at: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshot; // Return for Allure attachment
    }
}

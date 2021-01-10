import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotMaker {

    private WebDriver driver;

    public ScreenShotMaker(WebDriver driver) {
        this.driver = driver;
    }

    public void makeScreenshot(String fileName) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotFile, new File("screenshots" + File.separator + fileName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save screenshot at location " + fileName);
        }
    }


}
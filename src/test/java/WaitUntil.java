import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUntil {

    private WebDriverWait webDriverWait;

    public WaitUntil(WebDriver driver) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public WebElement waitUntilPresenceOfElementLocated(By by) {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitUntilElementIsInvisible(WebElement checkboxBeforeClick) {
        webDriverWait.until(ExpectedConditions.invisibilityOf(checkboxBeforeClick));
    }
}
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class FluentWaitTests2 {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_loading/2");
    }

    @Test
    public void fluentWaitWithExceptionTest() {
        WebElement startButton = driver.findElement(By.cssSelector("#start > button"));
        startButton.click();

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        WebElement helloWorldMessage = fluentWait
                .pollingEvery(Duration.ofMillis(250))
                .withTimeout(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish h4")));

        assertTrue(helloWorldMessage.isDisplayed());
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
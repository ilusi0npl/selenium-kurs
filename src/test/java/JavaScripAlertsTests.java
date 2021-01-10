import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class JavaScripAlertsTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.navigate().to("http://theinernet.przyklady.javastart.pl/javascript_alerts");
    }

    @Test
    public void javaScriptAlertTest() {
        WebElement jsAlertButton = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        jsAlertButton.click();

        driver.switchTo().alert().dismiss();
        WebElement result = driver.findElement(By.id("result"));

        assertEquals(result.getText(), "You successfuly clicked an alert");
    }

    @Test
    public void javaScriptAlertConfirmTest() {
        WebElement jsConfirmButton = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
        jsConfirmButton.click();

        driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.id("result"));

        assertEquals(result.getText(), "You clicked: Ok");

        jsConfirmButton.click();

        driver.switchTo().alert().dismiss();

        assertEquals(result.getText(), "You clicked: Cancel");
    }

    @Test
    public void javaScriptAlertPromptTest() {
        WebElement jsConfirmButton = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        jsConfirmButton.click();

        String typedText = "Selenium is cool";

        Alert alert = driver.switchTo().alert();
        alert.sendKeys(typedText);
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));

        assertEquals(result.getText(), "You entered: " + typedText);
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
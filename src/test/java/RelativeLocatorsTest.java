import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RelativeLocatorsTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/login");
    }

    @Test
    public void relativeLocatorTest() {
        WebElement pageTitle = driver.findElement(By.tagName("h2"));
        WebElement usernameTextField = driver.findElement(RelativeLocator.with(By.tagName("input")).below(pageTitle));
        WebElement passwordTextField = driver.findElement(RelativeLocator.with(By.tagName("input")).below(usernameTextField));
        WebElement loginButton = driver.findElement(RelativeLocator.with(By.tagName("button")).below(passwordTextField));

        usernameTextField.sendKeys("tomsmith");
        passwordTextField.sendKeys("SuperSecretPassword!");
        loginButton.click();

        WebElement informationAlert = driver.findElement(By.id("flash-messages"));

        assertEquals(informationAlert.getText(), "You logged into a secure area!\n×");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}

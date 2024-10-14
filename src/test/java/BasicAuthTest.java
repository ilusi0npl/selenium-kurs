import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class BasicAuthTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void basicAuthOldTest() {
        driver.get("http://admin:admin@theinternet.przyklady.javastart.pl/basic_auth");
        String text = driver.findElement(By.cssSelector(".example p")).getText();
        assertEquals(text, "Congratulations! You must have the proper credentials.");
    }

    @Test
    public void basicAuthNewTest() {
        ((HasAuthentication) driver).register(UsernameAndPassword.of("admin", "admin"));
        driver.get("http://theinternet.przyklady.javastart.pl/basic_auth");

        String text = driver.findElement(By.cssSelector(".example p")).getText();
        assertEquals(text, "Congratulations! You must have the proper credentials.");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
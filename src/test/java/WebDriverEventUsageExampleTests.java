import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class WebDriverEventUsageExampleTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();

        //Utworzenie obiektu typu DriverEventListener
        DriverEventListener driverEventListener = new DriverEventListener();

        // Utworzenie obiektu EventFiringDecorator, który to w konstruktorze przymuje stworzoną przez nas klasę DriverEventListener
        EventFiringDecorator eventFiringDecorator = new EventFiringDecorator(driverEventListener);

        // W ramach metody decorate "dekorujemy" stworzony poprzednio przez WebDrivera
        driver = eventFiringDecorator.decorate(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/");
    }

    @Test
    public void webDriverEventListenerUsageTest() {
        driver.findElement(By.cssSelector("#Content a")).click();
        driver.findElement(By.cssSelector("#MenuContent a[href*='signonForm']")).click();

        driver.findElement(By.name("username")).sendKeys("NotExistingLogin");
        driver.findElement(By.name("password")).sendKeys("NotProperPassword");

        driver.findElement(By.name("signon")).click();

        assertEquals(driver.findElement(By.cssSelector("#Content ul[class='messages'] li")).getText(), "Invalid username or password. Signon failed.");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
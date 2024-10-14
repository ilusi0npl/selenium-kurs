import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ScreenShotMakeTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://duckduckgo.com/");
    }

    @Test
    public void screenshotMakeTest() {
        ScreenShotMaker screenShotMaker = new ScreenShotMaker(driver);
        screenShotMaker.makeScreenshot("GoogleBeforeTypingQueryPage.png");

        WebElement searchField = driver.findElement(By.id("search_form_input_homepage"));
        searchField.sendKeys("Kurs Selenium");

        screenShotMaker.makeScreenshot("GoogleAfterTypingQueryPage.png");

        searchField.submit();

        screenShotMaker.makeScreenshot("GoogleSearchResultsPage.png");
        assertTrue(driver.getTitle().contains("Kurs Selenium"));
    }


    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
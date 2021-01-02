import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class CheckBoxesTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/checkboxes");
    }

    @Test
    public void checkboxesTest() {
        WebElement firstCheckbox = driver.findElement(By.xpath("//*[@id=\'checkboxes\']/input[1]"));
        WebElement secondCheckbox = driver.findElement(By.xpath("//*[@id=\'checkboxes\']/input[2]"));

        assertFalse(firstCheckbox.isSelected());
        assertTrue(secondCheckbox.isSelected());

        firstCheckbox.click();
        secondCheckbox.click();

        assertTrue(firstCheckbox.isSelected());
        assertFalse(secondCheckbox.isSelected());
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
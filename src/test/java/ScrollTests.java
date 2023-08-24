import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ScrollTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://theinternet.przyklady.javastart.pl/large");
    }

    @Test
    public void scrollUsingJavaScriptTest() {

        //Ostatni WebElement w tabelce
        WebElement lastElementInTheTable = driver.findElement(By.xpath("//*[@id='large-table']/tbody/tr[50]/td[50]"));

        //Wykonanie skoku przy pomocy JavaScriptExecutora
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastElementInTheTable);

        //Wykonanie asercji
        sleep();
        assertEquals(lastElementInTheTable.getText(), "50.50");
    }

    @Test
    public void scrollUsingMoveToElementTest() {

        //Ostatni WebElement w tabelce
        WebElement lastElementInTheTable = driver.findElement(By.xpath("//*[@id='large-table']/tbody/tr[50]/td[50]"));

        //Wykonanie skoku przy pomocy klasy Actions oraz metody moveToElement
        Actions actions = new Actions(driver);
        actions.moveToElement(lastElementInTheTable).perform();

        //Wykonanie asercji
        sleep();
        assertEquals(lastElementInTheTable.getText(), "50.50");
    }

    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

}
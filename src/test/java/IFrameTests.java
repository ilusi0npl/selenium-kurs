import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IFrameTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
    }

    @Test
    public void iFrameTest() {
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/nested_frames");

        //Przejście do ramki nadrzędnej
        driver.switchTo().frame("frame-top");

        //Przejście do ramki podrzędnej - właściwej z tekstem
        driver.switchTo().frame("frame-left");

        By bodyLocator = By.xpath("//body");
        String leftFrameText = driver.findElement(bodyLocator).getText();
        assertEquals(leftFrameText, "LEFT");

        //Powrót to głównej ramki
        driver.switchTo().defaultContent();

        //Przejście do ramki o nazwie bottom
        driver.switchTo().frame("frame-bottom");

        String bottomFrameText = driver.findElement(bodyLocator).getText();
        assertEquals(bottomFrameText, "BOTTOM");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
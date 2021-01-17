import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class FileDetector {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() throws MalformedURLException {

        ChromeOptions chromeOptions = new ChromeOptions();

        //Tworzymy instancję WebDrivera - dla Selenium GRID
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);

        //Bierzemy obiekt WebDrivera i rzutujemy go na obiekt RemoteWebDriver
        RemoteWebDriver remoteWebDriver = (RemoteWebDriver) this.driver;

        //Obiekt RemoteWebDriver posiada metodę setFileDetector(), która pozwala ustawić instancję klasy LocalFileDetector
        remoteWebDriver.setFileDetector(new LocalFileDetector());

        driver.navigate().to("http://theinternet.przyklady.javastart.pl/upload");
    }

    @Test
    public void fileUploadTest() {
        WebElement fileUpload = driver.findElement(By.id("file-upload"));

        //Wykonujemy załadowanie pliku. Plik znajduje się w zasobach projektu
        fileUpload.sendKeys("src/test/resources/testfile.txt");

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
        assertEquals(uploadedFiles.getText(), "testfile.txt");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
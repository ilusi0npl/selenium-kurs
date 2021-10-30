import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;


public class JavaScriptErrorTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.navigate().to("http://theinternet.przyklady.javastart.pl/javascript_error");
    }

    @Test
    public void javaScriptErrorInConsoleTest() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

        assertFalse(isErrorPresent(logEntries, "TypeError"), "JavaScript error should not be present on the page!");
    }

    private boolean isErrorPresent(LogEntries logEntries, String errorName) {
        boolean errorPresent = false;

        for (LogEntry logEntry : logEntries) {
            if (logEntry.getMessage().contains(errorName)) {
                System.out.println("There was an error on the page: " + logEntry);
                errorPresent = true;
                continue;
            }
            System.out.println("Log Entry does not contain TypeError");
        }
        return errorPresent;
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
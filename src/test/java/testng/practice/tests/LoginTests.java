package testng.practice.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testng.practice.tests.page.objects.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/login");
    }

    @Parameters({"username", "password", "expectedWarning"})
    @Test
    public void asUserLoginUsingIncorrectCredentials(String username, String password, String expectedWarning) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUserNameField(username);
        loginPage.typeIntoPasswordField(password);
        loginPage.clickOnLoginButton();

        String warningMessage = loginPage.getWarningMessage();

        assertTrue(warningMessage.contains(expectedWarning));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
package testng.practice.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import testng.practice.tests.page.objects.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/login");
    }

    @Test
    public void loginUsingBadPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUserNameField("tomsmith");
        loginPage.typeIntoPasswordField("Bad password");
        loginPage.clickOnLoginButton();

        String warningMessage = loginPage.getWarningMessage();

        assertTrue(warningMessage.contains("Your password is invalid!"));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
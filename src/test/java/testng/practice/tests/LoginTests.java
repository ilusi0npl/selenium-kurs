package testng.practice.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import testng.practice.tests.page.objects.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginTests {

    private IncorrectLoginTestData incorrectLoginTestData;
    private WebDriver driver;

    public LoginTests(IncorrectLoginTestData incorrectLoginTestData) {
        this.incorrectLoginTestData = incorrectLoginTestData;
    }

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/login");
    }

    @Test
    public void asUserLoginUsingIncorrectCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUserNameField(incorrectLoginTestData.getUsername());
        loginPage.typeIntoPasswordField(incorrectLoginTestData.getPassword());
        loginPage.clickOnLoginButton();

        String warningMessage = loginPage.getWarningMessage();

        assertTrue(warningMessage.contains(incorrectLoginTestData.getExpectedMessage()));
    }

    @Factory
    public static Object[] incorrectLoginData() {
        LoginTests firstTestToExecute = new LoginTests
                (new IncorrectLoginTestData("", "", "Your username is invalid!"));
        LoginTests secondTestToExecute = new LoginTests
                (new IncorrectLoginTestData("tomsmith", "Bad password", "Your password is invalid!"));
        LoginTests thirdTestToExecute = new LoginTests
                (new IncorrectLoginTestData("Bad login", "SuperSecretPassword!", "Your username is invalid!"));

        return new Object[]{
                firstTestToExecute,
                secondTestToExecute,
                thirdTestToExecute};
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
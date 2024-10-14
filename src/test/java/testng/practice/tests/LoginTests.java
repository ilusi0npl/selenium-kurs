package testng.practice.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testng.practice.tests.page.objects.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/login");
    }

    @Test(dataProvider = "incorrectLoginData")
    public void asUserLoginUsingIncorrectCredentials(String username, String password, String expectedMessage) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUserNameField(username);
        loginPage.typeIntoPasswordField(password);
        loginPage.clickOnLoginButton();

        String warningMessage = loginPage.getWarningMessage();

        assertTrue(warningMessage.contains(expectedMessage));
    }

    @DataProvider
    public Object[][] incorrectLoginData() {
        return new Object[][]{
                {"", "", "Your username is invalid!"},
                {"tomsmith", "Bad password", "Your password is invalid!"},
                {"Bad login", "SuperSecretPassword!", "Your username is invalid!"}};
    }


    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PageObjectStaleElementReferenceExceptionTests {
    private static final String ACTION_SUCCESSFUL = "Action successful";
    private static final String ACTION_UNSUCCESFUL_PLEASE_TRY_AGAIN = "Action unsuccesful, please try again";

    private WebDriver driver;
    private NotificationMessagePage notificationMessagePage;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
    }

    @Test
    public void staleElementWorkingTest() {
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/notification_message_rendered");

        notificationMessagePage = new NotificationMessagePage(driver);
        assertThaCorrectActionMessageIsDisplayed(ACTION_UNSUCCESFUL_PLEASE_TRY_AGAIN);
        assertThaCorrectActionMessageIsDisplayed(ACTION_SUCCESSFUL);
        assertThaCorrectActionMessageIsDisplayed(ACTION_UNSUCCESFUL_PLEASE_TRY_AGAIN);
    }

    private void assertThaCorrectActionMessageIsDisplayed(String message) {
        boolean isMessageHavingCorrectText;

        do {
            notificationMessagePage.clickOnClickHere();
            isMessageHavingCorrectText = notificationMessagePage.getMessageLabelText().contains(message);
            System.out.println("Message label had correct text: " + isMessageHavingCorrectText);
        } while (!isMessageHavingCorrectText);

        assertTrue(isMessageHavingCorrectText);
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
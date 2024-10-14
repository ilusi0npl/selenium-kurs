import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class WithFindElementStaleElementReferenceExceptionTests {
    private static final String ACTION_SUCCESSFUL = "Action successful";
    private static final String ACTION_UNSUCCESFUL_PLEASE_TRY_AGAIN = "Action unsuccesful, please try again";
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
    }

    @Test
    public void staleElementWorkingTest() {
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/notification_message_rendered");

        //W celu uniknięcia duplikacji została stworzona dodatkowa metoda o nazwie assertThaCorrectActionMessageIsDisplayed
        //Metoda w parametrze przyjmuje treść wiadomości
        assertThaCorrectActionMessageIsDisplayed(ACTION_UNSUCCESFUL_PLEASE_TRY_AGAIN);
        assertThaCorrectActionMessageIsDisplayed(ACTION_SUCCESSFUL);
        assertThaCorrectActionMessageIsDisplayed(ACTION_UNSUCCESFUL_PLEASE_TRY_AGAIN);
    }

    //Metoda wykorzystuje pętlę do-while, która wykonuje akcję a następnie sprawdza warunek
    private void assertThaCorrectActionMessageIsDisplayed(String message) {
        
        boolean isMessageHavingCorrectText;
        do {
            //Kliknięcie w link Click here
            WebElement clickHereLink = driver.findElement(By.cssSelector("#content a"));
            clickHereLink.click();
            
            //Utworzenie WebElement odpowiadającemu wiadomości
            WebElement messageLabel = driver.findElement(By.id("flash"));
            
            //Zwrócenie informacji czy Webelement zawiera treść oczekiwanej wiadomości
            isMessageHavingCorrectText = messageLabel.getText().contains(message);
            System.out.println("Message label had correct text: " + isMessageHavingCorrectText);
            
            //Jeśli wiadomość jest zawarta, pętla zostaje przerwana
        } while (!isMessageHavingCorrectText);

        // Sprawdzenie asercją czy treść jest zawarta
        assertTrue(isMessageHavingCorrectText);
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
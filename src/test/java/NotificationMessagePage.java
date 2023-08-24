import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationMessagePage {

    private WebDriverWait webDriverWait;

    @FindBy(id = "flash")
    private WebElement messageLabel;

    @FindBy(css = "#content a")
    private WebElement clickHereLink;

    public NotificationMessagePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnClickHere() {
        clickHereLink.click();
    }

    public String getMessageLabelText() {
        return messageLabel.getText();
    }

}
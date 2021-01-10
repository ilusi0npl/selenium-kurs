import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.Arrays;

public class DriverEventListener implements WebDriverEventListener {
    @Override
    public void beforeAlertAccept(WebDriver driver) {
        System.out.println("Trying to accept alert");
    }

    @Override
    public void afterAlertAccept(WebDriver driver) {
        System.out.println("Alert was accepted");
    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {
        System.out.println("Alert was dismissed");
    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {
        System.out.println("Trying to dismiss alert");
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Trying to navigate to:" + url);
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigated to: " + url);
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        System.out.println("Trying to navigate back");
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        System.out.println("Navigated back");
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        System.out.println("Trying to navigate forward");
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        System.out.println("Navigated forward");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        System.out.println("Trying to refresh page");
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        System.out.println("Refreshed page");
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Trying to find element with locator " + by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Found element with locator " + by.toString());
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Trying to click on element");
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicked on element");
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        if (keysToSend == null) {
            System.out.println("Trying to clear field with location " + element.getLocation());
        } else {
            System.out.println("Trying to type text " + Arrays.toString(keysToSend));
        }
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        if (keysToSend == null) {
            System.out.println("Cleared field with location " + element.getLocation());
        } else {
            System.out.println("Typed text " + Arrays.toString(keysToSend));
        }
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
        System.out.println("Trying to execute script: " + script);
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
        System.out.println("Executed script");
    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        System.out.println("Trying to switch to window " + windowName);
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        System.out.println("Switched window " + windowName);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {
        System.out.println("Trying to get screenshot");
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {
        System.out.println("Done screenshot");
    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
        System.out.println("Trying to get text for WebElement");
    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
        System.out.println("Taken text of WebElement. Text wast " + s);
    }
}
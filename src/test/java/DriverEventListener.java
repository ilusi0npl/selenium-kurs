import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.Arrays;
import java.util.List;

public class DriverEventListener implements WebDriverListener {

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElement(driver, locator);
        System.out.println("Trying to find WebElement with locator " + locator.toString());
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        WebDriverListener.super.afterFindElement(driver, locator, result);
        System.out.println("Found WebElement with locator " + locator.toString());
    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElements(driver, locator);
        System.out.println("Trying to find WebElement list with locator " + locator.toString());
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        WebDriverListener.super.afterFindElements(driver, locator, result);
        System.out.println("Found WebElements list with locator " + locator.toString());
    }

    @Override
    public void beforeFindElement(WebElement element, By locator) {
        WebDriverListener.super.beforeFindElement(element, locator);
        System.out.println("Trying to find WebElement with locator " + locator.toString());
    }

    @Override
    public void afterFindElement(WebElement element, By locator, WebElement result) {
        WebDriverListener.super.afterFindElement(element, locator, result);
        System.out.println("Found WebElement with locator " + locator.toString());
    }

    @Override
    public void beforeFindElements(WebElement element, By locator) {
        WebDriverListener.super.beforeFindElements(element, locator);
        System.out.println("Trying to find WebElement list with locator " + locator.toString());
    }

    @Override
    public void afterFindElements(WebElement element, By locator, List<WebElement> result) {
        WebDriverListener.super.afterFindElements(element, locator, result);
        System.out.println("Found WebElements list with locator " + locator.toString());
    }

    @Override
    public void beforeClear(WebElement element) {
        WebDriverListener.super.beforeClear(element);
        System.out.println("Trying to clear WebElement");
    }

    @Override
    public void afterClear(WebElement element) {
        WebDriverListener.super.afterClear(element);
        System.out.println("Cleared WebElement " + element);
    }

    @Override
    public void beforeClick(WebElement element) {
        WebDriverListener.super.beforeClick(element);
        System.out.println("Trying to click WebElement");
    }

    @Override
    public void afterClick(WebElement element) {
        WebDriverListener.super.afterClick(element);
        System.out.println("Clicked WebElement");
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        WebDriverListener.super.beforeSendKeys(element, keysToSend);
        if (keysToSend == null) {
            System.out.println("Trying to clear field with location " + element.getLocation());
        } else {
            System.out.println("Trying to type text " + Arrays.toString(keysToSend));
        }
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        WebDriverListener.super.afterSendKeys(element, keysToSend);
        if (keysToSend == null) {
            System.out.println("Cleared field with location " + element.getLocation());
        } else {
            System.out.println("Typed text " + Arrays.toString(keysToSend));
        }
    }

}

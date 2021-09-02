package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ElementHelper {
    public static void scrollTo(WebElement webElement) {
        ((JavascriptExecutor) DriverHelper.getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public static boolean isElementDisplayed(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
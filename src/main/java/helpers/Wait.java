package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    private static WebDriverWait wait;

    public static WebDriverWait getWait(int seconds) {
        return wait = new WebDriverWait(DriverHelper.getDriver(), seconds);
    }

    public static void untilElementIsVisible(By locator, int seconds) {
        getWait(seconds).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static void untilElementIsClickable(By locator, int seconds) {
        getWait(seconds).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void untilElementIsSelected(By locator, int seconds) {
        getWait(seconds).until(ExpectedConditions.elementToBeSelected(locator));
    }

}



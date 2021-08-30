package helpers;

import common.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverHelper {

    private static WebDriver driver;

    public static void initDriver() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Constants.TIME_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void navigate(String url) {
        driver.get(url);
    }

    public static void quit() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getTitle() {
        return driver.getTitle();
    }

    public static void clickOKButtonOfAlert() {
        driver.switchTo().alert().accept();
    }

}

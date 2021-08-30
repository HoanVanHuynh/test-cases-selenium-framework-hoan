package page_objects;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BasePage {

    // Locators
    private final By tabLogin = By.cssSelector("a[href$='Login.cshtml']");

    // Elements
    private WebElement getTabLogin() {
        return DriverHelper.getDriver().findElement(tabLogin);
    }

    // Methods
    public void clickLoginTab() {
        this.getTabLogin().click();
    }

}

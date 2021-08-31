package page_objects;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    // Locators
    private final By tabLogin = By.cssSelector("a[href$='Login.cshtml']");
    private final By tabBookTicket = By.cssSelector("a[href$='BookTicketPage.cshtml']");

    // Elements
    private WebElement getTabLogin() {
        return DriverHelper.getDriver().findElement(tabLogin);
    }

    private WebElement getTabBookTicket() {
        return DriverHelper.getDriver().findElement(tabBookTicket);
    }

    // Methods
    public void clickLoginTab() {
        this.getTabLogin().click();
    }

    public void clickBookTicketTab() {
        this.getTabBookTicket().click();
    }
}
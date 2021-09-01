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
    private final By tabLogout = By.cssSelector("a[href$='Logout']");
    private final By tabContact = By.cssSelector("a[href*='Contact']");
    private WebElement getTabLogout() {
        return DriverHelper.getDriver().findElement(tabLogout);
    }
    private WebElement getTabContact() {
        return DriverHelper.getDriver().findElement(tabContact);
    }
    public void clickLogoutTab() {
        this.getTabLogout().click();
    }
    public void clickContactTab() {
        this.getTabContact().click();
    }
    public Boolean isLogoutTabDisplayed() {
        return getTabLogout().isDisplayed();
    }
    public Boolean isLoginTabDisplayed(){
        return getTabLogin().isDisplayed();
    }
}
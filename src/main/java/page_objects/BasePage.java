package page_objects;

import helpers.DriverHelper;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    // Locators
    private final By tabLogin = By.cssSelector("a[href$='Login.cshtml']");
    private final By tabBookTicket = By.cssSelector("a[href$='BookTicketPage.cshtml']");
    private final By tabLogout = By.cssSelector("a[href$='Logout']");
    private final By tabContact = By.cssSelector("a[href*='Contact']");
    private final By tabRegister = By.cssSelector("li > a[href$='Register.cshtml']");

    // Elements
    private WebElement getTabLogin() {
        return DriverHelper.getDriver().findElement(tabLogin);
    }

    private WebElement getTabBookTicket() {
        return DriverHelper.getDriver().findElement(tabBookTicket);
    }

    private WebElement getTabLogout() {
        return DriverHelper.getDriver().findElement(tabLogout);
    }

    private WebElement getTabContact() {
        return DriverHelper.getDriver().findElement(tabContact);
    }

    private WebElement getTabRegister() {
        return DriverHelper.getDriver().findElement(tabRegister);
    }

    // Methods
    public void clickLoginTab() {
        this.getTabLogin().click();
    }

    public void clickBookTicketTab() {
        this.getTabBookTicket().click();
    }

    public void clickLogoutTab() {
        this.getTabLogout().click();
    }

    public void clickContactTab() {
        this.getTabContact().click();
    }

    public boolean isLogoutTabDisplayed() {
        return ElementHelper.isElementDisplayed(this.getTabLogout());
    }

    public boolean isLoginTabDisplayed() {
        return ElementHelper.isElementDisplayed(this.getTabLogin());
    }

    public void clickRegisterTab() {
        this.getTabRegister().click();
    }
}
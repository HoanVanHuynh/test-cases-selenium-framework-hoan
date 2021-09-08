package page_objects;

import com.logigear.control.common.imp.Link;
import helpers.ElementHelper;

public class BasePage {

    private final Link loginTab = new Link("css=a[href$='Login.cshtml']");
    private final Link bookTicketTab = new Link("css=a[href$='BookTicketPage.cshtml']");
    private final Link logoutTab = new Link("css=a[href$='Logout']");
    private final Link contactTab = new Link("css=a[href*='Contact']");
    private final Link registerTab = new Link("css=a[href*='Register']");
    private final Link changePasswordTab = new Link("css=a[href*='ChangePassword']");
    private final Link myTicketTab = new Link("css=a[href*='ManageTicket']");

    // Methods
    public void clickLoginTab() {
        loginTab.click();
    }

    public void clickBookTicketTab() {
        bookTicketTab.click();
    }

    public void clickLogoutTab() {
        logoutTab.click();
    }

    public void clickContactTab() {
        contactTab.click();
    }

    public boolean isLogoutTabDisplayed() {
        return logoutTab.isExist();
    }

    public boolean isLoginTabDisplayed() {
        return loginTab.isExist();
    }

    public void clickRegisterTab() {
        registerTab.click();
    }

    public void clickChangePasswordTab() {
        changePasswordTab.click();
    }

    public void clickMyTicketTab() {
        myTicketTab.click();
    }
}
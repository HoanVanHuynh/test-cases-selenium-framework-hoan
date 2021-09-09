package page_objects;

import com.logigear.control.common.imp.Link;

public class BasePage {

    private final Link tabLogin = new Link("css=a[href$='Login.cshtml']");
    private final Link tabBookTicket = new Link("css=a[href$='BookTicketPage.cshtml']");
    private final Link tabLogout = new Link("css=a[href$='Logout']");
    private final Link tabContact = new Link("css=a[href*='Contact']");
    private final Link tabRegister = new Link("css=a[href*='Register']");
    private final Link tabChangePassword = new Link("css=a[href*='ChangePassword']");
    private final Link tabMyTicket = new Link("css=a[href*='ManageTicket']");

    // Methods
    public void clickLoginTab() {
        tabLogin.click();
    }

    public void clickBookTicketTab() {
        tabBookTicket.click();
    }

    public void clickLogoutTab() {
        tabLogout.click();
    }

    public void clickContactTab() {
        tabContact.click();
    }

    public boolean isLogoutTabDisplayed() {
        return tabLogout.isExist();
    }

    public boolean isLoginTabDisplayed() {
        return tabLogin.isExist();
    }

    public void clickRegisterTab() {
        tabRegister.click();
    }

    public void clickChangePasswordTab() {
        tabChangePassword.click();
    }

    public void clickMyTicketTab() {
        tabMyTicket.click();
    }
}
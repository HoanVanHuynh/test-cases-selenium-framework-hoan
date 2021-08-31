package tests;

import common.Constants;
import helpers.DriverHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.LoginPage;

public class LoginTests extends BaseTest {

    private LoginPage loginPage = new LoginPage();
    private BookTicketPage bookTicketPage = new BookTicketPage();

    @BeforeMethod(onlyForGroups = {"g1"})
    public void precondition() {
        LogHelper.info("Click on Login tab");
        loginPage.clickLoginTab();
    }

    @Test(description = "User can log into Railway with valid username and password", groups = {"g1"})
    public void tc01_LoginWithValidInformation() {
        LogHelper.info("Enter valid Email and Password and click on Login button");
        loginPage.login(Constants.USERNAME, Constants.PASSWORD);

        LogHelper.info("Get welcome user message");
        String actualMessage = loginPage.getWelcomeMessage();
        String expectedMessage = "Welcome " + Constants.USERNAME;

        LogHelper.info("Verify that welcome user message displays correctly after logging into Railway successfully");
        Assert.assertEquals(actualMessage, expectedMessage, "Welcome user message is not displayed as expected");
    }

    @Test(description = "User can not login with blank username textbox", groups = {"g1"})
    public void tc02_CanNotLoginWithBlankUsername() {
        LogHelper.info("Does not type any words into username textbox but enter valid information into password textbox and click on login button");
        loginPage.login("", Constants.PASSWORD);

        LogHelper.info("Get error message at top of login form");
        String actualMessage = loginPage.getErrorMessageAtTop();
        String expectedMessage = "There was a problem with your login and/or errors exist in your form.";

        LogHelper.info("Verify that error message at top of login form appears correctly after logging with bank username textbox");
        Assert.assertEquals(actualMessage, expectedMessage, "Error message at top of login form does not appear correctly as design");

        LogHelper.info("Get current page title");
        String actualTitle = DriverHelper.getTitle();
        String expectedTitle = "Safe Railway - Login";

        LogHelper.info("Verify that if user can not login, user is still at the login page");
        Assert.assertEquals(actualTitle, expectedTitle, "Title of login page should not be changed");
    }

    @Test(description = "User cannot log into Railway with invalid password", groups = {"g1"})
    public void tc03_CanNotLoginWithInvalidPassword() {
        String invalidPassword = "12345";

        LogHelper.info("Enter valid Email and invalid Password and click on Login button");
        loginPage.login(Constants.USERNAME, invalidPassword);

        LogHelper.info("Get error message at top of login form");
        String actualMessage = loginPage.getErrorMessageAtTop();
        String expectedMessage = "Invalid username or password. Please try again.";

        LogHelper.info("Verify that error message at top of login form appears correctly after logging with invalid password");
        Assert.assertEquals(actualMessage, expectedMessage, "Error message at top of login form does not appear correctly as design");

        LogHelper.info("Get current page title");
        String actualTitle = DriverHelper.getTitle();
        String expectedTitle = "Safe Railway - Login";

        LogHelper.info("Verify that user is still at the login page");
        Assert.assertEquals(actualTitle, expectedTitle, "Title of login page is displayed incorrectly as expected");
    }

    @Test(description = "User is redirected to Book ticket page after logging in")
    public void tc04_UserIsRedirectedToBookTicketPage() {
        LogHelper.info("Click on Book ticket tab");
        bookTicketPage.clickBookTicketTab();

        LogHelper.info("Get topic content at the top of login page in the middle");
        String actualContent = loginPage.getTopicContentAtTop();

        LogHelper.info("Login with valid account");
        loginPage.login(Constants.USERNAME, Constants.PASSWORD);

        LogHelper.info("Get Book ticket form title on the left hand side of Book ticket page");
        String actualTitle = bookTicketPage.getBookTicketFormTitle();

        LogHelper.info("Verify that user is directed to Login page after clicking on Book Ticket tab");
        Assert.assertEquals(actualContent, "Login Page", "Topic content of Login page is displayed incorrectly as expected");

        LogHelper.info("Verify that book ticket page displays with Book ticket form opens");
        Assert.assertEquals(actualTitle, "Book ticket form", "Title of Book ticket form is displayed incorrectly as expected");
    }

    @Test(description = "System shows message when user enters wrong password several times", groups = {"g1"})
    public void tc05_SystemShowsMessage() {
        String invalidPassword = "11122233345";

        LogHelper.info("Log in 4 times with valid username but invalid password");
        for (int i = 0; i < 4; i++) {
            loginPage.login(Constants.USERNAME, invalidPassword);
        }

        LogHelper.info("Get error message after logging in 4 times with invalid password");
        String actualMessage = loginPage.getErrorMessageAtTop();
        String expectedMessage = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

        LogHelper.info("Verify that error message displays correctly after logging in 4 times with invalid password");
        Assert.assertEquals(actualMessage, expectedMessage, "Error message is displayed incorrectly as expected");
    }
}
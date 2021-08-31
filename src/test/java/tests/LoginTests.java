package tests;

import common.Constants;
import helpers.DataHelper;
import helpers.DriverHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.LoginPage;

public class LoginTests extends BaseTest {

    private LoginPage loginPage = new LoginPage();

    @Test(description = "User can log into Railway with valid username and password")
    public void tc01_LoginWithValidInformation() {
        LogHelper.info("Click on Login tab");
        loginPage.clickLoginTab();

        LogHelper.info("Enter valid Email and Password and click on Login button");
        loginPage.login(Constants.USERNAME, Constants.PASSWORD);

        LogHelper.info("Get welcome user message");
        String actualMessage = loginPage.getWelcomeMessage();
        String expectedMessage = "Welcome " + Constants.USERNAME;

        LogHelper.info("Verify that welcome user message displays correctly after logging into Railway successfully");
        Assert.assertEquals(actualMessage, expectedMessage, "Welcome user message is not displayed as expected");
    }

    @Test(description = "User can not login with blank username textbox")
    public void tc02_CanNotLoginWithBlankUsername() {
        LogHelper.info("Click on Login tab");
        loginPage.clickLoginTab();

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

    @Test(description = "User cannot log into Railway with invalid password ")
    public void tc03_CanNotLoginWithInvalidPassword() {
        LogHelper.info("Click on Login tab");
        loginPage.clickLoginTab();

        LogHelper.info("Get invalid random password with 5 characters");
        String invalidPassword = DataHelper.getRandomPassword(5);

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

        LogHelper.info("Verify that if user can not login, user is still at the login page");
        Assert.assertEquals(actualTitle, expectedTitle, "Title of login page should not be changed");
    }
}

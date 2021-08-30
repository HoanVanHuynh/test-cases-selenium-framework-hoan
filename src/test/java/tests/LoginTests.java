package tests;

import common.Constants;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BasePage;
import page_objects.LoginPage;

public class LoginTests extends BaseTest {

    private BasePage basePage = new BasePage();
    private LoginPage loginPage = new LoginPage();

    @Test(description = "User can log into Railway with valid username and password")
    public void tc01_LoginWithValidInformation() {
        LogHelper.info("Click on Login tab");
        basePage.clickLoginTab();
        LogHelper.info("Enter valid Email and Password and click on Login button");
        loginPage.login(Constants.USERNAME, Constants.PASSWORD);

        LogHelper.info("Get welcome user message");
        String actualMessage = loginPage.getWelcomeMessage();
        String expectedMessage = "Welcome " + Constants.USERNAME;

        Assert.assertEquals(actualMessage, expectedMessage, "Welcome user message is not displayed as expected");

    }
}

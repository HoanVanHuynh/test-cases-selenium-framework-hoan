package tests;

import common.Account;
import helpers.DataHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_objects.RegisterPage;

public class RegisterTests extends BaseTest {

    private Account account = new Account();
    private RegisterPage registerPage = new RegisterPage();
    private String email = DataHelper.getRandomEmail();
    private String password = DataHelper.getRandomPassword(10);
    private String pid = DataHelper.getRandomDigits(10);

    @BeforeTest
    public void precondition() {
        LogHelper.info("Set all valid register information such as email: " + email + ", password: " + password + ", confirm password: " + password + ", pid: " + pid);
        account.setEmail(email);
        account.setPassword(password);
        account.setConfirmPassword(password);
        account.setPid(pid);
    }

    @Test(description = "User can create new account")
    public void tc07_RegisterWithValidInformation() {
        LogHelper.info("Click on Register tab");
        registerPage.clickRegisterTab();

        LogHelper.info("Register an account");
        registerPage.register(account);

        LogHelper.info("Get register success message");
        String actualResult = registerPage.getRegisterSuccessMessage();
        String expectedResult = "You're here";

        LogHelper.info("Verify that new account is created and success message appears properly");
        Assert.assertEquals(actualResult, expectedResult, "Register success message displays incorrectly");
    }
}
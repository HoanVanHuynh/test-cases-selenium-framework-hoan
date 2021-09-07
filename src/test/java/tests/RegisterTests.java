package tests;

import common.Account;
import helpers.DataHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.ChangePasswordPage;
import page_objects.LoginPage;
import page_objects.RegisterPage;

public class RegisterTests extends BaseTest {

    private Account account = new Account();
    private RegisterPage registerPage = new RegisterPage();
    private ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    private LoginPage loginPage = new LoginPage();
    private String email;
    private String password;
    private String pid;

    @BeforeMethod
    public void precondition() {
        email = DataHelper.getRandomEmail();
        pid = DataHelper.getRandomDigits(10);
        password = "0123456789hochiminh";

        LogHelper.info("Set all valid register information such as email: " + email + ", password: " + password + ", confirm password: " + password + ", pid: " + pid);
        account.setEmail(email);
        account.setPassword(password);
        account.setConfirmPassword(password);
        account.setPid(pid);

        LogHelper.info("Click on Register tab");
        registerPage.clickRegisterTab();

        LogHelper.info("Register an account");
        registerPage.register(account);
    }

    @Test(description = "User can create new account")
    public void tc07_RegisterWithValidInformation() {
        LogHelper.info("Get register success message");
        String actualResult = registerPage.getRegisterSuccessMessage();
        String expectedResult = "You're here";

        LogHelper.info("Verify that new account is created and success message appears properly");
        Assert.assertEquals(actualResult, expectedResult, "Register success message displays incorrectly");
    }

    @Test(description = "User can not change password when New Password and Confirm Password are different")
    public void tc09_UserCanNotChangePassword() {
        LogHelper.info("Click on Login tab");
        loginPage.clickLoginTab();

        LogHelper.info("Log into Railway");
        loginPage.login(email, password);

        LogHelper.info("Click on Change Password tab");
        changePasswordPage.clickChangePasswordTab();

        String newPassword = "a123:\"/{}!@$\\";
        String confirmPassword = "b456:\"/{}!@$\\";

        LogHelper.info("Change password with new password and confirm password are different");
        changePasswordPage.changePassword(password, newPassword, confirmPassword);

        LogHelper.info("Get error message at the top of change password form ");
        String actualFormErrorMsg = changePasswordPage.getGeneralErrorMessage();
        String expectedFormErrorMsg = "Password change failed. Please correct the errors and try again.";

        LogHelper.info("Get error message next to confirm password field");
        String actualConfirmPasswordErrorMsg = changePasswordPage.getConfirmPasswordErrorMessage();
        String expectedConfirmPasswordErrorMsg = "The password confirmation does not match the new password.";

        LogHelper.info("Verify that user can not change password");
        Assert.assertEquals(actualFormErrorMsg, expectedFormErrorMsg, "Change password error message is displayed incorrectly");

        LogHelper.info("Verify that error message displays correctly when using new password and confirm password are different");
        Assert.assertEquals(actualConfirmPasswordErrorMsg, expectedConfirmPasswordErrorMsg, "Confirm password error message is displayed incorrectly");
    }
}
package page_objects;

import helpers.DriverHelper;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage {

    // Locators
    private final By txtCurrentPassword = By.id("currentPassword");
    private final By txtNewPassword = By.id("newPassword");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By btnChangePassword = By.cssSelector("input[value='Change Password']");
    private final By lblChangePasswordErrorMessageAtTop = By.cssSelector("p[class='message error']");
    private final By lblConfirmPasswordErrorMessageNextTo = By.cssSelector("input#confirmPassword + label.validation-error");

    // Elements
    private WebElement getTxtCurrentPassword() {
        return DriverHelper.getDriver().findElement(txtCurrentPassword);
    }

    private WebElement getTxtNewPassword() {
        return DriverHelper.getDriver().findElement(txtNewPassword);
    }

    private WebElement getTxtConfirmPassword() {
        return DriverHelper.getDriver().findElement(txtConfirmPassword);
    }

    private WebElement getBtnChangePassword() {
        return DriverHelper.getDriver().findElement(btnChangePassword);
    }

    private WebElement getLblChangePasswordErrorMessageAtTop() {
        return DriverHelper.getDriver().findElement(lblChangePasswordErrorMessageAtTop);
    }

    private WebElement getLblConfirmPasswordErrorMessageNextTo() {
        return DriverHelper.getDriver().findElement(lblConfirmPasswordErrorMessageNextTo);
    }

    // Methods
    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        ElementHelper.scrollTo(this.getTxtCurrentPassword());
        this.getTxtCurrentPassword().sendKeys(currentPassword);
        this.getTxtNewPassword().sendKeys(newPassword);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getBtnChangePassword().click();
    }

    public String getPasswordErrorMessageAtTop() {
        return this.getLblChangePasswordErrorMessageAtTop().getText();
    }

    public String getConfirmPasswordErrorMessageNextTo() {
        return this.getLblConfirmPasswordErrorMessageNextTo().getText();
    }
}
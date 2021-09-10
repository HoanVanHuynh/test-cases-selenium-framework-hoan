package page_objects;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.TextBox;

public class ChangePasswordPage extends BasePage {

    private final TextBox txtCurrentPassword = new TextBox("id=currentPassword");
    private final TextBox txtNewPassword = new TextBox("id=newPassword");
    private final TextBox txtConfirmPassword = new TextBox("id=confirmPassword");
    private final Button btnChangePassword = new Button("css=input[value='Change Password']");
    private final Label lblGeneralErrorMessage = new Label("css=p[class='message error']");
    private final Label lblConfirmPasswordErrorMessage = new Label("css=input#confirmPassword + label.validation-error");

    // Methods
    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        txtCurrentPassword.scrollToView();
        txtCurrentPassword.enter(currentPassword);
        txtNewPassword.enter(newPassword);
        txtConfirmPassword.enter(confirmPassword);
        btnChangePassword.click();
    }

    public String getGeneralErrorMessage() {
        return lblGeneralErrorMessage.getText();
    }

    public String getConfirmPasswordErrorMessage() {
        return lblConfirmPasswordErrorMessage.getText();
    }
}
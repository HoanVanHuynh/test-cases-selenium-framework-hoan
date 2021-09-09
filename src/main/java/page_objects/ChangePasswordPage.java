package page_objects;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.TextBox;

public class ChangePasswordPage extends BasePage {

    private final TextBox currentPasswordField = new TextBox("id=currentPassword");
    private final TextBox newPasswordField = new TextBox("id=newPassword");
    private final TextBox confirmPasswordField = new TextBox("id=confirmPassword");
    private final Button changePasswordButton = new Button("css=input[value='Change Password']");
    private final Label generalErrorMessage = new Label("css=p[class='message error']");
    private final Label confirmPasswordErrorMessage = new Label("css=input#confirmPassword + label.validation-error");

    // Methods
    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        currentPasswordField.scrollToView();
        currentPasswordField.enter(currentPassword);
        newPasswordField.enter(newPassword);
        confirmPasswordField.enter(confirmPassword);
        changePasswordButton.click();
    }

    public String getGeneralErrorMessage() {
        return generalErrorMessage.getText();
    }

    public String getConfirmPasswordErrorMessage() {
        return confirmPasswordErrorMessage.getText();
    }
}
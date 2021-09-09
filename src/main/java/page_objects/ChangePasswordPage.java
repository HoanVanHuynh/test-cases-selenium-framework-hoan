package page_objects;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.TextBox;

public class ChangePasswordPage extends BasePage {

    private final TextBox currentPassword = new TextBox("id=currentPassword");
    private final TextBox newPassword = new TextBox("id=newPassword");
    private final TextBox confirmPassword = new TextBox("id=confirmPassword");
    private final Button changePasswordButton = new Button("css=input[value='Change Password']");
    private final Label generalErrorMessage = new Label("css=p[class='message error']");
    private final Label confirmPasswordErrorMessage = new Label("css=input#confirmPassword + label.validation-error");

    // Methods
    public void changePassword(String old, String fresh, String confirm) {
        currentPassword.scrollToView();
        currentPassword.setValue(old);
        newPassword.setValue(fresh);
        confirmPassword.setValue(confirm);
        changePasswordButton.click();
    }

    public String getGeneralErrorMessage() {
        return generalErrorMessage.getText();
    }

    public String getConfirmPasswordErrorMessage() {
        return confirmPasswordErrorMessage.getText();
    }
}
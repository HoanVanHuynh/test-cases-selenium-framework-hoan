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
    public void changePassword(String ctp, String np, String cmp) {
        currentPassword.scrollToView();
        currentPassword.setValue(ctp);
        newPassword.setValue(np);
        confirmPassword.setValue(cmp);
        changePasswordButton.click();
    }

    public String getGeneralErrorMessage() {
        return generalErrorMessage.getText();
    }

    public String getConfirmPasswordErrorMessage() {
        return confirmPasswordErrorMessage.getText();
    }
}
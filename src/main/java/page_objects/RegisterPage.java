package page_objects;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.TextBox;
import common.Account;

public class RegisterPage extends BasePage {

    private final TextBox txtEmail = new TextBox("id=email");
    private final TextBox txtPassword = new TextBox("id=password");
    private final TextBox txtConfirmPassword = new TextBox("id=confirmPassword");
    private final TextBox txtPid = new TextBox("id=pid");
    private final Button btnRegister = new Button("css=input[value='Register']");
    private final Label lblRegisterSuccessMessage = new Label("css=div#content p");

    public void register(Account account) {
        txtEmail.scrollToView();
        txtEmail.setValue(account.getEmail());
        txtPassword.setValue(account.getPassword());
        txtConfirmPassword.setValue(account.getConfirmPassword());
        txtPid.setValue(account.getPid());
        btnRegister.click();
    }

    public String getRegisterSuccessMessage() {
        lblRegisterSuccessMessage.waitForVisibility();
        return lblRegisterSuccessMessage.getText();
    }
}
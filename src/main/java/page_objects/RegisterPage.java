package page_objects;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.TextBox;
import common.Account;
import common.Constants;

public class RegisterPage extends BasePage {

    private final TextBox email = new TextBox("id=email");
    private final TextBox password = new TextBox("id=password");
    private final TextBox confirmPassword = new TextBox("id=confirmPassword");
    private final TextBox pid = new TextBox("id=pid");
    private final Button registerButton = new Button("css=input[value='Register']");
    private final Label registerSuccessMessage = new Label("css=div#content p");

    public void register(Account account) {
        email.scrollToView();
        email.setValue(account.getEmail());
        password.setValue(account.getPassword());
        confirmPassword.setValue(account.getConfirmPassword());
        pid.setValue(account.getPid());
        registerButton.click();
    }

    public String getRegisterSuccessMessage() {
        registerSuccessMessage.isExist(Constants.TIME_WAIT);
        return registerSuccessMessage.getText();
    }
}
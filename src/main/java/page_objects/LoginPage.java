package page_objects;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.TextBox;

public class LoginPage extends BasePage {

    private final TextBox txtUsername = new TextBox("id=username");
    private final TextBox txtPassword = new TextBox("id=password");
    private final Button btnLogin = new Button("css=input[value='Login']");
    private final Label lblWelcomeMessage = new Label("css=div[class='account'] > strong");
    private final Label lblErrorMessageAtTop = new Label("css=p[class='message error LoginForm']");
    private final Label lblTopicContentAtTop = new Label("css=div#content h1");

    // Methods
    public void login(String username, String password) {
        txtUsername.scrollToView();
        txtUsername.enter(username);
        txtPassword.enter(password);
        btnLogin.click();
    }

    public String getWelcomeMessage() {
        return lblWelcomeMessage.getText();
    }

    public String getErrorMessageAtTop() {
        return lblErrorMessageAtTop.getText();
    }

    public String getTopicContentAtTop() {
        return lblTopicContentAtTop.getText();
    }

    public void loginMultipleTimes(int numberOfTimes, String username, String password) {
        for (int i = 0; i < numberOfTimes; i++) {
            login(username, password);
        }
    }
}
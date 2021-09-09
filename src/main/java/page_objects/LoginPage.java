package page_objects;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.TextBox;

public class LoginPage extends BasePage {

    private final TextBox usernameField = new TextBox("id=username");
    private final TextBox passwordField = new TextBox("id=password");
    private final Button loginButton = new Button("css=input[value='Login']");
    private final Label welcomeMessage = new Label("css=div[class='account'] > strong");
    private final Label errorMessageAtTop = new Label("css=p[class='message error LoginForm']");
    private final Label topicContentAtTop = new Label("css=div#content h1");

    // Methods
    public void login(String username, String password) {
        usernameField.scrollToView();
        usernameField.enter(username);
        passwordField.enter(password);
        loginButton.click();
    }

    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }

    public String getErrorMessageAtTop() {
        return errorMessageAtTop.getText();
    }

    public String getTopicContentAtTop() {
        return topicContentAtTop.getText();
    }

    public void loginMultipleTimes(int numberOfTimes, String username, String password) {
        for (int i = 0; i < numberOfTimes; i++) {
            login(username, password);
        }
    }
}
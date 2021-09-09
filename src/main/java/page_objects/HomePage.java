package page_objects;

import com.logigear.control.common.imp.Label;

public class HomePage extends BasePage {

    private final Label lblWelcomeContent = new Label("css=div#content h1");

    public String getWelcomeContent() {
        return lblWelcomeContent.getText();
    }
}
package page_objects;

import helpers.DriverHelper;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    // Locators
    private final By txtUsername = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.cssSelector("input[value='Login']");
    private final By lblWelcomeMessage = By.cssSelector("div[class='account'] > strong");
    private final By lblErrorMessageAtTop = By.cssSelector("p[class='message error LoginForm']");
    private final By lblTopicContentAtTop = By.cssSelector("div#content h1");

    // Elements
    private WebElement getTxtUsername() {
        return DriverHelper.getDriver().findElement(txtUsername);
    }

    private WebElement getTxtPassword() {
        return DriverHelper.getDriver().findElement(txtPassword);
    }

    private WebElement getBtnLogin() {
        return DriverHelper.getDriver().findElement(btnLogin);
    }

    private WebElement getLblWelcomeMessage() {
        return DriverHelper.getDriver().findElement(lblWelcomeMessage);
    }

    private WebElement getLblErrorMessageAtTop() {
        return DriverHelper.getDriver().findElement(lblErrorMessageAtTop);
    }

    private WebElement getLblTopicContentAtTop() {
        return DriverHelper.getDriver().findElement(lblTopicContentAtTop);
    }

    // Methods
    public void login(String username, String password) {
        ElementHelper.scrollTo(this.getTxtUsername());
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
    }

    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public String getErrorMessageAtTop() {
        return this.getLblErrorMessageAtTop().getText();
    }

    public String getTopicContentAtTop() {
        return this.getLblTopicContentAtTop().getText();
    }

    public void loginMultipleTimes(int numberOfTimes, String username, String password) {
        for (int i = 0; i < numberOfTimes; i++) {
            this.login(username, password);
        }
    }
}
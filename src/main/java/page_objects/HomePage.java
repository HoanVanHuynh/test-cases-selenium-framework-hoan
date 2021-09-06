package page_objects;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    // Locator
    private final By lblWelcomeContentAtTop = By.cssSelector("div#content h1");

    // Element
    private WebElement getLblWelcomeContentAtTop() {
        return DriverHelper.getDriver().findElement(lblWelcomeContentAtTop);
    }

    // Method
    public String getWelcomeContentAtTop() {
        return this.getLblWelcomeContentAtTop().getText();
    }
}
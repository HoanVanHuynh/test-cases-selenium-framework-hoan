package page_objects;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends BasePage {

    // Locator
    private final By lblBookTicketFormTitle = By.cssSelector("form[method='post'] fieldset legend");

    // Element
    private WebElement getLblBookTicketFormTitle() {
        return DriverHelper.getDriver().findElement(lblBookTicketFormTitle);
    }

    // Method
    public String getBookTicketFormTitle() {
        return this.getLblBookTicketFormTitle().getText();
    }
}

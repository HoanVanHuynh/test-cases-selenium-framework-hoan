package page_objects;

import helpers.DriverHelper;
import helpers.ElementHelper;
import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends BasePage {

    private final String dynamicManageTicketsRow = "//table[@class='MyTable']/tbody//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/input[@value='Cancel']";
    private final String dynamicNoteWith0Or1Ticket = "//div[@class='message']/li[text()='You currently book %d ticket, you can book %d more.']";
    private final String dynamicNoteWithMoreThan1Ticket = "//div[@class='message']/li[text()='You currently book %d tickets, you can book %d more.']";

    // Element
    private WebElement getCancelButton(String departStation, String arriveStation, String departDate, String ticketAmount) {
        String dynamicCancelButton = String.format(dynamicManageTicketsRow, departStation, arriveStation, departDate, ticketAmount);
        By cancelButton = By.xpath(dynamicCancelButton);
        return DriverHelper.getDriver().findElement(cancelButton);
    }

    // Methods
    public void cancelTicket(String departStation, String arriveStation, String departDate, String ticketAmount) {
        ElementHelper.scrollTo(this.getCancelButton(departStation, arriveStation, departDate, ticketAmount));
        this.getCancelButton(departStation, arriveStation, departDate, ticketAmount).click();
    }

    public String getCancelTicketNoteWith0Or1Ticket(int ticketAmount, int maximumTicketAmount) {
        int remainingTicketAmount = maximumTicketAmount - ticketAmount;
        String dynamicCancelTicketNote = String.format(dynamicNoteWith0Or1Ticket, ticketAmount, remainingTicketAmount);
        By note = By.xpath(dynamicCancelTicketNote);
        return DriverHelper.getDriver().findElement(note).getText();
    }

    public String getCancelTicketNoteWithMoreThan1Ticket(int ticketAmount, int maximumTicketAmount) {
        int remainingTicketAmount = maximumTicketAmount - ticketAmount;
        String dynamicCancelTicketNote = String.format(dynamicNoteWithMoreThan1Ticket, ticketAmount, remainingTicketAmount);
        By note = By.xpath(dynamicCancelTicketNote);
        return DriverHelper.getDriver().findElement(note).getText();
    }

    public void clickOKButton() {
        Wait.untilAlertIsPresent(10);
        DriverHelper.getAlert().accept();
    }
}
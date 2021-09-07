package page_objects;

import common.Ticket;
import helpers.DriverHelper;
import helpers.ElementHelper;
import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BookTicketPage extends BasePage {

    // Locators
    private final By cmbDepartDate = By.cssSelector("select[name='Date']");
    private final By cmbDepartFrom = By.cssSelector("select[name='DepartStation']");
    private final By cmbArriveAt = By.cssSelector("select[name='ArriveStation']");
    private final By cmbSeatType = By.cssSelector("select[name='SeatType']");
    private final By cmbTicketAmount = By.cssSelector("select[name='TicketAmount']");
    private final By btnBookTicket = By.cssSelector("input[type='submit']");
    private final By lblBookTicketMessage = By.cssSelector("div[id='content'] > h1");
    private final By lblBookTicketFormTitle = By.cssSelector("form[method='post'] fieldset legend");
    private final By lblBookedTicketTable = By.cssSelector("table[class = 'MyTable WideTable' ] tbody");

    // Elements
    private WebElement getLblBookedTicketTable() {
        return DriverHelper.getDriver().findElement(lblBookedTicketTable);
    }

    private WebElement getLblBookTicketFormTitle() {
        Wait.untilElementIsVisible(lblBookTicketFormTitle, 10);
        return DriverHelper.getDriver().findElement(lblBookTicketFormTitle);
    }

    private WebElement getBtnBookTicket() {
        return DriverHelper.getDriver().findElement(btnBookTicket);
    }

    private WebElement getLblBookTicketMessage() {
        return DriverHelper.getDriver().findElement(lblBookTicketMessage);
    }

    private Select getDropDownDepartDate() {
        Select select = new Select(DriverHelper.getDriver().findElement(cmbDepartDate));
        return select;
    }

    private Select getDropDownDepartFrom() {
        Select select = new Select(DriverHelper.getDriver().findElement(cmbDepartFrom));
        return select;
    }

    private Select getDropDownArriveAt() {
        Select select = new Select(DriverHelper.getDriver().findElement(cmbArriveAt));
        return select;
    }

    private Select getDropDownSeatType() {
        Select select = new Select(DriverHelper.getDriver().findElement(cmbSeatType));
        return select;
    }

    private Select getDropDownTicketAmount() {
        Select select = new Select(DriverHelper.getDriver().findElement(cmbTicketAmount));
        return select;
    }

    // Methods
    public void selectDepartDate(String departDate) {
        Wait.untilElementIsVisible(cmbDepartDate, 20);
        this.getDropDownDepartDate().selectByVisibleText(departDate);
    }

    public void selectDepartStation(String departFrom) {
        Wait.untilElementIsVisible(cmbDepartFrom, 20);
        this.getDropDownDepartFrom().selectByVisibleText(departFrom);
    }

    public void selectArriveStation(String arriveAt) {
        Wait.untilElementIsVisible(cmbArriveAt, 120);
        this.getDropDownArriveAt().selectByVisibleText(arriveAt);
    }

    public void selectSeatType(String seatType) {
        Wait.untilElementIsVisible(cmbSeatType, 20);
        this.getDropDownSeatType().selectByVisibleText(seatType);
    }

    public void selectTicketAmount(String ticketAmount) {
        Wait.untilElementIsVisible(cmbTicketAmount, 20);
        this.getDropDownTicketAmount().selectByVisibleText(ticketAmount);
    }

    public void bookTicket(Ticket ticket) {
        ElementHelper.scrollTo(this.getBtnBookTicket());
        this.selectDepartDate(ticket.getDepartDate());
        this.selectDepartStation(ticket.getDepartFrom());
        this.selectArriveStation(ticket.getArriveAt());
        this.selectSeatType(ticket.getSeatType());
        this.selectTicketAmount(ticket.getTicketAmount());
        this.getBtnBookTicket().click();
    }

    public String getInformationBeforeBooking(Ticket ticket) {
        return ticket.getDepartFrom() + " " + ticket.getArriveAt() + " " + ticket.getSeatType() + " " + ticket.getDepartDate() + " " + ticket.getTicketAmount() + " ";
    }

    public String getInformationAfterBooking() {
        StringBuilder stringBuilder = new StringBuilder();
        List<WebElement> row = getLblBookedTicketTable().findElements(By.tagName("td"));
        for (int i = 0; i < row.size() - 1; i++) {
            if (i == 4 || i == 5) {
                continue;
            }
            stringBuilder.append(row.get(i).getText() + " ");
        }
        return stringBuilder.toString();
    }

    public boolean isTheSameTicketInformationDisplayed(Ticket ticket) {
        String beforeBook = this.getInformationBeforeBooking(ticket);
        String afterBook = this.getInformationAfterBooking();
        if (beforeBook.equals(afterBook)) {
            return true;
        } else {
            return false;
        }
    }

    public String getBookTicketMessage() {
        return this.getLblBookTicketMessage().getText();
    }

    public String getBookTicketFormTitle() {
        return this.getLblBookTicketFormTitle().getText();
    }
}
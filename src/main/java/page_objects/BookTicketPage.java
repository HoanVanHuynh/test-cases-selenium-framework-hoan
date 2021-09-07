package page_objects;

import common.Constants;
import common.Ticket;
import helpers.DriverHelper;
import helpers.ElementHelper;
import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
    private final String dynamicBookedTicketTable = "//table[@class='MyTable WideTable']/tbody//td[text()='%s']";

    // Elements
    private WebElement getLblBookTicketFormTitle() {
        Wait.untilElementIsVisible(lblBookTicketFormTitle, Constants.TIME_WAIT);
        return DriverHelper.getDriver().findElement(lblBookTicketFormTitle);
    }

    private WebElement getBookedTicketTable(String option) {
        String bookedTicketTable = String.format(dynamicBookedTicketTable, option);
        By table = By.xpath(bookedTicketTable);
        return DriverHelper.getDriver().findElement(table);
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
        Wait.untilElementIsVisible(cmbDepartDate, Constants.TIME_WAIT);
        this.getDropDownDepartDate().selectByVisibleText(departDate);
    }

    public void selectDepartStation(String departFrom) {
        Wait.untilElementIsVisible(cmbDepartFrom, Constants.TIME_WAIT);
        this.getDropDownDepartFrom().selectByVisibleText(departFrom);
    }

    public void selectArriveStation(String arriveAt) {
        Wait.untilElementIsVisible(cmbArriveAt, Constants.TIME_WAIT);
        this.getDropDownArriveAt().selectByVisibleText(arriveAt);
    }

    public void selectSeatType(String seatType) {
        Wait.untilElementIsVisible(cmbSeatType, Constants.TIME_WAIT);
        this.getDropDownSeatType().selectByVisibleText(seatType);
    }

    public void selectTicketAmount(String ticketAmount) {
        Wait.untilElementIsVisible(cmbTicketAmount, Constants.TIME_WAIT);
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

    public boolean isTheSameTicketInformationDisplayed(Ticket ticket) {
        if (getBookedTicketTable(ticket.getDepartDate()).isDisplayed() && getBookedTicketTable(ticket.getDepartFrom()).isDisplayed() && getBookedTicketTable(ticket.getArriveAt()).isDisplayed()) {
            return true;
        }
        return false;
    }

    public String getBookTicketMessage() {
        return this.getLblBookTicketMessage().getText();
    }

    public String getBookTicketFormTitle() {
        return this.getLblBookTicketFormTitle().getText();
    }
}
package page_objects;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.ComboBox;
import com.logigear.control.common.imp.Label;
import common.Ticket;

public class BookTicketPage extends BasePage {

    private final ComboBox departDate = new ComboBox("css=select[name='Date']");
    private final ComboBox departFrom = new ComboBox("css=select[name='DepartStation']");
    private final ComboBox arriveAt = new ComboBox("css=select[name='ArriveStation']");
    private final ComboBox seatType = new ComboBox("css=select[name='SeatType']");
    private final ComboBox ticketAmount = new ComboBox("css=select[name='TicketAmount']");
    private final Button bookTicketButton = new Button("css=input[type='submit']");
    private final Label bookTicketMessage = new Label("css=div[id='content'] > h1");
    private final Label bookTicketFormTitle = new Label("css=form[method='post'] fieldset legend");
    private final Label dynamicBookedTicketTable = new Label("//table[@class='MyTable WideTable']/tbody//td[text()='%s']");

    public void selectDepartDate(String date) {
        departDate.waitForVisibility();
        departDate.select(date);
    }

    public void selectDepartStation(String from) {
        departFrom.waitForVisibility();
        departFrom.select(from);
    }

    public void selectArriveStation(String arrive) {
        arriveAt.waitForVisibility();
        arriveAt.select(arrive);
    }

    public void selectSeatType(String seat) {
        seatType.waitForVisibility();
        seatType.select(seat);
    }

    public void selectTicketAmount(String amount) {
        ticketAmount.waitForVisibility();
        ticketAmount.select(amount);
    }

    public void bookTicket(Ticket ticket) {
        bookTicketButton.scrollToView();
        selectDepartDate(ticket.getDepartDate());
        selectDepartStation(ticket.getDepartFrom());
        selectArriveStation(ticket.getArriveAt());
        selectSeatType(ticket.getSeatType());
        selectTicketAmount(ticket.getTicketAmount());
        bookTicketButton.click();
    }

    public boolean isTheSameTicketInformationDisplayed(String option) {
        dynamicBookedTicketTable.setDynamicValue(option);
        return dynamicBookedTicketTable.isExist();
    }

    public String getBookTicketMessage() {
        return bookTicketMessage.getText();
    }

    public String getBookTicketFormTitle() {
        return bookTicketFormTitle.getText();
    }
}
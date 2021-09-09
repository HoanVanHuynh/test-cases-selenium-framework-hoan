package page_objects;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.ComboBox;
import com.logigear.control.common.imp.Label;
import common.Ticket;

public class BookTicketPage extends BasePage {

    private final ComboBox cmbDepartDate = new ComboBox("css=select[name='Date']");
    private final ComboBox cmbDepartFrom = new ComboBox("css=select[name='DepartStation']");
    private final ComboBox cmbArriveAt = new ComboBox("css=select[name='ArriveStation']");
    private final ComboBox cmbSeatType = new ComboBox("css=select[name='SeatType']");
    private final ComboBox cmbTicketAmount = new ComboBox("css=select[name='TicketAmount']");
    private final Button btnBookTicket = new Button("css=input[type='submit']");
    private final Label lblBookTicketMessage = new Label("css=div[id='content'] > h1");
    private final Label lblBookTicketFormTitle = new Label("css=form[method='post'] fieldset legend");
    private final Label dynamicBookedTicketTable = new Label("//table[@class='MyTable WideTable']/tbody//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td[text()='%s']");

    public void selectDepartDate(String date) {
        cmbDepartDate.waitForVisibility();
        cmbDepartDate.select(date);
    }

    public void selectDepartStation(String from) {
        cmbDepartFrom.waitForVisibility();
        cmbDepartFrom.select(from);
    }

    public void selectArriveStation(String arrive) {
        cmbArriveAt.waitForVisibility();
        cmbArriveAt.select(arrive);
    }

    public void selectSeatType(String seat) {
        cmbSeatType.waitForVisibility();
        cmbSeatType.select(seat);
    }

    public void selectTicketAmount(String amount) {
        cmbTicketAmount.waitForVisibility();
        cmbTicketAmount.select(amount);
    }

    public void bookTicket(Ticket ticket) {
        btnBookTicket.scrollToView();
        selectDepartDate(ticket.getDepartDate());
        selectDepartStation(ticket.getDepartFrom());
        selectArriveStation(ticket.getArriveAt());
        selectSeatType(ticket.getSeatType());
        selectTicketAmount(ticket.getTicketAmount());
        btnBookTicket.click();
    }

    public boolean isTheSameTicketInformationDisplayed(Ticket ticket) {
        dynamicBookedTicketTable.setDynamicValue(ticket.getDepartFrom(), ticket.getArriveAt(), ticket.getSeatType(), ticket.getDepartDate(), ticket.getTicketAmount());
        return dynamicBookedTicketTable.isExist();
    }

    public String getBookTicketMessage() {
        return lblBookTicketMessage.getText();
    }

    public String getBookTicketFormTitle() {
        return lblBookTicketFormTitle.getText();
    }
}
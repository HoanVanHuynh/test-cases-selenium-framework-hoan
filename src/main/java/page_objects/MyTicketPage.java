package page_objects;

import com.logigear.control.common.imp.Label;

public class MyTicketPage extends BasePage {

    private final Label dynamicManageTicketsRow = new Label("//table[@class='MyTable']/tbody//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/input[@value='Cancel']");
    private final Label manageTicketNote = new Label("css=div.message li");

    public void cancelTicket(String departStation, String arriveStation, String departDate, String ticketAmount) {
        dynamicManageTicketsRow.setDynamicValue(departStation, arriveStation, departDate, ticketAmount);
        dynamicManageTicketsRow.scrollToView();
        dynamicManageTicketsRow.click();
    }

    public String getManageTicketsNote() {
        return manageTicketNote.getText();
    }
}
package tests;

import com.logigear.driver.DriverUtils;
import common.Account;
import common.Ticket;
import helpers.DataHelper;
import helpers.DateHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.*;

public class CancelTicketTests extends BaseTest {

    private Account account = new Account();
    private RegisterPage registerPage = new RegisterPage();
    private LoginPage loginPage = new LoginPage();
    private BookTicketPage bookTicketPage = new BookTicketPage();
    private MyTicketPage myTicketPage = new MyTicketPage();
    private Ticket ticket = new Ticket();
    private String email;
    private String password;
    private String pid;

    @BeforeMethod
    public void precondition() {
        email = DataHelper.getRandomEmail();
        pid = DataHelper.getRandomDigits(10);
        password = "0123456789hochiminh";

        LogHelper.info("Set all valid register information such as email: " + email + ", password: " + password + ", confirm password: " + password + ", pid: " + pid);
        account.setEmail(email);
        account.setPassword(password);
        account.setConfirmPassword(password);
        account.setPid(pid);

        LogHelper.info("Click on Register tab");
        registerPage.clickRegisterTab();

        LogHelper.info("Register an account");
        registerPage.register(account);
    }

    @Test(description = "User can cancel a ticket")
    public void tc16_UserCanCancelTicket() {
        LogHelper.info("Click on login tab");
        loginPage.clickLoginTab();

        LogHelper.info("Login with a valid account");
        loginPage.login(email, password);

        LogHelper.info("Click on book ticket tab");
        bookTicketPage.clickBookTicketTab();

        String departDate = DateHelper.getDateFromToday(5);
        String departStation = "Sài Gòn";
        String arriveStation = "Phan Thiết";
        String ticketAmount = "2";
        String seatType = "Hard seat";

        LogHelper.info("Set all ticket information");
        ticket.setDepartDate(departDate);
        ticket.setDepartFrom(departStation);
        ticket.setArriveAt(arriveStation);
        ticket.setSeatType(seatType);
        ticket.setTicketAmount(ticketAmount);

        LogHelper.info("Book a ticket");
        bookTicketPage.bookTicket(ticket);

        LogHelper.info("Get book ticket success message after booking");
        String actualBookTicketSuccessMsg = bookTicketPage.getBookTicketMessage();
        String expectedBookTicketSuccessMsg = "Ticket Booked Successfully!";

        LogHelper.info("Verify that book ticket success message displays correctly after booking successfully");
        Assert.assertEquals(actualBookTicketSuccessMsg, expectedBookTicketSuccessMsg, "Message does not display correctly");

        LogHelper.info("Verify that ticket formation displays correctly after booking successfully such as depart station, arrive station, depart date and ticket amount");
        Assert.assertTrue(bookTicketPage.isTheSameTicketInformationDisplayed(departDate));
        Assert.assertTrue(bookTicketPage.isTheSameTicketInformationDisplayed(departStation));
        Assert.assertTrue(bookTicketPage.isTheSameTicketInformationDisplayed(arriveStation));
        Assert.assertTrue(bookTicketPage.isTheSameTicketInformationDisplayed(ticketAmount));

        LogHelper.info("Click on My ticket tab");
        myTicketPage.clickMyTicketTab();

        LogHelper.info("Get current number of booked tickets before cancelling any ticket");
        String actualBeforeCancellingResult = myTicketPage.getManageTicketsNote();
        String expectedBeforeCancellingResult = "You currently book 2 tickets, you can book 8 more.";

        LogHelper.info("Verify that number of tickets displays correctly before cancelling any ticket");
        Assert.assertEquals(actualBeforeCancellingResult, expectedBeforeCancellingResult, "Cancel ticket note is displayed incorrectly");

        LogHelper.info("Cancel a ticket");
        myTicketPage.cancelTicket(departStation, arriveStation, departDate, ticketAmount);

        LogHelper.info("Click on OK button after alert displays correctly");
        DriverUtils.acceptAlert();

        LogHelper.info("Get number of remaining tickets after cancelling any ticket");
        String actualAfterCancellingResult = myTicketPage.getManageTicketsNote();
        String expectedAfterCancellingResult = "You currently book 0 ticket, you can book 10 more.";

        LogHelper.info("Verify that the canceled ticket is disappeared.");
        Assert.assertEquals(actualAfterCancellingResult, expectedAfterCancellingResult, "Cancel ticket note is displayed incorrectly");
    }
}
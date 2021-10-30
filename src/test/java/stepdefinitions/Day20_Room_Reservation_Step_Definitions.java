package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.DefaultPage;
import pages.RoomReservationPage;

import java.util.List;

public class Day20_Room_Reservation_Step_Definitions {

    DefaultPage defaultPage = new DefaultPage();
    RoomReservationPage roomReservationPage = new RoomReservationPage();
    @Given("user navigates to the create_room_reservation page")
    public void user_navigates_to_the_create_room_reservation_page() {
        defaultPage.hotelManagementLink.click();
        defaultPage.roomReservationLink.click();

        roomReservationPage.addRoomReservationButton.click();
    }
    @Given("user enters all required fields")
    public void user_enters_all_required_fields(DataTable roomData) {

       List<String> testData =  roomData.row(1);
        System.out.println(testData);

        //idUser is a dropdown, we have to create Select object
        Select selectIdUser = new Select(roomReservationPage.idUser);
        selectIdUser.selectByVisibleText(testData.get(0));

        //idHotel is a dropdown, we have to create Select object
        Select selectIdHotel = new Select(roomReservationPage.idHotelRoom);
        selectIdHotel.selectByVisibleText(testData.get(1));

        //price
        roomReservationPage.price.sendKeys(testData.get(2));
        //dateStart
        roomReservationPage.dateStart.sendKeys(testData.get(3));
        //dateEnd
        roomReservationPage.dateEnd.sendKeys(testData.get(4));
        //adultAmount
        roomReservationPage.AdultAmount.sendKeys(testData.get(5));
        //childrenAmount
        roomReservationPage.childrenAmount.sendKeys(testData.get(6));
        //contactNameSurname
        roomReservationPage.contactNameSurname.sendKeys(testData.get(7));
        //contactPhone
        roomReservationPage.contactPhone.sendKeys(testData.get(8));
        //contactEmail
        roomReservationPage.contactEmail.sendKeys(testData.get(9));
        //notes
        roomReservationPage.notes.sendKeys(testData.get(10));

    }
    @Given("user clicks on the approved_checkbox")
    public void user_clicks_on_the_approved_checkbox() {
       roomReservationPage.isApproved.click();
    }
    @Given("user clicks on the paid_checkbox")
    public void user_clicks_on_the_paid_checkbox() {
    roomReservationPage.isPaid.click();
    }
    @Given("user clicks on the save_button")
    public void user_clicks_on_the_save_button() {
    roomReservationPage.submitButton.click();
    }
    @Then("user verifies the success_message")
    public void user_verifies_the_success_message() throws InterruptedException {
        Thread.sleep(1000);
        String successMessage = roomReservationPage.successMessage.getText();
        String expectedSuccessMessage =  "RoomReservation was inserted successfully";
        Assert.assertEquals(successMessage, expectedSuccessMessage);
        roomReservationPage.okButton.click();
    }

}

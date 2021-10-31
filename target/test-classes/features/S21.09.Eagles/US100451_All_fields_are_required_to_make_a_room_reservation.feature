#FEATURE:
#FE1009 Room Reservation
#US100451 :
#All fields are required to make a room reservation
#Description:
#As manager, I should be able to make a room reservation
#Acceptance Criteria:
#Given user is on the application page
#And user enters manager credentials
#When user clicks on the login button
#Then verify the default page is displayed
#Given user is navigates to the create room reservation page
#And enter all required fields
#And user clicks on the approved checkbox
#And user clicks on is paid check box
#And user clicks on save button
#Then user verifies the success message
#Test Data:
#Url: https://qa-environment.resortsline.com/Account/Logon
#Credentials :
#manager,Manager1!
@room_reservation
Feature: FE1009_Room_Reservation
  Scenario: TC01_user_should_login_with_manager_profile
    Given user is on the application page
    And user enters manager_id and manager_password
      |manager|Manager1!|
    When user clicks on the login button
    Then verify the "manager" is displayed
    Then take the screenshot
  Scenario: TC02_user_should_navigate_room_reservation_page
    Given user navigates to the create_room_reservation page
    Then take the screenshot
#    Sending data using DataTable in cucumber
  Scenario: TC03_user_should_book_a_reservation
    Given user enters all required fields
      |idUser |idHotelRoom|price|dateStart |dateEnd   |adultAmount|childrenAmount|contactNameSurname|contactPhone  |contactEmail  |notes    |
      |manager|Ayse       |500  |11/08/2021|11/12/2021|2          |3             |test              |(999) 999-9999|test@gmail.com|test note|
    And user clicks on the approved_checkbox
    And user clicks on the paid_checkbox
    Then take the screenshot
    And user clicks on the save_button
    Then user verifies the success_message
    Then take the screenshot
    Then close the application
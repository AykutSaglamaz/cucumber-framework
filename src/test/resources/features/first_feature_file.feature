@google_search
Feature: Google_Search_Functionality

  Background: Navigating_to_the_page
    Given user is on the google page

  @smoke @regression
  Scenario: TC01_iPhone_search
    And user search for iPhone
    Then verify the result has iPhone
    Then close the application

  @teapot @smoke @regression
  Scenario: TC02_teapot_search
    And user search for tea pot
    Then verify the result has tea pot
    Then close the application

  Scenario: TC03_flower_search
    And user search for flower
    Then verify the result has flower
    Then close the application
  @smoke @tesla
  Scenario: TC04_tesla_search
    And user search for tesla
    Then verify the result has tesla
    Then close the application
Feature: Test Search Box Functionalities

  Scenario: Check Search Box button opens up Searched Product page
    Given a user on the Home page
    When user write product name at the search box
    And user click on search button
    Then user is navigated to the search result page
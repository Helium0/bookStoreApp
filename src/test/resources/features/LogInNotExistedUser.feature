Feature: Log ins scenarios


  Scenario: Log in without any data
    Given User clicks My account on header bar
    When User doesn`t provide any data
    And Clicks on Log in button
    Then User couldn`t log in
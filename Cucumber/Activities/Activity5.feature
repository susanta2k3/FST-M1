@activity5
Feature: Login Test
  Scenario Outline:Testing Login with Example.
    Given User is on the Login Page.
    When User enters "<userName>" and "<password>" to login to the application
    Then User validates the welcome message.
    And Close the Browser after execution.

    Examples:
     |userName|password|
     |admin   |password|
     |adminUser|password|
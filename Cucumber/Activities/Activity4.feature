@activity4

  Feature:Login Test
    Scenario: Testing with Data from Scenario
      Given User is on the Login Page.
      When User enters "admin" and "password" to login to the application
      Then User validates the welcome message.
      And Close the Browser after execution.
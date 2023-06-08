@activity1
  Feature: Google Search
    @SmokeTest
    Scenario:Performing a Google Search for cheese.
      Given User is on the Google home page.
      When User types in Cheese and hits Enter
      Then Show how many search results were shown
      And Close the Browser.
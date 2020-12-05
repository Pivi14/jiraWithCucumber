Feature: edit issue
  We can edit a issue's data

  Background:
    Given go to the page
    And type the username with "user2"
    And type the password
    And click log in
    And go to the issue's page


  Scenario: Edit a issue's summary
    When click on the Edit button
    And type new "ToP" summary
    And click the update button
    Then should see the new "ToP" summary
    When click on the Edit button
    And type new "Can we edit issue? ToP" summary
    And click the update button
    Then should see the new "Can we edit issue? ToP" summary


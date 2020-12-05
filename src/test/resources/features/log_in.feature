Feature: Log in Jira
  Log in jira.codecool.canvas.hu web page

  Scenario: Log in correct username and password
    Given go to the page
    When type the username with "user2"
    And type the password
    And click log in
    And go to the profile page
    Then I should see "user2"
Feature: Log out
  We can log out and don't see the profile page.

  Background:
    Given go to the page
    And type the username with "user2"
    And type the password
    And click log in

  Scenario: Log out
    Given click profile icon in the top-right corner
    When click log out button
    Then should see "You are now logged out. Any automatic login has also been stopped."
    When go to the profile page with url
    Then should see error message with "You must log in to access this page."
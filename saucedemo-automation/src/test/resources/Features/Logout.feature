Feature: Logout
  Scenario: Successful logout
    Given  User should be login in saucedemo
    When I click burger button
    And I click logout link
    Then I go to login page
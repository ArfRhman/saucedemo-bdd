Feature: Sorting

  Scenario: choose price (low to high)
    Given User should be login in saucedemo for sorting
    When user click Name  (A to Z) in top right of page
    And user choose price (low to highr)
    Then will display list product in home page will sorting based on price low to high
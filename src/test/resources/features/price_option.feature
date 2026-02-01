Feature: Select price option

  Scenario: User selects a price option
    Given I am on the Price Option page
    When I select the "Silver" plan
    And I proceed to the Send Quote tab
    Then I should see the Send Quote form

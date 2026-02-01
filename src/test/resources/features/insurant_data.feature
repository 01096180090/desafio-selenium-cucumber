Feature: Fill insurant data form

  Scenario: User completes the Insurant Data tab
    Given I am on the Insurant Data page
    When I fill in the insurant information
    And I proceed to the Product Data tab
    Then I should see the Product Data page

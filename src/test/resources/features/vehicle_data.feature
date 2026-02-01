Feature: Fill vehicle data form

  Scenario: User completes the Vehicle Data tab
    Given I am on the Vehicle Data page
    When I fill in the vehicle information
    And I proceed to the Insurant Data tab
    Then I should see the Insurant Data form

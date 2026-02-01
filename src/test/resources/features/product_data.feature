Feature: Fill product data form

  Scenario: User completes the Product Data tab
    Given I am on the Product Data page
    When I fill in the product information
    And I proceed to the Price Option tab
    Then I should see the Price Option form

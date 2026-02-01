Feature: Send quote - error scenarios

  Scenario: User enters mismatched passwords
    Given I am on the Send Quote page
    When I fill in the send quote information with mismatched passwords
    And I send the quote
    Then I should see an error message preventing submission

Feature: Send quote

  Scenario: User completes the Send Quote tab
    Given I am on the Send Quote page
    When I fill in the send quote information
    And I send the quote
    Then I should see the success message

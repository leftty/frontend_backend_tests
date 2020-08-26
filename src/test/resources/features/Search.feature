Feature: Search product on e-commerce website
  As a user on the website
  I should be able to search for a product using different search criteria

  Background:
    Given I go to website homepage
    When I go to sign in form
    Then wait until I see "Create new account"
    And I should see "Forgot password"
    When I login with proper credentials
    Then I should see "My account"

  Scenario: User searches for product using various search criteria
    When I search for product "leather"
    Then I should see 6 results
    When I filter by category "Shoes"
    Then I should see 4 results
    When I filter by size "US 7"
    Then I should see 2 results
    When I filter by price between "24" and "25"
    Then I should see 1 result
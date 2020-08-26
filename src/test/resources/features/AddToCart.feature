Feature: Add products to cart
  As a user on the website
  I should be able to add products to the shopping cart

  Background:
    Given I go to website homepage
    When I go to sign in form
    Then wait until I see "Create new account"
    And I should see "Forgot password"
    When I login with proper credentials
    Then I should see "My account"
    When I set location to "Romania"
    And I set currency to "US Dollar"
    And I empty shopping cart


  Scenario: User adds product to cart from search page
    When I search for product "tote"
    Then I should see "Leather Mini Tote Bag"
    When I add product "Leather Mini Tote Bag" to cart from search page
    Then I should see 1 product in the shopping minicart
    And wait until I see "You have just added"
    And I should see "Leather Mini Tote Bag"
    And I should see "1 x $29.99"
    When I go to view cart
    Then I should see "Your shopping cart - 1 item"
    And I should see "Leather Mini Tote Bag"
    And I should see "Subtotal: $29.99"


  Scenario: User tries to add product to cart in quantity bigger than the available stock
    When I search for product "tote"
    Then I should see "Leather Mini Tote Bag"
    When I go "Leather Mini Tote Bag" product page
    Then I should see "Leather Mini Tote Bag"
    And I should see "Add to cart"
    When I add product to cart in quantity bigger than available stock


  Scenario: User adds product to cart from product page
    When I search for product "tote"
    Then I should see "Leather Mini Tote Bag"
    When I go "Leather Mini Tote Bag" product page
    Then I should see "Leather Mini Tote Bag"
    And I should see "Add to cart"
    When I add product to cart in quantity 2
    Then I should see "You have just added"
    And I should see "Leather Mini Tote Bag"
    And I should see "2 x $29.99"
    And I should see 2 products in the shopping minicart
    When I go to view cart
    Then I should see "Your shopping cart - 2 items"
    And I should see "Leather Mini Tote Bag"
    And I should see "Subtotal: $59.98"

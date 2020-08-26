Feature: Remove products from cart
  As a user on the website
  I should be able to remove products from the shopping cart

  Background:
    Given I go to website homepage
    When I go to sign in form
    Then wait until I see "Create new account"
    And I should see "Forgot password"
    When I login with proper credentials
    Then I should see "My account"
    When I set location to "Romania"
    And I set currency to "US Dollar"
    When I empty shopping cart


  Scenario: User removes specific product from cart
    When I search for product "tote"
    Then I should see "Leather Mini Tote Bag"
    When I add product "Leather Mini Tote Bag" to cart from search page
    Then I should see 1 product in the shopping minicart
    And wait until I see "You have just added"
    And I should see "Leather Mini Tote Bag"
    And I should see "1 x $29.99"
    When I go to view cart
    Then I should see "Your shopping cart - 1 item"
    When I remove product "Leather Mini Tote Bag" from shopping cart
    Then I should see "Your cart is empty"


  Scenario: User changes quantity of a specific product in the shopping cart page
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
    When I change quantity for product "Leather Mini Tote Bag" to 3
    Then I should see 3 products in the shopping minicart
    Then I should see "Your shopping cart - 3 items"
    And I should see "Subtotal: $89.97"
    When I change quantity for product "Leather Mini Tote Bag" to 2
    Then I should see 2 products in the shopping minicart
    Then I should see "Your shopping cart - 2 items"
    And I should see "Subtotal: $59.98"


  Scenario: User changes quantity of a specific product in the shopping cart page to 0
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
    When I change quantity for product "Leather Mini Tote Bag" to 0
    Then I should see "Minimum value is 1"
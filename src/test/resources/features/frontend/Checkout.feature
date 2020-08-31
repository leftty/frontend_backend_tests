Feature: Checkout
  As a user on the website
  I should be able to place orders on the website

  @frontend
  Scenario: New user adds shipping address in checkout with only mandatory fields
    Given I go to website homepage
    When I go to sign in form
    Then wait until I see "Create new account"
    When I go to register form
    Then I should see "New account"
    When I fill in email with proper email address
    And I fill in password same as confirm password
    And I click "Create" button
    Then I should see "The data has been saved successfully"
    And I should see "My account"
    When I set location to "Romania"
    And I set currency to "US Dollar"
    And I empty shopping cart
    When I search for product "tote"
    Then I should see "Leather Mini Tote Bag"
    When I add product "Leather Mini Tote Bag" to cart from search page
    Then I should see 1 product in the shopping minicart
    And wait until I see "You have just added"
    And I should see "Leather Mini Tote Bag"
    And I should see "1 x $29.99"
    When I go to checkout
    Then I should see "Secure Checkout"
    And I should see "Addresses"
    When I fill first name with "Dragos"
    And I fill last name with "Panzaru"
    And I fill in address with "10 Downing Street"
    And I fill in city with "Bucharest"
    And I fill in zip code with "077160"
    And I go to shipping step
    Then I should see "Delivery method"
    Then I should not see "Free shipping on orders over $50"

  @bug @frontend
  Scenario: New user adds shipping address in checkout with all fields
    Given I go to website homepage
    When I go to sign in form
    Then wait until I see "Create new account"
    When I go to register form
    Then I should see "New account"
    When I fill in email with proper email address
    And I fill in password same as confirm password
    And I click "Create" button
    Then I should see "The data has been saved successfully"
    And I should see "My account"
    When I set location to "Romania"
    And I set currency to "US Dollar"
    And I empty shopping cart
    When I search for product "tote"
    Then I should see "Leather Mini Tote Bag"
    When I add product "Leather Mini Tote Bag" to cart from search page
    Then I should see 1 product in the shopping minicart
    And wait until I see "You have just added"
    And I should see "Leather Mini Tote Bag"
    And I should see "1 x $29.99"
    When I go to checkout
    Then I should see "Secure Checkout"
    And I should see "Addresses"
    And only country and email fields should be prefilled
    When I fill first name with "Dragos"
    And I fill last name with "Panzaru"
    And I fill in address with "10 Downing Street"
    And I fill in city with "Bucharest"
    And I fill in zip code with "077160"
    And I fill in telephone with "0123456789"
    And I fill in vat number with "123456"
    And I go to shipping step
    Then I should see "Delivery Method"

  @frontend
  Scenario Outline: User place order on the website
    Given I go to website homepage
    When I go to sign in form
    Then wait until I see "Create new account"
    And I should see "Forgot password"
    When I login with proper credentials
    Then I should see "My account"
    When I set location to "Romania"
    And I set currency to "US Dollar"
    And I empty shopping cart
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
    When I go to checkout page
    Then I should see "Secure Checkout"
    And I fill in shipping info if no previous addresses exist and go to shipping step
    And I should see "Proceed to payment"
    When I select <delivery_method> delivery
    Then wait until I see "<total_cost>" as total cost
    When I go to payment step
    Then I should see "Payment method"
    And I should see "Place order"
    When I select <payment_method> payment method
    And I place order
    Then I should see "Thank you for your order"
    And I should see "Grand total: <total_cost>"
    Examples:
      | payment_method   | delivery_method | total_cost |
      | paypal           | free shipping   | $59.98     |
      | phone ordering   | courier         | $66.53     |
      | credit card      | local shipping  | $67.59     |
      | cash on delivery | local pickup    | $59.98     |

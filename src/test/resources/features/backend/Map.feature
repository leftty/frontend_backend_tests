Feature: Create map
  As an API user
  I should be able create maps

  @backend
  Scenario: User creates new map
    When I make proper post request on the create map endpoint
    Then response status code should be 200
    And response body should have following fields
      | Path | Field   |
      | $    | id      |
    And following response body fields should have values
      | Path    | Value |
      | folder  | null  |
      | success | true  |
    When I make get request for the newly created map
    Then response status code should be 200
    And I should see id of newly created map in response body
    And following response body fields should have values
      | Path  | Value    |
      | owner | leftty86 |

  @backend
  Scenario: User tries to create a new map using invalid api key
    When I make post request on the create map endpoint over http
    Then response status code should be 200
    And following response body fields should have values
      | Path          | Value                     |
      | error.code    | 403                       |
      | error.message | Request not made over ssl |

  @backend
  Scenario: User tries to create a new map over http
    When I make post request on the create map endpoint with invalid key
    Then response status code should be 200
    And following response body fields should have values
      | Path          | Value          |
      | error.code    | 498            |
      | error.message | Invalid token. |

  @backend
  Scenario: User deletes map
    When I make proper post request on the create map endpoint
    Then response status code should be 200
    When I mark newly created map for deletion
    Then response status code should be 200
    And response body should have following fields
      | Path | Field   |
      | $    | itemId  |
    And following response body fields should have values
      | Path    | Value |
      | success | true  |
    Then response status code should be 200
    When I make delete request for the newly created map
    Then response status code should be 200
    And response body should have following fields
      | Path | Field   |
      | $    | itemId  |
    And following response body fields should have values
      | Path    | Value |
      | success | true  |
    When I make get request for the newly created map
    Then response status code should be 200
    And following response body fields should have values
      | Path              | Value                                   |
      | error.code        | 400                                     |
      | error.messageCode | CONT_0001                               |
      | error.message     | Item does not exist or is inaccessible. |


  @frontend
  Scenario: User tries to add product to cart in quantity bigger than the available stock
    When I search for product "tote"
    Then I should see "Leather Mini Tote Bag"
    When I go "Leather Mini Tote Bag" product page
    Then I should see "Leather Mini Tote Bag"
    And I should see "Add to cart"
    When I add product to cart in quantity bigger than available stock

  @frontend
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

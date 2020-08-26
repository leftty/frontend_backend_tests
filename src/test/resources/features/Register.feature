Feature: Register user
  As a visitor on the website
  I should be able to register a new account


  Scenario: Visitor creates new account
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


  Scenario: Visitor tries to create new account password confirmation different than the original password
    Given I go to website homepage
    When I go to sign in form
    Then wait until I see "Create new account"
    When I go to register form
    Then I should see "New account"
    When I fill in email with proper email address
    And I fill in password different than confirm password
    And I click "Create" button
    Then I should see "Personal info: Password and its confirmation do not match"


  Scenario: Visitor tries to create new account without password
    Given I go to website homepage
    When I go to sign in form
    Then wait until I see "Create new account"
    When I go to register form
    Then I should see "New account"
    When I fill in email with proper email address
    And I click "Create" button
    Then I should see error message "This field is required" under the password field
    And I should see error message "This field is required" under the password confirmation field


  Scenario: Visitor tries to create new account without email address
    Given I go to website homepage
    When I go to sign in form
    Then wait until I see "Create new account"
    When I go to register form
    Then I should see "New account"
    And I fill in password same as confirm password
    And I click "Create" button
    Then I should see error message "This field is required" under the email field


  Scenario: Visitor tries to create new account using improper email address
    Given I go to website homepage
    When I go to sign in form
    Then wait until I see "Create new account"
    When I go to register form
    Then I should see "New account"
    When I fill in email with improper email address
    And I fill in password same as confirm password
    And I click "Create" button
    Then I should see error message "Invalid email address" under the email field
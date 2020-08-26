Feature: Login to e-commerce website
  As a user on the website
  I should be able to login using my account credentials

  @frontend
  Scenario: User logs in with correct credentials
    Given I go to website homepage
    When I go to sign in form
    Then wait until I see "Create new account"
    And I should see "Forgot password"
    When I login with proper credentials
    Then I should see "My account"

  @bug @frontend
  Scenario: User tries to log in with incorrect credentials
    Given I go to website homepage
    When I go to sign in form
    Then wait until I see "Create new account"
    And I should see "Forgot password"
    When I login with incorrect credentials
    Then I should see "Invalid login or password."
    Then I should see "You can use the 'Forgot password?' link to reset your password."
    When I close sign in form
    And I go to sign in form
    Then sign in form should be cleared

  @bug @frontend
  Scenario: User tries to log in with no credentials
    Given I go to website homepage
    When I go to sign in form
    Then wait until I see "Create new account"
    And I should see "Forgot password"
    When I login with no credentials
    Then I should see "This field is required" under the email field
    Then I should see "This field is required" under the password field
    When I close sign in form
    And I go to sign in form
    Then sign in form should be cleared

  @bug
  Scenario: User tries to log in with only email address
    Given I go to website homepage
    When I go to sign in form
    Then wait until I see "Create new account"
    And I should see "Forgot password"
    When I login with only the email address
    Then I should see "This field is required" under the password field
    When I close sign in form
    And I go to sign in form
    Then sign in form should be cleared

  @bug @frontend
  Scenario: User tries to log in with only the password
    Given I go to website homepage
    When I go to sign in form
    Then wait until I see "Create new account"
    And I should see "Forgot password"
    When I login with only the password
    Then I should see "This field is required" under the email field
    When I close sign in form
    And I go to sign in form
    Then sign in form should be cleared

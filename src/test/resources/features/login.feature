Feature: Login

  Scenario: Valid user logs in
    Given I am on the login page
    When I login with "standard_user" and "secret_sauce"
    Then I should see the products page

  Scenario: Locked user sees an error
    Given I am on the login page
    When I login with "locked_out_user" and "secret_sauce"
    Then I should see the error "locked out"
    
      Scenario: Add backpack to cart
    Given I am on the login page
    When I login with "standard_user" and "secret_sauce"
    And I add the product "Backpack" to the cart
    Then the cart badge should show "1"
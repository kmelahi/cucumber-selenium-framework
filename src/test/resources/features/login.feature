@smoke
Feature: Login
# Just adding a comment here
  Scenario: Valid user can login
    Given I am on the login page
    When I login with username "standard_user" and password "secret_sauce"
    Then I should see the home page

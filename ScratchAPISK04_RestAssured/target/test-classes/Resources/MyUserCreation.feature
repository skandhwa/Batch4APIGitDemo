@sanity
Feature: Creation of New user for reqres

  Scenario Outline: To Create a new User for a demo site
    Given User will hit a specific URL on reqres site
    And User will pass the payload and header in the request specified
    When the user is going to hit the "<endpoint>"
    Then the User is going to validate the response with the status code as "<status_code>"

    Examples: 
      | endpoint  | status_code |
      | api/users |         201 |

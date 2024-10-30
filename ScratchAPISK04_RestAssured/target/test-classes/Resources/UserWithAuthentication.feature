@sanity


Feature: Creation of User with Authentication token

  Scenario Outline: New User Creation with token
    Given User hits an application url
    And the User passes the payload with all required details
    When the User will hit the url with the "<endpoint>"
    Then the User will be able to validate the reponse with a specific status code

    Examples: 
      | endpoint        |
      | public/v2/users |

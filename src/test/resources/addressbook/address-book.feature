Feature: Address Book
  Keep personal addresses at one place.

  Scenario: Add new address
    Given a new address
    When I save the given address
    Then I should get the ID of newly created address

  Scenario: Change an existing address
    Given an existing address with a street name
    When I change the street name and save it
    Then I get the changed address which has the changed street name

  Scenario Outline: Change the house number of an existing address
    Given an existing address with house number "<houseNo>"
    When I change the houseNo and save it
    Then I get the changed address with houseNo "<answer>"

    Examples:
      | houseNo                    | answer              |
      | 12                         | 12                  |
      | 12 B                       | 12b                 |
      | -13                        | 13                  |
      | 9,223,372,036,854,775,807  | 9223372036854775807 |
      | -9,223,372,036,854,775,808 | 9223372036854775808 |

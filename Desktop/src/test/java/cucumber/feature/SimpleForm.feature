Feature: Show a message and get total
  Scenario: Show a message
    Given User is on Home Page
    When User inputs a message
        | msg      |
        | thanhnd1 |
        | thanhnd2 |
        | thanhnd3 |


#  Scenario: Get total of 2 number
#    Given User is on Home Page
#    When User inputs value for a and b
#    And Click to the Get Total button
#    Then Result of a and b is displayed on Home Page
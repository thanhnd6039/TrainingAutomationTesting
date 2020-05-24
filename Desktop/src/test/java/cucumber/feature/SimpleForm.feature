Feature: Show a message and get total
  Scenario: Show a message
    Given User is on Home Page
    When User inputs "thanhnd3"
    And Click to the Show Message button
    Then Message is displayed on Home Page

#  Scenario: Get total of 2 number
#    Given User is on Home Page
#    When User inputs value for a and b
#    And Click to the Get Total button
#    Then Result of a and b is displayed on Home Page
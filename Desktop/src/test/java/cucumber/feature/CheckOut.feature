Feature: Check out
  Description: This purpose of this feature is to check out a product that user added to cart
  Scenario: Customer place an order by purchasing an item from search
    Given User is on home page
    When He searches for dress
    And Choose to buy the first item
    And Move to checkout form mini cart
    And Fill personal details on checkout page
    And Place an order
    Then Show a message successful order

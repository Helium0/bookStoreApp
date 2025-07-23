Feature: test

  Scenario: User adds book to cart and proceed payment
    Given User checks if logged on correct website
    Then User search How to Do Chemical Tricks book and add to cart
    And User checks how many books in cart: 1
    And User go to checkout
    And Card
    And Fill



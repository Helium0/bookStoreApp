Feature: User adds book and pay with card

  Scenario: User adds book to cart and proceed payment
    Given User checks if logged on correct website
    Then User search How to Do Chemical Tricks book and add to cart
    And User checks how many books in cart: 1
    When User go to checkout
    And User sets name: Patryk and surname: Prentki
    And User sets address details: Orzechowa 60-666 Ostro
    And User sets contact details: 666666666 patrykTest@gmail.com
    And User sets country Peru
    And User sets state Ica
    And User wants to pay with Mastercard
    And User fills card details and place order
    Then User successfully placed order
    And Checks order in DB




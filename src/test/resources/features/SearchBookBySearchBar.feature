Feature: Log ins scenarios


  Scenario: User finds book by search bar and proceed to buy it
    Given User searchs book title: Calculus Made Easy
    When User set book quantity in to 5 and add to cart
    And User clicks View cart
    And User checks Price for single book 13,00
    And User checks Subtotal for all books 65,00
    And User proceed to go checkout
    And User sets name: Patryk and surname: Prentki
    And User sets address details: Orzechowa 60-666 Ostro
    And User sets contact details: 666666666 patrykTest@gmail.com
    And User sets country Peru
    And User sets state Ica
    And User wants to pay with Visa
    And User fills card details and place order
    Then User successfully placed order
    And Order in DB should contains title: Calculus Made Easy by Silvanus P. Thompson

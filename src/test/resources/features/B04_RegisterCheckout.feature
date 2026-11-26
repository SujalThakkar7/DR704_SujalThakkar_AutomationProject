Feature: Complete Checkout 

Scenario: Register user and place an order 
Given I am on the Products page
When I search for "Blue Top" 
And I add Blue Top to the cart
And I open the cart
And I proceed to checkout
And I register a new practice account 
And I complete the checkout details 
And I place the order with dummy payment details 
Then I should see the order confirmation 


Feature: Guest Checkout 

Scenario: Verify guest user is asked to Register or Login 
Given I am on the Products page
When I search for "Blue Top" 
And I add Blue Top to the cart
And I open the cart
And I proceed to checkout 
Then I should see the Register Login prompt 

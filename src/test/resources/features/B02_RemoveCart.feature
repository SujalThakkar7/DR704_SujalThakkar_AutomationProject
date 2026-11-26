Feature: Remove Product from cart

Scenario: Remove Blue Top from cart 
Given I am on the Products page
When I search for "Blue Top" 
And I add Blue Top to the cart 
And I open the cart 
And I remove Blue Top from the cart 
Then Blue Top should not be displayed in the cart 
And the cart should be empty 

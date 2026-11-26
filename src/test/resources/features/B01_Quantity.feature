Feature: Add product with specific quantity

@smoke
Scenario: Add two Blue Top products to cart 
Given I am on the Products page 
When I search for "Blue Top" 
And I open the Blue Top product details 
And I set the product quantity to 2 
And I add the product to the cart 
Then I should see "Blue Top" in the cart
And the product quantity should be 2	
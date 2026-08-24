Feature: 

@AddToCart
Scenario: Add Products To The Cart Multiple Quantity 
	Given User is on GreenKart landing page
	When User searched with partial text Tomato and extracted the product in the Home page
	Then Add quantity 4 for the searched product
	And Verify the Product Name and Quantity in the Product Page
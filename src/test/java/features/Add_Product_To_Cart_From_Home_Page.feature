Feature: Adding Products To The Cart 

@PlaceOrder
Scenario Outline: Add Products To The Cart From Landing Page 
	Given User is on GreenKart landing page
	When Add product <Product1>, <Product2>, <Product3> to the cart
	Then Navigate to the cart from Landing page and proceed to checkout
	And Place the order without any coupon code for <country>
	
	Examples:
		|Product1|Product2|Product3|country|
		|Tomato|Brocolli|Cashews|India|
	
	
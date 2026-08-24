Feature: Search and Place the order for Products

@PlaceOrder
Scenario Outline: Search experience for Home page and Offers page.
	Given User is on GreenKart landing page
	When User searched with partial text <Name> and extracted the product in the Home page
	Then User seached with same name <Name> in the offers page and validated the product exists
	Examples:
		|Name|
		|Tom|
		|Beet|
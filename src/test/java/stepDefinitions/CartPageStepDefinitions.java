package stepDefinitions;


import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPageObjects;
import utils.TestContextSetup;

public class CartPageStepDefinitions {
	public TestContextSetup testContextSetup;
	public CartPageObjects cartPageObjects;
	public CartPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.cartPageObjects = testContextSetup.pageObjectsManager.getCartPage();
	}
	
	@Then("Verify the Product Name and Quantity in the Product Page")
	public void verify_the_product_name_and_quantity_in_the_product_page() {
		cartPageObjects.navigateToCart();
		String cartFirstProductName = cartPageObjects.getCartFirstProductName();
		int cartFirstProductQuantity = cartPageObjects.getCartFirstProductQuantity();
		Assert.assertEquals(testContextSetup.homePageResult, cartFirstProductName);
		Assert.assertEquals(testContextSetup.landingPageQuantity, cartFirstProductQuantity);
	}
	
	@Then("Navigate to the cart from Landing page and proceed to checkout")
	public void navigate_to_the_cart_from_landing_page_and_proceed_to_checkout() {
		cartPageObjects.navigateToCart();
		cartPageObjects.proceedToCheckOut();
	}
	@Then("^Place the order without any coupon code for (.+)$")
	public void place_the_order_without_any_coupon_code(String country) throws InterruptedException {
		Thread.sleep(1000);
		cartPageObjects.placeOrderToEnterAdress();
		cartPageObjects.selectCountryInPlaceOrder(country);
		cartPageObjects.agreeTCAndProceed();
	}
}

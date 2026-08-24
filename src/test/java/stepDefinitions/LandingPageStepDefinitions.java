package stepDefinitions;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPageObjects;
import utils.TestContextSetup;

public class LandingPageStepDefinitions {
	public TestContextSetup testContextSetup;
	public LandingPageObjects landingPageObjects;
	public String partialText;
	
    public LandingPageStepDefinitions(TestContextSetup testContextSetup)
    {
    	this.testContextSetup = testContextSetup;
    	this.landingPageObjects = testContextSetup.pageObjectsManager.getLandingPage();
    }
    
    @Given("User is on GreenKart landing page")
    public void user_is_on_green_kart_landing_page() {
    	System.out.println("Browser opened");
    }   
    
    @When("^User searched with partial text (.+) and extracted the product in the Home page$")
    public void user_searched_with_partial_tex_and_extracted_the_product_in_the_home_page(String partialText) throws InterruptedException {
		landingPageObjects.searchItem(partialText);
        Thread.sleep(2000); 
        testContextSetup.homePageResult = landingPageObjects.getProductName().split("-")[0].trim();
        System.out.println("Home Page Product: " + testContextSetup.homePageResult);
    }
    
    @Then("Add quantity {int} for the searched product")
    public void add_quantity_for_the_searched_product(int quantity) throws InterruptedException { 
    	testContextSetup.landingPageQuantity = quantity;
    	int i = testContextSetup.landingPageQuantity;
    	while(i - 1 > 0) { 
    		landingPageObjects.addIncrement();
    		i--;
    	}
    	landingPageObjects.addProductToCart();
    }
    
    @When("^Add product (.+), (.+), (.+) to the cart$")
	public void add_product_tomato_cashews_banana_to_the_cart(String product1, String product2, String product3) {
    	landingPageObjects.addProductFromHomePage(product1);
    	landingPageObjects.addProductFromHomePage(product2);
    	landingPageObjects.addProductFromHomePage(product3);
	}
}
package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.OffersPageObjects;
import utils.TestContextSetup;

public class OffersPageStepDefinitions {
	public String offerPageResult;
	public TestContextSetup testContextSetup;
	public OffersPageObjects offerPageObjects;
	public OffersPageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		this.offerPageObjects = testContextSetup.pageObjectsManager.getOffersPage();
	}
	
    @Then("^User seached with same name (.+) in the offers page and validated the product exists$")
    public void user_seached_with_same_name_in_the_offers_page_and_validated_the_product_exists(String partialText) {
    	offerPageObjects.navigate_to_TopDeals_Page();
    	testContextSetup.genericUtils.switch_to_child_window();
    	offerPageObjects.searchItem(partialText);
        offerPageResult = offerPageObjects.getProductName().trim();
        
        Assert.assertEquals(testContextSetup.homePageResult, offerPageResult);
        System.out.println("Offer Page Product: " + offerPageResult);
    }
}
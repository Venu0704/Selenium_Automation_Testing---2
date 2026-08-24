package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectsManager {
	public WebDriver driver;
	public LandingPageObjects landingPageObjects;
	public OffersPageObjects offersPageObjects;
	public CartPageObjects cartPageObjects;
	
	public PageObjectsManager(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public LandingPageObjects getLandingPage()
	{
		landingPageObjects = new LandingPageObjects(driver);
		return landingPageObjects;
	}
	
	public OffersPageObjects getOffersPage()
	{
		offersPageObjects = new OffersPageObjects(driver);
		return offersPageObjects;
	}
	
	public CartPageObjects getCartPage() {
		cartPageObjects = new CartPageObjects(driver);
		return cartPageObjects;
	}
}

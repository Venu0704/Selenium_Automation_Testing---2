package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPageObjects {
	public WebDriver driver;
	public OffersPageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	By search_field = By.xpath("//input[@id='search-field']");
	By first_row_result = By.cssSelector("tr td:nth-child(1)");
	By top_deals_button = By.linkText("Top Deals");
	
	public void navigate_to_TopDeals_Page() 
	{
		if(driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/"))
		{
			driver.findElement(top_deals_button).click();
		}
		else
		{
			driver.close();
			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
			driver.findElement(top_deals_button).click();
		}
	}
	
	public void searchItem(String item) {
		driver.findElement(search_field).sendKeys(item);
	} 
	
	public String getProductName() {
		return driver.findElement(first_row_result).getText();
	}
}

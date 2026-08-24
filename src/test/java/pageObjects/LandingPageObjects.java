package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPageObjects {
	public WebDriver driver;
	public LandingPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	By searchField = By.xpath("//input[@placeholder='Search for Vegetables and Fruits']");
	By resultProductName = By.cssSelector("h4.product-name");
	By first_product_increment_button = By.xpath("//a[text() = '+']");
	By add_to_cart = By.xpath("//button[text()='ADD TO CART']");
	
	public void searchItem(String item) {
		driver.findElement(searchField).sendKeys(item);
	}
	
	public String getProductName() {
		return driver.findElement(resultProductName).getText();
	}
	
	public void addIncrement() {
		driver.findElement(first_product_increment_button).click();
	}
	
	public void addProductToCart() {
		driver.findElement(add_to_cart).click();
	}
	
	public void addProductFromHomePage(String productName) {
	    String dynamicXPath = String.format("//h4[contains(text(),'%s')]/parent::div//button[text()='ADD TO CART']", productName);
	    driver.findElement(By.xpath(dynamicXPath)).click();
	}
}

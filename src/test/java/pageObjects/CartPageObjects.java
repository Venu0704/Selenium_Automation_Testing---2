package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartPageObjects {
	public WebDriver driver;
	public CartPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	By cart = By.xpath("//img[@alt='Cart']");
	By cart_first_product = By.xpath("//div[@class='cart-preview active']//p[@class='product-name']");
	By cart_first_product_quantity = By.xpath("//div[@class='cart-preview active']//div[@class='product-total']//p[@class='quantity']");
	By proceed_to_check_out_button = By.xpath("//button[text() = 'PROCEED TO CHECKOUT']");
	By place_order_button = By.xpath("//button[text() = 'Place Order']");
	By agreeTermAndConditions = By.xpath("//input[@type='checkbox']");
	By orderProceedButton = By.xpath("//button[text() = 'Proceed']");
	
	public void navigateToCart() {
		driver.findElement(cart).click();
	}
	public String getCartFirstProductName() {
		return driver.findElement(cart_first_product).getText().split("-")[0].trim();
	} 
	
	public int getCartFirstProductQuantity() {
		String qua = driver.findElement(cart_first_product_quantity).getText().replace("Nos.", "").trim();
		int quantity = Integer.parseInt(qua);
		return quantity;
	}
	
	public void proceedToCheckOut()
	{
		driver.findElement(proceed_to_check_out_button).click();
	}
	
	public void placeOrderToEnterAdress() {
		driver.findElement(place_order_button).click();
	}
	
	public void selectCountryInPlaceOrder(String country) {
		WebElement staticDropdown = driver.findElement(By.tagName("select"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText(country);
	}
	
	public void agreeTCAndProceed() {
		driver.findElement(agreeTermAndConditions).click();
		driver.findElement(orderProceedButton).click();
	}
}

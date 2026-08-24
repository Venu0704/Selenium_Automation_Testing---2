package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void switch_to_child_window() {
		Set<String> windows = driver.getWindowHandles();
        Iterator<String> i1 = windows.iterator();
        String parentWindow = i1.next();
        String childwindow = i1.next();
        
        driver.switchTo().window(childwindow);
	}
}

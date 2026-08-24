package stepDefinitions;


import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import utils.TestContextSetup;

public class Hooks {
	public TestContextSetup testContextSetup;
	// PicoContainer will inject TestContextSetup here
    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }
	@After
	public void quitBrowser() throws IOException {
		testContextSetup.testBase.WebDriverManager().quit();
		System.out.println("Browser closed");
	}
}

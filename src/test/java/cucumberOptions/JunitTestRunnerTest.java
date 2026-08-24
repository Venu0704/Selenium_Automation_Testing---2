package cucumberOptions;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/java/features",
	    glue = "stepDefinitions",
	    monochrome = true,
	    dryRun = false,
	    plugin = {"html:target/cucumber.html", "json:target/cucumber.json",
	    		 "rerun:target/failed_scenarios.txt"}, //rerun plugin is used for getting the failed scenario's in a txt document
	    tags = "@PlaceOrder" //Multiple tags (tags = "Placeholder or OrderPage") it will run scenario's with both placeholder and order page
	)

public class JunitTestRunnerTest {
	
}
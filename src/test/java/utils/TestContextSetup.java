package utils;

import java.io.IOException;

import pageObjects.PageObjectsManager;
import stepDefinitions.Hooks;

public class TestContextSetup {
    public String homePageResult;
    public int landingPageQuantity;
    public TestBase testBase;
    public PageObjectsManager pageObjectsManager;
    public GenericUtils genericUtils;
    
    public TestContextSetup(TestBase testBase) throws IOException
    {
    	this.testBase = testBase;// injected by Pico
    	this.pageObjectsManager = new PageObjectsManager(testBase.WebDriverManager());
    	this.genericUtils = new GenericUtils(testBase.WebDriverManager());
    }
}

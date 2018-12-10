package com.redbus.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.framework.common.ConfigurationProperties;
import com.framework.common.WebDriverFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Master {

	
	public static WebDriver driver;
	ConfigurationProperties configs = new ConfigurationProperties();
	
	@Before
	public void openBrowser(){
		WebDriverFactory factory = new WebDriverFactory();
		driver = factory.getDriver();
		driver.get(configs.getProperty(ConfigurationProperties.SITE_URL));
		driver.manage().window().maximize();
		System.out.println("=========Test Execution Started=================");
	}
	
	@After
	public void closeBrowser(){
		driver.quit();
		System.out.println("=========Test Execution Completed=================");
		
	}
}

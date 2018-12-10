package com.framework.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWrapper {
	WebDriver driver;
	public WebDriverWrapper(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForElementToBeDisplayed(final WebElement element, int timeOutPeriod) {
		WebDriverWait webDriverWait = new WebDriverWait(driver,timeOutPeriod);
		webDriverWait.until(ExpectedConditions.visibilityOf(element));
		
	}
}


package com.redbus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.framework.common.WebDriverWrapper;

public class SearchPage extends LoadableComponent<SearchPage> {
	WebDriver driver;
	int timeOutPeriod = 10;
	WebDriverWrapper wrapper;

	@FindBy(xpath = "//*[@id='fixer']/div/div[1]/div[2]/div[2]")
	WebElement btnModify;

	@FindBy(xpath = "//*[@id='10441710']/div/div[2]/div[1]")
	WebElement btnViewSeat;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public boolean verifySearchPage() {

		if (btnModify.isDisplayed()) {

			return true;
		}
		return false;

	}

	public void clickViewSeat(){
		WebDriverWrapper wrapper = new WebDriverWrapper(driver);
		wrapper.waitForElementToBeDisplayed(btnViewSeat, timeOutPeriod);
		btnViewSeat.click();
	}
	
	@Override
	protected void isLoaded() throws Error {

	}

	@Override
	protected void load() {

	}

}

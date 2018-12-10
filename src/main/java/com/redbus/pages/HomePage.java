package com.redbus.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.framework.common.WebDriverWrapper;

public class HomePage extends LoadableComponent<HomePage> {

	WebDriver driver;
	int timeOutPeriod = 10;
	WebDriverWrapper wrapper;

	@FindBy(xpath = "//input[@id='src']")
	WebElement txtSourceCity;

	@FindBy(xpath = "//input[@id='dest']")
	WebElement txtDestinationCity;

	@FindBy(xpath = "//*[@id='search']/div/div[3]/div/label")
	WebElement lblOnwardJourney;

	@FindBy(xpath = "//*[@id='search']/div/div[4]/div/label")
	WebElement lblReturnJourney;

	@FindBy(xpath = "//div[@id='rb-calendar_onward_cal']")
	WebElement lblOnwardJourneyCalender;

	@FindBy(xpath = "//div[@id='rb-calendar_return_cal']")
	WebElement lblReturnJourneyCalender;

	@FindBy(xpath = "//button[@id='search_btn']")
	WebElement btnSearchBuses;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomePage() {

		if (txtSourceCity.isDisplayed() && txtDestinationCity.isDisplayed()) {

			return true;
		}

		return false;
	}

	public void selectJourneyDetails(String srcCity, String destCity) throws InterruptedException {
		wrapper = new WebDriverWrapper(driver);
		wrapper.waitForElementToBeDisplayed(txtSourceCity, timeOutPeriod);
		txtSourceCity.sendKeys(srcCity);
		Thread.sleep(1000);
		txtSourceCity.sendKeys(Keys.TAB);
		wrapper.waitForElementToBeDisplayed(txtDestinationCity, timeOutPeriod);
		txtDestinationCity.sendKeys(destCity);
		Thread.sleep(1000);
		txtDestinationCity.sendKeys(Keys.TAB);

	}

	public void selectFromDate(String fromDate) throws ParseException {

		lblOnwardJourney.click();
		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = format.parse(fromDate);

		SimpleDateFormat formatFromDate = new SimpleDateFormat("dd");
		String selectFromDate = formatFromDate.format(date);

		List<WebElement> dates = lblOnwardJourneyCalender.findElements(By
				.tagName("td"));

		for (WebElement eachDate : dates) {

			if (eachDate.getText().equals(selectFromDate)) {
				eachDate.click();
				break;
			}
		}

	}

	public void selectToDate(String toDate) throws ParseException, InterruptedException {

		lblReturnJourney.click();
		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = format.parse(toDate);

		SimpleDateFormat formatFromDate = new SimpleDateFormat("dd");
		String selectToDate = formatFromDate.format(date);

		List<WebElement> dates = lblReturnJourneyCalender.findElements(By
				.tagName("td"));

		for (WebElement eachDate1 : dates) {

			if (eachDate1.getText().equals(selectToDate)) {
				eachDate1.click();
				break;
			}
		}
		wrapper = new WebDriverWrapper(driver);
		wrapper.waitForElementToBeDisplayed(btnSearchBuses, timeOutPeriod);
		btnSearchBuses.click();
		Thread.sleep(2000);

	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub

	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub

	}

}

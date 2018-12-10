package com.redbus.stepDefinitions;

import org.junit.Assert;

import com.redbus.pages.HomePage;
import com.redbus.pages.SearchPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDefinitions {
	HomePage homePage;
	SearchPage searchPage;

	@Given("^I am on red bus application home page$")
	public void i_am_on_red_bus_application_home_page() throws Throwable {

		homePage = new HomePage(Master.driver);
		Assert.assertEquals(true, homePage.verifyHomePage());

	}

	@When("^I input source\"([^\"]*)\" as well as  destination \"([^\"]*)\" cities$")
	public void i_input_source_as_well_as_destination_cities(String srcCity,
			String destCity) throws Throwable {
		homePage.selectJourneyDetails(srcCity, destCity);

	}

	@When("^I select journey dates from \"([^\"]*)\" to \"([^\"]*)\"and click on search button$")
	public void i_select_journey_dates_from_to_and_click_on_search_button(
			String fromDate, String toDate) throws Throwable {
		homePage = new HomePage(Master.driver);
		homePage.selectFromDate(fromDate);
		homePage.selectToDate(toDate);
		
	}

	@Then("^I navigated to search results page and see the available buses$")
	public void i_navigated_to_search_results_page_and_see_the_available_buses()
			throws Throwable {
		searchPage = new SearchPage(Master.driver);
		Assert.assertEquals(true, searchPage.verifySearchPage());

	}

	@Then("^I click on view seat$")
	public void i_click_on_view_seat() throws Throwable {
		searchPage.clickViewSeat();
		
	}
}

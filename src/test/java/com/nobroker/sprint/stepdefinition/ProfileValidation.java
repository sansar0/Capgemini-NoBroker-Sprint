package com.nobroker.sprint.stepdefinition;

import org.testng.Assert;

import com.nobroker.sprint.utils.AllUtilities;
import com.nobroker.sprint.utils.BaseClass;
import com.nobroker.sprint.utils.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileValidation extends AllUtilities {
	private BaseClass b;
	public ProfileValidation(BaseClass b) {
		this.b=b;
		this.driver=b.driver;
	}

	@Given("the user has successfully logged into the application")
	public void the_user_has_successfully_logged_into_the_application() {
		Assert.assertTrue(FetchApplicationUrl().contains("nobroker.in"), "Login was not successful or URL mismatch.");
	}

	@When("the user navigates to the Profile page")
	public void the_user_navigates_to_the_profile_page() {
		Pages.dashpage.GotoProfile(driver);
	}

	@When("the user updates the profile name to {string}")
	public void the_user_updates_the_profile_name_to(String newName) {
		Pages.profilepage.setupUserName(newName);
	}

	@When("the user refreshes the current page")
	public void the_user_refreshes_the_current_page() {
		RefreshCurrentpage();
	}

	@Then("the profile name should be displayed as {string}")
	public void the_profile_name_should_be_displayed_as(String expectedName) {
		String actualName = Pages.profilepage.getUserName().getAttribute("value");
		Assert.assertEquals(actualName, expectedName, "Profile name did not persist after refresh!");
	}
}

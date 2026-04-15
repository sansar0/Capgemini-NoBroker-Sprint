package com.nobroker.sprint.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	// Locating the City Drop down
	@FindBy(id = "searchCity")
	private WebElement cityDropdown;

	// Locating the Search btn
	@FindBy(xpath = "//button[contains(@class, 'prop-search-button')]")
	private WebElement SearchBtn;

	// Locating of Login WebElement
	@FindBy(xpath = "//div[contains(text(),'Log in')]")
	private WebElement Login;

	// Locating the Mobile Number Field
	@FindBy(css = "[type='tel']")
	private WebElement MobileNumber;

	// Locating Continue Btn
	@FindBy(id = "signUpSubmit")
	private WebElement continueButton;

	// Locating N Icon
	@FindBy(xpath = "//p[text()='New']")
	private WebElement NewIcon;

	// locating ProfileImg
	@FindBy(xpath = "//div[@id='profile-icon']//img")
	private WebElement ProfileImg;

	// Locating Profile feature
	@FindBy(xpath = "//div[@id='profile-menu-dropdown']//a[contains(.,'Profile')]")
	private WebElement ProfileFeature;

	// getters For WebElements
	public WebElement getCityDropdown() {
		return cityDropdown;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebElement getLogin() {
		return Login;
	}

	public WebElement getMobileNumber() {
		return MobileNumber;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getNewIcon() {
		return NewIcon;
	}

	public WebElement getProfileImg() {
		return ProfileImg;
	}

	public WebElement getProfileFeature() {
		return ProfileFeature;
	}

	// after OTP, click continue
	public void clickContinueAfterOTP(WebDriver driver) {
		// using an Explicit Wait to ensure the button is clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
	}

	public void selectCityWithDropdown(String cityName, WebDriver driver) {
		// Click the dropdown to get list of city
		cityDropdown.click();
		// dynamic XPath using the city name
		String cityXpath = "//div[contains(@class, 'nb-select__menu')]//div[text()='" + cityName + "']";
		// click that specific city
		driver.findElement(By.xpath(cityXpath)).click();
	}

	// Login Into Application
	public void LoginIn(WebDriver driver, String MobileNo) {
		getLogin().click();
		getMobileNumber().sendKeys(MobileNo);
		clickContinueAfterOTP(driver);
	}

	public void clickNewIcon(WebDriver driver) {
		// using an Explicit Wait to click new icon because webpage needs to refresh the page
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(getNewIcon())).click();
	}

	public void GotoProfile(WebDriver driver) {
		// using explicit wait because profile clicking is hovering part
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(getProfileImg())).click();
		wait.until(ExpectedConditions.elementToBeClickable(getProfileFeature())).click();
	}
}

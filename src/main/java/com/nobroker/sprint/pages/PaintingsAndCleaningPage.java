package com.nobroker.sprint.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaintingsAndCleaningPage {
	
	//locating Select your city field
	@FindBy(xpath = "//span[text()='Select Your City']")
	private WebElement SelectYourCity;
	
	//locating Interior and Renovation in web page
	@FindBy(xpath = "//div[text()='Interior and Renovation']/preceding-sibling::div")
	private WebElement InteriorRenovationField;
	
	//Locating Home interiors 
	@FindBy(xpath = "//div[text()='Home Interiors']")
	private WebElement HomeInteriors;

	// getter for all web element
	public WebElement getInteriorRenovationField() {
		return InteriorRenovationField;
	}

	public WebElement getHomeInteriors() {
		return HomeInteriors;
	}
	
	public WebElement getSelectYourCity() {
		return SelectYourCity;
	}
	
	public void SelectingCity(WebDriver driver, String cityname) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(getSelectYourCity()));
		driver.findElement(By.xpath("//img/following-sibling::div[contains(.,'"+cityname+"')]")).click();
	}
	
	public void SelectingHomeServices(WebDriver driver) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(getInteriorRenovationField())).click();
		wait.until(ExpectedConditions.elementToBeClickable(getHomeInteriors())).click();
	}
	
	
	
	

}

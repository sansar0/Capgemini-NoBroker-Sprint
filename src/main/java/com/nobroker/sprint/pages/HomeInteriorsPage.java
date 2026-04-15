package com.nobroker.sprint.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeInteriorsPage {
	
	//locating Schedule visit Field
	@FindBy(xpath = "//div[text()='Schedule Visit']")
	private WebElement ScheduleVisitField;
	
	//locating Share Button
	@FindBy(xpath = "//div[text()='Share']")
	private WebElement ShareBtn;

	//getters
	public WebElement getScheduleVisitField() {
		return ScheduleVisitField;
	}

	public WebElement getShareBtn() {
		return ShareBtn;
	}
		
	// click on share btn
	public void ClickOnScheduleVisit(WebDriver driver) {
		getScheduleVisitField().click();
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(getShareBtn())).click();
	}

}

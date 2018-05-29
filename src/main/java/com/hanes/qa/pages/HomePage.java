package com.hanes.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hanes.qa.base.TestBase;

public class HomePage extends TestBase 
{
	@FindBy(id="headerRow2")
	WebElement homePageLogo;
	
	@FindBy(id="Header_GlobalLogin_signInQuickLink")
	WebElement loginBtn;
	
	@FindBy(id="departmentButton_21062")
	WebElement menPage;
	
	@FindBy(id="departmentButton_21063")
	WebElement womenPage;

	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyTitle()
	{
		
		String title=driver.getTitle();
		return title;
	}
	
	public boolean validateHomePageImage()
	{
		return homePageLogo.isDisplayed();
	}
	public LoginPage clickLogin()
	{
		loginBtn.click();
		return new LoginPage();
	}
	
	public ManPage clickMenPage()
	{
		menPage.click();
		return new ManPage();
	}
	public WomenPage clickWomanPage()
	{
		womenPage.click();
		return new WomenPage();
	}
	
	
}

package com.hanes.qa.testclasses;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.hanes.qa.base.TestBase;
import com.hanes.qa.pages.HomePage;
import com.hanes.qa.pages.ManPage;
import com.hanes.qa.pages.WomenPage;
import com.hanes.qa.util.TestUtil;

public class HomePageTest extends TestBase 
{
	HomePage homePage;
	ManPage manPage;
	WomenPage womanPage;
	TestUtil util=new TestUtil();
	Logger log=Logger.getLogger(TestBase.class);
	public HomePageTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp()
	{
		initialization();
		homePage=new HomePage();
		System.out.println("Changed for git");
		
		log.info("Test has been started here");
	}
	@Test(priority=1)//
	public void verifyTitleTest()
	{
		String title=homePage.verifyTitle();
		Assert.assertEquals(title, "Comfortable Clothing Since 1901 | Hanes");
	}
	@Test(priority=2)
	public void verifyLogoTest()
	{
		boolean flag=homePage.validateHomePageImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void menPageTest()
	{
		manPage=homePage.clickMenPage();
	}
	@Test(priority=4)
	public void womenPageTest()
	{
		womanPage=homePage.clickWomanPage();
	}
	@Test
	public void handleFrame()
	{
		util.switchToFrame();
		
		
	}
	
	@AfterMethod
	public void tearOff()
	{
		driver.quit();
	}
}

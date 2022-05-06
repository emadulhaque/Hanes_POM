package com.hanes.qa.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Back_And_Forward_Simulation 
{
	@Test
	public static void simulation() throws InterruptedException
	{
		WebDriver driver= new FirefoxDriver();
		driver.get("http://www.google.com");
		Thread.sleep(3000);
		driver.navigate().to("http://www.facebook.com");
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.quit();
		String s=new String("Hi");
		
		
		
	}
}

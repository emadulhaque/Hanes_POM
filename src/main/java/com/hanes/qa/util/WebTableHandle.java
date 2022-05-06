package com.hanes.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableHandle 
{
	

		@Test
		public void handleWebTable()
		{
		
			System.setProperty("webdriver.chrome.driver", "/Users/mdhaque/Downloads/chromedriver");
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.w3schools.com/sql/sql_select.asp");
			
			//*[@id="main"]/div[5]/table/tbody/tr[2]/td[2]
			//*[@id="main"]/div[5]/table/tbody/tr[3]/td[2]
			//*[@id="main"]/div[5]/table/tbody/tr[4]/td[2]
			//*[@id="main"]/div[5]/table/tbody/tr[5]/td[2]
		
			String beforeXpath="//*[@id=\"main\"]/div[5]/table/tbody/tr[";
			String afterXpath="]/td[2]";
			
			for(int i=2; i<=7; i++)
			{
				String actualXpath=beforeXpath+i+afterXpath;
				WebElement element=driver.findElement(By.xpath(actualXpath));
				System.out.println(element.getText());
				if(element.getText().equals("Antonio Moreno Taquería"))
						{
						System.out.println("CustomerName : "+element.getText()+ "is fontd at position :  "+(i-1));
						break;
						}
			}
			
			System.out.println("***************");
			//*[@id="main"]/div[5]/table/tbody/tr[2]/td[3]
			
			String afterXpathContactName ="]/td[3]";
			
			for(int i=2; i<=7; i++)
			{
				String actualXpath=beforeXpath+i+afterXpathContactName;
				WebElement element=driver.findElement(By.xpath(actualXpath));
				System.out.println(element.getText());

			}
			System.out.println("***************");
			
			
			String afterXpathAddress ="]/td[4]";
			
			for(int i=2; i<=7; i++)
			{
				String actualXpath=beforeXpath+i+afterXpathAddress;
				WebElement element=driver.findElement(By.xpath(actualXpath));
				System.out.println(element.getText());

			}
			
			
			

		}
	}

	


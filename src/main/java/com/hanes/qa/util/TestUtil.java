package com.hanes.qa.util;

import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.io.FileUtils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hanes.qa.base.TestBase;

public class TestUtil extends TestBase
{
	WebDriver driver=new ChromeDriver();
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT =10;
	
	public void switchToFrame() 
	{
		driver.switchTo().frame(1);
		
		
	}

	
//	 URL to get the binary - http://poi.apache.org/download.html
//	 Binary Name - poi-bin-3.11-beta2-20140822.zip
//	 Extract the binary
//	 Add all the jars from the location you extracted to the build path
//	 Also add all the jars from lib, do not add the jar file of log4j
//	 Also add all the jars from ooxml-lib
//	 Only works for Excel 2007+

	//	This method is only to read a data from a particular cell in a excel sheet

	
	
	
	public void captureScreenMethod(String fileName) throws Exception
	{
		//((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		TakesScreenshot sc=new ChromeDriver(); 
		TakesScreenshot scrinShot=((TakesScreenshot)driver);
		 File screenShotFile=scrinShot.getScreenshotAs(OutputType.FILE); //screen shot is created
		 //now copy the pic to a destination
		 FileUtils.copyFile(screenShotFile, new File("Md Emadul Haque⁩/⁨Users⁩/⁨mdhaque⁩/⁨Desktop/NewFileLocation.png⁩"));
		 
		 
		 //We can take screen shot by using EventFiringWebDriver as well
		 
		 EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
		 
		 File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		  
		 FileUtils.copyFile(srcFile, new File("imgPath"));
		 
//		 File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		 FileUtils copyFile= (screenshotFile, "/Users/mdhaque/eclipse-workspace/HanesProject/src/main/java/com/hanes/qa/util/"+fileName+".png");
		 
	}
	
	public void DoubleClick_RightClick()
	{
		WebElement ele=driver.findElement(By.xpath("id=kfs"));
		Actions action=new Actions(driver);
		action.doubleClick().build().perform();
		//action.contextClick(ele);
		
	}
	
	public void mouseOver()
	{
		WebElement ele=driver.findElement(By.xpath("id=kfs"));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("456", 657);
		//action.doubleClick(ele).perform();
	}
	
	public void headlessDriver()
	 {
		 
		//HtmlUnitDriver driver = new HtmlUnitDriver(true);
	
		driver.setJavascriptEnabled(false);
		 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		driver.get("https://www.google.co.in/");
		 
		System.out.println(driver.getTitle());
		 
		}
		 
		

	
	
}

	


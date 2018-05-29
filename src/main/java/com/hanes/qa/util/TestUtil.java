package com.hanes.qa.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.hanes.qa.base.TestBase;

public class TestUtil extends TestBase
{
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

	public static void main(String[] args) 
	{
		
		XSSFWorkbook ExcelWBook;
		XSSFSheet ExcelWSheet;
		XSSFCell Cell;
		
		// Location of the Excel file
		String path = "/Users/mdhaque/eclipse-workspace/HanesProject/src/main/java/com/hanes/qa/testdata/Login_data.xlsx";
		String sheetName = "Sheet1";

		try {
			FileInputStream ExcelFile = new FileInputStream(path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			
			Cell = ExcelWSheet.getRow(1).getCell(2);
			String cellData = Cell.getStringCellValue();
			System.out.println("Cell Data: " + cellData);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	private static XSSFWorkbook ExcelWBook;
	private static XSSFSheet ExcelWSheet;

	/*
	 * Set the File path, open Excel file
	 * @params - Excel Path and Sheet Name
	 * The following method is to read multiple data from multiple row and column simultaneously
	 */
	public static void setExcelFile(String path, String sheetName) throws Exception {
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(path);

			// Access the excel data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
		} catch (Exception e) {
			throw (e);
		}
	}

	public static String[][] getTestData(String tableName) {
		String[][] testData = null;

		try {
			// Handle numbers and strings
			DataFormatter formatter = new DataFormatter();
			// BoundaryCells are the first and the last column
			// We need to find first and last column, so that we know which rows to read for the data
			XSSFCell[] boundaryCells = findCells(tableName);
			// First cell to start with
			XSSFCell startCell = boundaryCells[0];
			// Last cell where data reading should stop
			XSSFCell endCell = boundaryCells[1];
			
			// Find the start row based on the start cell
			int startRow = startCell.getRowIndex() + 1;
			// Find the end row based on end cell
			int endRow = endCell.getRowIndex() - 1;
			// Find the start column based on the start cell
			int startCol = startCell.getColumnIndex() + 1;
			// Find the end column based on end cell
			int endCol = endCell.getColumnIndex() - 1;

			// Declare multi-dimensional array to capture the data from the table
			testData = new String[endRow - startRow + 1][endCol - startCol + 1];

			for (int i=startRow; i<endRow+1; i++) {
				for (int j=startCol; j<endCol+1; j++) {
					// testData[i-startRow][j-startCol] = ExcelWSheet.getRow(i).getCell(j).getStringCellValue();
					// For every column in every row, fetch the value of the cell
					Cell cell = ExcelWSheet.getRow(i).getCell(j);
					// Capture the value of the cell in the multi-dimensional array
					testData[i - startRow][j - startCol] = formatter.formatCellValue(cell);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Return the multi-dimensional array
		return testData;
	}

	public static XSSFCell[] findCells(String tableName) {
		DataFormatter formatter = new DataFormatter();
		// Declare begin position
		String pos = "begin";
		XSSFCell[] cells = new XSSFCell[2];

		for (Row row : ExcelWSheet) {
			for (Cell cell : row) {
				// if (tableName.equals(cell.getStringCellValue())) {
				if (tableName.equals(formatter.formatCellValue(cell))) {
					if (pos.equalsIgnoreCase("begin")) {
						// Find the begin cell, this is used for boundary cells
						cells[0] = (XSSFCell) cell;
						pos = "end";
					} else {
						// Find the end cell, this is used for boundary cells
						cells[1] = (XSSFCell) cell;
					}
				}
			}
		}
		// Return the cells array
		return cells;
	}
	
	
	
	public static void captureScreenMethod() throws Exception
	{
		 
		 File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(screenshotFile, new File("D:\\SoftwareTestingMaterial.png"));
		 
	}

	
	
}

	


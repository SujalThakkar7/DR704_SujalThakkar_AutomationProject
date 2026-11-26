package org.utilities.qa;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	
	public static Object[][] getExcelData() throws Exception { 
		
		FileInputStream file = new FileInputStream("C:\\Users\\sujal\\eclipse-workspace\\DR704_AutomationProject\\src\\test\\resources\\testdata\\TestData.xlsx");
		
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("Search");
		
		int rows = sheet.getLastRowNum();
		int columns = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][columns];
		
		for (int i = 1; i <= rows; i++) {
			Row row = sheet.getRow(i);
			
			for (int j = 0; j < columns; j++) {
				data[i - 1][j] = row.getCell(j).toString();
			}
		}
		
		workbook.close();
		file.close();
		
		return data;
		
	}

}
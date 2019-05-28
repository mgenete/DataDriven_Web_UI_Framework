package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLhelper {
	
	
	
	public static ArrayList<String> getTestData(String sheetName, String testCase, String type) throws IOException {
		
		ArrayList<String> data = new ArrayList<String>();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\testdata\\TestData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		
		int sheetNumber = workBook.getNumberOfSheets();
		
		for(int i=0; i<sheetNumber; i++) {
			
			if(workBook.getSheetName(i).equalsIgnoreCase(sheetName)) {
				XSSFSheet sheet = workBook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> cells = firstRow.cellIterator();
				
				int k=0;
				int column=0;
				while(cells.hasNext()) {
					Cell value = cells.next();
					if(value.getStringCellValue().equalsIgnoreCase(testCase)) {
						column=k;
					}
					k++;
				}
				
				while(rows.hasNext()) {
					Row r = rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(type)) {
						Iterator<Cell> typeValues = r.cellIterator();
						while(typeValues.hasNext()) {
							Cell c = typeValues.next();
							if(c.getCellTypeEnum()==CellType.STRING) {
								data.add(c.getStringCellValue());
							
							} else {
							
								data.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
							
						}
					}
				}
			}

		}
		return data;

	}

}

package com.jtaf.qa.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @author Jaga
 *
 */
public class ExcelReaderUtility extends LoggerUtility {

	Logger log = getLogger(ExcelReaderUtility.class);

	public Object[][] getDataFromExcel(String excelPath, String sheetName) {
		Object[][] dataSet = null;
		try {
			log.info("Data extraction from excel sheet start");
			FileInputStream file = new FileInputStream(new File(excelPath));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int totalRow = sheet.getLastRowNum() + 1;
			int totalColumn = sheet.getRow(0).getLastCellNum();
			dataSet = new Object[totalRow - 1][totalColumn];
			for (int i = 1; i < totalRow; i++) {
				XSSFRow rows = sheet.getRow(i);
				for (int j = 0; j < totalColumn; j++) {
					XSSFCell cell = rows.getCell(j);
					switch (cell.getCellType()) {
					case STRING:
						dataSet[i - 1][j] = cell.getStringCellValue();
						break;
					case NUMERIC:
						dataSet[i - 1][j] = cell.getNumericCellValue();
						break;
					default:
						break;
					}
				}
			}
			log.info("Data extraction from excel sheet end");
			workbook.close();
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return dataSet;
	}

}

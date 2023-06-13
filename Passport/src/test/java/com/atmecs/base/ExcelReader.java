package com.atmecs.base;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author:Gomathi.Veeraiah
 * @date:12-06-2023
 * The ExcelReader class is responsible for reading data from an Excel file and printing the values of a specific column.
 * 
 */


public class ExcelReader {
	
	/**
     * The main method is the entry point of the program.
     * It reads the Excel file, retrieves the values from the specified column, and prints them.
     *
     * @param args The command-line arguments.
     */
	public static void main(String[] args) {
		String filePath = "C:\\Users\\gomathi.veeraiah\\eclipse-workspace\\Passport\\src\\test\\resources\\Data\\Login Application.xlsx";
		String sheetName = "TestCase";
		String columnHeader = "Key";

		try (FileInputStream fileInputStream = new FileInputStream(filePath);
				Workbook workbook = WorkbookFactory.create(fileInputStream)) {

			Sheet sheet = workbook.getSheet(sheetName);
			Row headerRow = sheet.getRow(0);

			int columnNumber = -1;
			// Find the column number based on the header value
			for (Cell cell : headerRow) {
				String cellValue = cell.getStringCellValue();
				if (cellValue.equalsIgnoreCase(columnHeader)) {
					columnNumber = cell.getColumnIndex();
					break;
				}
			}

			if (columnNumber != -1) {
				// Iterate through each row and retrieve the value of the specified column
				for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
					Row dataRow = sheet.getRow(rowIndex);
					Cell cell = dataRow.getCell(columnNumber);

					// Check if the cell contains numeric value
					if (cell.getCellType() == CellType.NUMERIC) {
						double numericValue = cell.getNumericCellValue();
						System.out.println("Row " + (rowIndex + 1) + ", Column " + (columnNumber + 1) + " (Numeric): "
								+ numericValue);
					}
					// Check if the cell contains string value
					else if (cell.getCellType() == CellType.STRING) {
						String stringValue = cell.getStringCellValue();
						System.out.println("Row " + (rowIndex + 1) + ", Column " + (columnNumber + 1) + " (String): "
								+ stringValue);
					}
					// Handle other cell types as needed
				}
			} else {
				System.out.println("Column header not found.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

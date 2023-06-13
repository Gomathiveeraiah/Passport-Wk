package com.atmecs.base;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.atmecs.constants.Constants;
import com.atmecs.featurefile.FeatureFileSteps;

/**
 * @author Gomathi.Veeraiah
 * @date:12-06-2023
 * The BaseClass is responsible for performing operations related to appending feature file steps based on Excel data.
 */


public class BaseClass {
	
	 /**
     * Reads the Excel file and retrieves the values from the specified column.
     * 
     * @return A LinkedList containing the values from the specified column in the Excel file.
     */

	Logger logger = Logger.getLogger(BaseClass.class);
	Constants path = new Constants();
	FeatureFileSteps matterSteps = new FeatureFileSteps();

	public LinkedList<String> excelSheetKeyReader() {

		LinkedList<String> list = new LinkedList<>();

		try (FileInputStream fileInputStream = new FileInputStream(path.EXCEL_READ);
				Workbook workbook = WorkbookFactory.create(fileInputStream)) {

			Sheet sheet = workbook.getSheet(path.SHEET_NAME);
			Row headerRow = sheet.getRow(0);

			int columnNumber = -1;
			// Find the column number based on the header value
			for (Cell cell : headerRow) {
				String cellValue = cell.getStringCellValue();
				if (cellValue.equalsIgnoreCase(path.KEY_NAME)) {
					columnNumber = cell.getColumnIndex();
					break;
				}
			}

			if (columnNumber != -1) {
				// Iterate through each row and retrieve the value of the specified column
				for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
					Row dataRow = sheet.getRow(rowIndex);
					Cell cell = dataRow.getCell(columnNumber);

					// Check if the cell contains string value
					if (cell.getCellType() == CellType.STRING) {
						String stringValue = cell.getStringCellValue();
						list.addLast(stringValue);
					}

					// Handle other cell types as needed
				}
			} else {
				logger.info("Column header not found.");
				
			}

		} catch (IOException execption) {
			logger.error(execption);
		}
		return list;
	}

	public void appendFeatureFileSteps() {
		
		/**
	     * Appends the feature file steps based on the Excel data.
	     * Writes the steps to the feature file specified in the Constants class.
	     *
	     */
		
		LinkedHashMap<String, String> matterCreation = matterSteps.matterCreationStep;
		Set<String> keySet = matterCreation.keySet();

		LinkedList<String> keys = this.excelSheetKeyReader();

		// append the featurefile
		try (BufferedWriter featureFilewriter = new BufferedWriter(new FileWriter(path.FEATURE_HOME))) {
			featureFilewriter.write("Feature: Verify the Matter creation");
			featureFilewriter.newLine();
			featureFilewriter.write("Scenario: Matter Creation");
			featureFilewriter.newLine();
			logger.info("Feature File Created Successfully");

			Iterator<Map.Entry<String, String>> iterator = matterCreation.entrySet().iterator();
			int index = 0;
			while (iterator.hasNext()) {
				Entry<String, String> next = iterator.next();
				String KeySteps = next.getKey();

				for (int i = index; i < keys.size(); i++) {
					String getKeyFromExcel = keys.get(i);
					logger.info(getKeyFromExcel);
				

					if (KeySteps.equals("Login")) {
						featureFilewriter.write("Given " + matterCreation.get(KeySteps));
						featureFilewriter.newLine();
						break;
					}

					if (KeySteps.equalsIgnoreCase(getKeyFromExcel) && !KeySteps.equals("Login")) {
						featureFilewriter.write("Then " + matterCreation.get(KeySteps));
						featureFilewriter.newLine();
						logger.info("Successfully Done");
						
						break;

					}
				}
				index = index + 1;
			}
		} catch (IOException execption) {
			logger.error(execption);

		}

	}
}

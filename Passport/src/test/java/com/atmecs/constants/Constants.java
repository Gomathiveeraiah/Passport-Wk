package com.atmecs.constants;

import java.io.File;


/**
 * @author Gomathi.Veeraiah
 * @date:12-06-2023
 * The Constants class defines the constant values used in the project.
 * It provides file paths, sheet names, and key names for various data sources.
 */

public class Constants {
	public final static String USERS_HOME = System.getProperty("user.dir") + File.separator;

	public final static String FEATURE_HOME = USERS_HOME + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator +"FeatureFile"+File.separator + "TestCase_01.feature";
	
	public final static String EXCEL_READ =USERS_HOME + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator + "Data" + File.separator +"Login Application.xlsx";
	
	public final static String JSON_HOME = USERS_HOME + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator + "Data" + File.separator + "TestCase01.json";
	
	public final static String SHEET_NAME = "Testcase";
	public final static String KEY_NAME = "Key";

}

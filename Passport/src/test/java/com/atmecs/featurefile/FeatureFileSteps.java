package com.atmecs.featurefile;

import java.util.LinkedHashMap;

import com.atmecs.base.JsonReader;

/**
 * @author Gomathi.Veeraiah
 * @date:13-06-2023 
 * 
 * The FeatureFileSteps class extends the JsonReader class and is responsible for defining and populating the
 * matterCreationStep LinkedHashMap, which represents the steps involved in the matter creation process.
 */

public class FeatureFileSteps extends JsonReader {

	/*
	 * 
	 * The matterCreationStep LinkedHashMap holds the matter creation steps as keys
	 * and their corresponding descriptions as values.
	 */

	public static LinkedHashMap<String, String> matterCreationStep;

	public FeatureFileSteps() {
		matterCreation();
	}

	public void matterCreation() {

		String username = jsonData("username");
		String password = jsonData("password");
		String fieldvalue = jsonData("fieldValue");
		String value = jsonData("value");
		String appleField = jsonData("appleField");
		String appleFieldvalue = jsonData("appleFieldValue");

		matterCreationStep = new LinkedHashMap<>();

		// Compare the excel key and feature file Steps

		matterCreationStep.put("Login", "I login as '" + username + "' with password '" + password + "'");
		
		matterCreationStep.put("Open the Matter",
				"I prepare item screen 'New Claim Intake Header Item' for the entity 'Matter' in mode 'Add'");

		matterCreationStep.put("Allocation Tab", "I provide field '" + fieldvalue + "' with value '" + value + "'");
	
		matterCreationStep.put("Verify Field Display",
				"I verify field '" + appleField + "' with value '" + appleFieldvalue + "'");
		
		matterCreationStep.put("Logout", "I logout");

	}

}

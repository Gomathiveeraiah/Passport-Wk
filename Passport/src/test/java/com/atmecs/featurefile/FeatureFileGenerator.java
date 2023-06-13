package com.atmecs.featurefile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.atmecs.constants.Constants;

public class FeatureFileGenerator extends Constants {
	
	public static void main(String[] args) {
		String featureFilePath = FEATURE_HOME;

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(featureFilePath))) {
			// Write the content of the feature file
			writer.write("Feature: My Feature");
			writer.newLine();
			writer.write("  Scenario: My Scenario");
			writer.newLine();
			writer.write("    Given I have a precondition");
			writer.newLine();
			writer.write("    When I perform an action");
			writer.newLine();
			writer.write("    Then I expect a result");
			writer.newLine();

			// Add more scenarios or steps as needed

			System.out.println("Feature file generated successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

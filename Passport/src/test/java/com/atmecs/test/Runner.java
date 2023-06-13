package com.atmecs.test;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;

import org.apache.log4j.Logger;

import com.atmecs.base.BaseClass;
import com.atmecs.base.JsonReader;
import com.atmecs.featurefile.FeatureFileSteps;

public class Runner {
	static Logger logger =Logger.getLogger(Runner.class);
	static BaseClass test = new BaseClass();
	static JsonReader reader = new JsonReader();

	public static void main(String[] args) {
		
		
		FeatureFileSteps featureFileSteps = new FeatureFileSteps();

		LinkedList<String> excelSheetKeyReader = test.excelSheetKeyReader();
		logger.info(excelSheetKeyReader);
		

		LinkedHashMap<String, String> matter = featureFileSteps.matterCreationStep;
		Set<String> keySetMatter = matter.keySet();
		logger.info(keySetMatter);
		
		
		test.appendFeatureFileSteps();
		
		
		
	}

}

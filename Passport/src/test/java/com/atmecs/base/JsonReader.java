package com.atmecs.base;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.atmecs.constants.Constants;

/**
* @author Gomathi.Veeraiah
* @date:13-06-2023
* The JsonReader class provides functionality to read values from a JSON file.
* It extends the Constants class to access the JSON file path defined in it.
*/

public class JsonReader extends Constants {
	
	//Logger logger = Logger.getLogger(BaseClass.class);
    
	public static String jsonData(String keyvalue) {
	
		JSONParser parser = new JSONParser();
		String valueofKey=null;

        try (FileReader fileReader = new FileReader(JSON_HOME)) {
            // Parse the JSON file
            Object obj = parser.parse(fileReader);
            JSONObject jsonObject = (JSONObject) obj;

            // Retrieve the values from the JSON object
             valueofKey = (String) jsonObject.get(keyvalue);
          
            return valueofKey;
        } catch (Exception expection) {
           
        }
		return keyvalue;
    }
}



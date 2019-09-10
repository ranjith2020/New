package com.helper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.text.ParseException;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import com.helper.SwoopConstant;

public class DataManager {
	
	private static String jsonElement;
	
	private DataManager() {
		
	}
	
	public static String getJsonElement() throws ParseException, IOException, org.json.simple.parser.ParseException {
			
		JSONParser parser = new JSONParser();
        URL resource = ClassLoader.getSystemResource("document.json");
//		System.out.print("file"+ resource);
		InputStream stream = resource.openStream();
		String file = IOUtils.toString(stream, "UTF-8");
//		System.out.print("File "+ file);
		Object obj = parser.parse(file);
//		System.out.println(obj);
		String jsonElement = obj.toString();
        return jsonElement;
	}

}

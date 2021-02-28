package com.jtaf.qa.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/***
 * 
 * @author Jaga
 *
 */
public class FileReader {

	InputStream inputStream;
	Properties properties;
	
	private static String propertyFilePath = "./src/main/resources/configuration/";
	private static String testConfigFile = "TestConfig.properties";

	public void getPropFileData() throws IOException {
		try {
			properties = new Properties();
			inputStream = getClass().getClassLoader().getResourceAsStream(propertyFilePath + testConfigFile);
			if (inputStream != null) {
				properties.load(inputStream);
			} else {
				throw new FileNotFoundException(
						"+++++++++++++++ [ Property file '" + testConfigFile + "' not found ] +++++++++++++++");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			inputStream.close();
		}
	}
}
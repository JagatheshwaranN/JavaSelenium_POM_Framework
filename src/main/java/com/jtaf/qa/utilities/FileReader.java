package com.jtaf.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/***
 * 
 * @author Jaga
 *
 */
public class FileReader {

	private Properties properties;
	private File file;
	private FileInputStream fileInputStream;

	private static String propertyFilePath = "//src//main//resources//configuration//";
	private static String testConfigFile = "TestConfig.properties";

	public void loadPropertyFile() throws IOException {
		try {
			properties = new Properties();
			file = new File(System.getProperty("user.dir") + propertyFilePath + testConfigFile);
			try {
				fileInputStream = new FileInputStream(file);
			} catch (FileNotFoundException ex) {
				System.out.println(
						"+++++++++++++++ [ Property file '\" + testConfigFile + \"' not found ] +++++++++++++++");
				ex.printStackTrace();
			}
			try {
				properties.load(fileInputStream);
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		} finally {
			fileInputStream.close();
		}
	}

	public String getTestData(String property) {
		String dataFromPropFile = null;
		try {
			dataFromPropFile = properties.getProperty(property).trim();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dataFromPropFile;
	}
	
}
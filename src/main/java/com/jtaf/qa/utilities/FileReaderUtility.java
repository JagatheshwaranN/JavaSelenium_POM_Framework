package com.jtaf.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/***
 * 
 * @author Jaga
 *
 */
public class FileReaderUtility extends LoggerUtility {

	private static Properties properties;
	private static File file;
	private static FileInputStream fileInputStream;

	private static String propertyFilePath = "//src//main//resources//configurations//";
	private static String testConfigFile = "TestConfig.properties";
	
	Logger log = getLogger(FileReaderUtility.class);

	public void loadPropertyFile() throws IOException {
		try {
			properties = new Properties();
			file = new File(System.getProperty("user.dir") + propertyFilePath + testConfigFile);
			try {
				fileInputStream = new FileInputStream(file);
			} catch (FileNotFoundException ex) {
				log.info("======================== [ Property file " + testConfigFile
						+ " not found ] ========================");
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
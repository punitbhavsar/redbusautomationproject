package com.framework.common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationProperties {

	Properties properties = new Properties();
	private final String PROPERTY_FILE_PATH = "Configurations/Configuration.properties";
	public static String SITE_URL = "siteurl";
	public static String BROWSER_NAME ="browsername";
	

	public ConfigurationProperties() {

		properties = loadProperties();
	}

	private Properties loadProperties() {
		Properties prop = new Properties();

		try {
			File file = new File(PROPERTY_FILE_PATH);
			FileInputStream fileInput = new FileInputStream(file);
			prop.load(fileInput);
			fileInput.close();
		} catch (Exception e) {
		}

		return prop;
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

}

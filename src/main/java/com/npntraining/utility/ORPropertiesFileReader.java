package com.npntraining.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ORPropertiesFileReader {
	static ORPropertiesFileReader instance = null;
	static Properties prop = null;

	private ORPropertiesFileReader() throws IOException {
		InputStream systemResouurceAsStream = ClassLoader.getSystemResourceAsStream("OR.properties");
		prop = new Properties();
		prop.load(systemResouurceAsStream);
	}

	public static ORPropertiesFileReader getInstance() {
		if (instance == null) {
			try {
				instance = new ORPropertiesFileReader();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;

	}

	public String getPropertyValue(String key) {
		return prop.getProperty(key);
	}

	public static void main(String[] args) {
		System.out.println(ORPropertiesFileReader.getInstance().getPropertyValue("username"));
	}
}

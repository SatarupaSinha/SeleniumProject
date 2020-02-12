package com.npntraining.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class test_config_properties_file {

	public static String getPropertyValue(String key) throws FileNotFoundException {
		//InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream("test-config.properties");
		InputStream input = new FileInputStream("C:\\Users\\Satarupa Sinha\\eclipse-workspace\\Page-Object-Model\\src\\test\\resources\\test-config.properties");
		Properties prop = new Properties();
		try {
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(key);

	}

	public static void main(String[]

	args) throws FileNotFoundException {
		System.out.println(test_config_properties_file.getPropertyValue("username"));
	}

}

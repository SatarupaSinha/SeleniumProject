package com.npntraining.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.npntraining.utility.ORPropertiesFileReader;

public class BasePage {
	protected static WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;

	}

	public String getTitle() {
		return driver.getTitle();
	}

	public WebElement findElement(String key) {
		String value = ORPropertiesFileReader.getInstance().getPropertyValue(key);
		String[] fields = value.split(",");
		By by = null;
		if (fields[0].equals("xpath")) {
			by = By.xpath(fields[1]);
		}
		System.out.println(driver.findElement(by));
		return driver.findElement(by);
	}
	
	
}

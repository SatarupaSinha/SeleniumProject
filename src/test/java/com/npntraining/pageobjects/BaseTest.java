package com.npntraining.pageobjects;

import static com.npntraining.constants.TestConfigKeyConstant.APPLICATION_URL;
import static com.npntraining.constants.TestConfigKeyConstant.BROWSER_NAME;
import static com.npntraining.constants.TestConfigKeyConstant.DRIVER_LOCATION;
import static com.npntraining.constants.TestConfigKeyConstant.DRIVER_NAME;
import static com.npntraining.utility.test_config_properties_file.getPropertyValue;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	static WebDriver driver;
	public static Logger log = LoggerFactory.getLogger("applogger");

	@BeforeClass
	public static void setupBeforeClass() throws FileNotFoundException {
		initializeWebDriver();
		driver.get(getPropertyValue(APPLICATION_URL));
		LoginPage loginPage = new LoginPage(driver);
	}

	public static void initializeWebDriver() throws FileNotFoundException {
		System.setProperty(getPropertyValue(DRIVER_NAME), getPropertyValue(DRIVER_LOCATION));
		if ("chrome".equals(getPropertyValue(BROWSER_NAME))) {
			driver = new ChromeDriver();
		} else if ("firefox".equals(getPropertyValue(BROWSER_NAME))) {
			driver = new FirefoxDriver();
		}
	}

}

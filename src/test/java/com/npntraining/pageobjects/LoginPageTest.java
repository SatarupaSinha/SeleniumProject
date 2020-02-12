package com.npntraining.pageobjects;

import static com.npntraining.constants.TestConfigKeyConstant.PASSWORD;
import static com.npntraining.constants.TestConfigKeyConstant.USER_NAME;
import static com.npntraining.utility.test_config_properties_file.getPropertyValue;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
	static LoginPage login;

	@Test
	public void testLogin_WithCorrectCredentials() throws FileNotFoundException {
		login = new LoginPage(driver);
		DashBoardPage dashboard = login.clickLogin(getPropertyValue(USER_NAME), getPropertyValue(PASSWORD));
		String expected = "Dashboard-Library";
		String actual = dashboard.getPageTitle();
		Assert.assertEquals(actual, expected);
		// dashboard.Logout();

	}
}

package com.npntraining.pageobjects;

import static com.npntraining.constants.TestConfigKeyConstant.PASSWORD;
import static com.npntraining.constants.TestConfigKeyConstant.USER_NAME;
import static com.npntraining.utility.test_config_properties_file.getPropertyValue;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DashBoardPageTest extends BaseTest {

	static LoginPage login;

	@Test
	public void clickLogout() throws FileNotFoundException {
		DashBoardPage dashboard = login.clickLogin(getPropertyValue(USER_NAME), getPropertyValue(PASSWORD));
		// DashBoardPage dashboardPage =
		// PageNAvigationFactory.navigateToDashboard(driver);
		dashboard.clickLogout();
		Assert.assertEquals(dashboard.getPageTitle(), "E.B. Magalona National High School");
	}
}
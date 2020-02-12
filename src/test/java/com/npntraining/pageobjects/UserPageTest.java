package com.npntraining.pageobjects;

import static com.npntraining.constants.TestConfigKeyConstant.FIELDEDITEDVALUE;
import static com.npntraining.constants.TestConfigKeyConstant.FIELDTOEDIT;
import static com.npntraining.constants.TestConfigKeyConstant.FIRSTNAME;
import static com.npntraining.constants.TestConfigKeyConstant.LASTNAME;
import static com.npntraining.constants.TestConfigKeyConstant.PASSWORD;
import static com.npntraining.constants.TestConfigKeyConstant.PWD;
import static com.npntraining.constants.TestConfigKeyConstant.USERNAME;
import static com.npntraining.constants.TestConfigKeyConstant.USER_NAME;
import static com.npntraining.utility.test_config_properties_file.getPropertyValue;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.npntraining.constants.TestConfigKeyConstant;
import com.npntraining.utility.PageNAvigationFactory;
import com.npntraining.utility.test_config_properties_file;

public class UserPageTest extends BaseTest {

	static DashBoardPage dash;
	static LoginPage login;

	@BeforeMethod()
	public void clickLogin() throws FileNotFoundException {
		DashBoardPage dashboard = login.clickLogin(getPropertyValue(USER_NAME), getPropertyValue(PASSWORD));
		Assert.assertEquals(dashboard.getPageTitle(), "Dashboard-Library");

	}

	 //@Test()
	public void ClickUser() throws InterruptedException, FileNotFoundException {
		UserPage user = PageNAvigationFactory.navigateToUser(driver);
		Assert.assertEquals(driver.getTitle(), "E.B. Magalona National High School");
		user.ClickAddUser();
		Thread.sleep(2000);
		user.AddUser(getPropertyValue(USERNAME), getPropertyValue(PWD), getPropertyValue(FIRSTNAME),
				getPropertyValue(LASTNAME));

	}

	 //@Test()
	public void CompareUser() throws FileNotFoundException {
		UserPage user = PageNAvigationFactory.navigateToUser(driver);
		Assert.assertEquals(driver.getTitle(), "E.B. Magalona National High School");
		log.info("User Compared");
		String userdetails[] = user.GetUser();
		Assert.assertEquals(userdetails[0], getPropertyValue(USERNAME));
		Assert.assertEquals(userdetails[1], getPropertyValue(PWD));
		Assert.assertEquals(userdetails[2], getPropertyValue(FIRSTNAME));
		Assert.assertEquals(userdetails[3], getPropertyValue(LASTNAME));
	}

	//@Test()
	public void EditUser() throws FileNotFoundException, InterruptedException {
		UserPage user = PageNAvigationFactory.navigateToUser(driver);
		Assert.assertEquals(driver.getTitle(), "E.B. Magalona National High School");
		user.EditUser(getPropertyValue(FIELDTOEDIT), getPropertyValue(FIELDEDITEDVALUE));
	}
@Test
	public void DeleteUser() throws InterruptedException {
		UserPage user = PageNAvigationFactory.navigateToUser(driver);
		Assert.assertEquals(driver.getTitle(), "E.B. Magalona National High School");
		user.DeleteUser("POMUSER");
		
	}

	// @AfterMethod
	public void TearDown() throws InterruptedException {
		DashBoardPage.clickLogout();
		Thread.sleep(2000);
		driver.quit();
	}
}

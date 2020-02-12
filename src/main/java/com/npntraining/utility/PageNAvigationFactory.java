package com.npntraining.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.npntraining.pageobjects.DashBoardPage;
import com.npntraining.pageobjects.UserPage;

public class PageNAvigationFactory {

	public static DashBoardPage navigateToDashboard(WebDriver driver) {
		return new DashBoardPage(driver);
	}

	public static UserPage navigateToUser(WebDriver driver) {
		driver.findElement(By.xpath("//ul[@class='nav']/li[2]")).click();
		return new UserPage(driver);
	}
}

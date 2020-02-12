package com.npntraining.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends BasePage {

	public DashBoardPage(WebDriver driver) {
		super(driver);
	}

	public static void clickLogout() {
		driver.findElement(By.xpath("//ul[@class='nav']/li[8]")).click();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
}
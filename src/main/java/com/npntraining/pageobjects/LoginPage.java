package com.npntraining.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
	static WebElement txtUserName;
	static WebElement txtPassword;
	static WebElement btnLogin;

	LoginPage(WebDriver driver) {

		super(driver);
		txtUserName = driver.findElement(By.id("username"));
		txtPassword = driver.findElement(By.id("password"));
		btnLogin = driver.findElement(By.id("login"));
	}

	public static DashBoardPage clickLogin(String name, String pwd) {
		txtUserName.sendKeys(name);
		txtPassword.sendKeys(pwd);
		btnLogin.click();
		return new DashBoardPage(driver);
	}
}

package com.npntraining.pageobjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserPage extends BasePage {

	static WebElement btnaddUser;
	static WebElement txtusername;
	static WebElement txtPassword;
	static WebElement txtFirstname;
	static WebElement txtlastname;
	static WebElement btnsave;

	public UserPage(WebDriver driver) {
		super(driver);
		btnaddUser = driver.findElement(By.xpath("//ul[@class='nav nav-tabs nav-stacked']/li/a"));
		txtusername = findElement("username");
		// txtusername = driver
		// .findElement(By.xpath("//div[@class='span2']//div[@class='modal-body']//div[1]//div[1]//input[1]"));
		// txtPassword =findElement("password");
		txtPassword = driver.findElement(By.xpath("//div[@id='add_user']/div/form/div[2]/div/input"));
		// txtFirstname = findElement("firstname");
		txtFirstname = driver.findElement(By.xpath("//div[@id='add_user']/div/form/div[3]/div/input"));
		txtlastname = driver.findElement(By.xpath("//div[@id='add_user']/div/form/div[4]/div/input"));
		btnsave = driver.findElement(By.xpath("//div[@id='add_user']/div/form/div[5]/div/button"));
	}

	public void ClickAddUser() {
		btnaddUser.click();
	}

	public void AddUser(String username, String pwd, String firstname, String lastname) {
		txtusername.sendKeys(username);
		txtPassword.sendKeys(pwd);
		txtFirstname.sendKeys(firstname);
		txtlastname.sendKeys(lastname);
		btnsave.click();
	}

	public String[] GetUser() {
		List<WebElement> username = driver.findElements(By.xpath("//div[@class='span10']/div[2]/table/tbody/tr"));
		Iterator iteusername = username.iterator();
		String details[] = new String[4];
		while (iteusername.hasNext()) {
			WebElement name = (WebElement) iteusername.next();
			if (name.getText().contains("Automation")) {
				details = name.getText().split(" ");
			}
		}
		return (details);
	}

	public void EditUser(String field, String newvalue) throws InterruptedException {
		int i = 0;
		List<WebElement> username = driver.findElements(By.xpath("//div[@class='span10']/div[2]/table/tbody/tr"));
		Iterator iteusername = username.iterator();
		String details[] = new String[5];
		while (iteusername.hasNext()) {
			WebElement name = (WebElement) iteusername.next();
			if (name.getText().contains("Automation")) {
				details = name.getText().split(" ");
				List<WebElement> btnclick = driver
						.findElements(By.xpath("//div[@class='span10']/div[2]/table/tbody/tr/td[5]"));
				// System.out.println(details[3]);
				btnclick.get(i).click();
				;
			}
			i++;
		}
		
		
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (field.equalsIgnoreCase("username"))
			js.executeScript("document.getElementById('inputEmail').value='username';");
		// driver.findElement(By.xpath("//div[@class='modal hide fade
		// in']/div/form/div/div/input[2]")).sendKeys(newvalue);
		else if (field.equalsIgnoreCase("password"))
			driver.findElement(By.xpath("//div[@class='modal hide fade in']/div/form/div[2]/div/input"))
					.sendKeys(newvalue);
		else if (field.equalsIgnoreCase("firstname"))
			driver.findElement(By.xpath("//div[@class='modal hide fade in']/div/form/div[3]/div/input"))
					.sendKeys(newvalue);
		else if (field.equalsIgnoreCase("lastname"))
			driver.findElement(By.xpath("//div[@class='modal hide fade in']/div/form/div[4]/div/input"))
					.sendKeys(newvalue);
		Thread.sleep(2000);
		js.executeScript("document.getElementsByName('submit').click();");
	}

	public void DeleteUser(String field) throws InterruptedException {
		String xpath = "//table[@id='example']//td[text()='"+field+"']//following-sibling::td[4]//a[@data-original-title='Delete']";
				driver.findElement(By.xpath(xpath)).click();
				String id=driver.findElement(By.xpath(xpath)).getAttribute("id");
				Thread.sleep(2000);
				String css = "div[id*='"+id+"']>div>a";
				driver.findElement(By.cssSelector(css)).click();
				
				//driver.findElement(By.xpath("//div[@id='delete_user512']//a[@class='btn btn-danger'][contains(text(),'Yes')]")).click();
				}
			//i++;
//		}
//	}
	
}

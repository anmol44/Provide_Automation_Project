package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class Login extends BasePage{
	
	static String userNameXpath = "//*[@id=\"txtLogin\"]";
	static String userPasswordXpath = "//*[@id=\"txtPassword\"]";
	static String userLogignButtonXpath ="//input[@type='submit' and @id='btnLogin']"; 
	
	public Login(WebDriver driver) {
		super(driver);
	
	}
	
	
	
	public Login enterUserName(String username ) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(userNameXpath))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(userNameXpath))).sendKeys(username);
		return this;
	}
	
	public Login enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(userPasswordXpath))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(userPasswordXpath))).sendKeys(password);
		return this;
	}
	
	
	public Login clickLoginBtn() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(userLogignButtonXpath))).click();
		return this;
	}
	
	public HomePage homepage() {
		clickLoginBtn();
		return new HomePage(driver);
	}
	
	public HomePage logIn(String username,String password) {
		
		return  
				enterUserName(username).
				enterPassword(password).
				homepage();
				
			
	}




}
	
		




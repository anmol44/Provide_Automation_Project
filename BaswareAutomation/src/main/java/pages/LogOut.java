package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import base.BasePage;

public class LogOut extends BasePage {
	
	static WebElement webElement;
	
	static String shadowRootHostXpath = "document.querySelector('alusta-navigation').shadowRoot.querySelector('div > nav > div.pt-navbar-nav.main-nav > ul > li:nth-child(1) > a')";
	static String shadowRootHostUserXpath = "document.querySelector('alusta-navigation').shadowRoot.querySelector('alusta-navigation-user-menu').shadowRoot.querySelector('#dropdownUserMenu > span')";
	static String shadowRootHostInvoiceLogoutXpath="document.querySelector('alusta-navigation').shadowRoot.querySelector('alusta-navigation-user-menu').shadowRoot.querySelector('div > alusta-navigation-dropdown > div:nth-child(4) > a')";
	static String shadowRootHostLogoutXpath = "document.querySelector('alusta-navigation').shadowRoot.querySelector('alusta-navigation-user-menu').shadowRoot.querySelector('div > alusta-navigation-dropdown > div:nth-child(6) > a')";
	static String allSessionsLogOutXpath = "//span[@class='ng-scope' and contains(text(),'All sessions')]";
	static String allSessionsLogOutInXpath="//button[@class='pt-btn' and contains(text(),'All sessions')]";
	static String logOutUrl = "https://voflusoprasttest.p2p.basware.com/edge/#/logout/_2Fedge_2Fapi_2Flogout";
	
	//logout url for Invoice
	static String LogOutInUrl = "https://voflusoprasttest.p2p.basware.com/ap/invoice?v=doc&s=0&docId=6a68077bfb934e6094fb22952c2f6c91";
	
	static String unsavedDataDiv="//div[@class='modal-content']//child :: pal-modal[@title-text='Unsaved data warning']";
	static String unsavedDataButton="//button[@class='btn btn-secondary']";								  


	public LogOut(WebDriver driver) {
		super(driver);
		
	}
	
	public LogOut logout(JavascriptExecutor javascriptExecutor,String doctype) throws InterruptedException {
		
		webElement = (WebElement) javascriptExecutor.executeScript("return "+shadowRootHostUserXpath);
		webElement.click();
		
		if(doctype.equalsIgnoreCase("Invoice")) {
			webElement = (WebElement) javascriptExecutor.executeScript("return "+shadowRootHostInvoiceLogoutXpath);
			javascriptExecutor.executeScript("arguments[0].click();", webElement); 
		}
		else {
		webElement = (WebElement) javascriptExecutor.executeScript("return "+shadowRootHostLogoutXpath);
		javascriptExecutor.executeScript("arguments[0].click();", webElement); 
		}
		
		unSavedData(javascriptExecutor,doctype);
		

		Thread.sleep(2000);
		if (driver.getCurrentUrl().contains(logOutUrl)) {
			allSessionsLogOut(wait,doctype);
			
		} else if(driver.getCurrentUrl().contains(LogOutInUrl)) {
			allSessionsLogOut(wait,doctype);
		}
		
		
		return this;
	}
	
	public static void allSessionsLogOut(WebDriverWait wait,String docType ) {
		if(docType.equalsIgnoreCase("invoice")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(allSessionsLogOutInXpath))).click();
		}else 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(allSessionsLogOutXpath))).click();
		
	}
	
	public static void unSavedData(JavascriptExecutor javascriptExecutor,String doctype) throws InterruptedException {
		
		if(driver.findElements(By.xpath(unsavedDataDiv)).size()>0) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unsavedDataButton))).click();
			
			Thread.sleep(2000);
			if (driver.getCurrentUrl().contains(logOutUrl)) {
				allSessionsLogOut(wait,doctype);
				}else if(driver.getCurrentUrl().contains(LogOutInUrl)) {
					allSessionsLogOut(wait,doctype);
				}
		}
	}
}

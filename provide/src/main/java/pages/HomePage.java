package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BasePage;

public class HomePage extends BasePage {
	
	WebElement webelement;
	
	static String searchHomeXpath="//span[@class='pal-search-submit-text ng-scope' and contains(text(),'Search')]";
	static String shopButtonXpath="document.querySelector('alusta-navigation').shadowRoot.querySelector('div > nav > div.pt-navbar-nav.main-nav > ul > li:nth-child(2) > a')";
	// accoutspayable xpath fix
	static String accountsPayableXpath = "document.querySelector('alusta-navigation').shadowRoot.querySelector('alusta-navigation-more-menu').shadowRoot.querySelector('div > alusta-navigation-dropdown > div:nth-child(7) > a')";
	static String alustaNavigation="//alusta-navigation[@id='alusta-navigation']";	



	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	public HomePage searchHomeXpath() {
		waitForElement(searchHomeXpath);
		return this;
	}
	
	public HomePage waitAlustaNavigation(ExtentTest test) {
		waitForElement(alustaNavigation);
		test.log(Status.PASS,"Successfully on Home Page");
		
		return this;
	}
	
	public Shop shopBtn(ExtentTest test, JavascriptExecutor javascriptExecutor) {
		searchHomeXpath().
		waitAlustaNavigation(test);
		test.log(Status.INFO, "Click Shop Button");
		webelement = (WebElement) javascriptExecutor.executeScript("return "+shopButtonXpath);
		webelement.click();
		test.log(Status.PASS, "Shop clicked");
		return new  Shop(driver);
	}
	
	public  AccountsPayable accountPayable(ExtentTest test,JavascriptExecutor javascriptExecutor) {
		searchHomeXpath().
		waitAlustaNavigation(test);
		test.log(Status.INFO, "Click Accounts Payable Button");
		webelement = (WebElement) javascriptExecutor.executeScript("return "+accountsPayableXpath);
		javascriptExecutor.executeScript("arguments[0].click() ",webelement);
		test.log(Status.PASS, "Accounts Payable clicked");
		return new AccountsPayable(driver);
	}
	
}

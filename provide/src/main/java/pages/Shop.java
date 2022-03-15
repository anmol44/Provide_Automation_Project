package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import base.BasePage;

public class Shop extends BasePage {
	static WebElement webelement;
	
	static String searchSubmitXpath="//button[@class='btn pal-search-submit' and @type='submit']";
	static String shopXpath = "document.querySelector('alusta-navigation').shadowRoot.querySelector('div > nav.pt-navbar-second-level > div:nth-child(2) > ul > li:nth-child(1) > a')";
	static String organizationSearchBoxXpath="//div[@class='modal-content']";
	static String organizationSearchXpath="//input[@class='pal-tree-select-input margin-xs form-control ng-pristine ng-untouched ng-valid ng-scope ng-empty']";
	static String organizationCountXpath = "//div[@class='pal-tree-view-item-count ng-scope']";
	static String organizationPanelXpath ="//div[@class='pal-tree-view-nodes']//child::pal-tree-item//child::div[@data-t-node-code=";
	static String organizationSelectButtonXpath="//button[@class='btn btn-pal-action-button ng-scope']";
	static String selectDropDownXpath= "//div[@class='pal-tree-select dropdown']";
	static String modalTitleXpath ="//span[@class='modal-title ng-binding']";
	static String fieldContaierXpath="/html/body/div[1]/div/div/pal-modal/div/div[2]/pal-modal-body/pal-field-container/div/div/div/pal-tree-single-select/div/div[1]/div";
	static String alustaNavigation="//alusta-navigation[@id='alusta-navigation']";	
	

	public Shop(WebDriver driver) {
		super(driver);
		
	}
	
	public Shop waitSearchSubmitButton() {
		waitForElement(searchSubmitXpath);
		
		return this;
	}
	
	public Shop waitAlustaNavigation() {
		waitForElement(alustaNavigation);
		
		return this;
	}
	
	public Shop organizationSelect(String organization) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(organizationSearchBoxXpath)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectDropDownXpath)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(modalTitleXpath)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fieldContaierXpath))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(organizationSearchXpath))).sendKeys(organization);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(organizationCountXpath)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(organizationPanelXpath +organization+"]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(organizationSelectButtonXpath))).click();
		return this;
	}
	
	
	public Shop selectEntity(JavascriptExecutor javascriptExecutor ) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		webelement = (WebElement) javascriptExecutor.executeScript("return "+shopXpath);
		webelement.click();
		
		return this;
	}
	
	
	public Form selectForm(String organization,JavascriptExecutor javascriptExecutor) {
		waitSearchSubmitButton().
		waitAlustaNavigation().
		selectEntity(javascriptExecutor).
		organizationSelect(organization);
		
		return new Form(driver);
	}

	
	
	

}

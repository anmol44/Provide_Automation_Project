package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

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
	static String organizationListXpath="//span[@class='pal-tree-item-label margin-left ng-binding']";
	static String selectDropDownXpath= "//div[@class='pal-tree-select dropdown']";
	static String modalTitleXpath ="//span[@class='modal-title ng-binding']";
	static String fieldContaierXpath="//div[@class='pal-tree-select-inner-container flex-grow' and @aria-label='Organization']";
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
	
	public Shop organizationSelect(ExtentTest test,String organization) {
		
		test.log(Status.INFO, "Enter Organization");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(organizationSearchBoxXpath)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(modalTitleXpath)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectDropDownXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fieldContaierXpath))).click();
		// change from elementToBeClickable  to visiblityOfElementLocated.
		
		
		test.log(Status.INFO, "Store All Organization in List");
		List<WebElement> elements = new ArrayList<>();
		elements = driver.findElements(By.xpath(organizationListXpath));
		List<WebElement> element = elements.stream().filter(e->e.getText().equalsIgnoreCase(organization)).collect(Collectors.toList());
		for(WebElement el : element) {
			test.log(Status.INFO, "Organization is Displayed :: "+el.isDisplayed());
			
		}
		
		test.log(Status.INFO, "Organization If is correct and available");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(organizationSearchXpath))).sendKeys(organization);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(organizationCountXpath)));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(organizationPanelXpath +organization+"]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(organizationSelectButtonXpath))).click();
		test.log(Status.PASS, "Successful Organization");
		return this;
	}
	
	
	public Shop selectEntity(ExtentTest test,JavascriptExecutor javascriptExecutor ) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.INFO, "Click to Open Select Organization Panel");
		webelement = (WebElement) javascriptExecutor.executeScript("return "+shopXpath);
		webelement.click();
		test.log(Status.PASS, "Successful Panel Opened to enter Organization");
		
		return this;
	}
	
	
	public Form selectForm(ExtentTest test ,String organization,JavascriptExecutor javascriptExecutor) {
		waitSearchSubmitButton().
		waitAlustaNavigation().
		selectEntity(test,javascriptExecutor).
		organizationSelect(test,organization);
		
		return new Form(driver);
	}

	
	
	

}

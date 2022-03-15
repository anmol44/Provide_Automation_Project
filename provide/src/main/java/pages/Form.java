package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


import base.BasePage;

public class Form extends BasePage {
	
	static String beStandardXpath = "//*/div[@class='card-icon fa fa-shopping-bag']";
	static String beHomeXpath="//*/div[@class='card-icon fa fa-home']";
	static String beSubcontractingXpath = "//div[@class='card-icon fa fa-user']";
	static String beLogisticsXpath = "//div[@class='card-icon fa fa-building']";
	static String beStandardSBS136Xpath = "//div[@class='card-icon fa fa-map-marker']";
	


	
	

	public Form(WebDriver driver) {
		super(driver);
		
	}
	
	public Form selectForm(String type) {
		if(type.equalsIgnoreCase("Standard")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(beStandardXpath))).click();
			} else if(type.equalsIgnoreCase("Subcontracting")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(beSubcontractingXpath))).click();
			}
			else if(type.equalsIgnoreCase("Logistics")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(beLogisticsXpath))).click();
				}
		return this;
	}
	
	
	
	public Form selectFormSBS(String type) {
		if(type.equalsIgnoreCase("DA")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(beStandardXpath))).click();
			} else if(type.equalsIgnoreCase("DI")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(beHomeXpath))).click();
			}
			else if(type.equalsIgnoreCase("Subcontracting")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(beSubcontractingXpath))).click();
				}
			else if(type.equalsIgnoreCase("Logistics")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(beLogisticsXpath))).click();
			} else 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(beStandardSBS136Xpath))).click();
		
		return this;
	}
	
	
	
	public EditRequisition editRequisitionSBS(String type) throws InterruptedException {
		Thread.sleep(2000);
		//refresh the page 
		driver.navigate().refresh();
		selectFormSBS(type);
		
		return new EditRequisition(driver);
	}
	
	public EditRequisition editRequisitionGalitt(String type) {
		selectFormSBS(type);
		
		return new EditRequisition(driver);
	}
	
	public EditRequisition editRequisitionBeleux(String type) {
		selectForm(type);
		
		return new EditRequisition(driver);
	}
	
	public EditRequisition editRequisitionSpain(String type) {
		selectForm(type);
		
		return new EditRequisition(driver);
	}
	
	public EditRequisition editRequisitionFrance(String type) {
		selectFormSBS(type);
		
		return new EditRequisition(driver);
	}


}

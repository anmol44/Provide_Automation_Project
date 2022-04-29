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
	
	private static String beGoodsAndServicesXpath = "//div[@class='card-icon fa fa-shopping-basket']";
	private static String beItXpath = "//div[@class='card-icon fa fa-desktop']";
	private static String beRealEstateAndGeneralServicesXpath = "//div[@class='card-icon fa fa-building']";
	private static String beSubcontractingNewXpath = "//div[@class='card-icon fa fa-group']";
	private static String beTravelXpath = "//div[@class='card-icon fa fa-plane']";
	
	


	
	

	public Form(WebDriver driver) {
		super(driver);
		
	}
	
	public Form selectForm(String type) throws InterruptedException {
		Thread.sleep(2000);
		//refresh the page 
		driver.navigate().refresh();
		
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
	
	
	
	public Form selectFormSBS(String type) throws InterruptedException {
		Thread.sleep(2000);
		//refresh the page 
		driver.navigate().refresh();
		
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
	
	
	// New Form for entity :=> 010, 136, 413, 426, 022, 362
	
		public Form selectFormNew(String type) throws InterruptedException {
			Thread.sleep(2000);
			//refresh the page 
			driver.navigate().refresh();
			
			if(type.equalsIgnoreCase("Goods & Services")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(beGoodsAndServicesXpath))).click();
			}else if(type.equalsIgnoreCase("It")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(beItXpath))).click();
			}else if(type.equalsIgnoreCase("Real Estate & General Services")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(beRealEstateAndGeneralServicesXpath))).click();
			}else if(type.equalsIgnoreCase("Subcontracring")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(beSubcontractingNewXpath))).click();
			}else if(type.equalsIgnoreCase("Travel")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(beTravelXpath))).click();
			}
			return this;
		}
	
	
	
	public EditRequisition editRequisitionSBS(String type) throws InterruptedException  {
		selectFormSBS(type);	
		return new EditRequisition(driver);
	}
	
	public EditRequisition editRequisitionGalitt(String type) throws InterruptedException {
		selectFormSBS(type);	
		return new EditRequisition(driver);
	}
	
	public EditRequisition editRequisitionBeleux(String type) throws InterruptedException {
		selectForm(type);		
		return new EditRequisition(driver);
	}
	
	public EditRequisition editRequisitionSpain(String type) throws InterruptedException {
		selectForm(type);	
		return new EditRequisition(driver);
	}
	
	public EditRequisition editRequisitionFrance(String type) throws InterruptedException {
		selectFormSBS(type);		
		return new EditRequisition(driver);
	}
	
	public EditRequisition editRequisition(String type) throws InterruptedException {
		selectFormNew(type);
		return new EditRequisition(driver);
	}


}

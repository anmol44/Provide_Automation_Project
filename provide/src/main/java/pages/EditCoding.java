package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import base.BasePage;

public class EditCoding extends BasePage {
	
	WebElement webelement;
	
	static String requesterXpath="//button[@class='pal-single-select-toggle-btn']";
	static String requesterSearchXpath="/html/body/div/bw-purchase-requisition-details/section/pal-two-col-row/div/div[1]/div/pal-two-col-row-left-content/div/bw-purchase-header-data-panel/div/div/div[2]/div/div[1]/div/pal-detail-fields/div/pal-detail-field[6]/div/div/bw-purchase-requisition-panel-field/div/bw-purchase-panel-field-switch/div/div/div/bw-lookup-list/div/pal-single-select/div/div[2]/pal-single-select-dropdown/div/div[1]/div/input";
	static String requesterSelect1Xpath="//span[@class='ng-binding' and contains(text(),'";
	static String requesterSelect2Xpath="')]";
	static String headerDataSaveXpath = "(//button[@type='button' and @class='btn ng-binding'])[2]";
	static String addAdressEditButtonXpath = "//button[@class='btn btn-pal-actions-button ng-scope btn-action-icon btn-secondary' and @type='button' and @title='Edit']";
	static String addressXpath = "(//span[@class='btn btn-default form-control ui-select-toggle'])[1]";
	static String addressSearchXpath = "/html/body/div/bw-purchase-requisition-details/section/pal-two-col-row/div/div[1]/div/pal-two-col-row-left-content/div/bw-purchase-common-header-address-panel/div/div[2]/div/div[1]/div[2]/div/bw-common-purchase-address-editor/div/section[1]/div[1]/div/input[1]";
	static String addressSelect1Xpath = "//span[@class='ui-select-highlight' and contains(text(),'";
	static String addressSelect2Xpath = "')]";
	static String addressSaveButtonXpath = "//button[@type='button' and @class='btn btn-pal-actions-button ng-scope']";
	
	static String editCodingDivXpath = "//div[@class='psl-col psl-col-0 psl-col-align-base ng-scope']";
	static String editCodingDivButtonXpath = "document.querySelector('#line-list > div.pal-catalog-container > div > pal-catalog-list > div > div.pal-catalog-list-items > pal-catalog-items > pal-catalog-item > div > div > div > div.psl-col.psl-col-0.psl-col-align-base.ng-scope > bw-personal-requisition-details-line-actions > pal-actions > div > div > div > div.actions-toggle-button-group > button')";
	static String editCodingXpath = "(//div[@class='actions-toggle-button-group'])[3]//child::button[@class='btn dropdown-toggle ng-scope dropdown-toggle-secondary use-dropdown-style']";
	static String editCodingButtonXpath =  "//button[@class='dropdown-btn btn-pal-actions-button']//child::span[contains(text(),'Edit coding')]";   //"(//button[@class='dropdown-btn btn-pal-actions-button'])[2]";
	static String viewCodingXpath = "//div[@class='view-coding']";
	static String natureJSXpath = "document.evaluate(\"//div[@aria-label='Nature']//span[@class='psl-icon-caret-down']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue";
	static String natureDivXpath = "(//div[@class='pal-single-select-dropdown-header'])[2]";
	static String natureSearchXpath = "/html/body/div/bw-purchase-requisition-details/section/pal-two-col-row/div/div[1]/div/pal-two-col-row-left-content/div/bw-personal-requisition-details-lines/div/div/div[2]/div/div/pal-catalog/div[1]/div/pal-catalog-list/div/div[2]/pal-catalog-items/pal-catalog-item/div/div[2]/div[2]/div[3]/div/bw-purchase-requisition-coding-row-editor/div/div[1]/pal-detail-fields/div/pal-detail-field[4]/div/div/bw-purchase-requisition-panel-field/div/bw-purchase-panel-field-switch/div/div/div/bw-lookup-list/div/pal-single-select/div/div[2]/pal-single-select-dropdown/div/div[1]/div/input";
	static String natureSearch1Xpath ="(//span[@class='psl-icon-search ng-scope'])[2]";
	static String natureSelect1Xpath = "//span[@class='ui-select-highlight' and contains(text(),'";
	static String natureSelect2Xpath = "')]";
	static String agencyXpath = "(//button[@class='pal-single-select-toggle-btn' ])[3]";
	static String agencyDivXpath = "(//div[@class='pal-single-select-dropdown-header'])[3]";
	static String agencySearchXpath = "/html/body/div/bw-purchase-requisition-details/section/pal-two-col-row/div/div[1]/div/pal-two-col-row-left-content/div/bw-personal-requisition-details-lines/div/div/div[2]/div/div/pal-catalog/div[1]/div/pal-catalog-list/div/div[2]/pal-catalog-items/pal-catalog-item/div/div[2]/div[2]/div[3]/div/bw-purchase-requisition-coding-row-editor/div/div[1]/pal-detail-fields/div/pal-detail-field[6]/div/div/bw-purchase-requisition-panel-field/div/bw-purchase-panel-field-switch/div/div/div/bw-lookup-list/div/pal-single-select/div/div[2]/pal-single-select-dropdown/div/div[1]/div/input";
	static String agencySearch1Xpath ="(//span[@class='psl-icon-search ng-scope'])[3]";
	static String agencySelect1Xpath = "//span[@class='ui-select-highlight' and starts-with(text(),'";
	static String agencySelect2Xpath = "')]//parent::span[@class='ng-binding' and not(text()[normalize-space(.)])]";
	static String sspXpath = "(//button[@class='pal-single-select-toggle-btn' ])[4]";
	static String sspDivXpath = "(//div[@class='pal-single-select-dropdown-header'])[4]";
	static String sspSearchXpath = "/html/body/div/bw-purchase-requisition-details/section/pal-two-col-row/div/div[1]/div/pal-two-col-row-left-content/div/bw-personal-requisition-details-lines/div/div/div[2]/div/div/pal-catalog/div[1]/div/pal-catalog-list/div/div[2]/pal-catalog-items/pal-catalog-item/div/div[2]/div[2]/div[3]/div/bw-purchase-requisition-coding-row-editor/div/div[1]/pal-detail-fields/div/pal-detail-field[8]/div/div/bw-purchase-requisition-panel-field/div/bw-purchase-panel-field-switch/div/div/div/bw-lookup-list/div/pal-single-select/div/div[2]/pal-single-select-dropdown/div/div[1]/div/input";
	static String sspSearch1Xpath ="(//span[@class='psl-icon-search ng-scope'])[4]";
	static String sspSelect1Xpath = "//span[@class='ui-select-highlight' and starts-with(text(),'";
	static String sspSelect2Xpath = "')]//parent::span[@class='ng-binding' and not(text()[normalize-space(.)])]";
	static String realEstateReferenceXpath="(//button[@class='pal-single-select-toggle-btn' ])[7]";
	static String realEstateReferenceDivXpath="(//div[@class='pal-single-select-dropdown-header'])[7]";
	static String realEstateReferenceSearchXpath="/html/body/div/bw-purchase-requisition-details/section/pal-two-col-row/div/div[1]/div/pal-two-col-row-left-content/div/bw-personal-requisition-details-lines/div/div/div[2]/div/div/pal-catalog/div[1]/div/pal-catalog-list/div/div[2]/pal-catalog-items/pal-catalog-item/div/div[2]/div[2]/div[3]/div/bw-purchase-requisition-coding-row-editor/div/div[1]/pal-detail-fields/div/pal-detail-field[15]/div/div/bw-purchase-requisition-panel-field/div/bw-purchase-panel-field-switch/div/div/div/bw-lookup-list/div/pal-single-select/div/div[2]/pal-single-select-dropdown/div/div[1]/div/input";
	static String realEstateReferenceSearch1Xpath ="(//span[@class='psl-icon-search ng-scope'])[7]";
	static String realEstateReferenceSelect1Xpath = "//span[@class='ui-select-highlight' and contains(text(),'";
	static String realEstateReferenceSelect2Xpath = "')]";
	static String approverXpath ="(//button[@class='pal-single-select-toggle-btn' ])[8]";
	static String approverDivXpath="(//div[@class='pal-single-select-dropdown-header'])[8]";
	static String approverSearchXpath="/html/body/div/bw-purchase-requisition-details/section/pal-two-col-row/div/div[1]/div/pal-two-col-row-left-content/div/bw-personal-requisition-details-lines/div/div/div[2]/div/div/pal-catalog/div[1]/div/pal-catalog-list/div/div[2]/pal-catalog-items/pal-catalog-item/div/div[2]/div[2]/div[3]/div/bw-purchase-requisition-coding-row-editor/div/div[1]/pal-detail-fields/div/pal-detail-field[17]/div/div/bw-purchase-requisition-panel-field/div/bw-purchase-panel-field-switch/div/div/div/bw-lookup-list/div/pal-single-select/div/div[2]/pal-single-select-dropdown/div/div[1]/div/input";
	static String approverSearch1Xpath ="(//span[@class='psl-icon-search ng-scope'])[8]";
	static String approverSelect1Xpath = "//span[@class='ui-select-highlight' and contains(text(),'";
	static String approverSelect2Xpath = "')]";
	static String editCodeSaveButtonXpath = "//button[@class='btn btn-pal-actions-button ng-scope']";
	static String viewDetailsXpath = "(//button[@class='btn dropdown-toggle ng-scope dropdown-toggle-secondary use-dropdown-style'])[1]";
	static String viewDetailsButtonXpath = "(//button[@class='dropdown-btn btn-pal-actions-button'])[1]";
	
	
	public EditCoding(WebDriver driver) {
		super(driver);
		
	}
	
	
	
	public EditCoding headerData(String requester) {
	    if(!requester.isEmpty()) {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(requesterXpath))).click();
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(requesterSearchXpath))).sendKeys(requester);
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(requesterSelect1Xpath+requester+requesterSelect2Xpath))).click();
	    }
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(headerDataSaveXpath))).click();
	
		return this;
	}
	
	
	public EditCoding addAddress(String deliveryAddress) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addAdressEditButtonXpath))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addAdressEditButtonXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addressXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addressSearchXpath))).sendKeys(deliveryAddress);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addressSelect1Xpath+deliveryAddress+addressSelect2Xpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addressSaveButtonXpath))).click();
		
	
		return this;
	}
	
	//Add viewDetails Button Common method
	
	public EditCoding viewDetailsButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewDetailsXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(viewDetailsXpath))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(viewDetailsButtonXpath))).click();
		return this;
	}
	
	public EditCoding editCodingFR(JavascriptExecutor javascriptExecutor,String nature,String agency,String type,String realEstateReference,String prType,String Approver,String ssp) throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(editCodingDivXpath)));
		webelement = (WebElement) javascriptExecutor.executeScript("return "+editCodingDivButtonXpath);
		javascriptExecutor.executeScript("arguments[0].click()",webelement);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(editCodingXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(editCodingButtonXpath))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewCodingXpath)));
		
		Thread.sleep(2000);
		webelement = (WebElement) javascriptExecutor.executeScript("return "+natureJSXpath);
		javascriptExecutor.executeScript("arguments[0].click()",webelement);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(natureDivXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(natureSearchXpath))).sendKeys(nature);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(natureSearch1Xpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(natureSearchXpath))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(natureSearchXpath))).sendKeys(nature);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(natureSearch1Xpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(natureSelect1Xpath+nature+natureSelect2Xpath))).click();
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(agencyXpath)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencyXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencyDivXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySearchXpath))).sendKeys(agency);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySearch1Xpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySearchXpath))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySearchXpath))).sendKeys(agency);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySearch1Xpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySelect1Xpath+agency+agencySelect2Xpath))).click();
		
		
		// ssp coding
		if(type.equalsIgnoreCase("A")) {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspXpath))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspDivXpath))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspSearchXpath))).sendKeys(ssp);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspSearch1Xpath))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspSearchXpath))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspSearchXpath))).sendKeys(ssp);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspSearch1Xpath))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspSelect1Xpath+ssp+sspSelect2Xpath))).click();
	
		}
	
	
		if(!realEstateReference.isEmpty()) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(realEstateReferenceXpath))).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(realEstateReferenceDivXpath))).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(realEstateReferenceSearchXpath))).sendKeys(realEstateReference);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(realEstateReferenceSearch1Xpath))).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(realEstateReferenceSearchXpath))).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(realEstateReferenceSearchXpath))).sendKeys(realEstateReference);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(realEstateReferenceSearch1Xpath))).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(realEstateReferenceSelect1Xpath+realEstateReference+realEstateReferenceSelect2Xpath))).click();
		
		}
	
		if (prType.equalsIgnoreCase("DI")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(approverXpath))).click(); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(approverDivXpath))).click(); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(approverSearchXpath))).sendKeys(Approver); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(approverSearch1Xpath))).click(); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(approverSearchXpath))).clear(); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(approverSearchXpath))).sendKeys(Approver); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(approverSearch1Xpath))).click(); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(approverSelect1Xpath + Approver + approverSelect2Xpath))).click();
		}
		 		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(editCodeSaveButtonXpath))).click();
		
		return this;
		
	}
	
	public EditCoding  editCoding(JavascriptExecutor javascriptExecutor,String nature,String agency,String type, String ssp)throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(editCodingDivXpath)));
		
		webelement = (WebElement) javascriptExecutor.executeScript("return "+editCodingDivButtonXpath);
		javascriptExecutor.executeScript("arguments[0].click()",webelement);
		
		
	//  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProvidePom.editCodingXpath))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(editCodingXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(editCodingButtonXpath))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewCodingXpath)));
		
		Thread.sleep(2000);
		webelement = (WebElement) javascriptExecutor.executeScript("return "+natureJSXpath);
		javascriptExecutor.executeScript("arguments[0].click()",webelement);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(natureDivXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(natureSearchXpath))).sendKeys(nature);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(natureSearch1Xpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(natureSearchXpath))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(natureSearchXpath))).sendKeys(nature);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(natureSearch1Xpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(natureSelect1Xpath+nature+natureSelect2Xpath))).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProvidePom.natureNameSelect1Xpath+nature+ProvidePom.natureNameSelect2Xpath)));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencyXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencyDivXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySearchXpath))).sendKeys(agency);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySearch1Xpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySearchXpath))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySearchXpath))).sendKeys(agency);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySearch1Xpath))).click();
		System.out.println(agency);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySelect1Xpath+agency+agencySelect2Xpath))).click();
		
		// ssp coding
		if(type.equalsIgnoreCase("A")) {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspXpath))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspDivXpath))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspSearchXpath))).sendKeys(ssp);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspSearch1Xpath))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspSearchXpath))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspSearchXpath))).sendKeys(ssp);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspSearch1Xpath))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspSelect1Xpath+ssp+sspSelect2Xpath))).click();
			
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(editCodeSaveButtonXpath))).click();
		return this;
		
	}
	
	public ViewDetails viewDetailsSBS(JavascriptExecutor javascriptExecutor,String requestor,String deliveryAddress,String nature,String agency,String type,String realEstateReference,String prType,String Approver,String ssp) throws InterruptedException {
		headerData(requestor).
		addAddress(deliveryAddress).
		editCodingFR(javascriptExecutor, nature, agency, type, realEstateReference, prType, Approver, ssp).
		viewDetailsButton();
		
		return new ViewDetails(driver); 
	}
	
	public ViewDetails viewDetailsGalitt(JavascriptExecutor javascriptExecutor,String requestor,String deliveryAddress,String nature,String agency,String type,String prType,String ssp) throws InterruptedException {
		headerData(requestor).
		addAddress(deliveryAddress).
		editCoding(javascriptExecutor, nature, agency, type, ssp).
		viewDetailsButton();
		
		return new ViewDetails(driver); 
	}
	
	public ViewDetails viewDetailsBeleux(JavascriptExecutor javascriptExecutor,String requestor,String deliveryAddress,String nature,String agency,String type,String prType,String ssp) throws InterruptedException {
		headerData(requestor).
		addAddress(deliveryAddress).
		editCoding(javascriptExecutor, nature, agency, type, ssp).
		viewDetailsButton();
		
		return new ViewDetails(driver); 
	}
	
	public ViewDetails viewDetailsSpain(JavascriptExecutor javascriptExecutor,String requestor,String deliveryAddress,String nature,String agency,String type,String prType,String ssp) throws InterruptedException {
		headerData(requestor).
		addAddress(deliveryAddress).
		editCoding(javascriptExecutor, nature, agency, type, ssp).
		viewDetailsButton();
		
		return new ViewDetails(driver); 
	}
	
	public ViewDetails viewDetailsFrance(JavascriptExecutor javascriptExecutor,String requestor,String deliveryAddress,String nature,String agency,String type,String realEstateReference,String prType,String Approver,String ssp) throws InterruptedException {
		headerData(requestor).
		addAddress(deliveryAddress).
		editCodingFR( javascriptExecutor, nature, agency, type, realEstateReference, prType, Approver, ssp).
		viewDetailsButton();
		
		return new ViewDetails(driver); 
	}


}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BasePage;

public class EditRequisition extends BasePage {
	

	static String orderDescription = "//div[@class='text ng-scope']//child::pal-field-container[@label='Description *']//child::input[@type='text']";
	static String supplierProductName = "//div[@class='text ng-scope']//child::pal-field-container[@label='Product name ']//child::input[@type='text']";
	static String supplierSelect1Xpath = "//span[@class='ui-select-highlight' and contains(text(),'";
	static String supplierSelect2Xpath = "')]//parent::span[@class='ng-binding']";
	static String supplierProductNameSBS136SubcontractingXpath= "/html/body/div/section/section/section/div/form/ul/li[2]/span/div/bw-freetext-field-switcher/div/div/bw-freetext-text-field/pal-field-container/div/div/div/input";
	static String purchaseCategoryButtonXpath = "//button[@type='button' and @class='pal-tree-select-toggle-btn ng-invalid']";
	static String purchaseCategorySearchXpath = "/html/body/div/section/section/section/div/form/ul/li[3]/span/div/bw-freetext-field-switcher/div/div/bw-freetext-category-field/pal-field-container/div/div/div/pal-tree-single-select/div/div[2]/pal-tree-view/div/div[1]/div/input";
	static String purchaseCategoryButtonFRXpath="//button[@class='pal-tree-select-toggle-btn ng-invalid']";
	static String purchaseCategorySearchFRXpath="/html/body/div/section/section/section/div/form/ul/li[2]/span/div/bw-freetext-field-switcher/div/div/bw-freetext-category-field/pal-field-container/div/div/div/pal-tree-single-select/div/div[2]/pal-tree-view/div/div[1]/div/input";
	// Change of Purchase category Xpath  (class from  'pal-tree-item-label ng-binding'   to   'pal-tree-item-checkbox-container' )
	// Change Xpath value of Purchase category .
	static String purchaseCategorySelect1Xpath = "//span[@class='ui-select-highlight' and contains(text(),'"; 
	static String purchaseCategorySelect2Xpath = "')]//parent::span[@class='pal-tree-item-label ng-binding']//parent::span";
	
    static String supplierButtonXpath = "//div[@aria-label='Supplier *']//child::button";
	static String supplierSearchXpath = "//div[@aria-label='Supplier *']//child::input[@aria-label='Supplier *']";
	static String supplierSelect1XpathFR="//span[@class='ui-select-highlight' and contains(text(),'";
	static String supplierSelect2XpathFR = "')]";
	static String quantityXpath = "//div[@class='decimal ng-scope']//child::pal-field-container[@label='Quantity *']//child::input";
	static String unitPriceXpath = "//div[@class='decimal ng-scope']//child::pal-field-container[@label='Unit Price *']//child::input";
	static String currencyButtonXpath="//pal-field-container[@label='Currency *']//child::button";
	static String currencySearchXpath="//input[@type='text' and @aria-label='Currency *']";
	static String currencySearch1Xpath="//span[@class='ui-select-highlight' and contains(text(),'";
	static String currencySearch2Xpath = "')]";
	static String editRequisitionXpath = "(//button[@class='btn btn-pal-actions-button ng-scope' and @title ='Edit requisition'])[1]";
    static String codeProductXpathFR="//input[@class='form-control ng-pristine ng-untouched ng-valid ng-scope ng-isolate-scope ng-empty ng-valid-required ng-valid-minlength ng-valid-maxlength']";
	static String prTypeButtonXpath = "/html/body/div/section/section/section/div/form/ul/li[8]/span/div/bw-freetext-field-switcher/div/div/bw-freetext-lookup-field/pal-field-container/div/div/div/pal-single-select/div/div[1]/div";
	static String prTypeSearchXpath = "/html/body/div/section/section/section/div/form/ul/li[8]/span/div/bw-freetext-field-switcher/div/div/bw-freetext-lookup-field/pal-field-container/div/div/div/pal-single-select/div/div[2]/pal-single-select-dropdown/div/div[1]/div/input";
	static String prTypeSelect1Xpath = "//span[@class='ui-select-highlight' and contains(text(),'";
	static String prTypeSelect2Xpath = "')]";
    static String purchaseCategorySearchXpathFR  ="/html/body/div/section/section/section/div/form/ul/li[2]/span/div/bw-freetext-field-switcher/div/div/bw-freetext-category-field/pal-field-container/div/div/div/pal-tree-single-select/div/div[2]/pal-tree-view/div/div[1]/div/input";
	static String supplierProductNameFR="/html/body/div/section/section/section/div/form/ul/li[4]/span/div/bw-freetext-field-switcher/div/div/bw-freetext-text-field/pal-field-container/div/div/div/input";
	static String supplierSearchXpathFR="/html/body/div/section/section/section/div/form/ul/li[5]/span/div/bw-freetext-field-switcher/div/div/bw-freetext-category-supplier-field/pal-field-container/div/div/div/pal-single-select/div/div[2]/pal-single-select-dropdown/div/div[1]/div/input";
	static String quantityXpathFR="/html/body/div/section/section/section/div/form/ul/li[6]/span/div/bw-freetext-field-switcher/div/div/bw-freetext-decimal-field/pal-field-container/div/div/div/input";
	static String unitPriceXpathFR="/html/body/div/section/section/section/div/form/ul/li[7]/span/div/bw-freetext-field-switcher/div/div/bw-freetext-decimal-field/pal-field-container/div/div/div/input";
	static String currencyButtonXpathFR="/html/body/div/section/section/section/div/form/ul/li[8]/span/div/bw-freetext-field-switcher/div/div/bw-freetext-lookup-field/pal-field-container/div/div/div/pal-single-select/div/div[1]/button";
	static String currencySearchXpathFR="/html/body/div/section/section/section/div/form/ul/li[8]/span/div/bw-freetext-field-switcher/div/div/bw-freetext-lookup-field/pal-field-container/div/div/div/pal-single-select/div/div[2]/pal-single-select-dropdown/div/div[1]/div/input";
	static String currencySearch1XpathFR="//span[@class='ui-select-highlight' and contains(text(),'";
	static String currencySearch2XpathFR = "')]";
	static String prTypeButtonXpathFR="/html/body/div/section/section/section/div/form/ul/li[9]/span/div/bw-freetext-field-switcher/div/div/bw-freetext-lookup-field/pal-field-container/div/div/div/pal-single-select/div/div[1]/button";
	static String prTypeSearchXpathFR="/html/body/div/section/section/section/div/form/ul/li[9]/span/div/bw-freetext-field-switcher/div/div/bw-freetext-lookup-field/pal-field-container/div/div/div/pal-single-select/div/div[2]/pal-single-select-dropdown/div/div[1]/div/input";
	static String prTypeSelect1XpathFR = "//span[@class='ui-select-highlight' and contains(text(),'";
	static String prTypeSelect2XpathFR = "')]";

	public EditRequisition(WebDriver driver) {
		super(driver);
	}
	
	public EditRequisition editRequisition(ExtentTest test, String orderDesc ,String productName,String purchaseCategory,String supplier,String quantity,String unitPrice,String currency,String prType) throws InterruptedException {
		
		test.log(Status.INFO, "Enter Order Description");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(orderDescription))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(orderDescription))).sendKeys(orderDesc);
		test.log(Status.PASS, "Successful Order Description");

		test.log(Status.INFO, "Enter Product Name");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierProductName))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierProductName))).sendKeys(productName);
		test.log(Status.PASS, "Successful Product Name");
		
		test.log(Status.INFO, "Enter Purchase Category");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(purchaseCategoryButtonXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(purchaseCategorySearchXpath))).sendKeys(purchaseCategory);
		test.log(Status.INFO, "Select  Purchase Category if Purchase category is correct and available");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(purchaseCategorySelect1Xpath+purchaseCategory+purchaseCategorySelect2Xpath))).click();
		test.log(Status.PASS, "Successful Purchase Category");
		
		test.log(Status.INFO, "Enter Supplier");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierButtonXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierSearchXpath))).sendKeys(supplier);
		test.log(Status.INFO, "Select Supplier if Supplier is correct and available");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierSelect1Xpath+supplier+supplierSelect2Xpath))).click();
		test.log(Status.PASS, "Successful Supplier");
		
		test.log(Status.INFO, "Enter Quantity");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(quantityXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(quantityXpath))).sendKeys(quantity);
		test.log(Status.PASS, "Successful Quantity");
		
		test.log(Status.INFO, "Enter Unit Price");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unitPriceXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unitPriceXpath))).sendKeys(unitPrice);
		test.log(Status.PASS, "Successful Unit Price");
		
		
			currency=currency.toUpperCase();
			test.log(Status.INFO, "Enter Currency");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currencyButtonXpath))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currencySearchXpath))).sendKeys(currency);
			test.log(Status.INFO, "Select Currency if Currency is correct and available");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currencySearch1Xpath+currency+currencySearch2Xpath))).click();
			test.log(Status.PASS, "Successful Currency");
			
			if(!prType.isEmpty()) {	
		test.log(Status.INFO, "Enter Pr Type if available");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prTypeButtonXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prTypeSearchXpath))).sendKeys(prType);
		test.log(Status.INFO, "Select Pr Type if is correct and available");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prTypeSelect1Xpath+prType+prTypeSelect2Xpath))).click();
		test.log(Status.PASS, "Successful PR Type");
			}
			
		test.log(Status.INFO, "Click Edit Requisition Button ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(editRequisitionXpath))).click();
		Thread.sleep(10000);
		return this;
	}
	
	
	public EditRequisition editRequisitionFrance(String orderDesc ,String purchaseCategory,String productName,String supplier,String quantity,String unitPrice,String currency,String prType) {
		 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(orderDescription))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(orderDescription))).sendKeys(orderDesc);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(purchaseCategoryButtonXpath))).click();
		
		if(prType.equalsIgnoreCase("DI")) {
			purchaseCategory= purchaseCategory.substring(0, 1)+purchaseCategory.substring(1,purchaseCategory.length()).toUpperCase();
		System.out.println(purchaseCategory);
		}
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(purchaseCategorySelect1Xpath+purchaseCategory+purchaseCategorySelect2Xpath))).click();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierProductNameFR))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierProductNameFR))).sendKeys(productName);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierButtonXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierSearchXpathFR))).sendKeys(supplier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierSelect1XpathFR+supplier+supplierSelect2XpathFR))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(quantityXpathFR))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(quantityXpathFR))).sendKeys(quantity);
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unitPriceXpathFR))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unitPriceXpathFR))).sendKeys(unitPrice);
		
			currency=currency.toUpperCase();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currencyButtonXpathFR))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currencySearchXpathFR))).sendKeys(currency);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currencySearch1XpathFR+currency+currencySearch2XpathFR))).click();
			
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prTypeButtonXpathFR))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prTypeSearchXpathFR))).sendKeys(prType);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prTypeSelect1XpathFR+prType+prTypeSelect2XpathFR))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(editRequisitionXpath))).click();
		
		return this;
	}
	
	
	
	public EditRequisition subcontractingAndLogistics(String orderDescr ,String purchaseCategory,String productName,String supplier,String quantity,String unitPrice,String currency,String prType) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(orderDescription))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(orderDescription))).sendKeys(orderDescr);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierProductNameSBS136SubcontractingXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierProductNameSBS136SubcontractingXpath))).sendKeys(productName);
		
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(purchaseCategoryButtonXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(purchaseCategorySearchXpath))).sendKeys(purchaseCategory);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(purchaseCategorySelect1Xpath+purchaseCategory+purchaseCategorySelect2Xpath))).click();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierButtonXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierSearchXpath))).sendKeys(supplier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierSelect1XpathFR+supplier+supplierSelect2XpathFR))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(quantityXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(quantityXpath))).sendKeys(quantity);
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unitPriceXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unitPriceXpath))).sendKeys(unitPrice);
		
		
			currency=currency.toUpperCase();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currencyButtonXpath))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currencySearchXpath))).sendKeys(currency);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currencySearch1Xpath+currency+currencySearch2Xpath))).click();
			
			
			// check logistic and subcontracting have prtype field
			if(!prType.isEmpty()) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prTypeButtonXpath))).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prTypeSearchXpath))).sendKeys(prType);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prTypeSelect1Xpath+prType+prTypeSelect2Xpath))).click();
			}
			
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(editRequisitionXpath))).click();
	
		
		return this;
	}
	
	
	
	public EditRequisition standard(String purchaseCategory,String codeProduct,String productName,String supplier,String quantity,String unitPrice,String currency,String prType) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(purchaseCategoryButtonXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(purchaseCategorySearchXpath))).sendKeys(purchaseCategory);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(purchaseCategorySelect1Xpath+purchaseCategory+purchaseCategorySelect2Xpath))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(codeProductXpathFR))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(codeProductXpathFR))).sendKeys(productName);
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierButtonXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierSearchXpath))).sendKeys(supplier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierSelect1XpathFR+supplier+supplierSelect2XpathFR))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(quantityXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(quantityXpath))).sendKeys(quantity);
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unitPriceXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unitPriceXpath))).sendKeys(unitPrice);
		
		
			currency=currency.toUpperCase();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currencyButtonXpath))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currencySearchXpath))).sendKeys(currency);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currencySearch1Xpath+currency+currencySearch2Xpath))).click();
			
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prTypeButtonXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prTypeSearchXpath))).sendKeys(prType);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prTypeSelect1Xpath+prType+prTypeSelect2Xpath))).click();
		
		
		return this;

	}
	
	
	public EditRequisition diAndDa(String purchaseCategory,String codeProduct,String productName,String supplier,String quantity,String unitPrice,String currency,String prType) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(purchaseCategoryButtonXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(purchaseCategorySearchXpathFR))).sendKeys(purchaseCategory);
		
		if(prType.equalsIgnoreCase("DI")) {
			purchaseCategory= purchaseCategory.substring(0, 1)+purchaseCategory.substring(1,purchaseCategory.length()).toUpperCase();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(purchaseCategorySelect1Xpath+purchaseCategory+purchaseCategorySelect2Xpath))).click();
	
	// code Product
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(codeProductXpathFR))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(codeProductXpathFR))).sendKeys(codeProduct);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierProductNameFR))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierProductNameFR))).sendKeys(productName);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierButtonXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierSearchXpathFR))).sendKeys(supplier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierSelect1XpathFR+supplier+supplierSelect2XpathFR))).click();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(quantityXpathFR))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(quantityXpathFR))).sendKeys(quantity);
	
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unitPriceXpathFR))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unitPriceXpathFR))).sendKeys(unitPrice);
	
	
		currency=currency.toUpperCase();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currencyButtonXpathFR))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currencySearchXpathFR))).sendKeys(currency);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currencySearch1XpathFR+currency+currencySearch2XpathFR))).click();
		

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prTypeButtonXpathFR))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prTypeSearchXpathFR))).sendKeys(prType);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prTypeSelect1XpathFR+prType+prTypeSelect2XpathFR))).click();
		
		return this;
	}
		
	public EditCoding editCodingSBS(String OrderDesc,String PurchaseCategory,String ProductCode,String ProductName,String Supplier, String Quantity,String UnitPrice,String Currency,String PrTYPE,String PRForm) {
		
		if(PRForm.equalsIgnoreCase("Subcontracting") || PRForm.equalsIgnoreCase("Logistics")) {
			subcontractingAndLogistics(OrderDesc , PurchaseCategory, ProductName, Supplier, Quantity, UnitPrice, Currency,PrTYPE);			
		}
		else {			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(orderDescription))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(orderDescription))).sendKeys(OrderDesc);				
			if(PRForm.equalsIgnoreCase("Standard")) {
				standard( PurchaseCategory, ProductCode, ProductName, Supplier, Quantity, UnitPrice, Currency, PrTYPE);
			} else {				
				diAndDa(  PurchaseCategory, ProductCode, ProductName, Supplier, Quantity, UnitPrice, Currency, PrTYPE);
			}			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(editRequisitionXpath))).click();			
		}
		return new EditCoding(driver);
	}
	
	
	public EditCoding editCodingGalitt(ExtentTest test,String OrderDesc,String ProductName,String PurchaseCategory,String Supplier, String Quantity,String UnitPrice,String Currency,String PrTYPE) throws InterruptedException {		
		editRequisition( test, OrderDesc , ProductName, PurchaseCategory, Supplier, Quantity, UnitPrice, Currency, PrTYPE);
		return new EditCoding(driver);
	}
	
	public EditCoding editCodingBeleux(ExtentTest test,String OrderDesc,String ProductName,String PurchaseCategory,String Supplier, String Quantity,String UnitPrice,String Currency,String PrTYPE) throws InterruptedException {		
		editRequisition( test,OrderDesc , ProductName, PurchaseCategory, Supplier, Quantity, UnitPrice, Currency, PrTYPE);
		return new EditCoding(driver);
	}
	
	public EditCoding editCodingSpain(ExtentTest test,String OrderDesc,String ProductName,String PurchaseCategory,String Supplier, String Quantity,String UnitPrice,String Currency,String PrTYPE) throws InterruptedException {
		editRequisition( test,OrderDesc , ProductName, PurchaseCategory, Supplier, Quantity, UnitPrice, Currency, PrTYPE);
		return new EditCoding(driver);
	}
	
	public EditCoding editCodingFrance(ExtentTest test,String OrderDesc,String ProductName,String PurchaseCategory,String Supplier, String Quantity,String UnitPrice,String Currency,String PrTYPE) {	
		editRequisitionFrance( OrderDesc ,PurchaseCategory, ProductName, Supplier, Quantity, UnitPrice, Currency, PrTYPE);
		return new EditCoding(driver);
	}
	
	
	public EditCoding editCoding(ExtentTest test,String OrderDesc,String ProductName,String PurchaseCategory,String Supplier, String Quantity,String UnitPrice,String Currency,String PrTYPE) throws InterruptedException {		
		editRequisition(test, OrderDesc , ProductName, PurchaseCategory, Supplier, Quantity, UnitPrice, Currency, PrTYPE);
		return new EditCoding(driver);	
	}



}

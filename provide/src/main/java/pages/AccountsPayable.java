package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class AccountsPayable extends BasePage {

	
	static String recievedStageXpath = "//div[@class='chart-caption ng-star-inserted' and contains(text(),'Received')]";
	static String invoiceXpath = "(//input[@class='pt-input ng-untouched ng-pristine ng-valid'])[1]";
	static String invoiceSearchXpath="//button[@class='pt-btn' and contains(text(),'Search')]";
	
	static String poXpath="//button[@aria-labelledby='OrderNumbers']";
	static String poDivXpath="//div[contains(text(),'Search for purchase order number')]";
	
	static String poSearchXpath="//input[@placeholder='Order number']";
	static String poSearchButtonXpath="//button[@class='pt-btn pt-btn-primary search-button' and contains(text(),'Search')]";
	static String poNumberVerify1Xpath="//span[@class='label' and contains(text(),'";
	static String poNumberVerify2Xpath="')]";
	static String poNumberTabCancelXpath="//button[@title='Cancel']";
	static String poNumberSelectXpath="//button[@class='pt-btn select-btn' and contains(text(),'Select')]";

	
	static String poSelect1Xpath="//span[@class='pt-highlighted-text' and contains(text(),'";
	static String poSelect2Xpath="')]";
	
	static String supplierCodeXpath="(//div[@class='pt-select-combobox-main'])[3]";   //(//ul[@class='pt-select-selections ng-star-inserted'])[1]
	static String supplierCodeDivXpath="(//div[@class='pt-select-selection-label'])[1]";  // //div[@class='pt-select-dropdown-header ng-star-inserted']
	static String supplierCodeSearchXpath="(//div[@class='pt-select-selection-label'])[2]";
	static String supplierCodeSelect1Xpath="//span[@class='pt-highlighted-text' and contains(text(),'";
	static String supplierCodeSelect2Xpath="')]";
	
	// xpaths for Supplier code
	
	static String supplierCodeButtonXpath="(//button[@class='pt-select-toggle-btn' and @aria-labelledby='SupplierCode'])"; 
	static String supplierCodePanelXpath="/html/body/pt-floating-panel";
	static String supplierCodeSearchContainerXpath="//div[@class='searchContainer']";
	static String supplierCodeInputXpath="//input[@placeholder='Search for supplier information']";
	static String supplierCodeSelectXpath="(//button[@class='pt-btn action-input-modal-btn' and not(@disabled)])";
	static String supplierSearchInputXpath="//pt-search-input[@class='search-input']";
	
	static String invoiceDateXpath="//input[@aria-labelledby='InvoiceDate']";
	
	static String netSumXpath="//input[@aria-labelledby='NetSum']";
	static String taxSumXpath="//input[@aria-labelledby='TaxSum']";
	static String saveButtonXpath="//button[@class='pt-btn' and contains(text(),'Save')]";
	static String matLabLabelsXpath="(//div[@class='mat-tab-labels'])[1]";
	static String matTabLabelsXpath= "//div[@id='mat-tab-label-0-1']";
		
	static String approverXpath="//label[contains(text(),' Approver ')]//following-sibling::div//child::button[@title='Expand']";
	static String approverDivXpath="//div[@class='pt-select-dropdown-header ng-star-inserted']";
	static String approverSearchXpath="//div[@class='pt-select-dropdown-header ng-star-inserted']//child::input";
	static String approverSelectXpath="//span[@class='pt-item-list-item-header']";
	static String approverSelect1Xpath="//span[@class='pt-highlighted-text' and contains(text(),'";
	static String approverSelect2Xpath="')]";
	
	static String addNewLineXpath="//button[@class='pt-btn pt-btn-link ng-star-inserted']";
	static String addNewLineGridXpath="(//div[@class='grid-container'])[2]";
	
	static String purchaseCategoryXpath="/html/body/bw-root/ia-invoices/pt-split-view/div/div[2]/div[2]/div/ia-invoice-coding/pt-tabs/mat-tab-group/div/mat-tab-body/div/div/div/gl-document-rows/div/gl-fields-grid/gl-grid/pt-grid/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[9]/gl-lookup-list-renderer/span";
    
	static String purchaseCategoryDivXpath="//div[@class='pt-select-dropdown-header ng-star-inserted']";
	static String purchaseCategorySearchXpath="//div[@class='pt-select-dropdown-header ng-star-inserted']//child::input";
	static String purchaseCategorySelect1Xpath="//span[@class='pt-highlighted-text' and contains(text(),'";
	static String purchaseCategorySelect2Xpath="')]";
	static String purchaseCategorySelectXpath="//span[@class='pt-item-list-item-header']";
	
	static String imputationXpath="(//span[@class='text-align-left ng-star-inserted'])[3]";
	
	static String natureCodeXpath="/html/body/bw-root/ia-invoices/pt-split-view/div/div[2]/div[2]/div/ia-invoice-coding/pt-tabs/mat-tab-group/div/mat-tab-body/div/div/div/gl-document-rows/div/gl-fields-grid/gl-grid/pt-grid/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[11]/gl-lookup-list-renderer//child::span[@title!='']";
	static String agencySiteXpath= "/html/body/bw-root/ia-invoices/pt-split-view/div/div[2]/div[2]/div/ia-invoice-coding/pt-tabs/mat-tab-group/div/mat-tab-body/div/div/div/gl-document-rows/div/gl-fields-grid/gl-grid/pt-grid/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[12]/gl-lookup-list-renderer/span";
	static String agencySiteDivXpath="//div[@class='pt-select-dropdown-header ng-star-inserted']";
	static String agencySiteSearchXpath="//div[@class='pt-select-dropdown-header ng-star-inserted']//child::input";
	static String agencySiteSelect1Xpath="//span[@class='pt-highlighted-text' and contains(text(),'";
	static String agencySiteSelect2Xpath="')]";
	static String agencySiteSelectXpath="//span[@class='pt-item-list-item-header']";
	static String agencySiteVisibleXpath="/html/body/bw-root/ia-invoices/pt-split-view/div/div[2]/div[2]/div/ia-invoice-coding/pt-tabs/mat-tab-group/div/mat-tab-body/div/div/div/gl-document-rows/div/gl-fields-grid/gl-grid/pt-grid/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[13]/gl-lookup-list-renderer//child::span[@title!='']";
	
	static String horizontalScrollPortXpath="(//div[@class='ag-body-horizontal-scroll-viewport'])[2]";
	static String horizontalScrollXpath="/html/body/bw-root/ia-invoices/pt-split-view/div/div[2]/div[2]/div/ia-invoice-coding/pt-tabs/mat-tab-group/div/mat-tab-body/div/div/div/gl-document-rows/div/gl-fields-grid/gl-grid/pt-grid/ag-grid-angular/div/div[2]/div[2]/div[5]/div[2]";
	static String sspXpath= "/html/body/bw-root/ia-invoices/pt-split-view/div/div[2]/div[2]/div/ia-invoice-coding/pt-tabs/mat-tab-group/div/mat-tab-body/div/div/div/gl-document-rows/div/gl-fields-grid/gl-grid/pt-grid/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[14]/gl-lookup-list-renderer/span";
	static String sspDivXpath="//div[@class='pt-select-dropdown-header ng-star-inserted']";
	static String sspSearchXpath="//div[@class='pt-select-dropdown-header ng-star-inserted']//child::input";
	static String sspSelect1Xpath="//span[@class='pt-highlighted-text' and contains(text(),'";
	static String sspSelect2Xpath="')]";
	static String sspVisibleXpath="(/html/body/bw-root/ia-invoices/pt-split-view/div/div[2]/div[2]/div/ia-invoice-coding/pt-tabs/mat-tab-group/div/mat-tab-body/div/div/div/gl-document-rows/div/gl-fields-grid/gl-grid/pt-grid/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1])//child::span[@title!='']";
	static String addCodingXpath="//span[@class='ng-star-inserted' and contains(text(),'Add coding')]";
	
	static String openXpath=   "//button[@class='pt-btn ng-star-inserted']//child::span[contains(text(),'Open')]";     //"(//button[@class='pt-btn ng-star-inserted'])[2]";
	static String sendToValidationXpath= "//button[@class='pt-btn ng-star-inserted']//child::span[contains(text(),'Send to validation')]";    //"(//button[@class='pt-btn ng-star-inserted'])[1]";
	static String tryRefreshingXpath="//button[@class='pt-btn-link ng-star-inserted' and contains(text(),'Try refreshing')]";

	
	public AccountsPayable(WebDriver driver) {
		super(driver);
	}
	
	
	public AccountsPayable receivedStage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(recievedStageXpath))).click();
		return this;
	}
	
	
	public AccountsPayable invoiceSearch(String invoice)throws InterruptedException  {
	       
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(invoiceXpath))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(invoiceXpath))).click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(invoiceXpath))).sendKeys(invoice);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(invoiceSearchXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(invoiceSearchXpath))).click();
		 
		return this;
	}
	
	public AccountsPayable  savePoInvoice(String invoice,String po,String supplierCode,String invoiceDate,String invoiceAmt,String taxAmt) throws InterruptedException  {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(matLabLabelsXpath)));
		WebElement element = driver.findElement(By.xpath(matLabLabelsXpath));
		List<WebElement> elements = element.findElements(By.xpath("./child::*"));
		elements.get(1).click();
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierCodeButtonXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierCodeButtonXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierCodeButtonXpath))).click();
     	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierCodePanelXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierCodeSearchContainerXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierSearchInputXpath))); 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierCodeInputXpath))).sendKeys(supplierCode);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierCodeSelectXpath))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(invoiceDateXpath))).clear();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(invoiceDateXpath))).sendKeys(invoiceDate);
		
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(netSumXpath))).sendKeys(Keys.CONTROL+"a");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(netSumXpath))).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(netSumXpath))).sendKeys(invoiceAmt);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(taxSumXpath))).sendKeys(Keys.CONTROL+"a");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(taxSumXpath))).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(taxSumXpath))).sendKeys(taxAmt);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(poXpath))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(poDivXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(poSearchXpath))).sendKeys(Keys.CONTROL+"a");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(poSearchXpath))).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(poSearchXpath))).sendKeys(po);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(poSearchButtonXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(poNumberVerify1Xpath+po+poNumberVerify2Xpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(poNumberTabCancelXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(poNumberSelectXpath))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(saveButtonXpath))).click();
		Thread.sleep(2000);
		
		return this;
	}
	
	public AccountsPayable editNonPoInvoice(String invoice,String supplierCode,String invoiceDate,String invoiceAmt,String taxAmt,String approver) throws InterruptedException  {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(matLabLabelsXpath)));
		WebElement element = driver.findElement(By.xpath(matLabLabelsXpath));
		List<WebElement> elements = element.findElements(By.xpath("./child::*"));
		elements.get(1).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierCodeButtonXpath)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierCodeButtonXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierCodeButtonXpath))).click();		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierCodePanelXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierCodeSearchContainerXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierSearchInputXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierCodeInputXpath))).sendKeys(supplierCode);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierCodeSelectXpath))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(invoiceDateXpath))).clear();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(invoiceDateXpath))).sendKeys(invoiceDate);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(netSumXpath))).sendKeys(Keys.CONTROL+"a");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(netSumXpath))).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(netSumXpath))).sendKeys(invoiceAmt);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(taxSumXpath))).sendKeys(Keys.CONTROL+"a");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(taxSumXpath))).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(taxSumXpath))).sendKeys(taxAmt);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(approverXpath))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(approverDivXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(approverDivXpath))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(approverSearchXpath))).sendKeys(Keys.CONTROL+"a");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(approverSearchXpath))).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(approverSearchXpath))).sendKeys(approver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(approverSelectXpath))).click();
		
		return this;
		}
	
	public AccountsPayable saveAndAddLines(JavascriptExecutor javascriptExecutor,String purchaseCategory,String coding,String agency,String type,String ssp) throws InterruptedException  {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addNewLineXpath))).click();		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addNewLineGridXpath)));
		driver.switchTo().activeElement();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(purchaseCategoryXpath))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(purchaseCategoryDivXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(purchaseCategoryDivXpath))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(purchaseCategorySearchXpath))).sendKeys(Keys.CONTROL + "a");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(purchaseCategorySearchXpath))).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(purchaseCategorySearchXpath))).sendKeys(purchaseCategory);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(purchaseCategorySelect1Xpath + purchaseCategory + purchaseCategorySelect2Xpath))).click();

		// wait for nature code
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(imputationXpath))).sendKeys(coding);
		
		//agency site
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySiteXpath))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(agencySiteDivXpath)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySiteDivXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySiteSearchXpath))).sendKeys(Keys.CONTROL+"a");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySiteSearchXpath))).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySiteSearchXpath))).sendKeys(agency);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySiteSelect1Xpath+agency+agencySiteSelect2Xpath))).click();

		driver.findElement(By.xpath(horizontalScrollPortXpath));
		WebElement element1 = driver.findElement(By.xpath(horizontalScrollXpath));
		javascriptExecutor.executeScript("arguments[0].scrollLeft += 600;",element1);
    	Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySiteVisibleXpath)));
		// ssp 
        if(type.equalsIgnoreCase("A")) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspXpath))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sspDivXpath)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspDivXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspSearchXpath))).sendKeys(Keys.CONTROL+"a");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspSearchXpath))).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspSearchXpath))).sendKeys(ssp);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspSelect1Xpath+ssp+sspSelect2Xpath))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sspVisibleXpath)));
        }       
            
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(saveButtonXpath))).click();
        
        return this;
	}
	
	
	
	public AccountsPayable sendToValidate() throws InterruptedException  {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(openXpath)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sendToValidationXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tryRefreshingXpath))).click();
		return this;
	}
	
	
	public AccountsPayable searchInvoice(String invoice) throws InterruptedException  {
		receivedStage().
		invoiceSearch(invoice);
		return this;
	}
	
	
	public Matching matching(String invoice,String po,String supplierCode,String invoiceDate,String invoiceAmt,String taxAmt) throws InterruptedException {
		savePoInvoice(invoice, po, supplierCode, invoiceDate, invoiceAmt, taxAmt).
		sendToValidate();
		
		return new Matching(driver);
	}
	
	public AccountsPayable nonPOInvoice(JavascriptExecutor javascriptExecutor,String invoice,String supplierCode,String invoiceDate,String invoiceAmt,String taxAmt,String approver,String purchaseCategory,String coding ,String agency,String type,String ssp) throws InterruptedException  {
		receivedStage().
		invoiceSearch(invoice).
		editNonPoInvoice(invoice, supplierCode, invoiceDate, invoiceAmt, taxAmt, approver).
		saveAndAddLines(javascriptExecutor, purchaseCategory,coding, agency, type, ssp).
		sendToValidate();
		return this;
	}

}

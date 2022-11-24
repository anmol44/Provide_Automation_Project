package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BasePage;

public class AccountsPayable extends BasePage {

	
	static String recievedStageXpath = "//div[@class='chart-caption ng-star-inserted' and contains(text(),'Received')]";
	
	static String fullLayoutXpath="//button[@title='Full coding layout']";
	
	static String invoiceXpath = "(//input[@class='pt-input ng-untouched ng-pristine ng-valid'])[1]";
	static String invoiceSearchXpath="//button[@class='pt-btn' and contains(text(),'Search')]";
	
	static String poXpath="//button[@aria-labelledby='OrderNumbers']";
	static String poDivXpath="//div[contains(text(),'Search for purchase order number')]";
	
	static String poSearchXpath="//input[@placeholder='Order number']";
	static String poSearchButtonXpath="//button[@class='pt-btn pt-btn-primary search-button' and contains(text(),'Search')]";
	static String poNumberVerify1Xpath="//span[@class='label' and contains(text(),'";
	static String poNumberVerify2Xpath="')]";
	static String organizationButtonXpath = "(//button[@class='pt-tree-select-toggle-btn'])[2]";
	static String selectAllButtonXpath = "//button[@title='Select all lower level organizations' and contains(text(),'Select all')]";
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
		
	static String approverXpath="//label[contains(text(),'Requester')]//following-sibling::div//child::button[@title='Expand']";
	static String approverDivXpath="//div[@class='pt-select-dropdown-header ng-star-inserted']";
	static String approverSearchXpath="//div[@class='pt-select-dropdown-header ng-star-inserted']//child::input";
	static String approverSelectXpath="//span[@class='pt-item-list-item-header']";
	static String approverSelect1Xpath="//span[@class='pt-highlighted-text' and contains(text(),'";
	static String approverSelect2Xpath="')]";
	
	static String addNewLineXpath="//button[@class='pt-btn pt-btn-link ng-star-inserted']";
	static String addNewLineGridXpath="(//div[@class='grid-container'])[2]";
	
	static String purchaseCategoryXpath="//div[@col-id='Text32']//span[@class='text-align-left ng-star-inserted']";   
	
	static String purchaseCategoryInputButtonXpath="//input[@aria-label='Purchase Category Code']//following::button[@title='Expand']";
	
	static String purchaseCategorySearchXpath="//div[@class='pt-select-dropdown-header ng-star-inserted']//child::input";
	static String purchaseCategorySelect1Xpath="//span[@class='pt-highlighted-text' and contains(text(),'";
	static String purchaseCategorySelect2Xpath="')]";
	static String purchaseCategorySelectXpath="//span[@class='pt-item-list-item-header']";
	
	static String imputationXpath="//div[@col-id='Text31']//span[@class='text-align-left ng-star-inserted']";
	static String imputationInputButtonXpath="//div[@col-id='Text31']//child::input[@data-t-id='select-form-control']//following::span[@class='pt-select-placeholder ng-star-inserted']";
	static String imputationDivXpath="//div[@class='pt-select-dropdown-header ng-star-inserted']";
	static String imputationSearchXpath="//div[@class='pt-select-dropdown-header ng-star-inserted']//child::input";
	static String imputationSelect1Xpath="//span[@class='pt-highlighted-text' and starts-with(text(),'";
	static String imputationSelect2Xpath="')]//parent::span[@class='pt-item-list-item-header' and not(text()[normalize-space(.)])]";
	static String imputationSelectXpath="//span[@class='pt-item-list-item-header']";
	
	//span[@class='pt-highlighted-text' and starts-with(text(),'CBK MAINT FIXED COST')]//parent::span[@class='pt-item-list-item-header' and not(text()[normalize-space(.)])]
	
	static String natureCodeXpath="/html/body/bw-root/ia-invoices/pt-split-view/div/div[2]/div[2]/div/ia-invoice-coding/pt-tabs/mat-tab-group/div/mat-tab-body/div/div/div/gl-document-rows/div/gl-fields-grid/gl-grid/pt-grid/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[11]/gl-lookup-list-renderer//child::span[@title!='']";
	
	static String agencySiteXpath= "//div[@col-id='Text16']//span[@class='text-align-left ng-star-inserted']";
	static String agencySiteDivXpath="//div[@class='pt-select-dropdown-header ng-star-inserted']";
	static String agencySiteSearchXpath="//div[@class='pt-select-dropdown-header ng-star-inserted']//child::input";
	static String agencySiteSelect1Xpath="//span[@class='pt-highlighted-text' and contains(text(),'";
	static String agencySiteSelect2Xpath="')]";
	static String agencySiteSelectXpath="//span[@class='pt-item-list-item-header']";
	static String agencySiteVisibleXpath="/html/body/bw-root/ia-invoices/pt-split-view/div/div[2]/div[2]/div/ia-invoice-coding/pt-tabs/mat-tab-group/div/mat-tab-body/div/div/div/gl-document-rows/div/gl-fields-grid/gl-grid/pt-grid/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[13]/gl-lookup-list-renderer//child::span[@title!='']";
	
	static String horizontalScrollPortXpath="(//div[@class='ag-body-horizontal-scroll-viewport'])[2]";
	static String horizontalScrollXpath="(//div[@class='ag-body-horizontal-scroll-viewport'])[2]";
	static String sspXpath= "//div[@col-id='ProjectCode']//span[@class='text-align-left ng-star-inserted']";
	static String sspDivXpath="//div[@class='pt-select-dropdown-header ng-star-inserted']";
	static String sspSearchXpath="//div[@class='pt-select-dropdown-header ng-star-inserted']//child::input";
	static String sspSelect1Xpath="//span[@class='pt-highlighted-text' and contains(text(),'";
	static String sspSelect2Xpath="')]";
	static String sspVisibleXpath="(/html/body/bw-root/ia-invoices/pt-split-view/div/div[2]/div[2]/div/ia-invoice-coding/pt-tabs/mat-tab-group/div/mat-tab-body/div/div/div/gl-document-rows/div/gl-fields-grid/gl-grid/pt-grid/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1])//child::span[@title!='']";
	static String addCodingXpath="//span[@class='ng-star-inserted' and contains(text(),'Add coding')]";
	
	static String openXpath=   "//button[@class='pt-btn ng-star-inserted']//child::span[contains(text(),'Open')]";     //"(//button[@class='pt-btn ng-star-inserted'])[2]";
	static String sendToValidationXpath= "//button[@class='pt-btn ng-star-inserted']//child::span[contains(text(),'Send to validation')]";    //"(//button[@class='pt-btn ng-star-inserted'])[1]";
	static String tryRefreshingXpath="//button[@class='pt-btn-link ng-star-inserted' and contains(text(),'Try refreshing')]";
	static String refreshButtonXpath = "//button[@class='pt-btn pt-btn-borderless pt-btn-md link-btn pt-clickable' and contains(text(),'Refresh')]";
	static String verifyInvoiceSentToValidation = "//span[contains(text(),'Invoice sent to validation')]";
	
	static String createInvoiceXpath = "//span[@class='ng-star-inserted' and contains(text(),'Create invoice')]";

	
	public AccountsPayable(WebDriver driver) {
		super(driver);
	}
	
	
	public AccountsPayable receivedStage(ExtentTest test) {
		test.log(Status.INFO,"Click Recieved stage");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(recievedStageXpath))).click();
		test.log(Status.PASS,"Successfully Clicked Recieved stage");

		return this;
	}
	
	public AccountsPayable fullCodingLayout(ExtentTest test) {
		test.log(Status.INFO,"Click Full Layout version");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fullLayoutXpath))).click();
		test.log(Status.PASS,"Successfully Clicked Full Layout version");

		return this;
	}
	
	
	public AccountsPayable invoiceSearch(ExtentTest test,String invoice)throws InterruptedException  {
		test.log(Status.INFO,"Invoice search");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(invoiceXpath))).click();
		test.log(Status.INFO,"Send Invoice Number");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(invoiceXpath))).sendKeys(invoice);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(invoiceSearchXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(invoiceSearchXpath))).click();
		test.log(Status.PASS,"Successfully Invoice Search Button cliicked");

		 
		return this;
	}
	
	public AccountsPayable  savePoInvoice(ExtentTest test,String invoice,String po,String supplierCode,String invoiceDate,String invoiceAmt,String taxAmt) throws InterruptedException  {
		test.log(Status.INFO,"Click Header Data and check Invoice Found or Not");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(matLabLabelsXpath)));
		WebElement element = driver.findElement(By.xpath(matLabLabelsXpath));
		List<WebElement> elements = element.findElements(By.xpath("./child::*"));
		elements.get(1).click();
		test.log(Status.PASS,"Successfully Header Data clicked and Invoice Found");
		
		test.log(Status.INFO,"Click supplier Code Button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierCodeButtonXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierCodeButtonXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierCodeButtonXpath))).click();
		test.log(Status.PASS,"Successfully clicked Supplier code Button");
     	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierCodePanelXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierCodeSearchContainerXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierSearchInputXpath))); 
		test.log(Status.INFO,"Enter Supplier code");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierCodeInputXpath))).sendKeys(supplierCode);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierCodeSelectXpath))).click();
		test.log(Status.PASS,"Successfully selected Supplier code");
		
		test.log(Status.INFO,"Enter Invoice Date");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(invoiceDateXpath))).clear();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(invoiceDateXpath))).sendKeys(invoiceDate);
		test.log(Status.PASS,"Successfully Entered Invoice Date");
		
		test.log(Status.INFO,"Enter Invoice Amount");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(netSumXpath))).sendKeys(Keys.CONTROL+"a");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(netSumXpath))).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(netSumXpath))).sendKeys(invoiceAmt);
		test.log(Status.PASS,"Successfully Entered Invoice amount");
		
		test.log(Status.INFO,"Enter Tax Amount");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(taxSumXpath))).sendKeys(Keys.CONTROL+"a");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(taxSumXpath))).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(taxSumXpath))).sendKeys(taxAmt);
		test.log(Status.PASS,"Successfully Entered Tax Amount");
		
		test.log(Status.INFO,"Click PO Button");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(poXpath))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(poDivXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(poSearchXpath))).sendKeys(Keys.CONTROL+"a");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(poSearchXpath))).sendKeys(Keys.BACK_SPACE);
		test.log(Status.INFO, "click to select all organization");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(organizationButtonXpath)));
		test.log(Status.PASS, "clicked successfully");
		test.log(Status.INFO, "Check all organizations select check");
		if(driver.findElements(By.xpath(selectAllButtonXpath)).size()>0) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectAllButtonXpath))).click();
		}
		test.log(Status.INFO,"Enter PO");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(poSearchXpath))).sendKeys(po);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(poSearchButtonXpath))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(poNumberVerify1Xpath+po+poNumberVerify2Xpath))).click();
		test.log(Status.INFO,"Selected PO");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(poNumberTabCancelXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(poNumberSelectXpath))).click();
		test.log(Status.PASS,"Successfully selected PO");
		
		test.log(Status.INFO,"Click save button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(saveButtonXpath))).click();
		test.log(Status.PASS,"Successfully Clicked save button");
		Thread.sleep(2000);
		
		return this;
	}
	
	public AccountsPayable editNonPoInvoice(ExtentTest test,String invoice,String supplierCode,String invoiceDate,String invoiceAmt,String taxAmt,String approver) throws InterruptedException  {
		
		test.log(Status.INFO,"Click Header Data");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(matLabLabelsXpath)));
		WebElement element = driver.findElement(By.xpath(matLabLabelsXpath));
		List<WebElement> elements = element.findElements(By.xpath("./child::*"));
		elements.get(1).click();
		test.log(Status.PASS,"Successfully Clicked Header Data");
		
		test.log(Status.INFO,"Click Supplier Code Button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierCodeButtonXpath)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(supplierCodeButtonXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierCodeButtonXpath))).click();
		test.log(Status.PASS,"Successfully Clicked Supplier Code Button");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierCodePanelXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierCodeSearchContainerXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierSearchInputXpath)));
		test.log(Status.INFO,"Enter Supplier Code");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierCodeInputXpath))).sendKeys(supplierCode);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supplierCodeSelectXpath))).click();
		test.log(Status.PASS,"Successfully Selected supplier code");
		
		test.log(Status.INFO,"Enter Invoice Date");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(invoiceDateXpath))).clear();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(invoiceDateXpath))).sendKeys(invoiceDate);
		test.log(Status.PASS,"Successfully Entered Invoice Date");
		
		test.log(Status.INFO,"Enter Net Sum");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(netSumXpath))).sendKeys(Keys.CONTROL+"a");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(netSumXpath))).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(netSumXpath))).sendKeys(invoiceAmt);
		test.log(Status.PASS,"Successfully Entered Net Sum");
		
		test.log(Status.INFO,"Enter Tax Sum");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(taxSumXpath))).sendKeys(Keys.CONTROL+"a");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(taxSumXpath))).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(taxSumXpath))).sendKeys(taxAmt);
		test.log(Status.PASS,"Successfully Entered Tax Sum");
		
		test.log(Status.INFO,"Click Approver Button");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(approverXpath))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(approverDivXpath)));
		test.log(Status.INFO,"Click Approval Panel");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(approverDivXpath))).click();
		test.log(Status.PASS,"On Approval Panel");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(approverSearchXpath))).sendKeys(Keys.CONTROL+"a");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(approverSearchXpath))).sendKeys(Keys.BACK_SPACE);
		test.log(Status.INFO,"Enter Approver");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(approverSearchXpath))).sendKeys(approver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(approverSelectXpath))).click();
		test.log(Status.PASS,"Successfully Entered Approver");
		
		return this;
		}
	
	public AccountsPayable saveAndAddLines(ExtentTest test,JavascriptExecutor javascriptExecutor,String purchaseCategory,String coding,String agency,String type,String ssp) throws InterruptedException  {
		test.log(Status.INFO,"Add New Line");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addNewLineXpath))).click();		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addNewLineGridXpath)));
		driver.switchTo().activeElement();
		test.log(Status.PASS,"Successfully New Line added");
		
		//Scroll Bar to view Accounts payable tab
		
		  test.log(Status.INFO,"Wait for scroll");
		  driver.findElement(By.xpath(horizontalScrollPortXpath)); 
		  WebElement element1  = driver.findElement(By.xpath(horizontalScrollXpath));
		  javascriptExecutor.executeScript("arguments[0].scrollLeft += 1200;",element1);
		  Thread.sleep(1000);
		  test.log(Status.PASS,"Successfully Successfully scrolled right");
		 
    		
		
		test.log(Status.INFO,"Click Purchase Category Line");
		WebElement purchaseCategoryElement = driver.findElement(By.xpath(purchaseCategoryXpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", purchaseCategoryElement);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(purchaseCategoryXpath))).click();
		test.log(Status.PASS,"Successfully Clicked Purchase Category Line to enter Data");
		
	//	test.log(Status.INFO,"Click Input Button For Search");
	//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(purchaseCategoryInputButtonXpath))).click();
	//	test.log(Status.PASS,"Successfully Button Clicked Purchase Category");
		
		test.log(Status.INFO,"Enter Purchase Category ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(purchaseCategorySearchXpath))).sendKeys(Keys.CONTROL + "a");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(purchaseCategorySearchXpath))).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(purchaseCategorySearchXpath))).sendKeys(purchaseCategory);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(purchaseCategorySelect1Xpath + purchaseCategory + purchaseCategorySelect2Xpath))).click();
		test.log(Status.PASS,"Successfully selected Purchase Category");

		// wait for nature code
		//Imputation data selection
		test.log(Status.INFO,"Click Imputation Line");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(imputationXpath))).click();
		test.log(Status.PASS,"Successfully clicked Imputation Line");
		
	//	test.log(Status.INFO,"Click Imputation Input Button");
	//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(imputationInputButtonXpath))).click();
	//	test.log(Status.PASS,"Successfully clicked Imputation Line");
		
		/*
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * imputationDivXpath))); test.log(Status.INFO,"Click Imputation Division");
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * imputationDivXpath))).click();
		 * test.log(Status.PASS,"Successfully Imputation division clicked");
		 */
		test.log(Status.INFO,"Enter Imputation Data");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(imputationSearchXpath))).sendKeys(Keys.CONTROL + "a");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(imputationSearchXpath))).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(imputationSearchXpath))).sendKeys(coding);
		Thread.sleep(2000);
		test.log(Status.INFO,"Collect all Imputation Data from search Panel into List");
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='pt-list-item-details-with-desc']//child::span[@CLASS='pt-item-list-item-header']"));
		
		List<WebElement> element = elements.stream().filter(e->e.getText().equalsIgnoreCase(coding)).collect(Collectors.toList());
		for(WebElement el : element){
			el.click();
		}
		test.log(Status.PASS,"Successfully Selected Imputation");
		
		
		
		
		//agency site
		test.log(Status.INFO,"Click Agency Site Line");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySiteXpath))).click();
		test.log(Status.PASS,"Successfully Agency Site Line");
		/*
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * agencySiteDivXpath))); test.log(Status.INFO,"Agency Site Div");
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * agencySiteDivXpath))).click();
		 * test.log(Status.PASS,"Successfully Agency Site div");
		 */
		
		test.log(Status.INFO, "Enter Agency Site");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySiteSearchXpath))).sendKeys(Keys.CONTROL+"a");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySiteSearchXpath))).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySiteSearchXpath))).sendKeys(agency);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySiteSearchXpath))).sendKeys(Keys.CONTROL+"a");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySiteSearchXpath))).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySiteSearchXpath))).sendKeys(agency);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencySiteSelect1Xpath+agency+agencySiteSelect2Xpath))).click();
		test.log(Status.PASS,"Successfully Selected Agency Site");
		
		
		// ssp 
    	test.log(Status.INFO,"Check type It is Agency or Site :: "+type);
        if(type.equalsIgnoreCase("A")) {
        	
        	test.log(Status.INFO,"Wait for scroll");		  
  		  javascriptExecutor.executeScript("arguments[0].scrollLeft += 500;",element1);
  		  Thread.sleep(1000);
  		  test.log(Status.PASS,"Successfully Successfully scrolled right for SSP");
        	
        	test.log(Status.INFO,"Click SSP line");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspXpath))).click();
		test.log(Status.PASS,"Successfully SSP line");
		/*
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sspDivXpath)));
		 * test.log(Status.INFO,"Click SSP Div");
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspDivXpath
		 * ))).click(); test.log(Status.PASS,"Successfully Clicked SSP div");
		 */
		
		test.log(Status.INFO, "Enter SSP");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspSearchXpath))).sendKeys(Keys.CONTROL+"a");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspSearchXpath))).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspSearchXpath))).sendKeys(ssp);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sspSelect1Xpath+ssp+sspSelect2Xpath))).click();
		test.log(Status.PASS,"Successfully SSP Selected");
        }       
        
        test.log(Status.INFO,"Click Save Button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(saveButtonXpath))).click();
        test.log(Status.PASS,"Successfully Save Button Clicked");
        
        return this;
	}
	
	
	
	public AccountsPayable sendToValidate(ExtentTest test) throws InterruptedException  {
		test.log(Status.INFO,"wait for open button to be active");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(openXpath)));
		test.log(Status.INFO,"Click Send To Validation Button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sendToValidationXpath))).click();
		test.log(Status.INFO,"Successfully Clicked send To Validation Button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifyInvoiceSentToValidation)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tryRefreshingXpath))).click();   // try refreshing when no duplicated of invoice no.  23/11/2022  @Anmol
		test.log(Status.PASS,"Successfully Sent To Validation");
		return this;
	}
	
	
	public AccountsPayable searchInvoice(ExtentTest test,String invoice) throws InterruptedException  {
		receivedStage(test).
		invoiceSearch(test,invoice);
		return this;
	}
	
	
	public CreateInvoice clickCreateInvoice(ExtentTest test) {
		test.log(Status.INFO,"Click Create Invoice");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createInvoiceXpath))).click();
		test.log(Status.PASS,"Create invoice button successful");
		return new CreateInvoice(driver);
	}
	
	
	public Matching matching(ExtentTest test,String invoice,String po,String supplierCode,String invoiceDate,String invoiceAmt,String taxAmt) throws InterruptedException {
		receivedStage(test).
		fullCodingLayout(test).
		invoiceSearch(test,invoice).
		savePoInvoice(test,invoice, po, supplierCode, invoiceDate, invoiceAmt, taxAmt).
		sendToValidate(test);		
		return new Matching(driver);
	}
	
	public AccountsPayable nonPOInvoice(ExtentTest test,JavascriptExecutor javascriptExecutor,String invoice,String supplierCode,String invoiceDate,String invoiceAmt,String taxAmt,String approver,String purchaseCategory,String coding ,String agency,String type,String ssp) throws InterruptedException  {
		receivedStage(test).
		fullCodingLayout(test).
		invoiceSearch(test,invoice).
		editNonPoInvoice(test,invoice, supplierCode, invoiceDate, invoiceAmt, taxAmt, approver).
		saveAndAddLines(test,javascriptExecutor, purchaseCategory,coding, agency, type, ssp).
		sendToValidate(test);
		return this;
	}

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BasePage;

public class Matching extends BasePage {
	
	public Matching(WebDriver driver) {
		super(driver);
	}
	
	
	static String tryRefreshingXpath="//button[@class='pt-btn-link ng-star-inserted' and contains(text(),'Try refreshing')]";
	static String refreshButtonXpath="//button[@class='pt-btn pt-btn-borderless pt-btn-md link-btn pt-clickable' and contains(text(),'Refresh')]";
	static String searchXpath="//button[@class='pt-btn pt-btn-primary search-button' and contains(text(),'Search')]";
	static String quantityToMatchXpath=     "/html/body/bw-root/bw-order-matching/bw-manual-matching/div/div/pt-split-view/div/div[1]/div[2]/div/div/bw-matching-search-results/div/div[3]/gl-fields-grid/gl-grid/pt-grid/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[4]";
	static String quantityToMatchInputXpath="/html/body/bw-root/bw-order-matching/bw-manual-matching/div/div/pt-split-view/div/div[1]/div[2]/div/div/bw-matching-search-results/div/div[3]/gl-fields-grid/gl-grid/pt-grid/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[4]/gl-grid-general-editor/gl-general-editor/pt-decimal-field-editor/input";
	static String matchXpath="//button[@class='pt-btn pt-btn-secondary pt-btn-md match-button' and @data-t-rel='match']";
	static String openXpath=   "//button[@class='pt-btn ng-star-inserted']//child::span[contains(text(),'Open')]";     //"(//button[@class='pt-btn ng-star-inserted'])[2]";
	static String openToMatchXpath="//button[@class='pt-btn ng-star-inserted']";
	static String spinnerXpath="//pt-busy";
	static String confirmButtonXpath="//button[@class='pt-btn ng-star-inserted']//child::span[contains(text(),'Confirm')]";
	static String showAllPOXpath = "//div[@class='pt-flipswitch-container checked']";
	static String showAllPOButtonXpath = "//button[@class='pt-flipswitch-switch']";
	static String taxCodeXpath = "//div[@col-id='TaxCode' and @role='gridcell']";
	static String taxCodeInputXpath = "//input[@data-t-id='search-input' ]";
	static String  selectTaxCodeXpath1 = "//span[text()='";
	static String selectTaxCodeXpath2 = "']//parent::span[not(text()[normalize-space(.)])]";
	static String saveButtonXpath = "//button[@class='pt-btn' and contains(text(),'Save')]";
	static String invoiceSavedLabelXpath = "//span[contains(text(),'Invoice saved')]";
	static String sendToValidationLogMessageXpath = "//span[contains(text(),'Invoice sent to validation')]";
	

	public Matching openAndMatchInvoice(ExtentTest test ) throws Exception   {
			
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(sendToValidationLogMessageXpath)));
		
		test.log(Status.INFO,"Try Refresh Button Click");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tryRefreshingXpath))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(refreshButtonXpath)));
		
		test.log(Status.PASS,"Successful Try Refresh Button Clicked and Refresh Button on same page");
		test.log(Status.INFO,"Open Button Click");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(openToMatchXpath))).click();
		test.log(Status.PASS,"Successful Open Button Clicked to match Quantity");
		try {
			test.log(Status.INFO,"Try Refresh Button Clicking for match Panel");
			while (driver.findElement(By.xpath(tryRefreshingXpath)).isDisplayed()) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tryRefreshingXpath))).click();
				Thread.sleep(2000);
			}
			test.log(Status.PASS,"Successful Match Panel Visisble");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		test.log(Status.INFO,"Search Button visible");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(searchXpath)));
		test.log(Status.PASS,"Successful Search Button visible");	
		// Show all PO Items	
		test.log(Status.INFO,"Check show All PO items button is checked");
		if(driver.findElements(By.xpath(showAllPOXpath)).size()>0) {}
		else {
			test.log(Status.INFO,"click button to show all PO items");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(showAllPOButtonXpath))).click();
			test.log(Status.PASS,"Successful button clicked to show all PO items");
		}
		test.log(Status.PASS,"Successful Show all PO items button is checked");
			
		return this;
	}
	
	public Matching sendTaxCode(ExtentTest test, String taxCode) throws InterruptedException {
		test.log(Status.INFO,"click tax code input block");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(taxCodeXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(taxCodeXpath))).click();
		test.log(Status.PASS," successful Tax code clicked");
		test.log(Status.INFO,"enter Tax Code");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(taxCodeInputXpath))).sendKeys(taxCode);
		test.log(Status.PASS,"successful enter Tax Code");
		test.log(Status.INFO,"select Tax code");
		Thread.sleep(2000);
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath(selectTaxCodeXpath1+taxCode+selectTaxCodeXpath2))).click();
		test.log(Status.PASS, "Tax Code selected successfully");
		
		return this;
	}
	
	public Matching quantityToMatch(ExtentTest test, String matchQty) {
		test.log(Status.INFO,"quantity to match data send");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(quantityToMatchXpath))).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProvidePom.quantityToMatchInpuXpath))).clear();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(quantityToMatchInputXpath))).sendKeys(Keys.CONTROL+"a");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(quantityToMatchInputXpath))).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(quantityToMatchInputXpath))).sendKeys(matchQty);
		test.log(Status.PASS,"Successful quantity to match data send");
		
		test.log(Status.INFO,"Match Button click");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(matchXpath))).click();
		test.log(Status.PASS,"Successful match button clicked");
		
		//wait until confirm button active
		test.log(Status.INFO,"wait till Spinner off");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinnerXpath)));
		test.log(Status.PASS,"Spinner off successful");		
	
		  return this;
	}
	
	public Matching clickSaveButton(ExtentTest test) throws InterruptedException {
		test.log(Status.INFO,"Click Save Button ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(saveButtonXpath))).click();
		test.log(Status.PASS,"Successful Save Button");
		
		test.log(Status.INFO, "wait for Invoice saved logo");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(invoiceSavedLabelXpath)));
		test.log(Status.PASS, "Successful Invoice saved");
		Thread.sleep(2000);
		
		return this;
	}
	
	public Matching clickConfirmButton(ExtentTest test) {
		test.log(Status.INFO,"Click Confirm Button ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(confirmButtonXpath))).click();
		test.log(Status.PASS,"Successful Confirm Button");
		
		test.log(Status.INFO,"Click refresh Button after Confirm Button click");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tryRefreshingXpath)));
		test.log(Status.PASS,"Successful refresh Button clicked after confirm button click");
		return this;
	}
    
 }


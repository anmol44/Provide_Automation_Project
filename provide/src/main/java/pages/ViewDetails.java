package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class ViewDetails extends BasePage {

	
	static String lineDataXpath = "//button[@class='btn btn-secondary btn-action-icon ng-scope']";
	static String sellingPriceXpath = "(//input[@class='form-control editor-focusable ng-pristine ng-untouched ng-valid ng-empty'])[3]";
	static String paymentTermsButtonXpath="(//button[@class='pal-single-select-toggle-btn'])[4]";
	static String paymentTermsSearchXpath="/html/body/div/bw-purchase-requisition-line-details/div/pal-two-col-row/div/div[1]/div/pal-two-col-row-left-content/div/bw-purchase-line-data-panel/div/div/div[2]/div/div[1]/div/pal-detail-fields/div/pal-detail-field[19]/div/div/bw-purchase-requisition-panel-field/div/bw-purchase-panel-field-switch/div/div/div/bw-lookup-list/div/pal-single-select/div/div[2]/pal-single-select-dropdown/div/div[1]/div/input";
	static String paymentTermsSelect1Xpath="//span[@class='ui-select-highlight' and contains(text(),'";
	static String paymentTermsSelect2Xpath="')]";
	static String lineDataSaveXpath = "(//button[@class='btn ng-binding'])[1]";
	static String lineDataSaveButtonVisibleXpath = "/html/body/div/bw-purchase-requisition-line-details/div/pal-two-col-row/div/div[1]/div/pal-two-col-row-left-content/div/bw-purchase-line-data-panel/div/div/div[1]/div/span/span/section[2]/button";
	static String backPageXpath = "(//i[@class='psl-icon-angle-left'])[1]";
	static String getApproveXpath = "(//button[@class='btn btn-pal-actions-button ng-scope use-dropdown-style'])[2]";
	
	public ViewDetails(WebDriver driver) {
		super(driver);
		
	}
	
	
	
	public ViewDetails viewDetails(String quantity,String unitPrice,String paymentTerms) {
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lineDataXpath))).click();
		
		double price;
		double quant;
		double uPrice;
		quant= Double.parseDouble(quantity.replace(",", "."));
		uPrice= Double.parseDouble(unitPrice.replace(",", "."));
		price= quant*uPrice; 
		String sellingPrice= Double.toString(price).replace(".", ",");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sellingPriceXpath))).sendKeys(sellingPrice);
		
		if(!paymentTerms.isEmpty()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(paymentTermsButtonXpath))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(paymentTermsSearchXpath))).sendKeys(paymentTerms);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(paymentTermsSelect1Xpath+paymentTerms+paymentTermsSelect2Xpath))).click();
			}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lineDataSaveXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lineDataSaveButtonVisibleXpath)));
		
		return this;
		
	}
	
	
	public ViewDetails  viewDetailsFR(String quantity,String unitPrice,String paymentTerms) {
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lineDataXpath))).click();
		
		Integer price;
		
		price= Integer.parseInt(quantity)*Integer.parseInt(unitPrice); 
		String sellingPrice= Integer.toString(price);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sellingPriceXpath))).sendKeys(sellingPrice);
		if(!paymentTerms.isEmpty()) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(paymentTermsButtonXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(paymentTermsSearchXpath))).sendKeys(paymentTerms);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(paymentTermsSelect1Xpath+paymentTerms+paymentTermsSelect2Xpath))).click();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lineDataSaveXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lineDataSaveButtonVisibleXpath)));
		
		
		return this;
	}
	
	public GetApprove getApprovePage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(backPageXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getApproveXpath))).click();
		
		return new GetApprove(driver);
	}
	
	public GetApprove getApproveSBS(String quantity,String unitPrice,String paymentTerms ) {
		viewDetailsFR(quantity,unitPrice,paymentTerms).
		getApprovePage();
		
		
		return new GetApprove(driver);
	}
	
	
	public GetApprove getApprove(String quantity,String unitPrice,String paymentTerms) {
		viewDetails(quantity,unitPrice,paymentTerms).
		getApprovePage();
		
		return new GetApprove(driver);
	}
	
	public GetApprove getApproveGalitt(String quantity,String unitPrice,String paymentTerms ) {
		viewDetailsFR(quantity,unitPrice,paymentTerms).
		getApprovePage();
		
		return new GetApprove(driver);
	}
	
	public GetApprove getApproveBeleux(String quantity,String unitPrice,String paymentTerms ) {
		viewDetailsFR(quantity,unitPrice,paymentTerms).
		getApprovePage();
		
		return new GetApprove(driver);
	}
	
	public GetApprove getApproveSpain(String quantity,String unitPrice,String paymentTerms) {
		viewDetails(quantity,unitPrice,paymentTerms).
		getApprovePage();
		
		return new GetApprove(driver);
	}
	
	public GetApprove getApproveFrance(String quantity,String unitPrice,String paymentTerms) {
		viewDetailsFR(quantity,unitPrice,paymentTerms).
		getApprovePage();
		
		return new GetApprove(driver);
	}

}

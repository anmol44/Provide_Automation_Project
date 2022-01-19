package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


import base.BasePage;

public class Matching extends BasePage {
	
	public Matching(WebDriver driver) {
		super(driver);
	}
	
	
	static String tryRefreshingXpath="//button[@class='pt-btn-link ng-star-inserted' and contains(text(),'Try refreshing')]";
	static String refreshButtonXpath="//button[@class='pt-btn pt-btn-borderless pt-btn-md link-btn pt-clickable' and contains(text(),'Refresh')]";
	static String searchXpath="//button[@class='pt-btn pt-btn-primary search-button' and contains(text(),'Search')]";
	static String quantityToMatchXpath="/html/body/bw-root/bw-order-matching/bw-manual-matching/div/div/pt-split-view/div/div[1]/div[2]/div/div/bw-matching-search-results/div/div[3]/gl-fields-grid/gl-grid/pt-grid/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[4]";
	static String quantityToMatchInputXpath="/html/body/bw-root/bw-order-matching/bw-manual-matching/div/div/pt-split-view/div/div[1]/div[2]/div/div/bw-matching-search-results/div/div[3]/gl-fields-grid/gl-grid/pt-grid/ag-grid-angular/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[4]/gl-grid-general-editor/gl-general-editor/pt-decimal-field-editor/input";
	static String matchXpath="//button[@class='pt-btn pt-btn-secondary pt-btn-md match-button' and @data-t-rel='match']";
	static String openXpath=   "//button[@class='pt-btn ng-star-inserted']//child::span[contains(text(),'Open')]";     //"(//button[@class='pt-btn ng-star-inserted'])[2]";
	static String openToMatchXpath="//button[@class='pt-btn ng-star-inserted']";
	static String spinnerXpath="//pt-busy";
	static String confirmButtonXpath="//button[@class='pt-btn ng-star-inserted']//child::span[contains(text(),'Confirm')]";

	public Matching openAndMatchInvoice(String matchQty) throws Exception   {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tryRefreshingXpath)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tryRefreshingXpath))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(refreshButtonXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(refreshButtonXpath)));
		
		Thread.sleep(10000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(openToMatchXpath)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(openToMatchXpath))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(searchXpath)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(quantityToMatchXpath))).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProvidePom.quantityToMatchInpuXpath))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(quantityToMatchInputXpath))).sendKeys(Keys.CONTROL+"a");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(quantityToMatchInputXpath))).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(quantityToMatchInputXpath))).sendKeys(matchQty);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(matchXpath))).click();
		
		//wait until confirm button active
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(spinnerXpath)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(confirmButtonXpath))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tryRefreshingXpath)));
		
		return this;

	}

}

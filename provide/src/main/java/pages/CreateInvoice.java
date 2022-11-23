package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BasePage;

public class CreateInvoice extends BasePage{
	
	static String addImageXpath = "//input[@id='file']";
	static String invoicePath = System.getProperty("user.dir") +"\\InvoicePDF\\Invoice.pdf";
	static String header = "//div[@class='pt-modal-header model-header']";
	static String organizationButtonXpath = "//button[@class='pt-tree-select-toggle-btn']";
	static String inputOrganizationXpath = "//INPUT[@class='pt-input tree-select-search ng-touched ng-pristine ng-valid']";
	static String selectOrgXpath1 = "//div[@data-t-id='tree-item-code' and contains(text(),'";
	static String selectOrgXpath2 = "')]";
	static String okXpath = "//button[@class='pt-btn pt-btn-secondary pt-btn-defaul-pseudo pt-margin-bottom-md ok-button' and @disabled]";
	static String okClickXpath = "//button[@class='pt-btn pt-btn-secondary pt-btn-defaul-pseudo pt-margin-bottom-md ok-button']";
	
	public CreateInvoice(WebDriver driver) {
		super(driver);
	}
	
	 
	public CreateInvoice addImage(ExtentTest test) {
	test.log(Status.INFO,"On Create Invoice page");
	test.log(Status.INFO,"Click add image");
	WebElement add = driver.findElement(By.xpath(addImageXpath));
	add.sendKeys(invoicePath);
	//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(header)));
	test.log(Status.PASS, "image successfull");
		return this;
	}
	
	public Invoice selectOrganization(ExtentTest test,String org) throws InterruptedException  {
		test.log(Status.INFO,"Click Button to enter organization");
		Thread.sleep(2000);
	//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='outerContainer']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(organizationButtonXpath))).click();
		test.log(Status.PASS, "Successfull clicked button");
		test.log(Status.INFO, "input organization");
	//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputOrganizationXpath))).sendKeys(org);
		test.log(Status.PASS, "Successfull enterd organization "+ org);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectOrgXpath1+org+selectOrgXpath2))).click();
		test.log(Status.INFO, "Click Ok Button");
	//	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(okXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(okClickXpath))).click();
		test.log(Status.PASS, "OK Passed");
		
		return new Invoice(driver);
	}
	
	 
 
}

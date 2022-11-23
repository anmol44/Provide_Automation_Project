package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import base.BasePage;

public class Invoice extends BasePage{
	static String createNewInvoiceXpath = "//button[@class='pt-btn pt-btn-md pt-btn-secondary create-new-invoice-button ng-star-inserted' and contains(text(),'Create new invoice')]";
	static String invoiceNumberXpath = "//label[@class='pt-field-container-label ng-star-inserted' and contains(text(),'Invoice number')]//parent::pt-field-container//following-sibling::div[@class='ng-star-inserted']//child::input";
    static String saveDraftXpath = "//button[@class='pt-btn' and contains(text(),'Save as draft')]";
    static String sendToValidationXpath = "//span[@class='ng-star-inserted' and contains(text(),'Send to validation')]";
    static String deleteImageButtonXpath = "//button[@data-t-id='delete-image-button']";
	public Invoice(WebDriver driver) {
		super(driver);
	}
	

	public Invoice enterInvoiceNumber(ExtentTest test,String invoiceNumber){
        test.log(Status.INFO, "validate Delete image element");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(deleteImageButtonXpath)));
        test.log(Status.PASS, "Validation successful for Delete image element ");
		test.log(Status.INFO, "Waiting for Create new invoice button");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createNewInvoiceXpath)));
		test.log(Status.PASS, "Passed craete new invoice button invoice");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(invoiceNumberXpath))).sendKeys(invoiceNumber);
		test.log(Status.PASS, "Invoice entered successfully");
	return this;	
	}
   
	public Invoice clickSaveDraft(ExtentTest test) {
		test.log(Status.INFO, "Click Save as Draft");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(saveDraftXpath))).click();
		test.log(Status.PASS, "save as Draft clicked");
		test.log(Status.INFO, "verify send to validation");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(sendToValidationXpath)));
		test.log(Status.PASS, "Passed the validation ");
		return this;
	}
}

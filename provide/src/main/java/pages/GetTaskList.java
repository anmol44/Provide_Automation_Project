package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BasePage;

public class GetTaskList extends BasePage {
	
	
	static String totalRowsTaskListXpath = "//span[@class='badge ng-binding']";
	static String docType1Xpath= "//*/tbody[";
	static String docType2Xpath= "]/tr[1]/td[4]/pal-list-item-secondary/bw-task-item-secondary/bw-task-item-type-and-organization-field/div/span[1]";
	static String orderDescription1Xpath = "//*/tbody[";
	static String orderDescription2Xpath= "]/tr[3]/td[2]/pal-list-item-description/bw-purchase-requisition-description-component/div/span[2]";
	static String approveTaskListXpath = "/html/body/div/bw-purchase-requisition-details/section/div[1]/pal-title-bar/div/div/div[2]/div/div[2]/pal-title-bar-actions/bw-purchase-requisition-details-actions/div/pal-actions/div/div/div/div[1]/div/button";
	static String allTasksXpath= "/html/body/div/div/bw-task-list-all/div/div/div[1]/div/span[1]";
	static String invoiceMatchButton1Xpath="/html/body/div/div/bw-task-list-all/div/div/pal-list/div/table/tbody[";
	 static String invoiceMatchButton2Xpath="]/tr[1]/td[1]/button/i//parent::button";
	 static String invoiceMatchText1Xpath="/html/body/div/div/bw-task-list-all/div/div/pal-list/div/table/tbody[";
	 static String invoiceMatchText2Xpath="]/tr[6]/td[2]/div/div/pal-list-item-expand-section/bw-coding-details-panel/div/div/div[2]/div[1]";
	 static String invoiceOPenPanel1Xpath="/html/body/div/div/bw-task-list-all/div/div/pal-list/div/table/tbody[";
	 static String invoiceOPenPanel2Xpath="]/tr[1]/td[3]/pal-list-item-primary/bw-task-item-primary/bw-task-item-supplier-field/div";
	 static String nextList="//button[@class='btn btn-link']";
	 
	public GetTaskList(WebDriver driver) {
		super(driver);
	}
	
	
	public static String getTaskList(ExtentTest test,String orderDescription,String docType) throws Exception {

		int count = 0;
		String concOrderDesc;
		concOrderDesc = "\"" + orderDescription+ "\"";
		String totalRows = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(totalRowsTaskListXpath))).getText();
		test.log(Status.INFO, "Total Rows in Task List : "+totalRows);
		int total = Integer.parseInt(totalRows);
		int rows = 50;
		int temp = rows;
		int noMatch = 0;
		int Total = total; 
		String document;
		String orderDesc = " ";
		 
		//String docType = ProvidePom.docType;
		 
		for (int i = 1; i <= rows; i++) {
			
			if(total ==noMatch) {
				return " ";
			}
			count++;
			noMatch++;
			// get document type from approval page.
			document = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(docType1Xpath + i + docType2Xpath))).getText();
			
			
			
			if(document.equalsIgnoreCase("Purchase requisition")) {  
				// For Pr requisition part we have to match invoice no.
				
				orderDesc="";
				orderDesc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(orderDescription1Xpath+i+orderDescription2Xpath))).getText();
				
				if (orderDesc.toLowerCase().equalsIgnoreCase(concOrderDesc)) {
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(orderDescription1Xpath + i + orderDescription2Xpath))).click();
						test.log(Status.PASS, "Order Description matched : "+orderDesc);
						return concOrderDesc;
					} 
			 else {

				if (noMatch == Total) {
					return " ";
				}
				if (count == rows) {

					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-link']"))).click();
					total = total - temp;
					if (total < temp) {
						rows += total;
					} else
						rows += temp;
				}

			} 
			
		}  else {
			if(document.equalsIgnoreCase("Invoice")) {    // For Invoice part we have to match invoice no.
				if (docType.equalsIgnoreCase(document)) {
					orderDesc="";
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invoiceMatchButton1Xpath+i+invoiceMatchButton2Xpath))).click();
					orderDesc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invoiceMatchText1Xpath+i+invoiceMatchText2Xpath))).getText();
					
					if (orderDesc.toLowerCase().equalsIgnoreCase(orderDescription)) {
						//open invoice
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invoiceOPenPanel1Xpath+i+invoiceOPenPanel2Xpath))).click();
						test.log(Status.PASS, "Order Description matched : "+orderDesc);
						return orderDesc;
						
					    }   else {
						        if (noMatch == Total) {
							    return " ";
						         }
					        }
				   }
				else {
					if (noMatch == Total) {
						return " ";
					}
					if (count == rows) {
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(nextList))).click();
						total = total - temp;
						if (total < temp) {
							rows += total;
						} else
							rows += temp;
					}
				} 
			} 
		}

		}

		return " ";

	}

}

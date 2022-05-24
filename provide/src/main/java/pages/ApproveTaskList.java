package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BasePage;

public class ApproveTaskList extends BasePage {
	
	 static String invoiceApproveButtonXpath="/html/body/div/section/div[1]/pal-title-bar/div/div/div[2]/div/div[2]/pal-title-bar-actions/div/div/bw-details-action-panel-commands/div/div/bw-task-actions/div/div/pal-actions/div/div/div/div[1]/div/button";
	 static String approveTaskListXpath = "/html/body/div/bw-purchase-requisition-details/section/div[1]/pal-title-bar/div/div/div[2]/div/div[2]/pal-title-bar-actions/bw-purchase-requisition-details-actions/div/pal-actions/div/div/div/div[1]/div/button";
	 static String allTasksXpath= "/html/body/div/div/bw-task-list-all/div/div/div[1]/div/span[1]";
	 static String verifyApproveXpath = "//div[@class='pal-toast']//child::span[@role='alert' and contains(text(),'Approved')]";

	public ApproveTaskList(WebDriver driver) {
		super(driver);
	}
	
	
	public  ApproveTaskList approveTaskList(ExtentTest test,String docType) throws Exception {
		test.log(Status.PASS, "Check DocType : "+docType);
		
		if(docType.equalsIgnoreCase("Invoice")) {
			test.log(Status.INFO, "Click Approve Button For Invoice");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invoiceApproveButtonXpath))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifyApproveXpath)));
			test.log(Status.PASS, "Successfully Approved By Approver");
		     
		     
		}
		else
			if(docType.equalsIgnoreCase("Purchase requisition")) {
		test.log(Status.INFO, "Click Approve Button For PR");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(approveTaskListXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifyApproveXpath)));
		test.log(Status.PASS, "Successfully Approved by Approver");
 	   
			}
		return this;
		}

  }

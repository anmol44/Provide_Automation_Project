package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;



import base.BasePage;

public class ApproveTaskList extends BasePage {
	
	 static String invoiceApproveButtonXpath="/html/body/div/section/div[1]/pal-title-bar/div/div/div[2]/div/div[2]/pal-title-bar-actions/div/div/bw-details-action-panel-commands/div/div/bw-task-actions/div/div/pal-actions/div/div/div/div[1]/div/button";
	 static String approveTaskListXpath = "/html/body/div/bw-purchase-requisition-details/section/div[1]/pal-title-bar/div/div/div[2]/div/div[2]/pal-title-bar-actions/bw-purchase-requisition-details-actions/div/pal-actions/div/div/div/div[1]/div/button";
	 static String allTasksXpath= "/html/body/div/div/bw-task-list-all/div/div/div[1]/div/span[1]";

	public ApproveTaskList(WebDriver driver) {
		super(driver);
	}
	
	
	public  ApproveTaskList approveTaskList(String docType) throws Exception {
		if(docType.equalsIgnoreCase("Invoice")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invoiceApproveButtonXpath))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invoiceApproveButtonXpath)));
		     if(driver.findElements(By.xpath(allTasksXpath)).size()>0) {
		     }
		}
		else
			if(docType.equalsIgnoreCase("Purchase requisition")) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(approveTaskListXpath))).click();
		System.out.println(driver.findElements(By.xpath(allTasksXpath)).size());
 	    if(driver.findElements(By.xpath(allTasksXpath)).size()>0) {
		    	 
		     }
			}
		return this;
		}

  }

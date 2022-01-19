package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BasePage;
import commons.ExceptionCode;

public class ReviewAndApprove extends BasePage {
	
	String concate=".";
	String orderDescr = "";
	String Reviewer = "Reviewer";
	
	static String taskListXpath = "/html/body/div/div/div[3]/div[1]/pal-narrow-layout/div/ng-transclude/div/div/div/div/div[2]/div[2]/div/a/span";
	static String approveTaskListXpath = "/html/body/div/bw-purchase-requisition-details/section/div[1]/pal-title-bar/div/div/div[2]/div/div[2]/pal-title-bar-actions/bw-purchase-requisition-details-actions/div/pal-actions/div/div/div/div[1]/div/button";
	static String allTasksXpath= "/html/body/div/div/bw-task-list-all/div/div/div[1]/div/span[1]";


	public ReviewAndApprove(WebDriver driver) {
		super(driver);
		
	}
	
	
	public ReviewAndApprove review(JavascriptExecutor javascriptExecutor,String reviewer,String password,String orderDescription,String docType,String PRNumber,String status,int i,int j,ExtentTest test)  {
		
		
			Login login = new Login(driver);
			login.logIn(reviewer, password);
		
		
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(taskListXpath))).click();
		    try {
				orderDescr =GetTaskList.getTaskList( orderDescription,docType);
			} catch (Exception e) {
				ExceptionCode exception =new ExceptionCode(driver);
				exception.exception(i, test);
				e.printStackTrace();
			}
		
		
		if (orderDescr.toLowerCase().equalsIgnoreCase("\"" + orderDescription + "\"")) {
			//	test.log(Status.INFO, "Approve");
				try {
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(approveTaskListXpath))).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(allTasksXpath)));
					
					test.log(Status.PASS, "PR: "+PRNumber+" reviewed  by reviewer "+j);
					LogOut logOut = new LogOut(driver);
					logOut.logout(javascriptExecutor,docType);
				}catch(Exception ex) {
					
					ExceptionCode exception =new ExceptionCode(driver);
					exception.exception(i, test);
					ex.printStackTrace();
				}
				
					
			} else {
				status="FAIL";
				test.log(Status.FAIL, "NO PR Found for Reviewer"+j);
				ExceptionCode exception =new ExceptionCode(driver);
				exception.exception(i, test);
				try {	
					LogOut logOut = new LogOut(driver);
					logOut.logout(javascriptExecutor,docType);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
				}
		
		return this;
	}
	
	
	public ReviewAndApprove approve(JavascriptExecutor javascriptExecutor,String approver,String password,String orderDescription,String docType,String PRNumber,String status,int i,int j,ExtentTest test) throws Exception {
		
		Login login = new Login(driver);
		login.logIn(approver, password);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(taskListXpath))).click();
		 
				orderDescr =GetTaskList.getTaskList( orderDescription,docType);
			
		 
		 if (orderDescr.toLowerCase().equalsIgnoreCase("\"" + orderDescription  + "\"")) {
			 ApproveTaskList approveTaskList = new ApproveTaskList(driver);
			 
			 try {
				approveTaskList.approveTaskList(docType);
				
				test.log(Status.PASS, "PR: "+PRNumber+" Approved by Approver "+j);
				LogOut logOut = new LogOut(driver);
				logOut.logout(javascriptExecutor,docType);
				
			} catch (Exception e) {
				ExceptionCode exception =new ExceptionCode(driver);
				exception.exception(i, test);
				e.printStackTrace();
			}
		 }else {
			 status="FAIL";
				test.log(Status.FAIL, "NO PR Found for Approver"+j);
				ExceptionCode exception =new ExceptionCode(driver);
				exception.exception(j, test);
				try {	
					LogOut logOut = new LogOut(driver);
					logOut.logout(javascriptExecutor,docType);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		 }
		
		return this;
	}

}

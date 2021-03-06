package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BasePage;
import commons.ExceptionCode;

public class ReviewAndApprove extends BasePage {
	
	String concate=".";
	String orderDescr = "";
	String Reviewer = "Reviewer";
	WebElement webElement;
	
	static String taskListXpath = "/html/body/div/div/div[3]/div[1]/pal-narrow-layout/div/ng-transclude/div/div/div/div/div[2]/div[2]/div/a/span";
	static String approveTaskListXpath = "/html/body/div/bw-purchase-requisition-details/section/div[1]/pal-title-bar/div/div/div[2]/div/div[2]/pal-title-bar-actions/bw-purchase-requisition-details-actions/div/pal-actions/div/div/div/div[1]/div/button";
	static String allTasksXpath= "/html/body/div/div/bw-task-list-all/div/div/div[1]/div/span[1]";
	static String verifyReviewXpath = "//div[@class='pal-toast']//child::span[@role='alert' and contains(text(),'Recommended')]";
	static String taskButtonXpath="document.querySelector('alusta-navigation').shadowRoot.querySelector('div > nav > div.pt-navbar-nav.main-nav > ul > li:nth-child(3) > a')";


	public ReviewAndApprove(WebDriver driver) {
		super(driver);
		
	}
	
	
	public String review(JavascriptExecutor javascriptExecutor,String reviewer,String password,String orderDescription,String docType,String PRNumber,String status,String url,int i,int j,ExtentTest test)  {
		
		
try {
			
			Login login = new Login(driver);
			
			test.log(Status.INFO, "Login for reviewer "+j);
			login.logIn(reviewer,password,url);
			test.log(Status.INFO, "Login "+reviewer+"  reviewer "+j);
			
		}
		catch(Exception e) {
			status="FAIL";
			test.log(Status.FAIL ,"Unable to login : Invalid  User/Password/url. Or Language is France ");
			
			ExceptionCode exception = new ExceptionCode(driver);
			exception.exception(i, test);
			
			return status;
		}
		
		
	//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(taskListXpath))).click();
			
			webElement = (WebElement) javascriptExecutor.executeScript("return "+taskButtonXpath);
			webElement.click();		

		    try {
				orderDescr =GetTaskList.getTaskList(test, orderDescription,docType);
			} catch (Exception e) {
				ExceptionCode exception =new ExceptionCode(driver);
				exception.exception(i, test);
				e.printStackTrace();
			}
		
		
		if (orderDescr.toLowerCase().equalsIgnoreCase("\"" + orderDescription + "\"")) {
			//	test.log(Status.INFO, "Approve");
				try {
					test.log(Status.PASS, "Click Review Button");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(approveTaskListXpath))).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifyReviewXpath)));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(allTasksXpath)));
					test.log(Status.PASS, "Successfully Reviewed");
					
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
		
		return status;
	}
	
	
	public  String approve(JavascriptExecutor javascriptExecutor,String approver,String password,String orderDescription,String docType,String PRNumber,String status,String url,int i,int j,ExtentTest test) throws Exception {
		
		try {
			
			Login login = new Login(driver);
			
			test.log(Status.INFO, "Loging for approver "+j);
			login.logIn(approver,password,url);
			test.log(Status.INFO, "Login "+approver+"  approver "+j);
			
		}
		catch(Exception e) {
			status="FAIL";
			test.log(Status.FAIL ,"Unable to login : Invalid  User/Password/url. Or Language is France ");
			
			ExceptionCode exception = new ExceptionCode(driver);
			exception.exception(i, test);
			
			return status;
		}
		
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(taskListXpath))).click();
		
		webElement = (WebElement) javascriptExecutor.executeScript("return "+taskButtonXpath);
		webElement.click();
		
		 
		 try {
				orderDescr =GetTaskList.getTaskList(test, orderDescription,docType);
			} catch (Exception e) {
				ExceptionCode exception =new ExceptionCode(driver);
				exception.exception(i, test);
				e.printStackTrace();
			}
			
		 
		 if (orderDescr.toLowerCase().equalsIgnoreCase("\"" + orderDescription  + "\"")) {
			 ApproveTaskList approveTaskList = new ApproveTaskList(driver);
			 
			 try {
				approveTaskList.approveTaskList(test,docType);
				
				test.log(Status.PASS, "PR: "+PRNumber+" Approved by Approver "+j);
				LogOut logOut = new LogOut(driver);
				logOut.logout(javascriptExecutor,docType);
				
			} catch (Exception e) {
				ExceptionCode exception =new ExceptionCode(driver);
				exception.exception(i, test);
				e.printStackTrace();
			}
		 }else if(docType.equalsIgnoreCase("Purchase requisition")){
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
		 
		 
		 if (orderDescr.toLowerCase().equalsIgnoreCase( orderDescription )) {
			 ApproveTaskList approveTaskList = new ApproveTaskList(driver);
			 
			 try {
				approveTaskList.approveTaskList(test,docType);
				
				test.log(Status.PASS, "Invoice::   Approved by Approver "+j);
				LogOut logOut = new LogOut(driver);
				logOut.logout(javascriptExecutor,docType);
				
			} catch (Exception e) {
				ExceptionCode exception =new ExceptionCode(driver);
				exception.exception(i, test);
				e.printStackTrace();
			}
		 }else if(docType.equalsIgnoreCase("Invoice")) {
			 status="FAIL";
				test.log(Status.FAIL, "NO INVOICE Found for Approver"+j);
				ExceptionCode exception =new ExceptionCode(driver);
				exception.exception(j, test);
				try {	
					LogOut logOut = new LogOut(driver);
					logOut.logout(javascriptExecutor,docType);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		 }
		
		return status;
	}

}

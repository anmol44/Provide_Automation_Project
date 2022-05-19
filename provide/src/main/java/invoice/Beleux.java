package invoice;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.BaseTest;
import commons.ExcelData;
import commons.ExceptionCode;
import commons.ExtentReport;
import commons.OutPutSheet;
import commons.ScreenShot;
import pages.AccountsPayable;
import pages.HomePage;
import pages.LogOut;
import pages.Login;
import pages.Matching;
import pages.ReviewAndApprove;


public class Beleux extends BaseTest {
	
	
	static HashMap<Integer, HashMap<String,String>> excelData;
	static  XSSFWorkbook workbook;
	static  XSSFSheet sheet;
	static Cell cell;
	static CellStyle style;
	static String status = "FAIL";
	static String concate = ".";
	static String orderDescription = "";
	static String Reviewer = "Reviewer";
	static String Approver="Approver";
	static String prNumber="";
	static int j=1;
	
	@Test
	@Parameters("Name")
	public void sbs(String Name) throws IOException {
		
		String inputFile = System.getProperty("user.dir") +"/test/";
		String outputFile = System.getProperty("user.dir") +"/Output/OutputDataProvide.xlsx";
		ExtentReports extent = ExtentReport.initializeExtendReport();
		ExtentTest test = extent.createTest("Reading Excel File"," ");
		
		try {
			excelData = ExcelData.getExcelData(Name);
			System.out.println(excelData);
			test.log(Status.PASS, "Data Imported");
			workbook =	(XSSFWorkbook) OutPutSheet.createOutPutSheet(inputFile+Name+".xlsx",outputFile);
			sheet=workbook.getSheetAt(0);
			OutPutSheet.testStatusInSheet(workbook,sheet,excelData);
			test.log(Status.PASS, "Output ExcelSheet Created without Test Results");
			}
		catch(Exception e) {	
			test.log(Status.FAIL, "Data imported Failed");
			extent.flush();
			e.printStackTrace();
			System.exit(0);
		}
		for (int i = 1; i <=excelData.size() ; i++) {
			status="PASS";
			test = extent.createTest("PR REQUISITION : "+i, "");
			
			try {
				Login login = new Login(driver);
				test.log(Status.INFO, "Loging for PR Creator "+i);
				login.logIn(excelData.get(i).get("User"),excelData.get(i).get("Password"),excelData.get(i).get("Url"));
				test.log(Status.INFO, "Login "+excelData.get(i).get("User")+" for PR Creator "+i);
			}
			catch(Exception e) {
				status="FAIL";
				test.log(Status.FAIL ,"Unable to login : Invalid  User/Password/url. ");
				try {
					String errorSc =concate+ ScreenShot.attachedScreenShot(driver, "PR_REQUISITION "+i);
					test.log(Status.FAIL, "Error Snapshot below:", MediaEntityBuilder.createScreenCaptureFromPath(errorSc).build());
					} catch(Exception a) {
						test.log(Status.INFO, "Error Screenshot not found");
					}
				continue;
			}
			try {
				test.log(Status.INFO, "HomePage ");
				HomePage homePage = new HomePage(driver);
					homePage.accountPayable(javascriptExecutor);
					
					
				test.log(Status.INFO, "Accounts Payable ");	
				AccountsPayable accountsPayable = new AccountsPayable(driver);
				test.log(Status.INFO, "Invoice search ");	
					accountsPayable.receivedStage().
					invoiceSearch(excelData.get(i).get("InvoiceNo"));
					
					if(!excelData.get(i).get("PO Number").isEmpty()) {
						
						test.log(Status.INFO, "Enter Data for Po Invoice ");	
						accountsPayable.matching(excelData.get(i).get("InvoiceNo"),excelData.get(i).get("PO Number"),excelData.get(i).get("SupplierCode"),excelData.get(i).get("InvoiceDate"),excelData.get(i).get("InvoiceAmt"),excelData.get(i).get("TaxAmt"));
						
						Matching matching = new Matching(driver);
						matching.openAndMatchInvoice(excelData.get(i).get("MatchQty"));
					}
					if(!excelData.get(i).get("PR Type").isEmpty() && excelData.get(i).get("PO Number").isEmpty()) {
						
						test.log(Status.INFO, "Enter Data for  Non-Po Invoice");	
						accountsPayable.nonPOInvoice(javascriptExecutor,excelData.get(i).get("InvoiceNo"),excelData.get(i).get("SupplierCode"),excelData.get(i).get("InvoiceDate"),excelData.get(i).get("InvoiceAmt"),excelData.get(i).get("TaxAmt"),excelData.get(i).get("Approver"),excelData.get(i).get("PurchaseCAtegory"),excelData.get(i).get("Agency"),excelData.get(i).get("Type"),excelData.get(i).get("SSP"));
						}
				
				LogOut logOut = new LogOut(driver);
				logOut.logout(javascriptExecutor,excelData.get(i).get("docType"));
				test.log(Status.INFO, "LogOut "+excelData.get(i).get("User")+" for Invoice "+i );
				
				if(excelData.get(i).containsKey(Reviewer + 1) && !excelData.get(i).get(Reviewer + 1).isEmpty()) {
					test.log(Status.INFO, "Review Process Started ");	
					ReviewAndApprove reviewAndApprove = new ReviewAndApprove(driver);
					while (excelData.get(i).containsKey(Reviewer + j) && !excelData.get(i).get(Reviewer + j).isEmpty()) {
						System.out.println(excelData.get(i).containsKey(Reviewer + j));
						status = reviewAndApprove.review(javascriptExecutor,excelData.get(i).get(Reviewer + j),excelData.get(i).get("Password"),excelData.get(i).get("OrderDesc"),excelData.get(i).get("docType"),prNumber,status,excelData.get(i).get("Url"),i,j,test);
						j++;
					}
					j=1;
				}
					test.log(Status.INFO, "Approval Process Started ");	
					
					ReviewAndApprove reviewAndApprove = new ReviewAndApprove(driver);
					while (excelData.get(i).containsKey(Approver + j) && !excelData.get(i).get(Approver + j).isEmpty()) {
						System.out.println(excelData.get(i).containsKey(Approver + j));
						status = reviewAndApprove.approve(javascriptExecutor,excelData.get(i).get(Approver + j),excelData.get(i).get("Password"),excelData.get(i).get("OrderDesc"),excelData.get(i).get("docType"),prNumber,status,excelData.get(i).get("Url"),i,j,test);
						j++;
					}
					j=1;
			
			} catch(Exception e) {
			 test.log(Status.FAIL, "PR REQUISITION: "+i+e.toString());
				 	ExceptionCode exception =new ExceptionCode(driver);
					exception.exception(i, test);
					status="FAIL";
					LogOut logOut = new LogOut(driver);
					try {
						logOut.logout(javascriptExecutor,excelData.get(i).get("docType"));
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					test.log(Status.INFO,"creator Log Out");
					 
						e.printStackTrace();
			}
			try {
				OutPutSheet.updateStatus(workbook, sheet, status, i,excelData);
			}
			catch(Exception e) {
				
				e.printStackTrace();
			}
		}
	OutPutSheet.outPutResultSheet(workbook, extent);
		
	}
	
}


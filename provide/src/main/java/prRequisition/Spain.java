package prRequisition;

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
import pages.EditCoding;
import pages.EditRequisition;
import pages.Form;
import pages.GetApprove;
import pages.HomePage;
import pages.LogOut;
import pages.Login;
import pages.ReviewAndApprove;
import pages.Shop;
import pages.ViewDetails;

public class Spain extends BaseTest {
	
	
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
					homePage.shopBtn(javascriptExecutor);
					
					
				test.log(Status.INFO, "ShopButton ");	
				Shop shop = new Shop(driver);
					shop.selectForm(excelData.get(i).get("Organization"), javascriptExecutor);
					
				test.log(Status.INFO, "Select Orgainzation ");
				Form form = new Form(driver);
					form.editRequisitionSpain(excelData.get(i).get("PRForm"));
				
				test.log(Status.INFO, "Enter Data for Edit Requisition creation ");
				EditRequisition editRequisition = new EditRequisition(driver);
					editRequisition.editCodingSpain(excelData.get(i).get("OrderDesc"),excelData.get(i).get("Product Name"), excelData.get(i).get("PurchaseCategory"),excelData.get(i).get("Supplier"), excelData.get(i).get("Quantity"),excelData.get(i).get("UnitPrice"),excelData.get(i).get("Currency"), excelData.get(i).get("PR tYPE"));
					test.log(Status.INFO, "Enter Data for Edit Requisition successfull ");
					
					test.log(Status.INFO, "Enter Data for Edit Coding creation ");
				EditCoding editCoding = new EditCoding(driver);
					editCoding.viewDetailsSpain(javascriptExecutor, excelData.get(i).get("Requestor"), excelData.get(i).get("Delivery Address"), excelData.get(i).get("Nature"), excelData.get(i).get("Agency/Site"),excelData.get(i).get("Type"), excelData.get(i).get("PR tYPE"),excelData.get(i).get("SSP"));
					test.log(Status.INFO, "Enter Data for Edit Coding successfull ");
					
				test.log(Status.INFO, "Enter Data for View Details creation ");	
				ViewDetails viewDetails = new ViewDetails(driver);
					viewDetails.getApproveSpain(excelData.get(i).get("Quantity"), excelData.get(i).get("UnitPrice"),excelData.get(i).get("Payment Terms"));
					test.log(Status.INFO, "Enter Data for View Details successfull ");	
					
				test.log(Status.INFO, "Get Approve Successfull");
				GetApprove getApprove = new GetApprove(driver);
				prNumber=getApprove.prNumber();
					test.log(Status.PASS, "PR: "+ prNumber +" Successfuly created.");
				
					
				LogOut logOut = new LogOut(driver);
				logOut.logout(javascriptExecutor,excelData.get(i).get("docType"));
				test.log(Status.INFO, "LogOut "+excelData.get(i).get("User")+" for PR Creator "+i );
				
				
				if(excelData.get(i).containsKey(Reviewer + 1) && !excelData.get(i).get(Reviewer + 1).isEmpty()) {
					test.log(Status.INFO, "Review Process Started ");	
					
					ReviewAndApprove reviewAndApprove = new ReviewAndApprove(driver);
					while (excelData.get(i).containsKey(Reviewer + j) && !excelData.get(i).get(Reviewer + j).isEmpty()) {
						System.out.println(excelData.get(i).containsKey(Reviewer + j));
						reviewAndApprove.review(javascriptExecutor,excelData.get(i).get(Reviewer + j),excelData.get(i).get("Password"),excelData.get(i).get("OrderDesc"),excelData.get(i).get("docType"),prNumber,status,excelData.get(i).get("Url"),i,j,test);
						j++;
					}
					j=1;
				}
					test.log(Status.INFO, "Approval Process Started ");	
					
					ReviewAndApprove reviewAndApprove = new ReviewAndApprove(driver);
					while (excelData.get(i).containsKey(Approver + j) && !excelData.get(i).get(Approver + j).isEmpty()) {
						System.out.println(excelData.get(i).containsKey(Approver + j));
						reviewAndApprove.approve(javascriptExecutor,excelData.get(i).get(Approver + j),excelData.get(i).get("Password"),excelData.get(i).get("OrderDesc"),excelData.get(i).get("docType"),prNumber,status,excelData.get(i).get("Url"),i,j,test);
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

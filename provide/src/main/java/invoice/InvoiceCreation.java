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
import com.aventstack.extentreports.Status;

import base.BaseTest;
import commons.ExcelData;
import commons.ExceptionCode;
import commons.ExtentReport;
import commons.OutPutSheet;
import commons.UserLoginException;
import pages.CreateInvoice;
import pages.HomePage;
import pages.LogOut;
import pages.Login;

public class InvoiceCreation extends BaseTest {

	static HashMap<Integer, HashMap<String, String>> excelData;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static Cell cell;
	static CellStyle style;
	static String status = "FAIL";
	static String concate = ".";
	
	
	@Test 
	@Parameters("Name")
	public void invoiceCreation(String Name)  throws InterruptedException, IOException {
		String inputFile = System.getProperty("user.dir") + "/test/";
		String outputFile = System.getProperty("user.dir") + "/Output/OutputInvoiceData.xlsx";
		
		ExtentReports extent = ExtentReport.initializeExtendReport();
		ExtentTest test = extent.createTest("Reading Excel File", " ");
		
		try {
			excelData = ExcelData.getExcelData(Name);
			System.out.println(excelData);
			test.log(Status.PASS, "Data Imported");
			workbook = (XSSFWorkbook) OutPutSheet.createOutPutSheet(inputFile + Name + ".xlsx", outputFile);
			sheet = workbook.getSheetAt(0);
			System.out.println(sheet);
			OutPutSheet.testStatusInSheet(workbook, sheet, excelData);
			test.log(Status.PASS, "Output ExcelSheet Created without Test Results");
		} catch (Exception e) {
			test.log(Status.FAIL, "Data imported Failed");
			extent.flush();
			e.printStackTrace();
			System.exit(0);

		}
		for (int i = 1; i <= excelData.size(); i++) {
			status = "PASS";
		test = extent.createTest("Create Invoice "+ i);
		
		try {
			Login login = new Login(driver);
			test.log(Status.INFO, "Loging for Invoice creation  " + i);
			
			login.logIn(
					excelData.get(i).get("User"),
					excelData.get(i).get("Password"),
					excelData.get(i).get("Url")
					);
			
			test.log(Status.PASS, "Login " + excelData.get(i).get("User") + " for Invoice Creator " + i);

		} catch (Exception e) {
			
			UserLoginException userLoginException = new UserLoginException(driver);
			userLoginException.loginExceptionHandler(status, test,workbook,sheet,i,excelData);
			 continue;
		}
		
		try {
			test.log(Status.INFO, "HomePage ");
			HomePage homePage = new HomePage(driver);
				homePage.accountPayable(test,javascriptExecutor).
				clickCreateInvoice(test);
				
				CreateInvoice createInvoice = new CreateInvoice(driver);
				createInvoice.
				addImage(test).
				selectOrganization(test,excelData.get(i).get("Organization")).
				enterInvoiceNumber(test, excelData.get(i).get("InvoiceNo")).
				clickSaveDraft(test);
				Thread.sleep(10000);
				
				LogOut logOut = new LogOut(driver);
				logOut.logout(javascriptExecutor,excelData.get(i).get("docType"));
				test.log(Status.INFO, "LogOut "+excelData.get(i).get("User")+" for Invoice "+i );
				
		}catch(Exception e) {
			 test.log(Status.FAIL, "Invoice: "+i+e.toString());
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
		
		OutPutSheet.outPutResultSheet(workbook, extent, outputFile);
		
	}
}

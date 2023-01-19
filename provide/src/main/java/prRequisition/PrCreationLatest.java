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
import com.aventstack.extentreports.Status;

import base.BaseTest;
import commons.ExcelData;
import commons.ExceptionCode;
import commons.ExtentReport;
import commons.OutPutSheet;
import commons.UserLoginException;
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

public class PrCreationLatest extends BaseTest {

	static HashMap<Integer, HashMap<String, String>> excelData;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static Cell cell;
	static CellStyle style;
	static String status = "FAIL";
	static String concate = ".";
	static String orderDescription = "";
	static String Reviewer = "Reviewer";
	static String Approver = "Approver";
	static String prNumber = "";
	static int j = 1;

	@Test   // Create Pr for Each Entity
	@Parameters("Name")
	public void PrCreation(String Name) throws InterruptedException, IOException {

		String inputFile = System.getProperty("user.dir") + "/test/";
		String outputFile = System.getProperty("user.dir") + "/Output/OutputDataProvide.xlsx";

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
			test = extent.createTest("PR REQUISITION : " + i, "");
			try {
				Login login = new Login(driver);
				test.log(Status.INFO, "Loging for PR Creator " + i);
				
				login.logIn(
						excelData.get(i).get("User"),
						excelData.get(i).get("Password"),
						excelData.get(i).get("Url")
						);
				
				test.log(Status.PASS, "Login " + excelData.get(i).get("User") + " for PR Creator " + i);

			} catch (Exception e) {
				
				UserLoginException userLoginException = new UserLoginException(driver);
				userLoginException.loginExceptionHandler(status, test,workbook,sheet,i,excelData);
				 continue;
			}

			try {
				test.log(Status.INFO, "HomePage ");
				HomePage homePage = new HomePage(driver);
				homePage.shopBtn(test,javascriptExecutor);

				test.log(Status.INFO, "ShopButton ");
				Shop shop = new Shop(driver);
				shop.selectForm(
						test,
						excelData.get(i).get("Organization"),
						javascriptExecutor);

				
				Form form = new Form(driver);
				form.editRequisition(
						test,
						excelData.get(i).get("PRForm")
						);

				test.log(Status.INFO, "Enter Data for Edit Requisition creation ");
				EditRequisition editRequisition = new EditRequisition(driver);
				editRequisition.editCoding(
						test,
						excelData.get(i).get("OrderDesc"),
						excelData.get(i).get("Product Name"),
						excelData.get(i).get("PurchaseCategory"),
						excelData.get(i).get("Supplier"),
						excelData.get(i).get("Quantity"),
						excelData.get(i).get("UnitPrice"),
						excelData.get(i).get("Currency"), 
						excelData.get(i).get("PR tYPE")
						);
						
				
				test.log(Status.INFO, "Wait till 30 sec for Basware Response");
				EditCoding editCoding = new EditCoding(driver);
				editCoding.viewDetails(
						test,
						javascriptExecutor, 
						excelData.get(i).get("Requestor"),
						excelData.get(i).get("Delivery Address"), 
						excelData.get(i).get("Coding"),
						excelData.get(i).get("Agency/Site"),
						excelData.get(i).get("Type"),
						excelData.get(i).get("PR tYPE"), 
						excelData.get(i).get("SSP")
						);
				test.log(Status.PASS, "Enter Data for Edit Coding successfull ");

				test.log(Status.INFO, "Enter Data for View Details creation ");
				ViewDetails viewDetails = new ViewDetails(driver);
				viewDetails.getApproveNew(
						test,
						excelData.get(i).get("Quantity"),
						excelData.get(i).get("UnitPrice"),
						excelData.get(i).get("Payment Terms"),
						excelData.get(i).get("SellingPrice")
						);

				test.log(Status.INFO, "Get Approval Successfull");
				GetApprove getApprove = new GetApprove(driver);
				prNumber = getApprove.prNumber(test);
				
				test.log(Status.INFO, "LogOut for "+prNumber + " creator");	
				LogOut logOut = new LogOut(driver);
				logOut.logout(javascriptExecutor, excelData.get(i).get("docType"));
				test.log(Status.INFO, "LogOut " + excelData.get(i).get("User") + " for PR Creator " + i);
				
				test.log(Status.INFO, "Check for reviewer if available");	
				if (excelData.get(i).containsKey(Reviewer + 1) && !excelData.get(i).get(Reviewer + 1).isEmpty()) {
					test.log(Status.INFO, "Review Process Started ");

					ReviewAndApprove reviewAndApprove = new ReviewAndApprove(driver);
					while (excelData.get(i).containsKey(Reviewer + j)
							&& !excelData.get(i).get(Reviewer + j).isEmpty()) {
						
						status = reviewAndApprove.review(
								javascriptExecutor, 
								excelData.get(i).get(Reviewer + j),
								excelData.get(i).get("Password"),
								excelData.get(i).get("OrderDesc"),
								excelData.get(i).get("docType"),
								prNumber, 
								status, 
								excelData.get(i).get("Url"), 
								i,
								j,
								test);
						j++;
					}
					j = 1;
				}
				test.log(Status.INFO, "Approval Process Started ");

				ReviewAndApprove reviewAndApprove = new ReviewAndApprove(driver);
				while (excelData.get(i).containsKey(Approver + j) && !excelData.get(i).get(Approver + j).isEmpty()) {
					status = reviewAndApprove.approve(
							javascriptExecutor,
							excelData.get(i).get(Approver + j),
							excelData.get(i).get("Password"), 
							excelData.get(i).get("OrderDesc"),
							excelData.get(i).get("docType"), 
							prNumber,
							status,
							excelData.get(i).get("Url"),
							i, 
							j,
							test);
					j++;
				}
				j = 1;

			} catch (Exception e) {

				test.log(Status.FAIL, "PR REQUISITION: " + i + e.toString());

				ExceptionCode exception = new ExceptionCode(driver);
				exception.exception(i, test);
				status = "FAIL";
				LogOut logOut = new LogOut(driver);
				try {

					logOut.logout(javascriptExecutor, excelData.get(i).get("docType"));

				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}
				test.log(Status.INFO, "creator Log Out");
				e.printStackTrace();
			}
			try {
				OutPutSheet.updateStatus(workbook, sheet, status, i, excelData);
			}

			catch (Exception e) {

				e.printStackTrace();
			}

		}
		OutPutSheet.outPutResultSheet(workbook, extent, outputFile);

	}

}

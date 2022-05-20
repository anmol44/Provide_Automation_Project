package commons;

import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BasePage;

public class UserLoginException extends BasePage {
	
	
	public UserLoginException(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void loginExceptionHandler(String status ,ExtentTest test, XSSFWorkbook workbook, XSSFSheet sheet,int i,HashMap<Integer, HashMap<String, String>> excelData) {

	status = "FAIL";
	test.log(Status.FAIL, "Unable to login : Invalid  User/Password/url. OR Language is not English ");


	ExceptionCode exception = new ExceptionCode(driver);
	exception.exception(i, test);
	
	try {
		OutPutSheet.updateStatus(workbook, sheet, status, i, excelData);
	}

	catch (Exception ex) {

		ex.printStackTrace();
	}
	
	}
	
}

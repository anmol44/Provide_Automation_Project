package commons;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.BasePage;

public class ExceptionCode extends BasePage {
	
	public ExceptionCode(WebDriver driver) {
		super(driver);
	}

	String concate=".";
	
	public void exception(int i,ExtentTest test) {
		
		try {
			String errorSc =concate+ ScreenShot.attachedScreenShot(driver,"ScreenShot"+i);
			
			test.log(Status.FAIL, "Error Snapshot below:", MediaEntityBuilder.createScreenCaptureFromPath(errorSc).build());
				
			} catch(Exception ex) {
				
				
				test.log(Status.INFO, "Error Screenshot not found");
			}
		
	}

}

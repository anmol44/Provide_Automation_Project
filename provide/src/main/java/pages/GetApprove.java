package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BasePage;

public class GetApprove extends BasePage {
	
	static String getPrApproveNumberXpath = "//*//span[@class='pal-main-title ng-binding']";
	

	public GetApprove(WebDriver driver) {
		super(driver);
		
	}
	
	
	
	public String prNumber(ExtentTest test) throws InterruptedException {
		Thread.sleep(6000);
		test.log(Status.INFO, "Go Back to get PR Number");	
		driver.navigate().back();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(getPrApproveNumberXpath))).getText();
		test.log(Status.INFO, "Get PR Number");	
		String Pr = driver.findElement(By.xpath(getPrApproveNumberXpath)).getText();
		test.log(Status.PASS, "PR number generated : "+Pr);	
		System.out.println("PR number generated : " +Pr);
		return Pr;
	}

}

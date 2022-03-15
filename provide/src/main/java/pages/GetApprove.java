package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import base.BasePage;

public class GetApprove extends BasePage {
	
	static String getPrApproveNumberXpath = "//*//span[@class='pal-main-title ng-binding']";
	

	public GetApprove(WebDriver driver) {
		super(driver);
		
	}
	
	
	
	public String prNumber() throws InterruptedException {
		Thread.sleep(6000);
		driver.navigate().back();
		
		String Pr = driver.findElement(By.xpath(getPrApproveNumberXpath)).getText();
		System.out.println("PR number : " +Pr);
		return Pr;
	}

}

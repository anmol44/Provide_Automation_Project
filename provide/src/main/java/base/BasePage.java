package base;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	JavascriptExecutor javascriptExecutor;
	
	public BasePage(WebDriver driver) {
		BasePage.driver=driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		javascriptExecutor = (JavascriptExecutor) driver;
	}
	
	
	
	public void waitForOverlaysToDisappear(By Overlay) {
		List<WebElement> overlays = driver.findElements(Overlay);
		System.out.println("OVERLAY SIZE" + overlays.size());
		if(overlays.size()>0) {
			wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
			System.out.println("OVERLAYS INVISIBLE");
		} else {
			System.out.println("OVERLAY NOT FOUND");
		}
		
	}
	
	
	// making Overload methods for selecting time and type of locator.
	public void waitForElement(String element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
	}
	
	public WebElement waitForElement(By by, Integer to) {
		WebDriverWait waitLocal = new WebDriverWait(driver,Duration.ofSeconds(to));
		return waitLocal.until(ExpectedConditions.visibilityOfElementLocated(by));
		
	}
	
	

}

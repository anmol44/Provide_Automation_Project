package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverManager;

public class BaseTest {
	
	protected WebDriver driver;
	protected JavascriptExecutor javascriptExecutor;
	
	
	@BeforeMethod
	public void startDriver() {
		driver = new DriverManager().initializeDriver();
		javascriptExecutor = (JavascriptExecutor) driver;
	}
	
	
	// Method to be called after each test case run
	  @AfterMethod 
	  public void quitDriver() throws InterruptedException {
	  Thread.sleep(100); 
	  driver.quit(); 
	  }
	 
	 
	 
	 
}

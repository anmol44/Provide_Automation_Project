package commons;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	
	
	public static  String  attachedScreenShot(WebDriver driver,String name )throws Exception {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = "./Output/ErrorScreenshots/"+name+".png";
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File(dest);
		FileHandler.copy(source, destination);
		return dest;
		
	}

}

package commons;

import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenShot {
	
	
	public static  String  attachedScreenShot(WebDriver driver,String name )throws Exception {
		TakesScreenshot ts = (TakesScreenshot)driver;
		// For Full screen Shot of page using Ashot library
		 Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	     ImageIO.write(s.getImage(),"PNG",new File("./Output/ErrorScreenshots/"+name+".png"));
			/*
			 * File source = ts.getScreenshotAs(OutputType.FILE); File destination = new
			 * File(dest); FileHandler.copy(source, destination);
			 */
		String dest = "./Output/ErrorScreenshots/"+name+".png";

		return dest;
		
	}

}

package commons;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

@SuppressWarnings("deprecation")
public class ExtentReport {
	
	
public static ExtentReports initializeExtendReport() {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/Output/testReport.html");
	    
        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
     
         return extent;
         
       
	}

}

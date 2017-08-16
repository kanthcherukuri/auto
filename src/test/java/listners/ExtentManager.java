package listners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import testBase.*;

public class ExtentManager extends LoadPropMac {
    
    private static ExtentReports extent;
    
    public static ExtentReports getInstance()    {
    	if (extent == null)
    		createInstance("test-output/extent.html");
    	
        return extent;
    }
    
    public static ExtentReports createInstance(String fileName)     {
    	
    	FileInputStream inStream = null;
		try {
			inStream = new FileInputStream(new File("ConfigFiles/Setup-Details.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		base_url=prop.getProperty("base.url");
		browser_name=prop.getProperty("browser.name");
		author_name=prop.getProperty("author.name");
		
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);
       
         extent = new ExtentReports();
      
         extent.setSystemInfo("Environment", "Zolyo-QA");
         extent.setSystemInfo("Browser Details", browser_name);
         extent.setSystemInfo("Application", base_url);
         extent.setSystemInfo("User Name", "Ganesh Kumar Mandala");
         extent.setSystemInfo("Device Name", System.getProperty("os.name"));
         extent.attachReporter(htmlReporter);
        
        return extent;
    }
}

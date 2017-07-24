package listners;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testBase.LoadPropMac;

public class TestListener extends LoadPropMac implements ITestListener {
	String filePath = "Screenshots/";
	Date today = new Date();
	
	
	public void onFinish(ITestContext context) {
		
    }
		
	public void onTestFailure(ITestResult result) {
    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
    	String className=result.getTestClass().toString().trim();
    	System.out.println("Failed Class Name ="+className);
    	System.out.println("Failed Method Name ="+methodName);
    	takeScreenShot(methodName);
    	
    }
    
    public void takeScreenShot(String methodName) {
    	
    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with test method name 
            try {
				FileUtils.copyFile(scrFile, new File(filePath+methodName+today+".png"));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
    }

	
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	 public void onTestStart(ITestResult result) { 
	    	
	    	System.out.println("Test Started");
	    	String methodName=result.getName().toString().trim();
	    	String className=result.getTestClass().toString().trim();
	    	System.out.println("***********Testing Class Name ="+className+"*****************");
	    	System.out.println("***********Testing Method Name ="+methodName+"***************");
	    }

	
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}






	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}






	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}

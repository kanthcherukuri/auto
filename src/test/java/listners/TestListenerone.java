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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import testBase.LoadPropMac;

public class TestListenerone extends LoadPropMac implements ITestListener {
	String filePath = "Screenshots/";
	Date today = new Date();
	private static ExtentReports extent = ExtentManager.createInstance("extent.html");
	private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    private static ThreadLocal<Object> test = new ThreadLocal<Object>();

    
    
	public synchronized void onStart(ITestContext context) {
		String methodName=context.getName().toString().trim();
    	ExtentTest parent = extent.createTest(getClass().getName());
   
        parentTest.set(parent);
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
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
    	
    	 File scrFile = (File) ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with test method name 
            try {
				FileUtils.copyFile(scrFile, new File(filePath+methodName+today+".png"));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
    }

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	


	 public void onTestStart(ITestResult result) { 
			
		 ExtentTest child = parentTest.get().createNode(result.getMethod().getMethodName());
	     test.set(child);
	
	    	System.out.println("Test Started");
	    	String methodName=result.getName().toString().trim();
	    	String className=result.getTestClass().toString().trim();
	    	System.out.println("***********Testing Class Name ="+className+"*****************");
	    	System.out.println("***********Testing Method Name ="+methodName+"***************");
	    	
	    	ExtentTest parent = extent.createTest(getClass().getName());
			   
	        parentTest.set(parent);
	    }

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		
	}

	

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}



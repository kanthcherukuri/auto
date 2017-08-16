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


public class TestListener extends LoadPropMac implements ITestListener {
	String filePath = "Screenshots/";
	Date today = new Date();
	private static ExtentReports extent = ExtentManager.createInstance("extent.html");
	private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	
    public synchronized void onStart(ITestContext context) {
    	ExtentTest parent = extent.createTest(getClass().getName());
        parentTest.set(parent);
	}

	
	public synchronized void onFinish(ITestContext context) {
		extent.flush();
	}
	
	
	public synchronized void onTestStart(ITestResult result) {
		 ExtentTest child = parentTest.get().createNode(result.getMethod().getMethodName());
	     test.set(child);
	}

	
	public synchronized void onTestSuccess(ITestResult result) {
		test.get().pass("Test passed");
	}

	
	public synchronized void onTestFailure(ITestResult result) {
		test.get().fail(result.getThrowable());
	}

	public synchronized void onTestSkipped(ITestResult result) {
		test.get().skip(result.getThrowable());
	}

	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
}


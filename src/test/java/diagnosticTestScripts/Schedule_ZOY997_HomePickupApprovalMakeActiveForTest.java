package diagnosticTestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY997_HomePickupApprovalMakeActiveForTest extends LoadPropMac{
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	

	@BeforeClass
	  public void launchbrowser() throws Exception {
		LoadBrowserProperties();
		 driver.manage().window().maximize();
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 DiagnosticPageZoylo.SignIn(Diagnostic_username, Diagnostic_password);
		  }
	
	
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Ganga","Full Body Test","10000","2"}

			};
		}

	@Test(dataProvider="DP1")
	public void ScheduleHomePickupTestMakeActiveInActive(String RunMode, String testname,String description,String cost,String discount) throws Exception{
		//After login Clicking on ScheduleMenu
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		Thread.sleep(2000);
		//In Schedule Menu clicking on HomePickup menu
		DiagnosticPageZoylo.clickonhomevisitmenu();
		//In Schedule Adding New Test in Test menu
		int id=DiagnosticPageZoylo.ScheduleHomeVisitAddTest(testname, description, cost, discount);
        System.out.println("The Id is :"+id);
		Thread.sleep(3000);
		//Created Test will be Sending for Approval
		DiagnosticPageZoylo.ScheduleHomePickupSubmitTestsForApproval(id);
		Thread.sleep(2000);
		driver.close();
		Thread.sleep(1000);
		//Launch New Browser To Login Into Admin Account
		DiagnosticPageZoylo.LaunchBrowserToLoginIntoAdminAccount("laKSHMikanth@zoylo.com", "Zoylo@123");
		//Admin Account To Approve the Created Test
		DiagnosticPageZoylo.ApproveTestInAdmin(testname);
		//driver.close();
		//Launching Browser to Login into Diagnostic Provider Account
		launchbrowser();
		Thread.sleep(2000);
		//After login Clicking on ScheduleMenu
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		Thread.sleep(2000);
		//In Schedule Menu clicking on HomePickup menu
		DiagnosticPageZoylo.clickonhomevisitmenu();
		Thread.sleep(3000);
		//Make the Test Active which is Approved by Admin
		DiagnosticPageZoylo.ScheduleHomePickupMakeTestsActive(id);
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void closebrowser(){
		driver.quit();
	}
}

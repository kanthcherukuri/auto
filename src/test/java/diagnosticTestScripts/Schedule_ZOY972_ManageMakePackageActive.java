package diagnosticTestScripts;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import objectRepository.Elements_Diagnostics;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY972_ManageMakePackageActive extends LoadPropMac{
	
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
		 DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		  }
	
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","aurbindotest","30000","2","Full Body Blood Test for Malaria","aurbindotest","Full Body Blood Test for Malaria"}

			};
		}
	@Test(dataProvider="DP1")
	public void ManageMakePackageActive(String RunMode,String packagename,String cost,String discount, String description,String testname,String testdescription) throws Exception{
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		DiagnosticPageZoylo.ScheduleInManageAddPackage(packagename, cost, discount, description, testname, testdescription);
		DiagnosticPageZoylo.ScheduleInManageSubmitPackageforApproval();
		Thread.sleep(2000);	
		driver.close();
		Thread.sleep(2000);
		DiagnosticPageZoylo.LaunchBrowserToLoginIntoAdminAccount("laKSHMikanth@zoylo.com", "Zoylo@123");
		Thread.sleep(2000);
		DiagnosticPageZoylo.ApproveTestInAdmin(testname);
		Thread.sleep(2000);
		launchbrowser();
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		driver.findElement(By.id(Elements_Diagnostics.clickondiagnosticmanage)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Elements_Diagnostics.clickonpackagemenu)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='sp-diag-dcenter-packapprove-hours-switch-switch'])[last()]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("saveClinicPackages")).click();
		Browser.CheckNotificationMessage("Diagnostics Packages updated successfully");
	}
	
	@AfterClass
	public void closebrowser(){
		driver.close();
	}
}
package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import objectRepository.Elements_Diagnostics;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY972_InManageMakePackageActive extends LoadPropMac{
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	@BeforeClass
	  public void launchbrowser() throws Exception {
		LoadBrowserProperties();
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 Browser.openUrl(loginPage_Url);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		  }
	
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Gunturpak","30000","10","Full Body Blood Test for Malaria","anantpurtest","Full Body Blood Test for Malaria"}

			};
		}
	@Test(dataProvider="DP1")
	public void ManageMakePackageActive(String RunMode,String packagename,String cost,String discount, String description,String testname,String testdescription) throws Exception{
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		DiagnosticPageZoylo.ScheduleInManageAddPackage(packagename, cost, discount, description, testname, testdescription);
		DiagnosticPageZoylo.ScheduleInManageSubmitPackageforApproval();
		Thread.sleep(2000);	
		DiagnosticPageZoylo.diagnosticlogout();
		Browser.openUrl(loginPage_Url);
		DiagnosticPageZoylo.SignIn("kanthl@zoylo.com","Zoylo@123");
		Browser.waitTill(2000);
		Browser.clickOnTheElementByXpath("//a[@href='/admin/zyDiagnosticCenters']");
		Browser.waitFortheElementXpath("//a[@href='/admin/zyDiagnosticCenterPackagesAndTestApprovalsList']");
		Browser.clickOnTheElementByXpath("//a[@href='/admin/zyDiagnosticCenterPackagesAndTestApprovalsList']");
		Thread.sleep(1000);
		//driver.get( Diagnostic_ApprovedApptURL);
		DiagnosticPageZoylo.ApproveTestInAdmin(packagename);
		Thread.sleep(5000);
		Browser.waitFortheElementXpath("html/body/div[6]/header/div[2]/ul/li/div/button");
		Browser.clickOnTheElementByXpath("html/body/div[6]/header/div[2]/ul/li/div/button");
		Thread.sleep(2000);
		Browser.clickOnTheElementByID("logout");
		Thread.sleep(3000);
		Browser.openUrl(loginPage_Url);
		DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		driver.findElement(By.id(Elements_Diagnostics.clickondiagnosticmanage)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Elements_Diagnostics.clickonpackagemenu)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='sp-diag-dcenter-packapprove-hours-switch-switch'])[last()]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("saveClinicPackages")).click();
		Browser.CheckNotificationMessage("Diagnostics Packages updated successfully");
		Thread.sleep(1000);
		DiagnosticPageZoylo.diagnosticslogout();
	}
	
	@AfterClass
	public void closebrowser(){
		driver.quit();
	}
}

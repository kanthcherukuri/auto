package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
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
		 Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DiagnosticPageZoylo.SignIn(Diagnostic_usernamesix, Diagnostic_passwordsix);
		  }
	
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","30000","10","Full Body Blood Test for Malaria","anantpurtest","Full Body Blood Test for Malaria"}

			};
		}
	@Test(dataProvider="DP1")
	public void ManageMakePackageActive(String RunMode,String cost,String discount, String description,String testname,String testdescription) throws Exception{
		String packagename="Guntapalli"+Browser.randomalphabets();
		System.out.println("Random Package Name:"+packagename);
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		DiagnosticPageZoylo.ScheduleInManageAddPackage(packagename, cost, discount, description, testname, testdescription);
		DiagnosticPageZoylo.ScheduleInManageSubmitPackageforApproval();
		Thread.sleep(2000);	
		DiagnosticPageZoylo.diagnosticlogout();
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		DiagnosticPageZoylo.SignIn("kanthl@zoylo.com","Zoylo@123");
		Browser.waitTill(2000);
		Browser.clickOnTheElementByXpath("//a[@href='/admin/zyDiagnosticCenters']");
		Browser.waitFortheElementXpath("//a[@href='/admin/zyDiagnosticCenterPackagesAndTestApprovalsList']");
		Browser.clickOnTheElementByXpath("//a[@href='/admin/zyDiagnosticCenterPackagesAndTestApprovalsList']");
		//Thread.sleep(1000);
		DiagnosticPageZoylo.ApproveTestInAdmin(packagename);
		//Thread.sleep(6000);
		Browser.clickOnTheElementByXpath("html/body/div[6]/header/div[2]/ul/li/div/button");
		Thread.sleep(2000);
		Browser.clickOnTheElementByID("logout");
		Thread.sleep(2000);
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		DiagnosticPageZoylo.SignIn(Diagnostic_usernamesix, Diagnostic_passwordsix);
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickondiagnosticmanage);
		//Thread.sleep(3000);
		Browser.waitFortheElementXpath(Elements_Diagnostics.clickonpackagemenu);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.clickonpackagemenu);
		//Thread.sleep(3000);
		Browser.clickOnTheElementByXpath("(//span[@class='sp-diag-dcenter-packapprove-hours-switch-switch'])[last()]");
		//Thread.sleep(2000);
		Browser.clickOnTheElementByID("saveClinicPackages");
		Browser.CheckNotificationMessage("Diagnostics Packages updated successfully");
		Thread.sleep(1000);
		DiagnosticPageZoylo.diagnosticlogout();
	}
	
	@AfterClass
	public void closebrowser(){
		driver.quit();
	}
}

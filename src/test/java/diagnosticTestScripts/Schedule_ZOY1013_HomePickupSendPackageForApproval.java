package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY1013_HomePickupSendPackageForApproval extends LoadPropMac {
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	@BeforeClass
	public void LaunchBrowser() throws Exception {
		LoadBrowserProperties();
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 Browser.openUrl(loginPage_Url);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
	  }
	
	@Test
	public void ScheduleHomeVistPackageForApproval() throws Exception{
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		DiagnosticPageZoylo.clickonhomevisitmenu();
		DiagnosticPageZoylo.ClickOnSchedulePackageHomePickUp();
		DiagnosticPageZoylo.ScheduleHomePickUpAddPackage("konarkpackage", "Full body Examination", "20000", "2","konarttest", "Full body Examination");
		Thread.sleep(3000);
		DiagnosticPageZoylo.ScheduleHomePickUpPackageSendforApproval();
		
		
		
	}
	
	@AfterClass
	  public void CloseBrowser() {
		driver.quit();
	  }
	

}

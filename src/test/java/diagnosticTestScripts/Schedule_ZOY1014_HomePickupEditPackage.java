package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY1014_HomePickupEditPackage extends LoadPropMac {
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	@BeforeClass
	  public void LaunchBrowser() throws Exception {
		LoadBrowserProperties();
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		  }
	
	@Test
	public void ScheduleHomePickUpPackageEdit() throws Exception{
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		DiagnosticPageZoylo.clickonhomevisitmenu();
		DiagnosticPageZoylo.ClickOnSchedulePackageHomePickUp();
		DiagnosticPageZoylo.ScheduleHomePickUpAddPackage("Surya diagnostic", "Full Body Test Examination", "30000", "2", "Surya Full Tes", "Full Body Test Examination");
		DiagnosticPageZoylo.ScheduleHomePickupEditPackage("Sunny Diagnosis", "Body Total scan", "40000", "2", "SunnyTest", "Toatal Body scan");
		
	}

	@AfterClass
	  public void CloaseBrowser() {
		driver.quit();
	  }
}

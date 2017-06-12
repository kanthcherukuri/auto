package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY1011_HomePickupEditTests extends LoadPropMac{
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	@BeforeClass
	  public void LaunchBrowser() throws Exception {
		LoadBrowserProperties();
		 driver.manage().window().maximize();
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 DiagnosticPageZoylo.SignIn(Diagnostic_username, Diagnostic_password);
		  }

	@Test
	public void ScheduleHomePickupEditTests() throws Exception{
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		Thread.sleep(2000);
		DiagnosticPageZoylo.clickonhomevisitmenu();
		DiagnosticPageZoylo.ScheduleHomePickUpAddTest("EcomnetsTest", "Full Company Testing", "30000", "2");
		Thread.sleep(2000);
		DiagnosticPageZoylo.ScheduleHomePickupToEditTests("Journal", "Full Lamination Testing", "40000", "2");
	}
	
	
	@AfterClass
	  public void CloseBrowser() {
		 driver.quit();
	  }
}

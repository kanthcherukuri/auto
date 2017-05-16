package diagnosticTestScripts;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY1011_HomePickupEditTests extends LoadPropMac{
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	@BeforeClass
	  public void beforeClass() throws Exception {
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
		int id=DiagnosticPageZoylo.ScheduleHomeVisitAddTest("Medwin Test Package", "full body tests", "10000", "2");
		Thread.sleep(2000);
		DiagnosticPageZoylo.ScheduleHomePickupToEditTests(id, "StarHospitalTestPackage", "Total Body Tests are Conducted", "10000", "2");
	}
	
	
	@AfterClass
	  public void CloseBrowser() {
		 driver.close();
	  }
}

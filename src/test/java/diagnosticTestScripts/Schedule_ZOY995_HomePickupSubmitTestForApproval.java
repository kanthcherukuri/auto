package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY995_HomePickupSubmitTestForApproval extends LoadPropMac{
	
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
	public void ScheduleHomePickupTestSubmitForApproval() throws Exception{
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		DiagnosticPageZoylo.clickonhomevisitmenu();
		DiagnosticPageZoylo.ScheduleHomePickUpAddTest("RajiniTest", "Person Has Robotic sense", "36000", "2");
		Thread.sleep(1000);
		DiagnosticPageZoylo.ScheduleHomePickupSubmitTestsForApproval();
	}

	
	@AfterClass
	  public void CloseBrowser() {
		driver.quit();
	  }
}

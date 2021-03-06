package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY1007_HomePickupAddPackage extends LoadPropMac{
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
		public void ScheduleHomePickUpAddPackage() throws Exception{
			DiagnosticPageZoylo.ClickOnScheduleMenu();
			DiagnosticPageZoylo.clickonhomevisitmenu();
			DiagnosticPageZoylo.ClickOnSchedulePackageHomePickUp();
			DiagnosticPageZoylo.ScheduleHomePickUpAddPackage("Srivalli", "Full Body Test For Blood", "10000", "2", "Srivallitest", "Full Body Test for blood");
			
			
			
		}

		@AfterClass
		  public void CloseBrowser() {
			 driver.quit();
		  }
}

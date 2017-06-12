package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY991_HomePickUpAddTests extends LoadPropMac{

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
	public void ScheduleHomeVisitAddTests() throws Exception{
		
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		Thread.sleep(2000);
		DiagnosticPageZoylo.clickonhomevisitmenu();
		DiagnosticPageZoylo.ScheduleHomePickUpAddTest("JosnaTest", "Full Body Test For Pancreas","26000", "2");
		
	    }
	
	@AfterClass
	  public void CloseBrowser() {
		 driver.quit();
	  }
}

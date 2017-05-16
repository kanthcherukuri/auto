package diagnosticTestScripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY1014_HomePickupEditPackage extends LoadPropMac {
	
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
		 DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		  }
	
	@Test
	public void ScheduleHomePickUpPackageEdit() throws Exception{
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		DiagnosticPageZoylo.clickonhomevisitmenu();
		DiagnosticPageZoylo.ClickOnSchedulePackageHomevisit();
		int editid=DiagnosticPageZoylo.ScheduleHomevisitAddPackage();
		System.out.println("EditIDValue is:"+editid);
		Thread.sleep(3000);
		DiagnosticPageZoylo.ScheduleHomePickupEditPackage(editid);
		Thread.sleep(2000);
		DiagnosticPageZoylo.diagnosticlogout();
	}

	@AfterClass
	  public void afterClass() {
		driver.close();
	  }
}

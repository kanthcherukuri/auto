package diagnosticTestScripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY1007_HomePickupAddPackage extends LoadPropMac{
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
		public void ScheduleHomePickUpAddPackage() throws Exception{
			DiagnosticPageZoylo.ClickOnScheduleMenu();
			Thread.sleep(2000);
			DiagnosticPageZoylo.clickonhomevisitmenu();
			Thread.sleep(1000);
			DiagnosticPageZoylo.ScheduleHomevisitAddPackage();
			
		}

		@AfterClass
		  public void afterClass() {
			 driver.close();
		  }
}
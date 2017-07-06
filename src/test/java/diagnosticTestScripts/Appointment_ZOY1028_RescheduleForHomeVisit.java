package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;


import org.testng.annotations.AfterMethod;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;


public class Appointment_ZOY1028_RescheduleForHomeVisit extends LoadPropMac{
	
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
  public void HomeVistReschedule() throws Exception {
		
		DiagnosticPageZoylo.DiagnosticAppointmentForHomeVisit("Roshan", "N", "9988661122", "roshan@gmail.com", "kakatiya residency", "Diabetic");
		DiagnosticPageZoylo.clickingonappointmentmodification();
		Thread.sleep(2000);
		DiagnosticPageZoylo.diagnosticrescheduleappointment();
		Browser.CheckNotificationMessage("Appointment rescheduled successfully");
		
		Thread.sleep(3000);
		
	}
	@AfterMethod
	public void bulkcancelandlogout() throws Exception{
		DiagnosticPageZoylo.ClickonAppointmentMenu();
		DiagnosticPageZoylo.ClickonToggleButtonForHomeVisit();
		DiagnosticPageZoylo.BulkCancellationForHomeVisit("07:00", "23:00");
		DiagnosticPageZoylo.diagnosticlogout();	
		}
	
	  @AfterClass
	  public void afterClass() {
	  
		  driver.quit();
		  
	  }
	  
}

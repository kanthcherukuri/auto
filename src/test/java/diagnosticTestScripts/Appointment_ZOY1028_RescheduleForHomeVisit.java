package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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
			DiagnosticPageZoylo=new DiagnosticPage(driver);
			Browser=new TestUtils(driver);
			DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
			
		  }
	
	
	@Test
  public void HomeVistReschedule() throws Exception {
		
		DiagnosticPageZoylo.DiagnosticAppointmentForHomeVisit("Ranjith", "N", "9988660022", "ranjith@gmail.com", "kakatiya residency", "Diabetic");
		Thread.sleep(3000);
		DiagnosticPageZoylo.clickingonappointmentmodification();
		DiagnosticPageZoylo.diagnosticrescheduleappointment();
		Thread.sleep(3000);
		
	}
	@AfterMethod
	public void bulkcancelandlogout() throws Exception{
		DiagnosticPageZoylo.ClickonAppointmentMenu();
		Thread.sleep(3000);
		DiagnosticPageZoylo.ClickonToggleButtonForHomeVisit();
		Thread.sleep(1000);
		DiagnosticPageZoylo.BulkCancellationForHomeVisit("07:00", "23:00");
		Thread.sleep(3000);
		DiagnosticPageZoylo.diagnosticlogout();	
		}
	
	  @AfterClass
	  public void afterClass() {
	  
		  driver.quit();
		  
	  }
	  
}

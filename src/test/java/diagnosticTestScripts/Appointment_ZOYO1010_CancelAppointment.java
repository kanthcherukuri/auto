package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOYO1010_CancelAppointment extends LoadPropMac {
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
			DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		  }
		
	
	
	@Test
	public void CancelAppointment() throws Exception{
		DiagnosticPageZoylo.DiagnosticAppointmentbookingForTomorrow("Mohan","M","9966009222","mohanm@gmail.com","Diabetic");
		DiagnosticPageZoylo.clickingonappointmentmodification();
		DiagnosticPageZoylo.CancelAppointmentOfHomeVisit();
		Browser.CheckNotificationMessage("Appointment has been Cancelled");
		Thread.sleep(2000);
		DiagnosticPageZoylo.diagnosticlogout();
		
	}

	@AfterClass
		public void closebrowser(){
		driver.quit();
	}
}

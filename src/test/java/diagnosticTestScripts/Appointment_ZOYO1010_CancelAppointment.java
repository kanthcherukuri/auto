package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOYO1010_CancelAppointment extends LoadPropMac {
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils exceldata;
	
	@BeforeClass
	  public void beforeClass() throws Exception {
		LoadBrowserProperties();
		 driver.manage().window().maximize();
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }
		
	  
	
	@Test(priority=1)
	  public void DiagnosticLogin() throws Exception {
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
			DiagnosticPageZoylo=new DiagnosticPage(driver);	
			DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
			
				}
	
	@Test(priority=2)
	public void CancelAppointment() throws Exception{
		DiagnosticPageZoylo.DiagnosticAppointmentbookingForTomorrow("Manohar","M","9966009022","manohar@gmail.com","Diabetic");
		Thread.sleep(1000);
		DiagnosticPageZoylo.clickingonappointmentmodification();
		Thread.sleep(3000);
		DiagnosticPageZoylo.CancelAppointmentOfHomeVisit();
		Thread.sleep(3000);
		DiagnosticPageZoylo.ClickingOnEllipse();
		Thread.sleep(1000);
		DiagnosticPageZoylo.diagnosticlogout();
		
	}

	@AfterClass
		public void closebrowser(){
		driver.close();
	}
}
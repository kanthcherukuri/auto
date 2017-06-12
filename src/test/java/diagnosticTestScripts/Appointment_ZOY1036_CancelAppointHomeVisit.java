package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY1036_CancelAppointHomeVisit extends LoadPropMac{
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils exceldata;
	
	
	@BeforeClass	 
	 public void beforeClass() throws Exception {	
		
	 LoadBrowserProperties();
	 driver.manage().window().maximize();
	 driver.get(doctors_Url);		 
	 DiagnosticPageZoylo=new DiagnosticPage(driver);	
		DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		
	  }
	
	
	@Test
	public void HomeVisitAppointmentCancel() throws Exception{
		DiagnosticPageZoylo.DiagnosticAppointmentForHomeVisit("Samsung","M","9922116622","samsung@gmail.com","Kakatiya Residency","Diabetic");
		Thread.sleep(3000);
		DiagnosticPageZoylo.clickingonappointmentmodification();
		Thread.sleep(5000);
		DiagnosticPageZoylo.CancelAppointmentOfHomeVisit();
		Thread.sleep(4000);
		DiagnosticPageZoylo.diagnosticlogout();
		
	}
	
	
	@AfterClass()
	public void closebrowser(){
		driver.quit();
	}
	
	

}

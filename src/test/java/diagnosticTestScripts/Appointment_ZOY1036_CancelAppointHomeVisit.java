package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;


import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY1036_CancelAppointHomeVisit extends LoadPropMac{
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	
	@BeforeClass	 
	 public void beforeClass() throws Exception {	
		
		LoadBrowserProperties();
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 Browser.openUrl(loginPage_Url);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		
	  }
	
	
	@Test
	public void HomeVisitAppointmentCancel() throws Exception{
		DiagnosticPageZoylo.DiagnosticAppointmentForHomeVisit("Samsung","M","9922116622","samsung@gmail.com","Kakatiya Residency","Diabetic");
		Thread.sleep(3000);
		DiagnosticPageZoylo.clickingonappointmentmodification();
		DiagnosticPageZoylo.CancelAppointmentOfHomeVisit();
		Browser.CheckNotificationMessage("Appointment has been Cancelled");
		DiagnosticPageZoylo.diagnosticlogout();
		
	}
	
	
	@AfterClass()
	public void closebrowser(){
		driver.quit();
	}
	
	

}

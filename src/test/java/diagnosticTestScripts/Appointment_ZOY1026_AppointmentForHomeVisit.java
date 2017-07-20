package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;


import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY1026_AppointmentForHomeVisit extends LoadPropMac{
	
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
	public void  diagnostichomevisit() throws Exception{
		
		DiagnosticPageZoylo.DiagnosticAppointmentForHomeVisit("Roja","S","9922222456","roja@gmail.com","Kakatiya Residency","Diabetic");
		Thread.sleep(3000);
		DiagnosticPageZoylo.BulkCancellationForHomeVisit("07:00", "23:00");
		DiagnosticPageZoylo.diagnosticlogout();	
		//
		}	
		
	@AfterClass
	public void closebrowser(){
		driver.quit();
		
	}
		
		
		

	
	

}

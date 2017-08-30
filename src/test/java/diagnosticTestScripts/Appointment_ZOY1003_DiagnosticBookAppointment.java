package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;


import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;



public class Appointment_ZOY1003_DiagnosticBookAppointment extends LoadPropMac{
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	
	@BeforeClass
	  public void beforeClass() throws Exception {
		LoadBrowserProperties();
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		  }

 
	@Test
	public void BookAppointment() throws Exception{
		
		DiagnosticPageZoylo.DiagnosticAppointmentbookingForTomorrow("Lenovo","L","9911662200","lenovo@gmail.com","Diabetic");
		Thread.sleep(4000);
		DiagnosticPageZoylo.DiagnosticAppointmentsBulkCancellation("06:00", "23:00");
		Thread.sleep(5000);
		DiagnosticPageZoylo.diagnosticlogout();
		}
	


	  @AfterClass
	  public void afterClass() {
		  
		  driver.quit();
	  }

  
}

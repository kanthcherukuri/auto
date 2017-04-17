package diagnosticTestScripts;

import org.testng.annotations.Test;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;

public class Appointment_ZOY1028_RescheduleForHomeVisit extends LoadPropMac{
	
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
	public void DiagnosticLogin() throws Exception{
		
		DiagnosticPageZoylo=new DiagnosticPage(driver);	
		DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		
		}
	
	@Test(priority=2)
  public void HomeVistReschedule() throws Exception {
		
		DiagnosticPageZoylo.DiagnosticAppointmentForHomeVisit();
		Thread.sleep(5000);
		DiagnosticPageZoylo.diagnosticrescheduleappointment();
		Thread.sleep(1000);
		DiagnosticPageZoylo.ClickingOnEllipse();
		DiagnosticPageZoylo.diagnosticlogout();
	}

  @AfterClass
  public void afterClass() {
  
	  driver.close();
  }
  
}

package diagnosticTestScripts;

import org.testng.annotations.Test;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;

public class Appointment_ZOY1003_DiagnosticBookAppointment extends LoadPropMac{
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
		Thread.sleep(2000);
			}
 
	@Test(priority=2)
	public void BookAppointment() throws Exception{
		
		DiagnosticPageZoylo.DiagnosticAppointmentbooking();
		Thread.sleep(1000);
		DiagnosticPageZoylo.ClickingOnEllipse();
		DiagnosticPageZoylo.diagnosticlogout();
		}
	
	@Test(priority=3)
	public void BulkCancellogout(){

	}

  @AfterClass
  public void afterClass() {
	  
	  driver.close();
  }

  
}

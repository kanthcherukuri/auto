package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY1043_BulkCancellationHomeVisit extends LoadPropMac{
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
	public void bulkcancellation() throws Exception{
		DiagnosticPageZoylo.DiagnosticAppointmentsBulkCancellation();
		Thread.sleep(1000);
		DiagnosticPageZoylo.ClickingOnEllipse();
		DiagnosticPageZoylo.diagnosticlogout();	
		
		}
		
	@AfterClass
	public void closebrowser(){
		driver.close();
	}
	}



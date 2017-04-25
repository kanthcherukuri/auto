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

public class Appointment_ZOY1009_RescheduleAppointment extends LoadPropMac{
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
	public void RescheduleAppointment() throws Exception{
		DiagnosticPageZoylo.DiagnosticAppointmentbookingForTomorrow("Chandrasekha","P","9966770000","chandra@gmail.com","Diabetic");
		Thread.sleep(2000);
		DiagnosticPageZoylo.DiagnosticAppointmentReschedule();
		Thread.sleep(2000);
		DiagnosticPageZoylo.PatientSerachInAllTabForReschedule("Chandrasekha","P","chandra@gmail.com");
		Thread.sleep(2000);
		DiagnosticPageZoylo.DiagnosticAppointmentsBulkCancellation();
		Thread.sleep(1000);
		DiagnosticPageZoylo.ClickingOnEllipse();
		Thread.sleep(2000);
		DiagnosticPageZoylo.diagnosticlogout();	
		}
	
	@AfterClass
	public void closebrowser(){
		driver.close();
	}

}
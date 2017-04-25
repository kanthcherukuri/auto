package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY1026_AppointmentForHomeVisit extends LoadPropMac{
	
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
	public void  diagnostichomevisit() throws Exception{
		
		DiagnosticPageZoylo.DiagnosticAppointmentForHomeVisit("Sundeep","s","9922663456","sundeep@gmail.com","Kakatiya Residency","Diabetic");
		Thread.sleep(3000);
		DiagnosticPageZoylo.BulkCancellationForHomeVisit();
		Thread.sleep(3000);
		DiagnosticPageZoylo.ClickingOnEllipse();
		Thread.sleep(2000);
		DiagnosticPageZoylo.diagnosticlogout();	
		}	
		
	@AfterClass
	public void closebrowser(){
		driver.close();
	}
		
		
		

	
	

}
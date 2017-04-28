package diagnosticTestScripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY971_DiagnosticSendNotifiactionInAllTab extends LoadPropMac {
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils exceldata;
	
		@BeforeClass
		public void beforeClass() throws Exception {
		LoadBrowserProperties();
		driver.manage().window().maximize();
		driver.get(doctors_Url);		 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		DiagnosticPageZoylo=new DiagnosticPage(driver);	
		DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		  }
		
		
		@Test
		public void CheckSendNotificationInAllTab() throws Exception{
			DiagnosticPageZoylo.DiagnosticAppointmentbookingForTomorrow("Civic", "M","9900222233", "civic@gmail.com", "Diabetic");
			Thread.sleep(8000);
			DiagnosticPageZoylo.CheckSendNofiticationFunctionalityInAllTab("civic@gmail.com");
			Thread.sleep(3000);
		}
		
		@AfterMethod	
		public void DiagnosticBulkCancellation() throws Exception{
			DiagnosticPageZoylo.DiagnosticAppointmentsBulkCancellation();
			Thread.sleep(3000);
			DiagnosticPageZoylo.ClickingOnEllipse();
			DiagnosticPageZoylo.diagnosticlogout();
		}
		
		@AfterClass
		public void browserclose(){
			driver.close();
		}
}
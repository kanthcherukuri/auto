package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY971_RescheduleSendNotifiactionInAllTab extends LoadPropMac {
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils exceldata;
	
		@BeforeClass
		public void LaunchBrowser() throws Exception {
		LoadBrowserProperties();
		driver.manage().window().maximize();
		driver.get(doctors_Url);	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		DiagnosticPageZoylo=new DiagnosticPage(driver);	
		DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		  }
		
		
		@Test
		public void CheckSendNotificationInAllTab() throws Exception{
			DiagnosticPageZoylo.DiagnosticAppointmentbookingForTomorrow("Freez", "M","9902222233", "freez@gmail.com", "Diabetic");
			Thread.sleep(8000);
			DiagnosticPageZoylo.CheckSendNofiticationFunctionalityInAllTab("freez@gmail.com");
			Thread.sleep(3000);
		}
		
		@AfterMethod	
		public void DiagnosticBulkCancellation() throws Exception{
			DiagnosticPageZoylo.DiagnosticAppointmentsBulkCancellation("07:00", "23:00");
			Thread.sleep(3000);
			DiagnosticPageZoylo.diagnosticlogout();
		}
		
		@AfterClass
		public void browserclose(){
			driver.quit();
		}
}

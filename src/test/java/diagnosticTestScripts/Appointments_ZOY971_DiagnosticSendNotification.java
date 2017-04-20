package diagnosticTestScripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointments_ZOY971_DiagnosticSendNotification extends LoadPropMac{
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
			
			DiagnosticPageZoylo=new DiagnosticPage(driver);	
			DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
			
				}
	@Test(priority=2,enabled=false)
	public void CheckSendNotificationInTodayTab() throws Exception{
		DiagnosticPageZoylo.DiagnosticAppointmentForToday("sony", "p","9900882212","sony@gmail.com", "Diabetic");
		Thread.sleep(5000);
		DiagnosticPageZoylo.CheckSendNofiticationFunctionality();
		Thread.sleep(2000);
		
	    }
	
	@Test(priority=3,enabled=false)
	public void CheckSendNotificationInAllTab() throws Exception{
		DiagnosticPageZoylo.DiagnosticAppointmentbookingForTomorrow("Priya", "s","9900118822", "priya@gmail.com", "Diabetic");
		Thread.sleep(8000);
		DiagnosticPageZoylo.CheckSendNofiticationFunctionalityInAllTab("priya@gmail.com");
		Thread.sleep(3000);
	}
	
	@Test(priority=4)	
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



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
		DiagnosticPageZoylo.DiagnosticAppointmentForToday("Sai", "kanth", "9900882212","sai@gmail.com", "Diabetic");
		Thread.sleep(5000);
		DiagnosticPageZoylo.CheckSendNofiticationFunctionality();
		Thread.sleep(2000);
		
	    }
	
	@Test(priority=3)
	public void CheckSendNotificationInAllTab() throws Exception{
		DiagnosticPageZoylo.DiagnosticAppointmentbookingForTomorrow("StautMark", "W","9900118822", "Stautmark@gmail.com", "Diabetic");
		Thread.sleep(8000);
		DiagnosticPageZoylo.CheckSendNofiticationFunctionalityInAllTab("Stautmark@gmail.com");
	}
	
	@Test(priority=4,enabled=false)	
	public void DiagnosticBulkCancellation() throws Exception{
		
		DiagnosticPageZoylo.DiagnosticAppointmentsBulkCancellation();
		DiagnosticPageZoylo.diagnosticlogout();
		
	}
		
	@AfterClass
	public void browserclose(){
		//driver.close();
	}
		
	}



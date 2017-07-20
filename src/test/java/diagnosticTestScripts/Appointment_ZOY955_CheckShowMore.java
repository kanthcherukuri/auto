package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;


import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY955_CheckShowMore extends LoadPropMac {
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	
	@BeforeClass
	  public void beforeClass() throws Exception {
		LoadBrowserProperties();
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 Browser.openUrl(loginPage_Url);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);

	  }
	
	
	@Test
	public void showmorebutton() throws Exception{
		
		DiagnosticPageZoylo.AppointCreationForShowMore("Nagesh","G","9922223355","nagesh@gmail.com","Diabetic");
		DiagnosticPageZoylo.ClickOnDashboardMenu();
		Thread.sleep(3000);	
		DiagnosticPageZoylo.CheckingShowMoreOnDashboard();	
		Thread.sleep(3000);
		DiagnosticPageZoylo.DiagnosticAppointmentsBulkCancellation("07:00", "23:00");
		DiagnosticPageZoylo.diagnosticlogout();
	  }


	@AfterClass
	public void closebrowser(){
		driver.quit();
	}
}

package diagnosticTestScripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointments_ZOY955_CheckShowMore extends LoadPropMac {
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
	public void showmorebutton() throws Exception{
		
		DiagnosticPageZoylo.AppointCreationForShowMore("sindhu","G","9911223355","sindhu@gmail.com","Diabetic");
		Thread.sleep(2000);
		DiagnosticPageZoylo.ClickOnDashboardMenu();
		Thread.sleep(3000);	
		DiagnosticPageZoylo.CheckingShowMoreOnDashboard();
			
	  }
	@Test(priority=3)
	public void bulkcancelandlogout() throws Exception{
		
		DiagnosticPageZoylo.DiagnosticAppointmentsBulkCancellation();
		Thread.sleep(3000);
		DiagnosticPageZoylo.ClickingOnEllipse();
		Thread.sleep(1000);
		DiagnosticPageZoylo.diagnosticlogout();
		
	}

	@AfterClass
	public void closebrowser(){
		driver.close();
	}
}

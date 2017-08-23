package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;


import org.testng.annotations.AfterMethod;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY1009_RescheduleAppointment extends LoadPropMac{
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	@BeforeClass
	  public void beforeClass() throws Exception {
		LoadBrowserProperties();
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		  }
		
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "TEEZABee","S","9922222466","teezatwo@gmail.com","Diabetic" }
	
			};
		}

	
	@Test(dataProvider="DP1")
	public void RescheduleAppointment(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		DiagnosticPageZoylo.DiagnosticAppointmentbookingForTomorrow(firstname, lastname, mobile, email, problem);
		Thread.sleep(2000);
		DiagnosticPageZoylo.clickingonappointmentmodification();
		DiagnosticPageZoylo.DiagnosticAppointmentReschedule();
		Thread.sleep(3000);
		DiagnosticPageZoylo.PatientSerachInAllTabForReschedule(firstname, lastname, email);
		Thread.sleep(2000);
	}
	
	@AfterMethod()
	public void bulkcancelandlogout() throws Exception{
		DiagnosticPageZoylo.DiagnosticAppointmentsBulkCancellation("07:00", "23:00");
		DiagnosticPageZoylo.diagnosticlogout();
		}
	
	
	@AfterClass
	public void closebrowser(){
		driver.quit();
	}

}

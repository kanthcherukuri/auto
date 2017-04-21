package diagnosticTestScripts;

import org.testng.annotations.Test;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;

public class Appointment_ZOY975_CheckIn extends LoadPropMac {
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
	
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Donepudi","k","9966775511","donepudi@gmail.com","Diabetic" }

			};
		}
	
	
	@Test(dataProvider="DP1",priority=2)
	public void VerifyCheckInCheckOut(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
	
		DiagnosticPageZoylo.DiagnosticAppointmentForToday(firstname, lastname, mobile, email, problem);
		Thread.sleep(6000);
		DiagnosticPageZoylo.VerifyCheckInCheckoutforAllTab(firstname, lastname, email);
		Thread.sleep(3000);
	}
	@Test(priority=3)
	public void DiagnosticBulkCancelAndLogout() throws Exception{
		
		DiagnosticPageZoylo.DiagnosticAppointmentsBulkCancellation();
		Thread.sleep(3000);
		DiagnosticPageZoylo.ClickingOnEllipse();
		DiagnosticPageZoylo.diagnosticlogout();
		
	}
	
	  @AfterClass
	  public void afterClass() {
		driver.close();
	  }
	
	}

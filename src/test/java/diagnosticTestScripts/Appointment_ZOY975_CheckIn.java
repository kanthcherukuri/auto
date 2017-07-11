package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;
import org.testng.annotations.DataProvider;


public class Appointment_ZOY975_CheckIn extends LoadPropMac {
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
		
		
	
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Deevayani","V","9963990000","deevayani@gmail.com","Diabetic" }

			};
		}
	
	
	@Test(dataProvider="DP1")
	public void VerifyCheckInCheckOut(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		DiagnosticPageZoylo.DiagnosticAppointmentForToday(firstname, lastname, mobile, email, problem);
		DiagnosticPageZoylo.VerifyCheckInCheckoutforAllTab(firstname, lastname, email);
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void DiagnosticBulkCancelAndLogout() throws Exception{
		DiagnosticPageZoylo.DiagnosticAppointmentsBulkCancellation("07:00", "23:00");
		DiagnosticPageZoylo.diagnosticlogout();
	}
	
	  @AfterClass
	  public void afterClass() {
		driver.quit();
	  }
	
	}

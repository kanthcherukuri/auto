package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY971_DiagnosticSendNotification extends LoadPropMac{
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
		@BeforeClass
		public void LaunchBrowser() throws Exception {
			LoadBrowserProperties();
			 DiagnosticPageZoylo=new DiagnosticPage(driver);
			 Browser=new TestUtils(driver);
			 Browser.openUrl(loginPage_Url);
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		  }
		
		@DataProvider(name = "DP1")
		 public String[][] createData1() {
				return new String[][] {
						{ "yes","Srinu","Raavi","9992255522","srinu@gmail.com","Diabetic" }

				};
			}
	
	
	@Test(dataProvider="DP1")
	public void CheckSendNotificationInTodayTab(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		DiagnosticPageZoylo.DiagnosticAppointmentForToday(firstname, lastname, mobile, email, problem);
		DiagnosticPageZoylo.CheckSendNofiticationFunctionality(firstname, lastname, email);
		
		
	    }
	
	
	@AfterMethod	
	public void DiagnosticBulkCancellation() throws Exception{
		DiagnosticPageZoylo.DiagnosticAppointmentsBulkCancellation("07:00", "23:00");
		DiagnosticPageZoylo.diagnosticlogout();
		
	}
		
	@AfterClass
	public void browserclose(){
		driver.quit();
	}
		
	}



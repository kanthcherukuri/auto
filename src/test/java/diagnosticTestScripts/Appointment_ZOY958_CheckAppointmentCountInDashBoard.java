package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY958_CheckAppointmentCountInDashBoard extends LoadPropMac{
    
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	@BeforeClass
	  public void LaunchBrowser() throws Exception {
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
					{ "yes","Nandini","J","9900222411","nandini@gmail.com","Diabetic" }

			};
		}

	 
	 @Test(dataProvider="DP1", groups = { "Regression","High" })
	 public void TodayAppointmentCountInDashBoard(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		 DiagnosticPageZoylo.DiagnosticAppointmentForToday(firstname, lastname, mobile, email, problem);
		 DiagnosticPageZoylo.CheckTodayAppointmentCountInDashBoardScreen();
	 }
	
	 @AfterMethod
	 public void BulkCancelandlogout() throws Exception{
		 DiagnosticPageZoylo.DiagnosticAppointmentsBulkCancellation("07:00", "23:00");
			DiagnosticPageZoylo.diagnosticlogout();
	 }
	 
	 @AfterClass
	 public void CloseBrowser(){
		 driver.quit();
	 }
}


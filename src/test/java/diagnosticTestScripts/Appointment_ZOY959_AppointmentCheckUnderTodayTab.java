package diagnosticTestScripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY959_AppointmentCheckUnderTodayTab extends LoadPropMac{
	
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
					{ "yes","Kiran","T","9966775500","kiran@gmail.com","Diabetic" }

			};
		}
	
	@Test(dataProvider="DP1",priority=2 )
	public void appointment(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		
		DiagnosticPageZoylo.DiagnosticAppointment(firstname, lastname, mobile, email, problem);
		Thread.sleep(3000);
		DiagnosticPageZoylo.patientserachforintoday(firstname, lastname, email);
		}

}

package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY961_CheckUnderAllTab extends LoadPropMac{
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils exceldata;
	
	@BeforeClass
	  public void beforeClass() throws Exception {
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
					{ "yes","Meera","K","9966655500","meera@gmail.com","Diabetic" }

			};
		}
	
	
	@Test(dataProvider="DP1")
	public void AppointmentCheckingUnderAllTab(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		DiagnosticPageZoylo.DiagnosticAppointmentbookingForTomorrow(firstname, lastname, mobile, email, problem);
		Thread.sleep(2000);
		DiagnosticPageZoylo.patientsearchinalltab(firstname, lastname, email);
	}
	
   @AfterMethod
   public void bulkcancelandlogout() throws Exception{
	   DiagnosticPageZoylo.DiagnosticAppointmentsBulkCancellation("07:00", "23:00");
		Thread.sleep(3000);
		DiagnosticPageZoylo.diagnosticlogout();
	   
   }
	
   @AfterClass
   public void closebrowser(){
	   driver.close();
   }
}

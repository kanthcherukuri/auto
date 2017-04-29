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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY956_SearchInPatientScreen extends LoadPropMac {
	
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
					{ "yes","Sruthione","J","9900001222","sruthione@gmail.com","Diabetic" }

			};
		}
 
	 
	 @Test(dataProvider="DP1", groups = { "Regression","High" })
	 public void patientsearch(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		 if(RunMode.equals("yes")){
			 
			 DiagnosticPageZoylo.DiagnosticAppointmentForToday(firstname, lastname, mobile, email, problem);
			 Thread.sleep(3000);
			 DiagnosticPageZoylo.CheckPatientSearchfunctionalityInTodaytab(firstname, lastname, mobile, email);
			 Thread.sleep(2000);
			 }else{
				 throw new SkipException("RUNMODE IS OFF"); 
			 }	
	 			}

	    @AfterMethod
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


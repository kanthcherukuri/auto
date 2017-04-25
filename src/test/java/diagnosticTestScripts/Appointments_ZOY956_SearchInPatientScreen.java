package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import objectRepository.Elements_Diagnostics;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointments_ZOY956_SearchInPatientScreen extends LoadPropMac {
	
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
					{ "yes","srilekha","J","9966001555","srilekha@gmail.com","Diabetic" }

			};
		}
 
	 
	 @Test(dataProvider="DP1", priority=2,groups = { "Regression","High" })
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

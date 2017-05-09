package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testBase.DoctorsPage;
import testBase.LoadProp;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY819_FollowUP extends LoadPropMac {

	public DoctorsPage DoctorsPageOfZoylo;
	 public TestUtils exceldata;
	
	
	 @BeforeClass
	  public void beforeClass() throws Exception { 
		  LoadBrowserProperties();
		  driver.get(doctors_Url);		 
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  DoctorsPageOfZoylo= new DoctorsPage(driver);			
		  DoctorsPageOfZoylo.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
			  }
		       
	  
	  @DataProvider(name = "DP1")
		 public String[][] createData1() {
				return new String[][] {
						{ "yes","Sunkara","R","9933333322","sunkara@gmail.com","Diabetic" }

				};
			}
	  
	 
	  
	  @Test(dataProvider="DP1")
	  public void CheckingFollowupFunctionality(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		  
		  DoctorsPageOfZoylo.DoctorAppointmentBookingForToday(firstname, lastname, mobile, email, problem);
		  Thread.sleep(2000);
		  DoctorsPageOfZoylo.CheckPateintScreenForCheckInFunctionality(firstname, lastname, email);
		  Thread.sleep(1000);
		  DoctorsPageOfZoylo.VerifyCheckINFunctionality();
		  Thread.sleep(2000);
		  DoctorsPageOfZoylo.CheckingFollowUpFunctionality(firstname, lastname);
		  Thread.sleep(2000);
	  		}
	  
		  @AfterMethod
		  public void bulkcancelandlogout() throws Exception{
			  DoctorsPageOfZoylo.BulkCancel();
			  Thread.sleep(2000);
			  DoctorsPageOfZoylo.doctorlogout();
		  }
		  
		@AfterClass
		public void closebrowser(){
			driver.close();
		}
			  
		  
		  
						
		  
		  
	  }
	  
	  
	  
	  
	  
	  
	

			 
	  
	  





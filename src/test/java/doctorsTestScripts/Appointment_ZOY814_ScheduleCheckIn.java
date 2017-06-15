package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY814_ScheduleCheckIn extends LoadPropMac  {
	
	public DoctorsPage DoctorsPage;
	 
	 public TestUtils exceldata;
	
	
 
  @BeforeClass
  public void LaunchBrowser() throws Exception {
	  	
	  	LoadBrowserProperties();
	  	driver.get(doctors_Url);		 
	  	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  	DoctorsPage= new DoctorsPage(driver);			
		DoctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);	
		  }
	  
  
  @DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Murari","A","9966395522","murari@gmail.com","Diabetic" }

			};
		}
  
  
  @Test(dataProvider="DP1",priority=2)
  public void CheckingCheckInFunctionality(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
	  	
	  					
		DoctorsPage.DoctorAppointmentBookingForToday(firstname, lastname, mobile, email, problem);
		Thread.sleep(2000);
		DoctorsPage.CheckPateintScreenForCheckInFunctionality(firstname, lastname, email);
		Thread.sleep(3000);
		DoctorsPage.VerifyCheckINFunctionality();		
		Thread.sleep(2000);				
			
	 }
  
	  @AfterMethod
	  public void bulkcancelandlogout() throws Exception{
		  DoctorsPage.BulkCancel();
		  Thread.sleep(2000);
		  DoctorsPage.doctorlogout();
	  }
	  
	  @AfterClass
	  public void closebrowser(){
		  driver.quit();
	  }
	
	  
  
  
  
  
  

}
	 


package doctorsTestScripts;

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
	 
	 public TestUtils Browser;
	
	
 
  @BeforeClass
  public void LaunchBrowser() throws Exception {
	  	LoadBrowserProperties();	 
		 DoctorsPage= new DoctorsPage(driver);	
		 Browser= new TestUtils(driver);
		 Browser.openUrl(loginPage_Url);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DoctorsPage.SignIn( DoctorsLogin_usernameone, DoctorsLogin_passwordone);
		  }
	 
  @DataProvider(name = "CheckIn")
  public Object[][] createData_DP1() throws Exception{
      Object[][] retObjArr=TestUtils.getTableArray("TestData/DoctorProvider.xls","Doctor", "ZOY814");
      return(retObjArr);
  }
  
  
  @Test(dataProvider="CheckIn")
  public void CheckingCheckInFunctionality(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
	  	
	  					
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
		  DoctorsPage.doctorlogout();
	  }
	  
	  @AfterClass
	  public void closebrowser(){
		  driver.quit();
	  }
	
	  
  
  
  
  
  

}
	 


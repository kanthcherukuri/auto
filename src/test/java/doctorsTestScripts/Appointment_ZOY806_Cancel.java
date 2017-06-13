package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.SkipException;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY806_Cancel extends LoadPropMac  {

	public DoctorsPage DoctorsPage;
	 public TestUtils exceldata;
	

	 @BeforeClass(groups = { "Regression","High" })	
	 public void LaunchBrowser() throws Exception {
		 LoadBrowserProperties();
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DoctorsPage= new DoctorsPage(driver);			
		 DoctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);	
		  }
	 
	 @DataProvider(name = "DP1")
	   // public Object[][] createData_DP1() throws Exception{
	  //Object[][] retObjArr=TestUtils.getTableArray("TestData\\DoctorAppointment1.xls", "doc", "TC1");
	    //    return(retObjArr);
	    //}
	 
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","kony","K","9499929191","kony@gmail.com","Diabetic" }

			};
		}



@Test(dataProvider="DP1",groups = { "Regression","High" })

public void doctorappointment(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{

	if(RunMode.equals("yes")){
		
		DoctorsPage.DoctorsAppointmentforTomorrow(firstname, lastname, mobile, email, problem);
		Thread.sleep(3000);
		DoctorsPage.Cancel(firstname, lastname, mobile, email, problem);
		Thread.sleep(3000);
		DoctorsPage.CheckCancelAppointmentInPatientScreen(firstname, lastname, email);
	}
	 else{
		 
			throw new SkipException("RUNMODE IS OFF");
		 }
	
		}


		@AfterMethod
		public void CancelAllAppointments() throws Exception{
			DoctorsPage.BulkCancel();
			Thread.sleep(2000);
			DoctorsPage.doctorlogout();	
		}


		@AfterClass
		public void closebrowser(){
			driver.quit();
		}



}

package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testBase.DoctorsPage;
import testBase.LoadProp;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY801_Reschedule extends LoadPropMac{
	
	public DoctorsPage DoctorsPageOfZoylo;
	 
	 public TestUtils exceldata;
	

	 @BeforeClass(groups = { "Regression","High" })	
	 
	 public void beforeClass() throws Exception {
		 
		// 1.The tomorrow menu Evening tab appointment timings should be available
		 //2. Next to the tomorrow menu->Morning tab appointment timings should be available
		// 3.Make sure no appointment is created in any of the cell before executing the script
		// 4.Execute with new Test Data every time with unique email-id

	
		 LoadBrowserProperties();
		 driver.manage().window().maximize();
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		  }
	 
	 @Test(groups = { "Regression","High" })	
	 public  void SignIntoDoctorLogin() throws Exception {
	
		 DoctorsPageOfZoylo= new DoctorsPage(driver);			
		DoctorsPageOfZoylo.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
				
		  }
	 
	 
	 @DataProvider(name = "DP1")
	   // public Object[][] createData_DP1() throws Exception{
	  //Object[][] retObjArr=TestUtils.getTableArray("TestData\\Doctors_TestData.xls", "Doctor", "ZOY801");
	    //    return(retObjArr);
	    //}
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Suzki","Samuri","9291219191","suzki@gmail.com","Diabetic" }

			};
		}

	 
	 
	
	 @Test(dataProvider="DP1", priority=2,groups = { "Regression","High" })
	public void AppointmentReschedule(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		 
		 if(RunMode.equals("yes")){
			 DoctorsPageOfZoylo.DoctorsAppointmentforTomorrow(firstname, lastname, mobile, email, problem);
			 Thread.sleep(2000);
			 DoctorsPageOfZoylo.reschedule(firstname, lastname, mobile, email, problem); 
			 Thread.sleep(3000);
			 DoctorsPageOfZoylo.CheckPatientScreenForReschedule(firstname, lastname, email);
			 
		 }
		 else{
			 
				throw new SkipException("RUNMODE IS OFF");
				
			 }
		 
		 
	 }
			
		@Test(priority=3)
		public void CancelAllAppointments() throws Exception{
			DoctorsPageOfZoylo.BulkCancel();
			Thread.sleep(2000);
			DoctorsPageOfZoylo.doctorlogout();
			
		}
			
			@AfterClass
			public void closebrowser(){
				driver.close();
			}
			
			
	}
		
		
		
		


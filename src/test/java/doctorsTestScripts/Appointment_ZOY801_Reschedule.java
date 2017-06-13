package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY801_Reschedule extends LoadPropMac{
	
	public DoctorsPage DoctorsPage;
	 
	 public TestUtils Browser;
	

	 @BeforeClass(groups = { "Regression","High" })	
	 public void LaunchBrowser() throws Exception {
		 LoadBrowserProperties();
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DoctorsPage= new DoctorsPage(driver);
		 Browser= new TestUtils(driver); 
		 DoctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
		  }
	 
	 
	 @DataProvider(name = "DP1")
	    public Object[][] createData_DP1() throws Exception{
	  Object[][] retObjArr=TestUtils.getTableArray("TestData/Data.xls","Kanth","ZOY801");
	        return(retObjArr);
	    }
	 
//	 public String[][] createData1() {
//			return new String[][] {
//					{ "yes","Suzki","Samuri","9291219191","suzki@gmail.com","Diabetic" }
//
//			};
//		}

	 
	
	 @Test(dataProvider="DP1",groups = { "Regression","High" })
	public void AppointmentReschedule(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		 
		 if(RunMode.equalsIgnoreCase("yes")){ 
			 DoctorsPage.DoctorsAppointmentforTomorrow(firstname, lastname, mobile, email, problem);
			 Thread.sleep(2000);
			 DoctorsPage.reschedule(firstname, lastname, mobile, email, problem); 
			 Thread.sleep(3000);
			 DoctorsPage.CheckPatientScreenForReschedule(firstname, lastname, email); 
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
		
		
		
		


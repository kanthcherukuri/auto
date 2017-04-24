package doctorsTestScripts;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY799_SearchFunctionalityInPatientScreen extends LoadPropMac{
	public DoctorsPage DoctorsPageOfZoylo;
	public TestUtils exceldata;
	
	
	@BeforeClass
	public void beforeClass() throws Exception {
		  
		  
		  LoadBrowserProperties();
			 driver.manage().window().maximize();
			 driver.get(doctors_Url);		 
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 //thread.
		
			  }
		  
			     
	@Test(priority=1)
		public  void SignIntoDoctorLogin() throws Exception {
				
		 DoctorsPageOfZoylo= new DoctorsPage(driver);			
		DoctorsPageOfZoylo.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
						
				  }
	
	
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Govinda","k","9966395522","govinda@gmail.com","Diabetic" }

			};
		}
	
	@Test(dataProvider="DP1",priority=2)
	public void CheckSearchFunctionality(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		
		DoctorsPageOfZoylo.DoctorsAppointmentforTomorrow(firstname, lastname, mobile, email, problem);
		Thread.sleep(3000);
		DoctorsPageOfZoylo.CheckPatientScreenSearchFunctionality(firstname, lastname, mobile, email);
		Thread.sleep(3000);
	}
  
	@Test(priority=3)
	public void AppointmentBulkCancelandLogout() throws Exception{
		DoctorsPageOfZoylo.BulkCancel();
		Thread.sleep(2000);
		DoctorsPageOfZoylo.doctorlogout();
	}
	@AfterClass
	public void closebrowser(){
		driver.close();
	}
}

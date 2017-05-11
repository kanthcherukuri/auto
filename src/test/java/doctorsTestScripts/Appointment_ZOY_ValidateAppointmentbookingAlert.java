package doctorsTestScripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY_ValidateAppointmentbookingAlert extends LoadPropMac {
	
	public DoctorsPage DoctorsPageOfZoylo;
	public TestUtils exceldata;
	
	@BeforeClass
	public void beforeClass() throws Exception {
	LoadBrowserProperties();
	 driver.manage().window().maximize();
	 driver.get(doctors_Url);		 
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 DoctorsPageOfZoylo= new DoctorsPage(driver);			
	 DoctorsPageOfZoylo.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
	  } 
	
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Srinu","S","9959559926","srinu@gmail.com","Diabetic" }
	
			};
		}

	@Test(dataProvider="DP1")
	public void CheckAlertforAppointmentBooking(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		
		DoctorsPageOfZoylo.DoctorsAppointmentforTomorrow(firstname, lastname, mobile, email, problem);
		DoctorsPageOfZoylo.ClickView();
		DoctorsPageOfZoylo.CheckAlerts();
	}
	
	@AfterMethod
	public void bulkCancelandlogout() throws Exception{
		DoctorsPageOfZoylo.BulkCancel();
		Thread.sleep(3000);
		DoctorsPageOfZoylo.doctorlogout();
	}
	
	
	@AfterClass
	public void closebrowser(){
		driver.close();
	}
}

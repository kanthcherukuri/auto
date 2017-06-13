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

public class Appointment_ZOY799_SearchFunctionalityInPatientScreen extends LoadPropMac{
	public DoctorsPage DoctorsPage;
	public TestUtils Browser;
	
	
	@BeforeClass
	public void LaunchBrowser() throws Exception {  
		  	LoadBrowserProperties();
		  	driver.get(doctors_Url);		 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			DoctorsPage= new DoctorsPage(driver);
			Browser=new TestUtils(driver);
			DoctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
		
			  }		     
	
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Apache","L","9966885522","apache@gmail.com","Diabetic" }

			};
		}
	
	@Test(dataProvider="DP1")
	public void CheckSearchFunctionality(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		DoctorsPage.DoctorsAppointmentforTomorrow(firstname, lastname, mobile, email, problem);
		Thread.sleep(3000);
		DoctorsPage.CheckPatientScreenSearchFunctionality(firstname, lastname, mobile, email);
		Thread.sleep(3000);
	}
  
	@AfterMethod
	public void AppointmentBulkCancelandLogout() throws Exception{
		DoctorsPage.BulkCancel();
		Thread.sleep(2000);
		DoctorsPage.doctorlogout();
	}
	@AfterClass
	public void closebrowser(){
		driver.quit();
	}
}

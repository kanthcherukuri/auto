package doctorsTestScripts;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY773_AppointmentListing extends LoadPropMac {
	
	
	public DoctorsPage DoctorsPageOfZoylo;
	 
	 public TestUtils exceldata;
	 
@BeforeClass	 
 public void beforeClass() throws Exception {	
	
 LoadBrowserProperties();
 driver.manage().window().maximize();
 driver.get(doctors_Url);		 
 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
	
	
     
 @Test
public  void SignIntoDoctorLogin() throws Exception {	
	 
DoctorsPageOfZoylo= new DoctorsPage(driver);			
DoctorsPageOfZoylo.SignIn( DoctorsLogin_usernameone, DoctorsLogin_passwordone);
		
  }
  
 @DataProvider(name = "DP1")
 public String[][] createData1() {
		return new String[][] {
				{ "yes","Gopinath","K","9966995522","gopinath@gmail.com","Diabetic" }

		};
	}
 
  
@Test(dataProvider="DP1",priority=2)
public void appListing(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
	
	//DoctorsPageOfZoylo.DoctorAppointmentListing();	
	
	DoctorsPageOfZoylo.DoctorAppointmentBookingForToday(firstname, lastname, mobile, email, problem);
	Thread.sleep(3000);
    DoctorsPageOfZoylo.ClickingOnEllipse();
    Thread.sleep(2000);
    DoctorsPageOfZoylo.ClickingOnDashboard();
    Thread.sleep(3000);
    //DoctorsPageOfZoylo.expliciteWait("//*[@id='sp-dashboard-content']/div[1]/div[2]",100);
    DoctorsPageOfZoylo.dashboardAppointmentListing(firstname, lastname);;
	
}
	
	@Test(priority=3)
	public void bulkCancelandlogout() throws Exception{
		DoctorsPageOfZoylo.BulkCancel();
		Thread.sleep(3000);
		DoctorsPageOfZoylo.doctorlogout();
	}
	
	@AfterClass
	public void closebrowser(){
		driver.close();
	}

}//main Class

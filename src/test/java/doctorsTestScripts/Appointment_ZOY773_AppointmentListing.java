package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY773_AppointmentListing extends LoadPropMac {
	
	
	public DoctorsPage DoctorsPageOfZoylo;
	 
	 public TestUtils exceldata;
	 
	@BeforeClass	 
	 public void beforeClass() throws Exception {		
	 LoadBrowserProperties();
	  }
	
	 @DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Janu","K","9966995533","janu@gmail.com","Diabetic" }
	
			};
		}
 
  
@Test(dataProvider="DP1",priority=1)
public void appListing(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
	
		//DoctorsPageOfZoylo.DoctorAppointmentListing();	
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DoctorsPageOfZoylo= new DoctorsPage(driver);			
		 DoctorsPageOfZoylo.SignIn( DoctorsLogin_usernameone, DoctorsLogin_passwordone);
		 DoctorsPageOfZoylo.DoctorAppointmentBookingForToday(firstname, lastname, mobile, email, problem);
		 Thread.sleep(3000);
		 //DoctorsPageOfZoylo.ClickingOnEllipse();
		 //Thread.sleep(2000);
		 DoctorsPageOfZoylo.ClickingOnDashboard();
		 Thread.sleep(3000);
	    //DoctorsPageOfZoylo.expliciteWait("//*[@id='sp-dashboard-content']/div[1]/div[2]",100);
		 DoctorsPageOfZoylo.dashboardAppointmentListing(firstname, lastname);
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

}//main Class

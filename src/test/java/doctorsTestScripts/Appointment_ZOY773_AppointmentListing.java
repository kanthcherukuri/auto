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
	
	
	public DoctorsPage DoctorsPage;
	 
	 public TestUtils exceldata;
	 
	@BeforeClass	 
	 public void beforeClass() throws Exception {		
	 LoadBrowserProperties();
	 driver.get(doctors_Url);		 
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 DoctorsPage= new DoctorsPage(driver);			
	 DoctorsPage.SignIn( DoctorsLogin_usernameone, DoctorsLogin_passwordone);
	  }
	
	 @DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Janu","K","9966995533","janu@gmail.com","Diabetic" }
	
			};
		}
 
  
@Test(dataProvider="DP1",priority=1)
public void appListing(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
	
		//DoctorsPage.DoctorAppointmentListing();	
		 
		 DoctorsPage.DoctorAppointmentBookingForToday(firstname, lastname, mobile, email, problem);
		 Thread.sleep(3000);
		 //DoctorsPage.ClickingOnEllipse();
		 //Thread.sleep(2000);
		 DoctorsPage.ClickingOnDashboard();
		 Thread.sleep(3000);
	    //DoctorsPage.expliciteWait("//*[@id='sp-dashboard-content']/div[1]/div[2]",100);
		 DoctorsPage.dashboardAppointmentListing(firstname, lastname);
			}
	
	@AfterMethod
	public void bulkCancelandlogout() throws Exception{
		DoctorsPage.BulkCancel();
		Thread.sleep(3000);
		DoctorsPage.doctorlogout();
	}
	
	
	@AfterClass
	public void closebrowser(){
		driver.close();
	}

}//main Class

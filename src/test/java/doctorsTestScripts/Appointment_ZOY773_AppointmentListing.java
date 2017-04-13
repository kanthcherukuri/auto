package doctorsTestScripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.DoctorsPage;
import testBase.LoadProp;
import testBase.TestUtils;

public class Appointment_ZOY773_AppointmentListing extends LoadProp {
	
	
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
  
  
  
@Test
public void appListing() throws Exception{
	
	//DoctorsPageOfZoylo.DoctorAppointmentListing();	
	
	DoctorsPageOfZoylo.DoctorappointmentCreation();
    DoctorsPageOfZoylo.expliciteWait("//*[@id='tab-3']/ul/li[1][@class='bg-red']",100);
    DoctorsPageOfZoylo.ClickingOnEllipse();
    DoctorsPageOfZoylo.ClickingOnDashboard();
    DoctorsPageOfZoylo.expliciteWait("//*[@id='sp-dashboard-content']/div[1]/div[2]",100);
    DoctorsPageOfZoylo.dashboardAppointmentListing();
	
}
	
	
	

}//main Class

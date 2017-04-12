package doctorsTestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.DoctorsPage;
import testBase.LoadProp;
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
Thread.sleep(10000);
		
  }
  
  
  
@Test
public void appListing() throws Exception{
	
	//DoctorsPageOfZoylo.DoctorAppointmentListing();	
	
	DoctorsPageOfZoylo.DoctorappointmentCreation();
    //DoctorsPageOfZoylo.expliciteWait("//*[@id='tab-3']/ul/li[1][@class='bg-red']",5000);
	Thread.sleep(2000);
    DoctorsPageOfZoylo.ClickingOnEllipse();
    DoctorsPageOfZoylo.ClickingOnDashboard();
    DoctorsPageOfZoylo.expliciteWait("//*[@id='sp-dashboard-content']/div[1]/div[2]",5000);
    DoctorsPageOfZoylo.dashboardAppointmentListing();
	
}
	
@AfterClass	
public void afterclass(){
	
	driver.close();
	
}
	

}//main Class

package doctorsTestScripts;

import org.testng.annotations.*;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY774_CalenaderDate extends LoadPropMac {
	
	public DoctorsPage DoctorsPageOfZoylo;
	public TestUtils exceldata;



@BeforeClass
public void beforeClass() throws Exception {
	  
	LoadBrowserProperties();
	driver.manage().window().maximize();
	driver.get(doctors_Url);	 
    }
  
	     
@Test(priority=1)
public  void SignIntoDoctorLogin() throws Exception {
		
DoctorsPageOfZoylo= new DoctorsPage(driver);			
DoctorsPageOfZoylo.SignIn(DoctorsLogin_usernameone,DoctorsLogin_passwordone);
Thread.sleep(10000);
				
		  }

@Test(priority=2)

public void CheckingDashBoradCalendarDatefunctionality() throws Exception{
	
	DoctorsPageOfZoylo.doctorappointmentforcalendardate();
	//DoctorsPageOfZoylo.ClickingOnEllipse();
	DoctorsPageOfZoylo.ClickingOnDashboard();
	DoctorsPageOfZoylo.checkingappointmentbyselectingcalendardate();
	DoctorsPageOfZoylo.doctorlogout();
	

}
	
	
	

	

	
	
	
	
	
	
	
	
}	



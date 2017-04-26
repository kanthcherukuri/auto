package doctorsTestScripts;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY769_doctorprofile extends LoadPropMac{
	
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
@Test(priority=2)
	public void doctorprofileverification() throws Exception{
	DoctorsPageOfZoylo.doctorprofileEditing();
	DoctorsPageOfZoylo.doctorlogout();
	//DoctorsPageOfZoylo.BulkCancel();
	
	}
@AfterClass
public void closebrowser(){
	driver.close();
}
}

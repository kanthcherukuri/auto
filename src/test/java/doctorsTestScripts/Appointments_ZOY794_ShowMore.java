package doctorsTestScripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.DoctorsPage;
import testBase.LoadProp;
import testBase.TestUtils;

public class Appointments_ZOY794_ShowMore extends LoadProp {
	
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
DoctorsPageOfZoylo.SignIn(DoctorsLogin_username, DoctorsLogin_password);
				
		  }

@Test
public void CheckingDashBoradShowMore() throws Exception{
	DoctorsPageOfZoylo.DoctorAppointmentForShowMore();
	DoctorsPageOfZoylo.ClickingOnEllipse();
	DoctorsPageOfZoylo.ClickingOnDashboard();
	DoctorsPageOfZoylo.CheckShowMore();
	
}

}

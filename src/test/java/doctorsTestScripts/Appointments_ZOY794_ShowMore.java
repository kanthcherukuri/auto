package doctorsTestScripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.DoctorsPage;
import testBase.LoadProp;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointments_ZOY794_ShowMore extends LoadPropMac {
	
public DoctorsPage DoctorsPageOfZoylo;
public TestUtils exceldata;



		@BeforeClass
		public void beforeClass() throws Exception {
		  		LoadBrowserProperties();
				 driver.manage().window().maximize();
				 driver.get(doctors_Url);		 
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
				  }
			  
	     
		@Test(priority=1)
		public  void SignIntoDoctorLogin() throws Exception {
				
		 DoctorsPageOfZoylo= new DoctorsPage(driver);			
		 DoctorsPageOfZoylo.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
						
				  }

		@Test(priority=2)
		public void CheckingDashBoradShowMore() throws Exception{
			DoctorsPageOfZoylo.DoctorAppointmentForShowMore();
			Thread.sleep(3000);
			DoctorsPageOfZoylo.ClickingOnEllipse();
			Thread.sleep(2000);
			DoctorsPageOfZoylo.ClickingOnDashboard();
			Thread.sleep(2000);
			DoctorsPageOfZoylo.CheckShowMore();
			Thread.sleep(2000);
			
		}
		
		@Test(priority=3)
		public void AppointmentBulkCancelandLogout() throws Exception{
			DoctorsPageOfZoylo.BulkCancel();
			Thread.sleep(3000);
			DoctorsPageOfZoylo.doctorlogout();
		}
 
		@AfterClass
		public void CloseBrowser(){
			driver.close();
		}
}

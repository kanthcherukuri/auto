package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointments_ZOY794_ShowMore extends LoadPropMac {
	
		public DoctorsPage DoctorsPageOfZoylo;
		public TestUtils exceldata;



		@BeforeClass
		public void beforeClass() throws Exception {
		  		LoadBrowserProperties();
				 
				  }	  

		@Test
		public void CheckingDashBoradShowMore() throws Exception{
			driver.manage().window().maximize();
			 driver.get(doctors_Url);		 
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 DoctorsPageOfZoylo= new DoctorsPage(driver);			
			 DoctorsPageOfZoylo.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
			DoctorsPageOfZoylo.DoctorAppointmentForShowMore();
			Thread.sleep(3000);
			DoctorsPageOfZoylo.ClickingOnEllipse();
			Thread.sleep(2000);
			DoctorsPageOfZoylo.ClickingOnDashboard();
			Thread.sleep(2000);
			DoctorsPageOfZoylo.CheckShowMore();
			Thread.sleep(2000);
			
		}
		
		@AfterMethod
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

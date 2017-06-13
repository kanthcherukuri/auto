package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import java.util.concurrent.TimeUnit;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointments_ZOY794_ShowMore extends LoadPropMac {
	
		public DoctorsPage DoctorsPage;
		public TestUtils exceldata;



		@BeforeClass
		public void beforeClass() throws Exception {
		  		LoadBrowserProperties();
		  		driver.manage().window().maximize();
				 driver.get(doctors_Url);		 
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				 DoctorsPage= new DoctorsPage(driver);			
				 DoctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
				 
				  }	  

		@Test
		public void CheckingDashBoradShowMore() throws Exception{
			
			DoctorsPage.DoctorAppointmentForShowMore();
			Thread.sleep(3000);
			//DoctorsPage.ClickingOnEllipse();
			//Thread.sleep(2000);
			DoctorsPage.ClickingOnDashboard();
			Thread.sleep(2000);
			DoctorsPage.CheckShowMore();
			Thread.sleep(2000);
			
		}
		
		@AfterMethod
		public void AppointmentBulkCancelandLogout() throws Exception{
			DoctorsPage.BulkCancel();
			Thread.sleep(3000);
			DoctorsPage.doctorlogout();
		}
 
		@AfterClass
		public void CloseBrowser(){
			driver.quit();
		}
}

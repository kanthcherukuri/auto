package doctorsTestScripts;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import objectRepository.Elements_Doctors;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY844_DoctorHospital_DeleteWorkTimings extends LoadPropMac{
	
	public DoctorsPage DoctorsPage;
	 public TestUtils Browser;

	 @BeforeClass
		public void LaunchBrowser() throws Exception {
			LoadBrowserProperties();
			 driver.get(doctors_Url);		 
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 DoctorsPage= new DoctorsPage(driver);	
			 Browser=new TestUtils(driver);
			 DoctorsPage.SignIn(DoctorsLogin_usernamefour,  DoctorsLogin_passwordfour);
			  } 
	 
	 @Test
	 public void DoctorHospitalDeleteWorkTimings() throws Exception{
		 
		 DoctorsPage.BulkCancel();
		 Thread.sleep(2000);
		 driver.findElement(By.id("schedule")).click();
		 Thread.sleep(3000);
		 DoctorsPage.DoctorsHospitalAddWorkTimings("07:00", "23:59");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(Elements_Doctors.HospitalDeleteWorkTimings)).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(Elements_Doctors.HospitalSaveWorkTimings)).click();
		 Browser.CheckNotificationMessage("Schedule Updated Successfully");
		 Thread.sleep(2000);
		 DoctorsPage.doctorlogout();
	 }
	 
	 @AfterClass
		public void Closebrowser(){
			driver.close();
		}

  
}
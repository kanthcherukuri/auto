package doctorsTestScripts;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import objectRepository.Elements_Doctors;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY848_DoctorHospital_DifferentStartEndTimes extends LoadPropMac{
	
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
	 public void DoctorHospitalsSameStartEndTimes() throws Exception{
		 DoctorsPage.BulkCancel();
		 Thread.sleep(2000);
		 driver.findElement(By.id("schedule")).click();
		 Thread.sleep(3000);
		 DoctorsPage.DoctorsHospitalAddWorkTimings("10:00", "10:00");
		 Browser.CheckNotificationMessage("Hospital Time Slot overlaps with Other Working Time Slot");
		 Thread.sleep(3000);
	 }
	 
	 @AfterMethod
	 public void DeleteAddedWorkTimingsandlogout() throws Exception{
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_DeleteWorkTimings)).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings)).click();
		 Thread.sleep(2000);
		 DoctorsPage.doctorlogout();
		 
	 }
	 
	 @AfterClass
		public void Closebrowser(){
			driver.close();
		}

	
}



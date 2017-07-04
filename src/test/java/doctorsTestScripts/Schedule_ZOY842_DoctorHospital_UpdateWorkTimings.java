package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import objectRepository.Elements_Doctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;

public class Schedule_ZOY842_DoctorHospital_UpdateWorkTimings extends LoadPropMac{
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
	 public void DoctorHospitalUpdateWorkTiming() throws Exception{
		 DoctorsPage.BulkCancel();
		 Thread.sleep(2000);
		 driver.findElement(By.id("schedule")).click();
		 Thread.sleep(3000);
		 DoctorsPage.DoctorsHospitalAddWorkTimings("07:00", "23:59");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_Starttime)).clear();
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_Starttime)).sendKeys("09:00");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_EndTime)).clear();
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_EndTime)).sendKeys("14:00");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings)).click();
		 Browser.CheckNotificationMessage("Schedule Updated Successfully");
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



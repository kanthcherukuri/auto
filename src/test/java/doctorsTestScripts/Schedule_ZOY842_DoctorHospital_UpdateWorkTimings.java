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
			 DoctorsPage= new DoctorsPage(driver);	
			 Browser=new TestUtils(driver);
			 Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 DoctorsPage.SignIn(DoctorsLogin_usernamefour,  DoctorsLogin_passwordfour);
			  } 
	 
	 @Test
	 public void DoctorHospitalUpdateWorkTiming() throws Exception{
		 DoctorsPage.BulkCancel();
		 Thread.sleep(4000);
		 Browser.clickOnTheElementByID("schedule");
		 Browser.waitTill(2000);
		 DoctorsPage.DoctorsHospitalAddWorkTimings("07:00", "23:59");
		 Thread.sleep(2000);
		 Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_Starttime);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_Starttime)).clear();
		 Browser.enterTextByXpath(Elements_Doctors.Schedule_Hospital_Starttime, "09:00");
		 Thread.sleep(2000);
		 Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_EndTime);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_EndTime)).clear();
		 Browser.enterTextByXpath(Elements_Doctors.Schedule_Hospital_EndTime, "14:00");
		 Thread.sleep(1000);
		 Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
		 Browser.CheckNotificationMessage("Hospital Time Slot Updated Successfully");
		 Thread.sleep(3000);
	 }
	 
	 @AfterMethod
	 public void DeleteAddedWorkTimingsandlogout() throws Exception{
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_DeleteWorkTimings);
		 Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
		 Thread.sleep(2000);
		 DoctorsPage.doctorlogout();
		 
	 }
	 
	 @AfterClass
		public void Closebrowser(){
			driver.close();
		}
	

}



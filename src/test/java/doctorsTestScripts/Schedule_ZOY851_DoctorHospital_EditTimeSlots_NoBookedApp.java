//@author:Ch.Lakshmi Kanth
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

public class Schedule_ZOY851_DoctorHospital_EditTimeSlots_NoBookedApp extends LoadPropMac {
	public DoctorsPage DoctorsPage;
	 public TestUtils Browser;
	 
	 @BeforeClass
		public void LaunchBrowser() throws Exception {
			LoadBrowserProperties(); 
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 DoctorsPage= new DoctorsPage(driver);	
			 Browser=new TestUtils(driver);
			 Browser.openUrl(loginPage_Url);
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 DoctorsPage.SignIn(DoctorsLogin_usernamefour,  DoctorsLogin_passwordfour);
			  } 
	 
	 @Test
	 public void HospitalIncreaseTimeSlotNoBookedApp() throws Exception{
		 DoctorsPage.BulkCancel();
		 Thread.sleep(2000);
		 Browser.clickOnTheElementByID("schedule");
		 Thread.sleep(3000);
		 DoctorsPage.DoctorsHospitalAddWorkTimings("07:00", "14:00");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_EndTime)).clear();
		 Browser.enterTextByXpath(Elements_Doctors.Schedule_Hospital_EndTime, "16:00");
		 Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
		 Browser.CheckNotificationMessage("Hospital Time Slot Updated Successfully");
		 Thread.sleep(2000);
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

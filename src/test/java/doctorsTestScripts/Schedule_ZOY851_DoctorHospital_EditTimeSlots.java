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

public class Schedule_ZOY851_DoctorHospital_EditTimeSlots extends LoadPropMac {
	public DoctorsPage DoctorsPage;
	 public TestUtils Browser;
	 
	 @BeforeClass
		public void LaunchBrowser() throws Exception {
			LoadBrowserProperties(); 
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 DoctorsPage= new DoctorsPage(driver);	
			 Browser=new TestUtils(driver);
			 Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 DoctorsPage.SignIn(DoctorsLogin_usernamefour,  DoctorsLogin_passwordfour);
			  } 
	 
	 @Test
	 public void HospitalIncreaseTimeSlotNoBookedApp() throws Exception{
		 DoctorsPage.BulkCancel();
		 Thread.sleep(5000);
		 Browser.clickOnTheElementByID("schedule");
		 Thread.sleep(3000);
		 DoctorsPage.DoctorsHospitalAddWorkTimingsSunday("07:00", "20:00");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_EndTime)).clear();
		 Browser.enterTextByXpath(Elements_Doctors.Schedule_Hospital_EndTime, "19:00");
		 Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
		 Browser.CheckNotificationMessage("Hospital Time Slot Updated Successfully");
		 Thread.sleep(7000);
		 DoctorsPage.DoctorAppointmentBookingForSunday("Mohan", "M", "9900224466", "mohan@gmail.com", "liver");
		 Browser.clickOnTheElementByID(Elements_Doctors.schedule);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_ClickOnHospitalTab);
		 Browser.waitFortheID(Elements_Doctors.Schedule_Hospital_SundayMenu);
		 Browser.clickOnTheElementByID(Elements_Doctors.Schedule_Hospital_SundayMenu);
		 Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_EndTime);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_EndTime)).clear();
		 Browser.enterTextByXpath(Elements_Doctors.Schedule_Hospital_EndTime, "18:00");
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
		 Browser.CheckNotificationMessage("Conflict with existing appointments, please cancel the appointments to change working start time.");
		 DoctorsPage.cancelSundayAppt();
	 }
	 @AfterMethod
	 public void DeleteAddedWorkTimingsandlogout() throws Exception{
		 Browser.clickOnTheElementByID(Elements_Doctors.schedule);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_ClickOnHospitalTab);
		 Browser.clickOnTheElementByID(Elements_Doctors.Schedule_Hospital_SundayMenu);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_DeleteWorkTimings);
		 Browser.CheckNotificationMessage("Time Slot Deleted Successfully");
		 Thread.sleep(7000);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
		 Browser.CheckNotificationMessage("Hospital Time Slot Updated Successfully");
		 Thread.sleep(2000);
		 DoctorsPage.doctorlogout();
		 
	 }
	 
	 @AfterClass
		public void Closebrowser(){
			driver.close();
		}
	
}

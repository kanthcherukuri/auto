//@author:Ch.Lakshmi Kanth
package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import objectRepository.Elements_Doctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY851_Hospital_DecTimeSlotAppointmentAvailable extends LoadPropMac{
	public DoctorsPage DoctorsPage;
	 public TestUtils Browser;
	 
	 @BeforeClass
		public void LaunchBrowser() throws Exception {
			LoadBrowserProperties();	 
			 DoctorsPage= new DoctorsPage(driver);	
			 Browser=new TestUtils(driver);
			 Browser.openUrl(loginPage_Url);
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 DoctorsPage.SignIn(DoctorsLogin_usernamefour,  DoctorsLogin_passwordfour);
			  } 
	 
	 @Test
	 public void HospitalDecreseTimeAppointmentBooked() throws Exception{
		 
		 Browser.clickOnTheElementByID(Elements_Doctors.schedule);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_ClickOnHospitalTab);
		 Browser.clickOnTheElementByID(Elements_Doctors.Schedule_Hospital_SundayMenu);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_ClickAddWorkTimingsButton);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_ClickOnToggle);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_Starttime)).clear();
		 Browser.enterTextByXpath(Elements_Doctors.Schedule_Hospital_Starttime, "07:00");
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_EndTime)).clear();
		 Browser.enterTextByXpath(Elements_Doctors.Schedule_Hospital_EndTime, "20:00");
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
		 Thread.sleep(2000);
		 DoctorsPage.DoctorAppointmentBookingForSunday("Mohan", "M", "9900224466", "mohan@gmail.com", "liver");
		 Thread.sleep(6000);
		 Browser.clickOnTheElementByID(Elements_Doctors.schedule);
		 Thread.sleep(2000);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_ClickOnHospitalTab);
		 Browser.waitFortheID(Elements_Doctors.Schedule_Hospital_SundayMenu);
		 Browser.clickOnTheElementByID(Elements_Doctors.Schedule_Hospital_SundayMenu);
		 Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_EndTime);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_EndTime)).clear();
		 Browser.enterTextByXpath(Elements_Doctors.Schedule_Hospital_EndTime, "19:00");
		 //Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
		 Browser.CheckNotificationMessage("Conflict with existing appointments, please cancel the appointments to change working start time.");
		 //Browser.waitforTextbyxpath("//div[@class='zy-status-wrapper']", "Conflict");
		 Thread.sleep(6000);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_EndTime)).clear();
		 Browser.enterTextByXpath(Elements_Doctors.Schedule_Hospital_EndTime, "22:00");
		 Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
		 Browser.CheckNotificationMessage("Hospital Time Slot Updated Successfully");
		 Thread.sleep(2000);
	 }
	 
	 @AfterMethod
	 public void DeleteWorktimeandAppointment() throws Exception{
		 DoctorsPage.cancelSundayAppt(); 
		 Thread.sleep(3000);
		 Browser.clickOnTheElementByID(Elements_Doctors.schedule);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_ClickOnHospitalTab);
		 Browser.clickOnTheElementByID(Elements_Doctors.Schedule_Hospital_SundayMenu);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_DeleteWorkTimings);
		 Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
		 Thread.sleep(3000);
		 
	 }
	
	
	
	@AfterClass
	public void Closebrowser(){
		driver.close();
	}
	}
 


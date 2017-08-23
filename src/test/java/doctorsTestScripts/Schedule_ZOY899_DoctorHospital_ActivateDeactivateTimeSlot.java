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

public class Schedule_ZOY899_DoctorHospital_ActivateDeactivateTimeSlot extends LoadPropMac {
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
	 public void ActivateDeactivateTimeSlot() throws Exception{
		
		 Browser.clickOnTheElementByID(Elements_Doctors.schedule);
		 Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_ClickOnHospitalTab);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_ClickOnHospitalTab);
		 Browser.waitFortheID(Elements_Doctors.Schedule_Hospital_SundayMenu);
		 Browser.clickOnTheElementByID(Elements_Doctors.Schedule_Hospital_SundayMenu);
		 Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_ClickAddWorkTimingsButton);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_ClickAddWorkTimingsButton);
		 Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_ClickOnToggle);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_ClickOnToggle);
		 Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_Starttime);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_Starttime)).clear();
		 Browser.enterTextByXpath(Elements_Doctors.Schedule_Hospital_Starttime, "07:00");
		 Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_EndTime);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_EndTime)).clear();
		 Browser.enterTextByXpath(Elements_Doctors.Schedule_Hospital_EndTime, "20:00");
		 Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
		 Thread.sleep(3000);
		 DoctorsPage.DoctorAppointmentBookingForSunday("Mohan", "M", "9900224466", "mohan@gmail.com", "liver");
		 Thread.sleep(3000);
		 Browser.clickOnTheElementByID(Elements_Doctors.schedule);
		 Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_ClickOnHospitalTab);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_ClickOnHospitalTab);
		 Browser.waitFortheID(Elements_Doctors.Schedule_Hospital_SundayMenu);
		 Browser.clickOnTheElementByID(Elements_Doctors.Schedule_Hospital_SundayMenu);
		 Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_ClickOnToggle);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_ClickOnToggle);
		// Browser.waitforTextbyxpath("//div[@class='zy-status-wrapper']", "Conflicts");
		//Thread.sleep(3000);
         
		
	 }
	 
	 @AfterMethod
	 public void DeleteWorktimeandAppointment() throws Exception{
		 DoctorsPage.cancelSundayAppt(); 
		 Thread.sleep(3000);
		 Browser.clickOnTheElementByID(Elements_Doctors.schedule);
		 Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_ClickOnHospitalTab);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_ClickOnHospitalTab);
		 Browser.waitFortheID(Elements_Doctors.Schedule_Hospital_SundayMenu);
		 Browser.clickOnTheElementByID(Elements_Doctors.Schedule_Hospital_SundayMenu);
		 Browser.waitFortheElementXpath("//i[@class='fa fa-minus-circle hospital_rem_slot']");
		 Browser.clickOnTheElementByXpath("//i[@class='fa fa-minus-circle hospital_rem_slot']");
		 Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
	
	 }
	 
	 @AfterClass
		public void Closebrowser(){
			driver.close();
		}
}

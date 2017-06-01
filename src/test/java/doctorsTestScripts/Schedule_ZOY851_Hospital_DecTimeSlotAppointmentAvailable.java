package doctorsTestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Doctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY851_Hospital_DecTimeSlotAppointmentAvailable extends LoadPropMac{
	public DoctorsPage DoctorsPageOfZoylo;
	 public TestUtils Browser;
	 
	 @BeforeClass
		public void LaunchBrowser() throws Exception {
			LoadBrowserProperties();
			 driver.get(doctors_Url);		 
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 DoctorsPageOfZoylo= new DoctorsPage(driver);	
			 Browser=new TestUtils(driver);
			 DoctorsPageOfZoylo.SignIn(DoctorsLogin_usernamefour,  DoctorsLogin_passwordfour);
			  } 
	 
	 @Test
	 public void HospitalDecreseTimeAppointmentBooked() throws Exception{
		 driver.findElement(By.id(Elements_Doctors.schedule)).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath(Elements_Doctors.ClickOnHospitalTab)).click();
		 Thread.sleep(2000);
		 driver.findElement(By.id(Elements_Doctors.HospitalsSundayMenu)).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(Elements_Doctors.HospitalClickAddWorkTimingsButton)).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(Elements_Doctors.HospitalClickOnToggle)).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath(Elements_Doctors.HospitalStarttime)).clear();
		 driver.findElement(By.xpath(Elements_Doctors.HospitalStarttime)).sendKeys("07:00");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(Elements_Doctors.HospitalEndTime)).clear();
		 driver.findElement(By.xpath(Elements_Doctors.HospitalEndTime)).sendKeys("20:00");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath(Elements_Doctors.HospitalSaveWorkTimings)).click();
		 Thread.sleep(4000);
		 DoctorsPageOfZoylo.DoctorAppointmentBookingForSunday("Mohan", "M", "9900224466", "mohan@gmail.com", "liver");
		 Thread.sleep(4000);
		 driver.findElement(By.id(Elements_Doctors.schedule)).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(Elements_Doctors.ClickOnHospitalTab)).click();
		 Thread.sleep(1000);
		 driver.findElement(By.id(Elements_Doctors.HospitalsSundayMenu)).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(Elements_Doctors.HospitalEndTime)).clear();
		 driver.findElement(By.xpath(Elements_Doctors.HospitalEndTime)).sendKeys("19:00");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(Elements_Doctors.HospitalSaveWorkTimings)).click();
		 Browser.waitforTextbyxpath("//div[@class='zy-status-wrapper']", "Conflict");
		 Thread.sleep(6000);
		 driver.findElement(By.xpath(Elements_Doctors.HospitalEndTime)).clear();
		 driver.findElement(By.xpath(Elements_Doctors.HospitalEndTime)).sendKeys("22:00");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(Elements_Doctors.HospitalSaveWorkTimings)).click();
		 Browser.CheckNotificationMessage("Schedule Updated Successfully");
		 Thread.sleep(4000);
	 }
	 
	 @AfterMethod
	 public void DeleteWorktimeandAppointment() throws Exception{
		 driver.findElement(By.xpath(Elements_Doctors.HospitalDeleteWorkTimings)).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(Elements_Doctors.HospitalSaveWorkTimings)).click();
		 Thread.sleep(3000);
		 DoctorsPageOfZoylo.cancelSundayAppt(); 
	 }
	
	
	
	@AfterClass
	public void Closebrowser(){
		driver.close();
	}
	}
 


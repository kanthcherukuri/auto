package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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
			 driver.get(doctors_Url);		 
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 DoctorsPage= new DoctorsPage(driver);	
			 Browser=new TestUtils(driver);
			 DoctorsPage.SignIn(DoctorsLogin_usernamefour,  DoctorsLogin_passwordfour);
			  } 
	 
	 @Test
	 public void ActivateDeactivateTimeSlot() throws Exception{
		 driver.findElement(By.id(Elements_Doctors.schedule)).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_ClickOnHospitalTab)).click();
		 Thread.sleep(2000);
		 driver.findElement(By.id(Elements_Doctors.Schedule_Hospital_SundayMenu)).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_ClickAddWorkTimingsButton)).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_ClickOnToggle)).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_Starttime)).clear();
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_Starttime)).sendKeys("07:00");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_EndTime)).clear();
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_EndTime)).sendKeys("20:00");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings)).click();
		 Thread.sleep(4000);
		 DoctorsPage.DoctorAppointmentBookingForSunday("Mohan", "M", "9900224466", "mohan@gmail.com", "liver");
		 Thread.sleep(4000);
		 driver.findElement(By.id(Elements_Doctors.schedule)).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_ClickOnHospitalTab)).click();
		 Thread.sleep(1000);
		 driver.findElement(By.id(Elements_Doctors.Schedule_Hospital_SundayMenu)).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_ClickOnToggle)).click();
		 Browser.waitforTextbyxpath("//div[@class='zy-status-wrapper']", "Conflicts");
		 Thread.sleep(3000);
         
		
	 }
	 
	 @AfterMethod
	 public void DeleteWorktimeandAppointment() throws Exception{
		 Thread.sleep(3000);
		 DoctorsPage.cancelSundayAppt(); 
		 Thread.sleep(3000);
		 driver.findElement(By.id(Elements_Doctors.schedule)).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_ClickOnHospitalTab)).click();
		 Thread.sleep(2000);
		 driver.findElement(By.id(Elements_Doctors.Schedule_Hospital_SundayMenu)).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//i[@class='fa fa-minus-circle hospital_rem_slot']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings)).click();
	 }
	 
	 @AfterClass
		public void Closebrowser(){
			driver.close();
		}
}

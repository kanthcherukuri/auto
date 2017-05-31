package doctorsTestScripts;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Doctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY815_Doctor_EditTimeSlotForClinics_IncreaseTime extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage docpage;
	
	//Global variables
	public String firstName="Gurr";
	public String lastName="Charan";
	public String Mobile="9870000000";
	public String mail="guru1@gmail.com";
	public String prob="This is my problem";
	public String updtendTime="18:00";
		
  @Test()
  public void testEditTimeSlotForClinicsIncreaseTime() throws Exception
  {
	  	docpage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
	  	//docpage.BulkCancel();
		Thread.sleep(2000);
		driver.findElement(By.id("schedule")).click();
		Browser.waitforTextbyxpath("(//div[@class='day-title'])[1]", "Consultation");
		docpage.addClinicWorkTimings("10:00", "17:00");
		Thread.sleep(1000);
		docpage.DoctorAppointmentBookingForSunday(firstName, lastName, Mobile, mail, prob);
		Thread.sleep(4000);
		driver.findElement(By.id("schedule")).click();
		Browser.waitFortheElementXpath(Elements_Doctors.clinicTab);
		driver.findElement(By.xpath(Elements_Doctors.clinicTab)).click();
		Browser.waitFortheID(Elements_Doctors.clinicName);
		driver.findElement(By.id(Elements_Doctors.sundayTab)).click();
		driver.findElement(By.xpath(Elements_Doctors.WendTime)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Doctors.WendTime)).sendKeys(updtendTime);
		driver.findElement(By.xpath(Elements_Doctors.clinicSubmitTimeSlots)).click(); //Save
		Browser.CheckNotificationMessage("Schedule Updated Successfully");
		Thread.sleep(4000);
		docpage.cancelSundayAppt(); //cancel sunday appointment
		Thread.sleep(4000);
		driver.findElement(By.id("schedule")).click();
		Browser.waitFortheElementXpath(Elements_Doctors.clinicTab);
		driver.findElement(By.xpath(Elements_Doctors.clinicTab)).click();
		Browser.waitFortheID(Elements_Doctors.clinicName);
		driver.findElement(By.id(Elements_Doctors.sundayTab)).click();
		driver.findElement(By.xpath(Elements_Doctors.WendTime)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Doctors.WendTime)).sendKeys(updtendTime);
		driver.findElement(By.xpath(Elements_Doctors.clinicSubmitTimeSlots)).click(); //Save
		Browser.CheckNotificationMessage("Schedule Updated Successfully");
  }
  
  @BeforeClass
 	public void launchapp() throws Exception
 	{
 		LoadBrowserProperties();
 		Browser= new TestUtils(driver);
 		docpage=new DoctorsPage(driver);
 		driver.get(recipient_url);
 	}
 	
 	@AfterClass
 	public void closeapp() throws Exception
 	{
 		Thread.sleep(2000);
 		docpage.removeClinicWorkTimings();
 		Thread.sleep(3000);
 		driver.close();
 	}
}
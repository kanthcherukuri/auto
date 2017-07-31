package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import objectRepository.Elements_Doctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

//@Author: Sagar Sen

public class Schedule_ZOY821_Doctor_ActivateDeactivateTimeSlot extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;
	
	@DataProvider(name="addAptdetail")
	  public Object[][] adAptInfo() throws Exception
	  {
		  Object[][] aptdetails=TestUtils.getTableArray("TestData/Doctors_TestData.xls", "Schedule", "ZOY811");
		  return(aptdetails);
	  }
	
	@Test(dataProvider="addAptdetail")
  public void testActivateDeactivateTimeSlot(String firstName, String lastName, String Mobile, String mail, String prob) throws Exception
  {
		doctorsPage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
	  	doctorsPage.BulkCancel();
	  	Browser.CheckNotificationMessage("Appointments cancelled successfully");
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Browser.waitFortheElementXpath("(//div[@class='day-title'])[1]");
		Thread.sleep(2000);
		doctorsPage.addClinicWorkTimings("10:00", "17:00");
		Thread.sleep(2000);
		doctorsPage.DoctorAppointmentBookingForSunday(firstName, lastName, Mobile, mail, prob);
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Browser.waitFortheElementXpath(Elements_Doctors.clinicTab);
		driver.findElement(By.xpath(Elements_Doctors.clinicTab)).click();
		Browser.waitFortheID(Elements_Doctors.clinicName);
		driver.findElement(By.id(Elements_Doctors.sundayTab)).click();
		activateDeactivate();
		Browser.CheckNotificationMessage("Conflict with existing appointments. To deactivate the clinic, please cancel the scheduled appointments");
		Thread.sleep(2000);
		doctorsPage.cancelSundayAppt(); //cancel sunday appointment
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Browser.waitFortheElementXpath(Elements_Doctors.clinicTab);
		driver.findElement(By.xpath(Elements_Doctors.clinicTab)).click();
		Browser.waitFortheID(Elements_Doctors.clinicName);
		driver.findElement(By.id(Elements_Doctors.sundayTab)).click();
		activateDeactivate();
		Thread.sleep(6000);
		driver.findElement(By.xpath(Elements_Doctors.clinicSubmitTimeSlots)).click(); //Save
		Browser.CheckNotificationMessage("Clinic Time Slot Updated Successfully");
		Thread.sleep(2000);
  }
  
  public void activateDeactivate() throws Exception
  {
	  	Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Doctors.sundayToggle)).click();
		//driver.findElement(By.xpath(Elements_Doctors.clinicSubmitTimeSlots)).click(); //Save
  }
	  
  @BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		doctorsPage=new DoctorsPage(driver);
		driver.get(loginPage_Url);
	}
	
  @AfterClass
	public void closeapp() throws Exception
	{
		doctorsPage.removeClinicWorkTimings();
		driver.quit();
	}

}
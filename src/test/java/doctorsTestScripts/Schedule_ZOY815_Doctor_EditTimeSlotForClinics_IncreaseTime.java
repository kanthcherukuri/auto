package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import objectRepository.Elements_Doctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY815_Doctor_EditTimeSlotForClinics_IncreaseTime extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;
	

	//Global variables
	public String updtendTime="18:00";
	@DataProvider(name="addAptdetail")
	  public Object[][] adAptInfo() throws Exception
	  {
		  Object[][] aptdetails=TestUtils.getTableArray("TestData/Doctors_TestData.xls", "Schedule", "ZOY811");
		  return(aptdetails);
	  }
	
	@Test(dataProvider="addAptdetail")
  public void testEditTimeSlotForClinicsIncreaseTime(String firstName, String lastName, String Mobile, String mail, String prob) throws Exception
  {
	  doctorsPage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
	  	//docpage.BulkCancel();
		Thread.sleep(5000);
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Browser.waitFortheElementXpath("(//div[@class='day-title'])[1]");
		Thread.sleep(6000);
		doctorsPage.addClinicWorkTimings("10:00", "17:00");
		Thread.sleep(5000);
		doctorsPage.DoctorAppointmentBookingForSunday(firstName, lastName, Mobile, mail, prob);
		Thread.sleep(5000);
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Browser.waitFortheElementXpath(Elements_Doctors.clinicTab);
		driver.findElement(By.xpath(Elements_Doctors.clinicTab)).click();
		Browser.waitFortheID(Elements_Doctors.clinicName);
		driver.findElement(By.id(Elements_Doctors.sundayTab)).click();
		driver.findElement(By.xpath(Elements_Doctors.WendTime)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Doctors.WendTime)).sendKeys(updtendTime);
		driver.findElement(By.xpath(Elements_Doctors.clinicSubmitTimeSlots)).click(); //Save
		Browser.CheckNotificationMessage("Clinic Time Slot Updated Successfully");
		Thread.sleep(4000);
		doctorsPage.cancelSundayAppt(); //cancel sunday appointment
		Thread.sleep(4000);
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Browser.waitFortheElementXpath(Elements_Doctors.clinicTab);
		driver.findElement(By.xpath(Elements_Doctors.clinicTab)).click();
		Browser.waitFortheID(Elements_Doctors.clinicName);
		driver.findElement(By.id(Elements_Doctors.sundayTab)).click();
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
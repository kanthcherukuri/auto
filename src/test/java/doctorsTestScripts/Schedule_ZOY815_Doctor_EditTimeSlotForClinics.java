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

public class Schedule_ZOY815_Doctor_EditTimeSlotForClinics extends LoadPropMac
{	
	public TestUtils Browser;
	public DoctorsPage doctorsPage;
	
	//Global variables
	public String timeDecrease="16:00";
	public String timeIncrease="18:00";
	@DataProvider(name="addAptdetail")
	  public Object[][] adAptInfo() throws Exception
	  {
		  Object[][] aptdetails=TestUtils.getTableArray("TestData/Doctors_TestData.xls", "Schedule", "ZOY811");
		  return(aptdetails);
	  }
	
	@Test(dataProvider="addAptdetail")
  public void testEditTimeSlotForClinicsDecreaseTime(String firstName, String lastName, String Mobile, String mail, String prob) throws Exception
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
		driver.findElement(By.xpath(Elements_Doctors.WendTime)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Doctors.WendTime)).sendKeys(timeDecrease);
		driver.findElement(By.xpath(Elements_Doctors.clinicSubmitTimeSlots)).click(); //Save
		Browser.waitforTextbyxpath("//div[@class='zy-status-wrapper']", "Conflict");
		driver.findElement(By.xpath("//div[@class='zy-status-wrapper']")).click();
		Thread.sleep(2000);
		//ZOY815 Increase time check
		driver.findElement(By.xpath(Elements_Doctors.WendTime)).clear();
		driver.findElement(By.xpath(Elements_Doctors.WendTime)).sendKeys(timeIncrease);
		driver.findElement(By.xpath(Elements_Doctors.clinicSubmitTimeSlots)).click(); //Save
		Browser.CheckNotificationMessage("Clinic Time Slot Updated Successfully");
		doctorsPage.cancelSundayAppt(); //cancel sunday appointment
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Browser.waitFortheElementXpath(Elements_Doctors.clinicTab);
		driver.findElement(By.xpath(Elements_Doctors.clinicTab)).click();
		Browser.waitFortheID(Elements_Doctors.clinicName);
		driver.findElement(By.id(Elements_Doctors.sundayTab)).click();
		Thread.sleep(2000);
  }
  
  @BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		doctorsPage=new DoctorsPage(driver);
		driver.get("https://"+Environment_Name+".zoylo.com/login");
	}
	
	@AfterClass
	public void closeapp() throws Exception
	{
		doctorsPage.removeClinicWorkTimings();
		driver.quit();
	}

}
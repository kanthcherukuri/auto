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

public class Schedule_ZOY811_Doctor_WorkTimingsvalidationChecks extends LoadPropMac
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
  public void testDeleteTimings(String firstName, String lastName, String Mobile, String mail, String prob) throws Exception
  {
		doctorsPage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
	  	doctorsPage.BulkCancel();
	  	Thread.sleep(5000);
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Thread.sleep(5000);
		Browser.waitFortheElementXpath("(//div[@class='day-title'])[1]");
		doctorsPage.addClinicWorkTimings("10:00", "17:00");
		Thread.sleep(5000);
		doctorsPage.DoctorAppointmentBookingForSunday(firstName, lastName, Mobile, mail, prob);
		Thread.sleep(5000);
		doctorsPage.checkWorkDeletionConflict(); //check delete conflicts
		Thread.sleep(5000);
		doctorsPage.cancelSundayAppt(); //cancel sunday appointment
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Browser.waitFortheElementXpath(Elements_Doctors.clinicTab);
		driver.findElement(By.xpath(Elements_Doctors.clinicTab)).click();
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

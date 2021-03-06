package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import objectRepository.Elements_Doctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

//@Author: Sagar Sen

public class Schedule_ZOY804_Doctor_AddWorkTimingsUnderClinicsTab extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;
	public String updateStrtTime="11:00";
	public String updateEndTime="16:00";
	
	@Test()
      public void testAddWorkTimingsUnderClinicsTab() throws Exception
	{
		doctorsPage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
		doctorsPage.BulkCancel();
		Browser.CheckNotificationMessage("Appointments cancelled successfully");
		//Thread.sleep(6000);
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Thread.sleep(2000);
		Browser.waitFortheElementXpath("(//div[@class='day-title'])[1]");
		doctorsPage.addClinicWorkTimings("10:00", "12:00");
		driver.navigate().refresh();
		doctorsPage.updateClinicWorkTimings(updateStrtTime, updateEndTime); //ZOY-807 script merged
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

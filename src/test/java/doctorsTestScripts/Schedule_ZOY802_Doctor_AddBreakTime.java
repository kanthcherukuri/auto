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

public class Schedule_ZOY802_Doctor_AddBreakTime extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;
	
	@Test()
	public void testAddBreakTime() throws Exception 
	{
		doctorsPage.SignIn(DoctorsLogin_usernamefive, DoctorsLogin_passwordfive);
		doctorsPage.BulkCancel();
		Browser.CheckNotificationMessage("Appointments cancelled successfully");
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Thread.sleep(6000);
		Browser.waitFortheElementXpath("(//div[@class='day-title'])[1]");
		doctorsPage.checkAddBreakTimes("13:00", "13:00");
		Browser.CheckNotificationMessage("End Time should be after Start Time");
		doctorsPage.checkremoveBreakTimes();
		doctorsPage.checkAddBreakTimes("13:00", "14:00");
		Browser.CheckNotificationMessage("Schedule updated successfully");
		doctorsPage.checkremoveBreakTimes();
		Thread.sleep(5000);
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
		driver.quit();
	}

}
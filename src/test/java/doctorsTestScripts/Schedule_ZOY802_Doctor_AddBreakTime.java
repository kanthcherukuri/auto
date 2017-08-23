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
		Thread.sleep(2000);
		Browser.waitFortheElementXpath("(//div[@class='day-title'])[1]");
		doctorsPage.checkAddBreakTimes("13:00", "13:00");
		Browser.CheckNotificationMessage("End Time should be after Start Time");
		doctorsPage.checkremoveBreakTimes();
		driver.navigate().refresh();
		//ZOY809 check
		Browser.clickOnTheElementByID(Elements_Doctors.schedule);
		Thread.sleep(2000);
		Browser.waitFortheElementXpath("(//div[@class='day-title'])[1]");
		doctorsPage.addClinicWorkTimings("10:00", "17:00");
		driver.navigate().refresh();
		Browser.waitFortheElementXpath("//strong[contains(., 'SET BREAK TIME')]");
		doctorsPage.checkAddBreakTimes("13:00", "14:00");
		Browser.CheckNotificationMessage("Lunch Slots overlap with working slots");
		doctorsPage.checkremoveBreakTimes();
		driver.navigate().refresh();
		Browser.waitFortheElementXpath(Elements_Doctors.clinicTab);
		driver.findElement(By.xpath(Elements_Doctors.clinicTab)).click();
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
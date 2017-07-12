package doctorsTestScripts;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Doctors;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.NewAdminDoctorsPage;
import testBase.TestUtils;

//@Author: Sagar Sen

public class Schedule_ZOY2100_AddClinic extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;
	public NewAdminDoctorsPage admin;
	
	@DataProvider(name="clinicdata")
	public Object[][] clinicdetails() throws Exception
	{
		Object[][] clinicinfo=TestUtils.getTableArray("TestData/Doctors_TestData.xls", "Schedule", "ZOY2100");
		return(clinicinfo);
	}
	
	@Test(dataProvider="clinicdata")
	public void addClinic(String ohrName, String otrClincFee, String othrCliNum, String linone, String otrPin, String lon, String lat) throws Exception
	{
		doctorsPage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
		Thread.sleep(2000);
		doctorsPage.addclinicSchedule(ohrName, otrClincFee, othrCliNum, linone, otrPin, lon, lat);
		closeapp();
		launchapp();
		admin.adminSignIn(admin_user, admin_password);
		doctorsPage.deleteOtherClinicFromAdmin(DoctorsLogin_username);
		
		//Admin logout
		Thread.sleep(6000);
		Browser.waitFortheElementXpath("//button[@class='btn btn-default dropdown-toggle']");
		driver.findElement(By.xpath("//button[@class='btn btn-default dropdown-toggle']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("logout")).click();
		Browser.waitFortheElementXpath("//img[@class='indexProfileImg']");
		
		//Deactivate all days break time temporary error cover methods
		driver.get(loginPage_Url);
		doctorsPage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Browser.waitforTextbyxpath("(//div[@class='day-title'])[1]", "Consultation");
		Browser.scrollbyxpath(Elements_Doctors.submitSchedule);
		driver.findElement(By.xpath(Elements_Doctors.submitSchedule)).click();
		Browser.waitFortheElementXpath("//div[@class='zy-status-wrapper']");
		String verifyMsg=Browser.getTextByXpath("//div[@class='zy-status-wrapper']");
		System.out.println(verifyMsg);
		Thread.sleep(6000);
		if(verifyMsg.equalsIgnoreCase("Start time is mandatory"))
		{
			for(int i=1;i<=7;i++)
			{
				driver.findElement(By.xpath("(//label[@class='sp-doc-conc-work-hours-switch-label'])["+i+"]")).click();
			}
		}
		driver.findElement(By.xpath(Elements_Doctors.submitSchedule)).click();
		Browser.CheckNotificationMessage("Schedule updated successfully");
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		doctorsPage=new DoctorsPage(driver);
		admin=new NewAdminDoctorsPage(driver);
		driver.get(loginPage_Url);
	}
	
	@AfterClass
	public void closeapp() throws Exception
	{
		driver.quit();
	}
}

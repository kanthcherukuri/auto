package doctorsTestScripts;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Doctors;
import objectRepository.Elements_NewAdminDoctors;

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
		doctorsPage.SignIn(DoctorsLogin_usernamefive, DoctorsLogin_passwordfive);
		Thread.sleep(2000);
		doctorsPage.BulkCancel();
		Browser.CheckNotificationMessage("Appointments cancelled successfully");
		doctorsPage.addclinicSchedule(ohrName, otrClincFee, othrCliNum, linone, otrPin, lon, lat);
		doctorsPage.doctorlogout();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.recipient_IndexAccountIcon);
		driver.get("https://"+Environment_Name+".zoylo.com/login");
		admin.adminSignIn(admin_user, admin_password);
		doctorsPage.deleteOtherClinicFromAdmin(DoctorsLogin_usernamefive);
		admin.click_Profile_Options("Logout");
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.recipient_IndexAccountIcon);
		
		//Deactivate all days break time temporary error cover methods
		driver.get("https://"+Environment_Name+".zoylo.com/login");
		doctorsPage.SignIn(DoctorsLogin_usernamefive, DoctorsLogin_passwordfive);
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
		driver.get("https://"+Environment_Name+".zoylo.com/login");
	}
	
	@AfterClass
	public void closeapp() throws Exception
	{
		driver.quit();
	}
}

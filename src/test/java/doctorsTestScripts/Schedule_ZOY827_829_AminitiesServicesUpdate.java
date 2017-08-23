package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

//@Author: Sagar Sen

public class Schedule_ZOY827_829_AminitiesServicesUpdate extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;
	
	@Test()
	public void aminitiesServicesEdit() throws Exception
	{
		 doctorsPage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
		 Thread.sleep(1000);
		 doctorsPage.editScheduleaminitiesServices("Zoylo Service");
		 Thread.sleep(3000);
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
		driver.quit();
	}
}

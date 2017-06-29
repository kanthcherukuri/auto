package NewAdminScripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_NewAdminDoctors;
import testBase.LoadPropMac;
import testBase.NewAdminDoctorsPage;
import testBase.TestUtils;

//@Author: Sagar Sen

public class Admin_ZOY2293_administratorAddEditCity extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	public String cityName="Xyzname";
	public String stateName="Telangana";
	
	@Test(priority=1)
	public void addCity() throws Exception
	{
		admin.click_AdministratorTab();
		admin.click_cityTab();
		admin.click_doctorReference_AddBtn();
		admin.Enter_cityDetails(cityName, stateName);
		admin.click_citySave();
		Browser.CheckNotificationMessage("City information saved successfully");
		Thread.sleep(5000);
	}
	
	@Test(priority=2)
	public void editCity() throws Exception
	{
		driver.navigate().refresh();
		admin.searchAdministratorReferenceByName(cityName);
		admin.clickEditbutton();
		Browser.waitforElementName(Elements_NewAdminDoctors.administrator_cityName);
		admin.click_citySave();
		Browser.CheckNotificationMessage("City information saved successfully");
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		driver.get(loginPage_Url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties(); // loading the Elements
		Browser= new TestUtils(driver);
		admin=new NewAdminDoctorsPage(driver);
		admin.adminSignIn(admin_user, admin_password);
	}
	
	@AfterClass
	public void closeapp() throws Exception
	{
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "city", "name", cityName);
		driver.quit();
	}
}

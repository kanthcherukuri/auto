package NewAdminScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;



import objectRepository.Elements_NewAdminDoctors;
import testBase.LoadPropMac;
import testBase.NewAdminDoctorsPage;
import testBase.TestUtils;

//Author: Sagar Sen

public class Admin_ZOY2288_administratorAddEditCountry extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	public String countryName="Xyzname";
	public String countryCode="XYZ";
	
	@Test(priority=1)
	public void addCountry() throws Exception
	{
		admin.click_AdministratorTab();
		admin.click_countryTab();
		admin.click_doctorReference_AddBtn();
		admin.Enter_countryDetails(countryCode, countryName);
		admin.click_countrySaveBtn();
		Browser.CheckNotificationMessage("Country created successfully");
	}
	
	@Test(priority=2)
	public void editCountry() throws Exception
	{
		driver.navigate().refresh();
		admin.searchAdministratorReferenceByName(countryCode);
		admin.clickEditbutton();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.administrator_countryEditHeader);
		admin.click_countrySaveBtn();
		Browser.CheckNotificationMessage("Country updated successfully");
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		driver.get("https://"+Environment_Name+".zoylo.com/login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties(); // loading the Elements
		Browser= new TestUtils(driver);
		admin=new NewAdminDoctorsPage(driver);
		admin.adminSignIn(admin_user, admin_password);
	}
	
	@AfterClass
	public void closeapp() throws Exception
	{
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "country", "code", countryCode);
		driver.quit();
	}
}

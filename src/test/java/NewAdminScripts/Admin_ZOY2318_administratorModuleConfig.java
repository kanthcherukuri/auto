package NewAdminScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_NewAdminDoctors;
import testBase.LoadPropMac;
import testBase.NewAdminDoctorsPage;
import testBase.TestUtils;

//@Author: Sagar Sen

public class Admin_ZOY2318_administratorModuleConfig extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	
	@Test()
	public void checkModule() throws Exception
	{
		driver.get(loginPage_Url);
		admin.adminSignIn(admin_user, admin_password);
		admin.click_AdministratorTab();
		admin.click_modulesTab();
		Browser.waitforElementName(Elements_NewAdminDoctors.administrator_moduleHospitalActiveCheckBox);
		driver.findElement(By.name(Elements_NewAdminDoctors.administrator_moduleHospitalActiveCheckBox)).click();
		admin.click_administratorSave();
		Browser.CheckNotificationMessage("Module Config information saved successfully");
		closeapp();
		launchapp();
		admin.checkModuleConfiginIndex();
		driver.get(loginPage_Url);
		admin.adminSignIn(admin_user, admin_password);
		admin.click_AdministratorTab();
		admin.click_modulesTab();
		Browser.waitforElementName(Elements_NewAdminDoctors.administrator_moduleHospitalActiveCheckBox);
		driver.findElement(By.name(Elements_NewAdminDoctors.administrator_moduleHospitalActiveCheckBox)).click();
		admin.click_administratorSave();
		Browser.waitforElementName(Elements_NewAdminDoctors.administrator_moduleHospitalActiveCheckBox);
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties(); // loading the Elements
		Browser= new TestUtils(driver);
		admin=new NewAdminDoctorsPage(driver);
	}
	
	@AfterClass
	public void closeapp() throws Exception
	{
		driver.quit();
	}
}
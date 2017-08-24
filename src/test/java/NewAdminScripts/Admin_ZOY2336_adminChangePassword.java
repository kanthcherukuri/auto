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

public class Admin_ZOY2336_adminChangePassword extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	public String changedPassword;
	public String oldPassword;
	
	@Test()
	public void adminUserChangePassword() throws Exception
	{
		admin.adminSignIn(adminuser_user, adminuser_password);
		oldPassword=adminuser_password;
		System.out.println("The old password is "+oldPassword);
		changedPassword="Zoy12@"+Browser.randomalphabets();
		System.out.println("New password generated is "+changedPassword);
		admin.click_Profile_Options("Change Password");
		admin.Enter_UserChangePasswordDetails(changedPassword);
		admin.click_UserChangePassworSavedBtn();
		Browser.CheckNotificationMessage("Your password has been successfully changed!");
		System.out.println("Password has been changed from "+oldPassword+" to "+changedPassword);
		closeapp();
		launchapp();
		//Login with new password
		admin.adminSignIn(adminuser_user, changedPassword);
		//Reset to old password
		admin.Enter_ResetAdminUserPassword(changedPassword);
		Browser.CheckNotificationMessage("Your password has been successfully changed!");
		System.out.println("Password has been changed from "+changedPassword+" to "+oldPassword);
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties(); // loading the Elements
		Browser= new TestUtils(driver);
		admin=new NewAdminDoctorsPage(driver);
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.quit();
	}
}

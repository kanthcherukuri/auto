package admintestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.AdminPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Admin_ZOY1808_adminChangePassword extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String oldPw = "Zoylo@123";
	public String newPw = "Zoylo@123";
	public String confPw = "Zoylo@123";
	
	@Test()
	public void changePw()
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-align-justify']")).click();
		driver.findElement(By.id("adminChangePasswordLink")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Change Password')]", "Change Password");
		driver.findElement(By.name("oldpassword")).sendKeys(oldPw);
		driver.findElement(By.name("newpassword")).sendKeys(newPw);
		driver.findElement(By.name("confirmpassword")).sendKeys(confPw);
		driver.findElement(By.id("adminChangePasswordButton")).click();
		Browser.waitforTextbyxpath("//div[@class='zy-status-wrapper']", "Your password has been successfully changed!");
	}
	
	@BeforeClass
	public void launchbrowser() throws Exception
	{
		LoadBrowserProperties();
		Elements_Admin.Admin_PageProperties(); // loading the Elements
		Elements_Recipients.Recipients_PageProperties();
		Browser= new TestUtils(driver);
		admin=new AdminPage(driver);
		driver.get(recipient_url);
	}
	
	@AfterClass
	public void closebrowser()
	{
		driver.close();
	}
}

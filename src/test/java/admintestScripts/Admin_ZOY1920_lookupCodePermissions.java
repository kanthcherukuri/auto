package admintestScripts;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.AdminPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Admin_ZOY1920_lookupCodePermissions extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String zqa = "https://zoyloqa.zoylo.com/admin/approveUser";
	public String pit = "https://pit.zoylo.com/admin/approveUser";
	public String lookUpCodezqa = "https://zoyloqa.zoylo.com/admin/lookupCodesList";
	
	@Test(priority=1)
	public void lookupCodeViewPermission() throws Exception
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(adminuser_user);
		Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", adminuser_user);
		driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[6]/button")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'User - Edit')]", "User - Edit");
		driver.findElement(By.name("profile.defaultRole")).click();
		Browser.selectbyName("profile.defaultRole", "VIEW LOOKUP CODE");
		driver.findElement(By.id("updateButton")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		
		closebrowser();
		launchbrowser();
		
		//Admin user login to check lookUpCode view permission
		admin.adminUserSignIn(adminuser_user, adminuser_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(lookUpCodezqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Lookup Codes')]", "Lookup Codes");
		if(driver.findElement(By.xpath("//button[contains(., 'EDIT')]")).isDisplayed())
			{
				driver.findElement(By.id("add")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Add");
				Thread.sleep(6000);
				driver.findElement(By.xpath("//button[contains(., 'EDIT')]")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Edit");
				System.out.println("View permission is working as expected");
			}
		closebrowser();
	}
	
	@Test(priority=2)
	public void lookupCodeEditPermission() throws Exception
	{
		launchbrowser();
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(adminuser_user);
		Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", adminuser_user);
		driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[6]/button")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'User - Edit')]", "User - Edit");
		driver.findElement(By.name("profile.roles.0")).click();
		Browser.selectbyName("profile.roles.0", "EDIT LOOKUP CODE");
		driver.findElement(By.id("updateButton")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		
		closebrowser();
		launchbrowser();
		
		//Admin user login to check lookUpCode edit permission
		admin.adminUserSignIn(adminuser_user, adminuser_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(lookUpCodezqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Lookup Codes')]", "Lookup Codes");
		if(driver.findElement(By.xpath("//button[contains(., 'EDIT')]")).isDisplayed())
			{
				driver.findElement(By.id("add")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Add");
				Thread.sleep(6000);
				driver.findElement(By.xpath("//button[contains(., 'EDIT')]")).click();
				Browser.waitforTextbyxpath("//h4[contains(., 'Lookup Codes - Edit')]", "Lookup Codes - Edit");
				System.out.println("Edit permission is working as expected");
			}
		closebrowser();
	}
	
	@Test(priority=3)
	public void lookupCodeAddPermission() throws Exception
	{
		launchbrowser();
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(adminuser_user);
		Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", adminuser_user);
		driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[6]/button")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'User - Edit')]", "User - Edit");
		driver.findElement(By.name("profile.roles.0")).click();
		Browser.selectbyName("profile.roles.0", "ADD LOOKUP CODE");
		driver.findElement(By.id("updateButton")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		
		closebrowser();
		launchbrowser();
		
		//Admin user login to check lookUpCode add permission
		admin.adminUserSignIn(adminuser_user, adminuser_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(lookUpCodezqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Lookup Codes')]", "Lookup Codes");
		if(driver.findElement(By.xpath("//button[contains(., 'EDIT')]")).isDisplayed())
			{
				driver.findElement(By.xpath("//button[contains(., 'EDIT')]")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Edit");
				Thread.sleep(6000);
				driver.findElement(By.id("add")).click();
				Browser.waitforTextbyxpath("//h4[contains(., 'Lookup Codes - Add')]", "Lookup Codes - Add");
				System.out.println("Edit permission is working as expected");
			}
	}
	
	@BeforeClass
	public void launchbrowser() throws Exception
	{
		LoadBrowserProperties();
		Elements_Admin.Admin_PageProperties(); // loading the Elements
		Elements_Recipients.Recipients_PageProperties();
		Browser= new TestUtils(driver);
		admin=new AdminPage(driver);
		driver.get(loginPage_Url);
	}
	
	@AfterClass
	public void closebrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
}

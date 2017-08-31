package oldAdmintestScripts;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.AdminPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Admin_ZOY1868_requestedDoctorsPermissions extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String zqa = "https://zoyloqa.zoylo.com/admin/approveUser";
	public String pit = "https://pit.zoylo.com/admin/approveUser";
	public String reqdoczqa = "https://zoyloqa.zoylo.com/admin/requestedProvidersList";
	
	@Test(priority=1)
	public void viewReqDoctors() throws Exception
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
		Browser.selectbyName("profile.defaultRole", "VIEW REQUESTED DOCTORS");
		driver.findElement(By.id("updateButton")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		closebrowser();
		launchbrowser();
		
		//Admin user login to check requested doctors view permission
		admin.adminUserSignIn(adminuser_user, adminuser_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(reqdoczqa);
		if(driver.findElement(By.xpath("//th[contains(., 'First Name')]")).isDisplayed())
			{
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Jskak");
				Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", "Jskak");
				driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[12]/button")).click();
				Browser.CheckNotificationMessage("Don't have Permission to View");
				System.out.println("View permission is working as expected");
			}
		closebrowser();
	}
	
	@Test(priority=2)
	public void editReqDoctors() throws Exception
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
		Browser.selectbyName("profile.roles.0", "EDIT REQUESTED DOCTORS");
		driver.findElement(By.id("updateButton")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		
		closebrowser();
		launchbrowser();
		
		//Admin user login to check requested doctors edit permission
		admin.adminUserSignIn(adminuser_user, adminuser_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(reqdoczqa);
		if(driver.findElement(By.xpath("//th[contains(., 'First Name')]")).isDisplayed())
			{
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Jskak");
				Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", "Jskak");
				driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[12]/button")).click();
				Browser.waitforTextbyxpath("//h4[contains(., 'Requested Doctor - Edit')]", "Requested Doctor - Edit");
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

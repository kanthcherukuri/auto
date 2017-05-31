package admintestScripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.AdminPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Admin_ZOY1941_appPropertyPermissions extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String zqa = "https://zoyloqa.zoylo.com/admin/approveUser";
	public String pit = "https://pit.zoylo.com/admin/approveUser";
	public String appPropzqa = "https://zoyloqa.zoylo.com/admin/applicationProperties";
	
	@Test(priority=2)
	public void appPropViewPermission() throws Exception
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
		Browser.selectbyName("profile.defaultRole", "VIEW_APP_PROPERTY");
		driver.findElement(By.id("updateButton")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		
		closebrowser();
		launchbrowser();
		
		//Admin user login to check appProp view permission
		admin.adminUserSignIn(adminuser_user, adminuser_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(appPropzqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Application Properties')]", "Application Properties");
		if(driver.findElements(By.xpath("//button[contains(., 'DELETE')]")).size()>0)
			{
				driver.findElement(By.id("add")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Add");
				Thread.sleep(6000);
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys("ToDelete");
				Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", "ToDelete");
				driver.findElement(By.xpath("//button[contains(., 'EDIT')]")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Edit");
				Thread.sleep(6000);
				driver.findElement(By.xpath("//button[contains(., 'DELETE')]")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Delete.");
				System.out.println("View permission is working as expected");
			}
		closebrowser();
	}
	
	@Test(priority=3)
	public void appPropEditPermission() throws Exception
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
		Browser.selectbyName("profile.roles.0", "EDIT_APP_PROPERTY");
		driver.findElement(By.id("updateButton")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		
		closebrowser();
		launchbrowser();
		
		//Admin user login to check appProp edit permission
		admin.adminUserSignIn(adminuser_user, adminuser_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(appPropzqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Application Properties')]", "Application Properties");
		if(driver.findElements(By.xpath("//button[contains(., 'DELETE')]")).size()!=0)
			{
				driver.findElement(By.id("add")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Add");
				Thread.sleep(6000);
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys("ToDelete");
				Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", "ToDelete");
				driver.findElement(By.xpath("//button[contains(., 'DELETE')]")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Delete.");
				driver.findElement(By.xpath("//button[contains(., 'EDIT')]")).click();
				//Pop up handler
				String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
				String subWindowHandler = null;

				Set<String> handles = driver.getWindowHandles(); // get all window handles
				Iterator<String> iterator = handles.iterator();
				while (iterator.hasNext())
				{
				    subWindowHandler = iterator.next();
				}
				driver.switchTo().window(subWindowHandler);
				Browser.waitforTextbyxpath("//h4[contains(., 'Edit Application Properties')]", "Edit Application Properties");
				driver.switchTo().window(parentWindowHandler);
				System.out.println("Edit permission is working as expected");
			}
		closebrowser();
	}
	
	@Test(priority=1)
	public void appPropAddPermission() throws Exception
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
		Browser.selectbyName("profile.roles.0", "ADD_APP_PROPERTY");
		driver.findElement(By.id("updateButton")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		
		closebrowser();
		launchbrowser();
		
		//Admin user login to check appProp add permission
		admin.adminUserSignIn(adminuser_user, adminuser_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(appPropzqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Application Properties')]", "Application Properties");
		if(driver.findElements(By.xpath("//button[contains(., 'DELETE')]")).size()!=0)
			{
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys("ToDelete");
				Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", "ToDelete");
				driver.findElement(By.xpath("//button[contains(., 'EDIT')]")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Edit");
				Thread.sleep(6000);
				driver.findElement(By.xpath("//button[contains(., 'DELETE')]")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Delete.");
				Thread.sleep(6000);
				driver.findElement(By.id("add")).click();
				//Pop up handler
				String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
				String subWindowHandler = null;

				Set<String> handles = driver.getWindowHandles(); // get all window handles
				Iterator<String> iterator = handles.iterator();
				while (iterator.hasNext())
				{
				    subWindowHandler = iterator.next();
				}
				driver.switchTo().window(subWindowHandler);
				Browser.waitforTextbyxpath("//h4[contains(., 'Add Application Properties')]", "Add Application Properties");
				driver.switchTo().window(parentWindowHandler);
				System.out.println("Add permission is working as expected");
			}
		closebrowser();
	}
	
	@Test(priority=4)
	public void appPropDeletePermission() throws Exception
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
		Browser.selectbyName("profile.roles.0", "DELETE_APP_PROPERTY");
		driver.findElement(By.id("updateButton")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		
		closebrowser();
		launchbrowser();
		
		//Admin user login to check appProp delete permission
		admin.adminUserSignIn(adminuser_user, adminuser_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(appPropzqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Application Properties')]", "Application Properties");
		if(driver.findElements(By.xpath("//button[contains(., 'DELETE')]")).size()>0)
			{
				driver.findElement(By.id("add")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Add");
				Thread.sleep(6000);
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys("ToDelete");
				Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", "ToDelete");
				driver.findElement(By.xpath("//button[contains(., 'EDIT')]")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Edit");
				Thread.sleep(6000);
				driver.findElement(By.xpath("//button[contains(., 'DELETE')]")).click();
				//Pop up handler
				String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
				String subWindowHandler = null;

				Set<String> handles = driver.getWindowHandles(); // get all window handles
				Iterator<String> iterator = handles.iterator();
				while (iterator.hasNext())
				{
				    subWindowHandler = iterator.next();
				}
				driver.switchTo().window(subWindowHandler);
				Browser.waitforTextbyxpath("//h4[contains(., 'Delete Application Properties')]", "Delete Application Properties");
				driver.switchTo().window(parentWindowHandler);
				System.out.println("Delete permission is working as expected");
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
		driver.get(recipient_url);
	}
	
	@AfterClass
	public void closebrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
}

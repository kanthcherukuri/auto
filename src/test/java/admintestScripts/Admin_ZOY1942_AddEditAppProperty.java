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

public class Admin_ZOY1942_AddEditAppProperty extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String zqa = "https://zoyloqa.zoylo.com/admin/approveUser";
	public String pit = "https://pit.zoylo.com/admin/approveUser";
	public String appPropzqa = "https://zoyloqa.zoylo.com/admin/applicationProperties";
	public String key="Azure";
	public String stringValue="GiveMeSomething";
	
	@Test(priority=1)
	public void addAppProp()
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(appPropzqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Application Properties')]", "Application Properties");
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
				driver.switchTo().window(subWindowHandler); // switch to popup window
				Browser.waitforTextbyxpath("//h4[contains(., 'Add Application Properties')]", "Add Application Properties");
				driver.findElement(By.id("applicationPropertiesKeys")).sendKeys(key);
				driver.findElement(By.id("applicationPropertiesValue")).sendKeys(stringValue);
				driver.findElement(By.id("applicationPropertiesSubmit")).click();	
				driver.switchTo().window(parentWindowHandler);  // switch back to parent window
				Browser.CheckNotificationMessage("Added Successfully");
	}
	
	@Test(priority=2)
	public void editAppProp()
	{
		driver.getCurrentUrl();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(key);
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

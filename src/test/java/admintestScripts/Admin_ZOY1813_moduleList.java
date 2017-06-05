package admintestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.AdminPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Admin_ZOY1813_moduleList extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String zqa = "https://zoyloqa.zoylo.com/admin/moduleList";
	public String pit = "https://pit.zoylo.com/admin/moduleList";
	
	@Test()
	public void module() throws Exception
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Available Modules')]", "Available Modules");
		driver.findElement(By.name("modules.2.isActive")).click();
		Browser.scrollbyName("modules.24.isActive");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Browser.waitFortheElementXpath("//div[@class='zy-status-wrapper']");
		//Browser.waitforTextbyxpath("//div[@class='zy-status-wrapper']", "Module Config information saved successfully");
		//Logout
		//Thread.sleep(6000);
		closebrowser();
		//driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
//		Browser.waitFortheID("logout");
//		driver.findElement(By.id("logout")).click();
		
		launchbrowser();
		driver.get(index_url);
		Browser.waitforTextbyxpath("//span[contains(., 'DOCTORS')]", "DOCTORS");
		if(driver.findElement(By.xpath("//span[contains(., 'HOSPITALS')]")).isDisplayed())
		{
			//Browser.waitforTextbyxpath("//span[contains(., 'HOSPITALS')]", "HOSPITALS");
			System.out.println("Hospitals is visible as it is activated in module config");
		}
		else
		{
			System.out.println("Hospitals is not visible as it is not activated in module config");
		}
		driver.get(recipient_url);
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Available Modules')]", "Available Modules");
		driver.findElement(By.name("modules.2.isActive")).click();
		Browser.scrollbyName("modules.24.isActive");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Browser.waitforTextbyxpath("//div[@class='zy-status-wrapper']", "Module Config information saved successfully");
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

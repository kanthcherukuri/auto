package admintestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.AdminPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Admin_ZOY1750_ref_AddState extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String zqa = "https://zoyloqa.zoylo.com/admin/stateList";
	public String pit = "https://pit.zoylo.com/admin/stateList";
	public String stateCode="JUNEONESTATE";
	public String stateName="Testsnine";
	public String country="India";
	
	@Test()
	public void addState()
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'States')]", "States");
		driver.findElement(By.id("add")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'State - Add')]", "State - Add");
		driver.findElement(By.name("code")).sendKeys(stateCode);
		driver.findElement(By.name("name")).sendKeys(stateName);
		driver.findElement(By.xpath("//span[@aria-labelledby='select2-newCountryForStateOptions-container']")).click();
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys(country);
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'States')]", "States");
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

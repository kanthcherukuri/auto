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

public class Admin_ZOY1751_ref_EditState extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String zqa = "https://zoyloqa.zoylo.com/admin/stateList";
	public String pit = "https://pit.zoylo.com/admin/stateList";
	public String stateCode="JUNEGIVESTATE";
	
	@Test()
	public void editState()
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'States')]", "States");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(stateCode);
		Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", stateCode);
		driver.findElement(By.id("stateEdit")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'State - Edit')]", "State - Edit");
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
	public void closebrowser()
	{
		driver.close();
	}
}

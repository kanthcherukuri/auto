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

public class Admin_ZOY1807_editMarketingElements extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String zqa="https://zoyloqa.zoylo.com/admin/marketingElements";
	public String pit="https://pit.zoylo.com/admin/marketingElements";
	public String marketHtML = "ZEETA";
	
	@Test
	public void editMarketing()
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		//Change environment
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Marketing Elements')]", "Marketing Elements");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(marketHtML);
		Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[2]", marketHtML);
		driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[4]/button")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Marketing Element - Edit')]", "Marketing Element - Edit");
		driver.findElement(By.name("isActive")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Marketing Elements')]", "Marketing Elements");
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

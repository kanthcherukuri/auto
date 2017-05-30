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

public class Admin_ZOY1748_ref_AddCountry extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String zqa = "https://zoyloqa.zoylo.com/admin/countryList";
	public String pit = "https://pit.zoylo.com/admin/countryList";
	public String countryCode="THREEZEROMAYCOUN";
	public String countryName="Threezeromaycountry";
	
	@Test()
	public void addCountry()
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Countries')]", "Countries");
		driver.findElement(By.id("add")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Country - Add')]", "Country - Add");
		driver.findElement(By.name("code")).sendKeys(countryCode);
		driver.findElement(By.name("name")).sendKeys(countryName);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Countries')]", "Countries");
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

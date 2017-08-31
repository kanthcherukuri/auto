package oldAdmintestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.AdminPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Admin_ZOY1754_ref_EditCity extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String zqa = "https://zoyloqa.zoylo.com/admin/cityList";
	public String pit = "https://pit.zoylo.com/admin/cityList";
	public String cityName="Junefivecity";
	
	@Test()
	public void editCity() throws InterruptedException
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Cities')]", "Cities");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(cityName);
		Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", cityName);
		driver.findElement(By.id("cityEdit")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'City - Edit')]", "City - Edit");
		Browser.scrollbyxpath("//h3[contains(., 'Diagnostic Centre Seo Information')]");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Cities')]", "Cities");
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
	public void closebrowser()
	{
		driver.close();
	}
	
	
}

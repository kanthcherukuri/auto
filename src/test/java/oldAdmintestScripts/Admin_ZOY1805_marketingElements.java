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

public class Admin_ZOY1805_marketingElements extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String zqa="https://zoyloqa.zoylo.com/admin/marketingElements";
	public String pit="https://pit.zoylo.com/admin/marketingElements";
	public String marketHtML = "IPHONE";
	public String htmlDesc = "Description section of the marketing element name is here.";
	
	@Test()
	public void marketElements()
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		//Change environment
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Marketing Elements')]", "Marketing Elements");
		driver.findElement(By.id("add")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Marketing Element - Add')]", "Marketing Element - Add");
		driver.findElement(By.name("marketingHtml")).sendKeys(marketHtML);
		driver.findElement(By.xpath("//input[@data-schema-key='description']")).sendKeys(htmlDesc);
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
		driver.get(loginPage_Url);
	}
	
	@AfterClass
	public void closebrowser()
	{
		driver.close();
	}
}

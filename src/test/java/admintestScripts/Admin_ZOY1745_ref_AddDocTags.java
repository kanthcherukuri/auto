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

public class Admin_ZOY1745_ref_AddDocTags extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String zqa = "https://zoyloqa.zoylo.com/admin/providerTagList";
	public String pit = "https://pit.zoylo.com/admin/providerTagList";
	public String tagName="Tagtwo";
	
	@Test()
	public void addDocTag()
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Doctor - Professional Tags')]", "Doctor - Professional Tags");
		driver.findElement(By.id("add")).click();
		Browser.waitforTextbyxpath("//label[contains(., 'Tag Name')]", "Tag Name");
		driver.findElement(By.name("name")).sendKeys(tagName);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Doctor - Professional Tags')]", "Doctor - Professional Tags");
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

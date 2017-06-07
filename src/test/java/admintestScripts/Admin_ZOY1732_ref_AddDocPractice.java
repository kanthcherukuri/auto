package admintestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.AdminPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Admin_ZOY1732_ref_AddDocPractice extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String zqa = "https://zoyloqa.zoylo.com/admin/lineOfPracticeList";
	public String pit = "https://pit.zoylo.com/admin/lineOfPracticeList";
	public String lopName="Junefivelop";
	
	@Test()
	public void addDocPractice() throws Exception
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Doctor - Practices')]", "Doctor - Practices");
		driver.findElement(By.id("add")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Doctor Practice - Add')]", "Doctor Practice - Add");
		driver.findElement(By.name("name")).sendKeys(lopName);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Browser.waitforTextbyxpath("//h4[contains(., 'Doctor - Practices')]", "Doctor - Practices");
		Thread.sleep(2000);
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

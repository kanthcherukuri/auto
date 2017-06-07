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

public class Admin_ZOY1747_ref_EditDocTags extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String zqa = "https://zoyloqa.zoylo.com/admin/providerTagList";
	public String pit = "https://pit.zoylo.com/admin/providerTagList";
	public String tagName="Junefivetag";
	
	@Test()
	public void editDocTag()
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Doctor - Professional Tags')]", "Doctor - Professional Tags");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(tagName);
		Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", tagName);
		driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[4]/button")).click();
		Browser.waitforTextbyxpath("//label[contains(., 'Tag Name')]", "Tag Name");
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
	public void closebrowser()
	{
		driver.close();
	}
}

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

public class Admin_ZOY1741_ref_EditDocQualification extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String zqa = "https://zoyloqa.zoylo.com/admin/doctorQualificationList";
	public String pit = "https://pit.zoylo.com/admin/doctorQualificationList";
	public String quaName="JUNEFIVEQUA";
	
	@Test()
	public void editDocQualification() throws Exception
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Doctor - Qualifications')]", "Doctor - Qualifications");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(quaName);
		Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", quaName);
		driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[4]/button")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Doctor Qualification - Edit')]", "Doctor Qualification - Edit");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Doctor - Qualifications')]", "Doctor - Qualifications");
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
		driver.get(loginPage_Url);
	}
	
	@AfterClass
	public void closebrowser()
	{
		driver.close();
	}
}

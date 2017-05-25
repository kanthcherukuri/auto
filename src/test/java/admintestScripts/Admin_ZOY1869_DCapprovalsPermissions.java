package admintestScripts;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.AdminPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Admin_ZOY1869_DCapprovalsPermissions extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String zqa = "https://zoyloqa.zoylo.com/admin/approveUser";
	public String pit = "https://pit.zoylo.com/admin/approveUser";
	public String DCappzqa = "https://zoyloqa.zoylo.com/admin/zyDiagnosticCenterPackagesAndTestApprovalsList";
	public String editData = "Kormangal";
	
	@Test(priority=1)
	public void DCapprovalsViewPermission() throws Exception
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(adminuser_user);
		Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", adminuser_user);
		driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[6]/button")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'User - Edit')]", "User - Edit");
		driver.findElement(By.name("profile.defaultRole")).click();
		Browser.selectbyName("profile.defaultRole", "VIEW DC APPROVALS");
		driver.findElement(By.id("updateButton")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		closebrowser();
		launchbrowser();
		
		//Admin user login to check DC approvals view permission
		admin.adminUserSignIn(adminuser_user, adminuser_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(DCappzqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Diagnostic Approvals')]", "Diagnostic Approvals");
		if(driver.findElement(By.xpath("//th[contains(., 'Date & Time')]")).isDisplayed())
			{
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys(editData);
				Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[3]", editData);
				driver.findElement(By.xpath("//input[@class='updatedCharges']")).clear();
				driver.findElement(By.xpath("//input[@class='updatedCharges']")).sendKeys("10");
				driver.findElement(By.xpath("//input[@type='search']")).click();
				Thread.sleep(6000);
				driver.findElement(By.xpath("//button[contains(., 'Approve')]")).click();
				Browser.CheckNotificationMessage("Failed to Approved: Unauthorized to Approve");
				System.out.println("View permission is working as expected");
			}
		closebrowser();
	}
	
	@Test(priority=2)
	public void DCapprovalsEditPermission() throws Exception
	{
		launchbrowser();
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(adminuser_user);
		Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", adminuser_user);
		driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[6]/button")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'User - Edit')]", "User - Edit");
		driver.findElement(By.name("profile.roles.0")).click();
		Browser.selectbyName("profile.roles.0", "EDIT DC APPROVALS");
		driver.findElement(By.id("updateButton")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		
		closebrowser();
		launchbrowser();
		
		//Admin user login to check DC approvals edit permission
		admin.adminUserSignIn(adminuser_user, adminuser_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(DCappzqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Diagnostic Approvals')]", "Diagnostic Approvals");
		if(driver.findElement(By.xpath("//th[contains(., 'Date & Time')]")).isDisplayed())
			{
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys(editData);
				Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[3]", editData);
				driver.findElement(By.xpath("//input[@class='updatedCharges']")).clear();
				driver.findElement(By.xpath("//input[@class='updatedCharges']")).sendKeys("10");
				driver.findElement(By.xpath("//input[@type='search']")).click();
				Thread.sleep(6000);
				driver.findElement(By.xpath("//button[contains(., 'Approve')]")).click();
				Browser.CheckNotificationMessage("Diagnostic Center package/test approved successfully");
				System.out.println("Edit permission is working as expected");
			}
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

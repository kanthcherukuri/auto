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

public class Admin_ZOY1875_DocAppointmentPermissions extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String zqa = "https://zoyloqa.zoylo.com/admin/approveUser";
	public String pit = "https://pit.zoylo.com/admin/approveUser";
	public String docAptzqa = "https://zoyloqa.zoylo.com/admin/appointmentsView";
	
	@Test(priority=1)
	public void docAptViewPermission() throws Exception
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
		Browser.selectbyName("profile.defaultRole", "VIEW APPOINTMENT DETAILS");
		driver.findElement(By.id("updateButton")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		closebrowser();
		launchbrowser();
		
		//Admin user login to check doctor appointment view permission
		admin.adminUserSignIn(adminuser_user, adminuser_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(docAptzqa);
		Browser.waitforTextbyxpath("//div[@class='panel-heading text-left adminListHeader']//h4[contains(., 'Appointments')]", "Appointments");
		if(driver.findElement(By.xpath("//th[contains(., 'Appointment ID')]")).isDisplayed())
			{
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys("9966775890");
				Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[3]", "+919966775890");
				Browser.scrollbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[18]/button");
				Browser.horizontalScroll();
				driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[18]/button")).click();
				Browser.CheckNotificationMessage("Permission Denied");
				System.out.println("View permission is working as expected");
			}
		closebrowser();
	}
	
	@Test(priority=2)
	public void DocAptEditPermission() throws Exception
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
		Browser.selectbyName("profile.roles.0", "EDIT APPOINTMENT");
		driver.findElement(By.id("updateButton")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		
		closebrowser();
		launchbrowser();
		
		//Admin user login to check doctor appointment edit permission
		admin.adminUserSignIn(adminuser_user, adminuser_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(docAptzqa);
		Browser.waitforTextbyxpath("//div[@class='panel-heading text-left adminListHeader']//h4[contains(., 'Appointments')]", "Appointments");
		if(driver.findElement(By.xpath("//th[contains(., 'Appointment ID')]")).isDisplayed())
			{
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys("9966775890");
				Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[3]", "+919966775890");
				Browser.scrollbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[18]/button");
				Browser.horizontalScroll();
				driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[18]/button")).click();
				Browser.CheckNotificationMessage("Email/SMS Notification sent to the Patient");
				System.out.println("View permission is working as expected");
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

package oldAdmintestScripts;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.AdminPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Admin_ZOY1887_transactionPermissions extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String zqa = "https://zoyloqa.zoylo.com/admin/approveUser";
	public String pit = "https://pit.zoylo.com/admin/approveUser";
	public String payConfigzqa = "https://zoyloqa.zoylo.com/admin/paymentGatewayServiceConfigList";
	public String payListzqa="https://zoyloqa.zoylo.com/admin/paymentList";
	
	@Test(priority=1)
	public void payConfigViewPermission() throws Exception
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
		Browser.selectbyName("profile.defaultRole", "VIEW PAYMENT CONFIG");
		driver.findElement(By.id("updateButton")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		
		closebrowser();
		launchbrowser();
		
		//Admin user login to check payment config view permission
		admin.adminUserSignIn(adminuser_user, adminuser_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(payConfigzqa);
		Browser.waitforTextbyxpath("//div[@class='panel-heading text-left adminListHeader']//h4[contains(., 'Payment Gateway')]", "Payment Gateway");
		Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[1]", "ICICI");
		driver.get(payListzqa);
		if(driver.findElement(By.xpath("//td[contains(., 'No data available in table')]")).isDisplayed())
		{
			System.out.println("View permission is working as expected");
		}
		closebrowser();
	}
	
	@Test(priority=2)
	public void payListViewPermission() throws Exception
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
		driver.findElement(By.name("profile.defaultRole")).click();
		Browser.selectbyName("profile.defaultRole", "VIEW PAYMENT DETAILS");
		driver.findElement(By.id("updateButton")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		
		closebrowser();
		launchbrowser();
		
		//Admin user login to check payment details view permission
		admin.adminUserSignIn(adminuser_user, adminuser_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(payListzqa);
		Browser.waitforTextbyxpath("//div[@class='panel-heading text-left adminListHeader']//h4[contains(., 'Payments')]", "Payments");
		Browser.waitFortheElementXpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[1]");
		driver.get(payConfigzqa);
		if(driver.findElement(By.xpath("//td[contains(., 'No data available in table')]")).isDisplayed())
		{
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
		driver.get(loginPage_Url);
	}
	
	@AfterClass
	public void closebrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
}

package oldAdmintestScripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.AdminPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Admin_ZOY1877_reviewPermissions extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String reviewStat = "Approve"; //Reject and Approve
	public String zqa = "https://zoyloqa.zoylo.com/admin/approveUser";
	public String pit = "https://pit.zoylo.com/admin/approveUser";
	public String pendingReviewszqa = "https://zoyloqa.zoylo.com/admin/pendingReviewsList";
	public String approvedReviewstzqa = "https://zoyloqa.zoylo.com/admin/approvedReviewsList";
	public String rejectReviewstzqa = "https://zoyloqa.zoylo.com/admin/rejectedReviewsList";
	
	@Test(priority=1)
	public void pendingRvViewPermission() throws Exception
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
		Browser.selectbyName("profile.defaultRole", "VIEW REVIEWS");
		driver.findElement(By.id("updateButton")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		closebrowser();
		launchbrowser();
		
		//Admin user login to check review view permission
		admin.adminUserSignIn(adminuser_user, adminuser_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(pendingReviewszqa);
		Browser.waitforTextbyxpath("//div[@class='panel-heading text-left adminListHeader']//h4[contains(., 'Reviews - Pending')]", "Reviews - Pending");
		if(driver.findElement(By.xpath("//th[contains(., 'Date & Time')]")).isDisplayed())
			{
				Browser.waitFortheElementXpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[6]/button");
				driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[6]/button")).click();
				
				//Pop up handler
				String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
				String subWindowHandler = null;

				Set<String> handles = driver.getWindowHandles(); // get all window handles
				Iterator<String> iterator = handles.iterator();
				while (iterator.hasNext())
				{
				    subWindowHandler = iterator.next();
				}
				driver.switchTo().window(subWindowHandler); // switch to popup window
				Thread.sleep(1000);                         // perform operations on popup
				if(reviewStat.equalsIgnoreCase("Reject"))
				{
					driver.findElement(By.id("reject")).click();
				}
				else
				{
					driver.findElement(By.id("approve")).click();
				}
				
				driver.switchTo().window(parentWindowHandler);  // switch back to parent window
				
				Browser.CheckNotificationMessage("Permission Denied");
				System.out.println("View permission is working as expected");
			}
		closebrowser();
	}
	
	@Test(priority=2)
	public void pendingRvEditPermission() throws Exception
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
		Browser.selectbyName("profile.roles.0", "EDIT REVIEW");
		driver.findElement(By.id("updateButton")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		
		closebrowser();
		launchbrowser();
		//Admin user login to check review edit permission
		admin.adminUserSignIn(adminuser_user, adminuser_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(pendingReviewszqa);
		Browser.waitforTextbyxpath("//div[@class='panel-heading text-left adminListHeader']//h4[contains(., 'Reviews - Pending')]", "Reviews - Pending");
		if(driver.findElement(By.xpath("//th[contains(., 'Date & Time')]")).isDisplayed())
			{
				Browser.waitFortheElementXpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[6]/button");
				driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[6]/button")).click();
				
				//Pop up handler
				String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
				String subWindowHandler = null;
				Set<String> handles = driver.getWindowHandles(); // get all window handles
				Iterator<String> iterator = handles.iterator();
				while (iterator.hasNext())
					{
				    	subWindowHandler = iterator.next();
					}
				driver.switchTo().window(subWindowHandler); // switch to popup window
				Thread.sleep(1000);                         // perform operations on popup
				if(reviewStat.equalsIgnoreCase("Reject"))
					{
						driver.findElement(By.id("reject")).click();
					}
						else
							{
								driver.findElement(By.id("approve")).click();
							}
						
				driver.switchTo().window(parentWindowHandler);  // switch back to parent window
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
		driver.get(loginPage_Url);
	}
	
	@AfterClass
	public void closebrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
}

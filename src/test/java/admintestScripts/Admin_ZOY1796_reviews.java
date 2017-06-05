package admintestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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

public class Admin_ZOY1796_reviews extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	public String reviewStat = "Approve"; //Reject and Approve
	
	//Global variables for pre-condition values
	public String zqa="https://zoyloqa.zoylo.com/admin/pendingReviewsList";
	public String pit="https://pit.zoylo.com/admin/pendingReviewsList";
	
	@Test()
	public void reviews() throws InterruptedException
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Reviews - Pending')]", "Reviews - Pending");
		
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
		Thread.sleep(5000);
		
		
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

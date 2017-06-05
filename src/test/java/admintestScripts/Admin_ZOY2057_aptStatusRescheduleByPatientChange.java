package admintestScripts;

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

public class Admin_ZOY2057_aptStatusRescheduleByPatientChange extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;

	//Global variables for pre condition values
	public String zqaApt="https://zoyloqa.zoylo.com/admin/appointmentsView";
	
	public String status = "Reschedule By Patient"; // Reschedule By Patient OR Reschedule By Doctor
	public String aptID = "APT-005809";
	
	@Test()
	public void aptStatusChange() throws InterruptedException
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(zqaApt);
		Browser.waitforTextbyxpath("//div[@class='panel-heading text-left adminListHeader']//h4[contains(., 'Appointments')]", "Appointments");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(aptID);
		Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", aptID);
		if(driver.findElement(By.xpath("(//select[@class='appointmentsStatusChangeId'])[1]")).isDisplayed())
		{
			Browser.scrollbyxpath("(//select[@class='appointmentsStatusChangeId'])[1]");
			Browser.horizontalScroll();
			//driver.findElement(By.xpath("(//select[@class='appointmentsStatusChangeId'])[1]")).click();
			Thread.sleep(2000);
			Browser.selectbyXpath("(//select[@class='appointmentsStatusChangeId'])[1]", status);
			if(status.contains("Reschedule By Patient") || status.contains("Reschedule By Doctor"))
			{
				Browser.selectbyXpath("(//select[@class='appointmentsStatusChangeId'])[1]", status);
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
				Thread.sleep(2000);                         // perform operations on popup
				driver.findElement(By.id("cd-0")).click(); //Click today
				driver.findElement(By.id("session1")).click();
				//Morning
				if(driver.findElements(By.xpath("(//span[@class='slotmsg'])[1]")).size()!=0)
				{
					Thread.sleep(1000);
					driver.findElement(By.id("session1")).click();
					Thread.sleep(3000);
					driver.findElement(By.id("session2")).click(); //Choose afternoon
					//Afternoon
					if(driver.findElements(By.xpath("(//span[@class='slotmsg'])[2]")).size()!=0)
					{
						Thread.sleep(1000);
						driver.findElement(By.id("session2")).click();
						Thread.sleep(3000);
						driver.findElement(By.id("session3")).click(); //Choose evening
						//Evening
						if(driver.findElements(By.xpath("(//span[@class='slotmsg'])[3]")).size()!=0)
						{
							Thread.sleep(1000);
							driver.findElement(By.id("session3")).click();
							Thread.sleep(3000);
							driver.findElement(By.id("session4")).click(); //Choose night
							//night
							if(driver.findElements(By.xpath("(//span[@class='slotmsg'])[4]")).size()!=0)
							{
								System.out.println("No slots available for current day");
							}
							else
							{
								driver.findElement(By.xpath("(//*[@id='apponitmentTime' and @class='sp-available-slots'])[1]")).click(); //Choose time slot
								Browser.CheckNotificationMessage("Successfully changed the appointment slot");
								System.out.println("Reschedule is night session");
							}
						}
						else
						{
							driver.findElement(By.xpath("(//*[@id='apponitmentTime' and @class='sp-available-slots'])[1]")).click(); //Choose time slot
							Browser.CheckNotificationMessage("Successfully changed the appointment slot");
							System.out.println("Reschedule is evening session");
						}
					}
					else
					{
						driver.findElement(By.xpath("(//*[@id='apponitmentTime' and @class='sp-available-slots'])[1]")).click(); //Choose time slot
						Browser.CheckNotificationMessage("Successfully changed the appointment slot");
						System.out.println("Reschedule is afternoon session");
					}
				}
				else
				{
					driver.findElement(By.xpath("(//*[@id='apponitmentTime' and @class='sp-available-slots'])[1]")).click(); //Choose time slot
					Browser.CheckNotificationMessage("Successfully changed the appointment slot");
					System.out.println("Reschedule is morning session");
				}
				
				driver.switchTo().window(parentWindowHandler);  // switch back to parent window
				
			}
		}
		else
		{
			System.out.println("Status change select box is not available");
		}
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Elements_Admin.Admin_PageProperties(); // loading the Elements
		Elements_Recipients.Recipients_PageProperties();
		Browser= new TestUtils(driver);
		admin=new AdminPage(driver);
		driver.get(recipient_url);
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.close();
	}
}

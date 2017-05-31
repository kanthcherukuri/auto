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

public class Admin_ZOY2086_aptStatusChangeToCompleted extends LoadPropMac {
	public TestUtils Browser;
	public AdminPage admin;
	// Global variables for pre condition values
	public String zqaApt = "https://zoyloqa.zoylo.com/admin/appointmentsView";
	public String status = "Completed";
	public String aptID = "APT-015972";

	@Test()
	public void aptCancel() throws Exception {
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(zqaApt);
		Browser.waitforTextbyxpath(
				"//div[@class='panel-heading text-left adminListHeader']//h4[contains(., 'Appointments')]",
				"Appointments");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(aptID);
		Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", aptID);
		if (driver.findElements(By.xpath("(//select[@class='appointmentsStatusChangeId'])[1]")).size() != 0) {
			Browser.scrollbyxpath("(//select[@class='appointmentsStatusChangeId'])[1]");
			Browser.horizontalScroll();
			Thread.sleep(2000);
			if (status.contains("Completed")) {
				Browser.selectbyXpath("(//select[@class='appointmentsStatusChangeId'])[1]", status);
				String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
				String subWindowHandler = null;
				Set<String> handles = driver.getWindowHandles(); // get all window handles
				Iterator<String> iterator = handles.iterator();
				while (iterator.hasNext()) {
					subWindowHandler = iterator.next();
				}
				driver.switchTo().window(subWindowHandler); // switch to popup window
				Thread.sleep(2000); // perform operations on popup

				driver.findElement(By.id("submitCompleted")).click();
				driver.switchTo().window(parentWindowHandler); // switch back to
																// parent window
				Browser.CheckNotificationMessage("Appointment checked out successfully");
			}
		} else {
			System.out.println("Status change select box is not available");
		}
	}

	@BeforeClass
	public void launchapp() throws Exception {
		LoadBrowserProperties();
		Elements_Admin.Admin_PageProperties(); // loading the Elements
		Elements_Recipients.Recipients_PageProperties();
		Browser = new TestUtils(driver);
		admin = new AdminPage(driver);
		driver.get(recipient_url);
	}

	@AfterClass
	public void closeapp() {
		driver.close();
	}
}
package admintestScripts;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.AdminPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Admin_ZOY1541_changePasswordOFdoctor extends LoadPropMac
{
	public AdminPage admin;
	public TestUtils Browser;
	
	@DataProvider(name="editDocDetails")
	public Object[][] details()
	{
		return new Object[][]
				{
					{"source@gmail.com"}
				};
	}
	
	@Test(dataProvider="editDocDetails")
	public void editdoctor(String docID) throws InterruptedException
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(docID);
		
		Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", docID);
		
		driver.findElement(By.xpath("//button[contains(., 'EDIT')]")).click();
		
		Browser.waitFortheElementXpath("//h4[contains(., 'Doctor - Edit')]");
		//Browser.scrollbyID(Elements_Admin.button_DoctorSave);
		driver.findElement(By.id("changePassword")).click();
		Browser.scrollbyxpath("//h4[contains(., 'Doctor - Change Password')]");
		
		driver.findElement(By.id("newPassword")).sendKeys("Zoylo@123");
		driver.findElement(By.id("confirmPassword")).sendKeys("Zoylo@123");
		driver.findElement(By.id("changePassword")).click();
		
		try {
			Browser.waitFortheID("add");
			System.out.println("Doctor ID "+docID+" password changed");
		} catch (Exception e) {
			System.out.println("Doctor ID "+docID+" password change failed");
		}
		
		
	}
	
	@BeforeClass
	public void lauchBrowser() throws Exception
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
package admintestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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

public class Admin_ZOY1712_editHospital extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre-condition values
		public String zqa="https://zoyloqa.zoylo.com/admin/hospitalList";
		public String pit="https://pit.zoylo.com/admin/hospitalList";
	
	@DataProvider(name="editHop")
	public Object[][] editDataHop()
	{
		return new Object[][]
				{
					{"Eighteenhospital", "Eighteenhospital"}
				};
	}
	
	@Test(dataProvider="editDataHop")
	public void editHop(String hopName, String hopVerify) throws Exception
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Hospitals')]", "Hospitals");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(hopName);
		
		Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", hopVerify);
		driver.findElement(By.xpath("//button[contains(., 'EDIT')]")).click();
		
		Browser.waitforTextbyxpath("//h4[contains(., 'Hospital - Edit')]", "Hospital - Edit");
		Browser.scrollbyID("submitCancel");
		Browser.waitforTextbyxpath("//button[@type='submit']", "Save");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		try {
			Browser.waitFortheID("add");
			System.out.println("Hospital "+hopVerify+" saved");
		} catch (Exception e) {
			System.out.println("Hospital "+hopVerify+" save failed");
		}
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
		driver.get(recipient_url);
	}
	
	@AfterClass
	public void closebrowser() throws InterruptedException
	{
		driver.close();
	}
}

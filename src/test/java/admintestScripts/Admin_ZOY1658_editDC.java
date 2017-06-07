package admintestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.AdminPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Admin_ZOY1658_editDC extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String emailID="june05_1dc@zoylo.com";
	public String zqa="https://zoyloqa.zoylo.com/admin/zyDiagnosticCenters";
	public String pit="https://pit.zoylo.com/admin/zyDiagnosticCenters";
	
	@DataProvider(name="userDetails")
	public Object[][] userGeneric()
	{
		return new Object[][]
				{
					{emailID}
			
				};
	}
	
	@Test(dataProvider="userDetails")
	public void editDCsave(String dcEmail) throws Exception
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		//Change environment
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Diagnostic Center')]", "Diagnostic Center");
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(dcEmail);
		Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[3]", dcEmail);
		driver.findElement(By.xpath("//button[@class='btn btn-xs edit-btn']")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Diagnostic Center - Edit')]", "Diagnostic Center - Edit");
		
		Browser.scrollbyxpath("//*[@class='pull-right']//*[text()='Save']");
		driver.findElement(By.xpath("//*[@class='pull-right']//*[text()='Save']")).click();
		
		Browser.waitFortheElementXpath("html/body/div[6]/div/div/div/div[2]/div/div[1]/div[1]/h4");
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
	public void closebrowser()
	{
		driver.close();
	}
	
}

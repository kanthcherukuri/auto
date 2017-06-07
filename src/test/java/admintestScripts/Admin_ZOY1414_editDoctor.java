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

public class Admin_ZOY1414_editDoctor extends LoadPropMac
{
	public AdminPage admin;
	public TestUtils Browser;
	
	//Global variables for pre condition values
	public String email="sss1@gmail.com";
	
	@DataProvider(name="editDocDetails")
	public Object[][] details()
	{
		return new Object[][]
				{
					{email}
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
		driver.findElement(By.id(Elements_Admin.button_DoctorSave)).click();
		Thread.sleep(5000);
		
		try {
			Browser.waitFortheID("add");
			System.out.println("Doctor ID "+docID+" saved");
		} catch (Exception e) {
			System.out.println("Doctor ID "+docID+" save failed");
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

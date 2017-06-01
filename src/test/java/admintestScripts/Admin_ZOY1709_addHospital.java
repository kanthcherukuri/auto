package admintestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.AdminPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Admin_ZOY1709_addHospital extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre-condition values
	public String zqa="https://zoyloqa.zoylo.com/admin/hospitalList";
	public String pit="https://pit.zoylo.com/admin/hospitalList";
	public String hopName="Junehospitalone";
	public String shortHopName="Junehopone";
	
	
	@DataProvider(name="hospitalDetails")
	public Object[][] hopDetails()
	{
		return new Object[][]
				{
					{hopName, shortHopName, "India", "Telangana", "Hyderabad"}
				};
	}
	
	@Test(dataProvider="hospitalDetails", priority=1)
	public void addHop(String hopname, String shorthopname, String country, String state, String city) throws InterruptedException
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Hospitals')]", "Hospitals");
		driver.findElement(By.id("add")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Hospital - Add')]", "Hospital - Add");
		driver.findElement(By.name("name")).sendKeys(hopname);
		driver.findElement(By.name("shortName")).sendKeys(shorthopname);
		driver.findElement(By.name("addressLine1")).sendKeys("404, Address line One, KPHB");
		
		//Country City State
		driver.findElement(By.id("select2-companyCountryOptions-container")).click();
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys(country);
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.id("select2-companyStateOptions-container")).click();
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys(state);
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.id("select2-companyCityOptions-container")).click();
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys(city);
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.name("pincode")).sendKeys("500033");
		driver.findElement(By.name("gpsLongitude")).sendKeys("77.99");
		driver.findElement(By.name("gpslatitude")).sendKeys("18.99");
		
		Browser.scrollbyID("submitCancel");
		Browser.waitforTextbyxpath("//button[@type='submit']", "Save");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		try {
			Browser.waitFortheID("add");
			System.out.println("Hospital "+hopname+" saved");
		} catch (Exception e) {
			System.out.println("Hospital "+hopname+" save failed");
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

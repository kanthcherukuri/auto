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

public class Admin_ZOY1950_referenceDataPermissions extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String zqa = "https://zoyloqa.zoylo.com/admin/approveUser";
	public String pit = "https://pit.zoylo.com/admin/approveUser";
	public String lopzqa = "https://zoyloqa.zoylo.com/admin/lineOfPracticeList";
	public String quazqa = "https://zoyloqa.zoylo.com/admin/doctorQualificationList";
	public String spczqa= "https://zoyloqa.zoylo.com/admin/areaOfSpecializationList";
	public String tagzqa= "https://zoyloqa.zoylo.com/admin/providerTagList";
	public String countryzqa = "https://zoyloqa.zoylo.com/admin/countryList";
	public String statezqa = "https://zoyloqa.zoylo.com/admin/stateList";
	public String cityzqa = "https://zoyloqa.zoylo.com/admin/cityList";
	public String langzqa = "https://zoyloqa.zoylo.com/admin/languageList";
	
	@Test(priority=1)
	public void referenceDataViewPermission() throws Exception
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
		Browser.selectbyName("profile.defaultRole", "VIEW REFERENCE DATA");
		driver.findElement(By.id("updateButton")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Users')]", "Users");
		
		closebrowser();
		launchbrowser();
		
		//Admin user login to check referenceData view permission
		admin.adminUserSignIn(adminuser_user, adminuser_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		//Doctor LOP
		driver.get(lopzqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Doctor - Practices')]", "Doctor - Practices");
		if(driver.findElements(By.xpath("//button[contains(., 'EDIT')]")).size()>0)
			{
				driver.findElement(By.id("add")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Add");
				Thread.sleep(6000);
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Scriptlopsix");
				Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", "Scriptlopsix");
				driver.findElement(By.xpath("//button[contains(., 'EDIT')]")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Edit");
				System.out.println("View permission is working as expected for doctor lop");
			}
		//Doctor Qualification
		driver.get(quazqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Doctor - Qualifications')]", "Doctor - Qualifications");
		if(driver.findElements(By.xpath("//button[contains(., 'EDIT')]")).size()>0)
			{
				driver.findElement(By.id("add")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Add");
				Thread.sleep(6000);
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys("EIGHTEENMAY");
				Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", "EIGHTEENMAY");
				driver.findElement(By.xpath("//button[contains(., 'EDIT')]")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Edit");
				System.out.println("View permission is working as expected for doctor qualification");
			}
		//Doctor specialization
		driver.get(spczqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Doctor - Specializations')]", "Doctor - Specializations");
		if(driver.findElements(By.xpath("//button[contains(., 'EDIT')]")).size()>0)
			{
				driver.findElement(By.id("add")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Add");
				Thread.sleep(6000);
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Srcsix");
				Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", "Srcsix");
				driver.findElement(By.xpath("//button[contains(., 'EDIT')]")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Edit");
				System.out.println("View permission is working as expected for doctor specialization");
			}
		//Doctor tags
		driver.get(tagzqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Doctor - Professional Tags')]", "Doctor - Professional Tags");
		if(driver.findElements(By.xpath("//button[contains(., 'EDIT')]")).size()>0)
			{
				driver.findElement(By.id("add")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Add");
				Thread.sleep(6000);
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Tagsix");
				Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", "Tagsix");
				driver.findElement(By.xpath("//button[contains(., 'EDIT')]")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Edit");
				System.out.println("View permission is working as expected for doctor tags");
			}
		//Country
		driver.get(countryzqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Countries')]", "Countries");
		if(driver.findElements(By.xpath("//button[contains(., 'EDIT')]")).size()>0)
			{
				driver.findElement(By.id("add")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Add");
				Thread.sleep(6000);
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys("TEIGHTEEN");
				Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", "TEIGHTEEN");
				driver.findElement(By.xpath("//button[contains(., 'EDIT')]")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Edit");
				System.out.println("View permission is working as expected for countries");
			}
		//State
		driver.get(statezqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'States')]", "States");
		if(driver.findElements(By.xpath("//button[contains(., 'EDIT')]")).size()>0)
			{
				driver.findElement(By.id("add")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Add");
				Thread.sleep(6000);
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys("TSSIX");
				Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", "TSSIX");
				driver.findElement(By.xpath("//button[contains(., 'EDIT')]")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Edit");
				System.out.println("View permission is working as expected for states");
			}
		//City
		driver.get(cityzqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Cities')]", "Cities");
		if(driver.findElements(By.xpath("//button[contains(., 'EDIT')]")).size()>0)
			{
				driver.findElement(By.id("add")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Add");
				Thread.sleep(6000);
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Testcsix");
				Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", "Testcsix");
				driver.findElement(By.xpath("//button[contains(., 'EDIT')]")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Edit");
				System.out.println("View permission is working as expected for city");
			}
		//Language
		driver.get(langzqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Languages')]", "Languages");
		if(driver.findElements(By.xpath("//button[contains(., 'EDIT')]")).size()>0)
			{
				driver.findElement(By.id("add")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Add");
				Thread.sleep(6000);
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys("TESTLANGSIX");
				Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", "TESTLANGSIX");
				driver.findElement(By.xpath("//button[contains(., 'EDIT')]")).click();
				Browser.CheckNotificationMessage("Don't have Permission to Edit");
				System.out.println("View permission is working as expected for city");
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

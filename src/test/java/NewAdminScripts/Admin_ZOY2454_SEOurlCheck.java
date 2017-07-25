package NewAdminScripts;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_NewAdminDoctors;
import testBase.LoadPropMac;
import testBase.NewAdminDoctorsPage;
import testBase.TestUtils;

//@Author: Sagar Sen

public class Admin_ZOY2454_SEOurlCheck extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	public String emailID="niru2pama@yahoo.com";
	public String seoID="dr-nirupama-dentist-in-adikmet";
	
	@Test(priority=1)
	public void activeDoctorSEOurl() throws Exception
	{
		driver.get(loginPage_Url);
		admin.adminSignIn(admin_user, admin_password);
		admin.click_doctorsTab();
		admin.searchDoctorbyEmailID(emailID);
		System.out.println(emailID+ " is Active");
		driver.get("https://"+Environment_Name+".zoylo.com/sitemap/cityDoctor-1-sitemap.xml");
		Thread.sleep(5000);
		boolean reader = driver.getPageSource().contains(seoID);
		assertTrue(reader);
	}
	
	@Test(priority=2)
	public void inactiveDoctorSEOurl() throws Exception
	{
		driver.get(loginPage_Url);
		admin.click_doctorsTab();
		admin.searchDoctorbyEmailID(emailID);
		Browser.clickOnTheElementByXpath("//input[@class='no-margin providerActive-class']");
		Thread.sleep(2000);
		System.out.println(emailID+ " is NOT Active");
		driver.get("https://"+Environment_Name+".zoylo.com/generateSitemap");
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(20000);
		driver.get("https://"+Environment_Name+".zoylo.com/sitemap/cityDoctor-1-sitemap.xml");
		Thread.sleep(5000);
		boolean reader = driver.getPageSource().contains(seoID);
		assertFalse(reader);
		driver.get(loginPage_Url);
		admin.click_doctorsTab();
		admin.searchDoctorbyEmailID(emailID);
		Browser.clickOnTheElementByXpath("//input[@class='no-margin providerActive-class']");
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		//driver.get(loginPage_Url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties(); // loading the Elements
		Browser= new TestUtils(driver);
		admin=new NewAdminDoctorsPage(driver);
		//admin.adminSignIn(admin_user, admin_password);
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.quit();
	}
}

package NewAdminScripts;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
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
	public String specURL="doctors/seospeciality";
	
	@Test(priority=1)
	public void activeDoctorSEOurl() throws Exception
	{
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		admin.adminSignIn(admin_user, admin_password);
		admin.click_doctorsTab();
		admin.searchDoctorbyEmailID(emailID);
		boolean isChecked = driver.findElement(By.xpath(Elements_NewAdminDoctors.doctorActiveCheckBox)).isSelected();
		System.out.println(emailID + "" + isChecked);
		if(isChecked!=true)
		{
			Browser.clickOnTheElementByXpath(Elements_NewAdminDoctors.doctorActiveCheckBox);
		}
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/generateSitemap"); //Generate sitemap to update SEO collections
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/sitemap/cityDoctor-1-sitemap.xml");
		Thread.sleep(5000);
		boolean reader = driver.getPageSource().contains("https://"+Environment_Name+".zoylo.com/hyderabad/doctor/"+seoID);
		assertTrue(reader);
	}
	
	@Test(priority=2)
	public void inactiveDoctorSEOurl() throws Exception
	{
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		admin.click_doctorsTab();
		admin.searchDoctorbyEmailID(emailID);
		boolean isChecked1 = driver.findElement(By.xpath(Elements_NewAdminDoctors.doctorActiveCheckBox)).isSelected();
		System.out.println(emailID + "" + isChecked1);
		if(isChecked1==true)
		{
			Browser.clickOnTheElementByXpath(Elements_NewAdminDoctors.doctorActiveCheckBox);
		}
		Thread.sleep(1000);
		boolean isChecked2 = driver.findElement(By.xpath(Elements_NewAdminDoctors.doctorActiveCheckBox)).isSelected();
		System.out.println(emailID + "" + isChecked2);
		Thread.sleep(2000);
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/generateSitemap"); //Generate sitemap to update SEO collections
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/sitemap/cityDoctor-1-sitemap.xml");
		Thread.sleep(5000);
		boolean reader = driver.getPageSource().contains("https://"+Environment_Name+".zoylo.com/hyderabad/doctor/"+seoID);
		assertFalse(reader);
	}
	
	@Test(priority=3)
	public void activeSpecialityURL() throws Exception
	{
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		admin.click_doctorsTab();
		admin.searchDoctorbyEmailID(emailID);
		boolean isChecked1 = driver.findElement(By.xpath(Elements_NewAdminDoctors.doctorActiveCheckBox)).isSelected();
		System.out.println(emailID + "" + isChecked1);
		if(isChecked1==false)
		{
			Browser.clickOnTheElementByXpath(Elements_NewAdminDoctors.doctorActiveCheckBox);
		}
		boolean isChecked2 = driver.findElement(By.xpath(Elements_NewAdminDoctors.doctorActiveCheckBox)).isSelected();
		System.out.println(emailID + "" + isChecked2);
		Thread.sleep(2000);
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/generateSitemap"); //Generate sitemap to update SEO collections
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/sitemap/citySpeciality-1-sitemap.xml");
		Thread.sleep(5000);
		boolean reader = driver.getPageSource().contains("https://"+Environment_Name+".zoylo.com/hyderabad/"+specURL);
		assertTrue(reader);
	}
	
	@Test(priority=4)
	public void inactiveSpecialityURL() throws Exception
	{
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		admin.click_doctorsTab();
		admin.searchDoctorbyEmailID(emailID);
		boolean isChecked1 = driver.findElement(By.xpath(Elements_NewAdminDoctors.doctorActiveCheckBox)).isSelected();
		System.out.println(emailID + "" + isChecked1);
		if(isChecked1==true)
		{
			Browser.clickOnTheElementByXpath(Elements_NewAdminDoctors.doctorActiveCheckBox);
		}
		boolean isChecked2 = driver.findElement(By.xpath(Elements_NewAdminDoctors.doctorActiveCheckBox)).isSelected();
		System.out.println(emailID + "" + isChecked2);
		Thread.sleep(2000);
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/generateSitemap"); //Generate sitemap to update SEO collections
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/sitemap/citySpeciality-1-sitemap.xml");
		Thread.sleep(5000);
		boolean reader = driver.getPageSource().contains("https://"+Environment_Name+".zoylo.com/hyderabad/"+specURL);
		assertFalse(reader);
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties(); // loading the Elements
		Browser= new TestUtils(driver);
		admin=new NewAdminDoctorsPage(driver);
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.quit();
	}
}

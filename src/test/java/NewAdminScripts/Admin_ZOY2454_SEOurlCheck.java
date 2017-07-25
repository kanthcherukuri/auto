package NewAdminScripts;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
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
	
	@Test(priority=1)
	public void activeDoctorSEOurl() throws Exception
	{
		driver.get(loginPage_Url);
		admin.adminSignIn(admin_user, admin_password);
		admin.click_doctorsTab();
		admin.searchDoctorbyEmailID(emailID);
		boolean isChecked = driver.findElement(By.xpath("//input[@class='no-margin providerActive-class']")).isSelected();
		System.out.println(emailID + "" + isChecked);
		if(isChecked!=true)
		{
			Browser.clickOnTheElementByXpath("//input[@class='no-margin providerActive-class']");
		}
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
		boolean isChecked1 = driver.findElement(By.xpath("//input[@class='no-margin providerActive-class']")).isSelected();
		System.out.println(emailID + "" + isChecked1);
		if(isChecked1==true)
		{
			Browser.clickOnTheElementByXpath("//input[@class='no-margin providerActive-class']");
		}
		Thread.sleep(1000);
		boolean isChecked2 = driver.findElement(By.xpath("//input[@class='no-margin providerActive-class']")).isSelected();
		System.out.println(emailID + "" + isChecked2);
		Thread.sleep(2000);
		driver.get("https://"+Environment_Name+".zoylo.com/generateSitemap");
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(20000);
		driver.get("https://"+Environment_Name+".zoylo.com/sitemap/cityDoctor-1-sitemap.xml");
		Thread.sleep(5000);
		boolean reader = driver.getPageSource().contains(seoID);
		assertFalse(reader);
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

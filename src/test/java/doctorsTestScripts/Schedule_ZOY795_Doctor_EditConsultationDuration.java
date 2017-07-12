package doctorsTestScripts;

//@Author: Sagar Sen

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import objectRepository.Elements_Admin;
import objectRepository.Elements_Doctors;
import objectRepository.Elements_Recipients;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;
import org.openqa.selenium.By;

public class Schedule_ZOY795_Doctor_EditConsultationDuration extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;
	public String duration="1";
	
	@Test()
	public void editConsultationDuration() throws Exception
	{
		doctorsPage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
		doctorsPage.BulkCancel();
		Thread.sleep(5000);
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Browser.waitFortheElementXpath("(//div[@class='day-title'])[1]");
		Thread.sleep(6000);
		driver.findElement(By.id("consultation-min")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("consultation-min")).sendKeys(duration);
		//driver.findElement(By.xpath("sp-doc-conc-duration-label")).click();
		Browser.scrollbyxpath("//div[@class='sp-doc-clinic-schd-save-btn menu_links']");
		driver.findElement(By.xpath("//div[@class='sp-doc-clinic-schd-save-btn menu_links']")).click();
		Thread.sleep(3000);
		Browser.CheckNotificationMessage("Schedule updated successfully");
		Thread.sleep(3000);
	}
  
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Elements_Admin.Admin_PageProperties(); // loading the Elements
		Elements_Recipients.Recipients_PageProperties();
		Browser= new TestUtils(driver);
		doctorsPage=new DoctorsPage(driver);
		driver.get(loginPage_Url);
	}
	
	@AfterClass
	public void closeapp() throws Exception
	{
		driver.quit();
	}
}
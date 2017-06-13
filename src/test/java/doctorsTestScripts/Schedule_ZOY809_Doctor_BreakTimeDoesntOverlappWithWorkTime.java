package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import objectRepository.Elements_Doctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY809_Doctor_BreakTimeDoesntOverlappWithWorkTime extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;
	public String updateStrtTime="12:00";
	public String updateEndTime="13:00";
	
	@Test()
	public void testBreakTimeDoesntOverlappWithWorkTime() throws Exception
	{
		doctorsPage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
		doctorsPage.BulkCancel();
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Browser.waitforTextbyxpath("(//div[@class='day-title'])[1]", "Consultation");
		doctorsPage.addClinicWorkTimings("10:00", "17:00");
		driver.navigate().refresh();
		Browser.waitFortheElementXpath("//strong[contains(., 'SET BREAK TIME')]");
		doctorsPage.checkAddBreakTimes(updateStrtTime, updateEndTime);
		Browser.CheckNotificationMessage("Lunch Slots overlap with working slots");
		driver.navigate().refresh();
		Browser.waitFortheElementXpath(Elements_Doctors.clinicTab);
		driver.findElement(By.xpath(Elements_Doctors.clinicTab)).click();
		driver.findElement(By.id(Elements_Doctors.sundayTab)).click();
		Thread.sleep(2000);
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		doctorsPage=new DoctorsPage(driver);
		driver.get(loginPage_Url);
	}
	
	@AfterClass
	public void closeapp() throws Exception
	{
		doctorsPage.removeClinicWorkTimings();
		driver.quit();
	}
}
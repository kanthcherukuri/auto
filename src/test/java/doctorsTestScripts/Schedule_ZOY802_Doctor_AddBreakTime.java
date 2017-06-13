package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import objectRepository.Elements_Doctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;


public class Schedule_ZOY802_Doctor_AddBreakTime extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;
	
	@Test()
	public void testAddBreakTime() throws Exception 
	{
		doctorsPage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
		doctorsPage.BulkCancel();
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Browser.waitforTextbyxpath("(//div[@class='day-title'])[1]", "Consultation");
		doctorsPage.checkAddBreakTimes("13:00", "14:00");
		Browser.CheckNotificationMessage("Schedule Updated Successfully");
		Thread.sleep(5000);
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
		doctorsPage.checkremoveBreakTimes();
		driver.quit();
	}

}
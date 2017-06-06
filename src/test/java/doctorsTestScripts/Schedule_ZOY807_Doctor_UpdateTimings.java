package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import objectRepository.Elements_Doctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY807_Doctor_UpdateTimings extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;
	public String updateStrtTime="11:00";
	public String updateEndTime="16:00";
  
	@Test() 
	public void validateTimeSlot() throws Exception
	{
		doctorsPage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
		doctorsPage.BulkCancel();
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Browser.waitforTextbyxpath("(//div[@class='day-title'])[1]", "Consultation");
		doctorsPage.addClinicWorkTimings("10:00", "17:00");
		driver.navigate().refresh();
		doctorsPage.updateClinicWorkTimings(updateStrtTime, updateEndTime);
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		doctorsPage=new DoctorsPage(driver);
		driver.get(recipient_url);
	}
	
	@AfterClass
	public void closeapp() throws Exception
	{
		Thread.sleep(2000);
		doctorsPage.removeClinicWorkTimings();
		Thread.sleep(3000);
		driver.close();
	}
}

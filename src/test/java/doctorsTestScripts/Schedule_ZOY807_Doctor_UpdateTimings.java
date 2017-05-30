package doctorsTestScripts;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY807_Doctor_UpdateTimings extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage docpage;
	public String updateStrtTime="11:00";
	public String updateEndTime="16:00";
  
	@Test() 
	public void validateTimeSlot() throws Exception
	{
		docpage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
	  	docpage.BulkCancel();
		Thread.sleep(2000);
		driver.findElement(By.id("schedule")).click();
		Browser.waitforTextbyxpath("(//div[@class='day-title'])[1]", "Consultation");
		docpage.addClinicWorkTimings("10:00", "17:00");
		driver.navigate().refresh();
		docpage.updateClinicWorkTimings(updateStrtTime, updateEndTime);
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		docpage=new DoctorsPage(driver);
		driver.get(recipient_url);
	}
	
	@AfterClass
	public void closeapp() throws Exception
	{
		Thread.sleep(2000);
		docpage.removeClinicWorkTimings();
		Thread.sleep(3000);
		driver.close();
	}
}

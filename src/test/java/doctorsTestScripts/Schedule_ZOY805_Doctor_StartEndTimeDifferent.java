package doctorsTestScripts;
import org.testng.annotations.Test;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Schedule_ZOY805_Doctor_StartEndTimeDifferent extends LoadPropMac
{
	
	public TestUtils Browser;
	public DoctorsPage docpage;
	
	@Test()
	public void testAddBreakTime() throws Exception 
	{
		docpage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
	  	docpage.BulkCancel();
		Thread.sleep(2000);
		driver.findElement(By.id("schedule")).click();
		Browser.waitforTextbyxpath("(//div[@class='day-title'])[1]", "Consultation");
		docpage.checkAddBreakTimes("13:00", "13:00");
		Browser.CheckNotificationMessage("Start time an end time can't be same");
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
		docpage.checkremoveBreakTimes();
		Thread.sleep(3000);
		driver.close();
	}
}
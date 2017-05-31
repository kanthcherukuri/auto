package doctorsTestScripts;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Schedule_ZOY798_Doctor_SetVacation extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage docpage;	
	
  @Test()
  public void testSetVacation() throws Exception
  {
	  	docpage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
	  	docpage.BulkCancel();
		Thread.sleep(2000);
		driver.findElement(By.id("schedule")).click();
		Browser.waitforTextbyxpath("(//div[@class='day-title'])[1]", "Consultation");
		docpage.setVacation();
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
		docpage.cancelVacation();
		Thread.sleep(3000);
		driver.close();
	}
}
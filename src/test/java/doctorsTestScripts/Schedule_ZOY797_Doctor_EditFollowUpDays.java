package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import objectRepository.Elements_Doctors;
import org.testng.annotations.BeforeClass;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;
import org.openqa.selenium.By;


public class Schedule_ZOY797_Doctor_EditFollowUpDays extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;
	public String duration="10";	
	
  @Test()
  public void testEditFollowUpDays() throws Exception
  {
	  doctorsPage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
	  doctorsPage.BulkCancel();
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Browser.waitforTextbyxpath("(//div[@class='day-title'])[1]", "Consultation");
		driver.findElement(By.id("followup-days")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("followup-days")).sendKeys(duration);
		Browser.scrollbyxpath("//div[@class='sp-doc-clinic-schd-save-btn menu_links']");
		driver.findElement(By.xpath("//div[@class='sp-doc-clinic-schd-save-btn menu_links']")).click();
		Thread.sleep(3000);
		Browser.CheckNotificationMessage("Schedule Updated Successfully");
		Thread.sleep(3000);
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
		driver.quit();
	}

}

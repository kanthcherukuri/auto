package doctorsTestScripts;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import objectRepository.Elements_Doctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;
import org.openqa.selenium.By;

//@Author: Sagar Sen

public class Schedule_ZOY798_Doctor_SetVacation extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;	
	
  @Test()
  public void testSetVacation() throws Exception
  {
	  doctorsPage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
	  doctorsPage.BulkCancel();
		Thread.sleep(5000);
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Browser.waitFortheElementXpath("(//div[@class='day-title'])[1]");
		Thread.sleep(6000);
		doctorsPage.setVacation();
		Thread.sleep(5000);
  }
  
  @BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		doctorsPage=new DoctorsPage(driver);
		driver.get("https://"+Environment_Name+".zoylo.com/login");
	}
	
	@AfterClass
	public void closeapp() throws Exception
	{
		doctorsPage.cancelVacation();
		driver.quit();
	}
}
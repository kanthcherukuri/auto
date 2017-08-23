package doctorsTestScripts;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import objectRepository.Elements_Doctors;
import org.openqa.selenium.By;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

//@Author: Sagar Sen

public class Schedule_ZOY792_Home_Visit_enable_disable extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;

	@Test()
	public void testEnableDisableHomeVisit() throws Exception
	{
		String fee=Browser.generateRandomNumber(3);
		doctorsPage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
		Browser.clickOnTheElementByID(Elements_Doctors.schedule);
		Browser.clickOnTheElementByXpath(Elements_Doctors.homeVisitTab);
		Browser.clickOnTheElementByXpath(Elements_Doctors.carIcon);
		Browser.CheckNotificationMessage("Activated Successfully");
		driver.findElement(By.id(Elements_Doctors.homeVisitFee)).clear();
		Browser.enterTextByID(Elements_Doctors.homeVisitFee, fee);
		Thread.sleep(1000);
		Browser.clickOnTheElementByXpath(Elements_Doctors.carIcon);
		Browser.CheckNotificationMessage("Deactivated Successfully");
	}

	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Elements_Doctors.Doc_PageProperties();
		Browser= new TestUtils(driver);
		doctorsPage=new DoctorsPage(driver);
		driver.get("https://"+Environment_Name+".zoylo.com/login");
	}

	@AfterClass
	public void closeapp() throws Exception
	{
		driver.quit();
	}
}
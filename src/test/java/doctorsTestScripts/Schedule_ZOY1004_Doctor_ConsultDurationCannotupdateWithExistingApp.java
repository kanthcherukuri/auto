package doctorsTestScripts;



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


public class Schedule_ZOY1004_Doctor_ConsultDurationCannotupdateWithExistingApp extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;
	public String duration="30";
	
	@Test()
	public void consultationDurationUpdate() throws Exception
	{
		doctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
		doctorsPage.DoctorAppointmentBookingForToday("Saatwika", "Swathi", "7829292920", "adf@fd.com", "dfsdf");
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Browser.waitforTextbyxpath("(//div[@class='day-title'])[1]", "Consultation");
		driver.findElement(By.id("consultation-min")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("consultation-min")).sendKeys(duration);
		//driver.findElement(By.xpath("sp-doc-conc-duration-label")).click();
		Browser.scrollbyxpath("//div[@class='sp-doc-clinic-schd-save-btn menu_links']");
		driver.findElement(By.xpath("//div[@class='sp-doc-clinic-schd-save-btn menu_links']")).click();
		Thread.sleep(3000);
		Browser.CheckNotificationMessage("Conflict with existing appointments, please cancel the appointments to change consultation duration.");	
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
		doctorsPage.BulkCancel();
		driver.quit();
	}
}
	
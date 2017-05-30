package doctorsTestScripts;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import objectRepository.Elements_Doctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY811_Doctor_WorkTimingsvalidationChecks extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage docpage;
	
	//Global variables
	public String firstName="Guru";
	public String lastName="Charan";
	public String Mobile="9870000000";
	public String mail="guru1@gmail.com";
	public String prob="This is my problem";
	
  @Test()
  public void testDeleteTimings() throws Exception
  {
	  	docpage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
	  	docpage.BulkCancel();
		Thread.sleep(2000);
		driver.findElement(By.id("schedule")).click();
		Browser.waitforTextbyxpath("(//div[@class='day-title'])[1]", "Consultation");
		docpage.addClinicWorkTimings("10:00", "17:00");
		Thread.sleep(1000);
		docpage.DoctorAppointmentBookingForSunday(firstName, lastName, Mobile, mail, prob);
		Thread.sleep(1000);
		docpage.checkWorkDeletionConflict(); //check delete conflicts
		docpage.cancelSundayAppt(); //cancel sunday appointment
		Thread.sleep(1000);
		driver.findElement(By.id("schedule")).click();
		Browser.waitFortheElementXpath(Elements_Doctors.clinicTab);
		driver.findElement(By.xpath(Elements_Doctors.clinicTab)).click();
		driver.findElement(By.id(Elements_Doctors.sundayTab)).click();
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

package doctorsTestScripts;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import objectRepository.Elements_Doctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY811_Doctor_DeleteCorrectTimings extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;
	
	//Global variables
	public String firstName="Guru";
	public String lastName="Charan";
	public String Mobile="9870000000";
	public String mail="guru1@gmail.com";
	public String prob="This is my problem";
	
  @Test()
  public void testDeleteTimings() throws Exception
  {
	  doctorsPage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
	  	//docpage.BulkCancel();
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Browser.waitforTextbyxpath("(//div[@class='day-title'])[1]", "Consultation");
		doctorsPage.addClinicWorkTimings("10:00", "17:00");
		Thread.sleep(1000);
		doctorsPage.DoctorAppointmentBookingForSunday(firstName, lastName, Mobile, mail, prob);
		Thread.sleep(1000);
		doctorsPage.checkWorkDeletionConflict(); //check delete conflicts
		doctorsPage.cancelSundayAppt(); //cancel sunday appointment
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Browser.waitFortheElementXpath(Elements_Doctors.clinicTab);
		driver.findElement(By.xpath(Elements_Doctors.clinicTab)).click();
		driver.findElement(By.id(Elements_Doctors.sundayTab)).click();
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

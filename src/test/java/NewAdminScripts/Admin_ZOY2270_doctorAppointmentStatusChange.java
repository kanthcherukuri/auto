package NewAdminScripts;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import objectRepository.Elements_Doctors;
import objectRepository.Elements_NewAdminDoctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.NewAdminDoctorsPage;
import testBase.TestUtils;

//@Author: Sagar Sen

public class Admin_ZOY2270_doctorAppointmentStatusChange extends LoadPropMac
{	
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	public DoctorsPage DoctorsPage;
	
	@DataProvider(name="DoctorAptStatus")
	public Object[][] DocInfoEdit() throws Exception
	{
		Object[][] DocInfoEdit=TestUtils.getTableArray("TestData/rvmpAdmin_addDoctor.xls", "appointment", "ZOY2270");
		return(DocInfoEdit);
	}
	
	@Test(dataProvider="DoctorAptStatus")
	public void doctorAptStatus(String firstname,String lastname,String mobile,String email,String problem, String status, String Notification) throws Exception
	{
		//Doctor Module
		DoctorsPage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
		DoctorsPage.BulkCancel();
		Browser.CheckNotificationMessage("Appointments cancelled successfully");
		Thread.sleep(5000);
		DoctorsPage.DoctorAppointmentBookingForTodayEveSecondCell(firstname, lastname, mobile, email, problem);
		Thread.sleep(5000);
		DoctorsPage.ClickView();
		String APTID=driver.findElement(By.xpath(Elements_Doctors.patient_getAptID)).getText();
		closeapp();
		launchapp();
		//Admin Module
		admin.adminSignIn(admin_user, admin_password);
		admin.click_doctorsTab();
		admin.click_aptTabToCompletedApt();
		admin.search_aptTbyAPTID(APTID);
		admin.doctorAptStatusChangeToReschedule(status, Notification);
		admin.doctorAptStatusChangeToCancel(status, Notification);
		admin.doctorAptStatusChangeToComplete(status, Notification);
		closeapp();
		launchapp();
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties(); // loading the Elements
		Browser= new TestUtils(driver);
		admin=new NewAdminDoctorsPage(driver);
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		DoctorsPage=new DoctorsPage(driver);
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.quit();
	}
}

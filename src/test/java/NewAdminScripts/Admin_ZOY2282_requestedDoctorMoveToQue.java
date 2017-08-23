package NewAdminScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;
import objectRepository.Elements_NewAdminDoctors;
import testBase.HomePage;
import testBase.LoadPropMac;
import testBase.NewAdminDoctorsPage;
import testBase.TestUtils;

//@Author: Sagar Sen

public class Admin_ZOY2282_requestedDoctorMoveToQue extends LoadPropMac
{
	public HomePage HomePageOfZoylo;
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	
	@DataProvider(name="DoctorEnroll")
	public Object[][] DocInfoEdit() throws Exception
	{
		Object[][] DocInfoEdit=TestUtils.getTableArray("TestData/rvmpAdmin_addDoctor.xls", "enroll", "ZOY2282");
		return(DocInfoEdit);
	}
	
	@Test(dataProvider="DoctorEnroll")
	public void enrollmentCheck(String Area, String FirstName,String LastName,String Gender,String Qualification,String Email, String Address,String Fee,String Notes) throws Exception
	{			
		HomePageOfZoylo.doctorsEnrollment(Area, FirstName, LastName, Gender, Qualification, Email,  Address, Fee, Notes);
		Thread.sleep(5000);
		//Admin Module
		driver.get("https://"+Environment_Name+".zoylo.com/login");
		admin.adminSignIn(admin_user, admin_password);
		admin.click_doctorsTab();
		admin.click_requestedDoctorTab();
		admin.searchRequestedDoctorbyEmailID(Email);
		admin.click_detailsBtn();
		admin.edit_requestedDoctorDetails();
		admin.click_validateBtn();
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		driver.get("https://"+Environment_Name+".zoylo.com/doctorenrollmentform");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties(); // loading the Elements
		Browser= new TestUtils(driver);
		admin=new NewAdminDoctorsPage(driver);
		HomePageOfZoylo=new HomePage(driver);
	}
	
	@AfterClass
	public void closeapp() throws Exception
	{
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "users", "username", "docenroll1@gmail.com");
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "requestedProviders", "username", "docenroll1@gmail.com");
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "providers", "username", "docenroll1@gmail.com");
		driver.quit();
	}
}

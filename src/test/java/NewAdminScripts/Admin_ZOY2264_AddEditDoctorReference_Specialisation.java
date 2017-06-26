package NewAdminScripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.Elements_NewAdminDoctors;
import testBase.LoadPropMac;
import testBase.NewAdminDoctorsPage;
import testBase.TestUtils;

//@Author: Sagar Sen

public class Admin_ZOY2264_AddEditDoctorReference_Specialisation extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	
	@DataProvider(name="DoctorSpecialisationDetailsADD")
	public Object[][] DocInfoAdd() throws Exception
	{
		Object[][] DocInfoAdd=TestUtils.getTableArray("TestData/rvmpAdmin_addDoctor.xls", "clinicDoctor", "ZOY2264ADD");
		return(DocInfoAdd);
	}
	
	@Test(dataProvider="DoctorSpecialisationDetailsADD", priority=1)
	public void addDoctorPractice(String specialisationName, String specialisationDescription) throws Exception
	{
		admin.click_doctorsTab();
		admin.click_doctorReferences();
		admin.click_doctorReferenceSpecialitionTab();
		admin.click_doctorReference_AddBtn();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_reference_specialisationHeader);
		admin.Enter_specialisationDetails(specialisationName, specialisationDescription);
		admin.click_specialisationSaveBtn();
		Browser.CheckNotificationMessage("Doctor - Specialization created successfully");
	}
	
	@DataProvider(name="DoctorSpecialisationDetailsEDIT")
	public Object[][] DocInfoEdit() throws Exception
	{
		Object[][] DocInfoEdit=TestUtils.getTableArray("TestData/rvmpAdmin_addDoctor.xls", "clinicDoctor", "ZOY2264EDIT");
		return(DocInfoEdit);
	}
	
	@Test(dataProvider="DoctorSpecialisationDetailsEDIT", priority=2)
	public void editDoctorPractice(String specialisationName) throws Exception
	{
		driver.navigate().refresh();
		admin.searchDoctorspecialisationByName(specialisationName);
		Thread.sleep(1500);
		admin.clickEditbutton();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_reference_specialisationEditHeader);
		admin.click_editSpecialisationSaveBtn();
		Browser.CheckNotificationMessage("Doctor - Specialization updated successfully");
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		driver.get(loginPage_Url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties(); // loading the Elements
		Browser= new TestUtils(driver);
		admin=new NewAdminDoctorsPage(driver);
		admin.adminSignIn(admin_user, admin_password);
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.quit();
	}
}

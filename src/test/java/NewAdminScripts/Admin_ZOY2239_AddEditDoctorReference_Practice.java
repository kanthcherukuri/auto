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

public class Admin_ZOY2239_AddEditDoctorReference_Practice extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	
	@DataProvider(name="DoctorPracticeDetailsADD")
	public Object[][] DocInfoAdd() throws Exception
	{
		Object[][] DocInfoAdd=TestUtils.getTableArray("TestData/rvmpAdmin_addDoctor.xls", "clinicDoctor", "ZOY2239ADD");
		return(DocInfoAdd);
	}
	
	@Test(dataProvider="DoctorPracticeDetailsADD", priority=1)
	public void addDoctorPractice(String practiceName, String practiceDescription) throws Exception
	{
		admin.click_doctorsTab();
		admin.click_doctorReferences();
		admin.click_doctorReferencePracticeTab();
		admin.click_doctorReference_AddBtn();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_reference_practiceAddHeader);
		admin.Enter_practiceDetails(practiceName, practiceDescription);
		admin.click_practiceSaveBtn();
		Browser.CheckNotificationMessage("Doctor - Line Of Practice created successfully");
	}
	
	@DataProvider(name="DoctorPracticeDetailsEDIT")
	public Object[][] DocInfoEdit() throws Exception
	{
		Object[][] DocInfoEdit=TestUtils.getTableArray("TestData/rvmpAdmin_addDoctor.xls", "clinicDoctor", "ZOY2239EDIT");
		return(DocInfoEdit);
	}
	
	@Test(dataProvider="DoctorPracticeDetailsEDIT", priority=2)
	public void editDoctorPractice(String practiceName)
	{
		driver.navigate().refresh();
		admin.searchDoctorPracticeByName(practiceName);
		admin.clickEditbutton();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_reference_practiceEditHeader);
		admin.click_editPracticeSaveBtn();
		Browser.CheckNotificationMessage("Line of Practice Updated Successfully");
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

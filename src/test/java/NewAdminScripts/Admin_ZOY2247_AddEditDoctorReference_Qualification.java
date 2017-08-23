package NewAdminScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;
import objectRepository.Elements_NewAdminDoctors;
import testBase.LoadPropMac;
import testBase.NewAdminDoctorsPage;
import testBase.TestUtils;

//@Author: Sagar Sen

public class Admin_ZOY2247_AddEditDoctorReference_Qualification extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	
	@DataProvider(name="DoctorQualificationDetailsADD")
	public Object[][] DocInfoAdd() throws Exception
	{
		Object[][] DocInfoAdd=TestUtils.getTableArray("TestData/rvmpAdmin_addDoctor.xls", "clinicDoctor", "ZOY2247ADD");
		return(DocInfoAdd);
	}
	
	@Test(dataProvider="DoctorQualificationDetailsADD", priority=1)
	public void addDoctorQualification(String qualificationName, String qualificationDescription) throws Exception
	{
		admin.click_doctorsTab();
		admin.click_doctorReferences();
		admin.click_doctorReferenceQualificationTab();
		admin.click_doctorReference_AddBtn();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_reference_qualificationAddHeader);
		admin.Enter_QualificationDetails(qualificationName, qualificationDescription);
		admin.click_qualificationSaveBtn();
		Browser.CheckNotificationMessage("Qualification created successfully");
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "providerQualification", "name", qualificationName);
	}
	
	@DataProvider(name="DoctorQualificationDetailsEDIT")
	public Object[][] DocInfoEdit() throws Exception
	{
		Object[][] DocInfoEdit=TestUtils.getTableArray("TestData/rvmpAdmin_addDoctor.xls", "clinicDoctor", "ZOY2247EDIT");
		return(DocInfoEdit);
	}
	
	@Test(dataProvider="DoctorQualificationDetailsEDIT", priority=2)
	public void editDoctorQualification(String qualificationName)
	{
		driver.navigate().refresh();
		admin.searchDoctorQualificationByName(qualificationName);
		admin.clickEditbutton();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_reference_qualificationEditHeader);
		admin.click_editQualificationSaveBtn();
		Browser.CheckNotificationMessage("Qualification updated successfully");
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		driver.get("https://"+Environment_Name+".zoylo.com/login");
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

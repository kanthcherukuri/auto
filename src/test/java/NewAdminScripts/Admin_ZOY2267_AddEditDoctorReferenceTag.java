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

public class Admin_ZOY2267_AddEditDoctorReferenceTag extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	
	@DataProvider(name="DoctorTagDetailsADD")
	public Object[][] DocInfoAdd() throws Exception
	{
		Object[][] DocInfoAdd=TestUtils.getTableArray("TestData/rvmpAdmin_addDoctor.xls", "clinicDoctor", "ZOY2267ADD");
		return(DocInfoAdd);
	}
	
	@Test(dataProvider="DoctorTagDetailsADD", priority=1)
	public void addDoctorTag(String tagName, String tagDescription) throws Exception
	{
		admin.click_doctorsTab();
		admin.click_doctorReferences();
		Thread.sleep(1000);
		admin.click_doctorReferenceTagTab();
		admin.click_doctorReference_AddBtn();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_reference_tagAddHeader);
		admin.Enter_tagDetails(tagName, tagDescription);
		admin.click_tagSaveBtn();
		Browser.CheckNotificationMessage("Doctor - Professional Tags created successfully");
	}
	
	@DataProvider(name="DoctorTagDetailsEDIT")
	public Object[][] DocInfoEdit() throws Exception
	{
		Object[][] DocInfoEdit=TestUtils.getTableArray("TestData/rvmpAdmin_addDoctor.xls", "clinicDoctor", "ZOY2267EDIT");
		return(DocInfoEdit);
	}
	
	@Test(dataProvider="DoctorTagDetailsEDIT", priority=2)
	public void editDoctorQualification(String tagName)
	{
		driver.navigate().refresh();
		admin.searchDoctorTagByName(tagName);
		admin.clickEditbutton();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_reference_tagEditHeader);
		admin.click_editTagSaveBtn();
		Browser.CheckNotificationMessage("Doctor - Professional Tags updated successfully");
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

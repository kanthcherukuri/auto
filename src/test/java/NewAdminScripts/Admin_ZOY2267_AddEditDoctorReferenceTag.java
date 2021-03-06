package NewAdminScripts;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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
		admin.Enter_tagDetails(tagName, tagDescription);
		admin.click_tagSaveBtn();
		Browser.CheckNotificationMessage("Doctor - Professional Tags created successfully");
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "providerTag", "name", tagName);
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
		admin.click_editTagSaveBtn();
		Browser.CheckNotificationMessage("Doctor - Professional Tags updated successfully");
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties(); // loading the Elements
		Browser= new TestUtils(driver);
		admin=new NewAdminDoctorsPage(driver);
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		admin.adminSignIn(admin_user, admin_password);
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.quit();
	}
}

package NewAdminScripts;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import objectRepository.Elements_NewAdminDoctors;
import testBase.LoadPropMac;
import testBase.NewAdminDoctorsPage;
import testBase.TestUtils;

//@Author: Sagar Sen

public class Admin_ZOY2291_administratorAddEditState extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	public String stateName="Xyzname";
	public String stateCode="XYZ";
	
	@Test(priority=1)
	public void addState() throws Exception
	{
		admin.click_AdministratorTab();
		admin.click_stateTab();
		admin.click_doctorReference_AddBtn();
		admin.Enter_stateDetails(stateCode, stateName);
		admin.click_stateSaveBtn();
		Browser.CheckNotificationMessage("State created successfully");
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void editState() throws Exception
	{
		driver.navigate().refresh();
		admin.searchAdministratorReferenceByName(stateCode);
		admin.clickEditbutton();
		Browser.waitFortheID(Elements_NewAdminDoctors.administrator_stateSave);
		admin.click_stateSaveBtn();
		Browser.CheckNotificationMessage("State updated successfully");
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
	public void closeapp() throws Exception
	{
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "state", "code", stateCode);
		driver.quit();
	}
}

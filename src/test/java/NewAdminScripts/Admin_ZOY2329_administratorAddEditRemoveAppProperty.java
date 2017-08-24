package NewAdminScripts;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import objectRepository.Elements_NewAdminDoctors;
import testBase.LoadPropMac;
import testBase.NewAdminDoctorsPage;
import testBase.TestUtils;

//@Authour: Sagar Sen

public class Admin_ZOY2329_administratorAddEditRemoveAppProperty extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	public String propertyKey="BHP";
	public String propertyValue="YZX";
	
	@Test(priority=1)
	public void addAppProperty() throws Exception
	{
		admin.click_AdministratorTab();
		admin.click_appPropertyTab();
		admin.click_doctorReference_AddBtn();
		admin.Enter_appPropertyDetails(propertyKey, propertyValue);
		admin.click_appPropertySaveBtn();
	}
	
	@Test(priority=2)
	public void editAppProperty() throws Exception
	{
		driver.navigate().refresh();
		admin.searchAdministratorReferenceByName(propertyKey);
		admin.clickEditbutton();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.administrator_appPropertyEditHeader);
		admin.click_appPropertyEditSaveBtn();
	}
	
	@Test(priority=3)
	public void deleteAppProperty() throws Exception
	{
		Thread.sleep(5000);
		admin.click_appPropertyDeleteBtn();
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
		driver.quit();
	}
}

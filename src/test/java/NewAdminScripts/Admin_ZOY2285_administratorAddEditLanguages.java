package NewAdminScripts;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import objectRepository.Elements_NewAdminDoctors;
import testBase.LoadPropMac;
import testBase.NewAdminDoctorsPage;
import testBase.TestUtils;

//Author: Sagar Sen

public class Admin_ZOY2285_administratorAddEditLanguages extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	public String languageName="XYZNAME";
	public String languageDescription="Xyzname description";
	
	@Test(priority=1)
	public void addLanguage() throws Exception
	{
		admin.click_AdministratorTab();
		admin.click_languagesTab();
		admin.click_doctorReference_AddBtn();
		admin.Enter_LanguageDetails(languageName, languageDescription);
		admin.click_languageSaveBtn();
		Browser.CheckNotificationMessage("Language information saved successfully");
	}
	
	@Test(priority=2)
	public void editLanguage() throws Exception
	{
		driver.navigate().refresh();
		admin.searchAdministratorReferenceByName(languageName);
		admin.clickEditbutton();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.administrator_LanguageEditHeader);
		admin.click_languageEditSaveBtn();
		Browser.CheckNotificationMessage("Language information updated successfully");
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
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "language", "name", languageName);
		driver.quit();
	}
}

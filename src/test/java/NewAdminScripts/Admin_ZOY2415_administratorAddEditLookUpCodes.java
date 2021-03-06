package NewAdminScripts;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import objectRepository.Elements_NewAdminDoctors;
import testBase.LoadPropMac;
import testBase.NewAdminDoctorsPage;
import testBase.TestUtils;

//@Authour: Sagar Sen

public class Admin_ZOY2415_administratorAddEditLookUpCodes extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	public String codeType="ZOYTA";
	public String codeName="Zoytb";
	public String codeDescription="Type is important";
	public String codeValue="V1";
	public String codeValueName="Value";
	public String codeValueDescription="Value disc";
	public String codeValueSequence="1";
	
	@Test()
	public void addEditLookUpCode() throws Exception
	{
		admin.click_AdministratorTab();
		admin.click_lookUpCodeTab();
		admin.click_doctorReference_AddBtn();
		admin.Enter_lookUpCodeDetails(codeType, codeName, codeDescription, codeValue, codeValueName, codeValueDescription, codeValueSequence);
		admin.click_administratorSave();
		Browser.CheckNotificationMessage("Lookup Code saved successfully");
		Thread.sleep(3000);
		driver.navigate().refresh();
		admin.searchAdministratorReferenceByName(codeType);
		admin.clickEditbutton();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.administrator_lookupCodeType);
		admin.click_administratorSave();
		Browser.CheckNotificationMessage("Lookup Code Updated successfully");
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "lookupCodes", "code", codeType);
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

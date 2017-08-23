package NewAdminScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import objectRepository.Elements_NewAdminDoctors;
import testBase.LoadPropMac;
import testBase.NewAdminDoctorsPage;
import testBase.TestUtils;

//@Authour: Sagar Sen

public class Admin_ZOY2325_administratorAddEditMaerketingElements extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	public String marketingName="Newmarket";
	public String marketingDescription="Newmarket description";
	
	@Test()
	public void addEditMarketingElement() throws Exception
	{
		admin.click_AdministratorTab();
		admin.click_marketingElementsTab();
		admin.click_doctorReference_AddBtn();
		Thread.sleep(1000);
		driver.navigate().refresh();
		admin.Enter_marketingElementDetails(marketingName, marketingDescription);
		admin.click_administratorSave();
		Browser.CheckNotificationMessage("Marketing Element Created Sucessfully");
		driver.navigate().refresh();
		admin.searchPromoCodeByName(marketingName);
		admin.clickEditbutton();
		Browser.waitforElementName(Elements_NewAdminDoctors.administrator_marketingName);
		admin.click_administratorSave();
		Browser.CheckNotificationMessage("Marketing Element updated successfully");
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
	public void closeapp() throws Exception
	{
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "marketingElement", "marketingHtml", marketingName);
		driver.quit();
	}
}

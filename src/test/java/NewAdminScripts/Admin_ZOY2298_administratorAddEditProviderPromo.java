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

public class Admin_ZOY2298_administratorAddEditProviderPromo extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	
	@DataProvider(name="PromoDetails")
	public Object[][] promoInfo() throws Exception
	{
		Object[][] promoInformation=TestUtils.getTableArray("TestData/rvmpAdmin_addDoctor.xls", "appointment", "ZOY2298ADD");
		return(promoInformation);
	}
	
	@Test(dataProvider="PromoDetails")
	public void addPromoDetails(String promoCodeType, String promoName, String promoDescription, String referraldiscountType, String referalValue, String refereediscountType, String refreeValue, String discountType, String discountValue, String minimumPurchase, String applyType) throws Exception
	{
		admin.click_AdministratorTab();
		admin.click_ProviderPromoTab();
		admin.click_doctorReference_AddBtn();
		admin.Enter_ProviderPromoDetails(promoCodeType, promoName, promoDescription, referraldiscountType, referalValue, refereediscountType, refreeValue, discountType, discountValue, minimumPurchase, applyType);
		admin.click_promoSaveBtn();
		Browser.CheckNotificationMessage("Promocode created successfully");
		driver.navigate().refresh();
		admin.searchPromoCodeByName(promoName);
		admin.clickEditbutton();
		Browser.waitforElementName(Elements_NewAdminDoctors.administrator_promoName);
		Browser.scrollbyxpath(Elements_NewAdminDoctors.admininstrator_Save);
		admin.click_promoSaveBtn();
		Browser.CheckNotificationMessage("Promo Code Updated Successfully");
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "zyProviderPromocodes", "code", promoName);
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
	public void closeapp() throws Exception
	{
		driver.quit();
	}
}

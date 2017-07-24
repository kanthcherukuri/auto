package NewAdminScripts;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;
import objectRepository.Elements_NewAdminDiagnostic;
import testBase.LoadPropMac;
import testBase.NewAdminDiagnosticPage;
import testBase.TestUtils;

public class Admin_EditHospital extends LoadPropMac {
	
	public NewAdminDiagnosticPage AdminDiagnostic;
	public TestUtils Browser;
	
	@BeforeClass	 
	 public void beforeClass() throws Exception {		
	 LoadBrowserProperties(); 
	 AdminDiagnostic=new NewAdminDiagnosticPage(driver);	
	 Browser= new TestUtils(driver);
	 Browser.openUrl(loginPage_Url);
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 AdminDiagnostic.SignIn(Admin_Username, Admin_Password);
	}
	

	@DataProvider(name="EditHospital")
	public Object[][] clinicDocInfo() throws Exception
	{
		Object[][] clinicDocInformation=TestUtils.getTableArray("TestData/NewAdmin.xls","Hospital", "EDITHOS");
		return(clinicDocInformation);
	}
	
	

	
	@Test(dataProvider="EditHospital")
	public void EditHospital(String HospitalName) throws Exception{
		
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Hospital_ClickOnHospitalMenu);
		Thread.sleep(2000);
		Browser.enterTextByXpath(Elements_NewAdminDiagnostic.Diagnostic_SearchBox, HospitalName);
		Thread.sleep(2000);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Hospital_ClickOnEdit);
		Browser.waitTill(1000);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Hospital_SelectBikeParking);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Hospital_SelectCarParking);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Hospital_SelectAmbulance);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Hospital_SelectPremiumServices);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Hospital_SelectICU);
		Browser.scrollbyID(Elements_NewAdminDiagnostic.Hospital_Cancel);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Hospital_Save);
		Browser.CheckNotificationMessage("Hospital information saved successfully");
		Thread.sleep(1000);
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "hospital", "name", HospitalName);
	}
	
	@AfterClass
	public void CloseBrowser(){
		driver.quit();
	}
}

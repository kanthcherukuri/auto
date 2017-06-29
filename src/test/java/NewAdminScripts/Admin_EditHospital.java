package NewAdminScripts;

import java.util.concurrent.TimeUnit;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
	 driver.get(doctors_Url);		 
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 AdminDiagnostic=new NewAdminDiagnosticPage(driver);	
	 Browser= new TestUtils(driver);
	 AdminDiagnostic.SignIn(Admin_Username, Admin_Password);
	}
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{"Lucidhospitallfe" }

			};
		}
	
	@Test(dataProvider="DP1")
	public void EditHospital(String HospitalName) throws Exception{
		
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Hospital_ClickOnHospitalMenu);
		Thread.sleep(2000);
		Browser.enterTextByXpath(Elements_NewAdminDiagnostic.Diagnostic_SearchBox, HospitalName);
		Browser.waitforTextbyxpath("//*[@id='DataTables_Table_0']/tbody/tr[1]/td[1]", HospitalName);
		Browser.clickOnTheElementByXpath("//*[@id='DataTables_Table_0']/tbody/tr[1]/td[6]/button");
		Browser.waitTill(1000);
		Browser.clickOnTheElementByXpath("//input[@name='facilities.isBikeParkingAvailableAtTheHospital']");
		Browser.clickOnTheElementByXpath("//input[@name='facilities.isCarParkingAvailableAtTheHospital']");
		Browser.clickOnTheElementByXpath("//input[@name='facilities.hasAmbulance']");
		Browser.clickOnTheElementByXpath("//input[@name='facilities.hasPremiumServicesAtHospital']");
		Browser.clickOnTheElementByXpath("//input[@name='facilities.hasIcuAtHospital']");
		Browser.scrollbyID(Elements_NewAdminDiagnostic.Hospital_Cancel);
		Browser.clickOnTheElementByXpath("//button[@type='submit']");
		Browser.CheckNotificationMessage("Hospital information saved successfully");
		
		
	}

}

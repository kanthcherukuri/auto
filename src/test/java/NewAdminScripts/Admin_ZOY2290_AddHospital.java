package NewAdminScripts;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;


import objectRepository.Elements_NewAdminDiagnostic;
import testBase.LoadPropMac;
import testBase.NewAdminDiagnosticPage;
import testBase.TestUtils;

public class Admin_ZOY2290_AddHospital extends LoadPropMac {
	
	public NewAdminDiagnosticPage AdminDiagnostic;
	public TestUtils Browser;
	
	@BeforeClass	 
	 public void beforeClass() throws Exception {		
	 LoadBrowserProperties();
	 AdminDiagnostic=new NewAdminDiagnosticPage(driver);	
	 Browser= new TestUtils(driver);
	 Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
	 AdminDiagnostic.SignIn(Admin_Username, Admin_Password);
	}
	
	
	@DataProvider(name = "AddHospital")
    public Object[][] createData_DP1() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","Hospital", "ZOY2290");
        return(retObjArr);
    }
	
	
	
	
	@Test(dataProvider="AddHospital")
	public void CheckAddHospital(String HospitalName,String ShortName,String Address,String Country,String State,String City,String pincode,
		String longitude,String latitude) throws Exception{
		
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Hospital_ClickOnHospitalMenu);
		Thread.sleep(2000);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Hospital_ClickOnAdd);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Hospital_ClickOnAdd);
		Browser.enterTextByXpath(Elements_NewAdminDiagnostic.Hospital_HospitalName, HospitalName);
		Browser.enterTextByXpath(Elements_NewAdminDiagnostic.Hospital_ShortName, ShortName);
		Browser.enterTextByXpath(Elements_NewAdminDiagnostic.Hospital_Address, Address);
		Thread.sleep(1000);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Hospital_ClickOnCountry);
		Browser.enterTextByXpath(Elements_NewAdminDiagnostic.Hospital_Country, Country);
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.Hospital_Country)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Hospital_ClickOnState);
		Browser.enterTextByXpath(Elements_NewAdminDiagnostic.Hospital_State, State);
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.Hospital_State)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Hospital_ClickOnCity);
		Browser.enterTextByXpath(Elements_NewAdminDiagnostic.Hospital_City, City);
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.Hospital_City)).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		Browser.enterTextByXpath(Elements_NewAdminDiagnostic.Hospital_Pincode, pincode);
		Browser.enterTextByXpath(Elements_NewAdminDiagnostic.Hospital_Longitude, longitude);
		Browser.enterTextByXpath(Elements_NewAdminDiagnostic.Hospital_Latitude, latitude);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Hospital_CloseContacts);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Hospital_CloseGallery);
		//Awards and Recognitions
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Hospital_CloseAwards);
		// Packages
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Hospital_ClosePackages);
		//Services
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Hospital_CloseServices);
		Browser.scrollbyID(Elements_NewAdminDiagnostic.Hospital_Cancel);
		Thread.sleep(1000);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Hospital_Save);
		Browser.CheckNotificationMessage("Hospital information saved successfully");	
		
		
	}
	
	@AfterClass
	public void closebrowser() {
		driver.quit();
	}

}

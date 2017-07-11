package NewAdminScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_NewAdminDiagnostic;
import testBase.LoadPropMac;
import testBase.NewAdminDiagnosticPage;
import testBase.TestUtils;

public class Admin_ZOY2364_MergeNames extends LoadPropMac{
	
	public NewAdminDiagnosticPage AdminDiagnostic;
	public TestUtils Browser;
	
	@BeforeClass	 
	 public void LaunchBrowser() throws Exception {		
	 LoadBrowserProperties(); 
	 AdminDiagnostic=new NewAdminDiagnosticPage(driver);	
	 Browser= new TestUtils(driver);
	 Browser.openUrl(loginPage_Url);
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 AdminDiagnostic.SignIn(Admin_Username, Admin_Password);
	 Thread.sleep(2000);
	 
	  }
	
	@Test
	public void CheckMergeNames() throws Exception{
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Admin_ClickOnAdministrationMenu);
		Browser.scrollbyxpath(Elements_NewAdminDiagnostic.Administration_MergeNamesMenu);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Administration_MergeNamesMenu);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.MergeName_SelectType);
		Browser.selectbyID(Elements_NewAdminDiagnostic.MergeName_SelectType, "Specialisation");
		Browser.selectbyID(Elements_NewAdminDiagnostic.MergeName_FromValue, "Unispec");
		Browser.selectbyID(Elements_NewAdminDiagnostic.MergeName_ToValue,"Antispec");
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.MergeName_Submit);
		Browser.CheckNotificationMessage("Updated Successfully. Please check after 2 hours.");
		Thread.sleep(6000);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Admin_ClickOnDoctorMenu);
		Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.Admin_Serachbox);
		driver.navigate().refresh();
		Browser.enterTextByXpath(Elements_NewAdminDiagnostic.Admin_Serachbox, "excel4@zoy.com");
		Thread.sleep(2000);
		String speciallisation=driver.findElement(By.xpath(Elements_NewAdminDiagnostic.Doctor_GetSpecialisation)).getText();
		System.out.println("speciallisation Name ="+speciallisation);
		Assert.assertEquals(speciallisation,"Antispec" );
		Thread.sleep(2000);
	}
	@AfterMethod
	public void MakeSpecialisationDefault(){
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Admin_ClickOnAdministrationMenu);
		Browser.scrollbyxpath(Elements_NewAdminDiagnostic.Administration_MergeNamesMenu);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Administration_MergeNamesMenu);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.MergeName_SelectType);
		Browser.selectbyID(Elements_NewAdminDiagnostic.MergeName_SelectType, "Specialisation");
		Browser.selectbyID(Elements_NewAdminDiagnostic.MergeName_FromValue, "Unispec");
		Browser.selectbyID(Elements_NewAdminDiagnostic.MergeName_ToValue,"Antispec");
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.MergeName_Submit);
		Browser.CheckNotificationMessage("Updated Successfully. Please check after 2 hours.");
	}
	
	@AfterClass
	public void CloseBrowser(){
		driver.quit();
	}

}

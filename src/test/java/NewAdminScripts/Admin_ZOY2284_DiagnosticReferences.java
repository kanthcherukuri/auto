

//@author:Ch.Lakshmi kanth
package NewAdminScripts;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

import org.testng.annotations.DataProvider;

import objectRepository.Elements_NewAdminDiagnostic;
import testBase.LoadPropMac;
import testBase.NewAdminDiagnosticPage;
import testBase.TestUtils;

public class Admin_ZOY2284_DiagnosticReferences extends LoadPropMac {
	
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
	
	@DataProvider(name = "DiagnosticReferences")
    public Object[][] createData_DP1() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","StatusChange", "ZOY2284");
        return(retObjArr);
    }

 
	@Test(dataProvider="DiagnosticReferences")
	public void CheckDiagnosticReferences(String entityname,String entityshortchname,String entitydescchname,String synonymname,
			String Editentityname,String Editentityshortchname,String Editentitydescchname) throws Exception{
		AdminDiagnostic.ClickOnDiagnosticMenu();
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.References_ClickReferencemenu)).click();
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.References_ClickOnTestsMenu)).click();
		Browser.maximizechromebrowser();
		Browser.waitFortheID(Elements_NewAdminDiagnostic.References_ClickOnAddButton);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.References_ClickOnAddButton);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.References_EntityName, entityname);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.References_EntityShortName, entityshortchname);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.References_Description, entitydescchname);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.References_Activate);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.References_AddSynonym);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.References_SynonymName, synonymname);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.References_SaveSynonym);
		String name=driver.findElement(By.xpath(Elements_NewAdminDiagnostic.References_CheckSynonymName)).getText();
		System.out.println(name);
		Assert.assertEquals(name, synonymname);
		Thread.sleep(2000);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.References_Save);
		Browser.CheckNotificationMessage("Standard Test created successfully");
		Thread.sleep(2000);
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.Diagnostic_SearchBox)).sendKeys(entityname);
		Thread.sleep(2000);
		Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.References_Edit);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.References_Edit);
		Thread.sleep(2000);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.References_EntityName);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.References_EntityName)).clear();
		Browser.enterTextByID(Elements_NewAdminDiagnostic.References_EntityName, Editentityname);
		System.out.println("EntityName="+Editentityname);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.References_EntityShortName);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.References_EntityShortName)).clear();
		Browser.enterTextByID(Elements_NewAdminDiagnostic.References_EntityShortName, Editentityshortchname);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.References_Description)).clear();
		Browser.enterTextByID(Elements_NewAdminDiagnostic.References_Description, Editentitydescchname);
		Thread.sleep(2000);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.References_Save);
		Browser.CheckNotificationMessage("Standard Test Updated successfully");
		Thread.sleep(3000);
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "zyDiagnosticCenterStandardTest", "entityName", Editentityname);
	}
	
	@AfterClass
	public void CloseBrowser(){
		driver.quit();
	}
	
	
}

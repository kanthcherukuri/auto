package NewAdminScripts;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import objectRepository.Elements_NewAdminDiagnostic;
import testBase.LoadPropMac;
import testBase.NewAdminDiagnosticPage;
import testBase.TestUtils;

public class Admin_EditDiagnostic extends LoadPropMac {
	
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
	
	@DataProvider(name="EditDiagnosticDetails")
    public Object[][] createData_DP1() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","EditDiagnostic", "TC1");
        return(retObjArr);
    }
 
	
	@Test(dataProvider="EditDiagnosticDetails")
	public void EditDiagnostic(String DiagnosticEmail,String EditPackageName,String EditDiscountPercentage,String EditZoyloPercentage,String EditDiscountPercentageOne,
	String EditZoyloPercentageOne,String EditdiagTestname,String Editdiagdiscountper,String EditdiagZoyloper,String DiagnosticName) throws Exception{
		AdminDiagnostic.ClickOnDiagnosticMenu();
		//Thread.sleep(2000);
		Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.Diagnostic_SearchBox);
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.Diagnostic_SearchBox)).sendKeys(DiagnosticEmail);
		Browser.waitforTextbyxpath("//*[@id='DataTables_Table_0']/tbody/tr/td[3]", DiagnosticEmail);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Diagnostic_ClickOnEdit);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.DiagnosticCenter_Name);
		AdminDiagnostic.ClickOnPackageAndTestsMenu();
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.HealthPackage_ClickOnEditButton);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.HealthPackage_packageName);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_packageName)).clear();
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_packageName)).sendKeys(EditPackageName);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_discountPercentage)).clear();
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_discountPercentage)).sendKeys(EditDiscountPercentage);
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_zoyloChargePercentage)).clear();
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_zoyloChargePercentage)).sendKeys(EditZoyloPercentage);
		Thread.sleep(2000);
		AdminDiagnostic.SaveAddHealthPackages();
		Thread.sleep(2000);
		String changedpackname=driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HealthPackage_CheckPackageName)).getText();
		System.out.println("Changed Package Name ;"+changedpackname);
		Assert.assertEquals(changedpackname, EditPackageName);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.DiagnosticTests_Menu);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_Menu)).click();
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.DiagnosticTests_ClickOnEdit)).click();
		Browser.waitFortheID(Elements_NewAdminDiagnostic.DiagnosticTests_EditTestName);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_EditTestName)).clear();
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_EditTestName)).sendKeys(EditdiagTestname);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_EditDiscountPercentage)).clear();
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_EditDiscountPercentage)).sendKeys(Editdiagdiscountper);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_EditZoyloCharge)).clear();
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_EditZoyloCharge)).sendKeys(EditdiagZoyloper);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_EditTestSave)).click();
		//driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_EditCancel)).click();
		Thread.sleep(8000);
		String diagtestname=driver.findElement(By.xpath(Elements_NewAdminDiagnostic.DiagnosticTests_CheckTestName)).getText();
		Assert.assertEquals(diagtestname, EditdiagTestname);
		driver.findElement(By.id("editDiagnosticSubmit")).click();
		Browser.CheckNotificationMessage("Diagnostic Center Updated Successfully");
		String dcID=Browser.mongoDB_getID("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "zyDiagnosticCenters", "user.email", DiagnosticEmail);
		System.out.println("DC ID retrived is: "+dcID);
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "users", "username", DiagnosticEmail);
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "zyDiagnosticCenters", "user.email", DiagnosticEmail);
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "zyGlobalGenericSearch", "entityId", dcID);
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "redisProvidersCache", "providerId", dcID);
	}
	
	@AfterClass
	public void CloseBrowser(){
		driver.quit();
	}

}

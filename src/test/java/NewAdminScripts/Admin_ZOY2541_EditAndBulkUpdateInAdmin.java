
//@author:Ch.LakshmiKanth

package NewAdminScripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import objectRepository.Elements_NewAdminDiagnostic;
import testBase.LoadPropMac;
import testBase.NewAdminDiagnosticPage;
import testBase.TestUtils;

public class Admin_ZOY2541_EditAndBulkUpdateInAdmin extends LoadPropMac{
	
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
	
	
	@DataProvider(name="EditAndBulkUpdateDiagnosticDetails")
    public Object[][] createData_DP1() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","EditDiagnostic", "TC1");
        return(retObjArr);
    }
	
	
	@Test(dataProvider="EditAndBulkUpdateDiagnosticDetails",priority=1)
	public void CheckEditAndBulkUpdateFunctionality(String DiagnosticEmail,String EditPackageName,String EditDiscountPercentage,String EditZoyloPercentage,String EditDiscountPercentageOne,
			String EditZoyloPercentageOne,String EditdiagTestname,String Editdiagdiscountper,String EditdiagZoyloper,String DiagnosticName ) throws Exception {
		
		
		AdminDiagnostic.ClickOnDiagnosticMenu();
		Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.Diagnostic_SearchBox);
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.Diagnostic_SearchBox)).sendKeys(DiagnosticEmail);
		Browser.waitforTextbyxpath("//*[@id='DataTables_Table_0']/tbody/tr/td[3]", DiagnosticEmail);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Diagnostic_ClickOnEdit);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.DiagnosticCenter_Name);
		AdminDiagnostic.ClickOnBulkUpdateTab();
		AdminDiagnostic.BulkUpdateSelection("10", "10", "Lab Visit", "Both");
		Browser.CheckNotificationMessage("Diagnostic Center Bulk Updated Successfully");
		Browser.waitFortheElementXpath("//*[@id='zyDCMandatoryFields']//a[@href='#zyDiagMandatoryFields']");
		AdminDiagnostic.ClickOnPackageAndTestsMenu();
		String discount=Browser.getTextByXpath(Elements_NewAdminDiagnostic.HealthPackage_CheckDiscount);
		String ZFC=Browser.getTextByXpath(Elements_NewAdminDiagnostic.HealthPackage_CheckZFC);
		Assert.assertEquals(discount, "10");
		Assert.assertEquals(ZFC, "10");
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.HealthPackage_ClickOnEditButton);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.HealthPackage_packageName);
		Browser.selectbyID("serviceMode", "Home Visit");
		Browser.clickOnTheElementByID("diagPackagesSave");
		Browser.CheckNotificationMessage("Package updated successfully");
		//Thread.sleep(2000);
		String packservicemode=Browser.getTextByXpath(Elements_NewAdminDiagnostic.HealthPackage_CheckServiceMode);
		Assert.assertEquals(packservicemode,"Home Visit");
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.DiagnosticTests_Menu);
		String testdis=Browser.getTextByXpath(Elements_NewAdminDiagnostic.DiagnosticTests_CheckDiscount);
		String testZFC=Browser.getTextByXpath(Elements_NewAdminDiagnostic.DiagnosticTests_CheckZFC);
		Assert.assertEquals(testdis,"10");
		Assert.assertEquals(testZFC,"10");
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.DiagnosticTests_ClickOnEdit);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.DiagnosticTests_EditTestName);
		Browser.selectbyID("diagEditServiceMode", "Home Visit");
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.DiagnosticTests_EditTestSave);
		Browser.CheckNotificationMessage("Test updated successfully");
		Thread.sleep(2000);
		String testservicemode=Browser.getTextByXpath(Elements_NewAdminDiagnostic.DiagnosticTests_CheckServiceMode);
		Assert.assertEquals(testservicemode, "Home Visit");
		Thread.sleep(1000);
		AdminDiagnostic.ClickOnBulkUpdateTab();
		AdminDiagnostic.BulkUpdateSelection("20", "5", "Home Visit", "Both");
		Browser.CheckNotificationMessage("Diagnostic Center Bulk Updated Successfully");
		Thread.sleep(2000);
		AdminDiagnostic.ClickOnPackageAndTestsMenu();
		String discountone=Browser.getTextByXpath(Elements_NewAdminDiagnostic.HealthPackage_CheckDiscount);
		String ZFCone=Browser.getTextByXpath(Elements_NewAdminDiagnostic.HealthPackage_CheckZFC);
		Assert.assertEquals(discountone, "20");
		Assert.assertEquals(ZFCone, "5");
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.DiagnosticTests_Menu);
		String testdisone=Browser.getTextByXpath(Elements_NewAdminDiagnostic.DiagnosticTests_CheckDiscount);
		String testZFCone=Browser.getTextByXpath(Elements_NewAdminDiagnostic.DiagnosticTests_CheckZFC);
		Assert.assertEquals(testdisone,"20");
		Assert.assertEquals(testZFCone,"5");
	
	}
	
	//2629 
	@Test(priority=2)
	public void CheckAddPackageInEdit() throws Exception {
		AdminDiagnostic.ClickOnPackageAndTestsMenu();
		Browser.clickOnTheElementByXpath("//a[@href='#zoyDiagPackHealth']");
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.HealthPackage_AddPackage);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.HealthPackage_Status);
		Browser.selectbyID(Elements_NewAdminDiagnostic.HealthPackage_Status, "Approved");
		Browser.selectbyID("serviceMode", "Lab & Home Visit");
		Browser.enterTextByID(Elements_NewAdminDiagnostic.HealthPackage_packageName, "SnidgaPack");
		Browser.enterTextByID(Elements_NewAdminDiagnostic.HealthPackage_packageCost, "30000");
		Browser.enterTextByID(Elements_NewAdminDiagnostic.HealthPackage_discountPercentage, "10");
		Browser.enterTextByID(Elements_NewAdminDiagnostic.HealthPackage_zoyloChargePercentage, "5");
		Browser.clickOnTheElementByID("isPackagesActive");
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HealthPackage_Save);
		Browser.CheckNotificationMessage("Package Added successfully");
		
	}
	
	
	//2539 Changes in Add Test Screen
	@Test(dataProvider="EditAndBulkUpdateDiagnosticDetails",priority=3)
	public void CheckAddTestScreenInEdit(String DiagnosticEmail,String EditPackageName,String EditDiscountPercentage,String EditZoyloPercentage,String EditDiscountPercentageOne,
		String EditZoyloPercentageOne,String EditdiagTestname,String Editdiagdiscountper,String EditdiagZoyloper,String DiagnosticName) throws Exception {
		AdminDiagnostic.ClickOnPackageAndTestsMenu();
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.DiagnosticTests_Menu);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.DiagnosticTests_AddTests);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.DiagnosticTests_AdminStatus);
		Browser.selectbyID("diagServiceMode", "Lab & Home Visit");
		Browser.enterTextByID(Elements_NewAdminDiagnostic.DiagnosticTests_DiscountPercentage, "10");
		Browser.enterTextByID(Elements_NewAdminDiagnostic.DiagnosticTests_ZoyloChargePercentage, "2");
		Browser.enterTextByXpath("(//*[@id='diagTestName'])[last()]", "PrasadTest");
		Browser.enterTextByXpath("(//*[@id='diagAddTestCost'])[last()]", "20000");
		Browser.clickOnTheElementByXpath("(//button[contains(.,' Save')])[last()]");
		Browser.CheckNotificationMessage("Dc Test Added successfully");
		Thread.sleep(1000);
		Browser.clickOnTheElementByXpath("(//button[@id='zyAddDcTestClone'])[last()]");
		Browser.enterTextByXpath("(//*[@id='diagTestName'])[last()]", "PrasadTestone");
		Browser.enterTextByXpath("(//*[@id='diagAddTestCost'])[last()]", "25000");
		Browser.clickOnTheElementByXpath("(//button[contains(.,' Save')])[last()]");
		Browser.CheckNotificationMessage("Dc Test Added successfully");
		Browser.clickOnTheElementByXpath("(//*[@id='zoyPackageTestCancel'])[2]");	
		
	}
	
	
	
	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}

}

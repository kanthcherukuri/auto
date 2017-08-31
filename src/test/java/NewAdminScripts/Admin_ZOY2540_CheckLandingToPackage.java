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
import testBase.RecipientPage;
import testBase.TestUtils;

public class Admin_ZOY2540_CheckLandingToPackage extends LoadPropMac{
	
	public NewAdminDiagnosticPage AdminDiagnostic;
	public TestUtils Browser;
	public RecipientPage Recipient;
	
	@BeforeClass	 
	 public void beforeClass() throws Exception {		
	 LoadBrowserProperties();
	 AdminDiagnostic=new NewAdminDiagnosticPage(driver);	
	 Recipient = new RecipientPage(driver);
	 Browser= new TestUtils(driver);
	 Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
	 AdminDiagnostic.SignIn(Admin_Username, Admin_Password);
	  }
	
	@DataProvider(name="LandingToPackage")
    public Object[][] createData_DP1() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","EditDiagnostic", "TC1");
        return(retObjArr);
    }
	
	@Test(dataProvider="LandingToPackage")
	public void CheckPackageTabIsSelecetedByDefault(String DiagnosticEmail,String EditPackageName,String EditDiscountPercentage,String EditZoyloPercentage,String EditDiscountPercentageOne,
			String EditZoyloPercentageOne,String EditdiagTestname,String Editdiagdiscountper,String EditdiagZoyloper,String DiagnosticName) throws Exception {
		
		AdminDiagnostic.ClickOnDiagnosticMenu();
		Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.Diagnostic_SearchBox);
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.Diagnostic_SearchBox)).sendKeys(DiagnosticEmail);
		Browser.waitforTextbyxpath("//*[@id='DataTables_Table_0']/tbody/tr/td[3]", DiagnosticEmail);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Diagnostic_ClickOnEdit);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.DiagnosticCenter_Name);
		Browser.clickOnTheElementByID("landingToPackage");
		Browser.clickOnTheElementByID("editDiagnosticSubmit");
		Browser.CheckNotificationMessage("Diagnostic Center Updated Successfully");
		Thread.sleep(3000);
		Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.Diagnostic_ClickOnLoginUser);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Diagnostic_ClickOnLoginUser);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Diagnostic_Logout);
		Thread.sleep(3000);
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/index");
		Browser.clickOnTheElementByXpath("//li[@id='diagnostics']//span/img");
		Recipient.searchDCInZoyloMAP(DiagnosticName);
		Recipient.bookAppointmentOnDiagnostics();
		Thread.sleep(1000);
		String landpage=driver.findElement(By.xpath("//li[@class='zy-rec-diag-s-apt-tabs-li active']")).getAttribute("id");
		System.out.println("Getting Id Value:"+landpage);
		Assert.assertEquals(landpage, "package-li");
	}
	
	
	@AfterClass
	public void ClsoeBrowser() {
		driver.quit();
	}

}

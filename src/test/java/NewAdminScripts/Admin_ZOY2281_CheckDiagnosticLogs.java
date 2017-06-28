package NewAdminScripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import objectRepository.Elements_Diagnostics;
import objectRepository.Elements_NewAdminDiagnostic;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.NewAdminDiagnosticPage;
import testBase.TestUtils;

public class Admin_ZOY2281_CheckDiagnosticLogs extends LoadPropMac{
	
	public NewAdminDiagnosticPage AdminDiagnostic;
	public TestUtils Browser;
	public DiagnosticPage DiagnosticPage;
	
	@BeforeClass	 
	 public void launchbrowser() throws Exception {		
	 LoadBrowserProperties();
	 driver.get(doctors_Url);	 
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 AdminDiagnostic=new NewAdminDiagnosticPage(driver);	
	 Browser= new TestUtils(driver);
	 DiagnosticPage=new DiagnosticPage(driver);
	 DiagnosticPage.SignIn(Diagnostic_usernamesix, Diagnostic_passwordsix);
	}
	
	
	@DataProvider(name = "DiagnosticLogs")
    public Object[][] createData_DP1() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","StatusChange", "ZOY2281");
        return(retObjArr);
    }
 		
 		
	  @Test(dataProvider="DiagnosticLogs")
	  public void CheckDiagnosticLogs(String packagename,String cost) throws Exception{
		  
		  DiagnosticPage.ClickOnScheduleMenu();
		  DiagnosticPage.ScheduleClickOnDiagnosticManage();
		  Browser.clickOnTheElementByXpath(Elements_Diagnostics.clickonpackagemenu);
		  Browser.clickOnTheElementByXpath(Elements_Diagnostics.ManagePackageEditlink);
		  Browser.waitFortheElementXpath(Elements_Diagnostics.ManagePackagename);
		  driver.findElement(By.xpath(Elements_Diagnostics.ManagePackagename)).clear();
		  Browser.enterTextByXpath(Elements_Diagnostics.ManagePackagename, packagename);
		  Browser.waitFortheElementXpath(Elements_Diagnostics.ManagePackagecost);
		  driver.findElement(By.xpath(Elements_Diagnostics.ManagePackagecost)).clear();
		  Browser.enterTextByXpath(Elements_Diagnostics.ManagePackagecost, cost);
		  Browser.clickOnTheElementByID(Elements_Diagnostics.ManagePackageSavePackage);
		  DiagnosticPage.diagnosticlogout();
		  Browser.openUrl(doctors_Url);
		  DiagnosticPage.SignIn("kanthl@zoylo.com", "Zoylo@123");
		  Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Diagnostic_Menu);
		  driver.get(Elements_NewAdminDiagnostic.DiagnosticLogs_url);
		  Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.Diagnostic_SearchBox);
		  Browser.enterTextByXpath(Elements_NewAdminDiagnostic.Diagnostic_SearchBox, packagename);
		  Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.DiagnosticLogs_NewCost);
		  Thread.sleep(2000);
		  String newcost= driver.findElement(By.xpath(Elements_NewAdminDiagnostic.DiagnosticLogs_NewCost)).getText();
		  System.out.println(newcost);
		  if(newcost.equalsIgnoreCase(cost)){
			 System.out.println("Updated Package Cost Verified SuccessFully");
		  }else{
			  Assert.fail();
		  } 
	  }

}

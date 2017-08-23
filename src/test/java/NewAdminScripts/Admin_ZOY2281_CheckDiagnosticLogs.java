package NewAdminScripts;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
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
	 AdminDiagnostic=new NewAdminDiagnosticPage(driver);	
	 Browser= new TestUtils(driver);
	 Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 DiagnosticPage=new DiagnosticPage(driver);
	 DiagnosticPage.SignIn(DiagnosticLogin_usernamefive, DiagnosticLogin_passwordfive);
	}
	
//	
//	@DataProvider(name = "DiagnosticLogs")
//    public Object[][] createData_DP1() throws Exception{
//        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","StatusChange", "ZOY2281");
//        return(retObjArr);
//    }
 		
 		
	  @Test
	  public void CheckDiagnosticLogs() throws Exception{
		  int Phno = (int )(Math.random() *100000);
		  String price=Integer.toString(Phno);
		  String name="Divya"+Browser.randomalphabets();
		  System.out.println("Package Name is :"+name);
		  DiagnosticPage.ClickOnScheduleMenu();
		  DiagnosticPage.ScheduleClickOnDiagnosticManage();
		  Browser.clickOnTheElementByXpath(Elements_Diagnostics.clickonpackagemenu);
		  Browser.clickOnTheElementByXpath(Elements_Diagnostics.ManagePackageEditlink);
		  Browser.waitFortheElementXpath(Elements_Diagnostics.ManagePackagename);
		  driver.findElement(By.xpath(Elements_Diagnostics.ManagePackagename)).clear();
		  Browser.enterTextByXpath(Elements_Diagnostics.ManagePackagename, name);
		  Browser.waitFortheElementXpath(Elements_Diagnostics.ManagePackagecost);
		  driver.findElement(By.xpath(Elements_Diagnostics.ManagePackagecost)).clear();
		  Browser.enterTextByXpath(Elements_Diagnostics.ManagePackagecost, price);
		  Browser.clickOnTheElementByID(Elements_Diagnostics.ManagePackageSavePackage);
		  DiagnosticPage.diagnosticlogout();
		  Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		  DiagnosticPage.SignIn("kanthl@zoylo.com", "Zoylo@123");
		  Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Diagnostic_Menu);
		  Browser.waitTill(2000);
		  Browser.waitFortheElementXpath("//a[@href='/admin/zyDiagnosticCenterPackagesAndTestsLogList']");
		  Browser.clickOnTheElementByXpath("//a[@href='/admin/zyDiagnosticCenterPackagesAndTestsLogList']");
		  
		  //driver.get(Elements_NewAdminDiagnostic.DiagnosticLogs_url);
		  Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.Diagnostic_SearchBox);
		  Browser.enterTextByXpath(Elements_NewAdminDiagnostic.Diagnostic_SearchBox, name);
		  Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.DiagnosticLogs_NewCost);
		  Thread.sleep(2000);
		  String newcost= driver.findElement(By.xpath(Elements_NewAdminDiagnostic.DiagnosticLogs_NewCost)).getText();
		  System.out.println(newcost);
		  if(newcost.equalsIgnoreCase(price)){
			 System.out.println("Updated Package Cost Verified SuccessFully");
		  }else{
			  Assert.fail();
		  } 
	  }

	  @AfterClass
	  public void CloseBrowser(){
		  driver.quit();
	  }
	  
}

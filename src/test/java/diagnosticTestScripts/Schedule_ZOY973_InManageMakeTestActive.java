package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY973_InManageMakeTestActive  extends LoadPropMac{
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	@BeforeClass
	  public void launchbrowser() throws Exception {
		LoadBrowserProperties();
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 Browser.openUrl(loginPage_Url);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		  }
	
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Pasmmarrupack","Full Body Blood Test for Malaria","10000","5"}

			};
		}

	@Test(dataProvider="DP1")
	public void ScheduleManageMakeTestActive(String RunMode,String testname,String description,String cost,String discount) throws Exception{
		
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		DiagnosticPageZoylo.ScheduleClickOnDiagnosticManage();
		DiagnosticPageZoylo.ScheduleDiagnosticManageClickonTestsMenu();
		DiagnosticPageZoylo.ScheduleDiagnosticManageAddTests(testname, description, cost, discount);
		Thread.sleep(2000);
		DiagnosticPageZoylo.ClickOnToggletoSubmitTestsForApproval();
		//Thread.sleep(3000);
		DiagnosticPageZoylo.diagnosticlogout();
		Browser.openUrl(loginPage_Url);
		DiagnosticPageZoylo.SignIn("kanthl@zoylo.com","Zoylo@123");
		Browser.waitTill(2000);
		Browser.clickOnTheElementByXpath("//a[@href='/admin/zyDiagnosticCenters']");
		Browser.waitFortheElementXpath("//a[@href='/admin/zyDiagnosticCenterPackagesAndTestApprovalsList']");
		Browser.clickOnTheElementByXpath("//a[@href='/admin/zyDiagnosticCenterPackagesAndTestApprovalsList']");
		Thread.sleep(1000);
		//driver.get( Diagnostic_ApprovedApptURL);
		DiagnosticPageZoylo.ApproveTestInAdmin(testname);
		Thread.sleep(5000);
		Browser.waitFortheElementXpath("html/body/div[6]/header/div[2]/ul/li/div/button");
		Browser.clickOnTheElementByXpath("html/body/div[6]/header/div[2]/ul/li/div/button");
		Thread.sleep(2000);
		Browser.clickOnTheElementByID("logout");
		Thread.sleep(3000);
		Browser.openUrl(loginPage_Url);
		DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		DiagnosticPageZoylo.ScheduleClickOnDiagnosticManage();
		DiagnosticPageZoylo.ScheduleDiagnosticManageClickonTestsMenu();
		Thread.sleep(2000);
		WebElement sc=driver.findElement(By.xpath("(//span[@class='sp-diag-dcenter-packactive-hours-switch-switch'])[last()]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(sc).click().perform();
		Thread.sleep(3000);
		driver.findElement(By.id("saveClinicTests")).click();
		Thread.sleep(2000);
		Browser.CheckNotificationMessage("Tests updated successfully");
		Thread.sleep(2000);
		DiagnosticPageZoylo.diagnosticslogout();
	}

	@AfterClass
		public void closebrowser(){
		driver.quit();
	}
}

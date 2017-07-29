package diagnosticTestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Diagnostics;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import java.util.concurrent.TimeUnit;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY997_HomePickupApprovalMakeActiveForTest extends LoadPropMac{
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	

	@BeforeClass
	  public void launchbrowser() throws Exception {
		LoadBrowserProperties();
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 Browser.openUrl(loginPage_Url);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DiagnosticPageZoylo.SignIn(Diagnostic_username, Diagnostic_password);
		  }
	
	
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","kormangaltest","Full Body Test","10000","5"}

			};
		}

	@Test(dataProvider="DP1")
	public void ScheduleHomePickupTestMakeActiveInActive(String RunMode, String testname,String description,String cost,String discount) throws Exception{
	
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		DiagnosticPageZoylo.clickonhomevisitmenu();
		DiagnosticPageZoylo.ScheduleHomePickUpAddTest(testname, description, cost, discount);
		Thread.sleep(3000);
		DiagnosticPageZoylo.ScheduleHomePickupSubmitTestsForApproval();
		Thread.sleep(2000);
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
		DiagnosticPageZoylo.SignIn(Diagnostic_username, Diagnostic_password);
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		DiagnosticPageZoylo.clickonhomevisitmenu();
		WebElement sc=driver.findElement(By.xpath("(//span[@class='sp-diag-homepick-packactive-hours-switch-switch'])[last()]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(sc).click().perform();
		Thread.sleep(3000);
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickhomevisittestsavebutton);
  		Browser.CheckNotificationMessage("Home Visit Tests updated successfully");
		Thread.sleep(2000);
		DiagnosticPageZoylo.diagnosticslogout();
	}
	
	@AfterClass
	public void closebrowser(){
		driver.quit();
	}
}

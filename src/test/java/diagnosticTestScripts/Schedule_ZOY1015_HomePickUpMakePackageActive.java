package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;

import org.testng.annotations.DataProvider;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY1015_HomePickUpMakePackageActive extends LoadPropMac{
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	@BeforeClass
	public void launchbrowser() throws Exception {
		LoadBrowserProperties();
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DiagnosticPageZoylo.SignIn(Diagnostic_usernamesix, Diagnostic_passwordsix);
	  }
	
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Full Body Test","10000","5","Kuppamtest","Full Body Test"}

			};
		}
	
	@Test(dataProvider="DP1")
	public void HomePickupMakePackageActive(String RunMode,String desc,String cost,String discount,String testname,String testdesc) throws Exception{
		 String packagename="chilukuri"+Browser.randomalphabets();
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		DiagnosticPageZoylo.clickonhomevisitmenu();
		DiagnosticPageZoylo.ClickOnSchedulePackageHomePickUp();
		DiagnosticPageZoylo.ScheduleHomePickUpAddPackage(packagename, desc, cost, discount, testname, testdesc);
		DiagnosticPageZoylo.ScheduleHomePickUpPackageSendforApproval();
		DiagnosticPageZoylo.diagnosticlogout();
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		DiagnosticPageZoylo.SignIn("kanthl@zoylo.com","Zoylo@123");
		Browser.waitTill(2000);
		Browser.clickOnTheElementByXpath("//a[@href='/admin/zyDiagnosticCenters']");
		Browser.clickOnTheElementByXpath("//a[@href='/admin/zyDiagnosticCenterPackagesAndTestApprovalsList']");
		DiagnosticPageZoylo.ApproveTestInAdmin(packagename);
		//Thread.sleep(6000);
		Browser.clickOnTheElementByXpath("//button[@class='btn btn-default dropdown-toggle']");
		Thread.sleep(1000);
		Browser.clickOnTheElementByID("logout");
		Thread.sleep(3000);
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		DiagnosticPageZoylo.SignIn(Diagnostic_usernamesix, Diagnostic_passwordsix);
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		DiagnosticPageZoylo.clickonhomevisitmenu();
		DiagnosticPageZoylo.ClickOnSchedulePackageHomePickUp();
		WebElement sc=driver.findElement(By.xpath("(//*[@class='sp-diag-homepick-pack-docard homeVisitPackages pckgIndex']/div[1]/div[2]/div/label/span[2])[last()]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(sc).click().perform();
		Thread.sleep(3000);
		driver.findElement(By.id("homeVisitPackages")).click();
		Thread.sleep(1000);
		Browser.CheckNotificationMessage("Home Visit Packages updated successfully");
		
		
	}
   @AfterClass
   public void closebrowser(){
	  driver.quit();
   }
	
}

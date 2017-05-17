package diagnosticTestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY1015_HomePickUpMakePackageActive extends LoadPropMac{
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	@BeforeClass
	public void launchbrowser() throws Exception {
	LoadBrowserProperties();
	 driver.manage().window().maximize();
	 driver.get(doctors_Url);		 
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 DiagnosticPageZoylo=new DiagnosticPage(driver);
	 Browser=new TestUtils(driver);
	 DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
	  }
	
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Kothapalli","Full Body Test","10000","2","KothapalliTest","Full Body Test"}

			};
		}
	
	@Test(dataProvider="DP1")
	public void HomePickupMakePackageActive(String RunMode,String packagename,String desc,String cost,String discount,String testname,String testdesc) throws Exception{
		
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		Thread.sleep(1000);
		DiagnosticPageZoylo.clickonhomevisitmenu();
		Thread.sleep(1000);
		DiagnosticPageZoylo.ClickOnSchedulePackageHomevisit();
		Thread.sleep(1000);
		int toggle=	DiagnosticPageZoylo.ScheduleHomevisitAddPackage(packagename, desc, cost, discount, testname, testdesc);
		System.out.println("ToggleValue is:"+toggle);
		Thread.sleep(2000);
		DiagnosticPageZoylo.ScheduleHomevisitPackageSendforApproval(toggle);
		Thread.sleep(2000);
		driver.close();
		DiagnosticPageZoylo.LaunchBrowserToLoginIntoAdminAccount("laKSHMikanth@zoylo.com","Zoylo@123" );
		Thread.sleep(2000);
		DiagnosticPageZoylo.ApproveTestInAdmin(packagename);
		Thread.sleep(1000);
		launchbrowser();
		Thread.sleep(2000);
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		Thread.sleep(2000);
		DiagnosticPageZoylo.clickonhomevisitmenu();
		Thread.sleep(2000);
		DiagnosticPageZoylo.ClickOnSchedulePackageHomevisit();
		Thread.sleep(4000);
		WebElement sc=driver.findElement(By.xpath("//*[@id='"+toggle+"']/div[1]/div[2]/div/label/span[2]"));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sc);
		Actions actions = new Actions(driver);

		actions.moveToElement(sc).click().perform();
		//driver.findElement(By.xpath("//*[@id='"+toggle+"']/div[1]/div[2]/div/label")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("homeVisitPackages")).click();
		Browser.CheckNotificationMessage("Home Visit Packages updated successfully");
		
	}
   @AfterClass
   public void closebrowser(){
	   driver.close();
   }
	
}

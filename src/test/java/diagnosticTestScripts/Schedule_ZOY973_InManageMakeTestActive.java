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
					{ "yes","Bhavaniisland","Full Body Blood Test for Malaria","10000","5"}

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
		Thread.sleep(3000);
		driver.close();
		DiagnosticPageZoylo.LaunchBrowserToLoginIntoAdminAccount("kanthl@zoylo.com", "Zoylo@123");
		DiagnosticPageZoylo.ApproveTestInAdmin(testname);
		Thread.sleep(2000);
		launchbrowser();
		Thread.sleep(2000);
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

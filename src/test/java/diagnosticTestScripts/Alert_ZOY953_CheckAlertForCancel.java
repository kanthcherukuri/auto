package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;




import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Alert_ZOY953_CheckAlertForCancel extends LoadPropMac{
	
	public DiagnosticPage DiagnosticPage;
	public TestUtils Browser;
	
	@BeforeClass
	  public void LaunchBrowser() throws Exception {
		LoadBrowserProperties();
		 driver.get("https://"+Environment_Name+".zoylo.com/login");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DiagnosticPage=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 DiagnosticPage.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		  }
	
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Somalia","S","9655559923","somalia@gmail.com","Diabetic" }
	
			};
		}

	@Test(dataProvider="DP1")
	public void CheckAlertforDiagnosticAppointmentCancel(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		
		DiagnosticPage.DiagnosticAppointmentbookingForTomorrow(firstname, lastname, mobile, email, problem);
		Thread.sleep(1000);
		DiagnosticPage.clickingonappointmentmodification();
		Thread.sleep(2000);
		String Id=DiagnosticPage.GetDiagnosticAppointmentId();
		System.out.println(Id);
		Thread.sleep(1000);
		DiagnosticPage.CancelAppointmentOfHomeVisit();
		Thread.sleep(2000);
		DiagnosticPage.clickOnAlertMenu();
		String alert=driver.findElement(By.xpath("(//*[@id='message'])[1]")).getText();
		System.out.println(alert);
		Assert.assertTrue(alert.contains("You have CANCELLED the lab visit appointment of "+firstname));
		Thread.sleep(1000);
		Assert.assertTrue(alert.contains(Id));
		
		
		
		
	}
	
	@AfterMethod()
	public void bulkcancelandlogout() throws Exception{
		DiagnosticPage.DiagnosticAppointmentsBulkCancellation("07:00", "23:00");
		DiagnosticPage.diagnosticlogout();
		}
	
	
	@AfterClass
	public void closebrowser(){
		driver.quit();
	}
}

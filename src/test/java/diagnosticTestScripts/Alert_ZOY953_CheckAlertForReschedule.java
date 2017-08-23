package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Alert_ZOY953_CheckAlertForReschedule extends LoadPropMac{
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	@BeforeClass
	  public void LaunchBrowser() throws Exception {
		LoadBrowserProperties();
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		  }
	
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Somalia","S","9655559923","somalia@gmail.com","Diabetic" }
	
			};
		}

	@Test(dataProvider="DP1")
	public void CheckAlertforDiagnosticAppointmentReschedule(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		
		DiagnosticPageZoylo.DiagnosticAppointmentbookingForTomorrow(firstname, lastname, mobile, email, problem);
		Thread.sleep(1000);
		DiagnosticPageZoylo.clickingonappointmentmodification();
		String Id=DiagnosticPageZoylo.GetDiagnosticAppointmentId();
		System.out.println(Id);
		Thread.sleep(1000);
		DiagnosticPageZoylo.DiagnosticAppointmentReschedule();
		DiagnosticPageZoylo.clickOnAlertMenu();
		String alert=driver.findElement(By.xpath("(//*[@id='message'])[1]")).getText();
		System.out.println(alert);
		Assert.assertTrue(alert.contains("You have RESCHEDULED the lab visit appointment for "+firstname));
		Thread.sleep(1000);
		Assert.assertTrue(alert.contains(Id));
		
		
		
		
	}
	
	@AfterMethod()
	public void bulkcancelandlogout() throws Exception{
		DiagnosticPageZoylo.DiagnosticAppointmentsBulkCancellation("07:00", "23:00");
		DiagnosticPageZoylo.diagnosticlogout();
		}
	
	
	@AfterClass
	public void closebrowser(){
		driver.quit();
	}
	
}

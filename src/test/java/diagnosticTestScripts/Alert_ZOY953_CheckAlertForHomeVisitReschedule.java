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

public class Alert_ZOY953_CheckAlertForHomeVisitReschedule extends LoadPropMac{
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	@BeforeClass
	  public void LaunchBrowser() throws Exception {
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
					{ "yes","Roja","S","9922222456","roja@gmail.com","Kakatiya Residency","Diabetic" }
	
			};
		}

	@Test(dataProvider="DP1")
	public void CheckAlertforDiagnosticHomeVisitReschedule(String RunMode,String firstname,String lastname,String mobile,String email,String address,String problem) throws Exception{
		
		DiagnosticPageZoylo.DiagnosticAppointmentForHomeVisit(firstname, lastname, mobile, email, address, problem);
		Thread.sleep(1000);
		DiagnosticPageZoylo.clickingonappointmentmodification();
		String Id=DiagnosticPageZoylo.GetDiagnosticAppointmentId();
		Thread.sleep(2000);
		DiagnosticPageZoylo.diagnosticrescheduleappointment();
		Browser.CheckNotificationMessage("Appointment rescheduled successfully");
		Thread.sleep(1000);
		DiagnosticPageZoylo.clickOnAlertMenu();
		String alert=driver.findElement(By.xpath("(//*[@id='message'])[1]")).getText();
		System.out.println(alert);
		Assert.assertTrue(alert.contains("You have RESCHEDULED the home visit appointment of "+firstname));
		Thread.sleep(1000);
		Assert.assertTrue(alert.contains(Id));
		
		
		
	}
	
	@AfterMethod
	public void bulkcancelandlogout() throws Exception{
		DiagnosticPageZoylo.ClickonAppointmentMenu();
		DiagnosticPageZoylo.ClickonToggleButtonForHomeVisit();
		DiagnosticPageZoylo.BulkCancellationForHomeVisit("07:00", "23:00");
		DiagnosticPageZoylo.diagnosticlogout();	
		}
	
	  @AfterClass
	  public void afterClass() {
	  
		  driver.quit();
	  }
}

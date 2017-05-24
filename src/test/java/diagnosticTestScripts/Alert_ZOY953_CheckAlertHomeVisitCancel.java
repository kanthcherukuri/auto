package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Alert_ZOY953_CheckAlertHomeVisitCancel extends LoadPropMac{
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	@BeforeClass
	  public void beforeClass() throws Exception {
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
					{ "yes","Roja","S","9922222456","roja@gmail.com","Kakatiya Residency","Diabetic" }
	
			};
		}

	@Test(dataProvider="DP1")
	public void CheckAlertforDiagnosticHomeVisitCancel(String RunMode,String firstname,String lastname,String mobile,String email,String address,String problem) throws Exception{
		
		DiagnosticPageZoylo.DiagnosticAppointmentForHomeVisit(firstname, lastname, mobile, email, address, problem);
		Thread.sleep(1000);
		DiagnosticPageZoylo.clickingonappointmentmodification();
		Thread.sleep(2000);
		String Id=DiagnosticPageZoylo.GetDiagnosticAppointmentId();
		Thread.sleep(2000);
		DiagnosticPageZoylo.CancelAppointmentOfHomeVisit();
		Thread.sleep(2000);
		DiagnosticPageZoylo.clickOnAlertMenu();
		String alert=driver.findElement(By.xpath("(//*[@id='message'])[1]")).getText();
		System.out.println(alert);
		AssertJUnit.assertTrue(alert.contains("You have cancelled Diagnostic Home visit Appointment:"));
		Thread.sleep(1000);
		AssertJUnit.assertTrue(alert.contains(Id));
	}
	
	@AfterMethod()
	public void bulkcancelandlogout() throws Exception{
		DiagnosticPageZoylo.ClickonAppointmentMenu();
		Thread.sleep(2000);
		DiagnosticPageZoylo.ClickonToggleButtonForHomeVisit();
		Thread.sleep(1000);
		DiagnosticPageZoylo.BulkCancellationForHomeVisit("07:00", "23:00");
		Thread.sleep(5000);
		DiagnosticPageZoylo.diagnosticlogout();
		}
	
	
	@AfterClass
	public void closebrowser(){
		driver.close();
	}
}

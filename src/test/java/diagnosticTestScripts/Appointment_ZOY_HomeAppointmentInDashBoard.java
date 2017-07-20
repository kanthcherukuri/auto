package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import objectRepository.Elements_Diagnostics;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY_HomeAppointmentInDashBoard extends LoadPropMac{
	
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
					{ "yes","Kiran","S","9922222456","kiran@gmail.com","Kakatiya Residency","Diabetic" }
	
			};
		}
	
	@Test(dataProvider="DP1")
	public void CheckHomeAppointmnetBookingInDashBoard(String RunMode,String firstname,String lastname,String mobile,String email,String address,String problem) throws Exception{
		
		DiagnosticPageZoylo.DiagnosticHomeVisitAppointmentForToday(firstname, lastname, mobile, email, address, problem);
		Thread.sleep(2000);
		Browser.waitFortheID(Elements_Diagnostics.clickondashboardmenu);
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickondashboardmenu);
		WebDriverWait wait=new WebDriverWait(driver,1000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Elements_Diagnostics.todayhighliteddate)));
		Thread.sleep(1000);
		int home=driver.findElements(By.xpath(Elements_Diagnostics.homevisitdashboardsize)).size();
		System.out.println(home);
		String fullname=firstname+" "+lastname;
		for(int i=1;i<=home;i++){
		String value=driver.findElement(By.xpath("(//div[@class='sp-diagno-aptusername sp-diagno-dash-healthproblem']//span)["+i+"]")).getText();
		System.out.println("Value is :"+value);
		if(value.equalsIgnoreCase(fullname)){
			driver.findElement(By.xpath(Elements_Diagnostics.homevisitimageindashboard)).click();
			System.out.println("Home Appointment  Verification In DashBoard is Sucessfull");
			break;
			
		}	
			
		
		}		
	}
	
	@AfterMethod
	public void bulkcancelandlogout() throws Exception{
		DiagnosticPageZoylo.ClickonAppointmentMenu();
		DiagnosticPageZoylo.ClickonToggleButtonForHomeVisit();
		DiagnosticPageZoylo.BulkCancellationForHomeVisit("07:00", "23:00");
		DiagnosticPageZoylo.diagnosticlogout();
		}
	
	@AfterClass
	public void closebrowser(){
		driver.quit();
	}

}

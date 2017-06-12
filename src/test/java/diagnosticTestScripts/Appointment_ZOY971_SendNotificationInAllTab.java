package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import objectRepository.Elements_Diagnostics;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY971_SendNotificationInAllTab extends LoadPropMac{
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	@BeforeClass
	public void LaunchBrowser() throws Exception {
	LoadBrowserProperties();
	driver.manage().window().maximize();
	driver.get(doctors_Url);		 
	DiagnosticPageZoylo=new DiagnosticPage(driver);	
	Browser=new TestUtils(driver);
	DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
	  }
	
	
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Suresh","Raavi","9992255522","suresh@gmail.com","Diabetic" }

			};
		}
	
	@Test(dataProvider="DP1")
	public void SendNotificationInAllTab(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		DiagnosticPageZoylo.DiagnosticAppointmentbookingForTomorrow(firstname, lastname, mobile, email, problem);
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Diagnostics.clickonpatientmenu)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(Elements_Diagnostics.clickonserachbarid)).click();
		driver.findElement(By.id(Elements_Diagnostics.clickonalltab)).click();
		driver.findElement(By.id(Elements_Diagnostics.serachtextbox)).sendKeys(email);
		driver.findElement(By.id(Elements_Diagnostics.serachtextbox)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	int alltabsize=driver.findElements(By.xpath(Elements_Diagnostics.alltabsize)).size();
	for(int i=1;i<=alltabsize;i++){
		String schedule=driver.findElement(By.xpath("//*[@id='sp-diagno-tab-2']/div["+i+"]/div/div[2]/div/h1/span[2]/p")).getText();
		if(schedule.equalsIgnoreCase("Scheduled")){
			WebElement sc = driver.findElement(By.xpath("//*[@id='sp-diagno-tab-2']/div["+i+"]/div/div[2]/div/h1/span[2]/p"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sc);
			driver.findElement(By.xpath("//*[@id='sp-diagno-tab-2']/div["+i+"]/div/div[3]/div/div/div[3]/div[2]/button")).click();
			Browser.CheckNotificationMessage("Email/SMS Notification sent to the Patient");
			}
			}
			}
	
	@AfterMethod	
	public void DiagnosticBulkCancellation() throws Exception{
		DiagnosticPageZoylo.DiagnosticAppointmentsBulkCancellation("07:00", "23:00");
		Thread.sleep(3000);
		DiagnosticPageZoylo.diagnosticlogout();
	}
	
	@AfterClass
	public void browserclose(){
		driver.quit();
	}
	
}

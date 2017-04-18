package diagnosticTestScripts;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import objectRepository.Elements_Diagnostics;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointments_ZOY971_DiagnosticSendNotification extends LoadPropMac{
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils exceldata;
	
	@BeforeClass
	  public void beforeClass() throws Exception {
		LoadBrowserProperties();
		 driver.manage().window().maximize();
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }
		
	  
	
	@Test(priority=1)
	  public void DiagnosticLogin() throws Exception {
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
			DiagnosticPageZoylo=new DiagnosticPage(driver);	
			DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
			
				}
	@Test(priority=2)
	public void CheckSendNotification() throws Exception{
		driver.findElement(By.id("patients")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='search-bar']")).click();
		Thread.sleep(2000);
		int todaytab= driver.findElements(By.xpath("//*[@id='sp-diagno-tab-1']/div")).size();
		System.out.println(todaytab);
		for(int i=1;i<=todaytab;i++){
		String schedule=driver.findElement(By.xpath("//*[@id='sp-diagno-tab-1']/div["+i+"]/div/div[2]/div/h1/span[2]/p")).getText();
		if(schedule.equalsIgnoreCase("Scheduled")||schedule.equalsIgnoreCase("Rescheduled")){
			System.out.println("Scheduled/Rescheduled Found");
			Reporter.log("Scheduled/Rescheduled Found");
			
			WebElement sc = driver.findElement(By.xpath("//*[@id='sp-diagno-tab-1']/div["+i+"]/div/div[2]/div/h1/span[2]/p"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sc);
			driver.findElement(By.xpath(".//*[@id='sp-diagno-tab-1']/div["+i+"]/div/div[3]/div/div/div[3]/div[2]/button")).click();
			WebDriverWait wait = (new WebDriverWait(driver, 100));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Elements_Diagnostics.notification)));
			String notification=driver.findElement(By.cssSelector(Elements_Diagnostics.topnotification)).getText();
			System.out.println(notification);
			if(notification.equalsIgnoreCase("Email/SMS Notification sent to the Patient")){
				
				System.out.println("Notification has Sent Sucessfully");
				break;
			}else{
				System.out.println("Appointment Creation is Unsucess");
				Assert.fail("Appointment Creation is Unsucess");
			}
		}
			
			
		}
		
	}

}

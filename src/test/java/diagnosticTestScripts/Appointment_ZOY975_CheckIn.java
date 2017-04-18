package diagnosticTestScripts;

import org.testng.annotations.Test;
import objectRepository.Elements_Diagnostics;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class Appointment_ZOY975_CheckIn extends LoadPropMac {
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
	public void verifycheckinfunctionality() throws Exception{
		
		driver.findElement(By.id("patients")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='all']")).click();
		int size=driver.findElements(By.xpath(".//*[@id='sp-diagno-tab-2']/div")).size();
		for(int i=1;i<=size;i++){
			
		String schedule=driver.findElement(By.xpath("//*[@id='sp-diagno-tab-2']/div["+i+"]/div/div[2]/div/h1/span[2]/p")).getText();
		if(schedule.equalsIgnoreCase("Scheduled")||schedule.equalsIgnoreCase("Rescheduled")){
			
			System.out.println("Scheduled/Rescheduled Found");
			Reporter.log("Scheduled/Rescheduled Found");
			
			WebElement sc = driver.findElement(By.xpath("//*[@id='sp-diagno-tab-2']/div["+i+"]/div/div[2]/div/h1/span[2]/p"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sc);
			driver.findElement(By.xpath(".//*[@id='sp-diagno-tab-2']/div["+i+"]/div/div[2]/div/h1/span[1]")).click();
			Thread.sleep(5000);	
			if(driver.findElements(By.id("checkIn")).size()>0){
				driver.findElement(By.id("checkIn")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("startConsultation")).click();
				Thread.sleep(2000);
				WebElement element=driver.findElement(By.xpath("//*[@id='0']"));
				Select se=new Select(element);
				se.selectByValue("Completed");
				driver.findElement(By.id("tab-pkgs-btn")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("appointmentNotes")).sendKeys("Tests Are Completed");
				Thread.sleep(2000);
				driver.findElement(By.id("diag-note-btn")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(".//*[@id='generatReceiptBtn']")).click();
				Thread.sleep(10000);
				driver.findElement(By.id("checkoutBtn")).click();
				
				WebDriverWait wait=new WebDriverWait(driver,1000);
				//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Elements_Diagnostics.topnotification)));
				String notification=driver.findElement(By.cssSelector(Elements_Diagnostics.topnotification)).getText();
				System.out.println(notification);
				Thread.sleep(1000);
				if(notification.equalsIgnoreCase("Check Out Success")){
					System.out.println("Diagnostic Sucessfully Checked");
					System.out.println("Jira ZOY999 also sucessfully verified");
				}else{
					System.out.println("Checkout is not sucess");
				}	
				driver.findElement(By.xpath("//li[@class='tab-link'][contains(text(),'Reports')]")).click();
				Thread.sleep(5000);
				
				driver.findElement(By.id("uploadBtn")).sendKeys("/Users/lakshmikanth/Downloads/flower.jpeg");
				Thread.sleep(2000);
				driver.findElement(By.id("all_reports_upload")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("appt-reports-btn")).click();
				
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Elements_Diagnostics.notification)));
				String notification1=driver.findElement(By.cssSelector(Elements_Diagnostics.topnotification)).getText();
				System.out.println(notification1);
				Assert.assertEquals(notification1,"Reports Uploaded successfully");
				
				break;
				
			}else{
				driver.findElement(By.xpath("//*[@id='backbtn']")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(".//*[@id='all']")).click();
			}
			
			}
			
			}
			}

	
	  @AfterClass
	  public void afterClass() {
		driver.close();
	  }
	
	}

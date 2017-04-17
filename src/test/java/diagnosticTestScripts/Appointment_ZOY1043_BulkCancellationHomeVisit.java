package diagnosticTestScripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Diagnostics;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY1043_BulkCancellationHomeVisit extends LoadPropMac{
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
	public void DiagnosticLogin() throws Exception{
		
		DiagnosticPageZoylo=new DiagnosticPage(driver);	
		DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		
		}
	
	@Test(priority=2)
	public void bulkcancellation() throws Exception{
		driver.findElement(By.id("appointments")).click();
		Thread.sleep(3000);
		Actions action=new Actions(driver);
		WebElement toggle=driver.findElement(By.xpath(Elements_Diagnostics.clickontoggle));
		action.moveToElement(toggle);
		action.click().build().perform();
		
		driver.findElement(By.xpath("//i[@class='pa-cancl-apt fa fa-calendar-times-o cancel-apmpt-btn menu_links']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='bulk_cancel_fromDate']")).click();
		Thread.sleep(2000);
		
		List<WebElement> allDates=driver.findElements(By.xpath("//td[@class='day']"));
	
		for(WebElement ele:allDates)
		{
			boolean date2=ele.isEnabled();
			ele.click();
			break;
		}
		
		Thread.sleep(10000);
		driver.findElement(By.xpath(".//*[@id='bulk_cancel_toDate']")).click();
		Thread.sleep(2000);
		List<WebElement> CancelToDate=driver.findElements(By.xpath("//td[@class='day']"));
		for(WebElement ele:CancelToDate)
		{	
		String date=ele.getText();
			
			if(date.equalsIgnoreCase("30"))
			{
				ele.click();
				break;
			}
			
		}//cancletodate
		
		driver.findElement(By.xpath(".//*[@id='bulk_cancel_fromTime']")).sendKeys("07:00");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='bulk_cancel_toTime']")).sendKeys("23:00");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='bulkCancel_submit']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[6]/div")));
		String notification=driver.findElement(By.cssSelector(Elements_Diagnostics.topnotification)).getText();
		System.out.println(notification);
		Thread.sleep(5000);
		if(notification.equalsIgnoreCase("All Appointments Cancelled between the applied dates")){
			System.out.println("All Appointments Cancelled between the applied dates");
			Reporter.log("All Appointments Cancelled between the applied dates");
		}else{
			System.out.println("All Appointments Not Cancelled ");
		}
		
		}
		
	}



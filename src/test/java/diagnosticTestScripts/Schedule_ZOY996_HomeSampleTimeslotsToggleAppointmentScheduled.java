package diagnosticTestScripts;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY996_HomeSampleTimeslotsToggleAppointmentScheduled extends LoadPropMac{
	
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
	
	@Test
	public void HomeSampleTimeslotsToggleAppointmentScheduled() throws Exception{
		DiagnosticPageZoylo.DiagnosticHomeVisitAppointmentForToday("Ratna", "R", "9900662288", "ratna@gmail.com", "Kakatiya Residency", "liver");
		Thread.sleep(2000);
		driver.findElement(By.id("schedule")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='cd-11']/div")).click();
		Thread.sleep(2000);
		Calendar calendar = Calendar.getInstance();
		 int day = calendar.get(Calendar.DAY_OF_WEEK); 
		 
		 System.out.println(day);
		 switch (day) {
		 case Calendar.SUNDAY:
			 driver.findElement(By.xpath("//*[@id='tab-homesample']/div[7]/div[9]/div[1]/div/label/span[2]")).click();
		    	Thread.sleep(2000);
		     	break;
		     	
	     case Calendar.MONDAY:
	    	 driver.findElement(By.xpath("//*[@id='tab-homesample']/div[7]/div[3]/div[1]/div/label/span[2]")).click();
		    	Thread.sleep(2000);
		     	break;
	     
	     case Calendar.TUESDAY:
	    	 driver.findElement(By.xpath("//*[@id='tab-homesample']/div[7]/div[4]/div[1]/div/label/span[2]")).click();
		    	Thread.sleep(2000);
		     	break;
	  
	    case Calendar.WEDNESDAY:
	    	driver.findElement(By.xpath("//*[@id='tab-homesample']/div[7]/div[5]/div[1]/div/label/span[2]")).click();
	    	Thread.sleep(2000);
	     	break;
	    
	    case Calendar.THURSDAY:
	    	driver.findElement(By.xpath("//*[@id='tab-homesample']/div[7]/div[6]/div[1]/div/label/span[2]")).click();
	    	Thread.sleep(2000);
	     	break;
	    
	    case Calendar.FRIDAY:
	    	driver.findElement(By.xpath("//*[@id='tab-homesample']/div[7]/div[7]/div[1]/div/label/span[2]")).click();
	    	Thread.sleep(2000);
	     	break;
	    
	    case Calendar.SATURDAY:
	    	driver.findElement(By.xpath("//*[@id='tab-homesample']/div[7]/div[8]/div[1]/div/label/span[2]")).click();
	    	Thread.sleep(2000);
	     	break;
		 }
		 
		 driver.findElement(By.id("diagnosticHomeVisitTimeSlots")).click();
		 WebDriverWait wait = (new WebDriverWait(driver, 2000));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.zy-status-wrapper")));
			String Notification= driver.findElement(By.cssSelector("div.zy-status-wrapper")).getText();
			Assert.assertTrue(Notification.contains("Home Visit: You can't inactive"));
	}
	
	@AfterClass
	public void closebrowser(){
		driver.close();
	}

}

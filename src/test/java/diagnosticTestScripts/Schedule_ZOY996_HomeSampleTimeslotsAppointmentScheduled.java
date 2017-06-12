package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY996_HomeSampleTimeslotsAppointmentScheduled extends LoadPropMac{
	
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
		 DiagnosticPageZoylo.SignIn(Diagnostic_usernamethree, Diagnostic_passwordthree);
		  }
	
	@Test
	public void HomeSampleTimeslotsAppointmentScheduled() throws Exception{
		
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
	    	 driver.findElement(By.xpath("//*[@id='Sunday'][@class='hvEndTime7 SundayHE']")).clear();
	    	 driver.findElement(By.xpath("//*[@id='Sunday'][@class='hvEndTime7 SundayHE']")).sendKeys("22:00");
	    	 Thread.sleep(2000);
	     
	     case Calendar.MONDAY:
	    	 driver.findElement(By.xpath("//*[@id='Monday'][@class='hvEndTime1 MondayHE']")).clear();
	    	 driver.findElement(By.xpath("//*[@id='Monday'][@class='hvEndTime1 MondayHE']")).sendKeys("22:00");
	    	 Thread.sleep(2000);
	    	 	break;
	     
	     case Calendar.TUESDAY:
	    	 driver.findElement(By.xpath("//*[@id='Tuesday'][@class='hvEndTime2 TuesdayHE']")).clear();
	    	 driver.findElement(By.xpath("//*[@id='Tuesday'][@class='hvEndTime2 TuesdayHE']")).sendKeys("22:00");
	    	 Thread.sleep(2000);
	    	 	break;
	  
	    case Calendar.WEDNESDAY:
	    	 driver.findElement(By.xpath("//*[@id='Wednesday'][@class='hvEndTime3 WednesdayHE']")).clear();
	    	 driver.findElement(By.xpath("//*[@id='Wednesday'][@class='hvEndTime3 WednesdayHE']")).sendKeys("22:00");
	    	 Thread.sleep(2000);
	    	 	break;
	    
	    case Calendar.THURSDAY:
	    	 driver.findElement(By.xpath("//*[@id='Thursday'][@class='hvEndTime4 ThursdayHE']")).clear();
	    	 driver.findElement(By.xpath("//*[@id='Thursday'][@class='hvEndTime4 ThursdayHE']")).sendKeys("22:00");
	    	 Thread.sleep(2000);
	    	 	break;
	    
	    case Calendar.FRIDAY:
	    	driver.findElement(By.xpath("//*[@id='Friday'][@class='hvEndTime5 FridayHE']")).clear();
	    	driver.findElement(By.xpath("//*[@id='Friday'][@class='hvEndTime5 FridayHE']")).sendKeys("22:00");
	    	Thread.sleep(2000);
	    	break;
	    
	    case Calendar.SATURDAY:
	    	driver.findElement(By.xpath("//*[@id='Saturday'][@class='hvEndTime6 SaturdayHE']")).clear();
	    	driver.findElement(By.xpath("//*[@id='Saturday'][@class='hvEndTime6 SaturdayHE']")).sendKeys("22:00");
	    	Thread.sleep(2000);
	     	break;
		 }
		 
		 driver.findElement(By.id("diagnosticHomeVisitTimeSlots")).click();
		 WebDriverWait wait = (new WebDriverWait(driver, 2000));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.zy-status-wrapper")));
			String Notification= driver.findElement(By.cssSelector("div.zy-status-wrapper")).getText();
			AssertJUnit.assertTrue(Notification.contains("Home Visit: You can't change end time for"));
	}
	
	@AfterClass
	public void closebrowser(){
		driver.quit();
	}

}

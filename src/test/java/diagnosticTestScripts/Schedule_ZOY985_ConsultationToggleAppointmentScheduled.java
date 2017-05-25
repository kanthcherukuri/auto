package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY985_ConsultationToggleAppointmentScheduled extends LoadPropMac {
	
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
		 DiagnosticPageZoylo.SignIn(Diagnostic_username, Diagnostic_password);
		  }
	
	@Test
	public void MakeToggleInactiveWhenAppointmentScheduled() throws Exception{
		
		DiagnosticPageZoylo.DiagnosticAppointmentForToday("Mohanjdaro", "M", "9900886622", "mohandaro@gmail.com", "Liver problem");
		Thread.sleep(2000);
		driver.findElement(By.id("schedule")).click();
		Thread.sleep(3000);
		Calendar calendar = Calendar.getInstance();
		 int day = calendar.get(Calendar.DAY_OF_WEEK); 
		 switch (day) {
		     case Calendar.SUNDAY:
		    	 driver.findElement(By.xpath(".//*[@id='tab-consult']/div[6]/div[9]/div[1]/div/label/span[2]")).click();
		    	 Thread.sleep(2000);
		     
		     case Calendar.MONDAY:
		    	 driver.findElement(By.xpath(".//*[@id='tab-consult']/div[6]/div[3]/div[1]/div/label/span[2]")).click();
		    	 Thread.sleep(2000);
		    	 	break;
		     
		     case Calendar.TUESDAY:
		    	 driver.findElement(By.xpath(".//*[@id='tab-consult']/div[6]/div[4]/div[1]/div/label/span[2]")).click();
		    	 Thread.sleep(2000);
		    	 	break;
		  
		    case Calendar.WEDNESDAY:
		    	 driver.findElement(By.xpath(".//*[@id='tab-consult']/div[6]/div[5]/div[1]/div/label/span[2]")).click();
		    	 Thread.sleep(2000);
		    	 	break;
		    
		    case Calendar.THURSDAY:
		    	 driver.findElement(By.xpath(".//*[@id='tab-consult']/div[6]/div[6]/div[1]/div/label/span[2]")).click();
		    	 Thread.sleep(2000);
		    	 	break;
		    
		    case Calendar.FRIDAY:
		    	driver.findElement(By.xpath(".//*[@id='tab-consult']/div[6]/div[7]/div[1]/div/label/span[2]")).click();
		    	Thread.sleep(2000);
		    	break;
		    
		    case Calendar.SATURDAY:
		    	driver.findElement(By.xpath(".//*[@id='tab-consult']/div[6]/div[8]/div[1]/div/label/span[2]")).click();
		    	Thread.sleep(2000);
		     	break;
		 }
		 driver.findElement(By.id("diagnosticClinicTimeSlots")).click();
		 WebDriverWait wait = (new WebDriverWait(driver, 2000));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.zy-status-wrapper")));
			String Notification= driver.findElement(By.cssSelector("div.zy-status-wrapper")).getText();
			AssertJUnit.assertTrue(Notification.contains("Lab Visit: You can't inactive"));
	    }
	
	@AfterClass
	public void closebrowser(){
		driver.close();
	}

	

}

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
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY977_ConsultationChangeSlotDurationAppointmentScheduled  extends LoadPropMac{
	
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
	public void ConsultatonCenterChangeSlotDurationWhenAppointmentScheduled() throws Exception{
		
		DiagnosticPageZoylo.DiagnosticAppointmentForToday("Mohanjdaro", "M", "9900886622", "mohandaro@gmail.com", "Liver problem");
		Thread.sleep(2000);
		driver.findElement(By.id("schedule")).click();
		Thread.sleep(3000);
		 driver.findElement(By.id("clinicSlotDuration")).clear();
		 driver.findElement(By.id("clinicSlotDuration")).sendKeys("22");
		 driver.findElement(By.id("clinicSlotDuration")).sendKeys(Keys.ENTER);
		 Thread.sleep(3000);
		 driver.findElement(By.id("diagnosticClinicTimeSlots")).click();
		 WebDriverWait wait = (new WebDriverWait(driver, 2000));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.zy-status-wrapper")));
			String Notification= driver.findElement(By.cssSelector("div.zy-status-wrapper")).getText();
			AssertJUnit.assertTrue(Notification.contains("You can't update clinic slot duration"));
	}
	
	@AfterClass
	public void closebrowser(){
		driver.close();
	}

}

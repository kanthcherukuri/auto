package doctorsTestScripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.LoadProp;

public class Schedule_ZOY899_DoctorHospital_ActivateDeactivateTimeSlot {
	
	WebDriver driver;
	public  WebDriverWait wait;
	
	
  @Test
  public void testDoctorHospital_ActivateDeactivateTimeSlot() {
	  
	  driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
	  wait=new WebDriverWait(driver, 8000);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]")));
	  
	  
	  
  }
  
  
  
  
  
  @BeforeTest(groups = { "Regression","High" })
  public void beforeTest() throws Exception {
	  
	  driver=LoadProp.LoadBrowserProperties();
	  driver.get(LoadProp.doctors_Url);
	 
	  driver.manage().window().maximize();
	  Thread.sleep(4000);
	  driver.findElement(By.id("emailAddress")).sendKeys(LoadProp.DoctorsLogin_usernametwo);
	  driver.findElement(By.id("password")).sendKeys(LoadProp.DoctorsLogin_passwordtwo);
	  driver.findElement(By.xpath(".//*[@id='zoyloCustLogin-form']//button[@class='signup-btn']")).click();
	 
	  
  }

  @AfterTest(groups = { "Regression","High" })
  public void afterTest() {
	  
	 // driver.close();
  }
}

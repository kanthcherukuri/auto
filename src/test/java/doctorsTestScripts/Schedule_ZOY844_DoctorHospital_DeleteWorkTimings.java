package doctorsTestScripts;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import testBase.LoadProp;

public class Schedule_ZOY844_DoctorHospital_DeleteWorkTimings {

	
	WebDriver driver;
	public  WebDriverWait wait; 
	String actual_text;
	
  @Test(enabled=true,groups = { "Regression","High" })
  public void testDoctorHospitalDeleteWorkTimings() throws InterruptedException {
	  
	  driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
	  wait=new WebDriverWait(driver, 8000);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]")));
	  driver.findElement(By.xpath(".//*[@id='schedule_scheduleIcon']")).click();
	  driver.findElement(By.xpath(".//*[@id='cd-12']/div")).click();
	  
	  List<WebElement> m=driver.findElements(By.xpath(".//*[@class='fa fa-minus-circle hospital_rem_slot']"));
	  
	  m.get(0).click();
	  
	  driver.findElement(By.cssSelector(".sp-doc-hosp-schd-save")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.zy-status-wrapper")));
	  actual_text=driver.findElement(By.cssSelector("div.zy-status-wrapper")).getText();
	  System.out.println(actual_text);
	 
	  driver.findElement(By.xpath(".//*[@id='appointments']/span[2]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//i[@class='fa fa-ellipsis-v footer-relipse']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='dashboard_dashboardIcon']")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]"))); 
	  if(actual_text.contains("Successfully"))
	  {
           System.out.println("TEST CASE PASSED, DELETING TIME SLOT SUCCESSFUL");
		  
	  }  
	  if(actual_text.contains("Conflict"))
	  {
           System.out.println("TEST CASE FAILED, DELETING TIME SLOT UNSUCCESSFUL");
		  
		  AssertJUnit.fail(actual_text);
		  
	  }  
	  
  }

@BeforeTest(groups = { "Regression","High" })
public void beforeTest() throws Exception {
	  
	  driver=LoadProp.LoadBrowserProperties();
	  driver.get(LoadProp.base_url+"/login");
	  driver.manage().window().maximize();
	  Thread.sleep(8000);
	  driver.findElement(By.id("emailAddress")).sendKeys(LoadProp.DoctorsLogin_usernameone);
	  driver.findElement(By.id("password")).sendKeys(LoadProp.DoctorsLogin_passwordone);
	  driver.findElement(By.xpath(".//*[@id='zoyloCustLogin-form']//button[@class='signup-btn']")).click();
	  Thread.sleep(4000);
}

//===============================================================================================================================================================//

@AfterTest(groups = { "Regression","High" })
public void afterTest() {
	  
	//driver.close();
}


  
}
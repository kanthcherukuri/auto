package doctorsTestScripts;

/*author - manraj bharaj


Description: Schedule Doctor under Home Visit tab , actiavte and deactivate the 
home visit option by clicking on the car icon
Refer manual test case ZOY792 for any information.

Schedule_ZOY792_Home_Visit_enable_disable
 */

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.LoadProp;

public class Schedule_ZOY792_Home_Visit_enable_disable {
	
	WebDriver driver;
	public  WebDriverWait wait;
	
	
  @Test
  public void testEnableDisableHomeVisit() throws InterruptedException {
	  
	  driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
	  wait=new WebDriverWait(driver, 8000);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]")));
	  driver.navigate().refresh();
	  driver.findElement(By.xpath(".//*[@id='schedule_scheduleIcon']")).click();
	  driver.findElement(By.xpath(".//*[@id='cd-13']/div")).click();
	  String a=driver.findElement(By.xpath(".//*[@class='sp-doc-home-visit']")).getAttribute("id");
	  if(a.contains("houseCallInactive"))
	  {
		System.out.println("HOUSE CALL BUTTON INACTIVE "); 
		System.out.println("ACTIVATING"); 
		driver.findElement(By.xpath(".//*[@id='houseCallInactive']/i")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.zy-status-wrapper")));
		String b=driver.findElement(By.cssSelector("div.zy-status-wrapper")).getText();
		
		if(b.contains("Activeated Successfully"))
		  {
			
		  driver.findElement(By.xpath(".//*[@id='houseCallServiceFee']")).clear();
		  driver.findElement(By.xpath(".//*[@id='houseCallServiceFee']")).sendKeys("10");
			
		  }
		  else
		  {
			  Assert.fail();
		  }
		
		Thread.sleep(8000);
		driver.findElement(By.xpath("//div[@id='tab-home']/div/div[5]/div/div/span")).click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.zy-status-wrapper")));
		String  actual_text = driver.findElement(By.cssSelector("div.zy-status-wrapper")).getText();
		System.out.println(actual_text);
		if(actual_text.contains("Schedule Updated Successfully"))
		  {
			System.out.println("TEST CASE PASSED, THE PROCESS OF ACTIVATION -- THEN DEACTIVATION  SUCCESSFUL");
		  }
		  else
		  {
			  Assert.fail("TEST CASE FAILED");
		  }
		Thread.sleep(8000); 
		System.out.println("HOUSE CALL BUTTON ACTIVE"); 
		System.out.println("DEACTIVATING"); 
		driver.findElement(By.xpath(".//*[@id='houseCallActive']/i")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.zy-status-wrapper")));
		String c=driver.findElement(By.cssSelector("div.zy-status-wrapper")).getText();
		
		if(c.contains("Deactiveated Successfully"))
		  {
			System.out.println("TEST CASE PASSED-- AND THE PROCESS OF ACTIVATION TO DEACTIVATION SUCCESSFUL");
		  }
		  else
		  {
			  Assert.fail();
		  }
		
	  }
	  if(a.contains("houseCallActive"))
	  {
		    System.out.println("HOUSE CALL ACTIVE");   
		    System.out.println("DEACTIVATING");   
		    driver.findElement(By.xpath(".//*[@id='houseCallActive']/i")).click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.zy-status-wrapper")));
			String d=driver.findElement(By.cssSelector("div.zy-status-wrapper")).getText();
			if(d.contains("Deactiveated Successfully"))
			  {
				System.out.println("TEST CASE PASSED");
			  }
			  else
			  {
				  Assert.fail("TEST CASE FAILED");
			  }
	
	 
  }
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
	  
	 driver.close();
  }
}

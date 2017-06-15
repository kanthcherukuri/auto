package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY792_Home_Visit_enable_disable extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;
	public  WebDriverWait wait;
	
	
  @Test()
  public void testEnableDisableHomeVisit() throws InterruptedException, IOException 
  {
	  doctorsPage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
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
		
		if(b.contains("Activated Successfully"))
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
		
		if(c.contains("Deactivated Successfully"))
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
			if(d.contains("Deactivated Successfully"))
			  {
				System.out.println("TEST CASE PASSED");
			  }
			  else
			  {
				  Assert.fail("TEST CASE FAILED");
			  } 
  }
	  Thread.sleep(3000);
  }
 
  
  @BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Elements_Admin.Admin_PageProperties(); // loading the Elements
		Elements_Recipients.Recipients_PageProperties();
		Browser= new TestUtils(driver);
		doctorsPage=new DoctorsPage(driver);
		driver.get(loginPage_Url);
	}
	
	@AfterClass
	public void closeapp() throws Exception
	{
		driver.quit();
	}
}

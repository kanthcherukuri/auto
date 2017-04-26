package doctorsTestScripts;

/*
 * @author-Manraj Bharaj
 * 
 * Description- Test case for "Schedule_Consultation" edit consultation duration. 
 * Follow ZOY795 JIRA for understanding the manual test case
 */

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testBase.LoadProp;
import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Schedule_ZOY795_Doctor_EditConsultationDuration{
	
	WebDriver driver;
	public  WebDriverWait wait; 
	String actual_text1;
	String data="LOCALITY";
	SoftAssert sa=new SoftAssert();
	
	  //===============================================================================================================================================================//	
	
  @Test(groups = { "Regression","High" })
  public void testEditConsultationDuration() throws InterruptedException, ParseException, AWTException {
	  
	
	  driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
	  wait=new WebDriverWait(driver, 8000);
	
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]")));
	  driver.findElement(By.xpath(".//*[@id='schedule_scheduleIcon']")).click();
	  
	  
	  System.out.println("EDITING THE CONSULTATION DURATION OF DOCTOR PROVIDER");
	  
	  driver.findElement(By.xpath(".//*[@id='cd-10']/div")).click();
	  WebElement mainMenu = driver.findElement(By.xpath("//canvas"));
	  Actions action = new Actions(driver);action.moveToElement(mainMenu,40,0).click().perform();
	  
	  System.out.println("Scrolling to the bottom");
	  
	  Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	  robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	    
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='tab-consult']/div[9]/div/div/span")));
	    
	  driver.findElement(By.xpath(".//*[@id='tab-consult']/div[9]/div/div/span")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[6]/div")));
	  actual_text1=driver.findElement(By.xpath("html/body/div[6]/div")).getText();
	  System.out.println(actual_text1);
	  if(actual_text1.contains("Successfully"))
	  {
		  System.out.println("THE CONSULTATION DURATION EDITED SUCCESSFULLY AND TEST CASE PASSED");
	  }
	  
	  if(!actual_text1.contains("Successfully"))
	  {
		  System.out.println("THE CONSULTATION DURATION EDITED UNSUCCESSFULLY AND TEST CASE FAILED");
		  AssertJUnit.fail(actual_text1);
		  
	  }	 
	 
  }
  
  //===============================================================================================================================================================//
  
  @BeforeTest(groups = { "Regression","High" })
  public void beforeTest() throws Exception {
	  
	  driver=LoadProp.LoadBrowserProperties();
	  driver.get(LoadProp.doctors_Url);
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
	  
	  driver.close();
  }

}

//===============================================================================================================================================================//

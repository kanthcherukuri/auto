package doctorsTestScripts;

/*
 * @author-Manraj Bharaj

 * 
 * Description- Test case for different start and end time while adding time slot. 
 * Follow ZOY805 JIRA for understanding the manual test case
 */

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testBase.LoadProp;
import testBase.TestUtils;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Schedule_ZOY805_Doctor_StartEndTimeDifferent{
	
	WebDriver driver;
	public  WebDriverWait wait; 
	String actual_text;
	SoftAssert sa=new SoftAssert();
	
	
 //===============================================================================================================================================================//	
	
	@Test(enabled=true,dataProvider="DP1",groups = { "Regression","High" })
  public void testStartEndTimeDifferent(String runmode,String day,String start_time,String end_time) throws InterruptedException, ParseException, AWTException {
	  
	  driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
	  wait=new WebDriverWait(driver, 8000);
	
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]")));
	  driver.findElement(By.xpath(".//*[@id='schedule_scheduleIcon']")).click();
	  Thread.sleep(8000);
	  
	  
	  System.out.println("EDITING THE BREAK DURATION OF DOCTOR PROVIDER");
	  
	  
	  switch(day){
	  
	  case "Monday":
		  driver.findElement(By.xpath(".//label[@for='myonoffswitch-monday']//span[@class='sp-doc-conc-work-hours-switch-switch']")).click();
		  driver.findElement(By.xpath(".//*[@id='mon_start_time']")).clear();
		  driver.findElement(By.xpath(".//*[@id='mon_start_time']")).sendKeys(start_time);
		  driver.findElement(By.xpath(".//*[@id='mon_end_time']")).clear();
          driver.findElement(By.xpath(".//*[@id='mon_end_time']")).sendKeys(end_time);
		  break;
		  
		  
	  case "Tuesday":
		  driver.findElement(By.xpath(".//label[@for='myonoffswitch-tuesday']//span[@class='sp-doc-conc-work-hours-switch-switch']")).click();
		  driver.findElement(By.xpath(".//*[@id='tue_start_time']")).clear();
		  driver.findElement(By.xpath(".//*[@id='tue_start_time']")).sendKeys(start_time);
		  driver.findElement(By.xpath(".//*[@id='tue_end_time']")).clear();
		  driver.findElement(By.xpath(".//*[@id='tue_end_time']")).sendKeys(end_time);
		  break;
		  
	  case "Wednesday":
		  driver.findElement(By.xpath(".//label[@for='myonoffswitch-wednesday']//span[@class='sp-doc-conc-work-hours-switch-switch']")).click();
		  driver.findElement(By.xpath(".//*[@id='wed_start_time']")).clear();
		  driver.findElement(By.xpath(".//*[@id='wed_start_time']")).sendKeys(start_time);
		  driver.findElement(By.xpath(".//*[@id='wed_end_time']")).clear();
		  driver.findElement(By.xpath(".//*[@id='wed_end_time']")).sendKeys(end_time);
		  break;
		  
		  
	  case "Thursday":
		  driver.findElement(By.xpath(".//label[@for='myonoffswitch-thursday']//span[@class='sp-doc-conc-work-hours-switch-switch']")).click();
		  driver.findElement(By.xpath(".//*[@id='thu_start_time']")).clear();
		  driver.findElement(By.xpath(".//*[@id='thu_start_time']")).sendKeys(start_time);
		  driver.findElement(By.xpath(".//*[@id='thu_end_time']")).clear();
		  driver.findElement(By.xpath(".//*[@id='thu_end_time']")).sendKeys(end_time);
		  break;
		  
	  case "Friday":
		  driver.findElement(By.xpath(".//label[@for='myonoffswitch-friday']//span[@class='sp-doc-conc-work-hours-switch-switch']")).click();
		  driver.findElement(By.xpath(".//*[@id='fri_start_time']")).clear();
		  driver.findElement(By.xpath(".//*[@id='fri_start_time']")).sendKeys(start_time);
		  driver.findElement(By.xpath(".//*[@id='fri_end_time']")).clear();
		  driver.findElement(By.xpath(".//*[@id='fri_end_time']")).sendKeys(end_time);
		  break;
		  
	  case "Saturday":
		  driver.findElement(By.xpath(".//label[@for='myonoffswitch-saturday']//span[@class='sp-doc-conc-work-hours-switch-switch']")).click();
		  driver.findElement(By.xpath(".//*[@id='sat_start_time']")).clear();
		  driver.findElement(By.xpath(".//*[@id='sat_start_time']")).sendKeys(start_time);
		  driver.findElement(By.xpath(".//*[@id='sat_end_time']")).clear();
		  driver.findElement(By.xpath(".//*[@id='sat_end_time']")).sendKeys(end_time);
		  break;
		  
		  
	  case "Sunday":
		  driver.findElement(By.xpath(".//label[@for='myonoffswitch-sunday']//span[@class='sp-doc-conc-work-hours-switch-switch']")).click();
		  driver.findElement(By.xpath(".//*[@id='sun_start_time']")).clear();
		  driver.findElement(By.xpath(".//*[@id='sun_start_time']")).sendKeys(start_time);
		  driver.findElement(By.xpath(".//*[@id='sun_end_time']")).clear();
		  driver.findElement(By.xpath(".//*[@id='sun_end_time']")).sendKeys(end_time);
		  break;
		  
	  }
	 
	  
	  
	  
	  Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	  robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	  
	 
	  Thread.sleep(4000);
	  driver.findElement(By.xpath(".//*[@id='tab-consult']/div[9]/div/div/span")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[6]/div")));
	  actual_text=driver.findElement(By.cssSelector("div.zy-status-wrapper")).getText();
	  System.out.println(actual_text);
	 
	  
	  driver.findElement(By.xpath(".//*[@id='appointments']/span[2]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//i[@class='fa fa-ellipsis-v footer-relipse']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='dashboard_dashboardIcon']")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]"))); 
	  
	  if(!actual_text.contains("Schedule Updated Successfully"))
	  {
           System.out.println("TEST CASE FAILED, ADDING BREAK TIME UNSUCCESSFUL");
		  
		  AssertJUnit.fail(actual_text);
		  
	  }  

	  
}
	
//===============================================================================================================================================================//	
	
  @DataProvider()
  public Object[][] DP1() throws Exception{
	  
      Object[][] retObjArr=TestUtils.getTableArray("TestData\\Doctors_TestData.xls", "Doctor", "ZOY805");
      return(retObjArr);
  } 
  
 //===============================================================================================================================================================//
  
  @BeforeTest(groups = { "Regression","High" })
  public void beforeTest() throws Exception {
	  
	  driver=LoadProp.LoadBrowserProperties();
	  driver.get(LoadProp.base_url+"login");
	  driver.manage().window().maximize();
	  Thread.sleep(8000);
	  driver.findElement(By.id("emailAddress")).sendKeys(LoadProp.DoctorsLogin_username);
	  driver.findElement(By.id("password")).sendKeys(LoadProp.DoctorsLogin_password);
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

package doctorsTestScripts;

/*
 * @author-Manraj Bharaj

 * 
 * Description- Test case for "Updating time slots" under HOSPITAL tab for DOCTORS module. 
 * Follow ZOY842 JIRA for understanding the manual test case
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
import java.util.ArrayList;
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

public class Schedule_ZOY842_DoctorHospital_UpdateWorkTimings{
	
	WebDriver driver;
	public  WebDriverWait wait; 
	String actual_text;
	String start_new1;
	String end_new1;

	
 //===============================================================================================================================================================//	
	
	@Test(enabled=true,dataProvider="DP1",groups = { "Regression","High" })
      public void testUpdateHospitalWorkTimings(String runmode, String day, String start_new, String end_new) throws InterruptedException, ParseException, AWTException {
	  
		start_new1=start_new.replace("*", "");
		end_new1=end_new.replace("*", "");
		System.out.println(start_new1);
		System.out.println(end_new1);
		
		
	  driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
	  wait=new WebDriverWait(driver, 8000);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]")));
	  driver.findElement(By.xpath(".//*[@id='schedule_scheduleIcon']")).click();
	  driver.findElement(By.xpath(".//*[@id='cd-12']/div")).click();
	  driver.findElement(By.xpath(".//li[@data-hospi-tab='"+day+"']/div")).click();
	  
		  driver.findElement(By.xpath(".//i[@class='fa fa-plus-circle slot_hospital_add']")).click();
		  List<WebElement> timeslots_temp=driver.findElements(By.xpath(".//span[@class='sp-doc-clinic-workday-switch-switch']"));
		  timeslots_temp.get(timeslots_temp.size()-1).click();
		  List<WebElement> startslots=driver.findElements(By.xpath(".//input[@class='slot-start-hos']"));
		  List<WebElement> endslots=driver.findElements(By.xpath(".//input[@class='slot-end-hos']"));
		  startslots.get(startslots.size()-1).sendKeys(start_new1);
		  endslots.get(endslots.size()-1).sendKeys(end_new1);
		  driver.findElement(By.xpath(".//span[@class='sp-doc-hosp-schd-save']")).click();
		  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.zy-status-wrapper")));
		  actual_text=driver.findElement(By.cssSelector("div.zy-status-wrapper")).getText();
		  System.out.println(actual_text);
		 
		  driver.findElement(By.xpath(".//*[@id='appointments']/span[2]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//i[@class='fa fa-ellipsis-v footer-relipse']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(".//*[@id='dashboard_dashboardIcon']")).click();
		  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]"))); 
		  
		  if(actual_text.contains("Error in Form:*"+day+"*: Specified slot overlaps"))
		  {
	           System.out.println("TEST CASE FAILED, ADDING TIME SLOT UNSUCCESSFUL");
			  
			  AssertJUnit.fail(actual_text);
			  
		  }  
		  if(actual_text.contains("Error in form:*"+day+"*: Invalid Start or End format hh:mm"))
		  {
	           System.out.println("TEST CASE FAILED, ADDING TIME SLOT UNSUCCESSFUL");
			  
			  AssertJUnit.fail(actual_text);
			  
		  }  
		  if(actual_text.contains("Specified slot beyond 24 hr cycle"))
		  {
	           System.out.println("TEST CASE FAILED, ADDING TIME SLOT UNSUCCESSFUL");
			  
			  AssertJUnit.fail(actual_text);
			  
		  }  
		  if(actual_text.contains("Schedule Updated Successfully"))
			                       
		  {
	           System.out.println("TEST CASE PASSED, ADDING TIME SLOT SUCCESSFUL");
			  
		  }  
		  
		  if(!actual_text.contains("Schedule Updated Successfully"))
		  {
	           System.out.println("TEST CASE FAILED, ADDING TIME SLOT UNSUCCESSFUL");
			  
			  AssertJUnit.fail(actual_text);
			  
		  }  
		  
		 
}

	//===============================================================================================================================================================//	
	
	  @DataProvider()
	  public Object[][] DP1() throws Exception{
		  
	      Object[][] retObjArr=TestUtils.getTableArray("TestData\\Doctors_TestData.xls", "Doctor", "ZOY842");
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
	  
	// driver.close();
  }

}

//===============================================================================================================================================================//

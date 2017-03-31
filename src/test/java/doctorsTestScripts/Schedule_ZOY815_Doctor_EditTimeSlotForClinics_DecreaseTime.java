package doctorsTestScripts;

/*
 * @author-Manraj Bharaj
 * 
 * Description- This test case checks if the time slots can be increased for clinics with or without any 
 * booked appointment
 * Follow ZOY815 JIRA for understanding the manual test case
 */

import org.testng.annotations.Test;
import testBase.LoadProp;
import org.testng.annotations.BeforeTest;
import java.text.ParseException;
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

public class Schedule_ZOY815_Doctor_EditTimeSlotForClinics_DecreaseTime{
	
	WebDriver driver;
	public  WebDriverWait wait; 
	String new_end_time="21:00";
	String actual_text;
	Date d=new Date();
	int day = d.getDay()-1;

	  //===============================================================================================================================================================//	
	
  @Test
  public void f() throws InterruptedException, ParseException {
	  
	
	  driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
	  wait=new WebDriverWait(driver, 8000);
	
	  
	  List<WebElement> bookings=driver.findElements(By.xpath("//div[@class='timing']/span[1]"));
	  System.out.println(bookings.size());
	  if(bookings.size() > 0)
	  {
		System.out.println("There are appointments so there cannot be decrease in time as it will cause CONFLICTS");
	  } 
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]")));
	  driver.findElement(By.xpath(".//*[@id='schedule_scheduleIcon']")).click();
	  driver.findElement(By.xpath(".//*[@data-tab='tab-clinic']/div")).click();
	  driver.findElement(By.xpath("//li[@id='cd-"+day+"']/div")).click();
	  System.out.println("Entering the data with booked time slot");
	  List<WebElement> ct_endslot=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-end']"));
	  if(ct_endslot.get(ct_endslot.size()-1).getAttribute("value").equals("23:59"))
	  {
		  Assert.fail("Time cannot be increased as the maximum time is 23:59 already present in end slot");
	  }
	  
	  System.out.println("Increasing the time slot");
	  ct_endslot.get(ct_endslot.size()-1).clear();
	  ct_endslot.get(ct_endslot.size()-1).sendKeys(new_end_time);
	  driver.findElement(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-schd-save-btn clinic_slots_save']")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[6]/div")));
	  actual_text=driver.findElement(By.xpath("html/body/div[6]/div")).getText();
	  System.out.println(actual_text);
	  driver.findElement(By.xpath(".//*[@id='appointments']/span[2]")).click();
	  driver.findElement(By.xpath("//i[@class='fa fa-ellipsis-v footer-relipse']")).click();
	  driver.findElement(By.xpath(".//*[@id='dashboard_dashboardIcon']")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]"))); 
	 
	 	  
	  if((actual_text.contains("Conflict with existing appointments, please cancel the appointments to change working start time.")) && (bookings.size() > 0))
	  {
		  System.out.println("Test case failed;increasing time slot is unsuccessful as there are BOOKINGS/APPOINTMENTS");
		  Assert.fail(actual_text); 
	  }
	  
	  if((!actual_text.contains("Successfully")) && (bookings.size() == 0))
	  {
		  System.out.println("Test case failed;increasing time slot is unsuccessful ;UNKNOWN REASON PLEASE CHECK");
		  Assert.fail(actual_text); 
	  }
	  
	  if(actual_text.contains("Successfully"))
	  {
		  System.out.println("Test case passed and time slot increased");
	  }
  }
  
  //===============================================================================================================================================================//
  
  @BeforeTest
  public void beforeTest() throws Exception {
	  
	  driver=LoadProp.LoadBrowserProperties();
	  driver.get(LoadProp.base_url+"login");
	  driver.manage().window().maximize();
	  Thread.sleep(4000);
	  driver.findElement(By.id("emailAddress")).sendKeys(LoadProp.DoctorsLogin_username);
	  driver.findElement(By.id("password")).sendKeys(LoadProp.DoctorsLogin_password);
	  driver.findElement(By.xpath(".//*[@id='zoyloCustLogin-form']//button[@class='signup-btn']")).click();
	  Thread.sleep(4000);
  }
  
  //===============================================================================================================================================================//
  
  @AfterTest
  public void afterTest() {
	  
	  driver.close();
  }

}

//===============================================================================================================================================================//

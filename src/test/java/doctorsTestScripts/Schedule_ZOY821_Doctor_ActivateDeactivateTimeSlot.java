package doctorsTestScripts;

/*
 * @author-Manraj Bharaj 
 * 
 * Description- This test case checks if the time slots can be ActivateDeactivateTimeSlot for clinics with or without any 
 * booked appointment
 * Follow ZOY821 JIRA for understanding the manual test case
 */

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

public class Schedule_ZOY821_Doctor_ActivateDeactivateTimeSlot{
	
	WebDriver driver;
	public  WebDriverWait wait; 
	String actual_text1;
	String actual_text2;
	Date d=new Date();
	int day = d.getDay()-1;
	SoftAssert sa=new SoftAssert();
	String new_start_time="22:01";
	String new_end_time="22:30"; 

	  //===============================================================================================================================================================//	
	
  @Test
  public void f() throws InterruptedException, ParseException {
	  
	
	  driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
	  wait=new WebDriverWait(driver, 8000);
	
	  
	  List<WebElement> bookings=driver.findElements(By.xpath("//div[@class='timing']/span[1]"));
	  System.out.println(bookings.size());
	  if(bookings.size() > 0)
	  {
		System.out.println("There are appointments deactivation can cause CONFLICTS");
	  } 
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]")));
	  driver.findElement(By.xpath(".//*[@id='schedule_scheduleIcon']")).click();
	  driver.findElement(By.xpath(".//*[@data-tab='tab-clinic']/div")).click();
	  driver.findElement(By.xpath("//li[@id='cd-"+day+"']/div")).click();
	  
	  System.out.println("DEACTIVATING THE TIME SLOT");
	  
	  List<WebElement> working_slot=driver.findElements(By.xpath("//span[@class='sp-doc-clinic-workday-switch-switch']"));
	  working_slot.get(working_slot.size()-1).click();
	  Thread.sleep(4000);
	  actual_text1=driver.findElement(By.xpath("html/body/div[6]/div")).getText();
	 
	  
	  if((actual_text1.contains("Conflicts with existing appointments, please cancel the appointments to inactivate.")) && (bookings.size() > 0))
	  {
		  System.out.println("actual text is ------->"+actual_text1);
		  System.out.println("Test case failed;deactivating time slot is unsuccessful as there are BOOKINGS/APPOINTMENTS");
		  sa.fail(actual_text1); 
	  }
	  if(!(driver.findElement(By.xpath("html/body/div[6]/div")).isDisplayed()) && (bookings.size() > 0))
	  {
		  System.out.println("actual text is NULL /EMPTY------->"+actual_text1);
		  System.out.println("Test case failed;deactivating time slot is successful  REASON ----> NO booking under this slot, please enter a slot with booking");
		  sa.fail(actual_text1); 
	  }
	  
       System.out.println("ADDING A NEW TIME SLOT AND TRYING TO ACTIVATE IT");
       
 	  driver.findElement(By.xpath(".//*[@id='appointments']/span[2]")).click();
 	  driver.findElement(By.xpath("//i[@class='fa fa-ellipsis-v footer-relipse']")).click();
 	  driver.findElement(By.xpath(".//*[@id='dashboard_dashboardIcon']")).click();
 	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]")));
 	  driver.findElement(By.xpath(".//*[@id='schedule_scheduleIcon']")).click();
 	  driver.findElement(By.xpath(".//*[@data-tab='tab-clinic']/div")).click();
 	  driver.findElement(By.xpath("//li[@id='cd-"+day+"']/div")).click();
 	  
	  
	  driver.findElement(By.xpath(".//*[@id='clinic_add_slot']")).click();
	  List<WebElement> slots=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//span[@class='sp-doc-clinic-workday-switch-switch']"));
	  slots.get(slots.size()-1).click();
	  List<WebElement> ct_startslot=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-start']"));
	  List<WebElement> ct_endslot=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-end']"));;
	  ct_startslot.get(ct_startslot.size()-1).sendKeys(new_start_time);
	  ct_endslot.get(ct_endslot.size()-1).sendKeys(new_end_time);
	  driver.findElement(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-schd-save-btn clinic_slots_save']")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[6]/div")));
	  actual_text2=driver.findElement(By.xpath("html/body/div[6]/div")).getText();
	  System.out.println(actual_text2);
	  driver.findElement(By.xpath(".//*[@id='appointments']/span[2]")).click();
	  driver.findElement(By.xpath("//i[@class='fa fa-ellipsis-v footer-relipse']")).click();
	  driver.findElement(By.xpath(".//*[@id='dashboard_dashboardIcon']")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]")));
	  
	  if(!actual_text2.contains("Successfully"))
	  {
		  System.out.println("Test case failed;adding time slot is unsuccessful/ENTER CORRECT TIME SLOT PLEASE");
		  Assert.fail(actual_text2); 
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
	  
	  //driver.close();
  }

}

//===============================================================================================================================================================//

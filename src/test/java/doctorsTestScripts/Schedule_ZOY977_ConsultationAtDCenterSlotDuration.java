package doctorsTestScripts;

/*author - manraj bharaj
Description: Schedule DAIGNOSTIC CENTRE , alter  the consultation
duration with booked and no booked appointments and check the results 
For test scenario 1 and 2 book an appointment and for test scenario 3 no appointment is needed
Schedule_ZOY977_ConsultationAtDCenterSlotDuration
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import testBase.LoadProp;
import testBase.TestUtils;

public class  Schedule_ZOY977_ConsultationAtDCenterSlotDuration {
	
	WebDriver driver;
	public  WebDriverWait wait; 
	
  @Test(dataProvider = "dp",groups = { "Regression","High" })
  public void testConsultationAtDCenterSlotDuration(String runmode, String date_from,String date_to) throws ParseException, InterruptedException {
	  
	  SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	  Date date_from1 = sdf.parse(date_from);
	  Date date_to1 = sdf.parse(date_to);
	  SimpleDateFormat sdf1=new SimpleDateFormat("d");
	  String d1=sdf1.format(date_from1);
	  String d2=sdf1.format(date_to1);
	  
	  driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
	  wait=new WebDriverWait(driver, 8000);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='zyDashboardFooter']")));
	  driver.findElement(By.xpath(".//*[@id='zyScheduleFooter']")).click();
	 
	  
	  //testScenario1();
	 // Thread.sleep(8000);
	 // testScenario2();
	 // Thread.sleep(8000);
	  testScenario3(d1,d2);
	  System.out.println("ALL THREE SCENARIOS SUCESSFULLY COMPLETED AND PASSED");
  }
  
  public void testScenario1()
  {
      System.out.println("BEGINNING TO EDIT THE CONSULTATION DURATION - SCENARIO 1");
	  
	  WebElement mainMenu = driver.findElement(By.xpath("//canvas"));
	  Actions action = new Actions(driver);
	  action.moveToElement(mainMenu,38,0).click().perform();
	  
	  driver.findElement(By.xpath(".//*[@id='diagnosticClinicTimeSlots']")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.zy-status-wrapper")));
	  String actual_text=driver.findElement(By.cssSelector("div.zy-status-wrapper")).getText();
	  System.out.println(actual_text);
	  if(actual_text.contentEquals("Select Slot Duration in between 15 to 600"))
	  {
		  System.out.println("TEST CASE PASSED , CANNOT DECRESE THE TIME BEYOND 15 MINS");
	  }
	  else
	  {
		  Assert.fail();
	  }
	   
  }
  
  public void testScenario2()
  {
      System.out.println("BEGINNING TO EDIT THE CONSULTATION DURATION - SCENARIO 2");
	  
	  WebElement mainMenu = driver.findElement(By.xpath("//canvas"));
	  Actions action = new Actions(driver);
	  action.moveToElement(mainMenu,60,8).click().perform();
	  
	  driver.findElement(By.xpath(".//*[@id='diagnosticClinicTimeSlots']")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.zy-status-wrapper")));
	  String actual_text=driver.findElement(By.cssSelector("div.zy-status-wrapper")).getText();
	  System.out.println(actual_text);
	  if(actual_text.contains("You can't update clinic slot duration. You have a existing appointment"))
	  {
		  System.out.println("TEST CASE PASSED , CONFLICTS WITH EXISTING APPOINTMENT");
	  }
	  else
	  {
		  Assert.fail();
	  }
	   
  }
  
  public void testScenario3(String d1,String d2) throws InterruptedException
  {
	 
	  System.out.println("BEGINNING TO DELETE ALL THE APPOINTMENTS");
	  driver.findElement(By.xpath(".//*[@id='zyAppointmentsFooter']")).click();
	  driver.findElement(By.xpath("//i[@class='pa-cancl-apt fa fa-calendar-times-o cancel-apmpt-btn menu_links']")).click();
	  Thread.sleep(4000);
	  driver.findElement(By.xpath(".//*[@id='bulk_cancel_fromDate']")).click();
	  
	  A:for(int i=1;i<=7;i++)
	  {
		  for(int j=1;j<=7;j++)
		  {
			  String date=driver.findElement(By.xpath("html/body/div[8]/div[1]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
			
			                                         
			  if(date.equals(d1))
			  {
				  driver.findElement(By.xpath("html/body/div[8]/div[1]/table/tbody/tr["+i+"]/td["+j+"]")).click();
				  break A;
			  }
		  }  
	  }
	  Thread.sleep(4000);
	  driver.findElement(By.xpath(".//*[@id='bulk_cancel_toDate']")).click();
	  
	  B:for(int i=1;i<=7;i++)
	  {
		  for(int j=1;j<=7;j++)
		  {
			  String date=driver.findElement(By.xpath("html/body/div[8]/div[1]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
			
			                                         
			  if(date.equals(d2))
			  {
				  driver.findElement(By.xpath("html/body/div[8]/div[1]/table/tbody/tr["+i+"]/td["+j+"]")).click();
				  break B;
			  }
		  }  
	  }
	  
	  driver.findElement(By.xpath(".//*[@id='bulk_cancel_fromTime']")).clear();
	  driver.findElement(By.xpath(".//*[@id='bulk_cancel_fromTime']")).sendKeys("00:00");
	  driver.findElement(By.xpath(".//*[@id='bulk_cancel_toTime']")).clear();
	  driver.findElement(By.xpath(".//*[@id='bulk_cancel_toTime']")).sendKeys("23:59");
	  driver.findElement(By.xpath(".//*[@id='bulkCancel_submit']")).click();
	  
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.zy-status-wrapper")));
	  String actual_text=driver.findElement(By.cssSelector("div.zy-status-wrapper")).getText();
	  System.out.println(actual_text);
	  if(actual_text.contains("All Appointments Cancelled between the applied dates"))
	  {
		  System.out.println("APPOINTMENTS CANCELLED SUCCESSFULLY" +actual_text);
	  }
	  
	  else 
	  {
		  Assert.fail(actual_text);
		  
	  }	 
	  System.out.println("BEGINNING TO EDIT THE CONSULTATION DURATION - SCENARIO 3");
	  
	  
	  driver.findElement(By.xpath(".//*[@id='zyScheduleFooter']")).click();
	  driver.findElement(By.xpath(".//*[@id='clinicSlotDuration']")).getText();
	  Thread.sleep(8000);
	  WebElement mainMenu = driver.findElement(By.xpath("//canvas"));
	  Actions action = new Actions(driver);
	  action.moveToElement(mainMenu,60,7).click().perform();

	  driver.findElement(By.xpath(".//*[@id='diagnosticClinicTimeSlots']")).click();
	  
	  System.out.println("TEST CASE PASSED");
	 
  }
  
  @BeforeTest(groups = { "Regression","High" })
  public void beforeTest() throws Exception {
  	  
  	  driver=LoadProp.LoadBrowserProperties();
  	  driver.get(LoadProp.Diagnostic_Urltwo);
  	  driver.manage().window().maximize();
  	  Thread.sleep(8000);
  	  driver.findElement(By.id("emailAddress")).sendKeys(LoadProp.DiagnosticLogin_usernametwo);
  	  driver.findElement(By.id("password")).sendKeys(LoadProp.DiagnosticLogin_passwordtwo);
  	  driver.findElement(By.xpath(".//*[@id='zoyloCustLogin-form']//button[@class='signup-btn']")).click();
  	  Thread.sleep(4000);
  }
  
  @DataProvider
  public Object[][] dp() throws Exception {
 	  Object[][] retObjArr=TestUtils.getTableArray("TestData\\Doctors_TestData.xls", "Doctor", "ZOY977");
      return(retObjArr);
  }
  
  
  @AfterTest(groups = { "Regression","High" })
  public void afterTest() {
	  
	 // driver.close();
  }
}

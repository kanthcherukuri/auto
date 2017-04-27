package doctorsTestScripts;

/*author - manraj bharaj


Description: Schedule DAIGNOSTIC CENTRE , alter  the CONSULTATION TIME IN THE TIME SLOTS
 with booked and no booked appointments and check the results 
For test scenario -booked an appointment and for test scenario no booked appointment 
Schedule_ZOY985_ConsultationAtCenterTimeSlots
 */

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.fail;
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testBase.LoadProp;
import testBase.TestUtils;

public class Schedule_ZOY985_ConsultationAtCenterTimeSlots {
	
	WebDriver driver;
	public  WebDriverWait wait; 
	
  @Test(dataProvider = "dp",groups = { "Regression","High" },priority=1,enabled=true)
  public void testConsultationAtCenterTimeSlotsBookedApp(String runmode, String t,String day,String date_from,String date_to) {
	  
	  driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
	  wait=new WebDriverWait(driver, 8000);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='zyDashboardFooter']")));
	  driver.findElement(By.xpath(".//*[@id='zyScheduleFooter']")).click();
	  
      System.out.println("TRYING TO DECREASE THE EXISTING TIME IN THE TIME SLOTS ");
  	  
      String id=String.valueOf(getId(day));
      String temp=id+" "+day;
  	  List<WebElement> l1=driver.findElements(By.xpath(".//*[@id='weekDay']"));
  	  for(int i=0;i<=l1.size()-1;i++)
  	  {
  		  if(l1.get(i).getText().equals(day))
  		  {
  			 driver.findElement(By.xpath(".//input[@class='slotStart"+temp+"S']")).click();
  			 String text=driver.findElement(By.xpath(".//input[@class='slotStart"+temp+"S']")).getAttribute("value");
  			 System.out.println(text);
  			 String text1=driver.findElement(By.xpath(".//input[@class='slotEnd"+temp+"E']")).getAttribute("value");
 			 System.out.println(text1);
 			driver.findElement(By.xpath(".//input[@class='slotEnd"+temp+"E']")).clear();
 			driver.findElement(By.xpath(".//input[@class='slotEnd"+temp+"E']")).sendKeys(t);
 			break;
  		  }
  	  }
  	driver.findElement(By.xpath(".//*[@id='diagnosticClinicTimeSlots']")).click();
      wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.zy-status-wrapper")));
	  String actual_text=driver.findElement(By.cssSelector("div.zy-status-wrapper")).getText();
	  System.out.println(actual_text);
	  if(actual_text.contains("conflict"))
	  {
		  System.out.println("TIME SLOT CANNOT BE INCREASED AS THERE ARE BOOKED APPOINTMENTS" +actual_text);
		  System.out.println("TEST CASE PASSED");
	  }
	  
	  else 
	  {
		  Assert.fail(actual_text);
	  }	 
  }
  @Test(dataProvider = "dp",groups = { "Regression","High" },priority=2,enabled=true)
  public void testCancelAppointments(String runmode, String t,String day,String date_from,String date_to) throws ParseException, InterruptedException {
	  
	  SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	  Date date_from1 = sdf.parse(date_from);
	  Date date_to1 = sdf.parse(date_to);
	  SimpleDateFormat sdf1=new SimpleDateFormat("d");
	  String d1=sdf1.format(date_from1);
	  String d2=sdf1.format(date_to1);
	  driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
	  wait=new WebDriverWait(driver, 8000);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='zyDashboardFooter']")));
	  driver.findElement(By.xpath(".//*[@id='zyScheduleFooter']")).click();
	  
      System.out.println("CANCELLING ALL THE APPOINTMENTS");
      driver.findElement(By.xpath(".//*[@id='zyAppointmentsFooter']")).click();
	  driver.findElement(By.xpath("//i[@class='pa-cancl-apt fa fa-calendar-times-o cancel-apmpt-btn menu_links']")).click();
	  Thread.sleep(4000);
	  driver.findElement(By.xpath(".//*[@id='bulk_cancel_fromDate']")).click();
	  int c=0;
	  int d=0;
	  for(int i=1;i<=6;i++)
	  {
		  for(int j=1;j<=7;j++)
		  {
			  String date=driver.findElement(By.xpath("html/body/div[8]/div[1]/table/tbody/tr["+i+"]/td["+j+"]")).getText();               
			  if(date.equals(d1))
			  {
				  c=i;
				  d=j;
			  }
		  }  
	  }
	  driver.findElement(By.xpath("html/body/div[8]/div[1]/table/tbody/tr["+c+"]/td["+d+"]")).click();
	  Thread.sleep(4000);
	  driver.findElement(By.xpath(".//*[@id='bulk_cancel_toDate']")).click();

	   int a=0;
	   int b=0;
	  for(int i=1;i<=6;i++)
	  {
		  for(int j=1;j<=7;j++)
		  {
			  
			  String text=driver.findElement(By.xpath("html/body/div[8]/div[1]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
			  if(text.equals(d2))
			  {
				 a=i;
				  b=j;
			  }
		  }
	  }
	  driver.findElement(By.xpath("html/body/div[8]/div[1]/table/tbody/tr["+a+"]/td["+b+"]")).click();
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
		  driver.findElement(By.xpath(".//*[@id='zyScheduleFooter']")).click();
	  }
	  
	  else 
	  {
		  Assert.fail(actual_text);
	  }	
	  Thread.sleep(8000);
  }
  @Test(dataProvider = "dp",groups = { "Regression","High" },priority=3,enabled=true)
  public void testConsultationAtCenterTimeSlotsNoBookedApp(String runmode, String t,String day,String date_from,String date_to) throws InterruptedException {
	  
	  Thread.sleep(8000);
	  driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
	  wait=new WebDriverWait(driver, 8000);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='zyDashboardFooter']")));
	  driver.findElement(By.xpath(".//*[@id='zyScheduleFooter']")).click();
	  
      System.out.println("TRYING TO DECREASE THE EXISTING TIME IN THE TIME SLOTS ");
  	  
      String id=String.valueOf(getId(day));
      String temp=id+" "+day;
  	  List<WebElement> l1=driver.findElements(By.xpath(".//*[@id='weekDay']"));
  	  for(int i=0;i<=l1.size()-1;i++)
  	  {
  		  if(l1.get(i).getText().equals(day))
  		  {
  			 driver.findElement(By.xpath(".//input[@class='slotStart"+temp+"S']")).click();
  			 String text=driver.findElement(By.xpath(".//input[@class='slotStart"+temp+"S']")).getAttribute("value");
  			 System.out.println(text);
  			 String text1=driver.findElement(By.xpath(".//input[@class='slotEnd"+temp+"E']")).getAttribute("value");
 			 System.out.println(text1);
 			driver.findElement(By.xpath(".//input[@class='slotEnd"+temp+"E']")).clear();
 			driver.findElement(By.xpath(".//input[@class='slotEnd"+temp+"E']")).sendKeys(t);
 			break;
  		  }
  	  }
  	 driver.findElement(By.xpath(".//*[@id='diagnosticClinicTimeSlots']")).click();
  	String text1=driver.findElement(By.xpath(".//input[@class='slotEnd"+temp+"E']")).getAttribute("value");
  	System.out.println(text1);
  	if
  	(text1.contains(t))
  	{
  		System.out.println("TEST CASE PASSED AS THE NEW TIME IN GIVEN TIME SLOT IS SET");
  	}
  	else
  	{
  		Assert.fail("TEST CASE FAILED AS THE NEW TIME IN GIVEN TIME SLOT IS NOT SET");
  	}
  	Thread.sleep(8000);
  }
  
  public int getId(String day){
	  int id=0;
	  if(day.equals("Monday"))
	  {
		  id=1;
	  }
	  if(day.equals("Tuesday"))
	  {
		  id=2;
	  }
	  if(day.equals("Wednesday"))
	  {
		  id=3;
	  }
	  if(day.equals("Thursday"))
	  {
		  id=4;
	  }
	  if(day.equals("Friday"))
	  {
		  id=5;
	  }
	  if(day.equals("Saturday"))
	  {
		  id=6;
	  }
	  if(day.equals("Sunday"))
	  {
		  id=7;
	  }
	return id;
	  
  }
  @DataProvider
  public Object[][] dp() throws Exception {
 	  Object[][] retObjArr=TestUtils.getTableArray("TestData\\Doctors_TestData.xls", "Doctor", "ZOY985");
      return(retObjArr);
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

  @AfterTest(groups = { "Regression","High" })
  public void afterTest() {
	  
	 driver.close();
  }
}

package doctorsTestScripts;

/*author - manraj bharaj


Description: Schedule DAIGNOSTIC CENTRE , alter  the Number Of Appointments Per Slot
 with booked and no booked appointments and check the results 
For test scenario -booked an appointment and for test scenario no booked appointment 
Schedule_ZOY983_ConsultationAtDCenterNumberOfAppointmentsPerSlot
 */

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
import testBase.LoadProp;
import testBase.TestUtils;

public class Schedule_ZOY983_ConsultationAtDCenterNumberOfAppointmentsPerSlot {
	
	WebDriver driver;
	public  WebDriverWait wait; 
	
  @Test(dataProvider = "dp",groups = { "Regression","High" })
  public void testConsultationAtDCenterNumberOfAppointmentsPerSlot(String runmode, String date_from,String date_to) throws InterruptedException, ParseException {
	  
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
	  
      System.out.println("BEGINNING TO EDIT THE CONSULTATION DURATION - SCENARIO 1");
	  
      String text1=changeNoOfAppointmentsPerSlot();
      if(text1.contains("You can't update clinic Appoointments per slot. You have a existing appointment"))
	  {
		  System.out.println("TEST CASE PASSED , CANNOT DECRESE THE TIME BEYOND 15 MINS");
	  }
	  else
	  {
		  AssertJUnit.fail();
	  } 
	 if(cancelAllAppointments(d1,d2))
	 {
		 WebElement mainMenu = driver.findElement(By.xpath(".//*[@class='sp-diag-conc-duration-timer sp-diag-conc-daytimer']//canvas"));
		  Actions action = new Actions(driver);
		  Thread.sleep(4000);
		  action.moveToElement(mainMenu,34,0).click().perform();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath(".//*[@id='diagnosticClinicTimeSlots']")).click();
		  Thread.sleep(8000);
		  WebElement mainMenu1 = driver.findElement(By.xpath(".//*[@class='sp-diag-conc-duration-timer sp-diag-conc-daytimer']//canvas"));
		  action.moveToElement(mainMenu1,50,0).click().perform();
		  Thread.sleep(8000);
		  driver.findElement(By.xpath(".//*[@id='diagnosticClinicTimeSlots']")).click();
		 System.out.println("END OF TEST CASE AND TEST CASE PASSED");
		
	 }
	  
  }
  public boolean cancelAllAppointments(String d1, String d2) throws InterruptedException
  {
	  boolean value=false;
	  System.out.println("BEGINNING TO DELETE ALL THE APPOINTMENTS");
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
		  value=true;
	  }
	  
	  else 
	  {
		  AssertJUnit.fail(actual_text);
	  }	 
	  return value;
  }
  public String changeNoOfAppointmentsPerSlot() throws InterruptedException
  {
	  WebElement mainMenu = driver.findElement(By.xpath(".//*[@class='sp-diag-conc-duration-timer sp-diag-conc-daytimer']//canvas"));
	  Actions action = new Actions(driver);
	  Thread.sleep(4000);
	  action.moveToElement(mainMenu,34,0).click().perform();
	  Thread.sleep(4000);
	  driver.findElement(By.xpath(".//*[@id='diagnosticClinicTimeSlots']")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.zy-status-wrapper")));
	  String actual_text=driver.findElement(By.cssSelector("div.zy-status-wrapper")).getText();
	  System.out.println(actual_text);
	  return actual_text;
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
 	  Object[][] retObjArr=TestUtils.getTableArray("TestData\\Doctors_TestData.xls", "Doctor", "ZOY983");
      return(retObjArr);
  }
  @AfterTest(groups = { "Regression","High" })
  public void afterTest() {
	  
	 // driver.close();
  }
}

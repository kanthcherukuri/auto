package doctorsTestScripts;

/*author - manraj bharaj

Description: Schedule Doctor under Hospitals tab , delete the time slot where no 
appointments are booked 
Check that no appointments whould be booked 
Schedule_ZOY851_DoctorHospital_EditTimeSlots_NoBookedApp
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testBase.LoadProp;
import testBase.TestUtils;

public class Schedule_ZOY851_DoctorHospital_EditTimeSlots_NoBookedApp {
	
	WebDriver driver;
	public  WebDriverWait wait; 
	String actual_text;
	
  @Test(dataProvider = "dp",groups = { "Regression","High" })
  public void testDoctorHospital_EditTimeSlots_NoBookedApp(String runmode,String date_from,String date_to) throws ParseException, InterruptedException {
	  
	  SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	  Date date_from1 = sdf.parse(date_from);
	  Date date_to1 = sdf.parse(date_to);
	  SimpleDateFormat sdf1=new SimpleDateFormat("d");
	  String d1=sdf1.format(date_from1);
	  String d2=sdf1.format(date_to1);
	  
	  
	  driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
	  wait=new WebDriverWait(driver, 8000);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]")));
	  driver.findElement(By.xpath(".//*[@id='appointment_appointmentCalendar']")).click();
	  driver.findElement(By.xpath("//*[@class='pa-cancl-apt fa fa-calendar-times-o cancel-apmpt-btn menu_links']")).click();
	
	  
	  System.out.println("SELECT THE DATES FOR BULK CANCELLATION");
	  driver.findElement(By.xpath(".//*[@id='datepicker-cancelfrom']")).click();
	  A:for(int i=1;i<=7;i++)
	  {
		  for(int j=1;j<=7;j++)
		  {
			  String date=driver.findElement(By.xpath("html/body/div[10]/div[1]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
			
			                                         
			  if(date.equals(d1))
			  {
				  driver.findElement(By.xpath("html/body/div[10]/div[1]/table/tbody/tr["+i+"]/td["+j+"]")).click();
				  break A;
			  }
		  }  
	  }
	  
	  driver.findElement(By.xpath(".//*[@id='datepicker-cancelto']")).click();
	  B:for(int i=1;i<=7;i++)
	  {
		  for(int j=1;j<=7;j++)
		  {
			  String date=driver.findElement(By.xpath("html/body/div[10]/div[1]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
			
			                                         
			  if(date.equals(d2))
			  {
				  driver.findElement(By.xpath("html/body/div[10]/div[1]/table/tbody/tr["+i+"]/td["+j+"]")).click();
				  break B;
			  }
		  }  
	  }
	  
	  driver.findElement(By.xpath(".//*[@id='fromTime']")).clear();
	  driver.findElement(By.xpath(".//*[@id='fromTime']")).sendKeys("00:00");
	  driver.findElement(By.xpath(".//*[@id='toTime']")).clear();
	  driver.findElement(By.xpath(".//*[@id='toTime']")).sendKeys("23:59");
	  driver.findElement(By.xpath(".//*[@id='cancelAppointmentsSubmit']")).click();
	  
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[6]/div")));
	  actual_text=driver.findElement(By.xpath("html/body/div[6]/div")).getText();
	  if(actual_text.contains("successfully"))
	  {
		  System.out.println("APPOINTMENTS CANCELLED SUCCESSFULLY" +actual_text);
	  }
	  
	  else 
	  {
		  Assert.fail(actual_text);
		  
	  }	 
	  
	  Thread.sleep(8000);
	  
	  driver.findElement(By.xpath(".//*[@id='schedule_scheduleIcon']")).click();
	  driver.findElement(By.xpath(".//*[@id='cd-12']/div")).click();
	  
      driver.findElement(By.xpath(".//*[@class='fa fa-plus-circle slot_hospital_add']")).click();
	  
	  List<WebElement> l=driver.findElements(By.xpath(".//*[@class='sp-doc-clinic-workday-switch-switch']"));
	  if(l.size()==1)
	  {
		  Assert.fail("NO SLOTS TO INCREASE/DECREASE TIMINGS");
	  }
	  if(l.size()>1)
	  {
		  SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm");
		  List<WebElement> l1=driver.findElements(By.xpath(".//*[@class='slot-end-hos']"));
		  List<WebElement> l2=driver.findElements(By.xpath(".//*[@class='fa fa-minus-circle hospital_rem_slot']"));
		  String t=l1.get(l1.size()-2).getAttribute("value");
		  System.out.println(sdf2.parse(t));
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(sdf2.parse(t));
		  cal.add(Calendar.MINUTE, 1);
		  String newTime = sdf2.format(cal.getTime());
          l1.get(l1.size()-2).clear();
		  l1.get(l1.size()-2).sendKeys(newTime);
		  l2.get(l2.size()-1).click();
		  driver.findElement(By.cssSelector(".sp-doc-hosp-schd-save")).click();
		  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.zy-status-wrapper")));
		  actual_text=driver.findElement(By.cssSelector("div.zy-status-wrapper")).getText();
		  System.out.println(actual_text);
		  if(actual_text.contains("Successfully"))
		  {
			  System.out.println("TEST CASE PASSED AND TIME SLOT DELETED SUCCESSFULLY");
		  }
		  else
		  {
			  Assert.fail(actual_text);
		  }
  }
  }
  
  @DataProvider
  public Object[][] dp() throws Exception {
 	  Object[][] retObjArr=TestUtils.getTableArray("TestData\\Doctors_TestData.xls", "Doctor", "ZOY851");
      return(retObjArr);
  }
  
  
  @BeforeTest(groups = { "Regression","High" })
  public void beforeTest() throws Exception {
	  
	  driver=LoadProp.LoadBrowserProperties();
	  driver.get(LoadProp.doctors_Url);
	 
	  driver.manage().window().maximize();
	  Thread.sleep(4000);
	  driver.findElement(By.id("emailAddress")).sendKeys(LoadProp.DoctorsLogin_usernameone);
	  driver.findElement(By.id("password")).sendKeys(LoadProp.DoctorsLogin_passwordone);
	  driver.findElement(By.xpath(".//*[@id='zoyloCustLogin-form']//button[@class='signup-btn']")).click();
	 
	  
  }

  @AfterTest(groups = { "Regression","High" })
  public void afterTest() {
	  
	 // driver.close();
  }
}

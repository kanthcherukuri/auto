package doctorsTestScripts;

/*author - manraj bharaj

 */

import org.testng.annotations.Test;
import testBase.LoadProp;
import testBase.TestUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Schedule_ZOY807_Doctor_UpdateTimings {

    WebDriver driver;
	public  WebDriverWait wait; 
	String actual_text;
	
	
  @Test(dataProvider = "dp",groups = { "Regression","High" }) 
  public void validateTimeSlot(String runmode,String new_start_time,String new_end_time) throws InterruptedException, ParseException {
	  
	  SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
	  System.out.println(sdf.parse(new_start_time));
	  System.out.println(sdf.parse(new_end_time));
	  if(sdf.parse(new_start_time).equals(sdf.parse(new_end_time)))
	  {
		  Assert.fail("Added times are same");
	  }
	  if(sdf.parse(new_start_time).after(sdf.parse(new_end_time)))
	  {
		  Assert.fail("new_end_time is less than new_start_time");
	  }
	  
	  ArrayList<String> al=new ArrayList<String>();
	  wait=new WebDriverWait(driver, 15000);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='schedule_scheduleIcon']")));
	  driver.findElement(By.xpath(".//*[@id='schedule_scheduleIcon']")).click();
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@data-tab='tab-clinic']/div")));
	  driver.findElement(By.xpath(".//*[@data-tab='tab-clinic']/div")).click();
	  List<WebElement> slots=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//span[@class='sp-doc-clinic-workday-switch-switch']"));
	  System.out.println("Checking if all time slots are valid");
	  List<WebElement> ct_startslots=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-start']"));
	  List<WebElement> ct_endslots=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-end']"));;
	  for(int i=0;i<=slots.size()-1;i++)
	  {
		  String ct_startslot=ct_startslots.get(i).getAttribute("value");
		  String ct_endslot=ct_endslots.get(i).getAttribute("value");
		  System.out.println(ct_startslot+"------"+ct_endslot);
		  al.add(ct_startslot);
		  al.add(ct_endslot);
		 if(sdf.parse(new_start_time).equals(sdf.parse(ct_startslot)) || sdf.parse(new_end_time).equals(sdf.parse(ct_startslot)) ) 
		 {
			 Assert.fail("New start time is not unique");
		 }
		 else if(sdf.parse(new_start_time).equals(sdf.parse(ct_endslot)) || sdf.parse(new_end_time).equals(sdf.parse(ct_endslot)) ) 
		 {
			 Assert.fail("New end time is not unique");
		 }
		 else
		 {
			 System.out.println(("New time slots are unique"));
		 }
	  System.out.println("Checking if the added time slots are overlapping or not ");
	  
	  if(sdf.parse(new_start_time).after(sdf.parse(ct_startslot)) && sdf.parse(new_start_time).before(sdf.parse(ct_endslot)))
	  {
		 Assert.fail("Specified START-Slot overlaps  " +(i+1)+"  line   "+sdf.parse(new_start_time));
	  }
	  if(sdf.parse(new_end_time).after(sdf.parse(ct_startslot)) && sdf.parse(new_end_time).before(sdf.parse(ct_endslot)))
	  {
		 Assert.fail("Specified END-Slot overlaps  "+(i+1)+"  line   " +sdf.parse(new_end_time));
	  }
	  }
  
	  

	  System.out.println("Adding the new time slot just as a measure of check ");  
		  driver.findElement(By.xpath(".//*[@id='clinic_add_slot']")).click();
		  List<WebElement> slots1=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//span[@class='sp-doc-clinic-workday-switch-switch']"));
		  slots1.get(slots1.size()-1).click();
		  List<WebElement> ct_startslot1=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-start']"));
		  List<WebElement> ct_endslot1=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-end']"));;
		  ct_startslot1.get(ct_startslot1.size()-1).sendKeys(new_start_time);
		  ct_endslot1.get(ct_endslot1.size()-1).sendKeys(new_end_time);
		  driver.findElement(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-schd-save-btn clinic_slots_save']")).click();
		  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[6]/div")));
		  actual_text=driver.findElement(By.xpath("html/body/div[6]/div")).getText();
		  System.out.println(actual_text);
		 
		  
		  driver.findElement(By.xpath(".//*[@id='appointments']/span[2]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//i[@class='fa fa-ellipsis-v footer-relipse']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(".//*[@id='dashboard_dashboardIcon']")).click();
		  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]"))); 
		  
		  if(!actual_text.contains("Successfully"))
		  {
			  System.out.println("Test case failed;adding time slot is unsuccessful");
			  if(actual_text.contains("Specified Slot overlaps"))
			  {
				  System.out.println("Overlapping due to times added in OTHER CLINICS or HOSPITALS" +new_start_time+"start time" +new_end_time+"end time");
			  }
			  Assert.fail(actual_text);
		  }  
  }
  
	  
  

  @DataProvider
  public Object[][] dp() throws Exception {
	  Object[][] retObjArr=TestUtils.getTableArray("TestData\\Doctors_TestData.xls", "Doctor", "ZOY807");
      return(retObjArr);
  }
  @BeforeClass(groups = { "Regression","High" })
  public void beforeClass() throws Exception {
	  
	  driver=LoadProp.LoadBrowserProperties();
	  driver.get(LoadProp.doctors_Url);
	  driver.manage().window().maximize();
	  Thread.sleep(4000);
	  driver.findElement(By.id("emailAddress")).sendKeys(LoadProp.DoctorsLogin_usernameone);
	  driver.findElement(By.id("password")).sendKeys(LoadProp.DoctorsLogin_passwordone);
	  driver.findElement(By.xpath(".//*[@id='zoyloCustLogin-form']//button[@class='signup-btn']")).click();
	  Thread.sleep(4000);
  }

  @AfterClass(groups = { "Regression","High" })
  public void afterClass() {
	  
	  driver.close();
  }

}

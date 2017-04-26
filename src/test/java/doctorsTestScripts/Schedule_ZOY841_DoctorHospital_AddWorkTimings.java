package doctorsTestScripts;

/*
 * @author-Manraj Bharaj

 * 
 * Description- Test case for "Adding time slots" under HOSPITAL tab for DOCTORS module. 
 * Follow ZOY841 JIRA for understanding the manual test case
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

public class Schedule_ZOY841_DoctorHospital_AddWorkTimings{
	
	WebDriver driver;
	public  WebDriverWait wait; 
	String actual_text;
	int start;
	int end;
	int start_new1;
	int end_new1;
	boolean status_d=false;
	boolean status=false;
	
	
 //===============================================================================================================================================================//	
	
	@Test(enabled=true,dataProvider="DP1",groups = { "Regression","High" })
      public void testAddHospitalWorkTimings(String runmode, String day, String start_new, String end_new) throws InterruptedException, ParseException, AWTException {
	  
	  driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
	  wait=new WebDriverWait(driver, 8000);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]")));
	  driver.findElement(By.xpath(".//*[@id='schedule_scheduleIcon']")).click();
	  driver.findElement(By.xpath(".//*[@id='cd-11']/div")).click();
	  status_d=checkSlotData( day, start_new, end_new);
	  if(!status_d==true)
		 {
			 AssertJUnit.fail();
		 }
	  List<String> l = getNumberOfClinics();
	  for(int i=0;i<=l.size()-1;i++)
	  {
		  selectClinic(l.get(i));
		  status=checkSlotData( day,  start_new,  end_new);
		 if(!status==true)
		 {
			 AssertJUnit.fail();
			 break;
		 }
		  
	  }
	  if(status==true)
	  {
		  driver.findElement(By.xpath(".//i[@class='fa fa-plus-circle slot_hospital_add']")).click();
		  List<WebElement> timeslots_temp=driver.findElements(By.xpath(".//span[@class='sp-doc-clinic-workday-switch-switch']"));
		  timeslots_temp.get(timeslots_temp.size()-1).click();
		  List<WebElement> startslots=driver.findElements(By.xpath(".//input[@class='slot-start-hos']"));
		  List<WebElement> endslots=driver.findElements(By.xpath(".//input[@class='slot-end-hos']"));
		  startslots.get(startslots.size()-1).sendKeys(start_new);
		  endslots.get(endslots.size()-1).sendKeys(end_new);
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
		  
		  if(!actual_text.contains("Schedule Updated Successfully"))
		  {
	           System.out.println("TEST CASE FAILED, ADDING TIME SLOT UNSUCCESSFUL");
			  
			  AssertJUnit.fail(actual_text);
			  
		  }  
		  
		  
	  }
	  
}
	
	
	public boolean checkSlotData(String day, String start_new, String end_new){
		    boolean status=false;
		    driver.findElement(By.xpath(".//*[@id='cd-12']/div")).click();
			driver.findElement(By.xpath(".//li[@data-hospi-tab='"+day+"']/div")).click();
			driver.findElement(By.xpath(".//i[@class='fa fa-plus-circle slot_hospital_add']")).click();
		  
		  List<WebElement> timeslots_temp=driver.findElements(By.xpath(".//div[@class='sp-doc-clinic-strt']/span/input"));
		  if(timeslots_temp.size()==2)
		  {
			  System.out.println("THERE ARE NO SLOTS AT ALL UNDER HOSPITALS OR CLINICS TAB");
			  driver.findElement(By.xpath(".//*[@class='fa fa-minus-circle hospital_rem_slot']")).click();
			  status=true;
			  
		  }
		  if(timeslots_temp.size()>2) 	
		  { 
			  List<WebElement> m_slots=driver.findElements(By.xpath(".//*[@class='fa fa-minus-circle hospital_rem_slot']"));
			  m_slots.get(m_slots.size()-1).click();
			  List<WebElement> timeslots=driver.findElements(By.xpath(".//div[@class='sp-doc-clinic-strt']/span/input"));
			  
		  for(int i=0;i<=timeslots.size()-2;i=i+2)
		  {
			  start=Integer.parseInt(timeslots.get(i).getAttribute("value").replace(":", ""));
			  end=Integer.parseInt(timeslots.get(i+1).getAttribute("value").replace(":", ""));
			  start_new1=Integer.parseInt(start_new.replace(":", ""));
			  end_new1=Integer.parseInt(end_new.replace(":", ""));
			  System.out.println(start);
			  System.out.println(end);
			  
			  if(start_new1>=start && start_new1<=end && end_new1>=start && end_new1<=end )
			  {
				  System.out.println("Time slot invalid as it lies between the existing slots");
				  AssertJUnit.fail();
			  }
			  
			  if(start_new1==start || start_new1==end || end_new1==start || end_new1==end )
			  {
				  System.out.println("Time slot invalid as it equals the existing slots");
				  AssertJUnit.fail();
			  }
			  else
			  {
				  System.out.println("Time slot valid");
				  status=true;
				  System.out.println(status);
			  }
		  }
		  }
		  
		
		  return status;
	}
	
	public List<String> getNumberOfClinics()
	{
		List<String> l=new ArrayList<String>();
		driver.findElement(By.xpath(".//*[@id='cd-11']/div")).click();
		driver.findElement(By.xpath(".//*[@id='profile-flip']/span[2]")).click();
		List<WebElement> timeslots=driver.findElements(By.xpath(".//div[@class='sp-clinic-address sp-clinic-click']"));
		for(int i=0;i<=timeslots.size()-1;i++)
		{
			l.add(timeslots.get(i).getAttribute("data-cl-name"));
		}
		
		driver.findElement(By.xpath(".//*[@id='profile-flip']/span[2]")).click();
		return l;
	}
	
	public void selectClinic( String clinic)
	{
		driver.findElement(By.xpath(".//*[@id='cd-11']/div")).click();
		driver.findElement(By.xpath(".//*[@id='profile-flip']/span[2]")).click();
		List<WebElement> timeslots=driver.findElements(By.xpath(".//div[@class='sp-clinic-address sp-clinic-click']"));
		for(int i=0;i<=timeslots.size()-1;i++)
		{
			if(timeslots.get(i).getAttribute("data-cl-name").equals(clinic))
			{
				timeslots.get(i).click();
				break;
			}
		}
	}
//===============================================================================================================================================================//	
	
  @DataProvider()
  public Object[][] DP1() throws Exception{
	  
      Object[][] retObjArr=TestUtils.getTableArray("TestData\\Doctors_TestData.xls", "Doctor", "ZOY841");
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

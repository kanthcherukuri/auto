package doctorsTestScripts;

/*author - manraj bharaj

 */

import org.testng.annotations.Test;

import testBase.LoadProp;
import testBase.TestUtils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Schedule_ZOY811_Doctor_DeleteWrongTimings {
	public String date="28/03/17";
	WebDriver driver;
	public  WebDriverWait wait; 
	String actual_text_cd;
	SimpleDateFormat sdf=new SimpleDateFormat("hh:mm");
	SimpleDateFormat sdf1=new SimpleDateFormat("EEEE");
	SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yy");
	boolean result_cd=false;
	boolean result1=false;
	boolean result2=false;
	
	
	
  @Test(dataProvider = "dp",groups = { "Regression","High" })
  public void testDeleteTimings(String runmode,String timeToBeDeleted) throws ParseException, InterruptedException {
	 
	  Date d1=sdf2.parse(date.trim());
      String day_of_week=sdf1.format(d1);
	  wait=new WebDriverWait(driver, 15000);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='schedule_scheduleIcon']")));
	  driver.findElement(By.xpath(".//*[@id='schedule_scheduleIcon']")).click();
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@data-tab='tab-clinic']/div")));
	  driver.findElement(By.xpath(".//*[@data-tab='tab-clinic']/div")).click();

	  
	  ArrayList<String> al = new ArrayList<String>();
	  driver.findElement(By.xpath(".//*[@id='profile-flip']/span[2]")).click();
   	  List<WebElement> other_clinics=driver.findElements(By.xpath(".//*[@id='profile-panel']//h5"));
   	  for(int k=0;other_clinics.size()>0 && k<=other_clinics.size()-1;k++)
   	  {
   	      al.add(other_clinics.get(k).getText());
   	      System.out.println(al.get(k));
   	  }
   	  driver.findElement(By.xpath(".//*[@id='profile-flip']/span[2]")).click();
   	  //================================================================================================================================================//
   	  
	  System.out.println("Searching in default clinic"); 
	  boolean result=findTheWrongTimeSlotClinic(day_of_week,timeToBeDeleted);
	  if(result==true)
			  {
		  System.out.println("DELETION UNSUCCESSFUL BUT FOUND CORRECT TIME SLOT");
			  }
	  
	//================================================================================================================================================//
	 
	  if((!result==true) && al.size()>0)
	  {    
		  System.out.println("Checking all the other clinics");
		  for(int j =0;j<=al.size()-1;j++)
		  {
			  selectTheOtherClinic(al.get(j));
			  result1=findTheWrongTimeSlotClinic(day_of_week,timeToBeDeleted);
			  if(result1==true )
			  {
				  break;
			  }
		  }
		  
	  }
	  
	  if(result1==true)
	  {
      System.out.println("DELETION UNSUCCESSFUL BUT FOUND CORRECT TIME SLOT");
	  }
	  
	  //================================================================================================================================================//
	 if ((!result1==true ) || ((!result==true) && al.size()==0))
	 { 
		 System.out.println("Checking all the hospitals");
		 
		 result2=findTheWrongTimeSlotHospital(day_of_week,timeToBeDeleted);
		 
		 if(!result2==true)
		 {
			 System.out.println("Test case failed");
		 }
		 else  if(result2==true)
		 {
			 System.out.println("DELETION UNSUCCESSFUL BUT FOUND CORRECT TIME SLOT");
			 System.out.println("Test case passed");
		 }
	 }
	 
	  
 }

 public boolean findTheWrongTimeSlotClinic(String day_of_week,String timeToBeDeleted) throws ParseException
 {
	  driver.findElement(By.xpath(".//*[@data-clinic-slot='"+day_of_week+"']/div")).click();
	  List<WebElement> startslots=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-start']"));
	  List<WebElement> endslots=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-end']"));
	  List<WebElement> minusslots=driver.findElements(By.xpath(".//*[@class='fa fa-minus-circle clinc_rem_slot']"));
	 
	  if(startslots.size()==0)
	  {
		  System.out.println("There are no time slots");
		  result_cd=false;
	  }
	  
	  for(int i=0;i<=startslots.size()-1;i++)
	  {
		  String start_time=startslots.get(i).getAttribute("value");
		  String end_time=endslots.get(i).getAttribute("value");
		  if((sdf.parse(start_time).before(sdf.parse(timeToBeDeleted)) && sdf.parse(end_time).after(sdf.parse(timeToBeDeleted))) ||
				  sdf.parse(start_time).equals(sdf.parse(timeToBeDeleted)) || sdf.parse(end_time).before(sdf.parse(timeToBeDeleted)))
		  {
			  minusslots.get(i).click();
			  
			  int size=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-start']")).size();
			  if(size==startslots.size()-1)
			  {
				  Assert.fail("Incorrect time slot , it has no booked appointment");
			  }
			  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[6]/div")));
			   if(driver.findElement(By.xpath("html/body/div[6]/div")).getText().contains("Conflicts") && size==startslots.size())
		      {
				  result_cd=true;
				  break;
		      }
		  } 
	  }
	 
	  return result_cd;
 }
 
 
 public int countTheTimeSlot() throws ParseException
 {
	 return driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-start']")).size();
 }
 
public boolean findTheWrongTimeSlotHospital(String day_of_week,String timeToBeDeleted) throws ParseException
 {
	  
	  driver.findElement(By.xpath(".//*[@id='cd-12']/div")).click();
	  driver.findElement(By.xpath(".//*[@data-hospi-tab='"+day_of_week+"']/div")).click();
	  List<WebElement> startslots=driver.findElements(By.xpath(".//*[@id='tab-hosp-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-start-hos']"));
	  List<WebElement> endslots=driver.findElements(By.xpath(".//*[@id='tab-hosp-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-end-hos']"));
	  List<WebElement> minusslots=driver.findElements(By.xpath(".//*[@class='fa fa-minus-circle hospital_rem_slot']"));
	 
	  if(startslots.size()==0)
	  {
		  System.out.println("There are no time slots");
		  result_cd=false;
	  }
	  
	  for(int i=0;i<=startslots.size()-1;i++)
	  {
		  String start_time=startslots.get(i).getAttribute("value");
		  String end_time=endslots.get(i).getAttribute("value");
		  if((sdf.parse(start_time).before(sdf.parse(timeToBeDeleted)) && sdf.parse(end_time).after(sdf.parse(timeToBeDeleted))) 
			|| sdf.parse(start_time).equals(sdf.parse(timeToBeDeleted))  ||sdf.parse(start_time).equals(sdf.parse(timeToBeDeleted)))
		  {
			  minusslots.get(i).click();
			  int size=driver.findElements(By.xpath(".//*[@id='tab-hosp-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-start-hos']")).size();
			  if(size==startslots.size()-1)
			  {
				  Assert.fail("Incorrect time slot , it has no booked appointment");
			  }
			  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[6]/div")));
              if(driver.findElement(By.xpath("html/body/div[6]/div")).getText().contains("Conflicts") && size==startslots.size() )
		      {
				  result_cd=true;
				  break;
		      }
		  } 
	  }
	 
	  return result_cd;
 }
 
 public void selectTheOtherClinic(String clinicName)
 {
	 driver.findElement(By.xpath(".//*[@id='profile-flip']/span[2]")).click();
	 List<WebElement> other_clinics=driver.findElements(By.xpath(".//*[@id='profile-panel']//h5"));
	 
	 for(int k=0;other_clinics.size()>0 && k<=other_clinics.size()-1;k++)
  	  {
		 if(other_clinics.get(k).getText().equals(clinicName) )
				 {
			 other_clinics.get(k).click();
				 }
    }
  	 
 }
 
 @DataProvider
 public Object[][] dp() throws Exception {
	  Object[][] retObjArr=TestUtils.getTableArray("TestData\\Doctors_TestData.xls", "Doctor", "ZOY811");
     return(retObjArr);
 }
 
  @BeforeTest(groups = { "Regression","High" })
  public void beforeTest() throws Exception {
	  
	  driver=LoadProp.LoadBrowserProperties();
	  driver.get(LoadProp.base_url+"login");
	 
	  driver.manage().window().maximize();
	  Thread.sleep(4000);
	  driver.findElement(By.id("emailAddress")).sendKeys(LoadProp.DoctorsLogin_username);
	  driver.findElement(By.id("password")).sendKeys(LoadProp.DoctorsLogin_password);
	  driver.findElement(By.xpath(".//*[@id='zoyloCustLogin-form']//button[@class='signup-btn']")).click();
	 
	  
  }

  @AfterTest(groups = { "Regression","High" })
  public void afterTest() {
  }

}

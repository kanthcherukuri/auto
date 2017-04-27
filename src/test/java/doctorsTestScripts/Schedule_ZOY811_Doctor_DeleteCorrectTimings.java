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

public class Schedule_ZOY811_Doctor_DeleteCorrectTimings {
	
	WebDriver driver;
	public  WebDriverWait wait; 
	String actual_text_cd;
	SimpleDateFormat sdf=new SimpleDateFormat("hh:mm");
	SimpleDateFormat sdf1=new SimpleDateFormat("EEEE");
	SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yy");
	boolean result_cd=false;
	boolean result=false;
	boolean result1=false;
	boolean result2=false;
	
	
	
  @Test(dataProvider = "dp",groups = { "Regression","High" })
  public void testDeleteTimings(String runmode,String date,String timeToBeDeleted) throws ParseException, InterruptedException {
	 
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
   	  }
   	  driver.findElement(By.xpath(".//*[@id='profile-flip']/span[2]")).click();
   	  //================================================================================================================================================//
   	  
	  System.out.println("Searching in default clinic"); 

	  result=findTheCorrectTimeSlotClinic(day_of_week,timeToBeDeleted); 
	
	//================================================================================================================================================//
	int count=0;
	  if((!result==true) && al.size()>0)
	  {    
		  System.out.println("Checking all the other clinics");
		  for(int j =0;j<=al.size()-1;j++)
		  {
		
			  selectTheOtherClinic(al.get(j));
			  result1=findTheCorrectTimeSlotClinic(day_of_week,timeToBeDeleted);
			  if(result1==true )
			  {
				  System.out.println("DELETION SUCCESSFUL IN OTHER CLINIC");
				  break;
			  }
			  if(result1==false )
			  {
				  count++;
			  }
		  }
		  
	  }
	  if(count==al.size())
	  {
		  Assert.fail("failure");
	  }
	  
	  
  }
	 


 public boolean findTheCorrectTimeSlotClinic(String day_of_week,String timeToBeDeleted) throws ParseException
 {
	  String actual_text="";
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
		  if(   sdf.parse(start_time).before(sdf.parse(timeToBeDeleted)) && sdf.parse(end_time).after(sdf.parse(timeToBeDeleted)) )
		  {
			  minusslots.get(i).click();
			  driver.findElement(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-schd-save-btn clinic_slots_save']")).click();
			  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[6]/div")));
			  actual_text=driver.findElement(By.xpath("html/body/div[6]/div")).getText();
			  System.out.println(actual_text);
			  int size=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-start']")).size();
			  System.out.println(size);
			  System.out.println(startslots.size()-1);
			  int x=startslots.size()-1;
			  if((size==x) && actual_text.contains("Schedule Updated Successfully"))
			  {
				  System.out.println("TIME SLOT DELETED FROM CLINICS");
				  result_cd=true;
				  break;
			  }
			  else if (actual_text.contains("Conflicts"))
			  {
				  Assert.fail(actual_text);
			  }
		  } 
	  }
	 
	  System.out.println(result_cd);
	  return result_cd;
 }
 
 public int countTheTimeSlot() throws ParseException
 {
	 return driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-start']")).size();
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
	  driver.get(LoadProp.doctors_Url);
	 
	  driver.manage().window().maximize();
	  Thread.sleep(4000);
	  driver.findElement(By.id("emailAddress")).sendKeys(LoadProp.DoctorsLogin_usernameone);
	  driver.findElement(By.id("password")).sendKeys(LoadProp.DoctorsLogin_passwordone);
	  driver.findElement(By.xpath(".//*[@id='zoyloCustLogin-form']//button[@class='signup-btn']")).click();
	 
	  
  }

  @AfterTest(groups = { "Regression","High" })
  public void afterTest() {
	//  driver.close();
  }

}

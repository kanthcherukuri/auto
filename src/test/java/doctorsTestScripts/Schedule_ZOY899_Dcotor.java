package doctorsTestScripts;


/*author - manraj bharaj
 * ZOY899 Test case for "Schedule_Hospitals" scenarios - Activate/Deactivate time slot
 * 
 * 
 */

import org.testng.annotations.Test;

import testBase.LoadProp;
import testBase.TestUtils;

import org.testng.annotations.BeforeTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.print.DocFlavor.STRING;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Schedule_ZOY899_Dcotor {
	
	WebDriver driver;
	public  WebDriverWait wait ;
	
  @Test(enabled=true)
  public void f() throws InterruptedException, ParseException {
	  WebDriverWait wait=new WebDriverWait(driver, 20);
	  String date="23-03-2017"; 
	 // int location=11;
	  String value=null;
	  String clinic_type="Gayatri Dental Clinic";
	  String new_start_time="17:00";
	  String new_end_time="17:30";
	  SimpleDateFormat sdf_date=new SimpleDateFormat("d");
	  SimpleDateFormat sdf_2=new SimpleDateFormat("HH:mm");
	  Date d1=new Date();
	  SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	  d1=sdf.parse(date);
	  int date1 = Integer.parseInt(sdf_date.format(d1));
	  SimpleDateFormat sdf1=new SimpleDateFormat("EEEE");
	  String day_of_week=sdf1.format(d1);
	  Thread.sleep(2000);
	  // check to see if new_start_time and new_end_time are not equal and new_end_time is greater than new_start_time
	  if(sdf_2.parse(new_start_time).equals(sdf_2.parse(new_end_time))&&(sdf_2.parse(new_end_time).before(sdf_2.parse(new_start_time))))
	  {
		  Assert.fail("New end time and start time are either equal or less than , please enter valid time");
	  }
	  
	  driver.findElement(By.xpath(".//*[@id='mycalendar']//a["+date1+"]/div[1]")).click();
	  List<WebElement> timings=driver.findElements(By.xpath(".//*[@id='scrolls']//div[@class='timing']/span[1]"));
	  if(timings.size()>0)
	  {
		  for(int j=0;j<=timings.size()-1;j++)
		  {
			  System.out.println("The appoinments schedule are---" +j+ "----->" +timings.get(j).getText() );
			  String t=timings.get(j).getText();
			  SimpleDateFormat sdf_t=new SimpleDateFormat("hh:mm a");
			  SimpleDateFormat sdf_t1=new SimpleDateFormat("HH:mm");
			  System.out.println(sdf_t1.format(sdf_t.parse(t)));
			  
			  if(sdf_t1.format(sdf_t.parse(t)).equals(sdf_2.parse(new_start_time)) || sdf_t1.format(sdf_t.parse(t)).equals(sdf_2.parse(new_end_time)) )
			  {
				  
		          Assert.fail("Time conflicts with the appointments");
			  }
		  }
	  } 
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='schedule_scheduleIcon']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@data-tab='tab-clinic']/div")).click();
	  
		//search for the required clinic from more tab
	  if(clinic_type != "Default Clinic")
	  {
			  driver.findElement(By.xpath(".//*[@id='profile-flip']/span[2]")).click();
		   	  List<WebElement> other_clinics=driver.findElements(By.xpath(".//*[@id='profile-panel']//h5"));
		   	  if(other_clinics.size()>0)
		   	  {
		   	  for(int n=0;n<=other_clinics.size()-1;n++)
		   	  {
		   	 System.out.println(other_clinics.get(n).getText());
		   	 if(other_clinics.get(n).getText().equals(clinic_type)) 
		   	 {
		   		other_clinics.get(n).click(); 
		   	 }
		     }
		   	 }
	  } // if ends here
	  
	  for(int m=0;m<=6;m++)
	  {
		  if(driver.findElement(By.xpath(".//*[@id='cd-"+m+"']/div")).getText().equalsIgnoreCase(day_of_week))
		  {
			  driver.findElement(By.xpath(".//*[@id='cd-"+m+"']/div")).click();  // select the day_of_week
			  List<WebElement> ct_startslot=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-start']"));
			  List<WebElement> ct_endslot=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-end']"));
			  
			  //matching the timings if they are 
			  if(ct_startslot.size()>0)
			  {
				  for(int i=0;i<=ct_startslot.size()-1;i++)
				  {   Thread.sleep(2000);
			    	  System.out.println("clinic start slot----->"+ct_startslot.get(i).getAttribute("value")+ "        clinic end slot----->"+ct_endslot.get(i).getAttribute("value"));
					  String start_time=ct_startslot.get(i).getAttribute("value");
					  SimpleDateFormat sdf_1=new SimpleDateFormat("HH:mm");
					  SimpleDateFormat sdf_3=new SimpleDateFormat("HH:mm");
					  String end_time=ct_endslot.get(i).getAttribute("value");
					  if((!sdf_1.parse(start_time).equals(sdf_2.parse(new_start_time)))&&(sdf_3.parse(end_time).before(sdf_2.parse(new_start_time))))
							  {
						  value="false";
						 	  }
					  else    {
						  System.out.println("new time is incorrect");
						  value="true";
						  break;
					          }
	               }
			  }
			  else 
				  break;
	      }
	  }// for loop ends here
	  
	  driver.findElement(By.xpath(".//*[@id='cd-12']/div")).click();
	  for(int n=20;n<=26;n++)
	  {
		  if(driver.findElement(By.xpath(".//*[@id='cd-"+n+"']/div")).getText().equalsIgnoreCase(day_of_week))
		  
		  {
			  driver.findElement(By.xpath(".//*[@id='cd-"+n+"']/div")).click();
			  List<WebElement> hos_startslot=driver.findElements(By.xpath(".//*[@id='tab-hosp-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-start-hos']"));
			  List<WebElement> hos_endslot=driver.findElements(By.xpath(".//*[@id='tab-hosp-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-end-hos']"));
			  for(int i=0;i<=hos_startslot.size()-1;i++)
			  {
				  System.out.println("hospital start slot----->"+hos_startslot.get(i).getAttribute("value")+ "      hospital end slot----->"+hos_endslot.get(i).getAttribute("value"));
				  SimpleDateFormat sdf_1=new SimpleDateFormat("HH:mm");
				  SimpleDateFormat sdf_3=new SimpleDateFormat("HH:mm");
				  String start_time=hos_startslot.get(i).getAttribute("value");
				  String end_time=hos_endslot.get(i).getAttribute("value");
				  if((!sdf_1.parse(start_time).equals(sdf_2.parse(new_start_time)))&&(sdf_3.parse(end_time).before(sdf_2.parse(new_start_time))))
						  {
					  value="false";
					      }
				  
				  else  {
					  System.out.println("new time is incorrect");
					  value="true";
					  break;
				  }
			  }
			  
			  if (value.equals("true"))
			  {
				  break;
			  }
			  
		  }
		  
	  }// for loop for hospitals breaks here and revert back to clinic
	   // starting the addition of new time slot for clinics
	  
	  driver.findElement(By.xpath(".//*[@id='cd-11']/div")).click();	  
	  for(int m=0;m<=6;m++)
	  { 
		  if(driver.findElement(By.xpath(".//*[@id='cd-"+m+"']/div")).getText().equalsIgnoreCase(day_of_week))
		  {
			  driver.findElement(By.xpath(".//*[@id='cd-"+m+"']/div")).click();
			  if(value.equalsIgnoreCase("false"))
			  {
				  driver.findElement(By.xpath(".//*[@id='clinic_add_slot']")).click();
				  List<WebElement> slots=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//span[@class='sp-doc-clinic-workday-switch-switch']"));
				  slots.get(slots.size()-1).click();
				  List<WebElement> ct_startslot=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-start']"));
				  List<WebElement> ct_endslot=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-end']"));;
				  ct_startslot.get(ct_startslot.size()-1).sendKeys(new_start_time);
				  ct_endslot.get(ct_endslot.size()-1).sendKeys(new_end_time);
				  driver.findElement(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-schd-save-btn clinic_slots_save']")).click();
				  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[6]/div")));
				  String actual_text=driver.findElement(By.xpath("html/body/div[6]/div")).getText();
				  System.out.println(actual_text);
				  Assert.assertEquals(actual_text,"Schedule Updated Successfully");
			  }
			  
			  else
				  break;
		  }
	  }
	  
        
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	 
	  driver=LoadProp.LoadBrowserProperties();
	  wait=new WebDriverWait(driver,2000);
	  driver.get(LoadProp.base_url);
	  driver.findElement(By.id("emailAddress")).sendKeys(LoadProp.login_username);
	  driver.findElement(By.id("password")).sendKeys(LoadProp.login_password);
	  driver.findElement(By.xpath(".//*[@id='zoyloCustLogin-form']//button[@class='signup-btn']")).click();
	  Thread.sleep(2000);
	   }
	  
	 // WebElement schedule_icon=driver.findElement(By.xpath(".//*[@id='schedule_scheduleIcon']"));
	 // wait.until(ExpectedConditions.visibilityOf(schedule_icon));
	  
	  
	  
  

  @AfterTest
  public void afterTest() throws Exception {
	  
	 driver.close();
	
  }

}

package doctorsTestScripts;


/*author - manraj bharaj
 * ZOY899 Test case for "Schedule_Hospitals" scenarios - Activate/Deactivate time slot
 * 
 * 
 */

import org.testng.annotations.Test;

import testBase.LoadProp;
import testBase.TestUtils;
import org.testng.annotations.DataProvider;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class Schedule_ZOY899_Doctor {
	
	WebDriver driver;
	public  WebDriverWait wait ;
  
  @Test(enabled=true,dataProvider="DP1")
  public void f(String runmode,String date,String clinic_type,String new_start_time,String new_end_time) throws InterruptedException, ParseException {
	  int date1;
	  int incorrect=0;
	  int day_num=0;
	  WebDriverWait wait=new WebDriverWait(driver, 8000);
	  String value_c=null;
	  String value_c1=null;
	  String value_h=null;
	  SimpleDateFormat sdf_date=new SimpleDateFormat("d");
	  SimpleDateFormat sdf_2=new SimpleDateFormat("HH:mm");
	  Date d1=new Date();
	  SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yy");
	  d1=sdf.parse(date.trim());
	  date1 = Integer.parseInt(sdf_date.format(d1));
	  SimpleDateFormat sdf1=new SimpleDateFormat("EEEE");
	  String day_of_week=sdf1.format(d1);
	
	  //================================================================================================================================================//	
	  
	  System.out.println("Check to see if new_start_time and new_end_time are not equal and new_end_time is greater than new_start_time");
	  if(sdf_2.parse(new_start_time).equals(sdf_2.parse(new_end_time))  ||(sdf_2.parse(new_end_time).before(sdf_2.parse(new_start_time))))
	  {
		 System.out.println("New end time and start time are either equal or less than , please enter valid time");
		 incorrect++;
	  }
	 
	  //================================================================================================================================================//
	  driver.findElement(By.xpath(".//*[@id='mycalendar']//a["+date1+"]/div[1]")).click();
	  List<WebElement> timings=driver.findElements(By.xpath(".//*[@id='scrolls']//div[@class='timing']/span[1]"));
	  System.out.println(timings.size());
	  if(timings.size()>0)
	  {  
		  if(timings.size()>5)
		  {
			  driver.findElement(By.xpath(".//*[@id='show-all-btn']")).click();
		  }
		  for(int j=0;j<=timings.size()-1;j++)
		  {
			  System.out.println("The appoinments schedule are---" +j+ "----->" +timings.get(j).getText() );
			  String t=timings.get(j).getText();
			  SimpleDateFormat sdf_t=new SimpleDateFormat("hh:mm a");
			  SimpleDateFormat sdf_t1=new SimpleDateFormat("HH:mm");
			  System.out.println(sdf_t1.format(sdf_t.parse(t)));
			  
			  if(sdf_t1.format(sdf_t.parse(t)).equals(sdf_2.parse(new_start_time)) || sdf_t1.format(sdf_t.parse(t)).equals(sdf_2.parse(new_end_time)) )
			  {
				  
				  System.out.println("Conflict with the appointments");
               }
			 
		  }
	  } 
	 
	  driver.findElement(By.xpath(".//*[@id='schedule_scheduleIcon']")).click();
	  Thread.sleep(4000);
	  driver.findElement(By.xpath(".//*[@data-tab='tab-clinic']/div")).click();
	  //================================================================================================================================================//
	  int count=0;
	  for(int m=0;m<=6;m++)
	  {
		  if(driver.findElement(By.xpath(".//*[@id='cd-"+m+"']/div")).getText().equalsIgnoreCase(day_of_week))
		  { 
			  driver.findElement(By.xpath(".//*[@id='cd-"+m+"']/div")).click();  // select the day_of_week
			  count++;
			  List<WebElement> ct_startslot=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-start']"));
			  List<WebElement> ct_endslot=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-end']"));
			  
			  //matching the timings if they are 
			  if(ct_startslot.size()>0)
			  {
				  for(int i=0;i<=ct_startslot.size()-1;i++)
				  {   Thread.sleep(2000);
			    	  System.out.println("clinic start slot----->"+ct_startslot.get(i).getAttribute("value")+ "        clinic end slot----->"+ct_endslot.get(i).getAttribute("value"));
					 
					  SimpleDateFormat sdf_1=new SimpleDateFormat("HH:mm");
					  
					  if((sdf_1.parse(ct_startslot.get(0).getAttribute("value")).after(sdf_2.parse(new_end_time))))
					  {
						  System.out.println("adding new time slot in the beginning");
						  value_c="false";
						  break;
					  }
					  else  if((sdf_1.parse(ct_endslot.get(ct_startslot.size()-1).getAttribute("value")).before(sdf_2.parse(new_start_time))))
					  {
						  System.out.println("adding new time slot in the end");
						  value_c="false";
						  break;
					  }
					  
					  else	  if(i<ct_startslot.size()-1 && (sdf_1.parse(ct_startslot.get(i+1).getAttribute("value")).before(sdf_2.parse(new_end_time))) && (sdf_1.parse(ct_endslot.get(i).getAttribute("value")).after(sdf_2.parse(new_start_time))))
							  {
						  System.out.println("adding new time slot in the middle");
						  value_c="false";
						  break;
						 	  }
					  
					  else    if ((sdf_1.parse(ct_startslot.get(i).getAttribute("value")).equals(sdf_2.parse(new_end_time))) || (sdf_1.parse(ct_endslot.get(i).getAttribute("value")).equals(sdf_2.parse(new_end_time))) 
							  || ((sdf_1.parse(ct_startslot.get(i).getAttribute("value")).equals(sdf_2.parse(new_start_time))) || (sdf_1.parse(ct_endslot.get(i).getAttribute("value")).equals(sdf_2.parse(new_start_time))))){
						  System.out.println("new time is incorrect");
						  value_c="true";
						  break;
					          }
					  else if ((sdf_1.parse(ct_startslot.get(i).getAttribute("value")).before(sdf_2.parse(new_start_time))) && (sdf_1.parse(ct_endslot.get(i).getAttribute("value")).after(sdf_2.parse(new_end_time))))  
					  {
						  System.out.println("new time is incorrect");
						  value_c="true";
						 break;
						 }
	               }
			  }
			  else 
			  {
				  value_c="false";
				  break;
			  }
	      }
		  if(count>0)
		   	 {
		   		 break;
		   	 }
	  }
	  //================================================================================================================================================//
	  int count1=0;
	  ArrayList<String> al = new ArrayList<String>();
	  driver.findElement(By.xpath(".//*[@id='profile-flip']/span[2]")).click();
   	  List<WebElement> other_clinics=driver.findElements(By.xpath(".//*[@id='profile-panel']//h5"));
   	 
   	  if(other_clinics.size()>0)
   	  {
   	  for(int k=0;k<=other_clinics.size()-1;k++)
   	  {
   	 al.add(other_clinics.get(k).getText());
      }
   	 }
   	  
   	 driver.findElement(By.xpath(".//*[@id='profile-flip']/span[2]")).click();
   	 
   	 //================================================================================================================================================//
	  //for other clinics
	  
	  for(int j=0;j<=al.size()-1;j++)
	  {
		          selectTheOtherClinic(al.get(j)) ;
		          driver.findElement(By.xpath(".//*[@data-clinic-slot='"+day_of_week+"']/div")).click();			  
				  driver.findElement(By.xpath(".//*[@id='cd-"+day_num+"']/div")).click();  // select the day_of_week
				  List<WebElement> ct_startslot=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-start']"));
				  List<WebElement> ct_endslot=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-end']"));
				  
				  if(ct_startslot.size()>0)
				  {
					  for(int i=0;i<=ct_startslot.size()-1;i++)
					  {   Thread.sleep(2000);
				    	  System.out.println("clinic start slot----->"+ct_startslot.get(i).getAttribute("value")+ "        clinic end slot----->"+ct_endslot.get(i).getAttribute("value"));
						 
						  SimpleDateFormat sdf_1=new SimpleDateFormat("HH:mm");
						  
						  if((sdf_1.parse(ct_startslot.get(0).getAttribute("value")).after(sdf_2.parse(new_end_time))))
						  {
							  System.out.println("adding new time slot in the beginning");
							  value_c1="false";
							  break;
						  }
						  else  if((sdf_1.parse(ct_endslot.get(ct_startslot.size()-1).getAttribute("value")).before(sdf_2.parse(new_start_time))))
						  {
							  System.out.println("adding new time slot in the end");
							  value_c1="false";
							  break;
						  }
						  
						  else	  if(i<ct_startslot.size()-1 && (sdf_1.parse(ct_startslot.get(i+1).getAttribute("value")).before(sdf_2.parse(new_end_time))) && (sdf_1.parse(ct_endslot.get(i).getAttribute("value")).after(sdf_2.parse(new_start_time))))
								  {
							  System.out.println("adding new time slot in the middle");
							  value_c1="false";
							  break;
							 	  }
						  
						  else    if ((sdf_1.parse(ct_startslot.get(i).getAttribute("value")).equals(sdf_2.parse(new_end_time))) || (sdf_1.parse(ct_endslot.get(i).getAttribute("value")).equals(sdf_2.parse(new_end_time))) 
								  || ((sdf_1.parse(ct_startslot.get(i).getAttribute("value")).equals(sdf_2.parse(new_start_time))) || (sdf_1.parse(ct_endslot.get(i).getAttribute("value")).equals(sdf_2.parse(new_start_time))))){
							  System.out.println("New time is incorrect as it is equals to start and end time");
							  value_c1="true";
							  break;
						          }
						  else if ((sdf_1.parse(ct_startslot.get(i).getAttribute("value")).before(sdf_2.parse(new_start_time))) && (sdf_1.parse(ct_endslot.get(i).getAttribute("value")).after(sdf_2.parse(new_end_time))))  
						  {
							  System.out.println("New time is incorrect as it overlaps");
							  value_c1="true";
							  break;
						  }
		               }
				  }
				  
				  
				  else 
				  {
					  value_c1="false";
					  break;
				  }	 
	 
			  
	   	 //check starts
	   	 if( value_c1=="true")
	   	 {
	   		 break;
	   	 }
	  }
	  
	  //================================================================================================================================================//
   	  // for loop ends here
	  
	          driver.findElement(By.xpath(".//*[@id='cd-12']/div")).click();
	          driver.findElement(By.xpath(".//*[@data-hospi-tab='"+day_of_week+"']/div")).click();
	          int n=20+day_num;
			  driver.findElement(By.xpath(".//*[@id='cd-"+n+"']/div")).click();
			  List<WebElement> hos_startslot=driver.findElements(By.xpath(".//*[@id='tab-hosp-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-start-hos']"));
			  List<WebElement> hos_endslot=driver.findElements(By.xpath(".//*[@id='tab-hosp-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-end-hos']"));
			  if(hos_startslot.size()==0)
			  {
				  value_h="false";
			  }
			  for(int i=0;hos_startslot.size()>0 && i<=hos_startslot.size()-1;i++)
			  {
				  System.out.println("hospital start slot----->"+hos_startslot.get(i).getAttribute("value")+ "      hospital end slot----->"+hos_endslot.get(i).getAttribute("value"));
				  SimpleDateFormat sdf_1=new SimpleDateFormat("HH:mm");
				  SimpleDateFormat sdf_3=new SimpleDateFormat("HH:mm");
				  String start_time=hos_startslot.get(i).getAttribute("value");
				  String end_time=hos_endslot.get(i).getAttribute("value");
				  
				 if((!sdf_1.parse(start_time).equals(sdf_2.parse(new_start_time)))&& (sdf_3.parse(end_time).before(sdf_2.parse(new_start_time))))
						  {
					  value_h="false";
					      }
				  
				  else
				  {
					  System.out.println("New time is incorrect under hospitals ");
					  value_h="true";
					  break;
				  }
			  } 
			  
		//================================================================================================================================================//	  
	    // selecting clinic type
			  
			        driver.findElement(By.xpath(".//*[@id='cd-11']/div")).click();
					  driver.findElement(By.xpath(".//*[@id='profile-flip']/span[2]")).click();
				   	  List<WebElement> other_clinics2=driver.findElements(By.xpath(".//*[@id='profile-panel']//h5"));
				   	 
				   	  if(other_clinics.size()>0)
				   	  {
				   	  for(int k=0;k<=other_clinics2.size()-1;k++)
				   	  {
				   		  if(other_clinics2.get(k).getText().equals(clinic_type)) 
				   	 {
				   	 other_clinics2.get(k).click(); 
				   	 driver.findElement(By.xpath(".//*[@id='cd-11']/div")).click();
					 count1++;
				   	 }
				     }
				   	 
			  } // if ends here
		
	   //================================================================================================================================================//
	   // starting the addition of new time slot for clinics
	  
			  String actual_text="";
					 if (count1==0)
						 {
							 driver.findElement(By.xpath(".//*[@id='profile-flip']/span[2]")).click();
						 }
					 if ( value_c =="false" && value_h =="false" && value_c1 =="false")
					 {
						 
						 driver.findElement(By.xpath(".//*[@id='cd-11']/div")).click();
						 driver.findElement(By.xpath(".//*[@id='cd-"+day_num+"']/div")).click();
						 driver.findElement(By.xpath(".//*[@id='clinic_add_slot']")).click();
						  List<WebElement> slots=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//span[@class='sp-doc-clinic-workday-switch-switch']"));
						  slots.get(slots.size()-1).click();
						  List<WebElement> ct_startslot=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-start']"));
						  List<WebElement> ct_endslot=driver.findElements(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-strt']//input[@class='slot-end']"));;
						  ct_startslot.get(ct_startslot.size()-1).sendKeys(new_start_time);
						  ct_endslot.get(ct_endslot.size()-1).sendKeys(new_end_time);
						  driver.findElement(By.xpath(".//*[@id='tab-clinic-schedule']//div[@class='sp-doc-clinic-schd-save-btn clinic_slots_save']")).click();
						  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[6]/div")));
						  actual_text=driver.findElement(By.xpath("html/body/div[6]/div")).getText();
						  System.out.println(actual_text);
						  System.out.println("reached end ");
							 driver.findElement(By.xpath(".//*[@id='appointments']/span[2]")).click();
							 Thread.sleep(2000);
							 driver.findElement(By.xpath("//i[@class='fa fa-ellipsis-v footer-relipse']")).click();
							 Thread.sleep(2000);
							 driver.findElement(By.xpath(".//*[@id='dashboard_dashboardIcon']")).click();
							 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]")));
					 }
						  
					 if ( value_c =="true" || value_h =="true"  || value_c1 =="true" || (!actual_text.equalsIgnoreCase("Schedule Updated Successfully")) || (incorrect>0))
					 {
						     System.out.println("reached end but time slot not saved successfully  ");
							 driver.findElement(By.xpath(".//*[@id='appointments']/span[2]")).click();
							 Thread.sleep(2000);
							 driver.findElement(By.xpath("//i[@class='fa fa-ellipsis-v footer-relipse']")).click();
							 Thread.sleep(2000);
							 driver.findElement(By.xpath(".//*[@id='dashboard_dashboardIcon']")).click();
							 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]"))); 
					 }
			
					 
  }
  
  @DataProvider()
  public Object[][] DP1() throws Exception{
Object[][] retObjArr=TestUtils.getTableArray("TestData\\Doctors_TestData.xls", "Doctor", "ZOY899");
      return(retObjArr);
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
  
  @BeforeClass
  public void beforeTest() throws Exception {
	 
	  driver=LoadProp.LoadBrowserProperties();
	  wait=new WebDriverWait(driver,2000);
	  driver.get(LoadProp.base_url+"login");
	  driver.manage().window().maximize();
	  driver.findElement(By.id("emailAddress")).sendKeys(LoadProp.DoctorsLogin_username);
	  driver.findElement(By.id("password")).sendKeys(LoadProp.DoctorsLogin_password);
	  driver.findElement(By.xpath(".//*[@id='zoyloCustLogin-form']//button[@class='signup-btn']")).click();
	  Thread.sleep(4000);
	  }
  
  @AfterClass
  public void afterTest() throws Exception {
	 
	 System.out.println("Closing the Chrome Browser");
	 //driver.close();
	}
}

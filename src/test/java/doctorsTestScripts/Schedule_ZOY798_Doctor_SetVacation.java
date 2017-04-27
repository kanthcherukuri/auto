package doctorsTestScripts;

/*
 * @author-Manraj Bharaj
 * 
 * Description- Test case for "Schedule_Consultation" edit vacation days. 
 * Follow ZOY798 JIRA for understanding the manual test case
 */

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testBase.LoadProp;
import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Schedule_ZOY798_Doctor_SetVacation{
	
	WebDriver driver;
	public  WebDriverWait wait; 
	String actual_text1;
	SoftAssert sa=new SoftAssert();
	
	  //===============================================================================================================================================================//	
	
  @Test(groups = { "Regression","High" })
  public void testSetVacation() throws InterruptedException, ParseException, AWTException {
	  
	
	  Date d=new Date();
	  SimpleDateFormat sdf=new SimpleDateFormat("d");
	  String date_current=sdf.format(d);
	  
	  driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
	  wait=new WebDriverWait(driver, 8000);
	
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]")));
	  driver.findElement(By.xpath(".//*[@id='schedule_scheduleIcon']")).click();
	  
	  
	  System.out.println("EDITING THE CONSULTATION DURATION OF DOCTOR PROVIDER");
	  
	  driver.findElement(By.xpath(".//*[@id='cd-10']/div")).click();
	  driver.findElement(By.xpath(".//*[@id='setVacation']")).click();
	  Thread.sleep(4000);
	  if(! driver.findElement(By.xpath(".//*[@id='vac_status0']")).isSelected())
	  {
	  driver.findElement(By.xpath(".//*[@id='vac_status0']")).click();
	  }
	  
	  System.out.println("SELECT THE DATES FOR HOLIDAY");
	  driver.findElement(By.xpath(".//*[@id='holiday-start-date_id']")).click();
	  A:for(int i=1;i<=7;i++)
	  {
		  for(int j=1;j<=7;j++)
		  {
			  String date=driver.findElement(By.xpath("html/body/div[9]/div[1]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
			  if(date.equals(date_current))
			  {
				  driver.findElement(By.xpath("html/body/div[9]/div[1]/table/tbody/tr["+i+"]/td["+j+"]")).click();
				  break A;
			  }
		  }  
	  }
	  
	  driver.findElement(By.xpath(".//*[@id='holiday-end-date_id']")).click();
	  B:for(int i=1;i<=7;i++)
	  {
		  for(int j=1;j<=7;j++)
		  {
			  String date=driver.findElement(By.xpath("html/body/div[9]/div[1]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
			  if(date.equals(date_current))
			  {
				  driver.findElement(By.xpath("html/body/div[9]/div[1]/table/tbody/tr["+i+"]/td["+j+"]")).click();
				  break B;
			  }
		  }  
	  }
	  
	  driver.findElement(By.xpath(".//*[@id='vacation_save']")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[6]/div")));
	  actual_text1=driver.findElement(By.xpath("html/body/div[6]/div")).getText();
	  System.out.println(actual_text1);
	  if(actual_text1.contains("successfully"))
	  {
		  System.out.println("THE CONSULTATION DURATION EDITED SUCCESSFULLY AND TEST CASE PASSED");
	  }
	  
	  else if(!actual_text1.contains("successfully"))
	  {
		  System.out.println("THE CONSULTATION DURATION EDITED UNSUCCESSFULLY AND TEST CASE FAILED");
		  Assert.fail(actual_text1);
		  
	  }	 
	  else if (!actual_text1.contains("cannot update vacation dates as you have existing appointments. Please cancel them to update doctor vacation."))
	  {
		  System.out.println("THE CONSULTATION DURATION EDITED UNSUCCESSFULLY AND TEST CASE FAILED");
		  Assert.fail(actual_text1);
		  
	  }	
	  
	  
  }
  
  //===============================================================================================================================================================//
  
  @BeforeTest(groups = { "Regression","High" })
  public void beforeTest() throws Exception {
	  
	  driver=LoadProp.LoadBrowserProperties();
	  driver.get(LoadProp.doctors_Url);
	  driver.manage().window().maximize();
	  Thread.sleep(8000);
	  driver.findElement(By.id("emailAddress")).sendKeys(LoadProp.DoctorsLogin_usernameone);
	  driver.findElement(By.id("password")).sendKeys(LoadProp.DoctorsLogin_passwordone);
	  driver.findElement(By.xpath(".//*[@id='zoyloCustLogin-form']//button[@class='signup-btn']")).click();
	  Thread.sleep(4000);
  }
  
  //===============================================================================================================================================================//
  
  @AfterTest(groups = { "Regression","High" })
  public void afterTest() {
	  
	  //driver.close();
  }

}

//===============================================================================================================================================================//

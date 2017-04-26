package doctorsTestScripts;

/*
 * @author-Manraj Bharaj
 * 
 * Description- This test case checks if the doctor data can be edited like services,amenities, address 
 * Follow ZOY824_ZOY827_ZOY829 JIRA's for understanding the manual test case
 */

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testBase.LoadProp;
import org.testng.annotations.BeforeTest;
import java.text.ParseException;
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

public class Schedule_ZOY824_ZOY827_ZOY829_Doctor_Edit{
	
	WebDriver driver;
	public  WebDriverWait wait; 
	String actual_text1;
	String actual_text2;
	String actual_text3;
	String data="LOCALITY";
	SoftAssert sa=new SoftAssert();
	
	  //===============================================================================================================================================================//	
	
  @Test(groups = { "Regression","High" })
  public void testEditAddressAmenitiesServices() throws InterruptedException, ParseException {
	  
	
	  driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
	  wait=new WebDriverWait(driver, 8000);
	
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]")));
	  driver.findElement(By.xpath(".//*[@id='schedule_scheduleIcon']")).click();
	  driver.findElement(By.xpath(".//*[@data-tab='tab-clinic']/div")).click();
	 
	  
	  System.out.println("EDITING THE ADDRESS OF DOCTOR PROVIDER");
	  
	
	  driver.findElement(By.xpath("//li[@data-tab='tab-clinic-address']")).click();
	  driver.findElement(By.id("man_clinic_addr_edit")).click();
	  driver.findElement(By.id("clinic_addr1")).sendKeys(data);
	  driver.findElement(By.id("clinic_addr_save")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[6]/div")));
	  actual_text1=driver.findElement(By.xpath("html/body/div[6]/div")).getText();
	  System.out.println(actual_text2);
	  if(actual_text1.contains("Successfully"))
	  {
		  System.out.println("ADDRESS EDITED SUCCESSFULLY AND TEST CASE PASSED");
	  }
	  
	  if(!actual_text1.contains("Successfully"))
	  {
		  System.out.println("ADDRESS EDITED UNSUCCESSFULLY AND TEST CASE FAILED");
		  AssertJUnit.fail(actual_text1);
		  
	  }	 
	  
	   
	  
	  
	  System.out.println("EDITING THE AMENITIES OF DOCTOR PROVIDER");
	  
		
	  driver.findElement(By.xpath("//li[@data-tab='tab-clinic-aminities']")).click();
	  
	  if(!driver.findElement(By.xpath(".//*[@id='ambulance']")).isSelected())
	  {
		  driver.findElement(By.id("ambulance")).click();
	  }
	  if(!driver.findElement(By.xpath(".//*[@id='emergency']")).isSelected())
	  {
		  driver.findElement(By.xpath(".//*[@id='emergency']")).click();
	  }
	  if(!driver.findElement(By.xpath(".//*[@id='carparking']")).isSelected())
	  {
		  driver.findElement(By.xpath(".//*[@id='carparking']")).click();
	  }
	  if(!driver.findElement(By.xpath(".//*[@id='bikeparking']")).isSelected())
	  {
		  driver.findElement(By.xpath(".//*[@id='bikeparking']")).click();
	  }
	 
	  
	  driver.findElement(By.xpath(".//*[@id='clinic_aminities_save']")).click();
	  
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[6]/div")));
	  actual_text2=driver.findElement(By.xpath("html/body/div[6]/div")).getText();
	  System.out.println(actual_text2);
	  if(actual_text2.contains("Successfully"))
	  {
		  System.out.println("AMENITIES EDITED SUCCESSFULLY AND TEST CASE PASSED");
	  }
	  
	  if(!actual_text2.contains("Successfully"))
	  {
		  System.out.println("AMENITIES EDITED UNSUCCESSFULLY AND TEST CASE FAILED");
		  AssertJUnit.fail(actual_text2);
		  
	  }	  
	  
	  
	  System.out.println("EDITING THE SERVICES OF DOCTOR PROVIDER");
	  
	  driver.findElement(By.xpath("//li[@data-tab='tab-clinic-services']")).click();
	  driver.findElement(By.xpath(".//*[@id='tab-clinic-services']//textarea")).click();
	  driver.findElement(By.xpath(".//*[@id='tab-clinic-services']//textarea")).sendKeys(data);
	  driver.findElement(By.xpath(".//*[@id='clinic_service_save']")).click();
	  
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[6]/div")));
	  actual_text3=driver.findElement(By.xpath("html/body/div[6]/div")).getText();
	  System.out.println(actual_text3);
	  if(actual_text3.contains("Successfully"))
	  {
		  System.out.println("SERVICES EDITED SUCCESSFULLY AND TEST CASE PASSED");
	  }
	  
	  if(!actual_text3.contains("Successfully"))
	  {
		  System.out.println("SERVICES EDITED UNSUCCESSFULLY AND TEST CASE FAILED");
		  AssertJUnit.fail(actual_text3);
		  
	  }	
	  
	  driver.findElement(By.xpath(".//*[@id='appointments']/span[2]")).click();
	  driver.findElement(By.xpath("//i[@class='fa fa-ellipsis-v footer-relipse']")).click();
	  driver.findElement(By.xpath(".//*[@id='dashboard_dashboardIcon']")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]")));
	  
	  }
  
  //===============================================================================================================================================================//
  
  @BeforeTest(groups = { "Regression","High" })
  public void beforeTest() throws Exception {
	  
	  driver=LoadProp.LoadBrowserProperties();
	  driver.get(LoadProp.base_url+"login");
	  driver.manage().window().maximize();
	  Thread.sleep(4000);
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

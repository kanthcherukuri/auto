package doctorsTestScripts;

/*author - manraj bharaj

 */

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testBase.LoadProp;
import testBase.TestUtils;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Schedule_ZOY804_Doctor_AddWorkTimingsUnderClinicsTab {
	WebDriver driver;
	public  WebDriverWait wait; 
	String actual_text;

	
	@Test(enabled=true,dataProvider="DP1",groups = { "Regression","High" })
      public void testAddWorkTimingsUnderClinicsTab(String runmode,String new_start_time,String new_end_time) throws InterruptedException {
		
	  wait=new WebDriverWait(driver, 8000);
	  SoftAssert sa=new SoftAssert();
	  boolean x=true;
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]")));
	  driver.findElement(By.xpath(".//*[@id='schedule_scheduleIcon']")).click();
	  Thread.sleep(4000);
	  driver.findElement(By.xpath(".//*[@data-tab='tab-clinic']/div")).click();
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
	  driver.findElement(By.xpath(".//*[@id='appointments']/span[2]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//i[@class='fa fa-ellipsis-v footer-relipse']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='dashboard_dashboardIcon']")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]"))); 
	  if(!actual_text.contains("Successfully"))
	  {
		  System.out.println("Test case failed;adding time slot is unsuccessful");
		  AssertJUnit.fail(actual_text); 
	  }
	  
	  
  }
	
  @DataProvider()
  public Object[][] DP1() throws Exception{
	  
      Object[][] retObjArr=TestUtils.getTableArray("TestData\\Doctors_TestData.xls", "Doctor", "ZOY804");
      return(retObjArr);
  }
  
  @BeforeClass(groups = { "Regression","High" })
  public void beforeClass() throws Exception {
	  
	  driver=LoadProp.LoadBrowserProperties();
	  driver.get(LoadProp.doctors_Url);
	  driver.manage().window().maximize();
	  driver.findElement(By.id("emailAddress")).sendKeys(LoadProp.DoctorsLogin_usernameone);
	  driver.findElement(By.id("password")).sendKeys(LoadProp.DoctorsLogin_passwordone);
	  driver.findElement(By.xpath(".//*[@id='zoyloCustLogin-form']//button[@class='signup-btn']")).click();
	  
	  }

  @AfterClass(groups = { "Regression","High" })
  public void afterClass() {
	  
	  driver.close();
  }

}

package doctorsTestScripts;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.ArrayList;
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

public class Schedule_ZOY848_DoctorHospital_DifferentStartEndTimes {

	
	WebDriver driver;
	public  WebDriverWait wait; 
	String actual_text;
	
  @Test(enabled=true,groups = { "Regression","High" },dataProvider="DP1")
  public void test_DoctorHospital_DifferentStartEndTimes(String runmode,String day,String time) throws InterruptedException {
	  
	  String t=time.replace("*", "");
	  
	  driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
	  wait=new WebDriverWait(driver, 8000);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]")));
	  driver.navigate().refresh();
	  driver.findElement(By.xpath(".//*[@id='schedule_scheduleIcon']")).click();
	  driver.findElement(By.xpath(".//*[@id='cd-12']/div")).click();
	  driver.findElement(By.xpath(".//li[@data-hospi-tab='"+day+"']/div")).click();
	  driver.findElement(By.xpath(".//*[@class='fa fa-plus-circle slot_hospital_add']")).click();
	  
	  List<WebElement> l=driver.findElements(By.xpath(".//*[@class='sp-doc-clinic-workday-switch-switch']"));
	  if(l.size()==1)
	  {
		  driver.findElement(By.xpath(".//*[@class='sp-doc-clinic-workday-switch-switch']")).click();
		  driver.findElement(By.xpath(".//*[@class='slot-start-hos']")).clear();
		  driver.findElement(By.xpath(".//*[@class='slot-start-hos']")).sendKeys(t);
		  driver.findElement(By.xpath(".//*[@class='slot-end-hos']")).clear();
		  driver.findElement(By.xpath(".//*[@class='slot-end-hos']")).sendKeys(t);
	  }
	  
	  
	  if(l.size() > 1)
	  {
		  List<WebElement> l1=driver.findElements(By.xpath(".//*[@class='slot-start-hos']"));
		  List<WebElement> l2=driver.findElements(By.xpath(".//*[@class='slot-end-hos']"));
		  String t1=l1.get(l1.size()-2).getAttribute("value");
		  l2.get(l2.size()-2).clear();
		  l2.get(l2.size()-2).sendKeys(t1);
		  
	  }
	  
	  
	 
	  
	  driver.findElement(By.cssSelector(".sp-doc-hosp-schd-save")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.zy-status-wrapper")));
	  actual_text=driver.findElement(By.cssSelector("div.zy-status-wrapper")).getText();
	  System.out.println(actual_text);
	 
	  goToDashBoard();
	  
	  if(actual_text.contains("Error"))
	  {
           System.out.println("TEST CASE PASSED,AS ADDING TIME SLOT WITH SAME TIMES THROWS AN ERROR");
		  
	  }  
	  else
	  {
           System.out.println("TEST CASE FAILED,AS ADDING TIME SLOT WITH SAME TIMES DOES NOT THROWS AN ERROR");
		  
		  AssertJUnit.fail(actual_text);
		  
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

//===============================================================================================================================================================//


public void goToDashBoard() throws InterruptedException {
	  
	 driver.findElement(By.xpath(".//*[@id='appointments']/span[2]")).click();
	  Thread.sleep(2000);
	  driver.navigate().refresh();
	  driver.findElement(By.xpath("//i[@class='fa fa-ellipsis-v footer-relipse']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='dashboard_dashboardIcon']")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='sp-dashboard-content']/div[1]/div[2]"))); 
}
 
//===============================================================================================================================================================//

@DataProvider()
public Object[][] DP1() throws Exception{
	  
    Object[][] retObjArr=TestUtils.getTableArray("TestData\\Doctors_TestData.xls", "Doctor", "ZOY848");
    return(retObjArr);
}  
}



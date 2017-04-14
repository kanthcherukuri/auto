package doctorsTestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.LoadProp;

public class Schedule_ZOY844_DoctorHospital_DeleteWorkTimings {
	
	WebDriver driver;
	public  WebDriverWait wait; 
	
  @Test(enabled=true,groups = { "Regression","High" })
  public void testDoctorHospitalDeleteWorkTimings() {
	  
	  
  }

@BeforeTest(groups = { "Regression","High" })
public void beforeTest() throws Exception {
	  
	  driver=LoadProp.LoadBrowserProperties();
	  driver.get(LoadProp.base_url+"/login");
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
	  
	// driver.close();
}

}

//===============================================================================================================================================================//

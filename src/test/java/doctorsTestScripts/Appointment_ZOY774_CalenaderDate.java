package doctorsTestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.DoctorsPage;
import testBase.LoadProp;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY774_CalenaderDate extends LoadPropMac {
	
	public DoctorsPage DoctorsPageOfZoylo;
	public TestUtils exceldata;



@BeforeClass
public void beforeClass() throws Exception {
	  
LoadBrowserProperties();
driver.manage().window().maximize();
driver.get(doctors_Url);	 


  }
  
	     
@Test(priority=1)
public  void SignIntoDoctorLogin() throws Exception {
		
DoctorsPageOfZoylo= new DoctorsPage(driver);			
DoctorsPageOfZoylo.SignIn(DoctorsLogin_usernameone,DoctorsLogin_passwordone);
Thread.sleep(10000);
				
		  }

@Test(priority=2)
public void CheckingDashBoradCalendarDatefunctionality() throws Exception{
	WebDriverWait wait=new WebDriverWait(driver,8000);
	
	LoadProp.isElementPresnt(driver,"//*[@id='appointment_appointmentCalendar']",20).click();
	//driver.findElement(By.id("appointment_appointmentCalendar")).click();	
	Thread.sleep(5000);
	 
	driver.findElement(By.xpath("//*[@id='cd-1']")).click();
	 
	driver.findElement(By.xpath("//*[@id='patient-apmt-tabs']/li[1]/div/center/span[1]")).click();
	 
	driver.findElement(By.xpath("//*[@id='patient-apmt-tabs']/li[2]/div/center/span[1]")).click();

	driver.findElement(By.xpath("//*[@id='patient-apmt-tabs']/li[3]/div/center/span[1]")).click();
	 
	 int slotsize = driver.findElements(By.xpath("//*[@id='tab-3']/ul/li")).size();

	 if(slotsize>0)
		 {
	driver.findElement(By.xpath("//*[@id='tab-3']/ul/li[1]/div[2]")).click();
	Thread.sleep(1000);	 
	driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("Amarnath");
	Thread.sleep(1000);
	driver.findElement(By.id("lastName")).sendKeys("R");
	Thread.sleep(1000);
	driver.findElement(By.id("mobileNumber")).sendKeys("+919912345678");
	Thread.sleep(1000);
	driver.findElement(By.id("email")).sendKeys("jene@gmail.com");
	Thread.sleep(1000);
	driver.findElement(By.id("problem")).sendKeys("diabetic");
	Thread.sleep(2000);
	driver.findElement(By.id("saveAppiontment")).click();
	
	
	
	//driver.findElement(By.xpath("//*[@id='plusmodaladd']/div/div/div/button")).click();
	
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tab-3']/ul/li[1][@class='bg-red']")));
   

	
	//LoadProp.isElementPresnt(driver,"//*[@id='tab-3']/ul/li[1][@class='bg-red']", 20);
	
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//span//i[@class='fa fa-ellipsis-v footer-relipse']")).click();

	Thread.sleep(2000);

	driver.findElement(By.id("dashBoard")).click();
	
	//Thread.sleep(20000);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='monthly-day monthly-day-event monthly-today']")));
	
	//LoadProp.isElementPresnt(driver, "//a[@class='monthly-day monthly-day-event monthly-today']", 20).click();
	
	
	
	
	String date=driver.findElement(By.xpath("//a[@class='monthly-day monthly-day-event monthly-today']")).getText();

	System.out.println(date);

	driver.findElement(By.xpath("//*[@id='mycalendar']/div[3]/a["+date+"+1]/div[1]")).click();
	Thread.sleep(8000);

	String name=driver.findElement(By.xpath("//*[@id='scrolls']/div/div[1]/div[2]/span")).getText();

	if(name.equalsIgnoreCase("Amarnath R"))
	{	
		
	driver.findElement(By.xpath("//*[@id='scrolls']/div/div[1]/div[2]/span")).click();	
	}

	else
	{	
		
	Assert.fail("Appointment For the selected User Not Available");

	}
			 
	}//if loop for slotsize
	
}	

}

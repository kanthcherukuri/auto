package doctorsTestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import testBase.DoctorsPage;
import testBase.LoadProp;
import testBase.TestUtils;

public class Appointment_ZOY814_ScheduleCheckIn extends LoadProp  {
	
	public DoctorsPage DoctorsPageOfZoylo;
	 
	 public TestUtils exceldata;
	
	
 
  @BeforeClass
  public void beforeClass() throws Exception {
	  
	  
	  LoadBrowserProperties();
		 driver.manage().window().maximize();
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		  }
	  
	     
  @Test
  public  void SignIntoDoctorLogin() throws Exception {
		
		 DoctorsPageOfZoylo= new DoctorsPage(driver);			
		DoctorsPageOfZoylo.SignIn(DoctorsLogin_username, DoctorsLogin_password);
				
		  }
  
  
  @Test(priority=2)
  
  public void checkin() throws Exception{
  
  driver.findElement(By.id("patients")).click();
	
	//driver.findElement(By.xpath("//*[@id='patients_patientsIcon']")).click();
	
	Thread.sleep(1000);
	
	 driver.findElement(By.xpath("html/body/div[9]/div[3]/div[2]/div/ul/li[2]")).click();
	 
	 System.out.println("Clicked on all tab");
	 Thread.sleep(10000);
	 
	 int patientsize= driver.findElements(By.xpath(".//*[@id='all']/div")).size();
	 
	 System.out.println(patientsize);
	 
	 
	 for(int l=1;l<=patientsize ;l++){
			
			
			String Schedule=	driver.findElement(By.xpath("//*[@id='all']/div["+l+"]/div[2]/p[1]")).getText();
			if(Schedule.equalsIgnoreCase("Scheduled")||Schedule.equalsIgnoreCase("Rescheduled"))
			{
				
				System.out.println("Scheduled/Rescheduled Found");
				Reporter.log("Scheduled/Rescheduled Found");
				
				WebElement sc = driver.findElement(By.xpath("//*[@id='all']/div["+l+"]/div[2]/p[1]"));
				 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sc);
				 driver.findElement(By.xpath("//*[@id='all']/div["+l+"]/div[2]/p[1]")).click();	
				
				
				Thread.sleep(10000);
				driver.findElement(By.id("checkIn")).click();
				Thread.sleep(1000);
				Reporter.log("Clicked on CheckIn button");
				Thread.sleep(1000);
				driver.findElement(By.id("startConsultation")).click();
				Thread.sleep(1000);
				Reporter.log("Clicked on Start Consultation Button");
				Thread.sleep(1000);
				driver.findElement(By.id("prognosis")).sendKeys("Normal");
				Thread.sleep(1000);
				driver.findElement(By.id("diagnosis")).sendKeys("Done");
				Thread.sleep(1000);
				driver.findElement(By.id("saveProblems")).click();
				Thread.sleep(1000);
				Reporter.log("Problems Saved");
				driver.findElement(By.id("heightFeet")).sendKeys("5");
				Thread.sleep(1000);
				driver.findElement(By.id("heightInches")).sendKeys("9");
				Thread.sleep(1000);
				driver.findElement(By.id("weight")).sendKeys("83");
				Thread.sleep(1000);
				driver.findElement(By.id("saveVitals")).click();
				Thread.sleep(1000);
				Reporter.log("Vital Details Saved");
				driver.findElement(By.id("drugAndInstructions")).sendKeys("Crocin");
				Thread.sleep(1000);
				driver.findElement(By.id("strength")).sendKeys("2");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='tab-pres']/div[1]/div[2]/div[3]/div[2]/span/input")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("savePrescription")).click();
				Thread.sleep(1000);
				Reporter.log("Prescription Details Saved");
				driver.findElement(By.id("consultationNotes")).sendKeys("Normal");
				Thread.sleep(1000);
				driver.findElement(By.id("saveNotes")).click();
				Reporter.log("Consultation Notes Saved");
				
				System.out.println("Consultation Notes Saved");
				Thread.sleep(3000);
				driver.findElement(By.id("generateReceipt")).click();
				
				Thread.sleep(2000);
				System.out.println("generateReceipt");
				
				Reporter.log("Clicked on generateReceipt");
				
				driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[2]/div[2]/div[1]/button")).click();
				
				System.out.println("click on the download Receipt icon");
				
				Reporter.log("click on the download Receipt icon");
				
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='presDownload']")).click();
				
				Thread.sleep(10000);
				
				driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[2]/div[2]/div[2]/button")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='prescriptionPdfShare']")).click();
				Thread.sleep(5000);
				
			     driver.findElement(By.xpath("//*[@id='sp-patient-sharepopup']/div/div/div/div/div/span[1]")).click();
			     Thread.sleep(5000);
			     driver.findElement(By.id("checkOut")).click();
			     
			     System.out.print("Clicked on Checkout");
			     
			     System.out.println("Check-In Scheduled/Rescheduled Sucessfull");
			     
			     break;
								
				
				
			}
			else{
				System.out.println("No Schedule and Reschedule Appointments are Available");
				
			}
			
	 }
  
  
  

  
  
  
  
  
  

}
	 
}

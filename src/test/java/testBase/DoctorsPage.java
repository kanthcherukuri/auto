package testBase;



import java.io.IOException;

import objectRepository.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DoctorsPage  {
	//FirefoxDriver browser = new FirefoxDriver();
	public    WebDriver driver;
	
	
	public DoctorsPage(WebDriver driver) throws Exception {
		this.driver=driver;
	
		Elements_Doctors.Doc_PageProperties();
		
	}
   
	
	
	 /*   Below is the Sample Method
	  *  @Autur : Ganesh Mandala
	  *   Entering the test details in Doctor enrollment Page and submitting the page
	  */
	
		public void doctorsEnrollment(String Area, String FirstName,String LastName,String Gender,String Qualification,String Email, String Address,String Fee,String Notes) throws InterruptedException{
			
			int Phno = (int )(Math.random() *1000000000);
			
			 System.out.println("element firstName"+Elements_Doctors.enrollment_firstname);
			
			driver.findElement(By.xpath("//span/ul")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[contains(@id,'"+Area+"')]")).click();
			driver.findElement(By.id(Elements_Doctors.enrollment_firstname)).sendKeys(FirstName);
			driver.findElement(By.id(Elements_Doctors.enrollment_lastname)).sendKeys(LastName);
			driver.findElement(By.xpath("//input[@value='"+Gender+"']")).click();
			driver.findElement(By.xpath("//div[2]/span/span/span/ul")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[contains(@id,'"+Qualification+"')]")).click();
			driver.findElement(By.id(Elements_Doctors.enrollment_regname)).sendKeys(String.valueOf("9"+Phno));
			driver.findElement(By.id(Elements_Doctors.enrollment_mobile)).sendKeys(String.valueOf("9"+Phno));
			driver.findElement(By.id(Elements_Doctors.enrollment_email)).sendKeys(""+Email+""+Phno+"@india.com");
			driver.findElement(By.id(Elements_Doctors.enrollment_clinicaddress)).sendKeys(Address);
			driver.findElement(By.id(Elements_Doctors.enrollment_consultationfee)).sendKeys(Fee);
			driver.findElement(By.id(Elements_Doctors.enrollment_notes)).sendKeys(Notes);
			driver.findElement(By.id(Elements_Doctors.enrollment_doc_fac)).click();
			driver.findElement(By.id(Elements_Doctors.enrollment_terms_cond)).click();
			driver.findElement(By.xpath(Elements_Doctors.enrollment_submit)).click();
			
			
		}
		
		
		// Doctors login Details 
		public  void SignIn(String username, String password) throws IOException{			
				driver.findElement(By.id(Elements_Doctors.username)).sendKeys(username);
				driver.findElement(By.id(Elements_Doctors.password)).sendKeys(password);	
				driver.findElement(By.xpath(Elements_Doctors.loginbutton)).click();				
			
			}
		
		
		
		
    
}
package testBase;


import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import objectRepository.PageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;


public class HomePage extends PageObjects {
	//FirefoxDriver browser = new FirefoxDriver();
	public final WebDriver driver;
	public HomePage(WebDriver driver) throws Exception {
		this.driver=driver;
		PageProperties();
	}
   //login-form
	public void searchZoylo(String City, String Locality,String Specialization) throws InterruptedException{
		
		
		
		System.out.println("home city"+home_city);
		
		
		driver.findElement(By.id(home_city)).sendKeys(City);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//html/body/div[15]/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id(home_area)).sendKeys(Locality);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//html/body/div[16]/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id(home_specialization)).sendKeys(Specialization);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='srch-op']/div[3]/div/ul/li")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("search-icon")).click();
		
		
	}
	
	 //login-form
		public void doctorsEnrollment(String Area, String FirstName,String LastName,String Gender,String Qualification,String Email, String Address,String Fee,String Notes) throws InterruptedException{
			
			int Phno = (int )(Math.random() *1000000000);
			
			driver.findElement(By.xpath("//span/ul")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[contains(@id,'"+Area+"')]")).click();
			driver.findElement(By.id("fname")).sendKeys(FirstName);
			driver.findElement(By.id("lname")).sendKeys(LastName);
			driver.findElement(By.xpath("//input[@value='"+Gender+"']")).click();
			driver.findElement(By.xpath("//div[2]/span/span/span/ul")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[contains(@id,'"+Qualification+"')]")).click();
			driver.findElement(By.id("zws_reg_no")).sendKeys(String.valueOf("9"+Phno));
			driver.findElement(By.id("zws_mobile")).sendKeys(String.valueOf("9"+Phno));
			driver.findElement(By.id("zws_email")).sendKeys(""+Email+""+Phno+"@india.com");
			driver.findElement(By.id("clinicAddress")).sendKeys(Address);
			driver.findElement(By.id("consultationFee")).sendKeys(Fee);
			driver.findElement(By.id("zws_notes")).sendKeys(Notes);
			driver.findElement(By.id("zws_doc_fac")).click();
			driver.findElement(By.id("zws_doc_termsCond")).click();
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			
			
		}
    
}
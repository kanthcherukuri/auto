package testBase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import objectRepository.Elements_Diagnostics;
import objectRepository.Elements_Doctors;

public class DiagnosticPage {
	
	public    WebDriver driver;
	public TestUtils Browser;
	
	public DiagnosticPage(WebDriver driver) throws Exception{
		this.driver=driver;
		Browser= new TestUtils(driver); 
		Elements_Diagnostics.Diag_PageProperties();
	}
	
	
	
	// Doctors login Details 
	public  void SignIn(String username, String password) throws IOException{	
		
			Browser.waitFortheID("emailAddress");	
			driver.findElement(By.id(Elements_Diagnostics.username)).sendKeys(username);
			driver.findElement(By.id(Elements_Diagnostics.password)).sendKeys(password);	
			driver.findElement(By.xpath(Elements_Diagnostics.loginbutton)).click();	
			}
		
	
	
	public void DiagnosticAppointmentForHomeVisit() throws Exception{
		
		driver.findElement(By.id(Elements_Diagnostics.clickonappointmentsmenu)).click();
		Thread.sleep(3000);
		Actions action=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath(Elements_Diagnostics.clickontoggle));
		action.moveToElement(ele);
		action.click().build().perform();
		Thread.sleep(1000);
		//System.out.println("Home Visit Toggle is Selected");
		driver.findElement(By.xpath(Elements_Diagnostics.tommorowmenu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.morninghomevisit)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.noonhomevisit)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.eveninghomevisit)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.eveningfirstcell)).click();
		//details
		driver.findElement(By.id(Elements_Diagnostics.detailsfirstname)).sendKeys("Jose");
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.detailslastname)).sendKeys("Jacob");
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.detailsmobile)).sendKeys("9491219191");
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.detailsemail)).sendKeys("jose@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.detailsaddress)).sendKeys("Bhaskar Residency FlotNo;401 Nizampet");
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.detailsproblem)).sendKeys("Diabetic");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.packagetab)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.packagecheckbox)).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//li[3]//a[@data-toggle='tab']")).click();
		//Thread.sleep(1000);
		//driver.findElement(By.xpath("//input[@class='test_select_checkbox']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.windowsavebutton)).click();
		WebDriverWait wait = (new WebDriverWait(driver, 2000));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Elements_Diagnostics.notification)));
		String top=driver.findElement(By.xpath(Elements_Diagnostics.notification)).getText();
		System.out.println(top);
		
	}
	
	
	
	
	public void ClickingOnEllipse() throws Exception{
		
		driver.findElement(By.xpath(Elements_Diagnostics.ellipse)).click();
		Thread.sleep(5000);
	   }
	
		
	public void diagnosticlogout() throws Exception{
		driver.findElement(By.id(Elements_Diagnostics.clickonmyaccountmenu)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(Elements_Diagnostics.clickonsignout)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Diagnostics.confirmsignout)).click();
	}
		
		
	public void diagnosticrescheduleappointment() throws Exception{
		driver.findElement(By.xpath(Elements_Diagnostics.clickonmore)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Elements_Diagnostics.clickonchange)).click();
		driver.findElement(By.xpath(Elements_Diagnostics.tommorowmenu)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Elements_Diagnostics.nextdaymenu)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Elements_Diagnostics.morninghomevisit)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Elements_Diagnostics.noonhomevisit)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Elements_Diagnostics.eveninghomevisit)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.eveningfirstcell)).click();
		//Thread.sleep(10000);
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[6]/div")));
		String notification=driver.findElement(By.cssSelector(Elements_Diagnostics.topnotification)).getText();
		System.out.println(notification);
		Thread.sleep(5000);
		if(notification.equalsIgnoreCase("Appointment is rescheduled successfully")){
			System.out.println("Appointment is rescheduled successfully");
			Reporter.log("Appointment is rescheduled successfully");
		}else{
			System.out.println("Appointment is  not rescheduled");
		}
		
		}
	
	public void clickingonappointmentmodification(){
		
		driver.findElement(By.xpath(Elements_Diagnostics.clickonmore)).click();
		
	}
  
	public void CancelAppointmentOfHomeVisit(){
		
		driver.findElement(By.xpath(Elements_Diagnostics.clickoncancel)).click();
		driver.findElement(By.id(Elements_Diagnostics.selectbox)).sendKeys("Personal reason");
		driver.findElement(By.xpath(Elements_Diagnostics.submitbutton)).click();
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[6]/div")));
		String notification=driver.findElement(By.cssSelector(Elements_Diagnostics.topnotification)).getText();
		System.out.println(notification);
		if(notification.equalsIgnoreCase("Appointment has been Cancelled")){
			
			System.out.println("Appointment has been Cancelled Sucessfully");
			Reporter.log("Appointment has been Cancelled Sucessfully");
		}else{
			Assert.fail("Appointment has notCancelled");
		}
	}
		
		
		
		
}//main Class
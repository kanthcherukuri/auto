package testBase;



import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import objectRepository.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;


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
		
		// Doctors logout 
				public  void doctorlogout() throws IOException, InterruptedException{			
					driver.get("https://zoyloqa.zoylo.com/providerAccount");
					Thread.sleep(5000);
					driver.findElement(By.cssSelector("span.icon-diag-cen > i.fa.fa-sign-out"))	.click();
					Thread.sleep(2000);
					driver.findElement(By.id("logout")).click();
					Thread.sleep(2000);
					}
		
		
		//DoctorAppointment  Reschedule
				public void reschedule(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
					
					WebDriverWait wait=new WebDriverWait(driver,90);
					
					 driver.findElement(By.id(Elements_Doctors.doctortab)) .click();	
					 
					 driver.findElement(By.xpath(Elements_Doctors.tommorrowmenu)).click();
				
					driver.findElement(By.xpath(Elements_Doctors.morning)).click();
					
					Thread.sleep(1000);
				
			     driver.findElement(By.xpath(Elements_Doctors.noon)).click();
			  
			     Thread.sleep(1000);
			      driver.findElement(By.xpath(Elements_Doctors.evening)).click();
			  
			  
			  driver.findElement(By.xpath(Elements_Doctors.eveningfirstcell)).click();
					Thread.sleep(2000);
					
					String parentWindow;
					parentWindow = driver.getWindowHandle();
					String subWindow = null;
					
					Set<String> handles = driver.getWindowHandles(); // get all window handles
					Iterator<String> iterator = handles.iterator();
					while (iterator.hasNext())
					{
					    subWindow = iterator.next();
					}
					driver.switchTo().window(subWindow); // switch to popup window
					
					// perform operations on popup
					driver.findElement(By.xpath(Elements_Doctors.locatorfirstname)).sendKeys(firstname);
							Thread.sleep(1000);
					driver.findElement(By.id(Elements_Doctors.locatorlsatname)).sendKeys( lastname);
					Thread.sleep(1000);
					driver.findElement(By.id(Elements_Doctors.locatormobile)).sendKeys(mobile);
					Thread.sleep(1000);
					driver.findElement(By.id(Elements_Doctors.locatoremail)).sendKeys( email);
					Thread.sleep(1000);
					driver.findElement(By.id(Elements_Doctors.locatorproblem)).sendKeys(problem);
					Thread.sleep(1000);
					driver.findElement(By.id("saveAppiontment")).click();
					
					driver.switchTo().window(parentWindow);  // switch back to parent window	
					
					Thread.sleep(5000);
					
					
			      wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Elements_Doctors.backgoundcolor)));
					
						
				driver.findElement(By.xpath(Elements_Doctors.changeicon)).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath(Elements_Doctors.nextmenu)).click();
				Thread.sleep(1000);
				
				driver.findElement(By.xpath(Elements_Doctors.morning)).click();
				
				Thread.sleep(1000);
				driver.findElement(By.xpath(Elements_Doctors.morningfirstcell)).click();
				
				Thread.sleep(1000);
				
				
				driver.findElement(By.xpath(Elements_Doctors.changeslot)).click();
				
				Thread.sleep(2000);
				
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Elements_Doctors.topnotification)));
				
				
				driver.findElement(By.id(Elements_Doctors.patienticon)).click();
				
				Thread.sleep(30000);  
				
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("searchPatientsList")));
				
					driver.findElement(By.id(Elements_Doctors.patientsearchbox)).sendKeys(email);
				     driver.findElement(By.id(Elements_Doctors.patientsearchbox)).sendKeys(Keys.ENTER);
						 driver.findElement(By.xpath(Elements_Doctors.patientallmenu)).click();	 
									 
						 
						 int patientsize= driver.findElements(By.xpath("//*[@id='all']/div")).size();
						 System.out.println(patientsize);
							String isfound2="true";
							for(int l=1;l<=patientsize && isfound2=="true";l++){
							
							String patientname=	driver.findElement(By.xpath(".//*[@id='all']/div["+l+"]/div[1]/div[2]/div/h1/span")).getText();
								System.out.println(patientname);
							if(patientname.equalsIgnoreCase(firstname+" "+lastname))
							{
									
						String provider=driver.findElement(By.xpath(".//*[@id='all']/div["+l+"]/div[2]/p[1]")).getText();
						
						System .out.println(provider);
							if(provider.equalsIgnoreCase("Rescheduled")){
							
							driver.findElement(By.xpath(".//*[@id='all']/div["+l+"]/div[2]/p[1]")).click();
							
							Reporter.log("The Appointment had been Rescheduled");
							break;
							}
								
							else{
							System.out.println("The Appointment Is Not Rescheduled");
							isfound2="false";
						}	
							}
							}			
						
					
				}
				

				
				
				public void Cancel(String firstname,String lastname,String mobile,String email,String problem) throws Exception {
					
					WebDriverWait wait=new WebDriverWait(driver,100);
					
					 driver.findElement(By.id(Elements_Doctors.doctortab)) .click();	
					 
					 driver.findElement(By.xpath(Elements_Doctors.tommorrowmenu)).click();
				
					driver.findElement(By.xpath(Elements_Doctors.morning)).click();
					
					Thread.sleep(1000);
				
			     driver.findElement(By.xpath(Elements_Doctors.noon)).click();
			  
			     Thread.sleep(1000);
			      driver.findElement(By.xpath(Elements_Doctors.evening)).click();
			  
			  
			  driver.findElement(By.xpath(Elements_Doctors.eveningfirstcell)).click();
					Thread.sleep(2000);
							
				
					
					// perform operations on popup
					driver.findElement(By.xpath(Elements_Doctors.locatorfirstname)).sendKeys(firstname);
							Thread.sleep(1000);
					driver.findElement(By.id(Elements_Doctors.locatorlsatname)).sendKeys( lastname);
					Thread.sleep(1000);
					driver.findElement(By.id(Elements_Doctors.locatormobile)).sendKeys(mobile);
					Thread.sleep(1000);
					driver.findElement(By.id(Elements_Doctors.locatoremail)).sendKeys( email);
					Thread.sleep(1000);
					driver.findElement(By.id(Elements_Doctors.locatorproblem)).sendKeys(problem);
					Thread.sleep(1000);
					driver.findElement(By.id("saveAppiontment")).click();
					Thread.sleep(40000);												
					
				
					//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[6]/div")));
		     	     	
					
			      //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Elements_Doctors.backgoundcolor)));
			     // wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='tab-3']/ul/li[1]/div[2]")));
					//driver.findElement(By.xpath("")).click();
			
			      driver.findElement(By.id("cancel")).click();
			      //driver.findElement(By.xpath("//*[@id='cancel']")).click();
			
			      driver.findElement(By.xpath("//*[@id='cancel-appointment-popup']/div/div/div[3]/select")).sendKeys("Personal reason");
					
			      driver.findElement(By.id("confirmYes")).click();		
							Thread.sleep(2000);
							driver.findElement(By.id("patients_patientsIcon")).click();
							
							Thread.sleep(30000);
							
							wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("searchPatientsList")));
							
							driver.findElement(By.id("searchPatientsList")).sendKeys(email);
							Thread.sleep(1000);
							 driver.findElement(By.id("searchPatientsList")).sendKeys(Keys.ENTER);
							 Thread.sleep(1000);
							 driver.findElement(By.xpath(" html/body/div[9]/div[3]/div[2]/div/ul/li[2]")).click();
							 Thread.sleep(10000);
							 
							 
							 int patientsize= driver.findElements(By.xpath("//*[@id='all']/div")).size();
							 
								String isfound2="true";
								for(int l=1;l<=patientsize && isfound2=="true";l++){
								
								String patientname=	driver.findElement(By.xpath(".//*[@id='all']/div["+l+"]/div[1]/div[2]/div/h1/span")).getText();
								System.out.println(patientname);
								if(patientname.equalsIgnoreCase(firstname+" "+lastname))
								{
									
						String provider=driver.findElement(By.xpath(".//*[@id='all']/div["+l+"]/div[2]/p[1]")).getText();
							if(provider.equalsIgnoreCase("Cancelled By Provider")){
								
								driver.findElement(By.xpath(".//*[@id='all']/div["+l+"]/div[2]/p[1]")).click();
								
								Reporter.log("The Appointment had been Canceled");
								break;
							}
								
							else{
								System.out.println("The Appointment Is Not Cancelled");
								isfound2="false";
							}	
															
								}					
					
				              }												
		    
                            }
				
				
public void patientsendnotification() throws Exception{
driver.findElement(By.id(Elements_Doctors.patienticonid)).click();
					  
  Thread.sleep(1000);
  
  // Clicking on all Tab in Patient Screen  
  driver.findElement(By.xpath(Elements_Doctors.alltab)).click();
  
  System.out.println("Clicked on all tab");
  
 Thread.sleep(10000);
 
 //Getting size of all the div's in all tab of patient screen
 int patientsize= driver.findElements(By.xpath(Elements_Doctors.alltabdivsize)).size();
 
 for(int l=1;l<=patientsize ;l++)
 {		 
	 
String Schedule=driver.findElement(By.xpath("//*[@id='all']/div["+l+"]/div[2]/p[1]")).getText();
if(Schedule.equalsIgnoreCase("Scheduled")||Schedule.equalsIgnoreCase("Rescheduled"))
{
	
System.out.println("Scheduled/Rescheduled Found");
Reporter.log("Scheduled/Rescheduled Found");			

//scrolling to the webelement Scheduled/Rescheduled
WebElement sc = driver.findElement(By.xpath("//*[@id='all']/div["+l+"]/div[2]/p[1]"));
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sc);

//Clicking on the send notification button
driver.findElement(By.xpath("//*[@id='all']/div["+l+"]/div[2]/p[1]//following-sibling::div[@id='resendNotification']/button")).click();							

System.out.println("Sucessfully clicked on Send Notification button");

//String notification = driver.findElement(By.xpath(Elements_Doctors.topnotification)).getText();

//System.out.println(notification);

//SoftAssert assertion=new SoftAssert();
				
//assertion.assertEquals(notification,"Email/SMS Notification sent to the Patient");
//assertion.assertAll();
			
	break; 		  
  
  }
	
else{
		
System.out.println("Scheduled/Rescheduled Text NotFound");
}				
 }	
					
}			
				
				
				
				
}//main class

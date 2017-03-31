package doctorsTestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.DoctorsPage;
import testBase.LoadProp;
import testBase.TestUtils;

public class Appointment_ZOY819_FollowUP extends LoadProp {

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
	  
	  @Test
	  
	  public void followup() throws Exception{
		  
		  String isFound = "true";
		  String isFound1 = "true";
		  String isFound2 = "true";
		  
		
		// Clicking on patients Icon
		driver.findElement(By.id("patients")).click();
		
		Thread.sleep(1000);
		
		 
		 System.out.println("Clicked on all tab");
		 Thread.sleep(10000);
		 
		 // get the size of the all tab in patients
	 int patientsize= driver.findElements(By.xpath(".//*[@id='all']/div")).size();
		 
		 System.out.println(patientsize);
		 
		 for(int l=1;l<=patientsize &&isFound2 =="true";l++){
			 
			 //Click on all link in Patients menu
			 driver.findElement(By.xpath("html/body/div[9]/div[3]/div[2]/div/ul/li[2]")).click();
			 
		 // Getting the  text Check out
		 String Schedule=driver.findElement(By.xpath("//*[@id='all']/div["+l+"]/div[2]/p[1]")).getText();
			if(Schedule.equalsIgnoreCase("Checked Out"))
			{
				
				System.out.println("Checked Out Found");
				
				// scroll to the Element 
				WebElement sc = driver.findElement(By.xpath("//*[@id='all']/div["+l+"]/div[2]/p[1]"));
				 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", sc);
				 driver.findElement(By.xpath("//*[@id='all']/div["+l+"]/div[2]/p[1]")).click();	
				 
				 Thread.sleep(10000);
				 
				// Verifying if the Follow Up button is available /Not
				 
				 if (driver.findElements(By.xpath("//button[text()='Follow Up']")).size()>0) {
					 
					driver.findElement(By.xpath("//button[text()='Follow Up']"))
							.click();
					System.out.println("Clicked on follow Up button");
					for (int i = 0; i <= 14 && isFound == "true"; i++) {

						driver.findElement(By.xpath(".//*[@id='cd-" + i + "']")).click();

						for (int j = 1; j <= 3 && isFound1 == "true"; j++) {

							driver.findElement(By.xpath(".//*[@id='patient-apmt-tabs']/li["+j+"]/div/center/span[1]")).click();

							int slotsize = driver.findElements(By.xpath(".//*[@id='tab-"+j+"']/ul/li")).size();

							if (slotsize > 1) {

								for (int k = 1; k <= slotsize; k++) {

				String textvalue = driver.findElement(By.xpath(".//div[@id='tab-"+j+ "']//ul//li["+k+"]//div[@class='apt-tme']")).getText();

									System.out.println(textvalue);

									if (textvalue.equalsIgnoreCase("07:31")) {

										System.out.println("Time Slot Found");
										
						driver.findElement(By.xpath(".//*[@id='tab-"+j+ "']/ul/li["+k+"]")).click();
										Thread.sleep(1000);
										driver.findElement(By.id("mobileNumber")).clear();
										
										driver.findElement(By.id("mobileNumber")).sendKeys("9908500133");
										Thread.sleep(1000);
										
										driver.findElement(By.id("problem")).sendKeys("Diabetic");
										Thread.sleep(1000);

										driver.findElement(By.id("saveFollowUpAppiontment")).click();
										Thread.sleep(20000);
										String notification = driver.findElement(By.xpath("html/body/div[6]/div")).getText();

										System.out.println(notification);
										isFound1 = "false";
										isFound = "false";
										isFound2 = "false";
										
										break;

									}//if loop of time comparation
								}//for loop for k

							}//if loop for slotsize

						}//for loop for j

					}// for loop for i
				}//FOLLOWUP IF
				 
				 
				 else{
					 
					 driver.findElement(By.xpath("//span[text()='Patients']")).click();
				 }	  	 
				 
				 
			}//if loop for checking Checked out
		 
		 }// for loop for  L
		
	}

		
		  
		  
		  
		  
		  
						
		  
		  
	  }
	  
	  
	  
	  
	  
	  
	

			 
	  
	  





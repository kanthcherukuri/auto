package diagnosticTestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.Elements_Diagnostics;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointments_ZOY956_SearchInPatientScreen extends LoadPropMac {
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils exceldata;
	
	@BeforeClass
	  public void beforeClass() throws Exception {
		LoadBrowserProperties();
		 driver.manage().window().maximize();
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }
		
	  
	
	@Test(priority=1)
	  public void DiagnosticLogin() throws Exception {
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
			DiagnosticPageZoylo=new DiagnosticPage(driver);	
			DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
			
				}
	 @DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Rajini","J","9966775511","rajni@gmail.com","Diabetic" }

			};
		}

	 
	 
	 @Test(dataProvider="DP1", priority=2,groups = { "Regression","High" })
	 public void patientsearch(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		 if(RunMode.equals("yes")){
			 
			 driver.findElement(By.id(Elements_Diagnostics.clickonappointmentsmenu)).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath(".//*[@id='cd-0']")).click();
				//driver.findElement(By.xpath(Elements_Diagnostics.tommorowmenu)).click();
				driver.findElement(By.xpath(Elements_Diagnostics.morningmenu)).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath(Elements_Diagnostics.noonmenu)).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath(Elements_Diagnostics.eveningmenu)).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath(Elements_Diagnostics.eveningfirstcell)).click();
				driver.findElement(By.id(Elements_Diagnostics.detailsfirstname)).sendKeys(firstname);
				Thread.sleep(1000);
				driver.findElement(By.id(Elements_Diagnostics.detailslastname)).sendKeys(lastname);
				Thread.sleep(1000);
				driver.findElement(By.id(Elements_Diagnostics.detailsmobile)).sendKeys(mobile);
				Thread.sleep(1000);
				driver.findElement(By.id(Elements_Diagnostics.detailsemail)).sendKeys(email);
				Thread.sleep(1000);
				driver.findElement(By.id(Elements_Diagnostics.detailsproblem)).sendKeys(problem);
				Thread.sleep(1000);
				driver.findElement(By.xpath(Elements_Diagnostics.packagetab)).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath(Elements_Diagnostics.packagecheckbox)).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id(Elements_Diagnostics.windowsavebutton)).click();
				WebDriverWait wait = (new WebDriverWait(driver, 60));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Elements_Diagnostics.notification)));
				String notification=driver.findElement(By.cssSelector(Elements_Diagnostics.topnotification)).getText();
				System.out.println(notification);
				if(notification.equalsIgnoreCase("Appointment is confirmed. Patient Name:"+firstname)){
					
					System.out.println("Appointment is Sucessfully Created");
				}else{
					System.out.println("Appointment Creation is Unsucess");
					//Assert.fail("Appointment Creation is Unsucess");
				}
				
				Thread.sleep(3000);
			 driver.findElement(By.id("patients")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//*[@id='search-bar']")).click();
			 Thread.sleep(5000);
			 String fullname=firstname+" "+lastname;
			 String topping[]=new String[3];
			 topping[0]=fullname;
			 topping[1]=mobile;
			 topping[2]=email;
			 
			 //String topping[]={{fullname},{mobile,{email}};
			 for(int i=0;i<=topping.length-1;i++){
				driver.findElement(By.xpath(".//*[@id='apt-search']")).clear();
				 driver.findElement(By.xpath(".//*[@id='apt-search']")).sendKeys(topping[i]);
				 driver.findElement(By.id("apt-search")).sendKeys(Keys.ENTER);
				 Thread.sleep(10000);
			String elementpresent=driver.findElement(By.xpath("//*[@id='sp-diagno-tab-1']/div[1]/div/div[2]/div/h1/span[1]/span")).getText();
			System.out.println(elementpresent);
			String status=driver.findElement(By.xpath("//p[@class='check_in']")).getText();
			System.out.println(status);
			if(elementpresent.equalsIgnoreCase(fullname)&&status.equalsIgnoreCase("Scheduled")){
				
				System.out.println("User had Present");
				
			}else{
				System.out.println("User Not Present");
			}
				
				
			
				 
			 }
			 
		 }else{
			 
			 throw new SkipException("RUNMODE IS OFF");
		 }
		 
		 
	 }

}

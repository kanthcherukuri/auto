package testBase;



import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import objectRepository.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;






public class DoctorsPage  {
	//FirefoxDriver browser = new FirefoxDriver();
	public    WebDriver driver;
	public TestUtils Browser;

	public DoctorsPage(WebDriver driver) throws Exception {
		this.driver=driver;
		Browser= new TestUtils(driver); 

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
		//Browser.waitFortheID("emailAddress");	
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
		Thread.sleep(5000);
		System.out.println("Doctor Logged Out");
	}

	// Click on recent Patient from dashboard
	public  void clickOnTheRecentPatientFromDashBoard() throws IOException, InterruptedException{
		Thread.sleep(5000);
		if(driver.findElements(By.id("show-all-btn")).isEmpty()){
			System.out.println("is empty");
			Browser.waitFortheElementXpath("//div[@class='doctor-patientname patientfullName']/span");
			driver.findElement(By.xpath("(//div[@class='doctor-patientname patientfullName']/span)[last()]")).click();  // Recent Appointment
			Browser.waitTill(60);
		}else{
			System.out.println("show all btn exisit");
			driver.findElement(By.id("show-all-btn")).click();
			Thread.sleep(2000);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 250)"); // if the element is on bottom.
			Thread.sleep(5000);
			//Browser.waitFortheElementXpath("//div[@class='doctor-patientname patientfullName']/span");
			driver.findElement(By.xpath("(//div[@class='doctor-patientname patientfullName']/span)[last()]")).click();  // Recent Appointment
			Browser.waitTill(60);

		}

	}

	// Doctors Checkin and check the recipient
	public  void doctorCheckinCheckOut() throws IOException, InterruptedException{			
		driver.findElement(By.xpath("//div[@id='checkIn']/span[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("startConsultation")).click();				
		Thread.sleep(2000);
		driver.findElement(By.id("diagnosis")).sendKeys("Diagonis Details");
		Thread.sleep(2000);
		driver.findElement(By.id("saveProblems")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("saveVitals")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("savePrescription")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("saveNotes")).click();				
		Thread.sleep(5000);
		driver.findElement(By.id("generateReceipt")).click();
		Thread.sleep(5000);
		Browser.verifyNotificationMessage("Bill generated successfully");
		Thread.sleep(5000);
		driver.findElement(By.id("checkOut")).click();
		Thread.sleep(2000);
		Browser.verifyNotificationMessage("Appointment checked out successfully");
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

	public void DoctorappointmentCreation() throws Exception{

		driver.findElement(By.id(Elements_Doctors.doctortab)) .click();	

		driver.findElement(By.xpath(Elements_Doctors.todaymenu)).click();

		driver.findElement(By.xpath(Elements_Doctors.morning)).click();

		driver.findElement(By.xpath(Elements_Doctors.noon)).click();

		driver.findElement(By.xpath(Elements_Doctors.evening)).click();

		int slotsize = driver.findElements(By.xpath("//*[@id='tab-3']/ul/li")).size();

		if(slotsize>0)
		{

			driver.findElement(By.xpath("//*[@id='tab-3']/ul/li[1]/div[2]")).click();

			Thread.sleep(1000);

			driver.findElement(By.xpath(Elements_Doctors.locatorfirstname)).sendKeys("Amarnath");
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Doctors.locatorlsatname)).sendKeys("R");
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Doctors.locatormobile)).sendKeys("1234567898");
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Doctors.locatoremail)).sendKeys("amar@gmail.com");
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Doctors.locatorproblem)).sendKeys("diabetic");
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Doctors.locatorsave)).click();	

		}
	}

	public  void expliciteWait(String xpath,int timeToWaitInSec) {

		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
		//wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	}



	public void ClickingOnEllipse(){

		driver.findElement(By.xpath("html/body/div[9]/div/div[2]/div[3]/span/i")).click();

	}


public void ClickingOnDashboard(){

driver.findElement(By.id("dashBoard")).click();	
WebDriverWait wait=new WebDriverWait(driver,100);
wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='label-font']")));
}



public void dashboardAppointmentListing(){


String listingavailable=driver.findElement(By.xpath("//div[@class='label-font']")).getText();

System.out.println("Listing Name:" +listingavailable );

if(listingavailable.equalsIgnoreCase("Appointments Listing")){

int appointmentlisting= driver.findElements(By.xpath("//div[@class='force-overflow']//div[@class='patient-details-dashboard']")).size();

System.out.println(appointmentlisting);

for(int i=1;i<=appointmentlisting; i++)
{

	String name=driver.findElement(By.xpath("//*[@id='scrolls']/div/div["+i+"]/div[2]/span")).getText();

System.out.println(name);

if(name.equalsIgnoreCase("Amarnath R"))

{
	System.out.println("User Name Matched");
System.out.println("The appointment created from Doctors login is Listed");
driver.findElement(By.xpath("//*[@id='scrolls']/div/div["+i+"]/div[2]/span")).click();	

//Thread.sleep(5000);

expliciteWait("html/body/div[7]/div[3]/div/div[1]/div[2]/div/h1/span",500);

//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[7]/div[3]/div/div[1]/div[2]/div/h1/span")));

String validation=driver.findElement(By.xpath("//div[@class='zy-rec-content']/div[@class='rec-content']/h1[@class='zy-rec-name']/span")).getText();

System.out.println(validation);

SoftAssert assertion=new SoftAssert();
assertion.assertEquals(validation,"Amarnath R");
	assertion.assertAll();

	break;

}

else{

	System.out.println("User Name Not Matched");

	}


}//for loop i

}// if loop for checking listingavailable 

else{

	System.out.println("Appointments Listing is not Displayed");

	}

}//if loop for sizeslot	



public void DoctorAppointmentListing() throws Exception{

driver.findElement(By.id(Elements_Doctors.doctortab)) .click();	

driver.findElement(By.xpath(Elements_Doctors.todaymenu)).click();

driver.findElement(By.xpath(Elements_Doctors.morning)).click();

driver.findElement(By.xpath(Elements_Doctors.noon)).click();

driver.findElement(By.xpath(Elements_Doctors.evening)).click();

int slotsize = driver.findElements(By.xpath("//*[@id='tab-3']/ul/li")).size();

if(slotsize>0)
{

driver.findElement(By.xpath("//*[@id='tab-3']/ul/li[1]/div[2]")).click();

Thread.sleep(1000);

driver.findElement(By.xpath(Elements_Doctors.locatorfirstname)).sendKeys("Amarnath");
Thread.sleep(1000);
driver.findElement(By.id(Elements_Doctors.locatorlsatname)).sendKeys("R");
Thread.sleep(1000);
driver.findElement(By.id(Elements_Doctors.locatormobile)).sendKeys("9908500133");
Thread.sleep(1000);
driver.findElement(By.id(Elements_Doctors.locatoremail)).sendKeys("amar@gmail.com");
Thread.sleep(1000);
driver.findElement(By.id(Elements_Doctors.locatorproblem)).sendKeys("diabetic");
Thread.sleep(1000);
driver.findElement(By.id(Elements_Doctors.locatorsave)).click();

WebDriverWait wait=new WebDriverWait(driver,10000);
wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='tab-3']/ul/li[1][@class='bg-red']")));

driver.findElement(By.xpath("html/body/div[9]/div/div[2]/div[3]/span/i")).click();

driver.findElement(By.id("dashBoard")).click();		

//Thread.sleep(65000);

wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='sp-dashboard-content']/div[1]/div[2]")));

String listingavailable=driver.findElement(By.xpath("//div[@class='label-font']")).getText();

System.out.println("Listing Name:" +listingavailable );

if(listingavailable.equalsIgnoreCase("Appointments Listing")){

int appointmentlisting= driver.findElements(By.xpath("//div[@class='force-overflow']//div[@class='patient-details-dashboard']")).size();

System.out.println(appointmentlisting);

for(int i=1;i<=appointmentlisting; i++)
{

String name=driver.findElement(By.xpath("//*[@id='scrolls']/div/div["+i+"]/div[2]/span")).getText();

System.out.println(name);

if(name.equalsIgnoreCase("Amarnath R"))

{
System.out.println("User Name Matched");
System.out.println("The appointment created from Doctors login is Listed");
driver.findElement(By.xpath("//*[@id='scrolls']/div/div["+i+"]/div[2]/span")).click();	

//Thread.sleep(5000);

wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[7]/div[3]/div/div[1]/div[2]/div/h1/span")));

String validation=driver.findElement(By.xpath("//div[@class='zy-rec-content']/div[@class='rec-content']/h1[@class='zy-rec-name']/span")).getText();

System.out.println(validation);

SoftAssert assertion=new SoftAssert();
assertion.assertEquals(validation,"Amarnath R");
assertion.assertAll();

break;

}

else{

System.out.println("User Name Not Matched");

}


}//for loop i

}// if loop for checking listingavailable 

else{

System.out.println("Appointments Listing is not Displayed");

}

}//if loop for sizeslot	

}//method



public void DoctorAppointmentForShowMore() throws Exception{
	
driver.findElement(By.id("appointment_appointmentCalendar")).click();	
 
driver.findElement(By.xpath(".//*[@id='cd-0']")).click();
 
driver.findElement(By.xpath("//*[@id='patient-apmt-tabs']/li[1]/div/center/span[1]")).click();
 
driver.findElement(By.xpath("//*[@id='patient-apmt-tabs']/li[2]/div/center/span[1]")).click();
 
driver.findElement(By.xpath("//*[@id='patient-apmt-tabs']/li[3]/div/center/span[1]")).click();
 
int slotsize = driver.findElements(By.xpath("//*[@id='tab-3']/ul/li")).size();

 if(slotsize>0)
 {
for(int i=1;i<=6; i++) {			
			
 WebElement  elementtoclick= driver.findElement(By.xpath("//*[@id='tab-3']/ul/li["+i+"]/div[2]"));
 ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+ elementtoclick.getLocation().x+")");
 elementtoclick.click();
 
Thread.sleep(1000);
		 
driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("Amarnath");
Thread.sleep(1000);
driver.findElement(By.id("lastName")).sendKeys("R");
Thread.sleep(2000);
driver.findElement(By.id("mobileNumber")).sendKeys("+919912345678");
Thread.sleep(1000);
driver.findElement(By.id("email")).sendKeys("amar@gmail.com");
Thread.sleep(1000);
driver.findElement(By.id("problem")).sendKeys("diabetic");
Thread.sleep(1000);	
driver.findElement(By.id("saveAppiontment")).click();	
DoctorsPage.isElementPresnt(driver, "//*[@id='tab-3']/ul/li["+i+"][@class='bg-red']", 20);
}//For Loop
	 
 }//if loop slotsize
 
}


public static WebElement isElementPresnt(WebDriver driver,String xpath,int time)
{ 
 
WebElement ele = null;
 
for(int i=0;i<time;i++)
{
try{
ele=driver.findElement(By.xpath(xpath));
break;
}
catch(Exception e)
{
try 
{
Thread.sleep(1000);
} catch (InterruptedException e1) 
{
System.out.println("Waiting for element to appear on DOM");
}
}
 
}
return ele;
 
}



public void CheckShowMore() throws InterruptedException{
	
Thread.sleep(3000);
System.out.println(driver.manage().window().getSize());
Dimension d= new Dimension(1920, 1080);
driver.manage().window().setSize(d);		
Thread.sleep(5000);		     
    	
if(driver.findElements(By.id("show-all-btn")).isEmpty()){
 
Assert.fail("Show More Button is not avaiable");
		
}
	
else{
		
 
driver.findElement(By.id("show-all-btn")).click();
System.out.println("show More Button is present");
System.out.println("show More Button is Clicked");
Thread.sleep(2000);	  		
((JavascriptExecutor)driver).executeScript("scroll(0,400)");
Thread.sleep(2000);
System.out.println("Scroll Button is Available");
driver.findElement(By.id("show-less-btn")).click();
System.out.println("Show Less Button is Present");	  	
System.out.println("Show Less Button is Clicked");	  		
		
}

}


public void doctorappointmentbooking(String timeslot,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
	
 //String emailaddress=email;
  String name=firstname+" "+lastname;
  System.out.println(name);	  ;
  String isFound = "true";
  String isFound1 = "true";
  
 driver.findElement(By.id("appointment_appointmentCalendar")) .click();	 		 
	
for(int i=0;i<=14 && isFound=="true";i++)
 {

 driver.findElement(By.xpath(".//*[@id='cd-"+i+"']")).click();
 
 for(int j=1;j<=3 && isFound1=="true";j++){
 
 driver.findElement(By.xpath(".//*[@id='patient-apmt-tabs']/li["+j+"]/div/center/span[1]")).click(); 
 
 int slotsize = driver.findElements(By.xpath(".//*[@id='tab-"+j+"']/ul/li")).size();
 
 if(slotsize>1)
 {
					 
for(int k=1;k<=slotsize;k++) 
	
{
						
						
String textvalue = driver.findElement(By.xpath(".//div[@id='tab-"+j+"']//ul//li["+k+"]//div[@class='apt-tme']")).getText();

System.out.println(textvalue);


if(textvalue.equalsIgnoreCase(timeslot)){
System.out.println(timeslot);
System.out.println("Time Slot Found");
driver.findElement(By.xpath(".//*[@id='tab-"+j+"']/ul/li["+k+"]")).click();
Thread.sleep(1000);					
driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys(firstname);
		Thread.sleep(1000);
driver.findElement(By.id("lastName")).sendKeys(lastname);
Thread.sleep(1000);
driver.findElement(By.id("mobileNumber")).sendKeys(mobile);
Thread.sleep(1000);
driver.findElement(By.id("email")).sendKeys(email);
Thread.sleep(1000);
driver.findElement(By.id("problem")).sendKeys(problem);
Thread.sleep(1000);
driver.findElement(By.id("saveAppiontment")).click();						
									
DoctorsPage.isElementPresnt(driver, "//*[@id='tab-"+j+"']/ul/li["+k+"][@class='bg-red']", 20);				

driver.findElement(By.id("patients")).click();

DoctorsPage.isElementPresnt(driver, "//*[@id='searchPatientsList']", 20).sendKeys(email); 

 driver.findElement(By.id("searchPatientsList")).sendKeys(Keys.ENTER);
 Thread.sleep(5000);
 driver.findElement(By.xpath(" html/body/div[9]/div[3]/div[2]/div/ul/li[2]")).click();
 Thread.sleep(5000);
 
int patientsize= driver.findElements(By.xpath(".//*[@id='all']/div")).size();

for(int l=1;l<=patientsize;l++){

String patientname=	driver.findElement(By.xpath(".//*[@id='all']/div["+l+"]/div[1]/div[2]/div/h1/span")).getText();
String Schedule=	driver.findElement(By.xpath("//*[@id='all']/div["+l+"]/div[2]/p[1]")).getText();
if(patientname.equalsIgnoreCase(firstname+" "+lastname)&& Schedule.equalsIgnoreCase("Scheduled"))
{
					
System.out.println(firstname+" "+lastname);
driver.findElement(By.xpath(".//*[@id='all']/div["+l+"]/div[1]/div[2]/div/h1/span")).click();	


Reporter.log("Appointment Created By Doctor was Sucessful and Verfied");
System.out.println("Appointment Created By Doctor was Sucessful and Verfied");
Thread.sleep(40000);	
				
break;
}
else{
	System.out.println("Doctor Appointment Creation was UnSucessfull");
}

}		
										
			
isFound="false";
isFound1="false";
break;				
}
else
	
{
	System.out.println(timeslot);
	System.out.println("Time Slot Not Matched");
	
}					
	
	}	//for loop	 k
					 
 }	// if loop		  	 
	 		 			 
 }	//for loop	 j

 }
	
	 // for loop  i
	 
}// main method 	
	

public void doctorprofileEditing() throws Exception{
	
driver.findElement(By.id("account_accountIcon")).click();
Thread.sleep(3000);
((JavascriptExecutor)driver).executeScript("scroll(0,400)");
driver.findElement(By.id("editAboutInfo")).click();
Thread.sleep(1000);
WebElement element=driver.findElement(By.id("doctorQualification"))	; 
Select se= new Select(element);
se.selectByValue("BACHELOR OF DENTAL SURGERY");
driver.findElement(By.id("saveAboutInfo")).click();
Thread.sleep(5000);

}





















}//main class

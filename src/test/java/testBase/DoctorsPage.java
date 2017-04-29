package testBase;



import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        Elements_Recipients.Recipients_PageProperties();
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

		driver.findElement(By.xpath(Elements_Doctors.changeicon)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Elements_Doctors.nextmenu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Doctors.morning)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Doctors.morningfirstcell)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Doctors.changeslot)).click();
		Thread.sleep(1000);
		Browser.CheckNotificationMessage("Successfully changed the appointment slot");
		Thread.sleep(2000);
		}
	
	
		public void CheckPatientScreenForReschedule(String firstname,String lastname,String email) throws Exception{

		driver.findElement(By.id(Elements_Doctors.patienticon)).click();
		WebDriverWait wait = new WebDriverWait(driver, 8000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("searchPatientsList")));
		driver.findElement(By.id(Elements_Doctors.patientsearchbox)).sendKeys(email);
		driver.findElement(By.id(Elements_Doctors.patientsearchbox)).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.name(Elements_Doctors.patientallmenuname)).click();	
		Thread.sleep(3000);
		String name=driver.findElement(By.xpath(Elements_Doctors.alltabname)).getText();
		String schedule=driver.findElement(By.xpath(Elements_Doctors.alltabschedule)).getText();
		String fullname=firstname+" "+lastname;
		if(name.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Rescheduled")){
			System.out.println("Appointment Rescheduled Is Sucessfully Verified");
		}		
		}




	public void Cancel(String firstname,String lastname,String mobile,String email,String problem) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.id("cancel")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='cancel-appointment-popup']/div/div/div[3]/select")).sendKeys("Personal reason");
		driver.findElement(By.id("confirmYes")).click();
		Browser.CheckNotificationMessage("Appointment has been Cancelled");
		Thread.sleep(5000);
	}
		
	public void CheckCancelAppointmentInPatientScreen(String firstname,String lastname,String email) throws Exception	{
		driver.findElement(By.id(Elements_Doctors.patienticonid)).click();
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(Elements_Doctors.patientsearchbox)));
		driver.findElement(By.id(Elements_Doctors.patientsearchbox)).sendKeys(email);
		driver.findElement(By.id(Elements_Doctors.patientsearchbox)).sendKeys(Keys.ENTER);
		driver.findElement(By.name(Elements_Doctors.patientallmenuname)).click();
		Thread.sleep(5000);
		String name=driver.findElement(By.xpath(Elements_Doctors.alltabname)).getText();
		String status=driver.findElement(By.xpath(Elements_Doctors.alltabschedule)).getText();
		String fullname=firstname+" "+lastname;
		if(name.equalsIgnoreCase(fullname)&&status.equalsIgnoreCase("Cancelled By Provider")){
			System.out.println("Appointment is Sucessfully Cancelled");
		}													
		}


	public void CheckPatientScreenSendNotificationOfAllTab(String firstname,String lastname,String email) throws Exception{
		driver.findElement(By.id(Elements_Doctors.patienticonid)).click();
		Thread.sleep(1000);
		// Clicking on all Tab in Patient Screen  
		driver.findElement(By.xpath(Elements_Doctors.alltab)).click();
		System.out.println("Clicked on all tab");
		Thread.sleep(3000);
		driver.findElement(By.id(Elements_Doctors.patientsearchbox)).sendKeys(email);	 
	 	driver.findElement(By.id(Elements_Doctors.patientsearchbox)).sendKeys(Keys.ENTER);
		String name=driver.findElement(By.xpath(Elements_Doctors.alltabname)).getText();
		String schedule=driver.findElement(By.xpath(Elements_Doctors.alltabschedule)).getText();
		String fullname=firstname+" "+lastname;
		if(name.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Scheduled")){
		driver.findElement(By.xpath(Elements_Doctors.sendnotification)).click();
		System.out.println("Sucessfully clicked on Send Notification button");
		Browser.CheckNotificationMessage("Email/SMS Notification sent to the Patient");
//		String notification = driver.findElement(By.xpath(Elements_Doctors.topnotification)).getText();
//		System.out.println(notification);
//		SoftAssert assertion=new SoftAssert();
//		assertion.assertEquals(notification,"Email/SMS Notification sent to the Patient");
//		assertion.assertAll();
		}
	}
			
	public void CheckPatientScreenSendNotificationOfTodayTab(String firstname,String lastname,String email) throws Exception{
		driver.findElement(By.id(Elements_Doctors.patienticonid)).click();
		Thread.sleep(1000);	
		driver.findElement(By.id(Elements_Doctors.patientsearchbox)).sendKeys(email);	 
	 	driver.findElement(By.id(Elements_Doctors.patientsearchbox)).sendKeys(Keys.ENTER);
	 	String name=driver.findElement(By.xpath(Elements_Doctors.todaytabname)).getText();
	 	String schedule=driver.findElement(By.xpath(Elements_Doctors.todaytabschedule)).getText();
	 	String fullname=firstname+" "+lastname;
	 	if(name.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Scheduled")){
	 		driver.findElement(By.xpath(Elements_Doctors.sendnotification)).click();
	 		System.out.println("Sucessfully clicked on Send Notification button");
	 		Browser.CheckNotificationMessage("Email/SMS Notification sent to the Patient");
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



	public void dashboardAppointmentListing(String firstname,String lastname){
	String listingavailable=driver.findElement(By.xpath("//div[@class='label-font']")).getText();
	System.out.println("Listing Name:" +listingavailable );
	if(listingavailable.equalsIgnoreCase("Appointments Listing")){
	int appointmentlisting= driver.findElements(By.xpath("//div[@class='force-overflow']//div[@class='patient-details-dashboard']")).size();
	System.out.println(appointmentlisting);
	for(int i=1;i<=appointmentlisting; i++)
	{
	
	String name=driver.findElement(By.xpath("//*[@id='scrolls']/div/div["+i+"]/div[2]/span")).getText();
	String fullname=firstname+" "+lastname;
	System.out.println(name);
	if(name.equalsIgnoreCase(fullname))
	{
	System.out.println("User Name Matched");
	System.out.println("The appointment created from Doctors login is Listed");
	driver.findElement(By.xpath("//*[@id='scrolls']/div/div["+i+"]/div[2]/span")).click();	
	expliciteWait("html/body/div[7]/div[3]/div/div[1]/div[2]/div/h1/span",5000);
	String validation=driver.findElement(By.xpath("//div[@class='zy-rec-content']/div[@class='rec-content']/h1[@class='zy-rec-name']/span")).getText();
	System.out.println(validation);
	SoftAssert assertion=new SoftAssert();
	assertion.assertEquals(validation,fullname);
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




		public void DoctorAppointmentForShowMore() throws Exception{	
		driver.findElement(By.id("appointment_appointmentCalendar")).click();	
		driver.findElement(By.xpath(".//*[@id='cd-0']")).click();
		driver.findElement(By.xpath("//*[@id='patient-apmt-tabs']/li[1]/div/center/span[1]")).click();
		driver.findElement(By.xpath("//*[@id='patient-apmt-tabs']/li[2]/div/center/span[1]")).click();
		driver.findElement(By.xpath("//*[@id='patient-apmt-tabs']/li[3]/div/center/span[1]")).click();
		int slotsize = driver.findElements(By.xpath("//*[@id='tab-3']/ul/li")).size();
		 if(slotsize>0)
		 {
		for( slotsize=1;slotsize<=6; slotsize++) {						
		 WebElement  elementtoclick= driver.findElement(By.xpath("//*[@id='tab-3']/ul/li["+slotsize+"]/div[2]"));
		 ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+ elementtoclick.getLocation().x+")");
		 elementtoclick.click();
		Thread.sleep(1000);	 
		driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("Anji");
		Thread.sleep(1000);
		driver.findElement(By.id("lastName")).sendKeys("R");
		Thread.sleep(2000);
		driver.findElement(By.id("mobileNumber")).sendKeys("9988664422");
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("anji@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("problem")).sendKeys("diabetic");
		Thread.sleep(1000);	
		driver.findElement(By.id("saveAppiontment")).click();	
		Browser.waitFortheElementXpath("//*[@id='tab-3']/ul/li["+slotsize+"][@class='bg-red']");
		Thread.sleep(1000);
		
		}//For Loop
			 
		 }//if loop slotsize
		 
		}


		public static WebElement isElementPresnt(WebDriver driver,String xpath,int time)
		{WebElement ele = null;
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





		public void BulkCancel() throws Exception{
	
		Date today = new Date(); 
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(today);  
		calendar.add(Calendar.MONTH, 1);  
		calendar.set(Calendar.DAY_OF_MONTH, 1);  
		calendar.add(Calendar.DATE, -1);  
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		Date lastDayOfMonth = calendar.getTime(); 
		String date=sdf.format(today);
		String enddate= sdf.format(lastDayOfMonth);
		System.out.println(date);
		System.out.println(enddate);
	   driver.findElement(By.id("appointment_appointmentCalendar")).click();
	   Thread.sleep(3000);
	   driver.findElement(By.xpath("//div//i[@class='pa-cancl-apt fa fa-calendar-times-o cancel-apmpt-btn menu_links']")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//*[@id='datepicker-cancelfrom']")).sendKeys(date);
	   Thread.sleep(3000);
	   driver.findElement(By.xpath("//*[@id='datepicker-cancelto']")).sendKeys(enddate);
	   Thread.sleep(3000);
	   driver.findElement(By.xpath("//*[@id='fromTime']")).sendKeys("07:00");
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//*[@id='toTime']")).sendKeys("23:00");
	   Thread.sleep(2000);
	   driver.findElement(By.id("cancelAppointmentsSubmit")).click();
	   Thread.sleep(3000);
	   //Browser.CheckNotificationMessage("Appointments cancelled successfully");
	   Browser.verifyNotificationMessage("Appointments cancelled successfully");
		
	  
		}



 public void DoctorsAppointmentforTomorrow(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
	 
	 driver.findElement(By.id(Elements_Doctors.doctortab)) .click();	

	 driver.findElement(By.xpath(Elements_Doctors.tommorrowmenu)).click();

	 driver.findElement(By.xpath(Elements_Doctors.morning)).click();

	 driver.findElement(By.xpath(Elements_Doctors.noon)).click();

	 driver.findElement(By.xpath(Elements_Doctors.evening)).click();
	 
	 driver.findElement(By.xpath("//*[@id='tab-3']/ul/li[1]/div[2]")).click();
	 Thread.sleep(2000);
	 
	 driver.findElement(By.xpath(Elements_Doctors.locatorfirstname)).sendKeys(firstname);
	 Thread.sleep(1000);
		
		driver.findElement(By.id(Elements_Doctors.locatorlsatname)).sendKeys(lastname);
		Thread.sleep(1000);
		
		driver.findElement(By.id(Elements_Doctors.locatormobile)).sendKeys(mobile);
		Thread.sleep(1000);
		
		driver.findElement(By.id(Elements_Doctors.locatoremail)).sendKeys(email);
		Thread.sleep(1000);
		
		driver.findElement(By.id(Elements_Doctors.locatorproblem)).sendKeys(problem);
		Thread.sleep(1000);
		
		driver.findElement(By.id(Elements_Doctors.locatorsave)).click();	
		
		Browser.waitFortheElementXpath(Elements_Doctors.backgoundcolor);
	 }


public void CheckPatientScreenSearchFunctionality(String firstname,String lastname,String mobile,String email) throws Exception{
	
	driver.findElement(By.id(Elements_Doctors.patienticonid)).click();
	Thread.sleep(10000);
	driver.findElement(By.name("all")).click();
	Thread.sleep(2000);
	String fullname=firstname+" "+lastname;
	 String topping[]=new String[3];
	 topping[0]=fullname;
	 topping[1]=mobile;
	 topping[2]=email;
	 for(int i=0;i<=topping.length-1;i++){
		 driver.findElement(By.id(Elements_Doctors.patientsearchbox)).clear();
		 Thread.sleep(1000);
		 driver.findElement(By.id(Elements_Doctors.patientsearchbox)).sendKeys(topping[i]);	 
		 driver.findElement(By.id(Elements_Doctors.patientsearchbox)).sendKeys(Keys.ENTER);
		 Thread.sleep(3000);
		String name= driver.findElement(By.xpath(".//*[@id='all']/div[1]/div[1]/div[2]/div/h1/span")).getText();
		String schedule=driver.findElement(By.xpath("//*[@id='all']/div[1]/div[2]/p[1]")).getText();
		if(name.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Scheduled")){
			System.out.println("Appointment Created User Had Available");
		}else{
			System.out.println("Appointment Created User Not Available");
		}
	 }
}

 public void DoctorAppointmentBookingForToday(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
	 
	 driver.findElement(By.id(Elements_Doctors.doctortab)) .click();
	 driver.findElement(By.xpath(Elements_Doctors.todaymenu)).click();
	 driver.findElement(By.xpath(Elements_Doctors.morning)).click();
     Thread.sleep(1000);
	 driver.findElement(By.xpath(Elements_Doctors.noon)).click();
     Thread.sleep(1000);
	 driver.findElement(By.xpath(Elements_Doctors.evening)).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath(Elements_Doctors.eveningfirstcell)).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath(Elements_Doctors.locatorfirstname)).sendKeys(firstname);
	 Thread.sleep(1000);
	 driver.findElement(By.id(Elements_Doctors.locatorlsatname)).sendKeys(lastname);
	 Thread.sleep(1000);
	 driver.findElement(By.id(Elements_Doctors.locatormobile)).sendKeys(mobile);
	 Thread.sleep(1000);
	 driver.findElement(By.id(Elements_Doctors.locatoremail)).sendKeys(email);
	 Thread.sleep(1000);
	 driver.findElement(By.id(Elements_Doctors.locatorproblem)).sendKeys(problem);
	 Thread.sleep(1000);
	 driver.findElement(By.id(Elements_Doctors.locatorsave)).click();	
	 Browser.waitFortheElementXpath(Elements_Doctors.backgoundcolor);
	 String fullname=firstname+" "+lastname;
	 Browser.CheckNotificationMessage("Appointment is confirmed. Patient Name:"+fullname); 
 }

public void CheckPateintScreenForCheckInFunctionality(String firstname,String lastname,String email) throws InterruptedException{
	driver.findElement(By.id(Elements_Doctors.patienticonid)).click();
	Thread.sleep(10000);
	driver.findElement(By.name(Elements_Doctors.patientallmenuname)).click();
	Thread.sleep(2000);
	 driver.findElement(By.id(Elements_Doctors.patientsearchbox)).sendKeys(email);	 
	 driver.findElement(By.id(Elements_Doctors.patientsearchbox)).sendKeys(Keys.ENTER);
	 String fullname=firstname+" "+lastname;
	 Thread.sleep(3000);
	 String name= driver.findElement(By.xpath(".//*[@id='all']/div[1]/div[1]/div[2]/div/h1/span")).getText();
	 String schedule=driver.findElement(By.xpath("//*[@id='all']/div[1]/div[2]/p[1]")).getText();
		if(name.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Scheduled")){
			driver.findElement(By.xpath("//*[@id='all']/div[1]/div[2]/p[1]")).click();
			Thread.sleep(5000);
		}
		}


public void VerifyCheckINFunctionality() throws Exception{
	
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
	Browser.CheckNotificationMessage("Appointment checked out successfully");
	System.out.print("Clicked on Checkout");
	System.out.println("Check-In Scheduled/Rescheduled Sucessfull");
			
}

	public void CheckingFollowUpFunctionality(String firstname,String lastname) throws Exception{
	
	driver.findElement(By.xpath("//button[text()='Follow Up']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath(Elements_Doctors.tommorrowmenu)).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(Elements_Doctors.morning)).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(Elements_Doctors.noon)).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(Elements_Doctors.evening)).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(Elements_Doctors.eveningfirstcell)).click();
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.locatorproblem)).sendKeys("Diabetic");
	Thread.sleep(1000);
	driver.findElement(By.id("saveFollowUpAppiontment")).click();
	Browser.waitFortheElementXpath(Elements_Doctors.backgoundcolor);
	String fullname=firstname+" "+lastname;
	Browser.CheckNotificationMessage("Follow Up Appointment is confirmed. Patient Name:"+fullname);
	
		}
	
	
	public void CheckAppointmentBySelectingDateFromCalendar(String firstname,String lastname) throws Exception{
		driver.findElement(By.id("dashBoard")).click();
		LoadProp.isElementPresnt(driver, "//a[@class='monthly-day monthly-day-event monthly-today']", 20).click();
		String date=driver.findElement(By.xpath("//a[@class='monthly-day monthly-day-event monthly-today']")).getText();
		System.out.println(date);
		String fullname=firstname+" "+lastname;
		driver.findElement(By.xpath("//*[@id='mycalendar']/div[3]/a["+date+"+1]/div[1]")).click();
		Thread.sleep(3000);
		String name=driver.findElement(By.xpath("//*[@id='scrolls']/div/div[1]/div[2]/span")).getText();
		if(name.equalsIgnoreCase(fullname))
		{	
			
		driver.findElement(By.xpath("//*[@id='scrolls']/div/div[1]/div[2]/span")).click();	
		System.out.println("Created Appointment is Available");
		Thread.sleep(3000);
		}

		else
		{	
			
		Assert.fail("Appointment For the selected User Not Available");

		}
		}
	
	
	public void CheckAppointmentsCountinDashboardForToday() throws Exception{
		driver.findElement(By.id("dashBoard")).click();
		Thread.sleep(3000);
		int appointmentsavailable=driver.findElements(By.xpath("//*[@id='scrolls']/div/div")).size();
		System.out.println(appointmentsavailable);
		String count=driver.findElement(By.xpath("//*[@id='sp-dashboard-content']/div[2]/div[5]/div[1]/div[1]/div")).getText();
		if(count.equalsIgnoreCase(Integer.toString(appointmentsavailable))){
			System.out.println("Appointment Count for Today is"+appointmentsavailable+"Sucessfully Verified");
		}else{
			
			Assert.fail("Appointment Count Verification for Today is UnSucess");
		}
	}

}//main class

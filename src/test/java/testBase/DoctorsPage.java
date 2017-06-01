package testBase;



import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
		Browser.waitFortheID("emailAddress");	
		driver.findElement(By.id(Elements_Doctors.username)).sendKeys(username);
		driver.findElement(By.id(Elements_Doctors.password)).sendKeys(password);	
		driver.findElement(By.xpath(Elements_Doctors.loginbutton)).click();			
		Browser.waitFortheID(Elements_Doctors.schedule);
	}
	
	/*
	 * Author: Sagar Sen
	 * @ Description: This method will click schedule from ribbon panel and home visit tab
	 * @ Params:
	 * @ Returns:
	 */
	public void goToScheduleHomeVisit()
	{
		Browser.waitFortheID(Elements_Doctors.schedule);
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Browser.waitforTextbyxpath("(//div[@class='day-title'])[1]", "Consultation");
		driver.findElement(By.xpath("(//div[@class='day-title'])[4]")).click();
		Browser.waitFortheElementXpath("//i[@class='fa fa-home']");
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
		driver.findElement(By.id(Elements_Doctors.clickoncheckinbutton)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.clickonstartconsulationbutton)).click();				
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.diagnosis)).sendKeys("Diagonis Details");
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.saveproblems)).click();
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


		public void ClickView() throws Exception{
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Doctors.clickonview)).click();
			Thread.sleep(5000);
		}
		
		public void ClickonAlertmenu(){
			driver.findElement(By.id("alerts")).click();
			WebDriverWait wait=new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='provider-alerts-cardholder']")));
		}
		
		public String  getappointmentid() throws Exception{
			
			String AppointmentId=driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[1]/div[2]/div/div/div[1]/div/span")).getText();
			System.out.println(AppointmentId);
			driver.findElement(By.id("backbtn")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='cd-1']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='patient-apmt-tabs']/li[1]/div/center")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='patient-apmt-tabs']/li[2]/div/center")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='patient-apmt-tabs']/li[3]/div/center")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='tab-3']/ul/li[1]/div[2]")).click();
			
			return AppointmentId;
		}
		
		public void CheckAlerts() throws Exception {
			
		String name=driver.findElement(By.xpath(Elements_Doctors.getfullnameonclickviewmenu)).getText();
		System.out.println(name);	
		String	AppointmentId=driver.findElement(By.xpath(Elements_Doctors.getappointmentid)).getText();
			System.out.println(AppointmentId);
			driver.findElement(By.id(Elements_Doctors.clickonalertmenu)).click();
			Thread.sleep(10000);
		String Alert=driver.findElement(By.xpath("//*[@id='message' and contains(.,'"+name+"')]")).getText();
		System.out.println(Alert);
		Assert.assertTrue(Alert.contains(AppointmentId));
		Thread.sleep(1000);
		Assert.assertTrue(Alert.contains("has been booked"));
		
			
		}


	public void Cancel(String firstname,String lastname,String mobile,String email,String problem) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Doctors.clickoncancelmenu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Doctors.selectcancelreason)).sendKeys("Personal reason");
		driver.findElement(By.id(Elements_Doctors.cancelconfirmation)).click();
		Browser.CheckNotificationMessage("Appointment has been Cancelled");
		Thread.sleep(5000);
	}
		
	public void CheckCancelAppointmentInPatientScreen(String firstname,String lastname,String email) throws Exception	{
		driver.findElement(By.id(Elements_Doctors.patienticonid)).click();
		Thread.sleep(5000);
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
		Thread.sleep(5000);
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
		driver.findElement(By.xpath(Elements_Doctors.clickonellipse)).click();
		}


	public void ClickingOnDashboard(){
	driver.findElement(By.id(Elements_Doctors.clickondashboardmenu)).click();	
	WebDriverWait wait=new WebDriverWait(driver,100);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Elements_Doctors.getappointlistingtext)));
	}



	public void dashboardAppointmentListing(String firstname,String lastname){
	String listingavailable=driver.findElement(By.xpath(Elements_Doctors.getappointlistingtext)).getText();
	System.out.println("Listing Name:" +listingavailable );
	if(listingavailable.equalsIgnoreCase("Appointments Listing")){
	int appointmentlisting= driver.findElements(By.xpath(Elements_Doctors.getappointmentlistingsize)).size();
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
		driver.findElement(By.id(Elements_Doctors.doctortab)).click();	
		driver.findElement(By.xpath(Elements_Doctors.todaymenu)).click();
		driver.findElement(By.xpath(Elements_Doctors.morning)).click();
		driver.findElement(By.xpath(Elements_Doctors.noon)).click();
		driver.findElement(By.xpath(Elements_Doctors.evening)).click();
		int slotsize = driver.findElements(By.xpath(Elements_Doctors.eveningfirstcellsize)).size();
		 if(slotsize>0)
		 {
		for( slotsize=1;slotsize<=6; slotsize++) {						
		 WebElement  elementtoclick= driver.findElement(By.xpath("//*[@id='tab-3']/ul/li["+slotsize+"]/div[2]"));
		 ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+ elementtoclick.getLocation().x+")");
		 elementtoclick.click();
		Thread.sleep(1000);	 
		driver.findElement(By.xpath(Elements_Doctors.locatorfirstname)).sendKeys("Anji");
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Doctors.locatorlsatname)).sendKeys("R");
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.locatormobile)).sendKeys("9988664422");
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Doctors.locatoremail)).sendKeys("anji@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Doctors.locatorproblem)).sendKeys("diabetic");
		Thread.sleep(1000);	
		driver.findElement(By.id(Elements_Doctors.locatorsave)).click();	
		Browser.waitFortheElementXpath("//*[@id='tab-3']/ul/li["+slotsize+"][@class='bg-red']");
		Thread.sleep(1000);
		
		}//For Loop
			 
		 }//if loop slotsize
		 
		}



		public void CheckShowMore() throws InterruptedException{	
		Thread.sleep(3000);
		System.out.println(driver.manage().window().getSize());
		Dimension d= new Dimension(1920, 1080);
		driver.manage().window().setSize(d);		
		Thread.sleep(5000);		        	
		if(driver.findElements(By.id(Elements_Doctors.showmorebutton)).isEmpty()){
		Assert.fail("Show More Button is not avaiable");		
		}	
		else{
		driver.findElement(By.id(Elements_Doctors.showmorebutton)).click();
		System.out.println("show More Button is present");
		System.out.println("show More Button is Clicked");
		Thread.sleep(2000);	  		
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		Thread.sleep(2000);
		System.out.println("Scroll Button is Available");
		driver.findElement(By.id(Elements_Doctors.showlessbutton)).click();
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
		Thread.sleep(2000);
		 Browser.actionbyXpath(".//*[@id='areaOfSpecialisations']/div[2]/span/span[1]/span/ul", "Ayurvedic");
		 Browser.actionbyXpath(".//*[@id='lineOfPractice']/div[2]/span/span[1]/span/ul", "Homeopathy");
		Thread.sleep(2000);		 
        driver.findElement(By.id("aboutField")).clear();
        driver.findElement(By.id("aboutField")).sendKeys("Hi I am Rajasekhar I had 11 years of Experience in Dental");
		driver.findElement(By.id("saveAboutInfo")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='myTabs']/li[2]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("editProfileAwards")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("membership")).clear();
		driver.findElement(By.id("membership")).sendKeys("World Health Organisation");
		Thread.sleep(1000);
		driver.findElement(By.id("certifications")).clear();
		driver.findElement(By.id("certifications")).sendKeys("Cisco");
		Thread.sleep(2000);
		driver.findElement(By.id("saveAwards")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='myTabs']/li[3]/a/span[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("online")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("cheque")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("debitCard")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("creditCard")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("cash")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("doctor_edit_save")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='myTabs']/li[4]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("editAddInfo")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("website")).clear();
		driver.findElement(By.id("website")).sendKeys("www.zoylo.com");
		Thread.sleep(1000);
		driver.findElement(By.id("journals")).clear();
		driver.findElement(By.id("journals")).sendKeys("https://www.omicsonline.org/open-access-journals-list.php");
		Thread.sleep(1000);
		driver.findElement(By.id("books")).clear();
		driver.findElement(By.id("books")).sendKeys("APJ Adbul Kalam");
		Thread.sleep(1000);
		driver.findElement(By.id("saveAddInfo")).click();
		Thread.sleep(3000);
		}
		
		/*
		 * Author: Sagar Sen
		 * Description: This method will set the vacation for a doctor
		 * Param:
		 * Return:
		 */
		public void setVacation() throws InterruptedException
		{
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
			//Set vacation
			driver.findElement(By.id(Elements_Doctors.setVacation)).click();
			//Pop up handler
			String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
			String subWindowHandler = null;
			Set<String> handles = driver.getWindowHandles(); // get all window handles
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext())
			{
			    subWindowHandler = iterator.next();
			}
			driver.switchTo().window(subWindowHandler); // switch to popup window
			Thread.sleep(1000);                         // perform operations on popup
			driver.findElement(By.id(Elements_Doctors.addVacationSlot)).click();
			Thread.sleep(2000);
			Browser.actionbyXpath(Elements_Doctors.vacationStart, date);
			Thread.sleep(2000);
			Browser.actionbyXpath(Elements_Doctors.vacationEnd, date);
			Thread.sleep(2000);
			driver.findElement(By.id(Elements_Doctors.vacationActive)).click();
			driver.findElement(By.id(Elements_Doctors.vacationSave)).click();
			driver.switchTo().window(parentWindowHandler);  // switch back to parent window
			Browser.CheckNotificationMessage("Your vacation successfully updated");
		}
		
		/*
		 * Author: Sagar Sen
		 * Description: This method will check the addition of break times for a doctor
		 * Param: start time and end time
		 * Return:
		 */
		public void checkAddBreakTimes(String strtTime, String endTime)
		{
			//Click Sunday break time
			driver.findElement(By.xpath(Elements_Doctors.sunToggle)).click(); //toggle
			driver.findElement(By.id(Elements_Doctors.sunStrtTime)).clear();
			driver.findElement(By.id(Elements_Doctors.sunEndTime)).clear();
			driver.findElement(By.id(Elements_Doctors.sunStrtTime)).sendKeys(strtTime);
			driver.findElement(By.id(Elements_Doctors.sunEndTime)).sendKeys(endTime);
			driver.findElement(By.xpath(Elements_Doctors.submitSchedule)).click();
		}
		
		/*
		 * Author: Sagar Sen
		 * Description: This method will remove the break times for a doctor
		 * Param: start time and end time
		 * Return:
		 */
		public void checkremoveBreakTimes()
		{
			//Click saturday break time
			driver.findElement(By.id(Elements_Doctors.sunStrtTime)).clear();
			driver.findElement(By.id(Elements_Doctors.sunEndTime)).clear();
			driver.findElement(By.xpath(Elements_Doctors.sunToggle)).click(); //toggle
			driver.findElement(By.xpath(Elements_Doctors.submitSchedule)).click();
			Browser.CheckNotificationMessage("Schedule Updated Successfully");
		}
		
		/*
		 * Author: Sagar Sen
		 * Description: This method will add the clinic work times for a doctor
		 * Param: start time and end time
		 * Return:
		 */
		public void addClinicWorkTimings(String strtTime, String endTime) throws Exception
		{
			driver.findElement(By.xpath(Elements_Doctors.clinicTab)).click();
			Browser.waitFortheID(Elements_Doctors.clinicName);
			driver.findElement(By.id(Elements_Doctors.sundayTab)).click(); //Click on Sunday
			driver.findElement(By.id(Elements_Doctors.AddWorkTime)).click(); //Add sat clinic slot
			
			try {
				if(driver.findElements(By.id("1")).size()!=0)
				{
					driver.findElement(By.id("1")).click();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Two slot tabs did not open");
			}
			
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Doctors.sundayToggle)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Doctors.WstrtTime)).sendKeys(strtTime);
			driver.findElement(By.xpath(Elements_Doctors.WendTime)).sendKeys(endTime);
			driver.findElement(By.xpath(Elements_Doctors.clinicSubmitTimeSlots)).click(); //Save
			Browser.CheckNotificationMessage("Schedule Updated Successfully");
		}
		
		/*
		 * Author: Sagar Sen
		 * Description: This method will update the clinic work times for a doctor
		 * Param: start time and end time
		 * Return:
		 */
		public void updateClinicWorkTimings(String updtstrtTime, String updtendTime) throws Exception
		{
			driver.findElement(By.xpath(Elements_Doctors.clinicTab)).click();
			Browser.waitFortheID(Elements_Doctors.clinicName);
			driver.findElement(By.id(Elements_Doctors.sundayTab)).click(); //Click on Sunday
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Doctors.WstrtTime)).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Doctors.WstrtTime)).sendKeys(updtstrtTime);
			driver.findElement(By.xpath(Elements_Doctors.WendTime)).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Doctors.WendTime)).sendKeys(updtendTime);
			driver.findElement(By.xpath(Elements_Doctors.clinicSubmitTimeSlots)).click(); //Save
			Browser.CheckNotificationMessage("Schedule Updated Successfully");
		}
		
		/*
		 * Author: Sagar Sen
		 * Description: This method will remove the clinic work times for a doctor
		 * Param: 
		 * Return:
		 */
		public void removeClinicWorkTimings() throws Exception
		{
			Thread.sleep(2000);
			driver.findElement(By.id("0")).click();
			//driver.findElement(By.id("1")).click();
			driver.findElement(By.xpath(Elements_Doctors.clinicSubmitTimeSlots)).click(); //Save
			Browser.CheckNotificationMessage("Schedule Updated Successfully");
		}
		
		/*
		 * Author: Sagar Sen
		 * Description: This method will cancel the vacation for a doctor
		 * Param:
		 * Return:
		 */
		public void cancelVacation() throws Exception
		{
			//Set vacation
			driver.findElement(By.id(Elements_Doctors.setVacation)).click();
			//Pop up handler
			String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
			String subWindowHandler = null;
			Set<String> handles = driver.getWindowHandles(); // get all window handles
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext())
			{
			    subWindowHandler = iterator.next();
			}
			driver.switchTo().window(subWindowHandler); // switch to popup window
			Thread.sleep(1000);                         // perform operations on popup
			driver.findElement(By.id(Elements_Doctors.vacationActive)).click();
			Thread.sleep(1000); 
			driver.findElement(By.xpath(Elements_Doctors.removeVacationSlot)).click();
			driver.findElement(By.id(Elements_Doctors.vacationSave)).click();
			driver.switchTo().window(parentWindowHandler);  // switch back to parent window
			Browser.CheckNotificationMessage("Your vacation successfully updated");
		}
		
		/*
		 * Author: Ch.Lakshmi Kanth
		 * Description: This method will Create Work Timings for doctor in Hospiatl Tab
		 * Param:
		 * Return:
		 */
		public void DoctorsHospitalAddWorkTimings(String starttime, String endtime) throws Exception{
			 driver.findElement(By.xpath(Elements_Doctors.ClickOnHospitalTab)).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath(Elements_Doctors.HospitalClickAddWorkTimingsButton)).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath(Elements_Doctors.HospitalClickOnToggle)).click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath(Elements_Doctors.HospitalStarttime)).clear();
			 driver.findElement(By.xpath(Elements_Doctors.HospitalStarttime)).sendKeys(starttime);
			 Thread.sleep(2000);
			 driver.findElement(By.xpath(Elements_Doctors.HospitalEndTime)).clear();
			 driver.findElement(By.xpath(Elements_Doctors.HospitalEndTime)).sendKeys(endtime);
			 Thread.sleep(1000);
			 driver.findElement(By.xpath(Elements_Doctors.HospitalSaveWorkTimings)).click();
			 //Browser.CheckNotificationMessage("Schedule Updated Successfully");
			 Thread.sleep(2000);
			
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
	   driver.findElement(By.id(Elements_Doctors.doctortab)).click();
	   Thread.sleep(3000);
	   driver.findElement(By.xpath(Elements_Doctors.clickonbulkcancelbutton)).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath(Elements_Doctors.cancelfromdate)).sendKeys(date);
	   Thread.sleep(3000);
	   driver.findElement(By.xpath(Elements_Doctors.canceltodate)).sendKeys(enddate);
	   Thread.sleep(3000);
	   driver.findElement(By.xpath(Elements_Doctors.cancelfromtime)).click();
	   driver.findElement(By.xpath(Elements_Doctors.cancelfromtime)).sendKeys("07:00");
	   Thread.sleep(2000);
	   driver.findElement(By.xpath(Elements_Doctors.canceltotime)).sendKeys("23:00");
	   Thread.sleep(2000);
	   driver.findElement(By.id(Elements_Doctors.submitbulkcancel)).click();
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
		String name= driver.findElement(By.xpath(Elements_Doctors.patientgetfullname)).getText();
		String schedule=driver.findElement(By.xpath(Elements_Doctors.patientgetstatus)).getText();
		if(name.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Scheduled")){
			System.out.println("Appointment Created User Had Available");
		}else{
			System.out.println("Appointment Created User Not Available");
		}
	 }
}

 public void DoctorAppointmentBookingForToday(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
	 
	 driver.findElement(By.id(Elements_Doctors.doctortab)) .click();
	 Browser.waitFortheElementXpath(Elements_Doctors.todaymenu);
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
 
 /*
  * @ Author: Sagar Sen
  * @ Description: This method will book appointment for sunday based on test case ZOY-811
  * @ Param: firstname, lastname, mobile, email, problem
  * @ Return:
  */
public void DoctorAppointmentBookingForSunday(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
	 
	 driver.findElement(By.id(Elements_Doctors.doctortab)) .click();
	 Browser.waitFortheElementXpath(Elements_Doctors.sundayMenu);
	 driver.findElement(By.xpath(Elements_Doctors.sundayMenu)).click();
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

/*
 * @ Author: Sagar Sen
 * @ Description: This method will edit the default clinic address in scheule
 * @ Param: AddressLine One, locality, pincode
 * @ Return:
 */
public void editScheduleDefaultClinicAddress(String addLineOne, String Locality, String pinCode)
{
	driver.findElement(By.id(Elements_Doctors.schedule)).click();
	Browser.waitforTextbyxpath("(//div[@class='day-title'])[1]", "Consultation");
	driver.findElement(By.xpath(Elements_Doctors.clinicTab)).click();
	Browser.waitFortheElementXpath(Elements_Doctors.addressTab);
	driver.findElement(By.xpath(Elements_Doctors.addressTab)).click();
	driver.findElement(By.id(Elements_Doctors.addressEditButton)).click(); //Click on edit
	driver.findElement(By.id(Elements_Doctors.addLineOne)).clear(); //Add line one
	driver.findElement(By.id(Elements_Doctors.addLineOne)).sendKeys(addLineOne);
	driver.findElement(By.id(Elements_Doctors.locality)).clear(); //Locality
	driver.findElement(By.id(Elements_Doctors.locality)).sendKeys(Locality);
	driver.findElement(By.id(Elements_Doctors.pincode)).clear(); //pincode
	driver.findElement(By.id(Elements_Doctors.pincode)).sendKeys(pinCode);
	Browser.scrollbyID(Elements_Doctors.addSave); //Scroll to save
	driver.findElement(By.id(Elements_Doctors.addSave)).click();
	Browser.CheckNotificationMessage("Address Updated Successfully");
}

/*
* @ Author: Sagar Sen
* @ Description: This method will edit the default clinic aminities and services in scheule
* @ Param: serviceName
* @ Return:
*/
public void editScheduleaminitiesServices(String serviceName) throws Exception
{
	driver.findElement(By.id(Elements_Doctors.schedule)).click();
	Browser.waitforTextbyxpath("(//div[@class='day-title'])[1]", "Consultation");
	driver.findElement(By.xpath(Elements_Doctors.clinicTab)).click();
	Browser.waitFortheElementXpath(Elements_Doctors.aminitiesTab);
	driver.findElement(By.xpath(Elements_Doctors.aminitiesTab)).click();
	driver.findElement(By.id(Elements_Doctors.aminitiesAmbulance)).click();
	driver.findElement(By.id(Elements_Doctors.aminitiesSave)).click();
	Browser.CheckNotificationMessage("Amenities Updated Successfully");
	Thread.sleep(5000);
	driver.findElement(By.xpath(Elements_Doctors.servicesTab)).click();
	driver.findElement(By.id(Elements_Doctors.addServices)).click();
	driver.findElement(By.xpath(Elements_Doctors.servicesText)).sendKeys(serviceName);
	driver.findElement(By.id(Elements_Doctors.serviceSave)).click();
	Browser.CheckNotificationMessage("Services Updated Successfully");
	Thread.sleep(5000);
	driver.findElement(By.id(Elements_Doctors.removeService)).click();
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.serviceSave)).click();
	Browser.CheckNotificationMessage("Services Updated Successfully");
}

/*
 * @ Author: Sagar Sen
 * @ Description: This method will check slot deletion conflic message based on test case ZOY-811
 * @ Param: 
 * @ Return:
 */
public void checkWorkDeletionConflict()
{
	driver.findElement(By.id(Elements_Doctors.schedule)).click();
	driver.findElement(By.xpath(Elements_Doctors.clinicTab)).click();
	Browser.waitFortheID(Elements_Doctors.clinicName);
	driver.findElement(By.id(Elements_Doctors.sundayTab)).click();
	driver.findElement(By.id("0")).click();
	Browser.waitforTextbyxpath("//div[@class='zy-status-wrapper']", "Conflicts");
}

/*
 * @ Author: Sagar Sen
 * @ Description: This method will cancel the appointment booked by using DoctorAppointmentBookingForSunday() menthod
 * @ Param: 
 * @ Return:
 */
public void cancelSundayAppt() throws InterruptedException
{
	driver.findElement(By.id(Elements_Doctors.doctortab)) .click();
	Browser.waitFortheElementXpath(Elements_Doctors.sundayMenu);
	driver.findElement(By.xpath(Elements_Doctors.sundayMenu)).click();
	driver.findElement(By.xpath(Elements_Doctors.evening)).click();
	driver.findElement(By.xpath("//div[@class='patient-apt-uname']")).click();
	Thread.sleep(2000);
	driver.findElement(By.id(Elements_Doctors.clickoncancelmenu)).click();
	String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
	String subWindowHandler = null;
	Set<String> handles = driver.getWindowHandles(); // get all window handles
	Iterator<String> iterator = handles.iterator();
	while (iterator.hasNext()) {
		subWindowHandler = iterator.next();
	}
	driver.switchTo().window(subWindowHandler); // switch to popup window
	Thread.sleep(2000); // perform operations on popup
	Browser.waitFortheElementXpath("(//div[contains(., 'Reason of cancellation')])[4]");
	Browser.selectbyXpath("//div[@class='res-slec']//select", "Attending an emergency");
	driver.findElement(By.id(Elements_Doctors.cancelconfirmation)).click();
	driver.switchTo().window(parentWindowHandler); // switch back to
													// parent window
	Browser.CheckNotificationMessage("Appointment has been Cancelled");
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
	 String name= driver.findElement(By.xpath(Elements_Doctors.patientgetfullname)).getText();
	 String schedule=driver.findElement(By.xpath(Elements_Doctors.patientgetstatus)).getText();
		if(name.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Scheduled")){
			driver.findElement(By.xpath(Elements_Doctors.patientgetstatus)).click();
			Thread.sleep(5000);
		}
		}


public void VerifyCheckINFunctionality() throws Exception{
	
	driver.findElement(By.id(Elements_Doctors.clickoncheckinbutton)).click();
	Thread.sleep(1000);
	Reporter.log("Clicked on CheckIn button");
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.clickonstartconsulationbutton)).click();
	Thread.sleep(1000);
	Reporter.log("Clicked on Start Consultation Button");
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.prognosis)).sendKeys("Normal");
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.diagnosis)).sendKeys("Done");
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.saveproblems)).click();
	Thread.sleep(1000);
	Reporter.log("Problems Saved");
	driver.findElement(By.id(Elements_Doctors.height)).sendKeys("5");
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.heightinches)).sendKeys("9");
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.weight)).sendKeys("83");
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.savevitals)).click();
	Thread.sleep(1000);
	Reporter.log("Vital Details Saved");
	driver.findElement(By.id(Elements_Doctors.druginstructions)).sendKeys("Crocin");
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.strenght)).sendKeys("2");
	Thread.sleep(1000);
	driver.findElement(By.xpath(Elements_Doctors.medicinetime)).click();
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.saveprescription)).click();
	Thread.sleep(1000);
	Reporter.log("Prescription Details Saved");
	driver.findElement(By.id(Elements_Doctors.consultationnotes)).sendKeys("Normal");
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.savenotes)).click();
	Reporter.log("Consultation Notes Saved");
	System.out.println("Consultation Notes Saved");
	Thread.sleep(3000);
	driver.findElement(By.id(Elements_Doctors.generatereciept)).click();
	Thread.sleep(2000);
	System.out.println("generateReceipt");
	Reporter.log("Clicked on generateReceipt");
	driver.findElement(By.xpath(Elements_Doctors.clickonrecieptdownload)).click();		
	System.out.println("click on the download Receipt icon");		
	Reporter.log("click on the download Receipt icon");
	Thread.sleep(5000);
	driver.findElement(By.xpath(Elements_Doctors.selectreciepttodownload)).click();		
	Thread.sleep(10000);
	driver.findElement(By.xpath(Elements_Doctors.clickonprescription)).click();	
	Thread.sleep(5000);
	driver.findElement(By.xpath(Elements_Doctors.selectprescription)).click();		
	Thread.sleep(5000);
	driver.findElement(By.xpath(Elements_Doctors.selectemailno)).click();		
	Thread.sleep(5000);
	driver.findElement(By.id(Elements_Doctors.clickoncheckoutbutton)).click();
	Browser.CheckNotificationMessage("Appointment checked out successfully");
	System.out.print("Clicked on Checkout");
	System.out.println("Check-In Scheduled/Rescheduled Sucessfull");
			
}

	public void CheckingFollowUpFunctionality(String firstname,String lastname) throws Exception{
	driver.findElement(By.xpath(Elements_Doctors.clickonfollowupbutton)).click();
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
	driver.findElement(By.id(Elements_Doctors.savefollowupappointment)).click();
	Browser.waitFortheElementXpath(Elements_Doctors.backgoundcolor);
	String fullname=firstname+" "+lastname;
	Browser.CheckNotificationMessage("Follow Up Appointment is confirmed. Patient Name:"+fullname);
	
		}
	
	
	public void CheckAppointmentBySelectingDateFromCalendar(String firstname,String lastname) throws Exception{
		driver.findElement(By.id(Elements_Doctors.clickondashboardmenu)).click();
		LoadProp.isElementPresnt(driver, "//a[@class='monthly-day monthly-day-event monthly-today']", 20).click();
		String date=driver.findElement(By.xpath(Elements_Doctors.selecttodaysdate)).getText();
		System.out.println(date);
		String fullname=firstname+" "+lastname;
		driver.findElement(By.xpath("//*[@id='mycalendar']/div[3]/a["+date+"+1]/div[1]")).click();
		Thread.sleep(3000);
		String name=driver.findElement(By.xpath(Elements_Doctors.dashboardfullname)).getText();
		if(name.equalsIgnoreCase(fullname))
		{	
		
		driver.findElement(By.xpath(Elements_Doctors.dashboardfullname)).click();	
		System.out.println("Created Appointment is Available");
		Thread.sleep(3000);
		}

		else
		{	
			
		Assert.fail("Appointment For the selected User Not Available");

		}
		}
	
	/*
	 * @ Author: Sagar Sen
	 * @ Description: This method will add a clinic in schedule for a doctor
	 * @ Pram: Other clinic Name, other clinic fee, other clinic mobile number
	 * @ Return:
	 */
	public void addclinicSchedule(String otherClnName, String otherfee, String othermob, String othrPin, String othrLon, String othrLat)
	{
		driver.findElement(By.id(Elements_Doctors.schedule)).click();
		Browser.waitforTextbyxpath("(//div[@class='day-title'])[1]", "Consultation");
		driver.findElement(By.xpath(Elements_Doctors.clinicTab)).click();
		Browser.waitFortheElementXpath(Elements_Doctors.addressTab);
		driver.findElement(By.id(Elements_Doctors.clickPlusMore)).click();
		driver.findElement(By.xpath(Elements_Doctors.addClinic)).click();
		Browser.waitFortheID(Elements_Doctors.popUpHeading);
		driver.findElement(By.id(Elements_Doctors.otherclinicName)).sendKeys(otherClnName);
		driver.findElement(By.id(Elements_Doctors.otherClinicFee)).sendKeys(otherfee);
		driver.findElement(By.id(Elements_Doctors.otherClinicMobile)).sendKeys(othermob);
		driver.findElement(By.id(Elements_Doctors.otherPincode)).sendKeys(othrPin);
		Browser.scrollbyID(Elements_Doctors.otherClinicSave);
		driver.findElement(By.id(Elements_Doctors.otherLon)).sendKeys(othrLon);
		driver.findElement(By.id(Elements_Doctors.otherLat)).sendKeys(othrLat);
		driver.findElement(By.id(Elements_Doctors.otherClinicSave)).click();
	}
	
	public void CheckAppointmentsCountinDashboardForToday() throws Exception{
		driver.findElement(By.id(Elements_Doctors.clickondashboardmenu)).click();
		Thread.sleep(3000);
		int appointmentsavailable=driver.findElements(By.xpath(Elements_Doctors.checktodayappointmentssize)).size();
		System.out.println(appointmentsavailable);
		String count=driver.findElement(By.xpath(Elements_Doctors.checktodayappointmentcountfromgraph)).getText();
		if(count.equalsIgnoreCase(Integer.toString(appointmentsavailable))){
			System.out.println("Appointment Count for Today is"+appointmentsavailable+"Sucessfully Verified");
		}else{
			
			Assert.fail("Appointment Count Verification for Today is UnSucess");
		}
	}

}//main class

package testBase;



import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import objectRepository.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;








public class DoctorsPage  {
	//FirefoxDriver browser = new FirefoxDriver();
	public    WebDriver driver;
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	

	public DoctorsPage(WebDriver driver) throws Exception {
		this.driver=driver;
		Browser= new TestUtils(driver); 
		admin= new NewAdminDoctorsPage(driver);
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
		driver.get("https://"+LoadPropMac.Environment_Name+".zoylo.com/providerAccount");
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
	// Click on recent Patient from dashboard
		public  void clickOnThePatientFromDashBoard(String slotTime) throws IOException, InterruptedException, ParseException{
			Thread.sleep(2000);
			DateFormat ModTime = new SimpleDateFormat("h:mm a");
			String PslotTime=ModTime.format(ModTime.parse(slotTime)).toLowerCase();
            System.out.println("Slot Time after modification"+PslotTime);
            
			if(driver.findElements(By.id("show-all-btn")).isEmpty()){
				System.out.println("is empty");
				Browser.waitFortheElementXpath("//div[@class='doctor-patientname patientfullName']/span");
				driver.findElement(By.xpath("//div[@class='timing' and contains(.,'"+PslotTime+"')]/following-sibling::div[1]")).click();  // Recent Appointment
				Browser.waitTill(60);
			}else{
				System.out.println("show all btn exisit");
				driver.findElement(By.id("show-all-btn")).click();
				Thread.sleep(2000);
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("scroll(0, 250)"); // if the element is on bottom.
				Thread.sleep(5000);
				//Browser.scrollbyxpath("//div[@class='timing' and contains(.,'"+PslotTime+"')]/following-sibling::div[1]");
				//Browser.waitFortheElementXpath("//div[@class='doctor-patientname patientfullName']/span");
				driver.findElement(By.xpath("//div[@class='timing' and contains(.,'"+PslotTime+"')]/following-sibling::div[1]")).click();  // Recent Appointment
				Browser.waitTill(60);

			}

		}

	// Doctors Checkin and check the recipient
		public  void doctorCheckinCheckOut() throws IOException, InterruptedException{
			Browser.clickOnTheElementByID(Elements_Doctors.patient_clickoncheckinbutton);
			Browser.clickOnTheElementByID(Elements_Doctors.patient_clickonstartconsulationbutton);			
			Browser.enterTextByID(Elements_Doctors.patient_diagnosis, "Doctor Details");
			Browser.clickOnTheElementByID(Elements_Doctors.patient_saveproblems);
			Browser.clickOnTheElementByID("saveVitals");
			Browser.clickOnTheElementByID("savePrescription");
			Browser.clickOnTheElementByID("saveNotes");
			Browser.clickOnTheElementByID("generateReceipt");
			Thread.sleep(10000);
			Browser.clickOnTheElementByID("checkOut");
			Thread.sleep(2000);
			Browser.verifyNotificationMessage("Appointment checked out successfully");
		}
	
	// Doctors Checkin and check the recipient
	public  void doctorCheckinCheckOut1() throws IOException, InterruptedException{			
		driver.findElement(By.id(Elements_Doctors.patient_clickoncheckinbutton)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.patient_clickonstartconsulationbutton)).click();				
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.patient_diagnosis)).sendKeys("Diagonis Details");
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.patient_saveproblems)).click();
		Thread.sleep(5000);
		driver.findElement(By.id("saveVitals")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("savePrescription")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("saveNotes")).click();				
		Thread.sleep(5000);
		driver.findElement(By.id("generateReceipt")).click();
		Thread.sleep(5000);
		//Browser.verifyNotificationMessage("Bill generated successfully");
		Thread.sleep(5000);
		driver.findElement(By.id("checkOut")).click();
		Thread.sleep(2000);
		Browser.verifyNotificationMessage("Appointment checked out successfully");
	}

	//DoctorAppointment  Reschedule
	public void reschedule(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		
		Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_changeicon);
//		WebDriverWait wait = new WebDriverWait(driver,1000);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.zy-status-wrapper")));
		Thread.sleep(5000);
		Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_nextmenu);
		Browser.waitFortheElementXpath(Elements_Doctors.appointment_morning);
		Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_morning);
		Browser.waitFortheElementXpath(Elements_Doctors.appointment_morningfirstcell);
		Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_morningfirstcell);
		Browser.waitFortheElementXpath(Elements_Doctors.appointment_changeslot);
		Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_changeslot);
		Thread.sleep(3000);
		//Browser.CheckNotificationMessage("Your appointment slot has been successfully CHANGED");
		
		}
	
	
		public void CheckPatientScreenForReschedule(String firstname,String lastname,String email) throws Exception{
		
		Browser.clickOnTheElementByID(Elements_Doctors.patient_id);
		WebDriverWait wait = new WebDriverWait(driver, 8000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("searchPatientsList")));
		Browser.enterTextByID(Elements_Doctors.patient_searchbox, email);
		driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.name(Elements_Doctors.patientallmenuname)).click();	
		Thread.sleep(3000);
		String name=driver.findElement(By.xpath(Elements_Doctors.patient_alltabfullname)).getText();
		String schedule=driver.findElement(By.xpath(Elements_Doctors.patient_alltabschedule)).getText();
		String fullname=firstname+" "+lastname;
		if(name.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Rescheduled")){
			System.out.println("Appointment Rescheduled Is Sucessfully Verified");
		}else{
			Assert.fail();
		}
		}


		public void ClickView() throws Exception
		{
			Thread.sleep(3000);
			driver.findElement(By.xpath(Elements_Doctors.appointment_clickonview)).click();
			Browser.waitFortheID("about");
		}
		
		public void ClickonAlertmenu(){
			Browser.clickOnTheElementByID("alerts");
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
			
		String name=driver.findElement(By.xpath(Elements_Doctors.appointment_getfullnameonclickviewmenu)).getText();
		System.out.println(name);	
		String	AppointmentId=driver.findElement(By.xpath(Elements_Doctors.appointment_getappointmentid)).getText();
			System.out.println(AppointmentId);
			driver.findElement(By.id(Elements_Doctors.alert_clickonalertmenu)).click();
			Thread.sleep(10000);
		String Alert=driver.findElement(By.xpath("//*[@id='message' and contains(.,'"+name+"')]")).getText();
		System.out.println(Alert);
		Assert.assertTrue(Alert.contains(AppointmentId));
		Thread.sleep(1000);
		Assert.assertTrue(Alert.contains("has been booked"));
		
			
		}


	public void Cancel(String firstname,String lastname,String mobile,String email,String problem) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Doctors.appointment_clickoncancelmenu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Doctors.appointment_selectcancelreason)).sendKeys("Personal reason");
		driver.findElement(By.id(Elements_Doctors.appointment_cancelconfirmation)).click();
		
		
	}
		
	public void CheckCancelAppointmentInPatientScreen(String firstname,String lastname,String email) throws Exception	{
		driver.findElement(By.id(Elements_Doctors.patient_id)).click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(Elements_Doctors.patient_searchbox)));
		driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(email);
		driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(Keys.ENTER);
		driver.findElement(By.name(Elements_Doctors.patientallmenuname)).click();
		Thread.sleep(5000);
		String name=driver.findElement(By.xpath(Elements_Doctors.patient_alltabfullname)).getText();
		String status=driver.findElement(By.xpath(Elements_Doctors.patient_alltabschedule)).getText();
		String fullname=firstname+" "+lastname;
		if(name.equalsIgnoreCase(fullname)&&status.equalsIgnoreCase("Cancelled By Provider")){
			System.out.println("Appointment is Sucessfully Cancelled");
		}	
		else{
			System.out.println("Appointment is  Not Sucessfully Cancelled");
			Assert.fail("Appointment is  Not Sucessfully Cancelled");
		}
		}


	public void CheckPatientScreenSendNotificationOfAllTab(String firstname,String lastname,String email) throws Exception{
		driver.findElement(By.id(Elements_Doctors.patient_id)).click();
		Thread.sleep(5000);
		// Clicking on all Tab in Patient Screen  
		driver.findElement(By.xpath(Elements_Doctors.patient_alltab)).click();
		System.out.println("Clicked on all tab");
		Thread.sleep(3000);
		driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(email);	 
	 	driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(Keys.ENTER);
		String name=driver.findElement(By.xpath(Elements_Doctors.patient_alltabfullname)).getText();
		String schedule=driver.findElement(By.xpath(Elements_Doctors.patient_alltabschedule)).getText();
		String fullname=firstname+" "+lastname;
		if(name.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Scheduled")){
		driver.findElement(By.xpath(Elements_Doctors.patient_sendnotification)).click();
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
	driver.findElement(By.id(Elements_Doctors.dashboard_clickondashboardmenu)).click();	
	WebDriverWait wait=new WebDriverWait(driver,100);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Elements_Doctors.dashboard_getappointlistingtext)));
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
		driver.findElement(By.id("journals")).sendKeys("http://www.omicsonline.org/open-access-journals-list.php");
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
				Browser.CheckNotificationMessage("Your vacation updated successfully");
			
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
			Browser.scrollbyxpath(Elements_Doctors.sunToggle);
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
			//Click sunday break time
			Browser.scrollbyxpath(Elements_Doctors.sunToggle);
			driver.findElement(By.id(Elements_Doctors.sunStrtTime)).clear();
			driver.findElement(By.id(Elements_Doctors.sunEndTime)).clear();
			driver.findElement(By.xpath(Elements_Doctors.sunToggle)).click(); //toggle
			driver.findElement(By.xpath(Elements_Doctors.submitSchedule)).click();
			Browser.CheckNotificationMessage("Schedule updated successfully");
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
			Browser.CheckNotificationMessage("Clinic Time Slot Updated Successfully");
		}
		
		/*
		 * Author: Sagar Sen
		 * Description: This method will update the clinic work times for a doctor
		 * Param: start time and end time
		 * Return:
		 */
		public void updateClinicWorkTimings(String updtstrtTime, String updtendTime) throws Exception
		{
			Browser.waitFortheElementXpath(Elements_Doctors.clinicTab);
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
			Browser.CheckNotificationMessage("Clinic Time Slot Updated Successfully");
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
			driver.findElement(By.xpath(Elements_Doctors.clinicTimeSlotMinusBtn)).click();
			Browser.CheckNotificationMessage("Time Slot Deleted Successfully");
			Thread.sleep(6000);
			//driver.findElement(By.id("1")).click();
			driver.findElement(By.xpath(Elements_Doctors.clinicSubmitTimeSlots)).click(); //Save
			Browser.CheckNotificationMessage("Clinic Time Slot Updated Successfully");
			Thread.sleep(3000);
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
			Browser.CheckNotificationMessage("Your vacation updated successfully");
			Thread.sleep(3000);
		}
		
		/*
		 * Author: Ch.Lakshmi Kanth
		 * Description: This method will Create Work Timings for doctor in Hospiatl Tab
		 * Param:
		 * Return:
		 */
		public void DoctorsHospitalAddWorkTimings(String starttime, String endtime) throws Exception{
			 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_ClickOnHospitalTab)).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_ClickAddWorkTimingsButton)).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_ClickOnToggle)).click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_Starttime)).clear();
			 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_Starttime)).sendKeys(starttime);
			 Thread.sleep(2000);
			 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_EndTime)).clear();
			 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_EndTime)).sendKeys(endtime);
			 Thread.sleep(1000);
			 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings)).click();
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
		Browser.waitFortheID(Elements_Doctors.appointments_doctortab);
		Browser.clickOnTheElementByID(Elements_Doctors.appointments_doctortab);
		Browser.waitFortheElementXpath(Elements_Doctors.bulkcancel_clickonbulkcancelbutton);
		Browser.clickOnTheElementByXpath(Elements_Doctors.bulkcancel_clickonbulkcancelbutton);
		Browser.waitFortheElementXpath(Elements_Doctors.bulkcancel_fromdate);
		Browser.enterTextByXpath(Elements_Doctors.bulkcancel_fromdate, date);
		Browser.waitFortheElementXpath(Elements_Doctors.bulkcancel_todate);
		Browser.enterTextByXpath(Elements_Doctors.bulkcancel_todate, enddate);
		Browser.clickOnTheElementByXpath(Elements_Doctors.bulkcancel_fromtime);
		Browser.enterTextByXpath(Elements_Doctors.bulkcancel_fromtime, "07:00");
		Browser.enterTextByXpath(Elements_Doctors.bulkcancel_totime, "23:00");
		Browser.clickOnTheElementByID(Elements_Doctors.bulkcancel_submit);
		Thread.sleep(2000);
	  
			}

		
 public void DoctorsAppointmentforTomorrow(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
	 
	 
	 Browser.clickOnTheElementByID(Elements_Doctors.appointments_doctortab);
	 Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_tommorrowmenu);
	 Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_morning);
	 Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_noon);
	 Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_eveningtab);
	 Browser.clickOnTheElementByXpath("//*[@id='tab-3']/ul/li[1]/div[2]");
	 Browser.waitFortheElementXpath(Elements_Doctors.appointment_firstname);
	 Browser.enterTextByXpath(Elements_Doctors.appointment_firstname,firstname );
	 Browser.enterTextByID(Elements_Doctors.appointment_lsatname, lastname); 
	 Browser.enterTextByID(Elements_Doctors.appointment_mobile, mobile); 
	 Browser.enterTextByID(Elements_Doctors.appointment_email, email); 
	 Browser.enterTextByID(Elements_Doctors.appointment_problem, problem); 
	 Browser.clickOnTheElementByID(Elements_Doctors.appointment_save); 
	 Browser.waitFortheElementXpath(Elements_Doctors.appointment_backgoundcolor);
	 }


public void CheckPatientScreenSearchFunctionality(String firstname,String lastname,String mobile,String email) throws Exception{
	
	driver.findElement(By.id(Elements_Doctors.patient_id)).click();
	Thread.sleep(10000);
	driver.findElement(By.name("all")).click();
	Thread.sleep(2000);
	String fullname=firstname+" "+lastname;
	 String topping[]=new String[3];
	 topping[0]=fullname;
	 topping[1]=mobile;
	 topping[2]=email;
	 for(int i=0;i<=topping.length-1;i++){
		 driver.findElement(By.id(Elements_Doctors.patient_searchbox)).clear();
		 Browser.waitFortheID(Elements_Doctors.patient_searchbox);
		 driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(topping[i]);	 
		 driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(Keys.ENTER);
		 Browser.waitFortheElementXpath(Elements_Doctors.patient_getfullname);
		String name= driver.findElement(By.xpath(Elements_Doctors.patient_getfullname)).getText();
		String schedule=driver.findElement(By.xpath(Elements_Doctors.patient_getstatus)).getText();
		if(name.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Scheduled")){
			System.out.println("Appointment Created User Had Available");
		}else{
			System.out.println("Appointment Created User Not Available");
		}
	 }
}

 public void DoctorAppointmentBookingForToday(String firstname,String lastname,String mobile,String email,String problem) throws Exception
 {	 
	 driver.findElement(By.id(Elements_Doctors.appointments_doctortab)).click();
	 Browser.waitFortheElementXpath(Elements_Doctors.appointment_todaymenu);
	 driver.findElement(By.xpath(Elements_Doctors.appointment_todaymenu)).click();
	 driver.findElement(By.xpath(Elements_Doctors.appointment_morning)).click();
     Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_noon);
     Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_eveningtab);
	 Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_eveningfirstcell);
	 driver.findElement(By.xpath(Elements_Doctors.appointment_firstname)).sendKeys(firstname);
	 driver.findElement(By.id(Elements_Doctors.appointment_lsatname)).sendKeys(lastname);
	 Thread.sleep(1000);
	 driver.findElement(By.id(Elements_Doctors.appointment_mobile)).sendKeys(mobile);
	 driver.findElement(By.id(Elements_Doctors.appointment_email)).sendKeys(email);
	 driver.findElement(By.id(Elements_Doctors.appointment_problem)).sendKeys(problem);
	 Browser.clickOnTheElementByID(Elements_Doctors.appointment_save);	
	 Browser.waitFortheElementXpath(Elements_Doctors.appointment_backgoundcolor);
	 String fullname=firstname+" "+lastname;
	 Browser.CheckNotificationMessage("Appointment is confirmed. Patient Name: "+fullname);
 }
 
 public void DoctorAppointmentBookingForTodayEveSecondCell(String firstname,String lastname,String mobile,String email,String problem) throws Exception
 {	 
	 driver.findElement(By.id(Elements_Doctors.appointments_doctortab)).click();
	 Browser.waitFortheElementXpath(Elements_Doctors.appointment_todaymenu);
	 driver.findElement(By.xpath(Elements_Doctors.appointment_todaymenu)).click();
     Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_eveningtab);
	 Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_eveningSecondCell);
	 driver.findElement(By.xpath(Elements_Doctors.appointment_firstname)).sendKeys(firstname);
	 driver.findElement(By.id(Elements_Doctors.appointment_lsatname)).sendKeys(lastname);
	 Thread.sleep(1000);
	 driver.findElement(By.id(Elements_Doctors.appointment_mobile)).sendKeys(mobile);
	 driver.findElement(By.id(Elements_Doctors.appointment_email)).sendKeys(email);
	 driver.findElement(By.id(Elements_Doctors.appointment_problem)).sendKeys(problem);
	 Browser.clickOnTheElementByID(Elements_Doctors.appointment_save);	
	 //Browser.waitFortheElementXpath(Elements_Doctors.appointment_backgoundcolor);
	 String fullname=firstname+" "+lastname;
	 Browser.CheckNotificationMessage("Appointment is confirmed. Patient Name: "+fullname);
 }
 
 /*
  * @ Author: Sagar Sen
  * @ Description: This method will book appointment for sunday based on test case ZOY-811
  * @ Param: firstname, lastname, mobile, email, problem
  * @ Return:
  */
public void DoctorAppointmentBookingForSunday(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
	 
	 driver.findElement(By.id(Elements_Doctors.appointments_doctortab)) .click();
	 Browser.waitTill(1000);
	 Browser.waitFortheElementXpath(Elements_Doctors.appointment_sundayMenu);
	 driver.findElement(By.xpath(Elements_Doctors.appointment_sundayMenu)).click();
	 driver.findElement(By.xpath(Elements_Doctors.appointment_morning)).click();
     Thread.sleep(1000);
	 driver.findElement(By.xpath(Elements_Doctors.appointment_noon)).click();
     Thread.sleep(1000);
	 driver.findElement(By.xpath(Elements_Doctors.appointment_eveningtab)).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath(Elements_Doctors.appointment_eveningfirstcell)).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath(Elements_Doctors.appointment_firstname)).sendKeys(firstname);
	 Thread.sleep(1000);
	 driver.findElement(By.id(Elements_Doctors.appointment_lsatname)).sendKeys(lastname);
	 Thread.sleep(1000);
	 driver.findElement(By.id(Elements_Doctors.appointment_mobile)).sendKeys(mobile);
	 Thread.sleep(1000);
	 driver.findElement(By.id(Elements_Doctors.appointment_email)).sendKeys(email);
	 Thread.sleep(1000);
	 driver.findElement(By.id(Elements_Doctors.appointment_problem)).sendKeys(problem);
	 Thread.sleep(1000);
	 driver.findElement(By.id(Elements_Doctors.appointment_save)).click();	
	 Browser.waitFortheElementXpath(Elements_Doctors.appointment_backgoundcolor);
	 String fullname=firstname+" "+lastname;
	 Browser.CheckNotificationMessage("Appointment is confirmed. Patient Name: " +fullname); 
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
	Browser.waitFortheElementXpath(Elements_Doctors.clinicTab);
	driver.findElement(By.xpath(Elements_Doctors.clinicTab)).click();
	Browser.waitFortheID(Elements_Doctors.clinicName);
	driver.findElement(By.id(Elements_Doctors.sundayTab)).click();
	driver.findElement(By.xpath("//i[@class='fa fa-minus-circle clinc_rem_slot']")).click();
	Browser.waitforTextbyxpath("//div[@class='zy-status-wrapper']", "Conflict");
}

/*
 * @ Author: Sagar Sen
 * @ Description: This method will cancel the appointment booked by using DoctorAppointmentBookingForSunday() menthod
 * @ Param: 
 * @ Return:
 */
public void cancelSundayAppt() throws InterruptedException
{
	driver.findElement(By.id(Elements_Doctors.appointments_doctortab)) .click();
	Thread.sleep(1000);
	Browser.waitFortheElementXpath(Elements_Doctors.appointment_sundayMenu);
	driver.findElement(By.xpath(Elements_Doctors.appointment_sundayMenu)).click();
	driver.findElement(By.xpath(Elements_Doctors.appointment_eveningtab)).click();
	driver.findElement(By.xpath("//div[@class='patient-apt-uname']")).click();
	Thread.sleep(2000);
	driver.findElement(By.id(Elements_Doctors.appointment_clickoncancelmenu)).click();
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
	driver.findElement(By.id(Elements_Doctors.appointment_cancelconfirmation)).click();
	driver.switchTo().window(parentWindowHandler); // switch back to
													// parent window
	Browser.CheckNotificationMessage("Appointment has been Cancelled");
}

public void CheckPateintScreenForCheckInFunctionality(String firstname,String lastname,String email) throws InterruptedException{
	driver.findElement(By.id(Elements_Doctors.patient_id)).click();
	Thread.sleep(10000);
	driver.findElement(By.name(Elements_Doctors.patientallmenuname)).click();
	Thread.sleep(2000);
	 driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(email);	 
	 driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(Keys.ENTER);
	 String fullname=firstname+" "+lastname;
	 Thread.sleep(3000);
	 String name= driver.findElement(By.xpath(Elements_Doctors.patient_getfullname)).getText();
	 String schedule=driver.findElement(By.xpath(Elements_Doctors.patient_getstatus)).getText();
		if(name.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Scheduled")){
			driver.findElement(By.xpath(Elements_Doctors.patient_getstatus)).click();
			Thread.sleep(5000);
		}
		}

public void VerifyCheckINFunctionality() throws Exception{
	
	driver.findElement(By.id(Elements_Doctors.patient_clickoncheckinbutton)).click();
	Thread.sleep(2000);
	driver.findElement(By.id(Elements_Doctors.patient_clickonstartconsulationbutton)).click();
	Thread.sleep(2000);
	driver.findElement(By.id(Elements_Doctors.patient_prognosis)).sendKeys("Normal");
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.patient_diagnosis)).sendKeys("Done");
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.patient_saveproblems)).click();
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.patient_height)).sendKeys("5");
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.patient_heightinches)).sendKeys("9");
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.patient_weight)).sendKeys("83");
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.patient_savevitals)).click();
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.patient_druginstructions)).sendKeys("Crocin");
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.patient_strenght)).sendKeys("2");
	Thread.sleep(1000);
	driver.findElement(By.xpath(Elements_Doctors.patient_medicinetime)).click();
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.patient_saveprescription)).click();
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.patient_consultationnotes)).sendKeys("Normal");
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.patient_savenotes)).click();
	System.out.println("Consultation Notes Saved");
	Thread.sleep(3000);
	driver.findElement(By.id(Elements_Doctors.patient_generatereciept)).click();
	Thread.sleep(2000);
	System.out.println("generateReceipt");
	driver.findElement(By.xpath(Elements_Doctors.patient_clickonrecieptdownload)).click();		
	System.out.println("click on the download Receipt icon");		
	Thread.sleep(5000);
	driver.findElement(By.xpath(Elements_Doctors.patient_selectreciepttodownload)).click();		
	Thread.sleep(10000);
	driver.findElement(By.xpath(Elements_Doctors.patient_clickonprescription)).click();	
	Thread.sleep(5000);
	driver.findElement(By.xpath(Elements_Doctors.patient_selectprescription)).click();		
	Thread.sleep(5000);
	driver.findElement(By.xpath(Elements_Doctors.patient_selectemailno)).click();		
	Thread.sleep(5000);
	driver.findElement(By.id(Elements_Doctors.patient_clickoncheckoutbutton)).click();
	Browser.CheckNotificationMessage("Appointment checked out successfully");
	System.out.print("Clicked on Checkout");
	System.out.println("Check-In Scheduled/Rescheduled Sucessfull");
			
}

	public void CheckingFollowUpFunctionality(String firstname,String lastname) throws Exception{
	driver.findElement(By.xpath(Elements_Doctors.patient_clickonfollowupbutton)).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath(Elements_Doctors.appointment_tommorrowmenu)).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(Elements_Doctors.appointment_morning)).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(Elements_Doctors.appointment_noon)).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(Elements_Doctors.appointment_eveningtab)).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(Elements_Doctors.appointment_eveningfirstcell)).click();
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.appointment_problem)).sendKeys("Diabetic");
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.patient_savefollowupappointment)).click();
	Browser.waitFortheElementXpath(Elements_Doctors.appointment_backgoundcolor);
	String fullname=firstname+" "+lastname;
	Browser.CheckNotificationMessage("Follow Up Appointment is confirmed. Patient Name:"+fullname);
	
		}
	
	
	
	/*
	 * @ Author: Sagar Sen
	 * @ Description: This method will add a clinic in schedule for a doctor
	 * @ Pram: Other clinic Name, other clinic fee, other clinic mobile number
	 * @ Return:
	 */
	public void addclinicSchedule(String otherClnName, String otherfee, String othermob, String lineone, String othrPin, String othrLon, String othrLat)
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
		driver.findElement(By.id(Elements_Doctors.addlineone)).sendKeys(lineone);
		driver.findElement(By.id(Elements_Doctors.otherPincode)).sendKeys(othrPin);
		Browser.scrollbyID(Elements_Doctors.otherClinicSave);
		driver.findElement(By.id(Elements_Doctors.otherLon)).sendKeys(othrLon);
		driver.findElement(By.id(Elements_Doctors.otherLat)).sendKeys(othrLat);
		driver.findElement(By.id(Elements_Doctors.otherClinicSave)).click();
		Browser.CheckNotificationMessage("Clinic added successfully");
	}
	
	/*
	 * @ Author: Sagar Sen
	 * @ Description: This method will delete otherclinic from admin for a doctor
	 * @ Pram: doctor email
	 * @ Return:
	 */
	public void deleteOtherClinicFromAdmin(String docEmail) throws Exception
	{
		admin.click_doctorsTab();
		admin.searchDoctorbyEmailID("may19_0@zoy.com");
		admin.clickEditbutton();
		Browser.waitFortheID(Elements_NewAdminDoctors.practiceTab);
		driver.findElement(By.id(Elements_NewAdminDoctors.practiceTab)).click();
		Browser.waitFortheID(Elements_NewAdminDoctors.addOtherClinic);
		if(driver.findElements(By.xpath("//i[@class='fa fa-trash-o zoyDeleteOtherClinicsBtn']")).size()>0)
		{
			driver.findElement(By.xpath("//i[@class='fa fa-trash-o zoyDeleteOtherClinicsBtn']")).click();
			Thread.sleep(2000);
			System.out.println("Other clinic is available and deleted");
		}
		else
		{
			System.out.println("There is no other clinic for this doctor");
		}
		admin.clickSubmitDoctor();
		Browser.CheckNotificationMessage("Doctor Updated Successfully");
	}
	
	

}//main class

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

//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;








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
		Reporter.log("Doctor Signed in as "+username);
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
		//driver.get("https://"+LoadPropMac.Environment_Name+".zoylo.com/providerAccount");
		Browser.openUrl("https://"+LoadPropMac.Environment_Name+".zoylo.com/providerAccount");
		Browser.waitFortheElementXpath("//a[@data-target='#logoutModal1']");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("span.icon-diag-cen > i.fa.fa-sign-out")).click();
		Thread.sleep(2000);
		Browser.clickOnTheElementByID("logout");
		//driver.findElement(By.id("logout")).click();
		Thread.sleep(5000);
		System.out.println("Doctor Logged Out");
		Reporter.log("Doctor Logged Out");
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
					Browser.waitFortheID("dashboard_dashboardIcon");
					DateFormat ModTime = new SimpleDateFormat("h:mm a");
					String PslotTime=ModTime.format(ModTime.parse(slotTime)).toLowerCase();
		            System.out.println("Slot Time after modification"+PslotTime);
		        	
		    
					if(driver.findElements(By.id("show-all-btn")).size()==0){
						System.out.println("is empty");
						driver.findElement(By.xpath("//div[@class='timing' and contains(.,'"+PslotTime+"')]/following-sibling::div[1]")).click();  // Recent Appointment
						Browser.waitTill(60);
					}
					else {
						System.out.println("show all btn exisit");
						driver.findElement(By.id("show-all-btn")).click();
						Reporter.log("Clicked on Show all Button");
						Thread.sleep(2000);
						JavascriptExecutor jse = (JavascriptExecutor)driver;
						jse.executeScript("scroll(0, 250)"); // if the element is on bottom.
						Thread.sleep(2000);
						driver.findElement(By.xpath("//div[@class='timing' and contains(.,'"+PslotTime+"')]/following-sibling::div[1]")).click();  // Recent Appointment
						Browser.waitTill(60);
						Reporter.log("Clicked Patient at Slot Time="+slotTime);

					}

				}


	// Doctors Checkin and check the recipient
		public  void doctorCheckinCheckOut() throws IOException, InterruptedException{
			Browser.clickOnTheElementByID(Elements_Doctors.patient_clickoncheckinbutton);
			Reporter.log("Clicked on Check-In Button");
			Browser.clickOnTheElementByID(Elements_Doctors.patient_clickonstartconsulationbutton);
			Reporter.log("Clicked on Start Consulation Button");
			Browser.enterTextByID(Elements_Doctors.patient_diagnosis, "Doctor Details");
			Reporter.log("Entered Diagnosis Details");
			Browser.clickOnTheElementByID(Elements_Doctors.patient_saveproblems);
			Reporter.log("Clicked on Save Problems button");
			Browser.clickOnTheElementByID("saveVitals");	
			Reporter.log("Clicked On Save Vitals");
			Browser.clickOnTheElementByID("savePrescription");	
			Reporter.log("Clicked on Save Prescription");
			Browser.clickOnTheElementByID("saveNotes");
			Reporter.log("Clicked on Save Notes");
			Thread.sleep(10000);
			Browser.clickOnTheElementByID("generateReceipt");
			Reporter.log("Clicked on generateReceipt");
			Browser.CheckNotificationMessage("Bill generated successfully");
			Browser.clickOnTheElementByID("checkOut");
			Reporter.log("Clicked on checkOut");
			Browser.CheckNotificationMessage("Appointment checked out successfully");


		}
	
	
	/*
	 * @ Author: Ch.LakshmiKanth
	 * @ Description: This method to reschedule appointment
	 * @ Params:
	 * @ Returns:
	 */
	public void reschedule(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		
		Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_changeicon);
		Thread.sleep(5000);
		Reporter.log("Clicked on Changes Icon");
		Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_nextmenu);
		Reporter.log("Clicked on Next Day Menu");
		Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_morning);
		Reporter.log("Clicked on Moening Tab");
		Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_morningfirstcell);
		Reporter.log("Clicked on Morning First Cell");
		Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_changeslot);
		Reporter.log("Clicked on Change Slot");
		Thread.sleep(3000);
		//Browser.CheckNotificationMessage("Your appointment slot has been successfully CHANGED");
		
		}
	
	/*
	 * Author: Ch.LakshmiKanth
	 * @ Description: This method to reschedule appointment and Check In Patient Screen
	 * @ Params:
	 * @ Returns:
	 */
		public void CheckPatientScreenForReschedule(String firstname,String lastname,String email) throws Exception{
		
		Browser.clickOnTheElementByID(Elements_Doctors.patient_id);
		Reporter.log("Clicked on Patient Menu");
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("searchPatientsList")));
		Browser.enterTextByID(Elements_Doctors.patient_searchbox, email);
		driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(Keys.ENTER);
		Reporter.log("Enterd Email In Serach Box");
		Thread.sleep(3000);
		driver.findElement(By.name(Elements_Doctors.patientallmenuname)).click();	
		Reporter.log("Clicked On all menu in Patient Search");
		Thread.sleep(3000);
		String name=driver.findElement(By.xpath(Elements_Doctors.patient_alltabfullname)).getText();
		Reporter.log("Get FullName from Patient Search:"+name);
		String schedule=driver.findElement(By.xpath(Elements_Doctors.patient_alltabschedule)).getText();
		Reporter.log("Get Schedule Status in Patient Screen:"+schedule);
		String fullname=firstname+" "+lastname;
		if(name.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Rescheduled")){
			System.out.println("Appointment Rescheduled Is Sucessfully Verified");
			Reporter.log("Appointment Rescheduled Is Sucessfully Verified");
		}else{
			Assert.fail();
			Reporter.log("Appointment Rescheduled Verification is Failed");
		}
		}


		/*
		 * Author: Ch.LakshmiKanth
		 * @ Description: This method to Click on View menu
		 * @ Params:
		 * @ Returns:
		 */
		public void ClickView() throws Exception
		{
			Thread.sleep(2000);
			Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_clickonview);
			Reporter.log("Clicked on View menu To get Appointment ID");
			Browser.waitFortheID("about");
			Reporter.log("Waiting For the Page To Load");
		}
		
		
		/*
		 * Author: Ch.LakshmiKanth
		 * @ Description: This method to Click on Alert menu
		 * @ Params:
		 * @ Returns:
		 */
		public void ClickonAlertmenu(){
			Browser.clickOnTheElementByID("alerts");
			Reporter.log("Clicked on The Alerts Menu");
			WebDriverWait wait=new WebDriverWait(driver,90);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='provider-alerts-cardholder']")));
			Reporter.log("Waiting for the Page Load");
		}
		
		/*
		 * Author: Ch.LakshmiKanth
		 * @ Description: This method to get Appointment Id
		 * @ Params:
		 * @ Returns:AppointmentId
		 */
		public String  getappointmentid() throws Exception{
			
			String AppointmentId=driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[1]/div[2]/div/div/div[1]/div/span")).getText();
			System.out.println(AppointmentId);
			driver.findElement(By.id("backbtn")).click();
			Browser.clickOnTheElementByXpath("//*[@id='cd-1']");
			Browser.clickOnTheElementByXpath("//*[@id='patient-apmt-tabs']/li[1]/div/center");
			Browser.clickOnTheElementByXpath("//*[@id='patient-apmt-tabs']/li[2]/div/center");
			Browser.clickOnTheElementByXpath("//*[@id='patient-apmt-tabs']/li[3]/div/center");
			Browser.clickOnTheElementByXpath("//*[@id='tab-3']/ul/li[1]/div[2]");
			return AppointmentId;
		}
		
		/*
		 * Author: Ch.LakshmiKanth
		 * @ Description: This method to Check the Alert Messages
		 * @ Params:
		 * @ Returns:
		 */
		public void CheckAlerts() throws Exception {
			
		String name=driver.findElement(By.xpath(Elements_Doctors.appointment_getfullnameonclickviewmenu)).getText();
		Reporter.log("Get the Appointment Patient Name");
		System.out.println(name);	
		String	AppointmentId=driver.findElement(By.xpath(Elements_Doctors.appointment_getappointmentid)).getText();
		System.out.println(AppointmentId);
		Reporter.log("Get The Appointment ID:"+AppointmentId);
		Browser.clickOnTheElementByID(Elements_Doctors.alert_clickonalertmenu);
		Reporter.log("Clicked on the Alert Menu");
		Browser.waitTill(5000);
		Reporter.log("Waiting For the Page to Load");
		String Alert=driver.findElement(By.xpath("//*[@id='message' and contains(.,'"+name+"')]")).getText();
		Reporter.log("Get The Appointment Id From Alert Menu");
		System.out.println(Alert);
		Assert.assertTrue(Alert.contains(AppointmentId));
		Thread.sleep(1000);
		Assert.assertTrue(Alert.contains("has been booked"));
		
			
		}

		/*
		 * Author: Ch.LakshmiKanth
		 * @ Description: This method to Click on Cancel menu
		 * @ Params:
		 * @ Returns:
		 */
	public void Cancel(String firstname,String lastname,String mobile,String email,String problem) throws Exception {
		Thread.sleep(1000);
		Browser.clickOnTheElementByID(Elements_Doctors.appointment_clickoncancelmenu);
		Reporter.log("Clicked on the Cancel Option");
		Browser.enterTextByXpath(Elements_Doctors.appointment_selectcancelreason, "Personal reason");
		Reporter.log("Selected the Cancel Option");
		Browser.clickOnTheElementByID(Elements_Doctors.appointment_cancelconfirmation);
		Reporter.log("Clicked on Cancel Confirmation Button");
		
		
		
	}
	
	/*
	 * Author: Ch.LakshmiKanth
	 * @ Description: This method to Check the Cancel appoinrmnet In Patient Screen 
	 * @ Params:
	 * @ Returns:
	 */
		
	public void CheckCancelAppointmentInPatientScreen(String firstname,String lastname,String email) throws Exception	{
		Browser.clickOnTheElementByID(Elements_Doctors.patient_id);
		Reporter.log("Clicked on Patient Menu");
		Browser.waitTill(5000);
		Reporter.log("Waiting for Page Load");
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(Elements_Doctors.patient_searchbox)));
		Browser.enterTextByID(Elements_Doctors.patient_searchbox, email);
		Reporter.log("Entered The Email To Serach");
		driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(Keys.ENTER);
		driver.findElement(By.name(Elements_Doctors.patientallmenuname)).click();
		Reporter.log("Clicked on the Full Name Link On Patient Screen");
		Browser.waitFortheElementXpath(Elements_Doctors.patient_alltabfullname);
		Reporter.log("waiting for the page to Load");
		String name=driver.findElement(By.xpath(Elements_Doctors.patient_alltabfullname)).getText();
		Reporter.log("Get The Full Name in Today Tab:"+name);
		String status=driver.findElement(By.xpath(Elements_Doctors.patient_alltabschedule)).getText();
		Reporter.log("Get The Schedule Sattusin Today Tab:"+status);
		String fullname=firstname+" "+lastname;
		if(name.equalsIgnoreCase(fullname)&&status.equalsIgnoreCase("Cancelled By Provider")){
			System.out.println("Appointment is Sucessfully Cancelled");
			Reporter.log("Appointment is Sucessfully Cancelled");
		}	
		else{
			System.out.println("Appointment is  Not Sucessfully Cancelled");
			Assert.fail("Appointment is  Not Sucessfully Cancelled");
			Reporter.log("Appointment is  Not Sucessfully Cancelled");
		}
		}

	/*
	 * Author: Ch.LakshmiKanth
	 * @ Description: This method to Click on Send Notication in Patient Screen All Tab
	 * @ Params:
	 * @ Returns:
	 */
	public void CheckPatientScreenSendNotificationOfAllTab(String firstname,String lastname,String email) throws Exception{
		
		Browser.clickOnTheElementByID(Elements_Doctors.patient_id);
		Reporter.log("Clicked on the Patient Menu");
		Browser.waitTill(90);
		Reporter.log("Waiting for the Page Load");
		Browser.clickOnTheElementByXpath(Elements_Doctors.patient_alltab);
		System.out.println("Clicked on all tab");
		Reporter.log("Clicked on all tab");
		Browser.enterTextByID(Elements_Doctors.patient_searchbox, email); 
		Reporter.log("Entered the Email In Search Box");
	 	driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(Keys.ENTER);
		String name=driver.findElement(By.xpath(Elements_Doctors.patient_alltabfullname)).getText();
		Reporter.log("Get the Full Name:"+name);
		String schedule=driver.findElement(By.xpath(Elements_Doctors.patient_alltabschedule)).getText();
		Reporter.log("Get The Schedule Status:"+schedule);
		String fullname=firstname+" "+lastname;
		if(name.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Scheduled")){
		Browser.clickOnTheElementByXpath(Elements_Doctors.patient_sendnotification);
		System.out.println("Sucessfully clicked on Send Notification button");
		Reporter.log("Sucessfully clicked on Send Notification button");
		Browser.CheckNotificationMessage("Email/SMS Notification sent to the Patient");

		}
	}
			
			
		public  void expliciteWait(String xpath,int timeToWaitInSec) {
			WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
			//wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		}


		/*
		 * Author: Ch.LakshmiKanth
		 * @ Description: This method to Click on Ellipse to select the hide menu in ribbon Panel
		 * @ Params:
		 * @ Returns:
		 */
		public void ClickingOnEllipse(){
			
		Browser.clickOnTheElementByXpath(Elements_Doctors.clickonellipse);
		Reporter.log("Clicked on Ellipse");
		}

		/*
		 * Author: Ch.LakshmiKanth
		 * @ Description: This method to Click on DashBoard menu
		 * @ Params:
		 * @ Returns:
		 */
	public void ClickingOnDashboard(){
	Browser.clickOnTheElementByID(Elements_Doctors.dashboard_clickondashboardmenu);
	Reporter.log("Clicked on DashBoard Menu");
	WebDriverWait wait=new WebDriverWait(driver,100);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Elements_Doctors.dashboard_getappointlistingtext)));
	Reporter.log("Waiting for the Appointment List");
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
		public void checkAddBreakTimes(String strtTime, String endTime) throws InterruptedException
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
		public void checkremoveBreakTimes() throws InterruptedException
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
			Browser.clickOnTheElementByXpath(Elements_Doctors.clinicTab);
			Browser.waitFortheID(Elements_Doctors.clinicName);
			driver.findElement(By.id(Elements_Doctors.sundayTab)).click(); //Click on Sunday
			driver.findElement(By.id(Elements_Doctors.AddWorkTime)).click(); //Add sat clinic slot
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
			Thread.sleep(2000);
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
		 * Author: Ch.LakshmiKanth
		 * Description: This method will Create Work Timings for doctor in Hospiatl Tab
		 * Param:
		 * Return:
		 */
		public void DoctorsHospitalAddWorkTimings(String starttime, String endtime) throws Exception{
				
			Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_ClickOnHospitalTab);
			Reporter.log("Clicked on Hospital Tab");
			Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_ClickAddWorkTimingsButton);
			Reporter.log("Clicked on Add Work Timings Button");
			Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_ClickOnToggle);
			Reporter.log("Clicked on The Toggle Button");
			driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_Starttime)).clear();
			Browser.enterTextByXpath(Elements_Doctors.Schedule_Hospital_Starttime, starttime);
			Reporter.log("Entered Start Time");
			Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_EndTime);
			driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_EndTime)).clear();
			Browser.enterTextByXpath(Elements_Doctors.Schedule_Hospital_EndTime, endtime);
			Reporter.log("Entered End Time");
			Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
			Reporter.log("Clicked on Save Work Timing Button");
			//Browser.CheckNotificationMessage("Schedule Updated Successfully");
			 Thread.sleep(3000);
			
		}
		
		/*
		 * Author: Sagar Sen
		 * Description: This method will Create Work Timings for doctor in Hospiatl Tab on sunday
		 * Param:
		 * Return:
		 */
		public void DoctorsHospitalAddWorkTimingsSunday(String starttime, String endtime) throws Exception{
				
			Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_ClickOnHospitalTab);
			Browser.clickOnTheElementByID(Elements_Doctors.Schedule_Hospital_SundayMenu);
			Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_ClickAddWorkTimingsButton);
			Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_ClickOnToggle);
			driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_Starttime)).clear();
			Browser.enterTextByXpath(Elements_Doctors.Schedule_Hospital_Starttime, starttime);
			Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_EndTime);
			 driver.findElement(By.xpath(Elements_Doctors.Schedule_Hospital_EndTime)).clear();
			 Browser.enterTextByXpath(Elements_Doctors.Schedule_Hospital_EndTime, endtime);
			 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
			 //Browser.CheckNotificationMessage("Schedule Updated Successfully");
			 Thread.sleep(2000);
			
		}
		
		/*
		 * Author: Ch.LakshmiKanth
		 * @ Description: This method to Cancel All Existing Appointments at Once
		 * @ Params:
		 * @ Returns:
		 */

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
		Browser.clickOnTheElementByID(Elements_Doctors.appointments_doctortab);
		Browser.clickOnTheElementByXpath(Elements_Doctors.bulkcancel_clickonbulkcancelbutton);
		Browser.enterTextByXpath(Elements_Doctors.bulkcancel_fromdate, date);
		Browser.enterTextByXpath(Elements_Doctors.bulkcancel_todate, enddate);
		Browser.clickOnTheElementByXpath(Elements_Doctors.bulkcancel_fromtime);
		Browser.enterTextByXpath(Elements_Doctors.bulkcancel_fromtime, "06:00");
		Browser.enterTextByXpath(Elements_Doctors.bulkcancel_totime, "23:00");
		Browser.clickOnTheElementByID(Elements_Doctors.bulkcancel_submit);
		Thread.sleep(3000);
	  
			}

		/*
		 * Author: Ch.LakshmiKanth
		 * @ Description: This method to Create Appointment For Tommorow(Next Day)
		 * @ Params:
		 * @ Returns:
		 */
 public void DoctorsAppointmentforTomorrow(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
	 Browser.clickOnTheElementByID(Elements_Doctors.appointments_doctortab);
	 Reporter.log("Clicked on Appointment Menu");
	 Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_tommorrowmenu);
	 Reporter.log("Clicked on Tommorrow Menu");
	 Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_morning);
	 Reporter.log("Clicked on Morning Tab");
	 Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_noon);
	 Reporter.log("Clicked on Afternoon Tab");
	 Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_eveningtab);
	 Reporter.log("Clicked on Evening Tab");
	 Browser.clickOnTheElementByXpath("//*[@id='tab-3']/ul/li[1]/div[2]");
	 Reporter.log("Clicked on Evening First Cell");
	 Browser.enterTextByXpath(Elements_Doctors.appointment_firstname,firstname );
	 Reporter.log("Entered First Name:"+firstname);
	 Browser.enterTextByID(Elements_Doctors.appointment_lsatname, lastname); 
	 Reporter.log("Entered Last Name:"+lastname);
	 Browser.enterTextByID(Elements_Doctors.appointment_mobile, mobile); 
	 Reporter.log("Entered Mobile no:"+mobile);
	 Browser.enterTextByID(Elements_Doctors.appointment_email, email); 
	 Reporter.log("Entered email:"+email);
	 Browser.enterTextByID(Elements_Doctors.appointment_problem, problem); 
	 Reporter.log("Entered Problem:"+problem);
	 Browser.clickOnTheElementByID(Elements_Doctors.appointment_save); 
	 Reporter.log("Clicked on Save Button");
	 Browser.waitFortheElementXpath(Elements_Doctors.appointment_backgoundcolor);
	 }


 /*
	 * Author: Ch.LakshmiKanth
	 * @ Description: This method to Search The Appointment Details in Patient screen
	 * @ Params:
	 * @ Returns:
	 */
public void CheckPatientScreenSearchFunctionality(String firstname,String lastname,String mobile,String email) throws Exception{
	Browser.clickOnTheElementByID(Elements_Doctors.patient_id);
	Reporter.log("Clicked on Patient Menu");
	Browser.waitTill(90);
	Reporter.log("Waiting for Page to Load");
	driver.findElement(By.name("all")).click();
	Reporter.log("Clicked on all tab");
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
		 Reporter.log("Entering the Value to search");
		 Browser.waitFortheElementXpath(Elements_Doctors.patient_getfullname);
		String name= driver.findElement(By.xpath(Elements_Doctors.patient_getfullname)).getText();
		Reporter.log("Get The Name:"+name);
		String schedule=driver.findElement(By.xpath(Elements_Doctors.patient_getstatus)).getText();
		Reporter.log("Get the Schedule status:"+schedule);
		if(name.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Scheduled")){
			System.out.println("Appointment Created User Had Available");
			Reporter.log("Appointment Created User Had Available");
		}else{
			System.out.println("Appointment Created User Not Available");
			Reporter.log("Appointment Created User Not Available");
		}
	 }
}


/*
 * Author: Ch.LakshmiKanth
 * @ Description: This method to Create Appointment For Today
 * @ Params:
 * @ Returns:
 */
 public void DoctorAppointmentBookingForToday(String firstname,String lastname,String mobile,String email,String problem) throws Exception
 {	 
	 Browser.clickOnTheElementByID(Elements_Doctors.appointments_doctortab);
	 Reporter.log("Clicked on The Doactor Menu");
	 Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_todaymenu);
	 Reporter.log("Clicked on the Today Tab");
	 Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_morning);
	 Reporter.log("Clicked on Morning tab");
     Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_noon);
     Reporter.log("Clicked on Afternoon tab");
     Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_eveningtab);
     Reporter.log("Clicked on Evening tab");
	 Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_eveningfirstcell);
	 Reporter.log("Clicked on Evening Tab First Cell");
	 Browser.enterTextByXpath(Elements_Doctors.appointment_firstname, firstname);
	 Reporter.log("Entered First Name:"+firstname);
	 Browser.enterTextByID(Elements_Doctors.appointment_lsatname, lastname);
	 Reporter.log("Entered Last Name:"+lastname);
	 Browser.enterTextByID(Elements_Doctors.appointment_mobile, mobile);
	 Reporter.log("Entered Mobile no:"+mobile);
	 Browser.enterTextByID(Elements_Doctors.appointment_email, email);
	 Reporter.log("Entered Mobile no:"+email);
	 Browser.enterTextByID(Elements_Doctors.appointment_problem, problem);
	 Reporter.log("Entered Mobile no:"+problem);
	 Browser.clickOnTheElementByID(Elements_Doctors.appointment_save);
	 Reporter.log("Clicked on Save Button");
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
	 
	 driver.findElement(By.id(Elements_Doctors.appointments_doctortab)).click();
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
public void editScheduleDefaultClinicAddress(String addLineOne, String Locality, String pinCode) throws InterruptedException
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
	Browser.CheckNotificationMessage("Clinic details updated successfully");
	Thread.sleep(5000);
	driver.findElement(By.xpath(Elements_Doctors.servicesTab)).click();
	driver.findElement(By.id(Elements_Doctors.addServices)).click();
	driver.findElement(By.xpath(Elements_Doctors.servicesText)).sendKeys(serviceName);
	driver.findElement(By.id(Elements_Doctors.serviceSave)).click();
	Browser.CheckNotificationMessage("Clinic details updated successfully");
	Thread.sleep(5000);
	driver.findElement(By.id(Elements_Doctors.removeService)).click();
	Thread.sleep(1000);
	driver.findElement(By.id(Elements_Doctors.serviceSave)).click();
	Browser.CheckNotificationMessage("Clinic details updated successfully");
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
	driver.findElement(By.xpath("//div[@class='zy-status-wrapper']")).click();
}

/*
 * @ Author: Sagar Sen
 * @ Description: This method will cancel the appointment booked by using DoctorAppointmentBookingForSunday() menthod
 * @ Param: 
 * @ Return:
 */
public void cancelSundayAppt() throws InterruptedException
{
	System.out.println("Entered cancelSunday method");
	driver.findElement(By.id(Elements_Doctors.appointments_doctortab)).click();
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

/*
 * @ Author: Ch.LakshmiKanth
 * @ Description: This method to Check the appointment is available in Patient Screen and Click on the Patient Name 
 * @ Pram: Other clinic Name, other clinic fee, other clinic mobile number
 * @ Return:
 */

public void CheckPateintScreenForCheckInFunctionality(String firstname,String lastname,String email) throws InterruptedException{
	
	Browser.clickOnTheElementByID(Elements_Doctors.patient_id);
	Reporter.log("Clicked on Patient Menu");
	Browser.waitTill(2000);
	Reporter.log("Waiting for the Page Load");
	driver.findElement(By.name(Elements_Doctors.patientallmenuname)).click();
	Reporter.log("Clicked on the All Tab");
	//Thread.sleep(2000);
	Browser.enterTextByID(Elements_Doctors.patient_searchbox, email); 
	driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(Keys.ENTER);
	Reporter.log("Entered Email To Search");
	 String fullname=firstname+" "+lastname;
	 Thread.sleep(3000);
	 String name= driver.findElement(By.xpath(Elements_Doctors.patient_getfullname)).getText();
	 Reporter.log("Get The Name:"+name);
	 String schedule=driver.findElement(By.xpath(Elements_Doctors.patient_getstatus)).getText();
	 Reporter.log("Get The Schedule Status:"+schedule);
		if(name.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Scheduled")){
			Browser.clickOnTheElementByXpath(Elements_Doctors.patient_getstatus);
			Reporter.log("Clicked on the Save Button");
			Thread.sleep(5000);
		}
		}

/*
 * @ Author: Ch.LakshmiKanth
 * @ Description: This method To Check the CheckIN Functionality on Patient Screen
 * @ Pram: 
 * @ Return:
 */

public void VerifyCheckINFunctionality(String prognosis,String diagnosis,String height,String inches, String weight,
		String drug,String strenght,String notes) throws Exception{
	
	Browser.clickOnTheElementByID(Elements_Doctors.patient_clickoncheckinbutton);
	Reporter.log("Clicked on Check-In Button");
	Browser.clickOnTheElementByID(Elements_Doctors.patient_clickonstartconsulationbutton);
	Reporter.log("Clicked on Start Consultation Button");
	Browser.enterTextByID(Elements_Doctors.patient_prognosis, prognosis);
	Reporter.log("Entered Prognosis Data");
	Browser.enterTextByID(Elements_Doctors.patient_diagnosis, diagnosis);
	Reporter.log("Entered Diagnosis Data");
	Browser.clickOnTheElementByID(Elements_Doctors.patient_saveproblems);
	Reporter.log("Clicked on Save Problems Button");
	Thread.sleep(1000);
	Browser.enterTextByID(Elements_Doctors.patient_height, height);
	Reporter.log("Entered Height");
	Browser.enterTextByID(Elements_Doctors.patient_heightinches, inches);
	Reporter.log("Entered Inches");
	Browser.enterTextByID(Elements_Doctors.patient_weight, weight);
	Reporter.log("Entered Weight");
	Browser.clickOnTheElementByID(Elements_Doctors.patient_savevitals);
	Reporter.log("Clicked on Save Vitals Button");
	Thread.sleep(1000);
	Browser.enterTextByID(Elements_Doctors.patient_druginstructions, drug);
	Reporter.log("Entered Drug Details");
	Browser.enterTextByID(Elements_Doctors.patient_strenght, strenght);
	Reporter.log("Entered Strenght details");
	Browser.clickOnTheElementByXpath(Elements_Doctors.patient_medicinetime);
	Reporter.log("Entered Medicine Time");
	Browser.clickOnTheElementByID(Elements_Doctors.patient_saveprescription);
	Reporter.log("Clicked on Save Prescription");
	Thread.sleep(1000);
	Browser.enterTextByID(Elements_Doctors.patient_consultationnotes, notes);
	Reporter.log("Entered The Notes");
	Thread.sleep(1000);
	Browser.clickOnTheElementByID(Elements_Doctors.patient_savenotes);
	Reporter.log("Clicked on Save Notes Button");
	System.out.println("Consultation Notes Saved");
	Thread.sleep(2000);
	Browser.clickOnTheElementByID(Elements_Doctors.patient_generatereciept);
	Thread.sleep(6000);
	Reporter.log("Clicked on Generate Reciept Button");
	System.out.println("generateReceipt");
	Browser.clickOnTheElementByID(Elements_Doctors.patient_clickoncheckoutbutton);
	Reporter.log("Clicked on Check -Out Button");
	Browser.CheckNotificationMessage("Appointment checked out successfully");
	Thread.sleep(3000);
			
}

	
	
	
	
	/*
	 * @ Author: Sagar Sen
	 * @ Description: This method will add a clinic in schedule for a doctor
	 * @ Pram: Other clinic Name, other clinic fee, other clinic mobile number
	 * @ Return:
	 */
	public void addclinicSchedule(String otherClnName, String otherfee, String othermob, String lineone, String othrPin, String othrLon, String othrLat) throws InterruptedException
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
		admin.searchDoctorbyEmailID(docEmail);
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
	
	/*
	 * @ Author: Sagar Sen
	 * @ Description: This method will edit aminity for a doctor to check in recipient application
	 * @ Pram: aminity element
	 * @ Return:
	 */
	public void editAminitiesStringPass(String aminity)
	{
		Browser.clickOnTheElementByID(aminity);
		Browser.clickOnTheElementByID(Elements_Doctors.aminitiesSave);
	}
	
	/*
	 * @ Author: Sagar Sen
	 * @ Description: This method will switch between clinic practice locations
	 * @ Pram:
	 * @ Return:
	 */
	public void switchClinicPracticeLoactions()
	{
		Browser.clickOnTheElementByXpath(Elements_Doctors.clinicTab);
		Browser.clickOnTheElementByID(Elements_Doctors.clickPlusMore);
		Browser.waitFortheElementXpath(Elements_Doctors.selectOtherClinic);
		String clinicName= Browser.getTextByXpath(Elements_Doctors.selectOtherClinic);
		Browser.clickOnTheElementByXpath(Elements_Doctors.selectOtherClinic);
		System.out.println("Clicked on "+clinicName);
		String clinicNameonPage=Browser.getTextByID(Elements_Doctors.clinicName);
		Assert.assertEquals(clinicName, clinicNameonPage);
	}
	
	/*
	 * @ Author: Sagar Sen
	 * @ Description: This method will route to doctor profile picture pop up
	 * @ Pram:
	 * @ Return:
	 */
	public void goToDoctorProfilePicture() throws Exception
	{
		Browser.waitFortheID(Elements_Doctors.schedule);
		Browser.scrollbyxpath(Elements_Doctors.doctor_Profile);
		Browser.clickOnTheElementByXpath(Elements_Doctors.doctor_Profile);
		Browser.clickOnTheElementByXpath(Elements_Doctors.doctor_profilePicture);
		Browser.waitFortheElementXpath(Elements_Doctors.doctor_profilePicturePopUp);
	}
	
	/*
	 * @ Author: Sagar Sen
	 * @ Description: This method will route to doctor other clinic and edit clinic name
	 * @ Pram: othEditName
	 * @ Return:
	 */
	public void Edit_OtherClinicName(String othEditName) throws Exception
	{
		Browser.clickOnTheElementByXpath(Elements_Doctors.addressTab);
		Browser.clickOnTheElementByID(Elements_Doctors.addressEditButton);
		driver.findElement(By.id(Elements_Doctors.clinicName)).clear();
		Browser.enterTextByID(Elements_Doctors.clinicName, othEditName);
		Browser.clickOnTheElementByID(Elements_Doctors.addSave);
	}
	
}//main class

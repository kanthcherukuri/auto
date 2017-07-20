package testBase;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import objectRepository.Elements_NewAdminDiagnostic;

public class NewAdminDiagnosticPage 
{
	public WebDriver driver;
	public TestUtils Browser;
	
	public NewAdminDiagnosticPage(WebDriver driver)
	{
		this.driver=driver;
		Browser=new TestUtils(driver);
		Elements_NewAdminDiagnostic .newAdmin_DiagnosticPageProperties();
	}
	
	//Methods from here
	
	
	
	public  void SignIn(String username, String password) throws  Exception{	
		Browser.waitFortheID("emailAddress");	
		driver.findElement(By.id("emailAddress")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);	
		driver.findElement(By.xpath("//button[text()='Login']")).click();			
		Browser.waitFortheID("tabs");
		
	}
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method will click Diagnostics Menu
	 * @ Params:
	 * @ Returns:
	 */
	public void ClickOnDiagnosticMenu() throws Exception{
		
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.Diagnostic_Menu)).click();
		Thread.sleep(2000);
	}
	
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method will click AddDiagnostics Button
	 * @ Params:
	 * @ Returns:
	 */
	public void ClickOnAddDiagnostic() throws Exception{
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Diagnostic_ClickOnAddDiagnostic)).click();
		Thread.sleep(2000);
	}
	
	
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method will Enter Diagnostic Center Details
	 * @ Params:
	 * @ Returns:
	 */
	
	public void EnterDiagnosticDetails(String DiagnosticName,String ShortName,String fullname,String email,String phone,String password) throws Exception{
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticCenter_Name)).sendKeys(DiagnosticName);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticCenter_ShortName)).sendKeys(ShortName);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticCenter_fullname)).sendKeys(fullname);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticCenter_email)).sendKeys(email);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticCenter_phone)).sendKeys(phone);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticCenter_password)).sendKeys(password);
		Thread.sleep(2000);
	}
	
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method will Enter Mandator Field values 
	 * @ Params:
	 * @ Returns:
	 */
	public void EnterMandatoryFields(String dateofbirth,String desc,String regno,String dateofreg,String rating,String startedyear) throws Exception{
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MandatoryFields_dateofbirth)).clear();
		Browser.enterTextByID(Elements_NewAdminDiagnostic.MandatoryFields_dateofbirth, dateofbirth);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.MandatoryFields_desc, desc);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.MandatoryFields_regno, regno);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MandatoryFields_dateofreg)).clear();
		Browser.enterTextByID(Elements_NewAdminDiagnostic.MandatoryFields_dateofreg, dateofreg);
		Browser.selectbyid(Elements_NewAdminDiagnostic.MandatoryFields_StatusCode, "approved");
		Browser.clickOnTheElementByXpath("(//ul[@class='select2-selection__rendered'])[4]");
		Browser.selectbyid(Elements_NewAdminDiagnostic.MandatoryFields_languagesSpoken, "ENGLISH");
		Browser.enterTextByID(Elements_NewAdminDiagnostic.MandatoryFields_rating, rating);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.MandatoryFields_startedyear, startedyear);
		Thread.sleep(3000);
		
		
	}
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method will Enter Home Visit Details While Creating Diagnostic Center 
	 * @ Params:
	 * @ Returns:
	 */
	
	public void EnterHomeVisitDetails(String homevisitvalue,String charge,String range,String appperslot,String mvalue,String starttime,String endtime,
			String tvalue,String tstarttime,String tendtime,String Wvalue,String Wstarttime,String Wendtime,String thvalue,String thstarttime,String thendtime,
			String fvalue,String fstarttime,String fendtime,String Svalue,String Sstarttime,String Sendtime) 
			throws Exception{
		
		if(homevisitvalue.equalsIgnoreCase("true")){
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HomeVisit_Menu);	
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HomeVisit_Active);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.HomeVisit_Charge, charge);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.HomeVisit_ServiceRange, range);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.HomeVisit_SlotDuration, "15");	
		Browser.enterTextByID(Elements_NewAdminDiagnostic.HomeVisit_AppointmentsPerSlot, appperslot);	
		Thread.sleep(1000);
		if(mvalue.equalsIgnoreCase("true")){
			
			//System.out.println("its in Monday");
			driver.findElement(By.id("sunday")).click();
			Thread.sleep(1500);
			Browser.clickOnTheElementByID("monday");
			Browser.clickOnTheElementByXpath("(//button[@data-target='#zoyDiagAddHomeVisitTimings'])[2]/i");
			//driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursMonday)).click();
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive)).click();
			Thread.sleep(1000);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime, starttime);
			Thread.sleep(500);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime, endtime);
			Thread.sleep(500);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit);
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit);
			Thread.sleep(2000);
			
			
		}//mvalue
		else{
		System.out.println("Monday slots are not provided");
		}
		
		if(tvalue.equalsIgnoreCase("true")){
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HomeVisit_Tuesday);
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursTuesday);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime);
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive);
			Thread.sleep(500);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime, tstarttime);
			Thread.sleep(500);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime, tendtime);;
			Thread.sleep(500);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit);
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit);
			Thread.sleep(3000);
			
		}//tvalue
		else{
		System.out.println("Tuesday slots are not provided");
		}
		if(Wvalue.equalsIgnoreCase("true")){
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.HomeVisit_Wednesday);
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursWednesday);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive);
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive);
			Thread.sleep(500);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime, Wstarttime);
			Thread.sleep(500);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime, Wendtime);
			Thread.sleep(500);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit);
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit);
			Thread.sleep(3000);
			
		}//Wvalue
		else{
		System.out.println("Wednesday slots are not provided");
		}
		if(thvalue.equalsIgnoreCase("true")){
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HomeVisit_Thursday);
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursThursday);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive);
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive);
			Thread.sleep(500);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime, thstarttime);
			Thread.sleep(500);
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime, thendtime);
			Thread.sleep(500);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit);
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit);
			Thread.sleep(3000);
			
		
		}//thvalue
		else{
		System.out.println("Thursday slots are not provided");
		}
		if(fvalue.equalsIgnoreCase("true")){
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HomeVisit_Friday);
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVistHoursFriday);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive);
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive);
			Thread.sleep(500);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime, fstarttime);
			Thread.sleep(500);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime, fendtime);
			Thread.sleep(500);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit);
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit);
			Thread.sleep(3000);
			
			
		}//fvalue
		else{
		System.out.println("Friday slots are not provided");
		}
		if(Svalue.equalsIgnoreCase("true")){
			Browser.clickOnTheElementByID("saturday");
			Browser.clickOnTheElementByXpath("//*[@id='dcHomeVisitSat']/div[1]/div[4]/button");
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive);
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive);
			Thread.sleep(500);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime, Sstarttime);
			Thread.sleep(500);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime, Sendtime);
			Thread.sleep(500);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit);
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit);
			Thread.sleep(2000);
		}//mvalue
		else{
		System.out.println("Saturday slots are not provided");
		}
			
		}//homevisitvalue
		else{
			System.out.println("HomeVisit Appointment is Not Available");
		}
	}
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method will Enter Lab Visit Details While Creating Diagnostic Center 
	 * @ Params:
	 * @ Returns:
	 */
	public void EnterLabVisitDetails(String labslotduration,String labapptperslot,String Lmvalue,String Lmstarttime,String Lmendtime,
		String Ltvalue,String Ltstarttime,String Ltendtime,String LWvalue,String LWstarttime,String LWendtime,String LThvalue,String LThstarttime,
		String LThendtime,String Lfvalue,String Lfstarttime,String Lfendtime,String LSvalue,String LSstarttime,String LSendtime) throws Exception{
		Thread.sleep(2000);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.LabVisit_Menu);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.LabVisit_SlotDuration, labslotduration);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.LabVisit_AppointmentsPerSlot, labapptperslot);
		Thread.sleep(1000);
		if(Lmvalue.equalsIgnoreCase("true")){
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_Monday);
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursMonday);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursActive);
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursActive);
			Thread.sleep(1000);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime, Lmstarttime);
			Thread.sleep(500);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime, Lmendtime);
			Thread.sleep(500);
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursSubmit);
			Thread.sleep(3000);
		}else{
			System.out.println("Monday Lab Slot are Unavilable");
		}
		if(Ltvalue.equalsIgnoreCase("true")){
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_Tuesday);
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursTuesday);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime);
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursActive);
			Thread.sleep(1000);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime, Ltstarttime);
			Thread.sleep(500);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime, Ltendtime);
			Thread.sleep(500);
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursSubmit);
			Thread.sleep(3000);
		}else{
			System.out.println("Tuesday Lab Slot are Unavilable");
		}
		if(LWvalue.equalsIgnoreCase("true")){
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_Wednesday);
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursWednesday);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime);
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursActive);
			Thread.sleep(1000);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime, LWstarttime);
			Thread.sleep(500);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime, LWendtime);
			Thread.sleep(500);
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursSubmit);
			Thread.sleep(3000);
		}else{
			System.out.println("Wednesday Lab Slot are Unavilable");
		}
		if(LThvalue.equalsIgnoreCase("true")){
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_Thursday);
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursThursday);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursActive)).click();
			Thread.sleep(1000);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime, LThstarttime);
			Thread.sleep(500);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime, LThendtime);
			Thread.sleep(500);
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursSubmit);
			Thread.sleep(3000);
		}else{
			System.out.println("Thursday Lab Slot are Unavilable");
		}
		if(Lfvalue.equalsIgnoreCase("true")){
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_Friday);
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursFriday);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime);
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursActive);
			Thread.sleep(1000);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime, Lfstarttime);
			Thread.sleep(500);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime, Lfendtime);
			Thread.sleep(500);
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursSubmit);
			Thread.sleep(3000);
		}else{
			System.out.println("Friday Lab Slot are Unavilable");
		}
		
		if(LSvalue.equalsIgnoreCase("true")){
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_Saturday);
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursSaturday);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursActive)).click();
			Thread.sleep(1000);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime, LSstarttime);
			Thread.sleep(500);
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime);
			Browser.enterTextByID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime, LSendtime);
			Thread.sleep(500);
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursSubmit);
	
		}else{
			System.out.println("Saturday Lab Slot are Unavilable");
		}
	}
	
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method will Click On The PackageAndTests Menu 
	 * @ Params:
	 * @ Returns:
	 */
	
	public void ClickOnPackageAndTestsMenu() throws Exception{
		Thread.sleep(2000);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.PackageandTests_Menu);
		Thread.sleep(3000);
	}
	
	
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method will Add Health Packages For Lab/Home Visits while Creating Diagnostic Center
	 * @ Params:
	 * @ Returns:
	 */
	
	public void AddHealthPackages(String servicemode,String packagename,String packagedesc,String packagecost, String discountpercentage,
	String zoylopercentage,String packageduration,String packageperslot		) throws Exception{
		
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.HealthPackage_AddPackage);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.HealthPackage_Status);
		WebElement element=driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_Status));
		Select se=new Select(element);
		se.selectByValue("approved");
		
		if(servicemode.equalsIgnoreCase("Lab Visit")){
			
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HealthPackage_ClickOnServiceMode);
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.HealthPackage_LabVisit);
			
		}else{
			
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HealthPackage_ClickOnServiceMode);
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.HealthPackage_HomeVisit);
			
		}
		
		Browser.waitFortheID(Elements_NewAdminDiagnostic.HealthPackage_packageName);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.HealthPackage_packageName, packagename);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.HealthPackage_packageDescription, packagedesc);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.HealthPackage_packageCost, packagecost);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.HealthPackage_discountPercentage,discountpercentage);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.HealthPackage_zoyloChargePercentage, zoylopercentage);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.HealthPackage_averageDuration, packageduration);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.HealthPackage_PackagesPerSlot, packageperslot);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HealthPackage_PackagesActive);
		Thread.sleep(2000);
		
	}
	
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method will Add Tests in Packages For Lab/Home Visits while Creating Diagnostic Center
	 * @ Params:
	 * @ Returns:
	 */
	
	public void AddTestsInHealthPackage(String testname,String testdesc) throws Exception{
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.PackageTests_Add);
		//Thread.sleep(1000);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.PackageTests_TestName);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.PackageTests_TestName, testname);
		//Thread.sleep(1000);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.PackageTests_TestDescription);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.PackageTests_TestDescription, testdesc);
		//Thread.sleep(1000);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.PackageTests_TestActive);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.PackageTests_TestActive);
		//Thread.sleep(1000);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.PackageTests_TestSave);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.PackageTests_TestSave);
		Thread.sleep(2000);
	}
	
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method will Save The Packages that are Created while Creating Diagnostic Center
	 * @ Params:
	 * @ Returns:
	 */
	public void SaveAddHealthPackages() throws Exception{
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HealthPackage_Save);
		Thread.sleep(2000);
		
	}

	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method will Add and save the Diagnostic Tests For Lab/Home Visits while Creating Diagnostic Center
	 * @ Params:
	 * @ Returns:
	 */
	
	public void CreateDiagnosticTests(String diagTestname,String diagTestdesc,String diagservicemode,String diagTestcost,String diagdiscountper,
	String diagZoyloper,String diagduration,String diagNumofSlots	) throws Exception{
		
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.DiagnosticTests_Menu);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.DiagnosticTests_AddTests);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.DiagnosticTests_TestName);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.DiagnosticTests_TestName, diagTestname+Browser.randomalphabets());
		Browser.waitFortheID(Elements_NewAdminDiagnostic.DiagnosticTests_TestDescription);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.DiagnosticTests_TestDescription, diagTestdesc);
		Browser.selectbyid(Elements_NewAdminDiagnostic.DiagnosticTests_AdminStatus, "approved");
		
		if(diagservicemode.equalsIgnoreCase("Lab Visit")){
			Browser.selectbyid("diagServiceMode", "C");
		}else{
			Browser.selectbyid("diagServiceMode", "H");
		}
		
		Browser.enterTextByID(Elements_NewAdminDiagnostic.DiagnosticTests_TestCost, diagTestcost);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.DiagnosticTests_DiscountPercentage, diagdiscountper);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.DiagnosticTests_ZoyloChargePercentage, diagZoyloper);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.DiagnosticTests_AverageDuration, diagduration);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.DiagnosticTests_TestsPerSlot, diagNumofSlots);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.DiagnosticTests_TestActive);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.DiagnosticTests_TestSave);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.DiagnosticTests_TestCancel);
		Thread.sleep(3000);
	}
	
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method will Add Contact Information  while Creating Diagnostic Center
	 * @ Params:
	 * @ Returns:
	 */
	public void  EnterAdditionalContactInformation(String Personname,String PersonPhone,String PersonEmail,String PersonFax) throws Exception{
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.AdditionalInformation_Menu);
		//Thread.sleep(1000);
		Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.ContactPerson_AddContact);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.ContactPerson_AddContact);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.ContactPerson_Name);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.ContactPerson_Name, Personname);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.ContactPerson_Phone);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.ContactPerson_Phone, PersonPhone);
		//Thread.sleep(1000);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.ContactPerson_Email);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.ContactPerson_Email, PersonEmail);
		Thread.sleep(1000);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.ContactPerson_Fax);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.ContactPerson_Fax, PersonFax);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.ContactPerson_Save);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.ContactPerson_Save);
		Thread.sleep(4000);
	}
	
	
	public void AddDiagnosticImage(String imageURL ) throws Exception{
		String current = System.getProperty("user.dir");
		Browser.waitFortheID("zyDCInfoGallery");
		Browser.clickOnTheElementByID("zyDCInfoGallery");
		Browser.waitFortheID("isDiagnoDefault");
		Browser.clickOnTheElementByID("isDiagnoDefault");
		Thread.sleep(5000);
		driver.findElement(By.id("diagnosDefaImagesList")).sendKeys(current+imageURL);
		Thread.sleep(2000);
	}
	
	
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method will Add the period when the Diagnostic to be shown as Closed while Creating Diagnostic Center
	 * @ Params:
	 * @ Returns:
	 */
	public void EnterMarkedasClosedInformation(String startdate,String enddate) throws Exception{
		
		Browser.waitFortheID(Elements_NewAdminDiagnostic.MarkedasClosed_Menu);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.MarkedasClosed_Menu);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.MarkedasClosed_Add);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.MarkedasClosed_Add);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.MarkedasClosed_startdate);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MarkedasClosed_startdate)).clear();
		Browser.enterTextByID(Elements_NewAdminDiagnostic.MarkedasClosed_startdate, startdate);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.MarkedasClosed_enddate);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MarkedasClosed_enddate)).clear();
		Browser.enterTextByID(Elements_NewAdminDiagnostic.MarkedasClosed_enddate, enddate);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.MarkedasClosed_Active);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.MarkedasClosed_Save);
		Thread.sleep(2000);
	}
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method will Add Other Information Details of Diagnostic while Creating Diagnostic Center
	 * @ Params:
	 * @ Returns:
	 */
	public void EnterOtherInformationdetails(String discountoffered,String websiteURL,String accreditations,String ngo,String reportonline) throws Exception{
		
		Browser.waitFortheID(Elements_NewAdminDiagnostic.OtherInformation_Menu);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.OtherInformation_Menu);
		Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.OtherInformation_Discountoffered);
		Browser.enterTextByXpath(Elements_NewAdminDiagnostic.OtherInformation_Discountoffered, discountoffered);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.OtherInformation_NABL);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.OtherInformation_NABL);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.OtherInformation_websiteURL);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.OtherInformation_websiteURL, websiteURL);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.OtherInformation_accreditations);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.OtherInformation_accreditations, accreditations);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.OtherInformation_NGO);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.OtherInformation_NGO, ngo);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.OtherInformation_reportOnlineduration);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.OtherInformation_reportOnlineduration, reportonline);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.OtherInformation_isOnline);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.OtherInformation_isOnline);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.OtherInformation_isSelfCheckIn);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.OtherInformation_isSelfCheckIn);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.OtherInforamtion_isReportOnline);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.OtherInforamtion_isReportOnline);
		Thread.sleep(2000);
	}
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method will Add the Social Information Of the Diagnostic while Creating Diagnostic Center
	 * @ Params:
	 * @ Returns:
	 */
	
	public void EnterSocialInformation(String facebookurl,String googleurl,String linkedinurl,String twiterurl) throws Exception{
		
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Social_Menu);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Social_Menu);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Social_Facebook);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Social_Facebook);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.Social_FaceboolURL, facebookurl);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Social_GooglePlus);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Social_GooglePlus);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.Social_GooglePlusURL, googleurl);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Social_LinkedIn);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Social_LinkedIn);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.Social_LinkedInURL, linkedinurl);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Social_Twitter);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Social_Twitter);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.Social_TwitterURL, twiterurl);
		Thread.sleep(2000);
	}
	
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method To Add the Address of the Diagnostic while Creating Diagnostic Center
	 * @ Params:
	 * @ Returns:
	 */
	public void EnterAddressDetails(String address, String country,String state,String city,String pincode,String locality,String landmark,
			String longitude,String latitude) throws Exception{
		
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Address_Menu);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Address_Line1);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.Address_Line1, address);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Address_ClickOnCountry);
		Browser.selectbyID(Elements_NewAdminDiagnostic.Address_Country, country);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Address_ClicOnState);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Address_ClicOnState);
		Browser.selectbyID(Elements_NewAdminDiagnostic.Address_State, state);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Address_ClickOnCity);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Address_ClickOnCity);
		Browser.selectbyID(Elements_NewAdminDiagnostic.Address_City, city);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Address_Pincode);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.Address_Pincode, pincode);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Address_Locality);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.Address_Locality, locality);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Address_Landmark);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.Address_Landmark, landmark);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Address_Longitude);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.Address_Longitude, longitude);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Address_latitude);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.Address_latitude, latitude);
		Thread.sleep(2000);
	}
	
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This methodto select the facilities provided by the Diagnostic while Creating Diagnostic Center
	 * @ Params:
	 * @ Returns:
	 */
	public void EnterTheFacilities() throws Exception{
		
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Facilities_Menu);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Facilities_Menu);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Facilities_DebitCard);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Facilities_DebitCard);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Facilities_Bike);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Facilities_Bike);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Facilities_CreditCard);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Facilities_CreditCard);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Facilities_CarParking);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Facilities_CarParking);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Facilities_ambulance);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Facilities_ambulance);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Facilities_proBono);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Facilities_proBono);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Facilities_onlinePayment);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Facilities_onlinePayment);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Facilities_Premium);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Facilities_Premium);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Facilities_Cheque);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Facilities_Cheque);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.Facilities_Emergency);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Facilities_Emergency);
		Thread.sleep(2000);
	}
	
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method to  Add the SEO details of the Diagnostics while Creating Diagnostic Center
	 * @ Params:
	 * @ Returns:
	 */
	public void EnterDetailsForSEO(String SEOtitle,String SEOdesc,String SEOkeywords,String SEOurl) throws Exception{
		Browser.waitFortheID(Elements_NewAdminDiagnostic.SEO_Menu);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.SEO_Menu);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.SEO_Title);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.SEO_Title, SEOtitle);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.SEO_Desc);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.SEO_Desc, SEOdesc);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.SEO_Keywords);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.SEO_Keywords, SEOkeywords);
		Browser.waitFortheID(Elements_NewAdminDiagnostic.SEO_URL);
		Browser.enterTextByID(Elements_NewAdminDiagnostic.SEO_URL, SEOurl);
		Thread.sleep(2000);
		
	}
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method to Save the all the Details and  Create the Diagnostic Center
	 * @ Params:
	 * @ Returns:
	 */
	public void SaveDiagnosticDetails() throws Exception{
		
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.AddDiagnostic_Submit);
		Thread.sleep(2000);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
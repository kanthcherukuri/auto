package testBase;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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
		driver.findElement(By.xpath("//*[@id='zoyloCustLogin-form']/div/div[2]/div/div/div/div/button")).click();			
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
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MandatoryFields_dateofbirth)).sendKeys(dateofbirth);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MandatoryFields_desc)).sendKeys(desc);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MandatoryFields_regno)).sendKeys(regno);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MandatoryFields_dateofreg)).clear();
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MandatoryFields_dateofreg)).sendKeys(dateofreg);
		Browser.selectbyid(Elements_NewAdminDiagnostic.MandatoryFields_StatusCode, "approved");
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[4]")).click();
		Browser.selectbyid(Elements_NewAdminDiagnostic.MandatoryFields_languagesSpoken, "ENGLISH");
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MandatoryFields_rating)).sendKeys(rating);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MandatoryFields_startedyear)).sendKeys(startedyear);
		Thread.sleep(2000);
		
		
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
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_Menu)).click();	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_Active)).click();
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_Charge)).sendKeys(charge);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_ServiceRange)).sendKeys(range);	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_SlotDuration)).sendKeys("15");	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AppointmentsPerSlot)).sendKeys(appperslot);	
		Thread.sleep(1000);
		if(mvalue.equalsIgnoreCase("true")){
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_Monday)).click();
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursMonday)).click();
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive)).click();
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime)).sendKeys(starttime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime)).sendKeys(endtime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit)).click();
			Thread.sleep(2000);
			
			
		}//mvalue
		else{
		System.out.println("Monday slots are not provided");
		}
		
		if(tvalue.equalsIgnoreCase("true")){
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_Tuesday)).click();		
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursTuesday)).click();
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive)).click();
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime)).sendKeys(tstarttime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime)).sendKeys(tendtime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit)).click();
			Thread.sleep(3000);
			
		}//tvalue
		else{
		System.out.println("Tuesday slots are not provided");
		}
		if(Wvalue.equalsIgnoreCase("true")){
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HomeVisit_Wednesday)).click();
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursWednesday)).click();
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive)).click();
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime)).sendKeys(Wstarttime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime)).sendKeys(Wendtime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit)).click();
			Thread.sleep(3000);
			
		}//Wvalue
		else{
		System.out.println("Wednesday slots are not provided");
		}
		if(thvalue.equalsIgnoreCase("true")){
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_Thursday)).click();
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursThursday)).click();
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive)).click();
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime)).sendKeys(thstarttime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime)).sendKeys(thendtime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit)).click();
			Thread.sleep(3000);
			
		
		}//thvalue
		else{
		System.out.println("Thursday slots are not provided");
		}
		if(fvalue.equalsIgnoreCase("true")){
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_Friday)).click();
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVistHoursFriday)).click();
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive)).click();
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime)).sendKeys(fstarttime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime)).sendKeys(fendtime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit)).click();
			Thread.sleep(3000);
			
			
		}//fvalue
		else{
		System.out.println("Friday slots are not provided");
		}
		if(Svalue.equalsIgnoreCase("true")){
			driver.findElement(By.id("saturday")).click();
			driver.findElement(By.xpath("//*[@id='dcHomeVisitSat']/div[1]/div[4]/button")).click();
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive)).click();
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime)).sendKeys(Sstarttime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime)).sendKeys(Sendtime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit)).click();
			
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
		driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_Menu)).click();
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_SlotDuration)).sendKeys(labslotduration);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AppointmentsPerSlot)).sendKeys(labapptperslot);
		Thread.sleep(1000);
		if(Lmvalue.equalsIgnoreCase("true")){
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_Monday)).click();
			
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursMonday)).click();
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursActive)).click();
			
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime)).sendKeys(Lmstarttime);
		
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime)).sendKeys(Lmendtime);
			
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursSubmit)).click();
			Thread.sleep(3000);
		}else{
			System.out.println("Monday Lab Slot are Unavilable");
		}
		if(Ltvalue.equalsIgnoreCase("true")){
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_Tuesday)).click();
			
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursTuesday)).click();
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursActive)).click();
			
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime)).sendKeys(Ltstarttime);
			
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime)).sendKeys(Ltendtime);
			
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursSubmit)).click();
			Thread.sleep(3000);
		}else{
			System.out.println("Tuesday Lab Slot are Unavilable");
		}
		if(LWvalue.equalsIgnoreCase("true")){
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_Wednesday)).click();
			
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursWednesday)).click();
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursActive)).click();
			
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime)).sendKeys(LWstarttime);
			
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime)).sendKeys(LWendtime);
			
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursSubmit)).click();
			Thread.sleep(3000);
		}else{
			System.out.println("Wednesday Lab Slot are Unavilable");
		}
		if(LThvalue.equalsIgnoreCase("true")){
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_Thursday)).click();
			
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursThursday)).click();
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursActive)).click();
			
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime)).sendKeys(LThstarttime);
		
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime)).sendKeys(LThendtime);
			
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursSubmit)).click();
			Thread.sleep(3000);
		}else{
			System.out.println("Thursday Lab Slot are Unavilable");
		}
		if(Lfvalue.equalsIgnoreCase("true")){
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_Friday)).click();
			
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursFriday)).click();
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursActive)).click();
			
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime)).sendKeys(Lfstarttime);
			
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime)).sendKeys(Lfendtime);
			
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursSubmit)).click();
			Thread.sleep(3000);
		}else{
			System.out.println("Friday Lab Slot are Unavilable");
		}
		
		if(LSvalue.equalsIgnoreCase("true")){
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_Saturday)).click();
			
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursSaturday)).click();
			Browser.waitFortheID(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursActive)).click();
			
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime)).sendKeys(LSstarttime);
			
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime)).sendKeys(LSendtime);
			
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursSubmit)).click();
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
		driver.findElement(By.id(Elements_NewAdminDiagnostic.PackageandTests_Menu)).click();
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
		
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HealthPackage_AddPackage)).click();
		Browser.waitFortheID(Elements_NewAdminDiagnostic.HealthPackage_Status);
		WebElement element=driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_Status));
		Select se=new Select(element);
		se.selectByValue("approved");
		
		if(servicemode.equalsIgnoreCase("Lab Visit")){
			
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_ClickOnServiceMode)).click();
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HealthPackage_LabVisit)).click();
		}else{
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_ClickOnServiceMode)).click();
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HealthPackage_HomeVisit)).click();
		}
		
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_packageName)).sendKeys(packagename);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_packageDescription)).sendKeys(packagedesc);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_packageCost)).sendKeys(packagecost);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_discountPercentage)).sendKeys(discountpercentage);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_zoyloChargePercentage)).sendKeys(zoylopercentage);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_averageDuration)).sendKeys(packageduration);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_PackagesPerSlot)).sendKeys(packageperslot);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_PackagesActive)).click();
		Thread.sleep(2000);
		
	}
	
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method will Add Tests in Packages For Lab/Home Visits while Creating Diagnostic Center
	 * @ Params:
	 * @ Returns:
	 */
	
	public void AddTestsInHealthPackage(String testname,String testdesc) throws Exception{
		
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.PackageTests_Add)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.PackageTests_TestName)).sendKeys(testname);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.PackageTests_TestDescription)).sendKeys(testdesc);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.PackageTests_TestActive)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.PackageTests_TestSave)).click();
		Thread.sleep(2000);
	}
	
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method will Save The Packages that are Created while Creating Diagnostic Center
	 * @ Params:
	 * @ Returns:
	 */
	public void SaveAddHealthPackages() throws Exception{
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_Save)).click();
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
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_Menu)).click();
	
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.DiagnosticTests_AddTests)).click();
		Browser.waitFortheID(Elements_NewAdminDiagnostic.DiagnosticTests_TestName);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_TestName)).sendKeys(diagTestname);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_TestDescription)).sendKeys(diagTestdesc);
	
		Browser.selectbyid(Elements_NewAdminDiagnostic.DiagnosticTests_AdminStatus, "approved");
		
		if(diagservicemode.equalsIgnoreCase("Lab Visit")){
			Browser.selectbyid("diagServiceMode", "C");
		}else{
			Browser.selectbyid("diagServiceMode", "H");
		}
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_TestCost)).sendKeys(diagTestcost);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_DiscountPercentage)).sendKeys(diagdiscountper);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_ZoyloChargePercentage)).sendKeys(diagZoyloper);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_AverageDuration)).sendKeys(diagduration);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_TestsPerSlot)).sendKeys(diagNumofSlots);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_TestActive)).click();
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_TestSave)).click();
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_TestCancel)).click();
		Thread.sleep(3000);
	}
	
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method will Add Contact Information  while Creating Diagnostic Center
	 * @ Params:
	 * @ Returns:
	 */
	public void  EnterAdditionalContactInformation(String Personname,String PersonPhone,String PersonEmail,String PersonFax) throws Exception{
		driver.findElement(By.id(Elements_NewAdminDiagnostic.AdditionalInformation_Menu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.ContactPerson_AddContact)).click();
		Browser.waitFortheID(Elements_NewAdminDiagnostic.ContactPerson_Name);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.ContactPerson_Name)).sendKeys(Personname);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.ContactPerson_Phone)).sendKeys(PersonPhone);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.ContactPerson_Email)).sendKeys(PersonEmail);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.ContactPerson_Fax)).sendKeys(PersonFax);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.ContactPerson_Save)).click();
		Thread.sleep(2000);
	}
	
	
	public void AddDiagnosticImage(String imageURL ){
		String current = System.getProperty("user.dir");
		driver.findElement(By.id("zyDCInfoGallery")).click();
		driver.findElement(By.id("isDiagnoDefault")).click();
		
		driver.findElement(By.id("diagnosDefaImagesList")).sendKeys(current+imageURL);
	}
	
	
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method will Add the period when the Diagnostic to be shown as Closed while Creating Diagnostic Center
	 * @ Params:
	 * @ Returns:
	 */
	public void EnterMarkedasClosedInformation(String startdate,String enddate) throws Exception{
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MarkedasClosed_Menu)).click();
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MarkedasClosed_Add)).click();
		Browser.waitFortheID(Elements_NewAdminDiagnostic.MarkedasClosed_startdate);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MarkedasClosed_startdate)).clear();
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MarkedasClosed_startdate)).sendKeys(startdate);
	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MarkedasClosed_enddate)).clear();
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MarkedasClosed_enddate)).sendKeys(enddate);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MarkedasClosed_Active)).click();
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MarkedasClosed_Save)).click();
		Thread.sleep(2000);
	}
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method will Add Other Information Details of Diagnostic while Creating Diagnostic Center
	 * @ Params:
	 * @ Returns:
	 */
	public void EnterOtherInformationdetails(String discountoffered,String websiteURL,String accreditations,String ngo,String reportonline) throws Exception{
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.OtherInformation_Menu)).click();
		
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.OtherInformation_Discountoffered)).sendKeys(discountoffered);
	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.OtherInformation_NABL)).click();
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.OtherInformation_websiteURL)).sendKeys(websiteURL);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.OtherInformation_accreditations)).sendKeys(accreditations);
	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.OtherInformation_NGO)).sendKeys(ngo);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.OtherInformation_reportOnlineduration)).sendKeys(reportonline);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.OtherInformation_isOnline)).click();
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.OtherInformation_isSelfCheckIn)).click();
	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.OtherInforamtion_isReportOnline)).click();
		Thread.sleep(2000);
	}
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method will Add the Social Information Of the Diagnostic while Creating Diagnostic Center
	 * @ Params:
	 * @ Returns:
	 */
	
	public void EnterSocialInformation(String facebookurl,String googleurl,String linkedinurl,String twiterurl) throws Exception{
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Social_Menu)).click();
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Social_Facebook)).click();
	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Social_FaceboolURL)).sendKeys(facebookurl);
	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Social_GooglePlus)).click();
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Social_GooglePlusURL)).sendKeys(googleurl);
	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Social_LinkedIn)).click();
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Social_LinkedInURL)).sendKeys(linkedinurl);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Social_Twitter)).click();
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Social_TwitterURL)).sendKeys(twiterurl);
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
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Address_Menu)).click();
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Address_Line1)).sendKeys(address);
	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Address_ClickOnCountry)).click();
		Browser.selectbyID(Elements_NewAdminDiagnostic.Address_Country, country);
	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Address_ClicOnState)).click();
		Browser.selectbyID(Elements_NewAdminDiagnostic.Address_State, state);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Address_ClickOnCity)).click();
		Browser.selectbyID(Elements_NewAdminDiagnostic.Address_City, city);
	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Address_Pincode)).sendKeys(pincode);
	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Address_Locality)).sendKeys(locality);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Address_Landmark)).sendKeys(landmark);
	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Address_Longitude)).sendKeys(longitude);
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Address_latitude)).sendKeys(latitude);
		Thread.sleep(2000);
	}
	
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This methodto select the facilities provided by the Diagnostic while Creating Diagnostic Center
	 * @ Params:
	 * @ Returns:
	 */
	public void EnterTheFacilities() throws Exception{
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Facilities_Menu)).click();
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Facilities_DebitCard)).click();
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Facilities_Bike)).click();
	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Facilities_CreditCard)).click();
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Facilities_CarParking)).click();
	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Facilities_ambulance)).click();
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Facilities_proBono)).click();
	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Facilities_onlinePayment)).click();
	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Facilities_Premium)).click();
	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Facilities_Cheque)).click();
	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Facilities_Emergency)).click();
		Thread.sleep(2000);
	}
	
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method to  Add the SEO details of the Diagnostics while Creating Diagnostic Center
	 * @ Params:
	 * @ Returns:
	 */
	public void EnterDetailsForSEO(String SEOtitle,String SEOdesc,String SEOkeywords,String SEOurl) throws Exception{
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.SEO_Menu)).click();
	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.SEO_Title)).sendKeys(SEOtitle);
	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.SEO_Desc)).sendKeys(SEOdesc);
	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.SEO_Keywords)).sendKeys(SEOkeywords);
	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.SEO_URL)).sendKeys(SEOurl);
		Thread.sleep(2000);
		
	}
	/*
	 * Author: Ch.Lakshmi Kanth
	 * @ Description: This method to Save the all the Details and  Create the Diagnostic Center
	 * @ Params:
	 * @ Returns:
	 */
	public void SaveDiagnosticDetails() throws Exception{
		driver.findElement(By.id(Elements_NewAdminDiagnostic.AddDiagnostic_Submit)).click();
		Thread.sleep(2000);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
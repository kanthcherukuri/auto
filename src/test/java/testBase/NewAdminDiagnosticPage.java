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
		driver.findElement(By.xpath("//*[@id='zoyloCustLogin-form']/div/div[2]/div/div/div/div/button")).click();			
		Browser.waitFortheID("tabs");
		Thread.sleep(2000);
	}
	
	public void ClickOnDiagnosticMenu(){
		
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.Diagnostic_Menu)).click();
	}
	
	public void ClickOnAddDiagnostic(){
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Diagnostic_ClickOnAddDiagnostic)).click();
	}
	
	public void EnterDiagnosticDetails(String DiagnosticName,String ShortName,String fullname,String email,String phone,String password) throws Exception{
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticCenter_Name)).sendKeys(DiagnosticName);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticCenter_ShortName)).sendKeys(ShortName);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticCenter_fullname)).sendKeys(fullname);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticCenter_email)).sendKeys(email);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticCenter_phone)).sendKeys(phone);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticCenter_password)).sendKeys(password);
	}
	
	public void EnterMandatoryFields(String dateofbirth,String desc,String regno,String dateofreg,String rating,String startedyear) throws Exception{
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MandatoryFields_dateofbirth)).clear();
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MandatoryFields_dateofbirth)).sendKeys(dateofbirth);
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MandatoryFields_desc)).sendKeys(desc);
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MandatoryFields_regno)).sendKeys(regno);
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MandatoryFields_dateofreg)).clear();
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MandatoryFields_dateofreg)).sendKeys(dateofreg);
		Thread.sleep(2000);
		Browser.selectbyid(Elements_NewAdminDiagnostic.MandatoryFields_StatusCode, "approved");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[4]")).click();
		Browser.selectbyid(Elements_NewAdminDiagnostic.MandatoryFields_languagesSpoken, "ENGLISH");
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MandatoryFields_rating)).sendKeys(rating);
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MandatoryFields_startedyear)).sendKeys(startedyear);
		
		
	}
	
	public void EnterHomeVisitDetails(String homevisitvalue,String charge,String range,String appperslot,String mvalue,String starttime,String endtime,
			String tvalue,String tstarttime,String tendtime,String Wvalue,String Wstarttime,String Wendtime,String thvalue,String thstarttime,String thendtime,
			String fvalue,String fstarttime,String fendtime,String Svalue,String Sstarttime,String Sendtime) 
			throws Exception{
		
		if(homevisitvalue.equalsIgnoreCase("true")){
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_Menu)).click();	
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_Active)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_Charge)).sendKeys(charge);	
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_ServiceRange)).sendKeys(range);	
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_SlotDuration)).sendKeys("15");	
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AppointmentsPerSlot)).sendKeys(appperslot);	
		Thread.sleep(1000);
		if(mvalue.equalsIgnoreCase("true")){
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_Monday)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursMonday)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime)).sendKeys(starttime);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime)).sendKeys(endtime);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit)).click();
			Thread.sleep(3000);
			
		}//mvalue
		else{
		System.out.println("Monday slots are not provided");
		}
		
		if(tvalue.equalsIgnoreCase("true")){
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_Tuesday)).click();
			Thread.sleep(3000);			
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursTuesday)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime)).sendKeys(tstarttime);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime)).sendKeys(tendtime);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit)).click();
			Thread.sleep(3000);
		}//tvalue
		else{
		System.out.println("Tuesday slots are not provided");
		}
		if(Wvalue.equalsIgnoreCase("true")){
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HomeVisit_Wednesday)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursWednesday)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime)).sendKeys(Wstarttime);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime)).sendKeys(Wendtime);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit)).click();
			Thread.sleep(3000);
		}//Wvalue
		else{
		System.out.println("Wednesday slots are not provided");
		}
		if(thvalue.equalsIgnoreCase("true")){
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_Thursday)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursThursday)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime)).sendKeys(thstarttime);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime)).sendKeys(thendtime);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit)).click();
			Thread.sleep(3000);
		}//thvalue
		else{
		System.out.println("Thursday slots are not provided");
		}
		if(fvalue.equalsIgnoreCase("true")){
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_Friday)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVistHoursFriday)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime)).sendKeys(fstarttime);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime)).sendKeys(fendtime);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit)).click();
			Thread.sleep(3000);
		}//fvalue
		else{
		System.out.println("Friday slots are not provided");
		}
		if(Svalue.equalsIgnoreCase("true")){
			driver.findElement(By.id("saturday")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='dcHomeVisitSat']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime)).sendKeys(Sstarttime);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime)).sendKeys(Sendtime);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursSubmit)).click();
		}//mvalue
		else{
		System.out.println("Saturday slots are not provided");
		}
			
		}//homevisitvalue
		else{
			System.out.println("HomeVisit Appointment is Not Available");
		}
	}
	
	public void EnterLabVisitDetails(String labslotduration,String labapptperslot,String Lmvalue,String Lmstarttime,String Lmendtime,
		String Ltvalue,String Ltstarttime,String Ltendtime,String LWvalue,String LWstarttime,String LWendtime,String LThvalue,String LThstarttime,
		String LThendtime,String Lfvalue,String Lfstarttime,String Lfendtime,String LSvalue,String LSstarttime,String LSendtime) throws Exception{
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_Menu)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_SlotDuration)).sendKeys(labslotduration);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AppointmentsPerSlot)).sendKeys(labapptperslot);
		Thread.sleep(1000);
		if(Lmvalue.equalsIgnoreCase("true")){
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_Monday)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursMonday)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursActive)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime)).sendKeys(Lmstarttime);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime)).sendKeys(Lmendtime);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursSubmit)).click();
			Thread.sleep(3000);
		}else{
			System.out.println("Monday Lab Slot are Unavilable");
		}
		if(Ltvalue.equalsIgnoreCase("true")){
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_Tuesday)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursTuesday)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursActive)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime)).sendKeys(Ltstarttime);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime)).sendKeys(Ltendtime);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursSubmit)).click();
			Thread.sleep(3000);
		}else{
			System.out.println("Tuesday Lab Slot are Unavilable");
		}
		if(LWvalue.equalsIgnoreCase("true")){
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_Wednesday)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursWednesday)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursActive)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime)).sendKeys(LWstarttime);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime)).sendKeys(LWendtime);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursSubmit)).click();
			Thread.sleep(3000);
		}else{
			System.out.println("Wednesday Lab Slot are Unavilable");
		}
		if(LThvalue.equalsIgnoreCase("true")){
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_Thursday)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursThursday)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursActive)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime)).sendKeys(LThstarttime);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime)).sendKeys(LThendtime);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursSubmit)).click();
			Thread.sleep(3000);
		}else{
			System.out.println("Thursday Lab Slot are Unavilable");
		}
		if(Lfvalue.equalsIgnoreCase("true")){
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_Friday)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursFriday)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursActive)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime)).sendKeys(Lfstarttime);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime)).sendKeys(Lfendtime);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursSubmit)).click();
			Thread.sleep(3000);
		}else{
			System.out.println("Friday Lab Slot are Unavilable");
		}
		
		if(LSvalue.equalsIgnoreCase("true")){
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_Saturday)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursSaturday)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursActive)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursStartTime)).sendKeys(LSstarttime);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursEndTime)).sendKeys(LSendtime);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_AddLabVisitHoursSubmit)).click();
		}else{
			System.out.println("Saturday Lab Slot are Unavilable");
		}
	}
	
	
	
	public void ClickOnPackageAndTestsMenu() throws Exception{
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.PackageandTests_Menu)).click();
		Thread.sleep(1000);
	}
	
	
	
	public void AddHealthPackages(String servicemode,String packagename,String packagedesc,String packagecost, String discountpercentage,
	String zoylopercentage,String packageduration,String packageperslot		) throws Exception{
		
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HealthPackage_AddPackage)).click();
		Thread.sleep(2000);
		WebElement element=driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_Status));
		Select se=new Select(element);
		se.selectByValue("approved");
		Thread.sleep(1000);
		if(servicemode.equalsIgnoreCase("Lab Visit")){
			
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_ClickOnServiceMode)).click();
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HealthPackage_LabVisit)).click();
		}else{
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_ClickOnServiceMode)).click();
			driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HealthPackage_HomeVisit)).click();
		}
		
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_packageName)).sendKeys(packagename);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_packageDescription)).sendKeys(packagedesc);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_packageCost)).sendKeys(packagecost);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_discountPercentage)).sendKeys(discountpercentage);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_zoyloChargePercentage)).sendKeys(zoylopercentage);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_averageDuration)).sendKeys(packageduration);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_PackagesPerSlot)).sendKeys(packageperslot);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_PackagesActive)).click();
		Thread.sleep(1000);
		
	}
	
	
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
	
	public void SaveAddHealthPackages() throws Exception{
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HealthPackage_Save)).click();
		Thread.sleep(2000);
		
	}

	
	public void CreateDiagnosticTests(String diagTestname,String diagTestdesc,String servicemode,String diagTestcost,String diagdiscountper,
	String diagZoyloper,String diagduration,String diagNumofSlots	) throws Exception{
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_Menu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.DiagnosticTests_AddTests)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_TestName)).sendKeys(diagTestname);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_TestDescription)).sendKeys(diagTestdesc);
		Thread.sleep(1000);
		Browser.selectbyid(Elements_NewAdminDiagnostic.DiagnosticTests_AdminStatus, "approved");
		Thread.sleep(1000);
		if(servicemode.equalsIgnoreCase("Lab Visit")){
			Browser.selectbyid("diagServiceMode", "C");
		}else{
			Browser.selectbyid("diagServiceMode", "H");
		}
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_TestCost)).sendKeys(diagTestcost);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_DiscountPercentage)).sendKeys(diagdiscountper);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_ZoyloChargePercentage)).sendKeys(diagZoyloper);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_AverageDuration)).sendKeys(diagduration);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_TestsPerSlot)).sendKeys(diagNumofSlots);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_TestActive)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_TestSave)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticTests_TestCancel)).click();
		Thread.sleep(3000);
	}
	
	
	public void  EnterAdditionalContactInformation(String Personname,String PersonPhone,String PersonEmail,String PersonFax) throws Exception{
		driver.findElement(By.id(Elements_NewAdminDiagnostic.AdditionalInformation_Menu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.ContactPerson_AddContact)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.ContactPerson_Name)).sendKeys(Personname);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.ContactPerson_Phone)).sendKeys(PersonPhone);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.ContactPerson_Email)).sendKeys(PersonEmail);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.ContactPerson_Fax)).sendKeys(PersonFax);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.ContactPerson_Save)).click();
		Thread.sleep(2000);
	}
	
	
	public void EnterMarkedasClosedInformation(String startdate,String enddate) throws Exception{
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MarkedasClosed_Menu)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MarkedasClosed_Add)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MarkedasClosed_startdate)).clear();
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MarkedasClosed_startdate)).sendKeys(startdate);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MarkedasClosed_enddate)).clear();
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MarkedasClosed_enddate)).sendKeys(enddate);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MarkedasClosed_Active)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.MarkedasClosed_Save)).click();
		Thread.sleep(2000);
	}
	
	public void EnterOtherInformationdetails(String discountoffered,String websiteURL,String accreditations,String ngo,String reportonline) throws Exception{
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.OtherInformation_Menu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.OtherInformation_Discountoffered)).sendKeys(discountoffered);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.OtherInformation_NABL)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.OtherInformation_websiteURL)).sendKeys(websiteURL);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.OtherInformation_accreditations)).sendKeys(accreditations);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.OtherInformation_NGO)).sendKeys(ngo);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.OtherInformation_reportOnlineduration)).sendKeys(reportonline);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.OtherInformation_isOnline)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.OtherInformation_isSelfCheckIn)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.OtherInforamtion_isReportOnline)).click();
		Thread.sleep(2000);
	}
	
	
	public void EnterSocialInformation(String facebookurl,String googleurl,String linkedinurl,String twiterurl) throws Exception{
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Social_Menu)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Social_Facebook)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Social_FaceboolURL)).sendKeys(facebookurl);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Social_GooglePlus)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Social_GooglePlusURL)).sendKeys(googleurl);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Social_LinkedIn)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Social_LinkedInURL)).sendKeys(linkedinurl);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Social_Twitter)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Social_TwitterURL)).sendKeys(twiterurl);
		Thread.sleep(2000);
	}
	
	
	public void EnterAddressDetails(String address, String country,String state,String city,String pincode,String locality,String landmark,
			String longitude,String latitude) throws Exception{
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Address_Menu)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Address_Line1)).sendKeys(address);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Address_ClickOnCountry)).click();
		Browser.selectbyID(Elements_NewAdminDiagnostic.Address_Country, country);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Address_ClicOnState)).click();
		Browser.selectbyID(Elements_NewAdminDiagnostic.Address_State, state);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Address_ClickOnCity)).click();
		Browser.selectbyID(Elements_NewAdminDiagnostic.Address_City, city);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Address_Pincode)).sendKeys(pincode);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Address_Locality)).sendKeys(locality);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Address_Landmark)).sendKeys(landmark);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Address_Longitude)).sendKeys(longitude);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Address_latitude)).sendKeys(latitude);
		Thread.sleep(2000);
	}
	
	
	public void EnterTheFacilities() throws Exception{
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Facilities_Menu)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Facilities_DebitCard)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Facilities_Bike)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Facilities_CreditCard)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Facilities_CarParking)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Facilities_ambulance)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Facilities_proBono)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Facilities_onlinePayment)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Facilities_Premium)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Facilities_Cheque)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.Facilities_Emergency)).click();
		Thread.sleep(2000);
	}
	
	
	public void EnterDetailsForSEO(String SEOtitle,String SEOdesc,String SEOkeywords,String SEOurl) throws Exception{
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.SEO_Menu)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.SEO_Title)).sendKeys(SEOtitle);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.SEO_Desc)).sendKeys(SEOdesc);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.SEO_Keywords)).sendKeys(SEOkeywords);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.SEO_URL)).sendKeys(SEOurl);
		Thread.sleep(2000);
		
	}
	
	public void SaveDiagnosticDetails() throws Exception{
		driver.findElement(By.id(Elements_NewAdminDiagnostic.AddDiagnostic_Submit)).click();
		Thread.sleep(2000);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
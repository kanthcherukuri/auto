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
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_Menu)).click();	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_Active)).click();
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_Charge)).sendKeys(charge);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_ServiceRange)).sendKeys(range);	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_SlotDuration)).sendKeys("15");	
		driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AppointmentsPerSlot)).sendKeys(appperslot);	
		Thread.sleep(1000);
		if(mvalue.equalsIgnoreCase("true")){
			
			//System.out.println("its in Monday");
			driver.findElement(By.id("sunday")).click();
			Thread.sleep(1500);
			driver.findElement(By.id("monday")).click();
			Browser.clickOnTheElementByXpath("(//button[@data-target='#zoyDiagAddHomeVisitTimings'])[2]/i");
			//driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursMonday)).click();
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHoursActive)).click();
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime)).sendKeys(starttime);
			Thread.sleep(500);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime)).sendKeys(endtime);
			Thread.sleep(500);
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
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime)).sendKeys(tstarttime);
			Thread.sleep(500);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime)).sendKeys(tendtime);
			Thread.sleep(500);
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
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime)).sendKeys(Wstarttime);
			Thread.sleep(500);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime)).sendKeys(Wendtime);
			Thread.sleep(500);
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
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime)).sendKeys(thstarttime);
			Thread.sleep(500);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime)).sendKeys(thendtime);
			Thread.sleep(500);
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
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime)).sendKeys(fstarttime);
			Thread.sleep(500);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime)).sendKeys(fendtime);
			Thread.sleep(500);
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
			Browser.waitFortheID(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursStartTime)).sendKeys(Sstarttime);
			Thread.sleep(500);
			driver.findElement(By.id(Elements_NewAdminDiagnostic.HomeVisit_AddHomeVisitHoursEndTime)).sendKeys(Sendtime);
			Thread.sleep(500);
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
		driver.findElement(By.id(Elements_NewAdminDiagnostic.AddDiagnostic_Submit)).click();
		Thread.sleep(2000);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
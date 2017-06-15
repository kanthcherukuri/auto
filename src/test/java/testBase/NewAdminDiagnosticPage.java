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
		
		driver.findElement(By.xpath("//*[@id='tabs']/li[3]/a/div/div/a")).click();
	}
	
	public void ClickOnAddDiagnostic(){
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.ClickOnAddDiagnostic)).click();
	}
	
	public void EnterDiagnosticDetails(String DiagnosticName,String ShortName,String fullname,String email,String phone,String password) throws Exception{
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.DiagnosticName)).sendKeys(DiagnosticName);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.ShortName)).sendKeys(ShortName);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.fullname)).sendKeys(fullname);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.email)).sendKeys(email);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.phone)).sendKeys(phone);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.password)).sendKeys(password);
	}
	
	public void EnterMandatoryFields(String dateofbirth,String desc,String regno,String dateofreg,String rating,String startedyear) throws Exception{
		
		driver.findElement(By.id(Elements_NewAdminDiagnostic.dateofbirth)).clear();
		driver.findElement(By.id(Elements_NewAdminDiagnostic.dateofbirth)).sendKeys(dateofbirth);
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.desc)).sendKeys(desc);
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.regno)).sendKeys(regno);
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.dateofreg)).clear();
		driver.findElement(By.id(Elements_NewAdminDiagnostic.dateofreg)).sendKeys(dateofreg);
		Thread.sleep(2000);
		WebElement element=driver.findElement(By.id("zoyloStatusCode"));
		Select se=new Select(element);
		se.selectByValue("approved");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[4]")).click();
		WebElement ele=driver.findElement(By.id("languagesSpoken"));
		Select opt=new Select(ele);
		opt.selectByValue("ENGLISH");
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.rating)).sendKeys(rating);
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.startedyear)).sendKeys(startedyear);
		
		
	}
	
	public void EnterHomeVisitDetails(String homevisitvalue,String charge,String range,String appperslot,String mvalue,String starttime,String endtime,
			String tvalue,String tstarttime,String tendtime,String Wvalue,String Wstarttime,String Wendtime,String thvalue,String thstarttime,String thendtime,
			String fvalue,String fstarttime,String fendtime,String Svalue,String Sstarttime,String Sendtime) 
			throws Exception{
		
		if(homevisitvalue.equalsIgnoreCase("true")){
		driver.findElement(By.id("homeVisitTab")).click();	
		Thread.sleep(1000);
		driver.findElement(By.id("doesHomeVisit")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("homeVisitCharge")).sendKeys(charge);	
		Thread.sleep(1000);
		driver.findElement(By.id("homeVisitServiceRangeKms")).sendKeys(range);	
		Thread.sleep(1000);
		driver.findElement(By.id("homeVisitSlotDuration")).sendKeys("15");	
		Thread.sleep(1000);
		driver.findElement(By.id("homeVisitAppointmentsPerSlot")).sendKeys(appperslot);	
		Thread.sleep(1000);
		if(mvalue.equalsIgnoreCase("true")){
			driver.findElement(By.id("monday")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='dcHomeVisitMon']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isHomeActive")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("workHomeStartTime")).sendKeys(starttime);
			Thread.sleep(1000);
			driver.findElement(By.id("workHomeEndTime")).sendKeys(endtime);
			Thread.sleep(1000);
			driver.findElement(By.id("workingHrsSubmit")).click();
			Thread.sleep(3000);
			
		}//mvalue
		else{
		System.out.println("Monday slots are not provided");
		}
		
		if(tvalue.equalsIgnoreCase("true")){
			driver.findElement(By.id("tuesday")).click();
			Thread.sleep(3000);			
			driver.findElement(By.xpath("//*[@id='dcHomeVisitTue']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isHomeActive")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("workHomeStartTime")).sendKeys(tstarttime);
			Thread.sleep(1000);
			driver.findElement(By.id("workHomeEndTime")).sendKeys(tendtime);
			Thread.sleep(1000);
			driver.findElement(By.id("workingHrsSubmit")).click();
			Thread.sleep(3000);
		}//tvalue
		else{
		System.out.println("Tuesday slots are not provided");
		}
		if(Wvalue.equalsIgnoreCase("true")){
			driver.findElement(By.xpath("//a[@href='#dcHomeVisitWed']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='dcHomeVisitWed']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isHomeActive")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("workHomeStartTime")).sendKeys(Wstarttime);
			Thread.sleep(1000);
			driver.findElement(By.id("workHomeEndTime")).sendKeys(Wendtime);
			Thread.sleep(1000);
			driver.findElement(By.id("workingHrsSubmit")).click();
			Thread.sleep(3000);
		}//Wvalue
		else{
		System.out.println("Wednesday slots are not provided");
		}
		if(thvalue.equalsIgnoreCase("true")){
			driver.findElement(By.id("thursday")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='dcHomeVisitThu']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isHomeActive")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("workHomeStartTime")).sendKeys(thstarttime);
			Thread.sleep(1000);
			driver.findElement(By.id("workHomeEndTime")).sendKeys(thendtime);
			Thread.sleep(1000);
			driver.findElement(By.id("workingHrsSubmit")).click();
			Thread.sleep(3000);
		}//thvalue
		else{
		System.out.println("Thursday slots are not provided");
		}
		if(fvalue.equalsIgnoreCase("true")){
			driver.findElement(By.id("friday")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='dcHomeVisitFri']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isHomeActive")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("workHomeStartTime")).sendKeys(fstarttime);
			Thread.sleep(1000);
			driver.findElement(By.id("workHomeEndTime")).sendKeys(fendtime);
			Thread.sleep(1000);
			driver.findElement(By.id("workingHrsSubmit")).click();
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
			driver.findElement(By.id("isHomeActive")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("workHomeStartTime")).sendKeys(Sstarttime);
			Thread.sleep(1000);
			driver.findElement(By.id("workHomeEndTime")).sendKeys(Sendtime);
			Thread.sleep(1000);
			driver.findElement(By.id("workingHrsSubmit")).click();
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
		
		driver.findElement(By.id("labVisitTab")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("clinicSlotDuration")).sendKeys(labslotduration);
		Thread.sleep(1000);
		driver.findElement(By.id("clinicAppointmentsPerSlot")).sendKeys(labapptperslot);
		Thread.sleep(1000);
		if(Lmvalue.equalsIgnoreCase("true")){
			driver.findElement(By.xpath("//a[@href='#dcLabVisitMon']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='dcLabVisitMon']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isLabVisitActive")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("workLabStartTime")).sendKeys(Lmstarttime);
			Thread.sleep(1000);
			driver.findElement(By.id("workLabEndTime")).sendKeys(Lmendtime);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//*[@id='workingHrsSubmit'])[2]")).click();
			Thread.sleep(3000);
		}else{
			System.out.println("Monday Lab Slot are Unavilable");
		}
		if(Ltvalue.equalsIgnoreCase("true")){
			driver.findElement(By.xpath("//a[@href='#dcLabVisitTue']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='dcLabVisitTue']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isLabVisitActive")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("workLabStartTime")).sendKeys(Ltstarttime);
			Thread.sleep(1000);
			driver.findElement(By.id("workLabEndTime")).sendKeys(Ltendtime);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//*[@id='workingHrsSubmit'])[2]")).click();
			Thread.sleep(3000);
		}else{
			System.out.println("Tuesday Lab Slot are Unavilable");
		}
		if(LWvalue.equalsIgnoreCase("true")){
			driver.findElement(By.xpath("//a[@href='#dcLabVisitWed']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='dcLabVisitWed']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isLabVisitActive")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("workLabStartTime")).sendKeys(LWstarttime);
			Thread.sleep(1000);
			driver.findElement(By.id("workLabEndTime")).sendKeys(LWendtime);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//*[@id='workingHrsSubmit'])[2]")).click();
			Thread.sleep(3000);
		}else{
			System.out.println("Wednesday Lab Slot are Unavilable");
		}
		if(LThvalue.equalsIgnoreCase("true")){
			driver.findElement(By.xpath("//a[@href='#dcLabVisitThu']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='dcLabVisitThu']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isLabVisitActive")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("workLabStartTime")).sendKeys(LThstarttime);
			Thread.sleep(1000);
			driver.findElement(By.id("workLabEndTime")).sendKeys(LThendtime);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//*[@id='workingHrsSubmit'])[2]")).click();
			Thread.sleep(3000);
		}else{
			System.out.println("Thursday Lab Slot are Unavilable");
		}
		if(Lfvalue.equalsIgnoreCase("true")){
			driver.findElement(By.xpath("//a[@href='#dcLabVisitFri']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='dcLabVisitFri']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isLabVisitActive")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("workLabStartTime")).sendKeys(Lfstarttime);
			Thread.sleep(1000);
			driver.findElement(By.id("workLabEndTime")).sendKeys(Lfendtime);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//*[@id='workingHrsSubmit'])[2]")).click();
			Thread.sleep(3000);
		}else{
			System.out.println("Friday Lab Slot are Unavilable");
		}
		
		if(LSvalue.equalsIgnoreCase("true")){
			driver.findElement(By.xpath("//a[@href='#dcLabVisitSat']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='dcLabVisitSat']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isLabVisitActive")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("workLabStartTime")).sendKeys(LSstarttime);
			Thread.sleep(1000);
			driver.findElement(By.id("workLabEndTime")).sendKeys(LSendtime);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//*[@id='workingHrsSubmit'])[2]")).click();
		}else{
			System.out.println("Saturday Lab Slot are Unavilable");
		}
	}
	
	
	
	public void ClickOnPackageAndTestsMenu() throws Exception{
		
		driver.findElement(By.id("packageAndTestsTab")).click();
		Thread.sleep(1000);
	}
	
	
	
	public void AddHealthPackages(String servicemode,String packagename,String packagedesc,String packagecost, String discountpercentage,
	String zoylopercentage,String packageduration,String packageperslot		) throws Exception{
		
		driver.findElement(By.xpath("//*[@id='zoyDiagPackHealth']/div/div[1]/button")).click();
		Thread.sleep(2000);
		WebElement element=driver.findElement(By.id("adminStatus"));
		Select se=new Select(element);
		se.selectByValue("approved");
		Thread.sleep(1000);
		if(servicemode.equalsIgnoreCase("Lab Visit")){
			
			driver.findElement(By.id("select2-serviceMode-container")).click();
			driver.findElement(By.xpath("//*[@id='select2-serviceMode-results']/li[2]")).click();
		}else{
			driver.findElement(By.id("select2-serviceMode-container")).click();
			driver.findElement(By.xpath("//*[@id='select2-serviceMode-results']/li[3]")).click();
		}
		
		Thread.sleep(1000);
		driver.findElement(By.id("packageName")).sendKeys(packagename);
		Thread.sleep(1000);
		driver.findElement(By.id("packageDescription")).sendKeys(packagedesc);
		Thread.sleep(1000);
		driver.findElement(By.id("packageCost")).sendKeys(packagecost);
		Thread.sleep(1000);
		driver.findElement(By.id("discountPercentage")).sendKeys(discountpercentage);
		Thread.sleep(1000);
		driver.findElement(By.id("zoyloChargePercentage")).sendKeys(zoylopercentage);
		Thread.sleep(1000);
		driver.findElement(By.id("averageDuration")).sendKeys(packageduration);
		Thread.sleep(1000);
		driver.findElement(By.id("averageNumberOfPackagesPerSlot")).sendKeys(packageperslot);
		Thread.sleep(1000);
		driver.findElement(By.id("isPackagesActive")).click();
		Thread.sleep(1000);
		
	}
	
	
	public void AddTestsInHealthPackage(String testname,String testdesc) throws Exception{
		
		driver.findElement(By.xpath("//*[@id='zoyDCAddHealthPackageForm']/div/div/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("testName")).sendKeys(testname);
		Thread.sleep(1000);
		driver.findElement(By.id("testDescription")).sendKeys(testdesc);
		Thread.sleep(1000);
		driver.findElement(By.id("isTestActive")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("zoyPackageTestSave")).click();
		Thread.sleep(1000);
	}
	
	
	public void SaveAddHealthPackages(){
		
		driver.findElement(By.id("diagPackagesSave")).click();
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
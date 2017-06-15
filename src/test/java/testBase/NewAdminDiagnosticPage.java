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
		driver.findElement(By.id(Elements_NewAdminDiagnostic.dateofbirth)).sendKeys(dateofbirth);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.desc)).sendKeys(desc);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.regno)).sendKeys(regno);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.dateofreg)).sendKeys(dateofreg);
		Thread.sleep(1000);
		WebElement element=driver.findElement(By.id("zoyloStatusCode"));
		Select se=new Select(element);
		se.selectByValue("approved");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[4]")).click();
		WebElement ele=driver.findElement(By.id("languagesSpoken"));
		Select opt=new Select(ele);
		opt.selectByValue("ENGLISH");
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.rating)).sendKeys(rating);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDiagnostic.startedyear)).sendKeys(startedyear);
		
		
	}
	
	public void EnterHomeVisit(String homevisitvalue,String charge,String range,String appperslot,String mvalue,String starttime,String endtime,
			String tvalue,String tstarttime,String tendtime,String Wvalue,String Wstarttime,String Wendtime,String thvalue,String thstarttime,String thendtime,
			String fvalue,String fstarttime,String fendtime,String Svalue,String Sstarttime,String Sendtime) 
			throws Exception{
		
		if(homevisitvalue.equalsIgnoreCase("true")){
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
			driver.findElement(By.xpath("/*[@id='dcHomeVisitMon']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isHomeActive")).click();
			driver.findElement(By.id("workHomeStartTime")).sendKeys(starttime);
			driver.findElement(By.id("workHomeEndTime")).sendKeys(endtime);
			driver.findElement(By.id("workingHrsSubmit")).click();
		}//mvalue
		else{
		System.out.println("Monday slots are not provided");
		}
		
		if(tvalue.equalsIgnoreCase("true")){
			driver.findElement(By.id("tuesday")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/*[@id='dcHomeVisitMon']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isHomeActive")).click();
			driver.findElement(By.id("workHomeStartTime")).sendKeys(tstarttime);
			driver.findElement(By.id("workHomeEndTime")).sendKeys(tendtime);
			driver.findElement(By.id("workingHrsSubmit")).click();
		}//tvalue
		else{
		System.out.println("Tuesday slots are not provided");
		}
		if(Wvalue.equalsIgnoreCase("true")){
			driver.findElement(By.id("wednesday")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/*[@id='dcHomeVisitMon']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isHomeActive")).click();
			driver.findElement(By.id("workHomeStartTime")).sendKeys(Wstarttime);
			driver.findElement(By.id("workHomeEndTime")).sendKeys(Wendtime);
			driver.findElement(By.id("workingHrsSubmit")).click();
		}//Wvalue
		else{
		System.out.println("Wednesday slots are not provided");
		}
		if(thvalue.equalsIgnoreCase("true")){
			driver.findElement(By.id("thursday")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/*[@id='dcHomeVisitMon']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isHomeActive")).click();
			driver.findElement(By.id("workHomeStartTime")).sendKeys(thstarttime);
			driver.findElement(By.id("workHomeEndTime")).sendKeys(thendtime);
			driver.findElement(By.id("workingHrsSubmit")).click();
		}//thvalue
		else{
		System.out.println("Thursday slots are not provided");
		}
		if(fvalue.equalsIgnoreCase("true")){
			driver.findElement(By.id("friday")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/*[@id='dcHomeVisitMon']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isHomeActive")).click();
			driver.findElement(By.id("workHomeStartTime")).sendKeys(fstarttime);
			driver.findElement(By.id("workHomeEndTime")).sendKeys(fendtime);
			driver.findElement(By.id("workingHrsSubmit")).click();
		}//fvalue
		else{
		System.out.println("Friday slots are not provided");
		}
		if(Svalue.equalsIgnoreCase("true")){
			driver.findElement(By.id("saturday")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/*[@id='dcHomeVisitMon']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isHomeActive")).click();
			driver.findElement(By.id("workHomeStartTime")).sendKeys(Sstarttime);
			driver.findElement(By.id("workHomeEndTime")).sendKeys(Sendtime);
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
	
	public void Enterlabvisitdetails(String labslotduration,String labapptperslot,String Lmvalue,String Lmstarttime,String Lmendtime,
		String Ltvalue,String Ltstarttime,String Ltendtime,String LWvalue,String LWstarttime,String LWendtime,String LThvalue,String LThstarttime,
		String LThendtime,String Lfvalue,String Lfstarttime,String Lfendtime,String LSvalue,String LSstarttime,String LSendtime) throws Exception{
		
		driver.findElement(By.id("labVisitTab")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("clinicSlotDuration")).sendKeys(labslotduration);
		Thread.sleep(1000);
		driver.findElement(By.id("clinicAppointmentsPerSlot")).sendKeys(labapptperslot);
		Thread.sleep(1000);
		if(Lmvalue.equalsIgnoreCase("true")){
			driver.findElement(By.id("monday")).click();
			driver.findElement(By.xpath("//*[@id='dcLabVisitMon']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isLabVisitActive")).click();
			driver.findElement(By.id("workLabStartTime")).sendKeys(Lmstarttime);
			driver.findElement(By.id("workLabEndTime")).sendKeys(Lmendtime);
			driver.findElement(By.id("workingHrsSubmit")).click();
		}else{
			System.out.println("Monday Lab Slot are Unavilable");
		}
		if(Ltvalue.equalsIgnoreCase("true")){
			driver.findElement(By.id("tuesday")).click();
			driver.findElement(By.xpath("//*[@id='dcLabVisitMon']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isLabVisitActive")).click();
			driver.findElement(By.id("workLabStartTime")).sendKeys(Ltstarttime);
			driver.findElement(By.id("workLabEndTime")).sendKeys(Ltendtime);
			driver.findElement(By.id("workingHrsSubmit")).click();
		}else{
			System.out.println("Tuesday Lab Slot are Unavilable");
		}
		if(LWvalue.equalsIgnoreCase("true")){
			driver.findElement(By.id("wednesday")).click();
			driver.findElement(By.xpath("//*[@id='dcLabVisitMon']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isLabVisitActive")).click();
			driver.findElement(By.id("workLabStartTime")).sendKeys(LWstarttime);
			driver.findElement(By.id("workLabEndTime")).sendKeys(LWendtime);
			driver.findElement(By.id("workingHrsSubmit")).click();
		}else{
			System.out.println("Wednesday Lab Slot are Unavilable");
		}
		if(LThvalue.equalsIgnoreCase("true")){
			driver.findElement(By.id("thursday")).click();
			driver.findElement(By.xpath("//*[@id='dcLabVisitMon']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isLabVisitActive")).click();
			driver.findElement(By.id("workLabStartTime")).sendKeys(LThstarttime);
			driver.findElement(By.id("workLabEndTime")).sendKeys(LThendtime);
			driver.findElement(By.id("workingHrsSubmit")).click();
		}else{
			System.out.println("Thursday Lab Slot are Unavilable");
		}
		if(Lfvalue.equalsIgnoreCase("true")){
			driver.findElement(By.id("friday")).click();
			driver.findElement(By.xpath("//*[@id='dcLabVisitMon']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isLabVisitActive")).click();
			driver.findElement(By.id("workLabStartTime")).sendKeys(Lfstarttime);
			driver.findElement(By.id("workLabEndTime")).sendKeys(Lfendtime);
			driver.findElement(By.id("workingHrsSubmit")).click();
		}else{
			System.out.println("Friday Lab Slot are Unavilable");
		}
		
		if(LSvalue.equalsIgnoreCase("true")){
			driver.findElement(By.id("saturday")).click();
			driver.findElement(By.xpath("//*[@id='dcLabVisitMon']/div[1]/div[4]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("isLabVisitActive")).click();
			driver.findElement(By.id("workLabStartTime")).sendKeys(LSstarttime);
			driver.findElement(By.id("workLabEndTime")).sendKeys(LSendtime);
			driver.findElement(By.id("workingHrsSubmit")).click();
		}else{
			System.out.println("Saturday Lab Slot are Unavilable");
		}
		
		
		
		
		
		
		
	}
}
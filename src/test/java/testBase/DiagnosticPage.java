package testBase;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import testBase.*;

import objectRepository.Elements_Diagnostics;

public class DiagnosticPage {
	
	public    WebDriver driver;
	public TestUtils Browser;
	
	public DiagnosticPage(WebDriver driver) throws Exception{
		this.driver=driver;
		Browser= new TestUtils(driver); 
		Elements_Diagnostics.Diag_PageProperties();
	}
	
	
	
	// Doctors login Details 
	public  void SignIn(String username, String password) throws IOException{	
		
			Browser.waitFortheID("emailAddress");	
			driver.findElement(By.id(Elements_Diagnostics.username)).sendKeys(username);
			driver.findElement(By.id(Elements_Diagnostics.password)).sendKeys(password);	
			driver.findElement(By.xpath(Elements_Diagnostics.loginbutton)).click();	
			}
		
	
	
	public void DiagnosticAppointmentForHomeVisit(String firstname,String lastname,String mobile,String email,String address,String problem) throws Exception{
		
		driver.findElement(By.id(Elements_Diagnostics.clickonappointmentsmenu)).click();
		Thread.sleep(3000);
		Actions action=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath(Elements_Diagnostics.clickontoggle));
		action.moveToElement(ele);
		action.click().build().perform();
		Thread.sleep(1000);
		//System.out.println("Home Visit Toggle is Selected");
		driver.findElement(By.xpath(Elements_Diagnostics.tommorowmenu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.morninghomevisit)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.noonhomevisit)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.eveninghomevisit)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.eveningfirstcell)).click();
		//details
		driver.findElement(By.id(Elements_Diagnostics.detailsfirstname)).sendKeys(firstname);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.detailslastname)).sendKeys(lastname);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.detailsmobile)).sendKeys(mobile);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.detailsemail)).sendKeys(email);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.detailsaddress)).sendKeys(address);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.detailsproblem)).sendKeys(problem);
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.packagetab)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.packagecheckbox)).click();
		Thread.sleep(2000);
		WebElement sc = driver.findElement(By.id(Elements_Diagnostics.windowsavebutton));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sc);
		driver.findElement(By.id(Elements_Diagnostics.windowsavebutton)).click();
		Browser.CheckNotificationMessage("Appointment is confirmed. Patient Name:"+firstname);
	    }
	
	
	
	
	public void ClickingOnEllipse() throws Exception{
		driver.findElement(By.xpath(Elements_Diagnostics.ellipse)).click();
		Thread.sleep(5000);
	   }
	
		
	public void diagnosticlogout() throws Exception{
		driver.findElement(By.id(Elements_Diagnostics.clickonmyaccountmenu)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(Elements_Diagnostics.clickonsignout)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Diagnostics.confirmsignout)).click();
	}
		
		
	public void diagnosticrescheduleappointment() throws Exception{
		driver.findElement(By.xpath(Elements_Diagnostics.clickonmore)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Elements_Diagnostics.clickonchange)).click();
		driver.findElement(By.xpath(Elements_Diagnostics.tommorowmenu)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Elements_Diagnostics.nextdaymenu)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Elements_Diagnostics.morninghomevisit)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Elements_Diagnostics.noonhomevisit)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Elements_Diagnostics.eveninghomevisit)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.eveningfirstcell)).click();
		//Thread.sleep(10000);
		Browser.CheckNotificationMessage("Appointment is rescheduled successfully");
		}
	
	
	
	
	public void clickingonappointmentmodification(){
		driver.findElement(By.xpath(Elements_Diagnostics.clickonmore)).click();
	}
  

	
	
	public void CancelAppointmentOfHomeVisit() throws Exception{
		driver.findElement(By.xpath(Elements_Diagnostics.clickoncancel)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Diagnostics.selectbox)).sendKeys("Personal reason");
		Thread.sleep(2000);
		driver.findElement(By.xpath(Elements_Diagnostics.submitbutton)).click();
		Browser.CheckNotificationMessage("Appointment has been Cancelled");

		}
		
	
	
	public void BulkCancellationForHomeVisit() throws Exception{	
		driver.findElement(By.id(Elements_Diagnostics.clickonappointmentsmenu)).click();
		Thread.sleep(3000);
		Actions action=new Actions(driver);
		WebElement toggle=driver.findElement(By.xpath(Elements_Diagnostics.clickontoggle));
		action.moveToElement(toggle);
		action.click().build().perform();
		driver.findElement(By.xpath("//i[@class='pa-cancl-apt fa fa-calendar-times-o cancel-apmpt-btn menu_links']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Elements_Diagnostics.fromcanceldate)).click();
		Thread.sleep(2000);
		List<WebElement> allDates=driver.findElements(By.xpath("//td[@class='day']"));
		for(WebElement ele:allDates)
		{
			boolean date2=ele.isEnabled();
			
			ele.click();
			break;
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath(Elements_Diagnostics.tocanceldate)).click();
		Thread.sleep(2000);
		List<WebElement> CancelToDate=driver.findElements(By.xpath("//td[@class='day']"));
		for(WebElement ele:CancelToDate)
		{	
		String date=ele.getText();
			if(date.equalsIgnoreCase("30"))
			{
				ele.click();
				break;
			}
			
		}//cancletodate
		driver.findElement(By.xpath(Elements_Diagnostics.fromtime)).sendKeys("07:00");
		Thread.sleep(3000);
		driver.findElement(By.xpath(Elements_Diagnostics.totime)).sendKeys("23:00");
		Thread.sleep(2000);
		driver.findElement(By.xpath(Elements_Diagnostics.bulksubmitbutton)).click();
		Browser.CheckNotificationMessage("All Appointments Cancelled between the applied dates");
		
		
		
	}
	
	//DiagnosticAppointmentbooking
	
	public void DiagnosticAppointmentbookingForTomorrow(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		
		driver.findElement(By.id(Elements_Diagnostics.clickonappointmentsmenu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.tommorowmenu)).click();
		driver.findElement(By.xpath(Elements_Diagnostics.morningmenu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.noonmenu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.eveningmenu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.eveningfirstcell)).click();
		driver.findElement(By.id(Elements_Diagnostics.detailsfirstname)).sendKeys(firstname);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.detailslastname)).sendKeys(lastname);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.detailsmobile)).sendKeys(mobile);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.detailsemail)).sendKeys(email);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.detailsproblem)).sendKeys(problem);
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.packagetab)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.packagecheckbox)).click();
		Thread.sleep(5000);
		WebElement sc = driver.findElement(By.id(Elements_Diagnostics.windowsavebutton));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sc);
		driver.findElement(By.id(Elements_Diagnostics.windowsavebutton)).click();
        Browser.CheckNotificationMessage("Appointment is confirmed. Patient Name:"+firstname);

	}
		
	
	public void DiagnosticViewAppointment() throws Exception{
		
		driver.findElement(By.xpath(Elements_Diagnostics.clickonmore)).click();
		Thread.sleep(5000);
		String call=driver.findElement(By.xpath(Elements_Diagnostics.calltext)).getText();
		String change=driver.findElement(By.xpath(Elements_Diagnostics.changetext)).getText();
		String cancel=driver.findElement(By.xpath(Elements_Diagnostics.canceltext)).getText();
		if(call.equalsIgnoreCase("Call")&& change.equalsIgnoreCase("Change")&& cancel.equalsIgnoreCase("Cancel")){
			System.out.println("Appointment Created is Sucessfully view");
		}else{
			
			System.out.println("Appointment Created Is not Sucessfully Viewed");
		}
	}
	
	
	public void DiagnosticAppointmentReschedule() throws Exception{
		
	
		driver.findElement(By.xpath(Elements_Diagnostics.clickonmore)).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(Elements_Diagnostics.clickonchange)).click();
		driver.findElement(By.xpath(Elements_Diagnostics.nextdaymenu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.morningmenu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.noonmenu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.eveningmenu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.eveningfirstcell)).click();
		WebDriverWait wait = (new WebDriverWait(driver, 40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Elements_Diagnostics.notification)));
		String notification=driver.findElement(By.cssSelector(Elements_Diagnostics.topnotification)).getText();
		//System.out.println(notification);
		if(notification.equalsIgnoreCase("Appointment is rescheduled successfully")){
			
			System.out.println("Appointment is rescheduled successfully");
		}else{
			System.out.println("Appointment is not rescheduled ");
			Assert.fail("Appointment is not rescheduled");
		}
	}
	
	
	public void DiagnosticAppointmentForToday(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		driver.findElement(By.id(Elements_Diagnostics.clickonappointmentsmenu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.morningmenu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.noonmenu)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Elements_Diagnostics.eveningmenu)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Elements_Diagnostics.eveningfirstcell)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Diagnostics.detailsfirstname)).sendKeys(firstname);
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Diagnostics.detailslastname)).sendKeys(lastname);
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Diagnostics.detailsmobile)).sendKeys(mobile);
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Diagnostics.detailsemail)).sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Diagnostics.detailsproblem)).sendKeys(problem);
		Thread.sleep(2000);
		driver.findElement(By.xpath(Elements_Diagnostics.packagetab)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Elements_Diagnostics.packagecheckbox)).click();
		Thread.sleep(5000);
		WebElement sc = driver.findElement(By.id(Elements_Diagnostics.windowsavebutton));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sc);
		driver.findElement(By.id(Elements_Diagnostics.windowsavebutton)).click();
		
	}
	
	public void patientserachforintoday(String firstname,String lastname,String email) throws Exception{
		
		driver.findElement(By.id("patients")).click();
		Thread.sleep(8000);
		driver.findElement(By.id("search-bar")).click();
		//driver.findElement(By.xpath("//*[@id='search-bar']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("apt-search")).sendKeys(email);
		 driver.findElement(By.id("apt-search")).sendKeys(Keys.ENTER);
		 Thread.sleep(2000);
		int size= driver.findElements(By.xpath(".//*[@id='sp-diagno-tab-1']/div")).size();
		for(int i=1;i<=size;i++){
			String user= driver.findElement(By.xpath("//*[@id='sp-diagno-tab-1']/div["+i+"]/div/div[2]/div/h1/span[1]/span")).getText();
			String schedule=driver.findElement(By.xpath(".//*[@id='sp-diagno-tab-1']/div["+i+"]/div/div[2]/div/h1/span[2]/p")).getText();
			String fullname=firstname+" "+lastname;
			System.out.println(fullname);
			if(user.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Scheduled")){
				
				WebElement sc = driver.findElement(By.xpath("//*[@id='sp-diagno-tab-1']/div["+i+"]/div/div[2]/div/h1/span[2]/p"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sc);
				driver.findElement(By.xpath("//*[@id='sp-diagno-tab-1']/div["+i+"]/div/div[2]/div/h1/span[1]/span")).click();
				System.out.println("User is sucessfully Verified for booking appointment for Today");
				break;
			}else{
				System.out.println("User  Verification was not sucess for booking appointment for Today");
			}
		}
		}
		
	
	public void DiagnosticAppointmentsBulkCancellation() throws InterruptedException{
		
		driver.findElement(By.id(Elements_Diagnostics.clickonappointmentsmenu)).click();
		driver.findElement(By.xpath("//i[@class='pa-cancl-apt fa fa-calendar-times-o cancel-apmpt-btn menu_links']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Elements_Diagnostics.fromcanceldate)).click();
		Thread.sleep(2000);
		List<WebElement> allDates=driver.findElements(By.xpath("//td[@class='day']"));
		for(WebElement ele:allDates)
		{
			boolean date2=ele.isEnabled();
			ele.click();
			break;
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath(Elements_Diagnostics.tocanceldate)).click();
		Thread.sleep(2000);
		List<WebElement> CancelToDate=driver.findElements(By.xpath("//td[@class='day']"));
		for(WebElement ele:CancelToDate)
		{	
		String date=ele.getText();	
			if(date.equalsIgnoreCase("30"))
			{
				ele.click();
				break;
			}	
		}//cancletodate
		driver.findElement(By.xpath(Elements_Diagnostics.fromtime)).sendKeys("07:00");
		Thread.sleep(3000);
		driver.findElement(By.xpath(Elements_Diagnostics.totime)).sendKeys("23:00");
		Thread.sleep(2000);
		driver.findElement(By.xpath(Elements_Diagnostics.bulksubmitbutton)).click();
		Browser.CheckNotificationMessage("All Appointments Cancelled between the applied dates");
		}
	
	
	public void AppointCreationForShowMore(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		
		driver.findElement(By.id(Elements_Diagnostics.clickonappointmentsmenu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.tommorowmenu)).click();
		driver.findElement(By.xpath(Elements_Diagnostics.morningmenu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.noonmenu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.eveningmenu)).click();
		Thread.sleep(1000);
		int cellsize=driver.findElements(By.xpath("//*[@id='myTab-3']/ul/li")).size();
		for(cellsize=1;cellsize<=6;cellsize++){
			driver.findElement(By.xpath("//*[@id='myTab-3']/ul/li["+cellsize+"]")).click();
			driver.findElement(By.id(Elements_Diagnostics.detailsfirstname)).sendKeys(firstname	);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Diagnostics.detailslastname)).sendKeys(lastname);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Diagnostics.detailsmobile)).sendKeys(mobile);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Diagnostics.detailsemail)).sendKeys(email);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Diagnostics.detailsproblem)).sendKeys(problem);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Diagnostics.packagetab)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Diagnostics.packagecheckbox)).click();
			Thread.sleep(2000);
			WebElement sc = driver.findElement(By.id(Elements_Diagnostics.windowsavebutton));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sc);
			driver.findElement(By.id(Elements_Diagnostics.windowsavebutton)).click();
			Thread.sleep(5000);
		}
		
		}
	
	
	public void ClickOnDashboardMenu(){
		
		driver.findElement(By.id("dashBoard")).click();
		WebDriverWait wait=new WebDriverWait(driver,1000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@class='monthly-day monthly-day-event monthly-today']")));
		String date=driver.findElement(By.xpath("//a[@class='monthly-day monthly-day-event monthly-today']")).getText();
		driver.findElement(By.xpath("//*[@id='diagnosticDashboardCalendar']/div[3]/a["+date+"+1]/div[1]")).click();
		}
	
	
	
	public void CheckingShowMoreOnDashboard() throws Exception{
		
		if(driver.findElements(By.xpath("html/body/div[6]/div[3]/div[1]/div[5]/button[1]")).isEmpty()){ 
			Assert.fail("Show More Button is not avaiable");		
			}	
			else{	
			driver.findElement(By.xpath("html/body/div[6]/div[3]/div[1]/div[5]/button[1]")).click();
			System.out.println("show More Button is present");
			System.out.println("show More Button is Clicked");
			Thread.sleep(2000);	  		
			((JavascriptExecutor)driver).executeScript("scroll(400,0)");
			Thread.sleep(3000);
			System.out.println("Scroll Button is Available");
			driver.findElement(By.xpath("html/body/div[6]/div[3]/div[1]/div[5]/button[2]")).click();
			System.out.println("Show Less Button is Present");	  	
			System.out.println("Show Less Button is Clicked");	  		
					
			}
		
		}
	
	public void patientsearchinalltab(String firstname,String lastname,String email) throws Exception{
		
		
		driver.findElement(By.id("patients")).click();
		Thread.sleep(8000);
		driver.findElement(By.id("search-bar")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("all")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("apt-search")).sendKeys(email);
		int alltabsize=driver.findElements(By.xpath(".//*[@id='sp-diagno-tab-2']/div")).size();
		for(int i=1;i<=alltabsize;i++){
			
			String name=driver.findElement(By.xpath(".//*[@id='sp-diagno-tab-2']/div["+i+"]/div/div[2]/div/h1/span[1]")).getText();
			String schedule=driver.findElement(By.xpath(".//*[@id='sp-diagno-tab-2']/div["+i+"]/div/div[2]/div/h1/span[2]/p")).getText();
			String fullname=firstname+" "+lastname;
			if(name.equalsIgnoreCase(fullname)&& schedule.equalsIgnoreCase("Scheduled")){
				
				WebElement sc = driver.findElement(By.xpath("//*[@id='sp-diagno-tab-2']/div["+i+"]/div/div[2]/div/h1/span[2]/p"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sc);
				driver.findElement(By.xpath("//*[@id='sp-diagno-tab-2']/div["+i+"]/div/div[2]/div/h1/span[1]")).click();
				System.out.println("Appointment Booking is Sucessfully verified in All Tab Patient Screen");
				break;
				
			}else{
				System.out.println("Appointment Booking Verification Failed in All Tab Patient Screen");
			}
			
			}
	}
	
	
	public void PatientSerachInAllTabForReschedule(String firstname,String lastname,String email) throws Exception{
		driver.findElement(By.id(Elements_Diagnostics.clickonpatientmenu)).click();
		Thread.sleep(8000);
		driver.findElement(By.id("search-bar")).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.clickonalltab)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.serachtextbox)).sendKeys(email);
		driver.findElement(By.id(Elements_Diagnostics.serachtextbox)).sendKeys(Keys.ENTER);
		int alltabsize=driver.findElements(By.xpath(Elements_Diagnostics.alltabsize)).size();
		for(int i=1;i<=alltabsize;i++){	
		String name=driver.findElement(By.xpath("//*[@id='sp-diagno-tab-2']/div["+i+"]/div/div[2]/div/h1/span[1]")).getText();
		String schedule=driver.findElement(By.xpath("//*[@id='sp-diagno-tab-2']/div["+i+"]/div/div[2]/div/h1/span[2]/p")).getText();
		String fullname=firstname+" "+lastname;
		if(name.equalsIgnoreCase(fullname)&& schedule.equalsIgnoreCase("Rescheduled")){
			WebElement sc = driver.findElement(By.xpath("//*[@id='sp-diagno-tab-2']/div["+i+"]/div/div[2]/div/h1/span[2]/p"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sc);
			driver.findElement(By.xpath("//*[@id='sp-diagno-tab-2']/div["+i+"]/div/div[2]/div/h1/span[1]")).click();
			System.out.println("Appointment Booking is Sucessfully verified in All Tab Patient Screen");
			break;
			
		}else{
			System.out.println("Appointment Booking Verification Failed in All Tab Patient Screen");
		}
		}
	}
	
	
	
	public void CheckSendNofiticationFunctionality(String firstname,String lastname,String email) throws Exception{
		
		driver.findElement(By.id(Elements_Diagnostics.clickonpatientmenu)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(Elements_Diagnostics.clickonsearchicon)).click();
		driver.findElement(By.id(Elements_Diagnostics.serachtextbox)).sendKeys(email);
		driver.findElement(By.id(Elements_Diagnostics.serachtextbox)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		int todaytab= driver.findElements(By.xpath(Elements_Diagnostics.todaytabsize)).size();
		//System.out.println(todaytab);
		for(int i=1;i<=todaytab;i++){
		String schedule=driver.findElement(By.xpath("//*[@id='sp-diagno-tab-1']/div["+i+"]/div/div[2]/div/h1/span[2]/p")).getText();
		String name=driver.findElement(By.xpath("//*[@id='sp-diagno-tab-1']/div["+i+"]/div/div[2]/div/h1/span[1]/span")).getText();
		System.out.println(name);
		String fullname=firstname+" "+lastname;
		if(name.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Scheduled")){
			System.out.println("Scheduled/Rescheduled Found");
			Reporter.log("Scheduled/Rescheduled Found");	
			WebElement sc = driver.findElement(By.xpath("//*[@id='sp-diagno-tab-1']/div["+i+"]/div/div[2]/div/h1/span[2]/p"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sc);
			driver.findElement(By.xpath("//*[@id='sp-diagno-tab-1']/div["+i+"]/div/div[3]/div/div/div[3]/div[2]/button")).click();
			Browser.CheckNotificationMessage("Email/SMS Notification sent to the Patient");
			break;
		}else{
			System.out.println("Schedule/Reschedule Not Available In Today Tab ");
		}		
		}		
	}
	
	public void CheckSendNofiticationFunctionalityInAllTab(String email) throws Exception{
		driver.findElement(By.id(Elements_Diagnostics.clickonpatientmenu)).click();
		Thread.sleep(5000);
		driver.findElement(By.id("search-bar")).click();
		driver.findElement(By.id(Elements_Diagnostics.clickonalltab)).click();
		driver.findElement(By.id(Elements_Diagnostics.serachtextbox)).sendKeys(email);
		driver.findElement(By.id(Elements_Diagnostics.serachtextbox)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	int alltabsize=driver.findElements(By.xpath(Elements_Diagnostics.alltabsize)).size();
	for(int i=1;i<=alltabsize;i++){
		String schedule=driver.findElement(By.xpath("//*[@id='sp-diagno-tab-2']/div["+i+"]/div/div[2]/div/h1/span[2]/p")).getText();
		if(schedule.equalsIgnoreCase("Scheduled")||schedule.equalsIgnoreCase("Rescheduled")){
			WebElement sc = driver.findElement(By.xpath("//*[@id='sp-diagno-tab-2']/div["+i+"]/div/div[2]/div/h1/span[2]/p"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sc);
			driver.findElement(By.xpath("//*[@id='sp-diagno-tab-2']/div["+i+"]/div/div[3]/div/div/div[3]/div[2]/button")).click();
			Browser.CheckNotificationMessage("Email/SMS Notification sent to the Patient");
			
		}else{
			System.out.println("Schedule/Reschedule Not Available In Today Tab ");
		}
			
			
		}		
			
			
		}
	

	
	public void VerifyCheckInCheckoutforAllTab(String firstname,String lastname,String email) throws Exception{
		
		driver.findElement(By.id(Elements_Diagnostics.clickonpatientmenu)).click();
		Thread.sleep(8000);
		driver.findElement(By.id("search-bar")).click();
		driver.findElement(By.id(Elements_Diagnostics.clickonalltab)).click();
		driver.findElement(By.id(Elements_Diagnostics.serachtextbox)).sendKeys(email);
		driver.findElement(By.id(Elements_Diagnostics.serachtextbox)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String name=driver.findElement(By.xpath("//*[@id='sp-diagno-tab-2']/div/div/div[2]/div/h1/span[1]")).getText();
		System.out.println(name);
		String schedule=driver.findElement(By.xpath("//*[@id='sp-diagno-tab-2']/div/div/div[2]/div/h1/span[2]/p")).getText();
		System.out.println(schedule);
		String fullname=firstname+" "+lastname;
		if(name.equalsIgnoreCase(fullname)&& schedule.equalsIgnoreCase("Scheduled"));{
			driver.findElement(By.xpath("//*[@id='sp-diagno-tab-2']/div/div/div[2]/div/h1/span[1]")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("checkIn")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("startConsultation")).click();
			Thread.sleep(5000);
			WebElement element=driver.findElement(By.xpath("//*[@id='0']"));
			Select se=new Select(element);
			se.selectByValue("Completed");
			driver.findElement(By.id("tab-pkgs-btn")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("appointmentNotes")).sendKeys("Tests Are Completed");
			Thread.sleep(5000);
			driver.findElement(By.id("diag-note-btn")).click();
			Thread.sleep(8000);
			driver.findElement(By.id("generatReceiptBtn")).click();
			Thread.sleep(20000);
			driver.findElement(By.id("checkoutBtn")).click();
			Browser.CheckNotificationMessage("Check Out Success");	
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[@class='tab-link'][contains(text(),'Reports')]")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("uploadBtn")).sendKeys("/Users/lakshmikanth/Downloads/flower.jpeg");
			Thread.sleep(3000);
			driver.findElement(By.id("all_reports_upload")).click();
			Thread.sleep(6000);
			driver.findElement(By.id("appt-reports-btn")).click();
			Thread.sleep(3000);
			Browser.CheckNotificationMessage("Reports status changed successful");
			}
		}
	
	
	public void CheckPatientSearchfunctionalityInTodaytab(String firstname,String lastname,String mobile,String email) throws Exception{
		
		driver.findElement(By.id("patients")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//*[@id='search-bar']")).click();
		 Thread.sleep(5000);
		 String fullname=firstname+" "+lastname;
		 String topping[]=new String[3];
		 topping[0]=fullname;
		 topping[1]=mobile;
		 topping[2]=email;
		 for(int i=0;i<=topping.length-1;i++){
			driver.findElement(By.xpath("//*[@id='apt-search']")).clear();
			 driver.findElement(By.xpath("//*[@id='apt-search']")).sendKeys(topping[i]);
			 driver.findElement(By.id("apt-search")).sendKeys(Keys.ENTER);
			 Thread.sleep(10000);
		String elementpresent=driver.findElement(By.xpath("//*[@id='sp-diagno-tab-1']/div[1]/div/div[2]/div/h1/span[1]/span")).getText();
		System.out.println(elementpresent);
		String status=driver.findElement(By.xpath("//p[@class='check_in']")).getText();
		System.out.println(status);
		if(elementpresent.equalsIgnoreCase(fullname)&&status.equalsIgnoreCase("Scheduled")){
			
			System.out.println("User had Present");
			
		}else{
			System.out.println("User Not Present");
		}	
		 }
		}
	
	public void CheckPatientSearchfunctionalityInAllTab(String firstname,String lastname,String mobile,String email) throws Exception{
		driver.findElement(By.id(Elements_Diagnostics.clickonpatientmenu)).click();
		 Thread.sleep(8000);
		 driver.findElement(By.id(Elements_Diagnostics.clickonalltab)).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(Elements_Diagnostics.clickonsearchicon)).click();
		 Thread.sleep(2000);

		 String fullname=firstname+" "+lastname;
		 String topping[]=new String[3];
		 topping[0]=fullname;
		 topping[1]=mobile;
		 topping[2]=email;
		 for(int i=0;i<=topping.length-1;i++){
			 driver.findElement(By.id(Elements_Diagnostics.serachtextbox)).clear();
			 driver.findElement(By.id(Elements_Diagnostics.serachtextbox)).sendKeys(topping[i]);
			 driver.findElement(By.id("apt-search")).sendKeys(Keys.ENTER);
			 Thread.sleep(10000);
		String name=driver.findElement(By.xpath("//*[@id='sp-diagno-tab-2']/div/div/div[2]/div/h1/span[1]")).getText();
		System.out.println(name);
		String status=driver.findElement(By.xpath("//*[@id='sp-diagno-tab-2']/div/div/div[2]/div/h1/span[2]/p")).getText();
		System.out.println(status);
		if(name.equalsIgnoreCase(fullname)&& status.equalsIgnoreCase("Scheduled")){
			System.out.println("User had Present");	
		}else{
			System.out.println("User Not Present");
		}	
		
		 }
			 
		 }
	
	 
	public void EditProfilepage() throws InterruptedException{
		driver.findElement(By.id("account")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='menu_links']")).click();
		driver.findElement(By.id("shortName")).clear();
		driver.findElement(By.id("shortName")).sendKeys("CHLK");
		Thread.sleep(1000);
		driver.findElement(By.id("mobileNum")).clear();
		driver.findElement(By.id("mobileNum")).sendKeys("9966224499");
		Thread.sleep(1000);
		WebElement element=driver.findElement(By.id("languagesSpoken"))	; 
		Select se= new Select(element);
		se.selectByValue("GUJARATHI");
		driver.findElement(By.id("zysaveAboutInfo")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='myTabs']/li[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("man_clinic_addr_edit")).click();		
		Thread.sleep(1000);
		WebElement element1=driver.findElement(By.id("addressCountry"))	; 
		Select se1= new Select(element1);
		se1.selectByValue("IN");
		Thread.sleep(1000);
		WebElement element2=driver.findElement(By.id("addressState"))	; 
		Select se2= new Select(element2);
		se2.selectByValue("IN-AP");
		Thread.sleep(1000);
		WebElement element3=driver.findElement(By.id("addressCity"))	; 
		Select se3= new Select(element3);
		se3.selectByValue("8vAzEjB3DaHdamRsQ");
		driver.findElement(By.id("zyDiagnostic_addr_save")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='myTabs']/li[3]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("zyEditProfileAwards")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("awardSource0")).clear();
		driver.findElement(By.id("awardSource0")).sendKeys("Pdamabhushan");
		Thread.sleep(1000);
		driver.findElement(By.id("awardYear0")).clear();
		driver.findElement(By.id("awardYear0")).sendKeys("220");
		driver.findElement(By.id("zySaveAwards")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='myTabs']/li[6]/a/span[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("logout")).click();
	}
	
	public void CheckTodayAppointmentCountInDashBoardScreen() throws InterruptedException{
		driver.findElement(By.id("dashBoard")).click();
		 Thread.sleep(3000);
		int appointmentsavailable= driver.findElements(By.xpath("//div[@id='sp-diagno-dash-scrolls']/div[1]/div")).size();
		//System.out.println(appointmentsavailable);
		String count=driver.findElement(By.xpath("html/body/div[6]/div[3]/div[2]/div[5]/div[1]/div[1]/div")).getText();
		if(count.equalsIgnoreCase(Integer.toString(appointmentsavailable))){
			System.out.println("Appointment Count For Today is"+appointmentsavailable+ "Sucessfully Verified");
			
		}else{
			Assert.fail("Appointment Count For Today is Not Equal");
		}
	}
	
	// Click on recent Patient from dashboard
		public  void clickOnTheRecentPatientFromDashBoardInDiagnostics() throws IOException, InterruptedException{
			Thread.sleep(5000);
			if(driver.findElements(By.xpath("//button[text()='SHOW MORE']")).size() !=0){
	
				System.out.println("show all btn exisit");
				driver.findElement(By.xpath("//button[text()='SHOW MORE']")).click();
				Thread.sleep(2000);
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("scroll(0, 250)"); // if the element is on bottom.
				Thread.sleep(5000);
				//Browser.waitFortheElementXpath("//div[@class='doctor-patientname patientfullName']/span");
				driver.findElement(By.xpath("(//div[@class='sp-diagno-aptusername sp-diagno-dash-healthproblem']/span)[last()]")).click();  // Recent Appointment
				Browser.waitTill(60);
				
			}else{
				System.out.println("is empty");
				Browser.waitFortheElementXpath("//div[@class='sp-diagno-aptusername sp-diagno-dash-healthproblem']/span");
				driver.findElement(By.xpath("(//div[@class='sp-diagno-aptusername sp-diagno-dash-healthproblem']/span)[last()]")).click();  // Recent Appointment
				Browser.waitTill(60);

			}

		}
		// Doctors Checkin and check the recipient
		public  void diagnosticsCheckinCheckOut() throws IOException, InterruptedException{			
			driver.findElement(By.xpath("//div[@id='checkIn']/span[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("startConsultation")).click();				
			Thread.sleep(2000);
			driver.findElement(By.id("0")).sendKeys("Completed");
			driver.findElement(By.id("1")).sendKeys("Completed");
			driver.findElement(By.id("tab-pkgs-btn")).click();			
			Thread.sleep(2000);	
			driver.findElement(By.id("appointmentNotes")).sendKeys("Notes of diagnotics");
			driver.findElement(By.id("diag-note-btn")).click();				
			Thread.sleep(2000);
			driver.findElement(By.id("generatReceiptBtn")).click();
			Thread.sleep(5000);
			//Browser.verifyNotificationMessage("Bill generated successfully");
			//Thread.sleep(5000);
			driver.findElement(By.id("checkoutBtn")).click();
			Thread.sleep(2000);
			Browser.verifyNotificationMessage("Check Out Success");
		}
		
		// Diagnostic logout 
		public  void diagnosticslogout() throws IOException, InterruptedException{			
			driver.get("https://"+LoadPropMac.Environment+".zoylo.com/zyDiagnosticCenterAccount");
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("span.icon-diag-cen > i.fa.fa-sign-out"))	.click();
			Thread.sleep(2000);
			driver.findElement(By.id("logout")).click();
			Thread.sleep(5000);
			System.out.println("Diagnostics Logged Out"+LoadPropMac.Environment);
		}

	
}//main Class
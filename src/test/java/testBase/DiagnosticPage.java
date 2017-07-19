package testBase;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import objectRepository.Elements_Diagnostics;
import objectRepository.Elements_Doctors;

public class DiagnosticPage {
	
	public    WebDriver driver;
	public TestUtils Browser;
	 private SoftAssert assertion = new SoftAssert();
	
	
	
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
		Thread.sleep(3000);
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonappointmentsmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.clickontoggle);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.clickontoggle);
		Browser.waitFortheElementXpath(Elements_Diagnostics.tommorowmenu);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.tommorowmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.morninghomevisit);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.morninghomevisit);
		Browser.waitFortheElementXpath(Elements_Diagnostics.noonhomevisit);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.noonhomevisit);
		Browser.waitFortheElementXpath(Elements_Diagnostics.eveninghomevisit);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.eveninghomevisit);
		Browser.waitFortheElementXpath(Elements_Diagnostics.eveningfirstcell);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.eveningfirstcell);
		Browser.enterTextByID(Elements_Diagnostics.detailsfirstname,firstname);
		Browser.waitFortheID(Elements_Diagnostics.detailslastname);
		Browser.enterTextByID(Elements_Diagnostics.detailslastname, lastname);
		Browser.waitFortheID(Elements_Diagnostics.detailsmobile);
		Browser.enterTextByID(Elements_Diagnostics.detailsmobile,mobile);
		Browser.waitFortheID(Elements_Diagnostics.detailsemail);
		Browser.enterTextByID(Elements_Diagnostics.detailsemail, email);
		Browser.waitFortheID(Elements_Diagnostics.detailsaddress);
		Browser.enterTextByID(Elements_Diagnostics.detailsaddress, address);
		Browser.waitFortheID(Elements_Diagnostics.detailsproblem);
		Browser.enterTextByID(Elements_Diagnostics.detailsproblem, problem);
		Browser.waitFortheElementXpath(Elements_Diagnostics.packagetab);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.packagetab);
		Browser.waitFortheElementXpath(Elements_Diagnostics.packagecheckbox);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.packagecheckbox);
		Thread.sleep(2000);
		WebElement sc = driver.findElement(By.id(Elements_Diagnostics.windowsavebutton));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sc);
		driver.findElement(By.id(Elements_Diagnostics.windowsavebutton)).click();
		//Browser.CheckNotificationMessage("Appointment is confirmed. Patient Name:"+firstname);
	    }
	
	
	
	
	public void ClickingOnEllipse() throws Exception{
		driver.findElement(By.xpath(Elements_Diagnostics.ellipse)).click();
		Thread.sleep(5000);
	   }
	
		
	public void diagnosticlogout() throws Exception{
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.ellipse);
		Browser.waitFortheID(Elements_Diagnostics.clickonmyaccountmenu);
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonmyaccountmenu);
		//Thread.sleep(5000);
		Browser.waitFortheElementXpath(Elements_Diagnostics.clickonsignout);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.clickonsignout);
		//Thread.sleep(2000);
		Browser.waitFortheID(Elements_Diagnostics.confirmsignout);
		Browser.clickOnTheElementByID(Elements_Diagnostics.confirmsignout);
		Thread.sleep(2000);
	}
		
		
	public void diagnosticrescheduleappointment() throws Exception{
		//driver.findElement(By.xpath(Elements_Diagnostics.clickonmore)).click();
		//Thread.sleep(3000);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.clickonchange);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.tommorowmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.nextdaymenu);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.nextdaymenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.morninghomevisit);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.morninghomevisit);
		Browser.waitFortheElementXpath(Elements_Diagnostics.noonhomevisit);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.noonhomevisit);
		Browser.waitFortheElementXpath(Elements_Diagnostics.eveninghomevisit);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.eveninghomevisit);
		Browser.waitFortheElementXpath(Elements_Diagnostics.eveningfirstcell);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.eveningfirstcell);
		
		}
	
	
	
	public void clickingonappointmentmodification() throws Exception{
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.clickonmore);
		Thread.sleep(3000);
	}
  
	
	public void GetAlertTextFromAlertMenu(){
		
		String alert=driver.findElement(By.xpath("(//*[@id='message'])[1]")).getText();
		System.out.println(alert);
	}
	
	
	public void CancelAppointmentOfHomeVisit() throws Exception{
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.clickoncancel);
		Browser.waitFortheID(Elements_Diagnostics.selectbox);
		driver.findElement(By.id(Elements_Diagnostics.selectbox)).sendKeys("Personal reason");
		Browser.waitFortheElementXpath(Elements_Diagnostics.submitbutton);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.submitbutton);
		//Browser.CheckNotificationMessage("Appointment has been Cancelled");

		}
		
	public void ClickonAppointmentMenu() throws Exception{
		
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonappointmentsmenu);
		Thread.sleep(3000);	
	}
	
	public void ClickonToggleButtonForHomeVisit(){
		
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.clickontoggle);
		
	}
	
	
	public void BulkCancellationForHomeVisit(String CancelFromtime,String CancelTotime) throws Exception{	
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
		driver.findElement(By.xpath(Elements_Diagnostics.clickonbulkcancelcalendar)).click();
		Thread.sleep(2000);
		Browser.actionbyXpath(Elements_Diagnostics.fromcanceldate, date);
		Thread.sleep(2000);
		Browser.actionbyXpath(Elements_Diagnostics.tocanceldate, enddate);
		Thread.sleep(2000);
		driver.findElement(By.xpath(Elements_Diagnostics.fromtime)).sendKeys(CancelFromtime);
		Thread.sleep(3000);
		driver.findElement(By.xpath(Elements_Diagnostics.totime)).sendKeys(CancelTotime);
		Thread.sleep(2000);
		driver.findElement(By.xpath(Elements_Diagnostics.bulksubmitbutton)).click();
		Browser.CheckNotificationMessage("All Appointments Cancelled between the applied dates");
		Thread.sleep(2000);
		
		}
	
	//DiagnosticAppointmentbooking
	
	public void DiagnosticAppointmentbookingForTomorrow(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonappointmentsmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.tommorowmenu);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.tommorowmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.morningmenu);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.morningmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.noonmenu);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.noonmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.eveningmenu);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.eveningmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.eveningfirstcell);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.eveningfirstcell);
		Browser.waitFortheID(Elements_Diagnostics.detailsfirstname);
		Browser.enterTextByID(Elements_Diagnostics.detailsfirstname,firstname);
		Browser.waitFortheID(Elements_Diagnostics.detailslastname);
		Browser.enterTextByID(Elements_Diagnostics.detailslastname, lastname);
		Browser.waitFortheID(Elements_Diagnostics.detailsmobile);
		Browser.enterTextByID(Elements_Diagnostics.detailsmobile,mobile);
		Browser.waitFortheID(Elements_Diagnostics.detailsemail);
		Browser.enterTextByID(Elements_Diagnostics.detailsemail, email);
		Browser.waitFortheID(Elements_Diagnostics.detailsproblem);
		Browser.enterTextByID(Elements_Diagnostics.detailsproblem, problem);
		Browser.waitFortheElementXpath(Elements_Diagnostics.packagetab);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.packagetab);
		Browser.waitFortheElementXpath(Elements_Diagnostics.packagecheckbox);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.packagecheckbox);
		Thread.sleep(2000);
		WebElement sc = driver.findElement(By.id(Elements_Diagnostics.windowsavebutton));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sc);
		driver.findElement(By.id(Elements_Diagnostics.windowsavebutton)).click();
        Browser.CheckNotificationMessage("Appointment is confirmed for "+firstname);
        Thread.sleep(2000);

	}
		
	
	public void DiagnosticViewAppointment() throws Exception{
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.clickonmore);
		Browser.waitTill(1000);
		String call=driver.findElement(By.xpath(Elements_Diagnostics.calltext)).getText();
		String change=driver.findElement(By.xpath(Elements_Diagnostics.changetext)).getText();
		String cancel=driver.findElement(By.xpath(Elements_Diagnostics.canceltext)).getText();
		if(call.equalsIgnoreCase("Call")&& change.equalsIgnoreCase("Change")&& cancel.equalsIgnoreCase("Cancel")){
			System.out.println("Appointment Created is Sucessfully view");
		}else{
			
			System.out.println("Appointment Created Is not Sucessfully Viewed");
		}
	}
	
	public String GetDiagnosticAppointmentId() throws Exception{
		
	String AppointmentId=driver.findElement(By.xpath("(//span[@class='zy-sp-diag-m-p-uname'])[2]")).getText();
	Thread.sleep(1000);
	return AppointmentId;
	}
	
	public void clickOnAlertMenu() throws Exception{
		
		Browser.clickOnTheElementByID("alerts");
		Thread.sleep(5000);
	}
	
	public void DiagnosticAppointmentReschedule() throws Exception{
		
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.clickonchange);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.nextdaymenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.morningmenu);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.morningmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.noonmenu);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.noonmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.eveningmenu);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.eveningmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.eveningfirstcell);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.eveningfirstcell);
		WebDriverWait wait = (new WebDriverWait(driver, 40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Elements_Diagnostics.notification)));
		String notification=driver.findElement(By.cssSelector(Elements_Diagnostics.topnotification)).getText();
		System.out.println(notification);
		Assert.assertEquals("Appointment rescheduled successfully", notification);

	}
	
	
	public void DiagnosticAppointmentForToday(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonappointmentsmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.morningmenu);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.morningmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.noonmenu);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.noonmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.eveningmenu);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.eveningmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.eveningfirstcell);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.eveningfirstcell);
		Browser.waitFortheID(Elements_Diagnostics.detailsfirstname);
		Browser.enterTextByID(Elements_Diagnostics.detailsfirstname,firstname);
		Browser.waitFortheID(Elements_Diagnostics.detailslastname);
		Browser.enterTextByID(Elements_Diagnostics.detailslastname, lastname);
		Browser.waitFortheID(Elements_Diagnostics.detailsmobile);
		Browser.enterTextByID(Elements_Diagnostics.detailsmobile,mobile);
		Browser.waitFortheID(Elements_Diagnostics.detailsemail);
		Browser.enterTextByID(Elements_Diagnostics.detailsemail, email);
		Browser.waitFortheID(Elements_Diagnostics.detailsproblem);
		Browser.enterTextByID(Elements_Diagnostics.detailsproblem, problem);
		Browser.waitFortheElementXpath(Elements_Diagnostics.packagetab);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.packagetab);
		Browser.waitFortheElementXpath(Elements_Diagnostics.packagecheckbox);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.packagecheckbox);
		Thread.sleep(5000);
		WebElement sc = driver.findElement(By.id(Elements_Diagnostics.windowsavebutton));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sc);
		driver.findElement(By.id(Elements_Diagnostics.windowsavebutton)).click();
		Thread.sleep(3000);
		
	}
	
	public void DiagnosticHomeVisitAppointmentForToday(String firstname,String lastname,String mobile,String email,String address,String problem) throws Exception{
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonappointmentsmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.clickontoggle);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.clickontoggle);
		Browser.waitFortheElementXpath(Elements_Diagnostics.morningmenu);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.morningmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.noonmenu);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.noonmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.eveningmenu);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.eveningmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.eveningfirstcell);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.eveningfirstcell);
		Browser.waitFortheID(Elements_Diagnostics.detailsfirstname);
		Browser.enterTextByID(Elements_Diagnostics.detailsfirstname, firstname);
		Browser.waitFortheID(Elements_Diagnostics.detailslastname);
		Browser.enterTextByID(Elements_Diagnostics.detailslastname, lastname);
		Browser.waitFortheID(Elements_Diagnostics.detailsmobile);
		Browser.enterTextByID(Elements_Diagnostics.detailsmobile, mobile);
		Browser.waitFortheID(Elements_Diagnostics.detailsemail);
		Browser.enterTextByID(Elements_Diagnostics.detailsemail, email);
		Browser.waitFortheID(Elements_Diagnostics.detailsaddress);
		Browser.enterTextByID(Elements_Diagnostics.detailsaddress, address);
		Browser.waitFortheID(Elements_Diagnostics.detailsproblem);
		Browser.enterTextByID(Elements_Diagnostics.detailsproblem, problem);
		Browser.waitFortheElementXpath(Elements_Diagnostics.packagetab);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.packagetab);
		Browser.waitFortheElementXpath(Elements_Diagnostics.packagecheckbox);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.packagecheckbox);
		Thread.sleep(2000);
		WebElement sc = driver.findElement(By.id(Elements_Diagnostics.windowsavebutton));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sc);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.windowsavebutton)).click();
		//Browser.CheckNotificationMessage("Appointment is confirmed. Patient Name:"+firstname);
		Thread.sleep(2000);
	    }
		
	
	
	public void patientserachforintoday(String firstname,String lastname,String email) throws Exception{
		
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonpatientmenu);
		Thread.sleep(8000);
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonserachbarid);
		Thread.sleep(1000);
		Browser.enterTextByID(Elements_Diagnostics.serachtextbox, email);
		driver.findElement(By.id(Elements_Diagnostics.serachtextbox)).sendKeys(Keys.ENTER);
		 Thread.sleep(2000);
		int size= driver.findElements(By.xpath(Elements_Diagnostics.todaytabsize)).size();
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
		
	
	public void DiagnosticAppointmentsBulkCancellation(String CancelFromTime,String CancelToTime) throws InterruptedException{
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
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonappointmentsmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.clickonbulkcancelcalendar);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.clickonbulkcancelcalendar);
		Browser.waitFortheElementXpath(Elements_Diagnostics.fromcanceldate);
		Browser.actionbyXpath(Elements_Diagnostics.fromcanceldate, date);
		Browser.waitFortheElementXpath(Elements_Diagnostics.tocanceldate);
		Browser.actionbyXpath(Elements_Diagnostics.tocanceldate, enddate);
		Browser.waitFortheElementXpath(Elements_Diagnostics.fromtime);
		Browser.enterTextByXpath(Elements_Diagnostics.fromtime, CancelFromTime);
		Browser.waitFortheElementXpath(Elements_Diagnostics.totime);
		Browser.enterTextByXpath(Elements_Diagnostics.totime, CancelToTime);
		Browser.waitFortheElementXpath(Elements_Diagnostics.bulksubmitbutton);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.bulksubmitbutton);
		Browser.CheckNotificationMessage("All Appointments Cancelled between the applied dates");
		Thread.sleep(3000);
		}
	
	
	public void AppointCreationForShowMore(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonappointmentsmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.tommorowmenu);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.tommorowmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.morningmenu);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.morningmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.noonmenu);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.noonmenu);
		Browser.waitFortheElementXpath(Elements_Diagnostics.eveningmenu);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.eveningmenu);
		Thread.sleep(1000);
		int cellsize=driver.findElements(By.xpath("//*[@id='myTab-3']/ul/li")).size();
		System.out.println(cellsize);
		for(cellsize=1;cellsize<=6;cellsize++){
			driver.findElement(By.xpath("//*[@id='myTab-3']/ul/li["+cellsize+"]")).click();
			Browser.waitFortheID(Elements_Diagnostics.detailsfirstname);
			Browser.enterTextByID(Elements_Diagnostics.detailsfirstname, firstname);
			Browser.waitFortheID(Elements_Diagnostics.detailslastname);
			Browser.enterTextByID(Elements_Diagnostics.detailslastname, lastname);
			Browser.waitFortheID(Elements_Diagnostics.detailsmobile);
			Browser.enterTextByID(Elements_Diagnostics.detailsmobile, mobile);
			Browser.waitFortheID(Elements_Diagnostics.detailsemail);
			Browser.enterTextByID(Elements_Diagnostics.detailsemail, email);
			Browser.waitFortheID(Elements_Diagnostics.detailsproblem);
			Browser.enterTextByID(Elements_Diagnostics.detailsproblem, problem);
			Browser.waitFortheElementXpath(Elements_Diagnostics.packagetab);
			Browser.clickOnTheElementByXpath(Elements_Diagnostics.packagetab);
			Browser.waitFortheElementXpath(Elements_Diagnostics.packagecheckbox);
			Browser.clickOnTheElementByXpath(Elements_Diagnostics.packagecheckbox);
			Thread.sleep(2000);
			WebElement sc = driver.findElement(By.id(Elements_Diagnostics.windowsavebutton));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sc);
			driver.findElement(By.id(Elements_Diagnostics.windowsavebutton)).click();
			Thread.sleep(5000);

			
			
		}
		
		}
	
	
	public void ClickOnDashboardMenu(){
		
		driver.findElement(By.id(Elements_Diagnostics.clickondashboardmenu)).click();
		WebDriverWait wait=new WebDriverWait(driver,1000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Elements_Diagnostics.todayhighliteddate)));
		String date=driver.findElement(By.xpath(Elements_Diagnostics.todayhighliteddate)).getText();
		driver.findElement(By.xpath("//*[@id='diagnosticDashboardCalendar']/div[3]/a["+date+"+1]/div[1]")).click();
		}
	
	
	
	public void CheckingShowMoreOnDashboard() throws Exception{
		
		if(driver.findElements(By.xpath(Elements_Diagnostics.showmorebutton)).isEmpty()){ 
			Assert.fail("Show More Button is not avaiable");		
			}	
			else{	
			driver.findElement(By.xpath(Elements_Diagnostics.showmorebutton)).click();
			System.out.println("show More Button is present");
			System.out.println("show More Button is Clicked");
			Thread.sleep(2000);	  		
			((JavascriptExecutor)driver).executeScript("scroll(0,400)");
			Thread.sleep(3000);
			System.out.println("Scroll Button is Available");
			driver.findElement(By.xpath(Elements_Diagnostics.showlessbutton)).click();
			System.out.println("Show Less Button is Present");	  	
			System.out.println("Show Less Button is Clicked");	  		
					
			}
		
		}
	
	public void patientsearchinalltab(String firstname,String lastname,String email) throws Exception{
		
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonpatientmenu);
		Thread.sleep(8000);
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonserachbarid);
		Thread.sleep(1000);
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonalltab);
		Thread.sleep(1000);
		Browser.enterTextByID(Elements_Diagnostics.serachtextbox, email);
		int alltabsize=driver.findElements(By.xpath(Elements_Diagnostics.alltabsize)).size();
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
				Assert.fail("Appointment Booking Verification Failed in All Tab Patient Screen");
			}
			
			}
			}
	
	
	public void PatientSerachInAllTabForReschedule(String firstname,String lastname,String email) throws Exception{
		
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonpatientmenu);
		Thread.sleep(8000);
		Browser.waitFortheID(Elements_Diagnostics.clickonserachbarid);
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonserachbarid);
		Browser.waitFortheID(Elements_Diagnostics.clickonalltab);
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonalltab);
		Browser.waitFortheID(Elements_Diagnostics.serachtextbox);
		Browser.enterTextByID(Elements_Diagnostics.serachtextbox, email);
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
		
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonpatientmenu);
		Thread.sleep(5000);
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.clickonsearchicon);
		Browser.enterTextByID(Elements_Diagnostics.serachtextbox,email);
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
			Assert.fail("Schedule/Reschedule Not Available In Today Tab ");
		}		
		}		
	}
	
	
	public void CheckSendNofiticationFunctionalityInAllTab(String email) throws Exception{
		
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonpatientmenu);
		Thread.sleep(5000);
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonserachbarid);
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonalltab);
		Browser.enterTextByID(Elements_Diagnostics.serachtextbox, email);
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
		driver.findElement(By.id(Elements_Diagnostics.clickonserachbarid)).click();
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
			Browser.CheckNotificationMessage("Checked-out successfully");	
			System.out.println("SUCESSFULLY CHECKED OUT");
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("download_notes")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("billDwnld")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("consultationNotesShare")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("Email-share")).click();
			Browser.CheckNotificationMessage("E-mail sent successfully");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//li[5]")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("uploadBtn")).sendKeys("/Users/lakshmikanth/Downloads/flower.jpeg");
			Thread.sleep(3000);
			driver.findElement(By.id("all_reports_upload")).click();
			Thread.sleep(6000);
			driver.findElement(By.id("appt-reports-btn")).click();
			Thread.sleep(6000);
			Browser.CheckNotificationMessage("All reports uploaded successfully");
			}
		}
	
	
	public void CheckPatientSearchfunctionalityInTodaytab(String firstname,String lastname,String mobile,String email) throws Exception{
		
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonpatientmenu);
		 Thread.sleep(5000);
		 Browser.clickOnTheElementByXpath(Elements_Diagnostics.clickonsearchicon);
		 Thread.sleep(5000);
		 String fullname=firstname+" "+lastname;
		 String topping[]=new String[3];
		 topping[0]=fullname;
		 topping[1]=mobile;
		 topping[2]=email;
		 for(int i=0;i<=topping.length-1;i++){
			 
			driver.findElement(By.id(Elements_Diagnostics.serachtextbox)).clear();
			 driver.findElement(By.id(Elements_Diagnostics.serachtextbox)).sendKeys(topping[i]);
			 driver.findElement(By.id(Elements_Diagnostics.serachtextbox)).sendKeys(Keys.ENTER);
			 Thread.sleep(10000);
		String elementpresent=driver.findElement(By.xpath(Elements_Diagnostics.todaytabfullname)).getText();
		System.out.println(elementpresent);
		String status=driver.findElement(By.xpath(Elements_Diagnostics.todaytabstatus)).getText();
		System.out.println(status);
		if(elementpresent.equalsIgnoreCase(fullname)&&status.equalsIgnoreCase("Scheduled")){
			
			System.out.println("User had Present");
			
		}else{
			System.out.println("User Not Present");
			Assert.fail("User Not Present");
		}	
		 }
		}
	
	public void CheckPatientSearchfunctionalityInAllTab(String firstname,String lastname,String mobile,String email) throws Exception{
		
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonpatientmenu);
		 Thread.sleep(8000);
		 Browser.clickOnTheElementByID(Elements_Diagnostics.clickonalltab);
		 Thread.sleep(2000);
		 Browser.clickOnTheElementByXpath(Elements_Diagnostics.clickonsearchicon);
		 Thread.sleep(2000);

		 String fullname=firstname+" "+lastname;
		 String topping[]=new String[3];
		 topping[0]=fullname;
		 topping[1]=mobile;
		 topping[2]=email;
		 for(int i=0;i<=topping.length-1;i++){
			 driver.findElement(By.id(Elements_Diagnostics.serachtextbox)).clear();
			 driver.findElement(By.id(Elements_Diagnostics.serachtextbox)).sendKeys(topping[i]);
			 driver.findElement(By.id(Elements_Diagnostics.serachtextbox)).sendKeys(Keys.ENTER);
			 Thread.sleep(10000);
		String name=driver.findElement(By.xpath(Elements_Diagnostics.alltabgetfullname)).getText();
		System.out.println(name);
		String status=driver.findElement(By.xpath(Elements_Diagnostics.alltabstatus)).getText();
		System.out.println(status);
		if(name.equalsIgnoreCase(fullname)&& status.equalsIgnoreCase("Scheduled")){
			System.out.println("User had Present");	
		}else{
			System.out.println("User Not Present");
		}	
		
		 }
			 
		 }
	
	 
	public void EditProfilepage(String shortname,String mobile,String award,String year) throws InterruptedException{
		driver.findElement(By.id(Elements_Diagnostics.clickonmyaccountmenu)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.abouteditbutton)).click();
		driver.findElement(By.id(Elements_Diagnostics.shortname)).clear();
		driver.findElement(By.id(Elements_Diagnostics.shortname)).sendKeys(shortname);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.profilemobile)).clear();
		driver.findElement(By.id(Elements_Diagnostics.profilemobile)).sendKeys(mobile);
		Thread.sleep(1000);
		WebElement element=driver.findElement(By.id(Elements_Diagnostics.language))	; 
		Select se= new Select(element);
		se.selectByValue("GUJARATHI");
		driver.findElement(By.id(Elements_Diagnostics.aboutsave)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.profileaddressmenu)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.addresseditbutton)).click();		
		Thread.sleep(1000);
		WebElement element1=driver.findElement(By.id(Elements_Diagnostics.addresscountry))	; 
		Select se1= new Select(element1);
		se1.selectByValue("IN");
		Thread.sleep(1000);
		WebElement element2=driver.findElement(By.id(Elements_Diagnostics.addressstate))	; 
		Select se2= new Select(element2);
		se2.selectByValue("IN-AP");
		Thread.sleep(1000);
		WebElement element3=driver.findElement(By.id(Elements_Diagnostics.addresscity))	; 
		Select se3= new Select(element3);
		se3.selectByValue("8vAzEjB3DaHdamRsQ");
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.addresssave)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Diagnostics.clickonawardsmenu)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.awardseditbutton)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.awardsource)).clear();
		driver.findElement(By.id(Elements_Diagnostics.awardsource)).sendKeys(award);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.awardyear)).clear();
		driver.findElement(By.id(Elements_Diagnostics.awardyear)).sendKeys(year);
		driver.findElement(By.id(Elements_Diagnostics.saveawards)).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath(Elements_Diagnostics.clickonsignoutmenu)).click();
		//Thread.sleep(1000);
		//driver.findElement(By.id(Elements_Diagnostics.confirmlogout)).click();
	}
	
	public void CheckTodayAppointmentCountInDashBoardScreen() throws InterruptedException{
		
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickondashboardmenu);
		 Thread.sleep(3000);
		int appointmentsavailable= driver.findElements(By.xpath(Elements_Diagnostics.todaysappointmentslist)).size();
		//System.out.println(appointmentsavailable);
		String count=driver.findElement(By.xpath(Elements_Diagnostics.graphtodayappointmentcount)).getText();
		if(count.equalsIgnoreCase(Integer.toString(appointmentsavailable))){
			System.out.println("Appointment Count For Today is"+appointmentsavailable+ "Sucessfully Verified");
			
		}else{
			Assert.fail("Appointment Count For Today is Not Equal");
		}
	}
	
	// Click on recent Patient from dashboard
		public  void clickOnTheRecentPatientFromDashBoardInDiagnostics() throws IOException, InterruptedException{
			Thread.sleep(2000);
			if(driver.findElements(By.xpath("//button[@class='sp-diagno-dash-showall sp-diagno-dash-showall-btn']")).size()!=0){
				System.out.println("show all btn exisit");
				driver.findElement(By.xpath("//button[@class='sp-diagno-dash-showall sp-diagno-dash-showall-btn']")).click();
				Thread.sleep(2000);

				Browser.scrollbyxpath("(//div[@class='sp-diagno-aptusername sp-diagno-dash-healthproblem']/span)[last()]");
/*				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("scroll(0, 250)"); // if the element is on bottom.
				Thread.sleep(5000);*/
				driver.findElement(By.xpath("(//div[@class='sp-diagno-aptusername sp-diagno-dash-healthproblem']/span)[last()]")).click();  // Recent Appointment
				Browser.waitTill(60);
				
			}else{
				System.out.println("is empty");
				Browser.waitFortheElementXpath("//div[@class='sp-diagno-aptusername sp-diagno-dash-healthproblem']/span");
				driver.findElement(By.xpath("(//div[@class='sp-diagno-aptusername sp-diagno-dash-healthproblem']/span)[last()]")).click();  // Recent Appointment
				Browser.waitTill(60);

			}

		}
		
		// Click on the Patient from dashboard
				public  void clickOnThePatientFromDashBoardInDiagnostics(String slotTime) throws IOException, InterruptedException, ParseException{
					Thread.sleep(2000);
					DateFormat ModTime = new SimpleDateFormat("h:mm");
					String PslotTime=ModTime.format(ModTime.parse(slotTime));
                    System.out.println("Slot Time after modification"+PslotTime);
					
					if(driver.findElements(By.xpath("//button[@class='sp-diagno-dash-showall sp-diagno-dash-showall-btn']")).size()!=0){
						System.out.println("show all btn exisit");
						driver.findElement(By.xpath("//button[@class='sp-diagno-dash-showall sp-diagno-dash-showall-btn']")).click();
						Thread.sleep(2000);

						Browser.scrollbyxpath("(//div[@class='sp-diagno-dash-timing' and contains(.,'"+PslotTime+"')]/following-sibling::div[2])[last()]");
		/*				JavascriptExecutor jse = (JavascriptExecutor)driver;
						jse.executeScript("scroll(0, 250)"); // if the element is on bottom.
						Thread.sleep(5000);*/
						driver.findElement(By.xpath("(//div[@class='sp-diagno-dash-timing' and contains(.,'"+PslotTime+"')]/following-sibling::div[2])[last()]")).click();  // Recent Appointment
						Browser.waitTill(60);
						
					}else{
						System.out.println("is empty");
						Browser.waitFortheElementXpath("//div[@class='sp-diagno-aptusername sp-diagno-dash-healthproblem']/span");
						driver.findElement(By.xpath("(//div[@class='sp-diagno-dash-timing' and contains(.,'"+PslotTime+"')]/following-sibling::div[2])[last()]")).click();  // Recent Appointment
						Browser.waitTill(60);

					}

				}
		
		// Doctors Checkin and check the recipient
		public  void diagnosticsCheckinCheckOut() throws Exception{
			Browser.clickOnTheElementByXpath(Elements_Diagnostics.checkinbutton);
			Browser.clickOnTheElementByID(Elements_Diagnostics.checkinstartconsultation);
			Thread.sleep(5000);
			Browser.selectByVisibleTextByID("0", "Completed");
			Browser.selectByVisibleTextByID("1", "Completed");
			Browser.clickOnTheElementByID(Elements_Diagnostics.packagessavebutton);
			Browser.enterTextByID(Elements_Diagnostics.appointmentnotes, "Notes of diagnotics");
			Browser.clickOnTheElementByID(Elements_Diagnostics.appointmentnotesavebutton);
			Browser.clickOnTheElementByID(Elements_Diagnostics.generatebillsbutton);
			Thread.sleep(10000);
			Browser.clickOnTheElementByID(Elements_Diagnostics.checkoutbutton);
			Thread.sleep(2000);
			Browser.verifyNotificationMessage("Checked-out successfully");
		}
		
		
		// Diagnostic logout 
		public  void diagnosticslogout() throws IOException, InterruptedException{			
			driver.get("https://"+LoadPropMac.Environment_Name+".zoylo.com/zyDiagnosticCenterAccount");
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("span.icon-diag-cen > i.fa.fa-sign-out"))	.click();
			Thread.sleep(2000);
			driver.findElement(By.id("logout")).click();
			Thread.sleep(5000);
			System.out.println("Diagnostics Logged Out "+LoadPropMac.Environment_Name);
		}

		
		
		//Schedule Methods
		
		
		
		/*  @Author      :Ch.Lakshmi Kanth
		 *  @Description : Click On the Schedule Menu From The Ribbon Panel
		 *  @Parameters  : 
		 *  @Return      : 
		 */
		
		public void ClickOnScheduleMenu() throws Exception{
			
			Browser.clickOnTheElementByID(Elements_Diagnostics.clickonschedulemenu);
			Thread.sleep(3000);
		}
		
		
		
	   
		/*  @Author      :Ch.Lakshmi Kanth
		 *  @Description : In Schedule Diagnostic Center Manager - Contact Menu Add Contact
		 *  @Parameters  : name,phone,email,fax
		 *  @Return      : 
		 */
		
		public void AddContactInSchedule(String name,String phone,String email,String fax) throws Exception{
			
			driver.findElement(By.id(Elements_Diagnostics.clickondiagnosticmanage)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(Elements_Diagnostics.clickoncontact)).click();
			Thread.sleep(2000);
			driver.findElement(By.id(Elements_Diagnostics.clickaddclinic)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Diagnostics.addname)).sendKeys(name);
			Thread.sleep(2000);
			driver.findElement(By.id(Elements_Diagnostics.addphone)).sendKeys(phone);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Diagnostics.addemail)).sendKeys(email);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Diagnostics.addfax)).sendKeys(fax);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Diagnostics.clickonsave)).click();
			Browser.CheckNotificationMessage("Contact Information updated successfully");
			Thread.sleep(5000);
		}
		
		/*   Below is the  Method
		 *  @Author      :Ch.Lakshmi Kanth
		 *  @Description : In Schedule Diagnostic Center Manager - Contact Menu Delete Contact
		 *  @Parameters  : 
		 *  @Return      : 
		 */
		
		public void DeleteContactInSchedule() throws Exception{
			
			driver.findElement(By.xpath(Elements_Diagnostics.clickondelete)).click();
			Thread.sleep(2000);
			driver.findElement(By.id(Elements_Diagnostics.clickonsave)).click();
			Browser.CheckNotificationMessage("Contact Information updated successfully");
		}
		
		/*   Below is the  Method
		 *  @Author      :Ch.Lakshmi Kanth
		 *  @Description : In Schedule Diagnostic Center Manager - Contact Menu Edit Contact
		 *  @Parameters  : name,phone,email,fax
		 *  @Return      : 
		 */
		
		public void EditConatctInSchedule(String name,String phone,String email,String fax) throws Exception{
			
			driver.findElement(By.xpath("//div[@class='paddingb0 sp-diag-homepick-edit contactsEdit']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id(Elements_Diagnostics.addname)).clear();
			driver.findElement(By.id(Elements_Diagnostics.addname)).sendKeys(name);
			Thread.sleep(2000);
			driver.findElement(By.id(Elements_Diagnostics.addphone)).clear();
			driver.findElement(By.id(Elements_Diagnostics.addphone)).sendKeys(phone);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Diagnostics.addemail)).clear();
			driver.findElement(By.id(Elements_Diagnostics.addemail)).sendKeys(email);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Diagnostics.addfax)).clear();
			driver.findElement(By.id(Elements_Diagnostics.addfax)).sendKeys(fax);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Diagnostics.clickonsave)).click();;
			Browser.CheckNotificationMessage("Contact Information updated successfully");
			Thread.sleep(5000);
		}
		
		/*   Below is the  Method
		 *  @Author      :Ch.Lakshmi Kanth
		 *  @Description : In Schedule Diagnostic Center Manager - Package Menu :Add Package
		 *  @Parameters  : packagename,discount,Description, testname,testdescription 
		 *  @Return      : 
		 */
		
		public void ScheduleInManageAddPackage(String packagename,String cost,String discount, String description,String testname,String testdescription) throws Exception{
			
			Browser.clickOnTheElementByID(Elements_Diagnostics.clickondiagnosticmanage);
			Browser.waitFortheElementXpath(Elements_Diagnostics.clickonpackagemenu);
			Browser.clickOnTheElementByXpath(Elements_Diagnostics.clickonpackagemenu);
			Browser.waitFortheID("addPackage");
			Browser.clickOnTheElementByID("addPackage");
			Browser.waitFortheID(Elements_Diagnostics.clickonaddpackagebutton);
			Browser.clickOnTheElementByID(Elements_Diagnostics.clickonaddpackagebutton);
			System.out.println("Clicked on the add button");
			Browser.waitFortheElementXpath(Elements_Diagnostics.ManagePackagename);
			Browser.enterTextByXpath(Elements_Diagnostics.ManagePackagename, packagename);
			Browser.waitFortheElementXpath(Elements_Diagnostics.ManagePackagecost);
			Browser.enterTextByXpath(Elements_Diagnostics.ManagePackagecost,cost);
			Browser.waitFortheElementXpath(Elements_Diagnostics.ManagePackagediscount);
			Browser.enterTextByXpath(Elements_Diagnostics.ManagePackagediscount,discount);
			Browser.waitFortheElementXpath(Elements_Diagnostics.ManagePackagedesc);
			Browser.enterTextByXpath(Elements_Diagnostics.ManagePackagedesc, description);
			Browser.waitFortheElementXpath(Elements_Diagnostics.ManagePackageAddTest);
			Browser.clickOnTheElementByXpath(Elements_Diagnostics.ManagePackageAddTest);
			Thread.sleep(5000);
			Browser.enterTextByXpath(Elements_Diagnostics.ManagePackageTestname, testname);
			Thread.sleep(1000);
			Browser.enterTextByXpath(Elements_Diagnostics.ManagePackageTestdesc, testdescription);
			Browser.clickOnTheElementByID(Elements_Diagnostics.ManagePackageSavePackage);
			Browser.CheckNotificationMessage("Diagnostics Packages updated successfully");
			Thread.sleep(3000);
			
		}
		
		  
		/*  @Author      :Ch.Lakshmi Kanth
		 *  @Description : In Schedule Diagnostic Center Manager - Package Menu : Edit Package
		 *  @Parameters  : packagename,discount,Description, testname,testdescription 
		 *  @Return      : 
		 */
		
		public void SchecduleEditPackageInManage(String packagename,String cost,String discount,String desc,String testname,String testdescription) throws Exception{
			
			driver.findElement(By.xpath(Elements_Diagnostics.ManagePackageEditlink)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(Elements_Diagnostics.ManagePackagename)).clear();
			driver.findElement(By.xpath(Elements_Diagnostics.ManagePackagename)).sendKeys(packagename);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Diagnostics.ManagePackagecost)).clear();
			driver.findElement(By.xpath(Elements_Diagnostics.ManagePackagecost)).sendKeys(cost);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Diagnostics.ManagePackagediscount)).clear();
			driver.findElement(By.xpath(Elements_Diagnostics.ManagePackagediscount)).sendKeys(discount);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Diagnostics.ManagePackagedesc)).clear();
			driver.findElement(By.xpath(Elements_Diagnostics.ManagePackagedesc)).sendKeys(desc);
			Thread.sleep(2000);
			driver.findElement(By.xpath(Elements_Diagnostics.ManagePackageTestname)).clear();
			driver.findElement(By.xpath(Elements_Diagnostics.ManagePackageTestname)).sendKeys(testname);
			Thread.sleep(2000);
			driver.findElement(By.xpath(Elements_Diagnostics.ManagePackageTestdesc)).clear();
			driver.findElement(By.xpath(Elements_Diagnostics.ManagePackageTestdesc)).sendKeys(testdescription);
			driver.findElement(By.id(Elements_Diagnostics.ManagePackageSavePackage)).click();
			Browser.CheckNotificationMessage("Diagnostics Packages updated successfully");
		}
		
		/*   Below is the  Method
		 *  @Author      :Ch.Lakshmi Kanth
		 *  @Description : In Schedule Diagnostic Center Manager - Package Menu : Submit The Package for Approval
		 *  @Parameters  : 
		 *  @Return      : 
		 */
		
		public void ScheduleInManageSubmitPackageforApproval() throws Exception  {
			
			Browser.clickOnTheElementByXpath(Elements_Diagnostics.ManagePacakgeApproval);
			Thread.sleep(8000);
			String ActualNotification= driver.findElement(By.xpath(Elements_Diagnostics.ManageSubmitPackageApproval)).getText();
			System.out.println("ActualNotificationMessage="+ActualNotification);
		    Assert.assertEquals(ActualNotification,"Approval is pending");
		}
		
		
		/*   Below is the  Method
		 *  @Author      :Ch.Lakshmi Kanth
		 *  @Description : In Schedule To Click on HomePickup Menu
		 *  @Parameters  : 
		 *  @Return      : 
		 */
		
		public void clickonhomevisitmenu() throws Exception{
			
			Browser.clickOnTheElementByXpath(Elements_Diagnostics.clickonhomevisitmenu);
			Thread.sleep(2000);
		}
		
		

		/*  Below is the  Method
		 *  @Author      : Ch.Lakshmi Kanth
		 *  @Description : In Schedule HomePickup Menu Tests : Add Tests
		 *  @Parameters  : testname, description, cost,discount
		 *  @Return      : 
		 */
		
		public void ScheduleHomePickUpAddTest(String testname,String description,String cost,String discount) throws Exception{	
	
			Browser.clickOnTheElementByID(Elements_Diagnostics.clickonhometestaddbutton);
			Browser.waitFortheElementXpath(Elements_Diagnostics.HomePickupTestTestname);
			Browser.enterTextByXpath(Elements_Diagnostics.HomePickupTestTestname, testname);
			Browser.waitFortheElementXpath(Elements_Diagnostics.HomePickupTestTestdesc);
			Browser.enterTextByXpath(Elements_Diagnostics.HomePickupTestTestdesc, description);
			Browser.waitFortheElementXpath(Elements_Diagnostics.HomePickupTestTestcost);
			Browser.enterTextByXpath(Elements_Diagnostics.HomePickupTestTestcost, cost);
			Browser.waitFortheElementXpath(Elements_Diagnostics.HomePickupTestTestdiscount);
			Browser.enterTextByXpath(Elements_Diagnostics.HomePickupTestTestdiscount, discount);
			Browser.waitFortheID(Elements_Diagnostics.clickhomevisittestsavebutton);
			Browser.clickOnTheElementByID(Elements_Diagnostics.clickhomevisittestsavebutton);
			Browser.CheckNotificationMessage("Home Visit Tests updated successfully");
			
		}
		

		/*  Below is the  Method
		 *  @Author      : Ch.Lakshmi Kanth
		 *  @Description : In Schedule HomePickup Menu Tests : Edit Tests
		 *  @Parameters  : testname, description, cost,discount
		 *  @Return      : 
		 */
		
		public void ScheduleHomePickupToEditTests(String testname,String description,String cost,String discount) throws Exception{
			driver.findElement(By.xpath(Elements_Diagnostics.HomePickupTestsEditLink)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Diagnostics.HomePickupTestTestname)).clear();
			driver.findElement(By.xpath(Elements_Diagnostics.HomePickupTestTestname)).sendKeys(testname);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Diagnostics.HomePickupTestTestdesc)).clear();
			driver.findElement(By.xpath(Elements_Diagnostics.HomePickupTestTestdesc)).sendKeys(description);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Diagnostics.HomePickupTestTestcost)).clear();
			driver.findElement(By.xpath(Elements_Diagnostics.HomePickupTestTestcost)).sendKeys(cost);	
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Diagnostics.HomePickupTestTestdiscount)).clear();
			driver.findElement(By.xpath(Elements_Diagnostics.HomePickupTestTestdiscount)).sendKeys(discount);
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Diagnostics.clickhomevisittestsavebutton)).click();
			Browser.CheckNotificationMessage("Home Visit Tests updated successfully");
		}
		
		
		/*  Below is the  Method
		 *  @Author      : Ch.Lakshmi Kanth
		 *  @Description : In Schedule HomePickup Menu Tests : Submit Test For Approval
		 *  @Parameters  : testname, description, cost,discount
		 *  @Return      : 
		 */
		
		public void ScheduleHomePickupSubmitTestsForApproval() throws Exception{
			driver.findElement(By.xpath(Elements_Diagnostics.HomePickupTestSubmit)).click();
			Thread.sleep(3000);
			String ActualNotification=driver.findElement(By.xpath(Elements_Diagnostics.HomePickupTestSubmitNotification)).getText();
			assertion.assertEquals(ActualNotification, "Approval is pending");
			assertion.assertAll();
			Assert.assertEquals(ActualNotification,"Approval is pending");
		}
		
		
		/*  Below is the  Method
		 *  @Author      : Ch.Lakshmi Kanth
		 *  @Description : In Schedule HomePickup Menu : Click On Packages Menu
		 *  @Parameters  : testname, description, cost,discount
		 *  @Return      : 
		 */
		
		public void ClickOnSchedulePackageHomePickUp() throws Exception{
			
			Browser.clickOnTheElementByXpath(Elements_Diagnostics.clickonpackagemenuinhomepickup);
			 Thread.sleep(3000);
		}
		
		
		/*  Below is the  Method
		 *  @Author      : Ch.Lakshmi Kanth
		 *  @Description : In Schedule HomePickup Menu Packages Menu: Add Package
		 *  @Parameters  :packagename, desc,  cost, discount, testname, testdesc
		 *  @Return      : 
		 */
		
		public void ScheduleHomePickUpAddPackage(String packagename,String desc,String cost, String discount,String testname,String testdesc) throws Exception{
			
			 driver.findElement(By.id(Elements_Diagnostics.clickonhomevisitaddpackagebutton)).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath(Elements_Diagnostics.HomePickupPackName)).sendKeys(packagename);
			 Thread.sleep(2000);
			 driver.findElement(By.xpath(Elements_Diagnostics.HomepickupPackDesc)).sendKeys(desc);
			 Thread.sleep(2000);
			 driver.findElement(By.xpath(Elements_Diagnostics.HomepickupPackCost)).sendKeys(cost);
			 Thread.sleep(2000);
			 driver.findElement(By.xpath(Elements_Diagnostics.HomepickupPackDiscount)).sendKeys(discount);
			 Thread.sleep(3000);
			 driver.findElement(By.xpath(Elements_Diagnostics.HomePickupPackClickAddTest)).click();
			 Thread.sleep(3000);
			 WebElement sc= driver.findElement(By.xpath("(//input[starts-with(@id, 'homeVisitPackTestName')])[last()]"));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sc);
			 driver.findElement(By.xpath("(//input[starts-with(@id, 'homeVisitPackTestName')])[last()]")).sendKeys(testname);
			 Thread.sleep(3000);
			 driver.findElement(By.xpath(Elements_Diagnostics.HomepickupPacktestdesc)).sendKeys(testdesc);
			 Thread.sleep(3000);
			 driver.findElement(By.id(Elements_Diagnostics.clickonhomevisitpackagesavebutton)).click();
			 Browser.CheckNotificationMessage("Home Visit Packages updated successfully");
			 Thread.sleep(1000);
			
		}
		
		/*  Below is the  Method
		 *  @Author      : Ch.Lakshmi Kanth
		 *  @Description : In Schedule HomePickup Menu Packages Menu: Submit the Package For Approval
		 *  @Parameters  :
		 *  @Return      : 
		 */
		
		public void ScheduleHomePickUpPackageSendforApproval() throws Exception{
			Browser.clickOnTheElementByXpath(Elements_Diagnostics.HomePickupPackSubmit);
			Thread.sleep(8000);
			String ActualNotification=driver.findElement(By.xpath(Elements_Diagnostics.HomePickupPackSubmitNotification)).getText();
			System.out.println("ActualNotificationMessage="+ActualNotification);
			 Assert.assertEquals(ActualNotification,"Approval is pending");
			 Thread.sleep(1000);
			 
		}
		
		/*  Below is the  Method
		 *  @Author      : Ch.Lakshmi Kanth
		 *  @Description : In Schedule HomePickup Menu Packages Menu: Edit Package
		 *  @Parameters  :packagename, desc,  cost, discount, testname, testdesc
		 *  @Return      : 
		 */
		
		public void ScheduleHomePickupEditPackage(String packagename,String desc,String cost, String discount,String testname,String testdesc) throws Exception{
			
			driver.findElement(By.xpath(Elements_Diagnostics.HomePickupPackEditLink)).click();
			 System.out.println("Clicked on Edit Link");
			 Thread.sleep(2000);
			 driver.findElement(By.xpath(Elements_Diagnostics.HomePickupPackName)).clear();
			 driver.findElement(By.xpath(Elements_Diagnostics.HomePickupPackName)).sendKeys(packagename);
			 Thread.sleep(2000);
			 driver.findElement(By.xpath(Elements_Diagnostics.HomepickupPackDesc)).clear();
			 driver.findElement(By.xpath(Elements_Diagnostics.HomepickupPackDesc)).sendKeys(desc);
			 Thread.sleep(2000);
			 driver.findElement(By.xpath(Elements_Diagnostics.HomepickupPackCost)).clear();
			 driver.findElement(By.xpath(Elements_Diagnostics.HomepickupPackCost)).sendKeys(cost);
			 Thread.sleep(2000);
			 driver.findElement(By.xpath(Elements_Diagnostics.HomepickupPackDiscount)).clear();
			 driver.findElement(By.xpath(Elements_Diagnostics.HomepickupPackDiscount)).sendKeys(discount);
			Thread.sleep(2000);
			driver.findElement(By.xpath(Elements_Diagnostics.HomepickupPacktestname)).clear();
			driver.findElement(By.xpath(Elements_Diagnostics.HomepickupPacktestname)).sendKeys(testname);
			 Thread.sleep(3000);
			 driver.findElement(By.xpath(Elements_Diagnostics.HomepickupPacktestdesc)).clear();
			 driver.findElement(By.xpath(Elements_Diagnostics.HomepickupPacktestdesc)).sendKeys(testdesc);
			 Thread.sleep(3000);
			 driver.findElement(By.id(Elements_Diagnostics.clickonhomevisitpackagesavebutton)).click();
			 //Thread.sleep(8000);
			 Browser.CheckNotificationMessage("Home Visit Packages updated successfully");
		}
		
		/*  Below is the  Method
		 *  @Author      : Ch.Lakshmi Kanth
		 *  @Description : In Schedule Click on Diagnostic Center- Manage Menu
		 *  @Parameters  :
		 *  @Return      : 
		 */
		
		public void ScheduleClickOnDiagnosticManage() throws Exception{
			Browser.clickOnTheElementByXpath(Elements_Diagnostics.clcikondiagnosticmanagemenu);
			Thread.sleep(1000);
		}
		
		/*  Below is the  Method
		 *  @Author      : Ch.Lakshmi Kanth
		 *  @Description : In Schedule Diagnostic Center Manage Menu : Click On Tests Menu
		 *  @Parameters  :packagename, desc, testname, cost, discount, testname, testdesc
		 *  @Return      : 
		 */
		
		public void ScheduleDiagnosticManageClickonTestsMenu() throws Exception{
			Browser.clickOnTheElementByXpath(Elements_Diagnostics.clickonmanagetestsmenu);
			Thread.sleep(2000);
		}
		
		
		/*  Below is the  Method
		 *  @Author      : Ch.Lakshmi Kanth
		 *  @Description : In Schedule Diagnostic Center Manage Menu Tests Menu : Add Tests
		 *  @Parameters  :packagename, desc, testname, cost, discount, testname, testdesc
		 *  @Return      : 
		 */
		
		public void ScheduleDiagnosticManageAddTests(String testname,String description,String cost,String discount) throws Exception{
		
			Browser.clickOnTheElementByID("addTests");
		    Browser.waitFortheElementXpath(Elements_Diagnostics.ManageTestTestname);
		    Browser.enterTextByXpath(Elements_Diagnostics.ManageTestTestname, testname);
		    Browser.waitFortheElementXpath(Elements_Diagnostics.ManageTestTestDesc);
		    Browser.enterTextByXpath(Elements_Diagnostics.ManageTestTestDesc, description);
		    Browser.waitFortheElementXpath(Elements_Diagnostics.ManageTestCost);
		    Browser.enterTextByXpath(Elements_Diagnostics.ManageTestCost, cost);
		    Browser.waitFortheElementXpath(Elements_Diagnostics.ManageTestDiscount);
		    Browser.enterTextByXpath(Elements_Diagnostics.ManageTestDiscount, discount);
		    Browser.waitFortheID(Elements_Diagnostics.ManageTestSave);
		    Browser.clickOnTheElementByID(Elements_Diagnostics.ManageTestSave);
		    Browser.CheckNotificationMessage("Tests updated successfully");
		    
		}
		
		/*  Below is the  Method
		 *  @Author      : Ch.Lakshmi Kanth
		 *  @Description : In Schedule Diagnostic Center Manage Menu Tests Menu : Submit Tests For Approval
		 *  @Parameters  :
		 *  @Return      : 
		 */
		
		public void ClickOnToggletoSubmitTestsForApproval() throws Exception{
			Browser.clickOnTheElementByXpath(Elements_Diagnostics.ManageTestSubmit);
			Thread.sleep(10000);
//			String ActualNotification=driver.findElement(By.xpath(Elements_Diagnostics.ManageTestSubmitNotification)).getText();
//			Assert.assertEquals(ActualNotification,"Approval is pending");
			
		}
		
		
		
		/*  Below is the  Method
		 *  @Author      : Ch.Lakshmi Kanth
		 *  @Description : In Schedule Diagnostic Center Manage Menu Tests Menu : Edit Tests
		 *  @Parameters  : testname, testdesc cost, discount 
		 *  @Return      : 
		 */
		
		public void ScheduleInManageEditTests(String testname,String testdesc,String cost,String discount) throws Exception{
		
			driver.findElement(By.xpath(Elements_Diagnostics.ManageTestEditLink)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Diagnostics.ManageTestTestname)).clear();
			 driver.findElement(By.xpath(Elements_Diagnostics.ManageTestTestname)).sendKeys(testname);
			 Thread.sleep(1000);
			 driver.findElement(By.xpath(Elements_Diagnostics.ManageTestTestDesc)).clear();
			 driver.findElement(By.xpath(Elements_Diagnostics.ManageTestTestDesc)).sendKeys(testdesc);
			 Thread.sleep(1000);
			 driver.findElement(By.xpath(Elements_Diagnostics.ManageTestCost)).clear();
			 driver.findElement(By.xpath(Elements_Diagnostics.ManageTestCost)).sendKeys(cost);
			 Thread.sleep(1000);
			 driver.findElement(By.xpath(Elements_Diagnostics.ManageTestDiscount)).clear();
			 driver.findElement(By.xpath(Elements_Diagnostics.ManageTestDiscount)).sendKeys(discount);
			 Thread.sleep(1000);
			 driver.findElement(By.id(Elements_Diagnostics.ManageTestSave)).click();
		    Browser.CheckNotificationMessage("Tests updated successfully");
		}
		
		
		/*  Below is the  Method
		 *  @Author      : Ch.Lakshmi Kanth
		 *  @Description : Launching New Browser To Log In To Admin Account
		 *  @Parameters  : username,password
		 *  @Return      : 
		 */
		public void LaunchBrowserToLoginIntoAdminAccount(String username,String password) throws Exception{
			
			System.setProperty("webdriver.chrome.driver", "BrowserDrivers/chromedriver");
			ChromeOptions options = new ChromeOptions(); // Added to remove new chrome warning message
			options.addArguments("disable-infobars");   // Added to remove new chrome warning message
			options.addArguments("disable-save-password-bubble");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("https:zoyloqa.zoylo.com/login");
			driver.findElement(By.id(Elements_Diagnostics.adminusername)).sendKeys(username);
			Thread.sleep(2000);
			driver.findElement(By.id(Elements_Diagnostics.adminpassword)).sendKeys(password);
			Thread.sleep(2000);
			driver.findElement(By.xpath(Elements_Diagnostics.adminlogin)).click();
			Thread.sleep(3000);
		}
		
		/*  Below is the  Method
		 *  @Author      : Ch.Lakshmi Kanth
		 *  @Description : Functionality in Admin Login Search for testname
		 *  @Parameters  : testnames
		 *  @Return      : 
		 */
	
      public void ApproveTestInAdmin(String testname) throws Exception{
    	//driver.get(Elements_Diagnostics.diagnosticapprovalsurl);
  		Thread.sleep(3000);
  		driver.findElement(By.xpath(Elements_Diagnostics.adminsearchbutton)).sendKeys(testname);
  		Thread.sleep(5000);
  		driver.findElement(By.xpath(Elements_Diagnostics.facilitationbutton)).click();
  		driver.findElement(By.xpath(Elements_Diagnostics.facilitationbutton)).clear();
  		Thread.sleep(2000);
  		driver.findElement(By.xpath(Elements_Diagnostics.facilitationbutton)).sendKeys("2");
  		Thread.sleep(2000);
  		driver.findElement(By.xpath(Elements_Diagnostics.adminsearchbutton)).click();
  		Thread.sleep(6000);
  		driver.findElement(By.xpath(Elements_Diagnostics.adminapprovebutton)).click();
  		Thread.sleep(10000);
      }
      
      /*  Below is the  Method
		 *  @Author      : Ch.Lakshmi Kanth
		 *  @Description : To Make the Tests and Packages in Diagnostic Centre- Manager Menu & Home  Pickup Menu as Active
		 *  @Parameters  : username,password
		 *  @Return      : 
		 */
      public void ScheduleHomePickupMakeTestsActive() throws Exception{
    	  
    	  WebElement sc=driver.findElement(By.xpath("(//span[@class='sp-diag-homepick-packactive-hours-switch-switch'])[last()]"));
  		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sc);
  		Thread.sleep(1000);
  		driver.findElement(By.xpath("(//span[@class='sp-diag-homepick-packactive-hours-switch-switch'])[last()]")).click();
  		Thread.sleep(2000);
  		driver.findElement(By.id(Elements_Diagnostics.clickhomevisittestsavebutton)).click();
  		Browser.CheckNotificationMessage("Home Visit Tests updated successfully");
      }
		
      /*
  	 * @ Author: Sagar Sen
  	 * @ Description: This method will route to diagnostic profile picture pop up
  	 * @ Pram:
  	 * @ Return:
  	 */
  	public void goToDcProfilePicture() throws Exception
  	{
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.dc_ProfilePicture);
		Browser.waitFortheElementXpath(Elements_Doctors.doctor_profilePicturePopUp);
  	}
}//main Class
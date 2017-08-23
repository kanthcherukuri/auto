package recipientDiagnosticTestScripts;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.LoadPropMac;
import testBase.RecipientPage;
import testBase.TestUtils;

public class Recipient_ZOY2048_DiagnosticsRechangeNcancelHomeVisitApt extends LoadPropMac
{
	public TestUtils Browser;
	public RecipientPage RecipientPage;
	
	@Test()
	public void DiagnosticsRechangeNcancelHomeVisitApt() throws InterruptedException
	{
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		Thread.sleep(2000);
		RecipientPage.goToDiagnostics();
		RecipientPage.searchDCInZoyloMAP(Diagnostic_Name);
		RecipientPage.bookAppointmentOnDiagnostics();
		Browser.waitFortheElementXpath(Elements_Recipients.dcNameHolder);
		String dcName=driver.findElement(By.xpath(Elements_Recipients.dcNameHolder)).getText();
		driver.findElement(By.id(Elements_Recipients.dcHomePickUp)).click();
		Browser.waitFortheElementXpath("//div[@class='zy-rec-diag-hm-add-title']"); //Address heading
		driver.findElement(By.xpath(Elements_Recipients.recipient_firstHomeAddress)).click();
		driver.findElement(By.xpath(Elements_Recipients.dcHomeVisitAddressProceed)).click();
		Browser.waitFortheElementXpath("(.//*[@id='tests_search'])[2]"); //search bar xpath
		RecipientPage.selectDChomeVisitSlots();
		RecipientPage.confirmAppointmentOnDiagnostics();
		RecipientPage.makePayment();
		Browser.waitFortheElementXpath("//h5[contains(., 'Thank you for booking appointment at Diagnosticszoylo through Zoylo')]");
		System.out.println("Home visit appointment is successfully booked");		
		
		 //Get Appointment ID
		String APID = Browser.getAppointmentID();
		//Re-Scheduling the Apppointment
		RecipientPage.openMyAccounts("Appointments");
		RecipientPage.UpcomingAppointment(APID, "Reschedule");
		Browser.clickOnTheElementByXpath(Elements_Recipients.recipient_firstHomeAddress);
		Browser.clickOnTheElementByXpath(Elements_Recipients.dcHomeVisitAddressProceed);
		Browser.clickOnTheElementByXpath("(//div[@class='panel-collapse collapse in']/ul/li[@class='timeSlot sp-available-slots'])[2]");							 
		Browser.verifyNotificationMessage("Your appointment slot has been successfully CHANGED");
		//Verifying Re-shedule label in appointments
		String Appointment_Status_Reshedule=driver.findElement(By.xpath("//div[contains(.,'"+APID+"')]/preceding-sibling::div[@class='patientApmtStatus']")).getText();
        Assert.assertEquals(Appointment_Status_Reshedule, "Rescheduled");
		//Canceling the appointment			
        RecipientPage.UpcomingAppointment(APID, "Cancel");	   
        Browser.verifyNotificationMessage("Appointment has been Cancelled");
		driver.findElement(By.id("hist")).click();  // my History
		Thread.sleep(2000);
		String Appointment_Status_cancelled=driver.findElement(By.xpath("//div[contains(.,'"+APID+"')]/preceding-sibling::div[@class='paddingl0 apt-dt-chng']")).getText();
        Assert.assertEquals(Appointment_Status_cancelled, "Cancelled");
		
		
	}
	
	@BeforeClass
	public void launchbrowser() throws Exception
	{
		LoadBrowserProperties();
		Elements_Admin.Admin_PageProperties(); // loading the Elements
		Elements_Recipients.Recipients_PageProperties();
		Browser= new TestUtils(driver);
		RecipientPage=new RecipientPage(driver);
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
	}
	
	@AfterClass
	public void closebrowser() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
}

package recipientDiagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.LoadPropMac;
import testBase.RecipientPage;
import testBase.TestUtils;

public class Recipient_ZOY2041_bookDChomeVisitAppointment extends LoadPropMac
{
	public TestUtils Browser;
	public RecipientPage RecipientPage;
	
	@Test()
	public void bookDChomeVisitapt() throws InterruptedException
	{
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		Thread.sleep(2000);
		RecipientPage.goToDiagnostics();
		RecipientPage.searchDCInZoyloMAP(Diagnostic_Name);
		RecipientPage.bookAppointmentOnDiagnostics();
		Browser.waitFortheElementXpath(Elements_Recipients.dcNameHolder);
		driver.findElement(By.id(Elements_Recipients.dcHomePickUp)).click();
		Browser.waitFortheElementXpath("//div[@class='zy-rec-diag-hm-add-title']"); //Address heading
		driver.findElement(By.xpath(Elements_Recipients.recipient_firstHomeAddress)).click();
		driver.findElement(By.xpath(Elements_Recipients.dcHomeVisitAddressProceed)).click();
		Browser.waitFortheElementXpath("(.//*[@id='tests_search'])[2]"); //search bar xpath
		RecipientPage.selectDChomeVisitSlots();
		RecipientPage.confirmAppointmentOnDiagnostics();
		RecipientPage.makePaymentforDC();
		Browser.waitFortheElementXpath("//h5[contains(., 'Thank you for booking appointment at Diagnosticszoylo through Zoylo')]");
		System.out.println("Home visit appointment is successfully booked");
	
	
	}
	
	@BeforeClass
	public void launchbrowser() throws Exception
	{
		LoadBrowserProperties();
		Elements_Admin.Admin_PageProperties(); // loading the Elements
		Elements_Recipients.Recipients_PageProperties();
		Browser= new TestUtils(driver);
		RecipientPage=new RecipientPage(driver);
		driver.get(loginPage_Url);
	}
	
	@AfterClass
	public void closebrowser() throws InterruptedException
	{
		driver.quit();
	}
}

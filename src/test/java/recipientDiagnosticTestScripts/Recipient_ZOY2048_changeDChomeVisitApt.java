package recipientDiagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.LoadPropMac;
import testBase.RecipientPage;
import testBase.TestUtils;

public class Recipient_ZOY2048_changeDChomeVisitApt extends LoadPropMac
{
	public TestUtils Browser;
	public RecipientPage RecipientPage;
	
	@Test()
	public void bookDChomeVisitapt() throws InterruptedException
	{
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		Thread.sleep(2000);
		RecipientPage.goToDiagnostics();
		RecipientPage.searchInZoyloMAP(Diagnostic_Name);
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
		RecipientPage.makePaymentforDC();
		Browser.waitFortheElementXpath("//h5[contains(., 'Thank you for booking appointment at Diagnosticszoylo through Zoylo')]");
		System.out.println("Home visit appointment is successfully booked");
		String aptID=driver.findElement(By.xpath("(//div[@class='book-dtbox']//h3)[1]")).getText();
		String lastWord = aptID.substring(aptID.lastIndexOf(" ")+1);
		System.out.println(aptID);
		System.out.println(lastWord);
		driver.get(recipient_myaccount);
		Browser.waitFortheElementXpath("(//span[@class='usr-pr-tab-txt'])[1]");
		driver.findElement(By.xpath("(//span[@class='usr-pr-tab-txt'])[3]")).click();
		Browser.waitFortheID("upcmng");
		driver.findElement(By.id("aptSearch")).click();
		driver.findElement(By.id("aptSearch")).sendKeys(lastWord);
		Browser.waitforTextbyxpath("(//div[@class='zy-diagno-zy-apt-chng']//span)[2]", lastWord);
		driver.findElement(By.xpath("//span[@class='zy-diagno-doc-revw change-DcApt apt-doc-col']")).click();
		Browser.waitforTextbyxpath(Elements_Recipients.dcNameHolder, dcName);
		Browser.waitFortheElementXpath("//div[@class='zy-rec-diag-hm-add-title']"); //Address heading
		driver.findElement(By.xpath(Elements_Recipients.recipient_firstHomeAddress)).click();
		driver.findElement(By.xpath(Elements_Recipients.dcHomeVisitAddressProceed)).click();
		Browser.waitFortheElementXpath("(//a[contains(., 'Change')])[2]");
		if(driver.findElements(By.xpath("(//div[@id='diag-rec-h-timings']//div[@class='sp-slots-booking']//li[@class='timeSlot sp-available-slots'])[2]")).isEmpty())
		{
			throw new SkipException("Slots are not available");
		}
		else
		{
			driver.findElement(By.xpath("(//div[@id='diag-rec-h-timings']//div[@class='sp-slots-booking']//li[@class='timeSlot sp-available-slots'])[2]")).click();  // book
			Thread.sleep(2000);
			System.out.println("Cliked on Available Slot Button from diagonostics");
			Browser.CheckNotificationMessage("Successfully changed the appointment slot");
		}
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
		Thread.sleep(3000);
		driver.close();
	}
}

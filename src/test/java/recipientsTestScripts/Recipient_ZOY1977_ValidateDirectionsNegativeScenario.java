package recipientsTestScripts;

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

public class Recipient_ZOY1977_ValidateDirectionsNegativeScenario extends LoadPropMac
{
	public TestUtils Browser;
	public RecipientPage RecipientPage;
	
	@Test()
	public void validateDirectionsnegativeScenario() throws InterruptedException
	{
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		Thread.sleep(2000);
		RecipientPage.searchInZoyloMAP(Doctor_Name);
		driver.findElement(By.xpath("//*[@id='bookAppointment']/button")).click();
		Browser.waitforTextbyxpath("//h1[contains(., 'Doctorzoylo')]", "Doctorzoylo");
		RecipientPage.addressAssertion();
		Thread.sleep(1000);
		//driver.findElement(By.id("session4")).click();
		//Thread.sleep(1000);
		RecipientPage.selectDefaultSlot();
		Browser.waitforTextbyxpath("//h1[contains(., 'Book Appointment')]", "Book Appointment");
		driver.navigate().refresh();
		driver.findElement(By.xpath("//a[@class='cancel']")).click();
		RecipientPage.addressAssertion();	
	}
	
	@BeforeClass
	public void launchbrowser() throws Exception
	{
		LoadBrowserProperties();
		Elements_Admin.Admin_PageProperties(); // loading the Elements
		Elements_Recipients.Recipients_PageProperties();
		Browser= new TestUtils(driver);
		RecipientPage=new RecipientPage(driver);
		driver.get(recipient_url);
	}
	
	@AfterClass
	public void closebrowser() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
}

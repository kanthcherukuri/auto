package recipientsTestScripts;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.openqa.selenium.By;
import objectRepository.Elements_Home;
import objectRepository.Elements_Recipients;
import testBase.*;

public class Recipient_ZOY1364_ValidateaccountIconOnHeader extends LoadPropMac
{

	public TestUtils Browser;
	public RecipientPage RecipientPage;

	
	@Test
	public void headerAccountIcon() throws InterruptedException
	{
		
		reloadtohomePge();
		
		driver.findElement(By.xpath(Elements_Recipients.link_aboutHeaderIndex)).click();
		Browser.waitFortheElementXpath(Elements_Recipients.link_h2Header);
		String actual1 = Browser.getTextByXpath(Elements_Recipients.link_h2Header);
		Assert.assertEquals("About Us", actual1);
		
		reloadtohomePge();
		
		driver.findElement(By.xpath(Elements_Recipients.link_contactUsIndex)).click();
		Browser.waitFortheElementXpath(Elements_Recipients.link_header);
		String actual2 = Browser.getTextByXpath(Elements_Recipients.link_header);
		Assert.assertEquals("Our Location", actual2);
		
		reloadtohomePge();
		
		driver.findElement(By.xpath(Elements_Recipients.link_termsIndex)).click();
		Browser.waitFortheElementXpath(Elements_Recipients.link_h2Header);
		String actual3 = Browser.getTextByXpath(Elements_Recipients.link_h2Header);
		Assert.assertEquals("Terms of Use", actual3);
		
		reloadtohomePge();
		
		driver.findElement(By.xpath(Elements_Recipients.link_privacyIndex)).click();
		Browser.waitFortheElementXpath(Elements_Recipients.link_h2Header);
		String actual4 = Browser.getTextByXpath(Elements_Recipients.link_h2Header);
		Assert.assertEquals("Privacy Policy", actual4);
		
		reloadtohomePge();
		
		driver.findElement(By.xpath(Elements_Recipients.link_cancellationIndex)).click();
		Browser.waitFortheElementXpath(Elements_Recipients.link_h2Header);
		String actual5 = Browser.getTextByXpath(Elements_Recipients.link_h2Header);
		Assert.assertEquals("Cancellation / Refund Policy", actual5);
		
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Elements_Recipients.Recipients_PageProperties(); //Load page elements of recipients
		Elements_Home.Home_PageProperties(); //Load home page elements
		RecipientPage = new RecipientPage(driver); // Loading Pages
		Browser= new TestUtils(driver);
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
	}
	
	@AfterClass()
	public void Exit() {
		
		driver.quit();
	} 
	public void reloadtohomePge() throws InterruptedException //method to reload and wait until page is loaded
	{
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/index");
		Browser.waitFortheElementXpath(Elements_Recipients.link_myAccountheaderIcon);
		driver.findElement(By.xpath(Elements_Recipients.link_myAccountheaderIcon)).click();
	}
}

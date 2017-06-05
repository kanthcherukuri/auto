package recipientsTestScripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Home;
import objectRepository.Elements_Recipients;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Recipient_ZOY1364_ValidateaccountIconOnHeader extends LoadPropMac
{

	public TestUtils Browser;
	
	@Test
	public void headerAccountIcon()
	{
		reloadtohomePge();
		
		driver.findElement(By.id(Elements_Recipients.link_aboutHeaderIndex)).click();
		Browser.waitFortheElementXpath("//h2[@class='page-head']");
		String actual2 = driver.findElement(By.xpath("//h2[@class='page-head']")).getText();
		AssertJUnit.assertEquals("About Us", actual2);
		
		reloadtohomePge();
		
		driver.findElement(By.id(Elements_Recipients.link_contactUsIndex)).click();
		Browser.waitFortheElementXpath("//h2[contains(., 'Our Location')]");
		String actual1 = driver.findElement(By.xpath("//h2[contains(., 'Our Location')]")).getText();
		AssertJUnit.assertEquals("Our Location", actual1);
		
		reloadtohomePge();
		
		driver.findElement(By.id(Elements_Recipients.link_termsIndex)).click();
		Browser.waitFortheElementXpath("//h3[@class='page-head']");
		String actual3 = driver.findElement(By.xpath("//h3[@class='page-head']")).getText();
		AssertJUnit.assertEquals("TERMS AND CONDITIONS", actual3);
		
		reloadtohomePge();
		
		driver.findElement(By.id(Elements_Recipients.link_privacyIndex)).click();
		Browser.waitFortheElementXpath("//h3[contains(., 'PRIVACY POLICY')]");
		String actual4 = driver.findElement(By.xpath("//h3[contains(., 'PRIVACY POLICY')]")).getText();
		AssertJUnit.assertEquals("PRIVACY POLICY", actual4);
		
		reloadtohomePge();
		
		driver.findElement(By.id(Elements_Recipients.link_cancellationIndex)).click();
		Browser.waitFortheElementXpath("//h3[contains(., 'Cancellation & Refund')]");
		String actual5 = driver.findElement(By.xpath("//h3[contains(., 'Cancellation & Refund')]")).getText();
		AssertJUnit.assertEquals("Cancellation & Refund", actual5);
		
		reloadtohomePge();
		
		driver.findElement(By.id(Elements_Recipients.link_signinIndex)).click();
		Browser.waitFortheID("forgotPassword");
		driver.findElement(By.id("forgotPassword")).isDisplayed();
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Elements_Recipients.Recipients_PageProperties(); //Load page elements of recipients
		Elements_Home.Home_PageProperties(); //Load home page elements
		Browser= new TestUtils(driver);
		//driver.get(base_url);

	}
	public void reloadtohomePge() //method to reload and wait until page is loaded
	{
		driver.get(index_url);
		Browser.waitFortheElementXpath("//img[@class='indexProfileImg']");
		driver.findElement(By.xpath(Elements_Recipients.link_myAccountheaderIcon)).click();
	}
}

package recipientsTestScripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Home;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Recipient_ZOY1332_ValidateHomePageElements extends LoadPropMac
{
	
	public TestUtils Browser;
	
	
	
	@Test
	public void homefunctionality()
	{
		Browser.waitFortheElementXpath("//a[contains(.,'Contact us')]");
		driver.findElement(By.xpath(Elements_Home.link_customerlogin)).click();
		driver.findElement(By.id("forgotPassword")).isDisplayed();
		reloadtohomePge();
		driver.findElement(By.xpath(Elements_Home.link_practicelogin)).click();
		Browser.waitFortheElementXpath("//div[@class='login-hd-txt']");
		String actual = driver.findElement(By.xpath("//div[@class='login-hd-txt']")).getText();
		Assert.assertEquals("Sign in", actual);
		reloadtohomePge();
		driver.findElement(By.xpath(Elements_Home.link_contactus)).click();
		String actual1 = driver.findElement(By.xpath("//h2[contains(., 'Our Location')]")).getText();
		Assert.assertEquals("Our Location", actual1);
		reloadtohomePge();
		driver.findElement(By.xpath(Elements_Home.link_aboutus)).click();
		String actual2 = driver.findElement(By.xpath("//h2[@class='page-head']")).getText();
		Assert.assertEquals("About Us", actual2);
		reloadtohomePge();
		Browser.scrollbyxpath("//a[contains(.,'Terms & Conditions')]");
		Browser.waitFortheElementXpath("//a[contains(.,'Terms & Conditions')]");
		driver.findElement(By.xpath(Elements_Home.link_termsconditions)).click();
		String actual3 = driver.findElement(By.xpath("//h4[contains(., 'Disclaimer')]")).getText();
		Assert.assertEquals("Disclaimer", actual3);
		reloadtohomePge();
		Browser.scrollbyxpath("//a[contains(.,'Terms & Conditions')]");
		Browser.waitFortheElementXpath("//a[contains(.,'Terms & Conditions')]");
		driver.findElement(By.xpath(Elements_Home.link_privacypolicy)).click();
		Browser.scrollbyxpath("//h2[@class='page-head']");
		Browser.waitFortheElementXpath("//a[contains(.,'Terms & Conditions')]");
		String actual4 = driver.findElement(By.xpath("//h2[@class='page-head']")).getText();
		Assert.assertEquals("PRIVACY POLICY", actual4);
		reloadtohomePge();
		Browser.scrollbyxpath("//a[contains(.,'Terms & Conditions')]");
		Browser.waitFortheElementXpath("//a[contains(.,'Terms & Conditions')]");
		driver.findElement(By.xpath(Elements_Home.link_cancellationrefundpolicy)).click();
		Browser.scrollbyxpath("//h2[@class='page-head']");
		Browser.waitFortheElementXpath("//a[contains(.,'Terms & Conditions')]");
		String actual5 = driver.findElement(By.xpath("//h2[@class='page-head']")).getText();
		Assert.assertEquals("Cancellation & Refund", actual5);
		reloadtohomePge();
		
	}
	
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Elements_Home.Home_PageProperties(); // loading the Elements
		Browser= new TestUtils(driver);
		driver.get(base_url);

	}
	
	public void reloadtohomePge() //method to reload and wait until page is loaded
	{
		driver.get(base_url);
		Browser.waitFortheElementXpath("//a[contains(.,'Contact us')]");
	}
	
}

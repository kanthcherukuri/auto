package recipientsTestScripts;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import objectRepository.Elements_Home;
import objectRepository.Elements_Recipients;
import testBase.LoadPropMac;
import testBase.TestUtils;

//@Author: Sagar Sen

public class Recipient_ZOY2344_homePageLinksVerification extends LoadPropMac
{
	public TestUtils Browser;
	
	@Test(priority=1)
	public void homePageLinks() throws Exception
	{
		Browser.clickOnTheElementByXpath(Elements_Recipients.home_PracticeLogin);
		Browser.waitFortheElementXpath(Elements_Recipients.home_PracticeLogin_PagePlaceHolder);
		navigateToBase();
		Browser.clickOnTheElementByXpath(Elements_Recipients.home_customerLogin);
		Browser.waitFortheElementXpath(Elements_Recipients.home_customerLogin_PagePlaceHolder);
		navigateToBase();
		Browser.clickOnTheElementByXpath(Elements_Recipients.home_AppStoreLink);
	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    Browser.waitFortheElementXpath(Elements_Recipients.home_AppStore_Page);
	    driver.close();
	    driver.switchTo().window(tabs2.get(0));
	    Browser.clickOnTheElementByXpath(Elements_Recipients.home_androidLink);
	    ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs1.get(1));
	    Browser.waitFortheElementXpath(Elements_Recipients.home_androidLink_Page);
	    driver.close();
	    driver.switchTo().window(tabs2.get(0));
	    Thread.sleep(1000);
	   //About Us
	    Browser.ScrollDown();
	    Browser.clickOnTheElementByXpath(Elements_Recipients.home_aboutUs);
	    Browser.waitFortheElementXpath(Elements_Recipients.link_h2Header);
		String actual1 = Browser.getTextByXpath(Elements_Recipients.link_h2Header);
		Assert.assertEquals("About Us", actual1);
		//Contact Us
		Browser.ScrollDown();
		Browser.clickOnTheElementByXpath(Elements_Recipients.home_contactUs);
		Browser.waitFortheElementXpath(Elements_Recipients.link_header);
		String actual2 = Browser.getTextByXpath(Elements_Recipients.link_header);
		Assert.assertEquals("Our Location", actual2);
		//Terms
		Browser.ScrollDown();
		Browser.clickOnTheElementByXpath(Elements_Recipients.home_terms);
		Browser.waitFortheElementXpath(Elements_Recipients.link_h2Header);
		String actual3 = Browser.getTextByXpath(Elements_Recipients.link_h2Header);
		Assert.assertEquals("Terms of Use", actual3);
		//Privacy
		Browser.ScrollDown();
		Browser.clickOnTheElementByXpath(Elements_Recipients.home_privacy);
		Browser.waitFortheElementXpath(Elements_Recipients.link_h2Header);
		String actual4 = Browser.getTextByXpath(Elements_Recipients.link_h2Header);
		Assert.assertEquals("Privacy Policy", actual4);
		//Cancellation Refund
		Browser.ScrollDown();
		Browser.clickOnTheElementByXpath(Elements_Recipients.home_cancelRefund);
		Browser.waitFortheElementXpath(Elements_Recipients.link_h2Header);
		String actual5 = Browser.getTextByXpath(Elements_Recipients.link_h2Header);
		Assert.assertEquals("Cancellation / Refund Policy", actual5);
	}
	
	@DataProvider(name="placeInfo")
	public Object[][] placeName()
	{
		return new Object[][] 
		    	{
		            {"Delhi"},
		            {"Mumbai"},
		            {"Hyderabad"},
		            {"Bengaluru"},
		            {"Chennai"},
		            {"Pune"},
		            {"Ahmedabad"}
		        };
	}
	
	@Test(dataProvider="placeInfo",priority=2)
	public void doctorseoLinksFromHomePage(String place) throws InterruptedException
	{
		String home_DoctorsLink="//a[contains(., 'Doctors in "+place+"')]"; //XPATH
		Browser.ScrollDown();
		Browser.clickOnTheElementByXpath(home_DoctorsLink);
		if(driver.findElements(By.xpath("//div[@class='zy-status-wrapper']")).size()>0)
		{
			Browser.clickOnTheElementByXpath("//div[@class='zy-status-wrapper']");
		}
		String locationDisplayed=Browser.getTextByID(Elements_Recipients.indexLocationName);
		Assert.assertEquals(locationDisplayed, place);
		navigateToBase();
	}
	
	@DataProvider(name="placeInfoDC")
	public Object[][] placeNameforDC()
	{
		return new Object[][] 
		    	{
		            {"Delhi"},
		            {"Mumbai"},
		            {"Hyderabad"},
		            {"Bengaluru"},
		            {"Chennai"},
		            {"Pune"},
		            {"Ahmedabad"}
		        };
	}
	
	@Test(dataProvider="placeInfoDC",priority=3)
	public void diagnosticseoLinksFromHomePage(String place) throws InterruptedException
	{
		String home_DiagnosticLink="//a[contains(., 'Diagnostics in "+place+"')]"; //XPATH
		Browser.ScrollDown();
		Browser.clickOnTheElementByXpath(home_DiagnosticLink);
		if(driver.findElements(By.xpath("//div[@class='zy-status-wrapper']")).size()>0)
		{
			Browser.clickOnTheElementByXpath("//div[@class='zy-status-wrapper']");
		}
		String locationDisplayed=Browser.getTextByID(Elements_Recipients.indexLocationName);
		Assert.assertEquals(locationDisplayed, place);
		navigateToBase();
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Elements_Recipients.Recipients_PageProperties(); //Load page elements of recipients
		Elements_Home.Home_PageProperties(); //Load home page elements
		Browser= new TestUtils(driver);
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/");
	}
	
	@AfterClass()
	public void Exit() 
	{	
		driver.quit();
	}
	
	public void navigateToBase() throws InterruptedException
	{
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/");
		//Browser.waitTill(60);
	}
}

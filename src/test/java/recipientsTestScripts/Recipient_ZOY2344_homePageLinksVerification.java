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
	    Browser.scrollbyxpath(Elements_Recipients.home_aboutUs);
	    Browser.clickOnTheElementByXpath(Elements_Recipients.home_aboutUs);
	    Browser.waitFortheElementXpath(Elements_Recipients.link_h2Header);
		String actual1 = Browser.getTextByXpath(Elements_Recipients.link_h2Header);
		Assert.assertEquals("About Us", actual1);
		//Contact Us
		Browser.scrollbyxpath(Elements_Recipients.home_contactUs);
		Browser.clickOnTheElementByXpath(Elements_Recipients.home_contactUs);
		Browser.waitFortheElementXpath(Elements_Recipients.link_header);
		String actual2 = Browser.getTextByXpath(Elements_Recipients.link_header);
		Assert.assertEquals("Our Location", actual2);
		//Terms
		Browser.scrollbyxpath(Elements_Recipients.home_terms);
		Browser.clickOnTheElementByXpath(Elements_Recipients.home_terms);
		Browser.waitFortheElementXpath(Elements_Recipients.link_h2Header);
		String actual3 = Browser.getTextByXpath(Elements_Recipients.link_h2Header);
		Assert.assertEquals("TERMS AND CONDITIONS", actual3);
		//Privacy
		Browser.scrollbyxpath(Elements_Recipients.home_privacy);
		Browser.clickOnTheElementByXpath(Elements_Recipients.home_privacy);
		Browser.waitFortheElementXpath(Elements_Recipients.link_h2Header);
		String actual4 = Browser.getTextByXpath(Elements_Recipients.link_h2Header);
		Assert.assertEquals("PRIVACY POLICY", actual4);
		//Cancellation Refund
		Browser.scrollbyxpath(Elements_Recipients.home_cancelRefund);
		Browser.clickOnTheElementByXpath(Elements_Recipients.home_cancelRefund);
		Browser.waitFortheElementXpath(Elements_Recipients.link_h2Header);
		String actual5 = Browser.getTextByXpath(Elements_Recipients.link_h2Header);
		Assert.assertEquals("Cancellation & Refund", actual5);
	}
	
	@DataProvider(name="placeInfo")
	public Object[][] placeName()
	{
		return new Object[][] 
		    	{
		            {"Delhi"},
		            {"Mumbai"},
		            {"Hyderabad"},
		            {"Banglore"},
		            {"Chennai"},
		            {"Pune"},
		            {"Ahmedabad"}
		        };
	}
	
	@Test(dataProvider="placeInfo",priority=2)
	public void doctorseoLinksFromHomePage(String place)
	{
		String home_DoctorsLink="//a[contains(., 'Doctors in "+place+"')]"; //XPATH
		String home_DiagnosticLink="//a[contains(., 'Diagnostics in "+place+"')]"; //XPATH
		Browser.scrollbyxpath(home_DoctorsLink);
		Browser.clickOnTheElementByXpath(home_DoctorsLink);
		Browser.waitFortheID(Elements_Recipients.indexLocationName);
		String locationDisplayed=Browser.getTextByID(Elements_Recipients.indexLocationName);
		if(place.contains("Banglore"))
		{
			Assert.assertEquals(locationDisplayed, "Bengaluru");
		}
		else
		{
			Assert.assertEquals(locationDisplayed, place);
		}
//		Browser.clickOnTheElementByXpath(Elements_Recipients.indexLocationDropDown);
//		Browser.waitFortheElementXpath(Elements_Recipients.indexLocationContainer);
//		String currentLocationis=Browser.getTextByXpath(Elements_Recipients.indexCurrentLocator);
//		if(currentLocationis.equals(""))
//		{
//			System.out.println("Assert fail condition");
//			Assert.assertEquals(true, false);
//		}
//		else
//		{
//			System.out.println("Current location is available and is "+currentLocationis);
//		}
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
		            {"Banglore"},
		            {"Chennai"},
		            {"Pune"},
		            {"Ahmedabad"}
		        };
	}
	
	@Test(dataProvider="placeInfoDC",priority=3)
	public void diagnosticseoLinksFromHomePage(String place)
	{
		String home_DiagnosticLink="//a[contains(., 'Diagnostics in "+place+"')]"; //XPATH
		Browser.scrollbyxpath(home_DiagnosticLink);
		Browser.clickOnTheElementByXpath(home_DiagnosticLink);
		Browser.waitFortheID(Elements_Recipients.indexLocationName);
		String locationDisplayed=Browser.getTextByID(Elements_Recipients.indexLocationName);
		if(place.contains("Banglore"))
		{
			Assert.assertEquals(locationDisplayed, "Bengaluru");
		}
		else
		{
			Assert.assertEquals(locationDisplayed, place);
		}
//		Browser.clickOnTheElementByXpath(Elements_Recipients.indexLocationDropDown);
//		Browser.waitFortheElementXpath(Elements_Recipients.indexLocationContainer);
//		String currentLocationis=Browser.getTextByXpath(Elements_Recipients.indexCurrentLocator);
//		if(currentLocationis.equals(""))
//		{
//			System.out.println("Assert fail condition");
//			Assert.assertEquals(true, false);
//		}
//		else
//		{
//			System.out.println("Current location is available and is "+currentLocationis);
//		}
		navigateToBase();
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Elements_Recipients.Recipients_PageProperties(); //Load page elements of recipients
		Elements_Home.Home_PageProperties(); //Load home page elements
		Browser= new TestUtils(driver);
		driver.get(base_url);
	}
	
	@AfterClass()
	public void Exit() 
	{	
		driver.quit();
	}
	
	public void navigateToBase()
	{
		driver.get(base_url);
	}
}

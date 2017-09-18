package zoyloMT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_ZMTusers;
import testBase.LoadPropMac;
import testBase.TestUtils;
import testBase.ZMTPage;

//@Author: Sagar Sen

public class ZMT_contactUs_ZOY2658 extends LoadPropMac
{
	public TestUtils Browser;
	public ZMTPage zmtUserPage;
	
	@Test()
	public void zmtContactUs() throws Exception
	{
		String email1=Browser.generateRandomString(6);
		String fname="A"+email1.toLowerCase();
		zmtUserPage.contactUs_Details(fname);
		Browser.clickOnTheElementByID(Elements_ZMTusers.contactUs_submitButton);
		Browser.zmt_notification("Thank you for your interest, our customer care team will get back to you soon");
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		zmtUserPage= new ZMTPage(driver);
		Browser.openUrl("https://qa.zoylomt.com/contact-us");
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.quit();
	}
}
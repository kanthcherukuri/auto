package zoyloMT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.ArrayList;
import objectRepository.Elements_ZMTusers;
import testBase.LoadPropMac;
import testBase.TestUtils;
import testBase.ZMTPage;

//@Author: Sagar Sen

public class ZMT_homePageLinks_ZOY2659 extends LoadPropMac
{
	public TestUtils Browser;
	public ZMTPage zmtUserPage;
	
	@Test()
	public void homePageLinks() throws Exception
	{
		Browser.clickOnTheElementByID(Elements_ZMTusers.zmt_AboutUs_menuTab);
		Browser.waitFortheElementXpath(Elements_ZMTusers.zmt_AboutUsPageElement);
		Browser.openUrl("https://"+Zmt_environmentname+".com");
		Thread.sleep(1000);
		Browser.scrollbyxpath(Elements_ZMTusers.zmt_ReadMore);
		Thread.sleep(500);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_ReadMore);
		Thread.sleep(1000);
		Browser.scrollbyID(Elements_ZMTusers.zmt_login);
		Thread.sleep(500);
		Browser.waitFortheElementXpath(Elements_ZMTusers.zmt_AboutUsPageElement);
		Browser.clickOnTheElementByID(Elements_ZMTusers.zmt_serviceAndSpeciality_menuTab);
		Browser.waitFortheElementXpath(Elements_ZMTusers.zmt_servicesPage);
		Browser.scrollbyxpath(Elements_ZMTusers.zmt_ReadMoreLink);
		Thread.sleep(500);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_ReadMoreLink);
		Thread.sleep(1000);
		Browser.scrollbyxpath(Elements_ZMTusers.zmt_Readless);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_Readless);
		Thread.sleep(1000);
		Browser.scrollbyID(Elements_ZMTusers.zmt_visionAndMission_menuTab);
		Browser.clickOnTheElementByID(Elements_ZMTusers.zmt_visionAndMission_menuTab);
		Browser.waitFortheElementXpath(Elements_ZMTusers.zmt_VisionPage);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_partnerWithUs_menuTab);
		Browser.waitFortheElementXpath(Elements_ZMTusers.zmt_partnersPage);
		Thread.sleep(1000);
		Browser.scrollbyxpath(Elements_ZMTusers.zmt_partnerLinkPage);
		Thread.sleep(500);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_partnerLinkPage);
		Browser.waitFortheElementXpath(Elements_ZMTusers.zmt_SignUp_Button);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_loginForm_closeButton);
		Thread.sleep(1000);
		Browser.scrollbyID(Elements_ZMTusers.zmt_career_menuTab);
		Thread.sleep(500);
		Browser.clickOnTheElementByID(Elements_ZMTusers.zmt_career_menuTab);
		Browser.waitFortheElementXpath(Elements_ZMTusers.zmt_careerPage);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_contactUs_menuTab);
		Browser.waitFortheElementXpath(Elements_ZMTusers.zmt_contactUsPage);
		Browser.clickOnTheElementByID(Elements_ZMTusers.zmt_blog_menuTab);
		Thread.sleep(1000);
		ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs1.get(1));
		Browser.waitFortheElementXpath("//i[@class='fa fa-search']");
		driver.close();
		driver.switchTo().window(tabs1.get(0));
		Thread.sleep(1000);
		Browser.scrollbyxpath(Elements_ZMTusers.zmt_partnerWithUs_footerLink);
		Thread.sleep(500);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_partnerWithUs_footerLink);
		Browser.waitFortheElementXpath(Elements_ZMTusers.zmt_partnersPage);
		Thread.sleep(1000);
		Browser.scrollbyxpath(Elements_ZMTusers.zmt_hospital_footerLink);
		Thread.sleep(500);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_hospital_footerLink);
		Thread.sleep(1000);
		Browser.scrollbyxpath(Elements_ZMTusers.zmt_hospitalListPageHeader);
		Browser.waitFortheElementXpath(Elements_ZMTusers.zmt_hospitalListPageHeader);
		Browser.scrollbyxpath(Elements_ZMTusers.zmt_surgeon_footerLink);
		Thread.sleep(500);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_surgeon_footerLink);
		Thread.sleep(500);
		Browser.scrollbyxpath(Elements_ZMTusers.zmt_surgeonListPageHeader);
		Browser.waitFortheElementXpath(Elements_ZMTusers.zmt_surgeonListPageHeader);
		Browser.scrollbyID(Elements_ZMTusers.zmt_planUrTrip_footerLink);
		Thread.sleep(500);
		Browser.clickOnTheElementByID(Elements_ZMTusers.zmt_planUrTrip_footerLink);
		Browser.waitFortheElementXpath(Elements_ZMTusers.zmt_SignUp_Button);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_loginForm_closeButton);
		Thread.sleep(500);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_contactUs_footerLink);
		Thread.sleep(500);
		Browser.scrollbyxpath(Elements_ZMTusers.zmt_contactUsPage);
		Browser.waitFortheElementXpath(Elements_ZMTusers.zmt_contactUsPage);
		Browser.scrollbyxpath(Elements_ZMTusers.zmt_priceList_footerLink);
		Thread.sleep(500);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_priceList_footerLink);
		Thread.sleep(500);
		Browser.scrollbyxpath(Elements_ZMTusers.zmt_priceListPage);
		Browser.waitFortheElementXpath(Elements_ZMTusers.zmt_priceListPage);
		Browser.scrollbyxpath(Elements_ZMTusers.zmt_facebook_footerLink);
		Thread.sleep(500);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_facebook_footerLink);
		Thread.sleep(1000);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Browser.waitFortheID(Elements_ZMTusers.zmt_facebookPage);
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		Thread.sleep(500);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_googlePlus_footerLink);
		Thread.sleep(1000);
		ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs3.get(1));
		Browser.waitFortheElementXpath("(//div[contains(., 'Zoylo Medical Tourism')])[7]");
		driver.close();
		driver.switchTo().window(tabs3.get(0));
		Thread.sleep(500);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_twitter_footerLink);
		Thread.sleep(1000);
		ArrayList<String> tabs4 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs4.get(1));
		Browser.waitFortheElementXpath("(//img[@alt='Zoylo MedicalTourism'])[1]");
		driver.close();
		driver.switchTo().window(tabs4.get(0));
		Thread.sleep(500);
		Browser.openUrl("https://"+Zmt_environmentname+".com");
		Browser.scrollbyxpath(Elements_ZMTusers.zmt_viewAllSpecialitiesButton);
		Thread.sleep(500);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_viewAllSpecialitiesButton);
		Browser.waitFortheElementXpath(Elements_ZMTusers.zmt_sepcialityPopUp);
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		zmtUserPage= new ZMTPage(driver);
		Browser.openUrl("https://"+Zmt_environmentname+".com");
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.quit();
	}
}
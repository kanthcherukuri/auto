package zoyloMT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import objectRepository.Elements_ZMTusers;
import testBase.LoadPropMac;
import testBase.TestUtils;
import testBase.ZMTPage;

//@Author: Sagar Sen

public class ZMT_Surgeon_submit_Enquiry_GetEstimate_ZOY2666 extends LoadPropMac
{
	public TestUtils Browser;
	public ZMTPage zmtUserPage;
	public String name="Guru";
	public String email="gurucharan.a@zoylo.com";
	public String qury="This is my qury to submit.";
	
	@Test(priority=1)
	public void surgeons_searchList_submitEnquiry_GetEstimate() throws Exception
	{
		Browser.openUrl("https://"+Zmt_environmentname+".com");
		Browser.clickOnTheElementByID(Elements_ZMTusers.zmt_SearchButton);
		Browser.waitFortheElementXpath(Elements_ZMTusers.zmt_surgeonsListCount_searchList);
		//SUBMIT ENQ
		if(driver.findElements(By.xpath(Elements_ZMTusers.zmt_surgeonsListCount_searchList)).size()!=0)
		{
			Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_submitEngquiryButton);
			zmtUserPage.surgeon_submitEnquiry_Details(name, email, qury);
		}
		else{
			System.out.println("There are no surgeons.");
		}
		Browser.zmt_notification("We will get back to you soon");
		//GET ESTIMATE
		driver.navigate().refresh();
		Browser.waitFortheElementXpath(Elements_ZMTusers.zmt_surgeonsListCount_searchList);
		if(driver.findElements(By.xpath(Elements_ZMTusers.zmt_surgeonsListCount_searchList)).size()!=0)
		{
			Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_getEstimateButton);
			zmtUserPage.surgeon_submitEnquiry_Details(name, email, qury);
		}
		else{
			System.out.println("There are no surgeons.");
		}
		Browser.zmt_notification("We will get back to you soon");
	}
	
	@Test(priority=2)
	public void surgeons_ListOfSurgeons_submitEnquiry_GetEstimate() throws Exception
	{
		Browser.openUrl("https://"+Zmt_environmentname+".com/list-of-surgeons");
		Browser.waitFortheElementXpath(Elements_ZMTusers.zmt_surgeonsListCount_listOfSurgeons);
		//SUBMIT ENQ
		if(driver.findElements(By.xpath(Elements_ZMTusers.zmt_surgeonsListCount_listOfSurgeons)).size()!=0)
		{
			Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_submitEngquiryButton);
			zmtUserPage.surgeon_submitEnquiry_Details(name, email, qury);
		}
		else{
			System.out.println("There are no surgeons.");
		}
		Browser.zmt_notification("We will get back to you soon");
		//GET ESTIMATE
		driver.navigate().refresh();
		Browser.waitFortheElementXpath(Elements_ZMTusers.zmt_surgeonsListCount_listOfSurgeons);
		if(driver.findElements(By.xpath(Elements_ZMTusers.zmt_surgeonsListCount_listOfSurgeons)).size()!=0)
		{
			Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_getEstimateButton);
			zmtUserPage.surgeon_submitEnquiry_Details(name, email, qury);
		}
		else{
			System.out.println("There are no surgeons.");
		}
		Browser.zmt_notification("We will get back to you soon");
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		zmtUserPage= new ZMTPage(driver);
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.quit();
	}
}
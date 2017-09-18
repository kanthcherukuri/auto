
//Author:Ch.LakshmiKanth

package zoyloMT;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.LoadPropMac;
import testBase.TestUtils;
import testBase.ZMTPage;

public class ZMT_Careers_ZOY2660 extends LoadPropMac
{
	public TestUtils Browser;
	public ZMTPage zmtUserPage;
	
		@BeforeClass
		public void Browser() throws Exception {
			
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		zmtUserPage= new ZMTPage(driver);
		Browser.openUrl("https://qa.zoylomt.com");
		Browser.clickOnTheElementByXpath("//li[@id='careersMenuLabel']/a");
		
	}
	
	@Test
	public void CheckCareersPage() throws Exception {
		zmtUserPage.Details_Careers("LakshmiKanth", "10", "5", "Cognizant", "Senior", "500000");
		Browser.zmt_notification("Your profile is sumbitted successfully");
		
	}
	
	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}

}

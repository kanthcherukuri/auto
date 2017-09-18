package zoyloMT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testBase.LoadPropMac;
import testBase.TestUtils;
import testBase.ZMTPage;

//@Author: Sagar Sen

public class ZMT_homePageLinks_ZOY2659 extends LoadPropMac
{
	public TestUtils Browser;
	public ZMTPage zmtUserPage;
	
	@Test()
	public void homePageLinks()
	{
		
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		zmtUserPage= new ZMTPage(driver);
		Browser.openUrl("https://qa.zoylomt.com");
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.quit();
	}
}
package zoyloMT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testBase.LoadPropMac;
import testBase.TestUtils;
import testBase.ZMTPage;

//@Author: Sagar Sen

public class ZMT_SignUp_ZOY_2657 extends LoadPropMac
{
	public TestUtils Browser;
	public ZMTPage zmtUserPage;
	
	@DataProvider(name="zmt")
	public Object[][] clinicDocInfo() throws Exception
	{
		Object[][] clinicDocInformation=TestUtils.getTableArray("TestData/zmt.xls", "users", "ZMT2657");
		return(clinicDocInformation);
	}
	
	@Test(dataProvider="zmt")
	public void zmtSignUp(String functionalArea, String Country, String State, String address) throws Exception
	{
		Boolean removeFromDB=true;
		String email1=Browser.generateRandomString(6);
		String fname="A"+email1.toLowerCase();
		String lname=email1;
		String phnum="9"+Browser.generateRandomNumber(9);
		String emailID=email1.toLowerCase()+"@zmt.com";
		
		zmtUserPage.click_Login();
		zmtUserPage.click_SignUp();
		zmtUserPage.Details_SignUpForm(fname, lname, emailID, Country, State, phnum, functionalArea, address);
		zmtUserPage.click_SignUpButton();
		Browser.zmt_notification("user created successfully");
		driver.navigate().refresh();
		
		if(removeFromDB==true)
		{
			System.out.println("EmailID retrived is: "+emailID);
			Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "zmtusers", "email", emailID);
		}
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
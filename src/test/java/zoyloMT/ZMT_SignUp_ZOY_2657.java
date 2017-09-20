package zoyloMT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import objectRepository.Elements_ZMTusers;
import testBase.LoadPropMac;
import testBase.TestUtils;
import testBase.ZMTPage;

//@Author: Sagar Sen

public class ZMT_SignUp_ZOY_2657 extends LoadPropMac
{
	public TestUtils Browser;
	public ZMTPage zmtUserPage;
	public String password="Zmt@123";
	public String confirmPassword="Zmt@123";
	
	@DataProvider(name="zmt")
	public Object[][] clinicDocInfo() throws Exception
	{
		Object[][] clinicDocInformation=TestUtils.getTableArray("TestData/zmt.xls", "users", "ZMT2657");
		return(clinicDocInformation);
	}
	
	@Test(dataProvider="zmt")
	public void zmtSignUp(String functionalArea, String Country, String State, String password, String confirmPassword, String address) throws Exception
	{
		Boolean removeFromDB=true;
		String email1=Browser.generateRandomString(6);
		String fname="A"+email1.toLowerCase();
		String lname=email1;
		String phnum="9"+Browser.generateRandomNumber(9);
		String emailID=email1.toLowerCase()+"@zmt.com";
		
		Browser.clickOnTheElementByID(Elements_ZMTusers.zmt_login);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_SignUp_Button);
		zmtUserPage.SignUpForm_Details(fname, lname, emailID, Country, State, password, confirmPassword, phnum, functionalArea, address);
		Browser.clickOnTheElementByID(Elements_ZMTusers.signUp_submit);
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
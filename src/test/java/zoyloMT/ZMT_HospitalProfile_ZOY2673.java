package zoyloMT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import objectRepository.Elements_ZMTusers;
import testBase.LoadPropMac;
import testBase.TestUtils;
import testBase.ZMTPage;

//@Author: Sagar Sen

public class ZMT_HospitalProfile_ZOY2673 extends LoadPropMac
{
	public TestUtils Browser;
	public ZMTPage zmtUserPage;
	public String password="Zmt@123";
	public String confirmPassword="Zmt@123";
	public Boolean removeFromDB=true;
	public String fname="Hospital";
	public String lname="Profile";
	public String emailID="hospitalprofile@zmt.com";
	public String Country="India";
	public String State="Hyderabad";
	public String address="Hospital address at Hyderabad";
	
	@Test(priority=1)
	public void surgeonSignUp() throws Exception
	{
		String phnum="9"+Browser.generateRandomNumber(9);
		Browser.clickOnTheElementByID(Elements_ZMTusers.zmt_login);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_SignUp_Button);
		zmtUserPage.SignUpForm_Details(fname, lname, emailID, Country, State, password, confirmPassword, phnum, "Hospital", address);
		Browser.clickOnTheElementByID(Elements_ZMTusers.signUp_submit);
		Browser.zmt_notification("user created successfully");
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
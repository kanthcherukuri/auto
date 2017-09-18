package testBase;
import org.openqa.selenium.WebDriver;
import objectRepository.Elements_ZMTusers;

public class ZMTPage extends LoadPropMac
{
	public WebDriver driver;
	public TestUtils Browser;
	
	public ZMTPage(WebDriver driver) throws Exception
	{
		this.driver=driver;
		Browser=new TestUtils(driver);
		Elements_ZMTusers.zmt_UsersPageProperties();
	}
	
	/*
	 * @Author: Sagar Sen
	 * @Desc: This method is used to enter signup details on signUp form.
	 * @Parms: fname, lname, email, country, state, phnum, functionalArea, address
	 * @Return: NA
	 */
	public void SignUpForm_Details(String fname, String lname, String email, String country, String state, String phnum, String functionalArea, String address)
	{
		Browser.enterTextByID(Elements_ZMTusers.signUp_FirstName, fname);
		Browser.enterTextByID(Elements_ZMTusers.signUp_LastName, lname);
		Browser.enterTextByID(Elements_ZMTusers.signUp_email, email);
		Browser.selectbyID(Elements_ZMTusers.signUp_country, country);
		Browser.selectbyID(Elements_ZMTusers.signUp_state, state);
		Browser.enterTextByID(Elements_ZMTusers.signUp_password, "Zmt@123");
		Browser.enterTextByID(Elements_ZMTusers.signUp_confirmPassword, "Zmt@123");
		Browser.enterTextByID(Elements_ZMTusers.signUp_mobileNumber, phnum);
		Browser.selectbyID(Elements_ZMTusers.signUp_functionalArea, functionalArea);
		Browser.enterTextByID(Elements_ZMTusers.signUp_address, address);
	}
	
	/*
	 * @Author: Sagar Sen
	 * @Desc: This method is used to enter contact details on contactus form.
	 * @Parms: 
	 * @Return: NA
	 */
	public void contactUs_Details(String name)
	{
		Browser.enterTextByID(Elements_ZMTusers.contactUs_name, name);
		Browser.selectbyID(Elements_ZMTusers.contactUs_gender, "Male");
		Browser.enterTextByID(Elements_ZMTusers.contactUs_age, "25");
		Browser.selectbyID(Elements_ZMTusers.contactUs_country, "India");
		Browser.selectbyID(Elements_ZMTusers.contactUs_state, "Hyderabad");
		Browser.enterTextByID(Elements_ZMTusers.contactUs_email, "gurucharan.a@zoylo.com");
		Browser.enterTextByID(Elements_ZMTusers.contactUs_phone, "9999999999");
		Browser.enterTextByID(Elements_ZMTusers.contactUs_message, "Contactus message");
	}
}
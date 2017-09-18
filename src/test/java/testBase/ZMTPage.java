package testBase;
import org.openqa.selenium.By;
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
	 * @Desc: This method is used to click login button on home page.
	 * @Parms: NA
	 * @Return: NA
	 */
	public void click_Login()
	{
		Browser.clickOnTheElementByID(Elements_ZMTusers.zmt_login);
	}
	
	/*
	 * @Author: Sagar Sen
	 * @Desc: This method is used to click signup hyperlink on home page login popup.
	 * @Parms: NA
	 * @Return: NA
	 */
	public void click_SignUp()
	{
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_SignUp_Button);
	}
	
	/*
	 * @Author: Sagar Sen
	 * @Desc: This method is used to enter signup details on signUp form.
	 * @Parms: fname, lname, email, country, state, phnum, functionalArea, address
	 * @Return: NA
	 */
	public void Details_SignUpForm(String fname, String lname, String email, String country, String state, String phnum, String functionalArea, String address)
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
	 * @Desc: This method is used to click signup submit button on signup popup.
	 * @Parms: NA
	 * @Return: NA
	 */
	public void click_SignUpButton()
	{
		Browser.clickOnTheElementByID(Elements_ZMTusers.signUp_submit);
	}
	
	/*
	 * @Author: Sagar Sen
	 * @Desc: This method is used to enter contact details on contactus form.
	 * @Parms: 
	 * @Return: NA
	 */
	public void Details_contactUs(String name)
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
	
	/*
	 * @Author: Sagar Sen
	 * @Desc: This method is used to click contactus submit button on contactus page.
	 * @Parms: NA
	 * @Return: NA
	 */
	public void click_contactUsSubmitButton()
	{
		Browser.clickOnTheElementByID(Elements_ZMTusers.contactUs_submitButton);
	}
	
	/*
	 * @Author: Ch.LakshmiKanth
	 * @Desc: This method is used to Submit Your Profile In Careers .
	 * @Parms: NA
	 * @Return: NA
	 */
	public void Details_Careers(String fullname,String expinyears,String expinmonths,String currentemployee,String applyingfor,String currentctc) {
		
		String emailone=Browser.generateEmail(20); 
		String mobile="9"+Browser.generateRandomNumber(9);
		
		
		Browser.enterTextByID(Elements_ZMTusers.careers_fullname, fullname);
		Browser.enterTextByID(Elements_ZMTusers.careers_email,emailone);
		Browser.enterTextByID(Elements_ZMTusers.careers_mobile, mobile);
		Browser.enterTextByID(Elements_ZMTusers.careers_yearsofexperience, expinyears);
		Browser.enterTextByID(Elements_ZMTusers.careers_monthsofexperirnce, expinmonths);
		Browser.enterTextByID(Elements_ZMTusers.careers_currentemployee, currentemployee);
		Browser.enterTextByID(Elements_ZMTusers.careers_applyingfor, applyingfor);
		Browser.enterTextByID(Elements_ZMTusers.careers_currentctc, currentctc);
		driver.findElement(By.id(Elements_ZMTusers.careers_upload)).sendKeys(System.getProperty("user.dir")+"/Uploads/scroll.pdf");
		Browser.clickOnTheElementByID(Elements_ZMTusers.careers_submit);
	}
	
}
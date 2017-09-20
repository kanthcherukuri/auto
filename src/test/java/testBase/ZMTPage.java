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
	 * @Desc: This method is used to enter signup details on signUp form.
	 * @Parms: fname, lname, email, country, state, phnum, functionalArea, address
	 * @Return: NA
	 */
	public void SignUpForm_Details(String fname, String lname, String email, String country, String state, String password, String confirmPassword, String phnum, String functionalArea, String address)
	{
		Browser.enterTextByID(Elements_ZMTusers.signUp_FirstName, fname);
		Browser.enterTextByID(Elements_ZMTusers.signUp_LastName, lname);
		Browser.enterTextByID(Elements_ZMTusers.signUp_email, email);
		Browser.selectbyID(Elements_ZMTusers.signUp_country, country);
		Browser.selectbyID(Elements_ZMTusers.signUp_state, state);
		Browser.enterTextByID(Elements_ZMTusers.signUp_password, password);
		Browser.enterTextByID(Elements_ZMTusers.signUp_confirmPassword, confirmPassword);
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
	public void contactUs_Details(String name, String gender, String age, String country, String city, String email, String number, String message)
	{
		Browser.enterTextByID(Elements_ZMTusers.contactUs_name, name);
		Browser.selectbyID(Elements_ZMTusers.contactUs_gender, gender);
		Browser.enterTextByID(Elements_ZMTusers.contactUs_age, age);
		Browser.selectbyID(Elements_ZMTusers.contactUs_country, country);
		Browser.selectbyID(Elements_ZMTusers.contactUs_state, city);
		Browser.enterTextByID(Elements_ZMTusers.contactUs_email, email);
		Browser.enterTextByID(Elements_ZMTusers.contactUs_phone, number);
		Browser.enterTextByID(Elements_ZMTusers.contactUs_message, message);
	}
	
	/*
	 * @Author: Sagar Sen
	 * @Desc: This method is used to click either options on profile drop down.
	 * @Parms: NA
	 * @Return: NA
	 */
	public void zmt_Logout()
	{
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmtuserProfileButton);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_LogoutDropDown);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_confirmLogout);
	}
	
	/*
	 * @Author: Sagar Sen
	 * @Desc: This method is used to click submit enquiry button and fill the details.
	 * @Parms: name, email, qury
	 * @Return: NA
	 */
	public void surgeon_submitEnquiry_Details(String name, String email, String qury) throws Exception
	{
		Browser.enterTextByID(Elements_ZMTusers.zmt_enquireFirstName, name);
		Browser.enterTextByID(Elements_ZMTusers.zmt_enquiryEmail, email);
		Browser.enterTextByID(Elements_ZMTusers.zmt_enquiryQury, qury);
		Thread.sleep(500);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_submitEnquiry);
	}
	
	/*
	 * @Author: Ch.LakshmiKanth
	 * @Desc: This method is used to Submit Your Profile In Careers .
	 * @Parms: NA
	 * @Return: NA
	 */
	public void Details_Careers(String fullname,String expinyears,String expinmonths,String currentemployee,String applyingfor,String currentctc) {
		
		String emailone="kanth"+Browser.randomalphabets()+"@gmail.com" ;
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
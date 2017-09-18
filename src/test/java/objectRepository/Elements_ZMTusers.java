package objectRepository;
import org.openqa.selenium.WebDriver;
import testBase.LoadPropMac;

public class Elements_ZMTusers extends LoadPropMac
{
	public static WebDriver driver;
	
	public static String zmt_login, zmt_SignUp_Button, zmt_AboutUs_menu;
	public static String signUp_FirstName, signUp_LastName, signUp_email, signUp_country, signUp_state, signUp_password, signUp_confirmPassword, signUp_mobileNumber, signUp_functionalArea, signUp_address, signUp_submit;
	public static String contactUs_name, contactUs_gender, contactUs_age, contactUs_country, contactUs_state, contactUs_email, contactUs_phone, contactUs_message, contactUs_submitButton;
	
	public static WebDriver zmt_UsersPageProperties()
	{
		//Home page
		zmt_login="loginFormData"; //ID
		zmt_SignUp_Button="//a[@class='signupButton']"; //XPATH
		zmt_AboutUs_menu="aboutUsMenuLabel"; //ID
		
		//SignUP form
		signUp_FirstName="signUpFirstName"; //ID
		signUp_LastName="signUpLastName"; //ID
		signUp_email="signUpEmail"; //ID
		signUp_country="signUpCountry"; //ID
		signUp_state="signUpCity"; //ID
		signUp_password="signUpPassword";
		signUp_confirmPassword="signUpConfirmPassword"; //ID
		signUp_mobileNumber="signUpPhone"; //ID
		signUp_functionalArea="signUpFunctional"; //ID
		signUp_address="signUpAddress"; //ID
		signUp_submit="signUpFormSubmit"; //ID
		
		//Contact Us
		contactUs_name="contactUsName"; //ID
		contactUs_gender="contactUsGender"; //ID
		contactUs_age="contactUsAge"; //ID
		contactUs_country="searchCountry"; //ID
		contactUs_state="searchCity"; //ID
		contactUs_email="contactUsEmail"; //ID
		contactUs_phone="contactUsPhone"; //ID
		contactUs_message="contactUsMessage"; //ID
		contactUs_submitButton="contactUsSubmit"; //ID
		
		return driver;
	}
}

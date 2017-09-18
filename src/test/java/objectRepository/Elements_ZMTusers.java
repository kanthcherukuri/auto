package objectRepository;
import org.openqa.selenium.WebDriver;
import testBase.LoadPropMac;

public class Elements_ZMTusers extends LoadPropMac
{
	public static WebDriver driver;
	
	public static String zmt_login, zmt_SignUp_Button, zmt_AboutUs_menuTab, zmt_serviceAndSpeciality_menuTab, zmt_visionAndMission_menuTab, zmt_partnerWithUs_menuTab, zmt_career_menuTab, zmt_contactUs_menuTab, zmt_blog_menuTab, zmt_partnerWithUs_footerLink, zmt_hospital_footerLink, zmt_surgeon_footerLink, zmt_planUrTrip_footerLink, zmt_contactUs_footerLink, zmt_priceList_footerLink, zmt_facebook_footerLink, zmt_googlePlus_footerLink, zmt_twitter_footerLink, zmt_readMoreOnHomePage, zmt_viewAllSpecialitiesButton;
	public static String signUp_FirstName, signUp_LastName, signUp_email, signUp_country, signUp_state, signUp_password, signUp_confirmPassword, signUp_mobileNumber, signUp_functionalArea, signUp_address, signUp_submit;
	public static String contactUs_name, contactUs_gender, contactUs_age, contactUs_country, contactUs_state, contactUs_email, contactUs_phone, contactUs_message, contactUs_submitButton;
	public static String careers_fullname,careers_email,careers_mobile,careers_yearsofexperience,careers_monthsofexperirnce,careers_currentemployee,
	careers_applyingfor, careers_currentctc,careers_upload,careers_submit;
	public static WebDriver zmt_UsersPageProperties()
	{
		//Home page
		zmt_login="loginFormData"; //ID
		zmt_SignUp_Button="//a[@class='signupButton']"; //XPATH
		zmt_AboutUs_menuTab="aboutUsMenuLabel"; //ID
		zmt_serviceAndSpeciality_menuTab="servicesSpecialitiesMenuLabel"; //ID
		zmt_visionAndMission_menuTab="visionMissionMenuLabel"; //ID
		zmt_partnerWithUs_menuTab="(.//*[@id='partnerWithUsMenuLabel']/a)[1]"; //XPATH
		zmt_career_menuTab="careersMenuLabel"; //ID
		zmt_contactUs_menuTab="(.//*[@id='contactUsMenuLabel']/a)[1]"; //XPATH
		zmt_blog_menuTab="blogMenuLabel"; //ID
		zmt_partnerWithUs_footerLink="(.//*[@id='partnerWithUsMenuLabel']/a)[2]"; //XPATH
		zmt_hospital_footerLink="//a[@href='/hospitalsList']"; //XPATH
		zmt_surgeon_footerLink="//a[@href='/surgeonsList']"; //XPATH
		zmt_planUrTrip_footerLink="planYourTripMenuLabel"; //XPATH
		zmt_contactUs_footerLink="(.//*[@id='contactUsMenuLabel']/a)[2]"; //XPATH
		zmt_priceList_footerLink="//a[@href='/priseComparisionList']"; //XPATH
		zmt_facebook_footerLink="//i[@class='fa fa-facebook']"; //XPATH
		zmt_googlePlus_footerLink="//i[@class='fa fa-google-plus']"; //XPATH
		zmt_twitter_footerLink="//i[@class='fa fa-twitter']"; //XPATH
		zmt_readMoreOnHomePage="//a[@href='/about-us']"; //XPATH
		zmt_viewAllSpecialitiesButton="//a[@data-target='#servicesSpecialities']"; //XPATH
		
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
		
		
		//Careers
		careers_fullname="fullName";
		careers_email="username";
		careers_mobile="mobileNumber";
		careers_yearsofexperience="experienceInYears";
		careers_monthsofexperirnce="experienceInMonths";
		careers_currentemployee="applyNowDefaultCurrEmployer";
		careers_applyingfor="applyNowDefaultFor";
		careers_currentctc="applyNowDefaultCtc";
		careers_upload="cvUpload";
		careers_submit="submitProfile";
		
		return driver;
	}
}

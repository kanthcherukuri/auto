package objectRepository;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class Elements_Recipients  {
	
	public static Properties prop = new Properties();
	public static FileInputStream inStream;

	 public static String recipient_DoctorClusters, Recipient_UserName,Recipient_Password,Recipient_Button_Login,Default_Slot,link_myAccountheaderIcon,link_aboutHeaderIndex,link_contactUsIndex,link_termsIndex,link_h2Header,link_header,link_privacyIndex,link_cancellationIndex,link_signinIndex;
	
	 public static String dcNameHolder, dcHomePickUp, recipient_firstHomeAddress, dcHomeVisitAddressProceed, dcHometestTab, dcHomePkgTab, hWorkingTab, Recipient_MyAccountTab, Recipient_ProfilePicture, Recipient_ProfilePopUp, Recipient_ProfileUploadInputID, Recipient_ProfileRemoveBtn, Recipient_ProfileGetSrc;
	 public static WebDriver driver;
	 
	 public static By enrollment1_h5 = By.xpath("//h5");// Another way of initialization to avoid xpath/id by defining in test case
	public static String selectFirstDoctorFromListingPage, selectFirstDoctorBookBtnFromListingPage, mapListingIcon,Recipient_Wrapper;
	public static String addressAssertion, getDirectionLink, distanceValue, backBtn, getDistanceFromListingForFirstDoctor, doctorNameOnProfile, doctor_ProfileAminities, doctor_ProfileSchedule, doctor_ProfilePlusMore, doctor_ProfileOtherClinicDropDown, doctor_ProfileClinicName;
	public static String bookAptHeader,paymentPageHeader,cancelPaymentPage, bookAptPageDate, bookAptPageFee, makePaymentBtn, indexHeaderUserIcon;
	
	//Home page elements
	public static String home_PracticeLogin, home_PracticeLogin_PagePlaceHolder, home_customerLogin, home_customerLogin_PagePlaceHolder, home_AppStoreLink, home_AppStore_Page, home_androidLink, home_androidLink_Page;
	public static String home_aboutUs, home_contactUs, home_terms, home_privacy, home_cancelRefund;
	public static String indexLocationName, indexLocationDropDown, indexCurrentLocator, indexLocationContainer;
	public static String dcNameOnProfilePage, dcBookAptPageHeader, dcNameOnThankYouPage, thankYouPageLogo, recipient_DocProfile_About, recipient_DCProfileAbout;
	public static String recipient_DCProfileABoutText, recipient_DCProfileRegNum, recipient_DCEstablishedYear, recipient_DCLanguage, recipient_DCPayment;
	public static String recipient_DCAwardsTab, recipient_DCAwardsContent, recipient_DCTestCost, recipient_DCPackageCost, recipient_DCPackageTab, recipient_DCTestTab, recipient_DCPackageCostOnBookPay, recipient_DCTestCostOnBookPay, recipient_DCTotalCost, recipient_DCPackageQnty, recipient_DCPackageUp, recipient_DCTestUp, recipient_DCTestQnty, recipient_DCPackageDown, recipient_DCtestDown, recipient_DCHereOnPayment, recipient_DCTestPkgHeaderOnPayment, recipient_DCPackageQntyOnPayment, recipient_DCtestQntyOnPayment, recipient_DCpkgCostOnPayment, recipient_DCtestCostOnPayment, recipient_DCTotalCostOnPayment, recipient_DCThankYouPagePKGQnty, recipient_DCThankYouPageTestQnty, recipient_DCTotalOnThankYouPage, recipient_DoctorListProfilePic, recipient_DCListProfilePic, recipient_docProfilePageImg, recipient_dcProfilePageImg;
	
	//Don't have an account page
	public static String recipient_signUp, recipient_signUpFullName, recipient_signUpMobileNumber, recipient_signUpBtn, recipient_OtpText, recipient_VerifyOtp, recipient_thankYouSignUpName;
	
	public static WebDriver Recipients_PageProperties()throws Exception{
	   // FileInputStream inStream;
		/*
        inStream = new FileInputStream(new File("PageLocators\\DoctorsPageLocators.txt"));     
        prop.load(inStream);  
        inStream = new FileInputStream(new File("PageLocators\\MapPageLocators.txt")); 
         prop.load(inStream);
        */
		
		//Don't have an account
		recipient_signUp="//a[@href='/signup']"; //XPAtH
		recipient_signUpFullName="fullName"; //ID
		//Recipient_UserName
		recipient_signUpMobileNumber="mobileNumber"; //ID
		//Recipient_Password
		recipient_signUpBtn="test"; //ID
		recipient_OtpText="entered-otp"; //ID
		recipient_VerifyOtp="verify-otp-btn"; //ID
		recipient_thankYouSignUpName="//div[@class='col-md-12 col-sm-12 col-xs-12 signup-txtwrap']//h4"; //XPATH
		
		recipient_DoctorClusters="//div[@class='pin bounce ']"; //XPATH
		recipient_DoctorListProfilePic="//span[@class='imgHolder']//img"; //XPATH
		recipient_DCListProfilePic="//img[@class='diagno-defaultimg zy-diagno-image-53px']"; //XPATH
		recipient_docProfilePageImg="//img[@class='zy-provider-image-53px']"; //XPATH
		recipient_dcProfilePageImg="//img[@class='zy-rec-diag-m-image-53px']"; //XPATH
		thankYouPageLogo="//a[@class='desktop-logo']"; //XPATH
		dcNameOnThankYouPage="(//div[@class='book-dtbox']//h3)[2]"; //XPATH
		dcNameOnProfilePage="//span[@class='zy-rec-diag-m-d-name']"; //XPATH
		dcBookAptPageHeader="//h1[contains(., 'Book Diagnostic Lab Test')]"; //XPATH
		//Index
		indexLocationName="zy-location-right"; //ID
		indexLocationDropDown="(.//*[@id='zy-location-right']/span)[2]"; //XPATH
		indexLocationContainer="//span[@class='autodetcarea']"; //XPATH
		indexCurrentLocator="//span[@class='autodetc-location']"; //XPATH
		
		//HOME PAGE
		home_PracticeLogin="//a[@href='/doctorsignin']"; //XPATH
		home_PracticeLogin_PagePlaceHolder="//input[@placeholder='Zoylo Id']"; //XPATH
		home_customerLogin="//a[@href='/login']"; //XPATH
		home_customerLogin_PagePlaceHolder="//input[@placeholder='Email']"; //XPATH
		home_AppStoreLink="//a[@href='http://m.onelink.me/34dfbfec']"; //XPATH
		home_AppStore_Page="//img[@alt='iTunes']"; //XPATH
		home_androidLink="//a[@href='http://m.onelink.me/7a85373']"; //XPATH
		home_androidLink_Page="//span[@class='gb_Xa gb_Wa']"; //XPATH
		home_aboutUs="//a[@href='/aboutus']"; //XPATH
		home_contactUs="//a[@href='contactus']"; //XPATH
		home_terms="//a[@href='/terms']"; //XPATH
		home_privacy="//a[@href='/privacy']"; //XPATH
		home_cancelRefund="//a[@href='/cancellationRefundPolicy']"; //XPATH
		
	    //Recipient Login Page
		indexHeaderUserIcon="//img[@class='indexProfileImg userImgBackground']"; //XPATH
		makePaymentBtn="proceed"; //ID
		bookAptPageFee="providerFees"; //ID
		bookAptPageDate="//div[@class='d-y-t']"; //XPATH
		cancelPaymentPage="cancel"; //ID
		paymentPageHeader="//h4[contains(.,'Review Your Appointment Details')]"; //XPATH
		bookAptHeader="//h1[contains(., 'Book Appointment')]"; //XPATH
		doctorNameOnProfile="//h1[@class='tr-override-dctr-content-h1']"; //XPATH
		doctor_ProfileAminities="amenities";
		doctor_ProfileSchedule="bookapp";
		doctor_ProfilePlusMore="manage-flip";
		doctor_ProfileOtherClinicDropDown="(//a[@data-type='other-clinics'])[1]";
		doctor_ProfileClinicName="//h2[@class='addr-ClinicName']";
		mapListingIcon="mapIconMenu"; //ID
		getDistanceFromListingForFirstDoctor="(//div[@class='dctr-exprnce']//span[2])[1]"; //XPATH
		backBtn="backArrow"; //ID
		distanceValue="(//span[@class='zy-ad-leftContent'])[1]"; //XPATH
		getDirectionLink="default_clini_get"; //ID
		addressAssertion="//span[@class='docinfo-address-label']"; //XPATH
         selectFirstDoctorFromListingPage="(.//*[@id='serviceProvider']//h1)[1]"; //XPATH
         selectFirstDoctorBookBtnFromListingPage="(//button[contains(., 'Book')])[1]"; //XPATH
         Recipient_UserName="emailAddress";
         Recipient_Password="password";
         Recipient_Button_Login="//button[text()='Login']";
         Recipient_Wrapper="div.zy-status-wrapper";
         Default_Slot="(//*[@id='apponitmentTime' and @class='sp-available-slots'])[1]";
         link_myAccountheaderIcon="//img[@class='indexProfileImg']";
         link_aboutHeaderIndex="//a[@href='/zyAboutUs']";
         link_contactUsIndex="//a[@href='/zyContactUs']";
         link_termsIndex="//a[@href='/zyTermsConditions']";
         link_h2Header="//h2[@class='page-head']";
         link_header="//h2";
         link_privacyIndex="//a[@href='/zyPrivacyPolicy']";
         link_cancellationIndex="//a[@href='/zyRefundPolicy']";
         link_signinIndex="myAccountLink";
         dcNameHolder="//span[@class='zy-rec-diag-m-d-name']";
         dcHomePickUp="home_pickup";
         recipient_firstHomeAddress="(//div[@class='zy-rec-diag-hm-add-radio']//input[@name='address'])[1]";
         dcHomeVisitAddressProceed="//div[@class='zy-rec-diag-add-confirm-btn']//span";
         dcHometestTab="h_Test_li";
         dcHomePkgTab="h_Package_li";
         hWorkingTab="h_WorkTimings_li";
         Recipient_MyAccountTab="myaccount"; //ID
         Recipient_ProfilePicture="//span[@class='user-imgHolder']"; //XPATH
         Recipient_ProfilePopUp="//div[@class='acc-upload-remove-img']"; //XPATH
         Recipient_ProfileUploadInputID="profileImage";
         Recipient_ProfileRemoveBtn="//li[@class='acc-pic-hide modalList']";
         Recipient_ProfileGetSrc="//span[@class='user-imgHolder']//img"; //XPATH
         
         //Doc profile page
         recipient_DocProfile_About="about-doc";
         recipient_DCProfileAbout="//a[@href='#about']"; //XPATH
         recipient_DCProfileABoutText="(//div[@class='zy-rec-hosp-lbl'])[2]"; //XPATH
         recipient_DCProfileRegNum="(//div[@class='zy-rec-hosp-lbl'])[4]"; //XPATH
         recipient_DCEstablishedYear="(//div[@class='zy-rec-hosp-lbl'])[6]"; //XPATH
         recipient_DCLanguage="(//div[@class='zy-rec-hosp-lbl'])[8]"; //XPATH
         recipient_DCPayment="//span[@class='zy-rec-diag-pay-options']"; //XPATH
         recipient_DCAwardsTab="//a[@href='#awards']"; //XPATH
         recipient_DCAwardsContent="//div[@class='zy-rec-diag-awards-right-info']"; //XPATH
         recipient_DCTestCost="(//span[@class='zy-sp-diag-s-pkg-cost-icon zy-diag-prcAlign'])[1]"; //XPATH
         recipient_DCPackageCost="(//span[@class='zy-sp-diag-s-pkg-cost-icon zy-diag-prcAlign'])[3]"; //XPATH
         recipient_DCPackageTab="//*[@id='package-li']/a"; //XPATH
         recipient_DCTestTab="//*[@id='test-li']/a"; //XPATH
         recipient_DCPackageCostOnBookPay="(.//*[@id='finalcost'])[1]"; //XPATH
         recipient_DCTestCostOnBookPay="(.//*[@id='finalcost'])[2]"; //XPATH
         recipient_DCTotalCost="(//div[@class='zy-rec-diag-txt-amt']//span)[3]"; //XPATH
         recipient_DCPackageQnty="(//input[@class='form-control text-center'])[1]"; //XPATH
         recipient_DCPackageUp="(//i[@class='fa fa-caret-up'])[1]";
         recipient_DCTestUp="(//i[@class='fa fa-caret-up'])[2]";
         recipient_DCTestQnty="(//input[@class='form-control text-center'])[2]"; //XPATH
         recipient_DCPackageDown="(//i[@class='fa fa-caret-down'])[1]"; //XPATH
         recipient_DCtestDown="(//i[@class='fa fa-caret-down'])[2]"; //XPATH
         recipient_DCHereOnPayment="//a[@data-parent='#accordion9']"; //XPATH
         recipient_DCTestPkgHeaderOnPayment="//div[@class='zy-rec-diag-pkgs-tests']"; //XPATH
         recipient_DCPackageQntyOnPayment="(//td[@class='zyPackgTestQty'])[1]"; //XPATH
         recipient_DCtestQntyOnPayment="(//td[@class='zyPackgTestQty'])[2]"; //XPATH
         recipient_DCpkgCostOnPayment="(//td[@class='zyPackgTestPrice']//span[@class='zy-sp-payment-money'])[1]"; //XPATH
         recipient_DCtestCostOnPayment="(//td[@class='zyPackgTestPrice']//span[@class='zy-sp-payment-money'])[2]"; //XPATH
         recipient_DCTotalCostOnPayment="(//div[@class='zy-sp-payment-opts']//span[@class='zy-sp-payment-money'])[3]"; //XPATH
         recipient_DCThankYouPagePKGQnty="(//tr//td)[2]"; //XPATH
         recipient_DCThankYouPageTestQnty="(//tr//td)[6]"; //XPATH
         recipient_DCTotalOnThankYouPage="(//tr//td)[14]"; //XPATH
         
		return driver;	
        
       
}

}

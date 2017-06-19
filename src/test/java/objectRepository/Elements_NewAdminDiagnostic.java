package objectRepository;

import org.openqa.selenium.WebDriver;

public class Elements_NewAdminDiagnostic 
{
	public static WebDriver driver;
	public static String Diagnostic_ClickOnAddDiagnostic,DiagnosticCenter_Name,DiagnosticCenter_ShortName,DiagnosticCenter_fullname,DiagnosticCenter_email,DiagnosticCenter_phone,DiagnosticCenter_password;
	public static String MandatoryFields_dateofbirth, MandatoryFields_desc, MandatoryFields_regno, MandatoryFields_dateofreg;
	public static String MandatoryFields_StatusCode,MandatoryFields_languagesSpoken,MandatoryFields_rating,MandatoryFields_startedyear;
	
	
	
	
	
	
	
	
	
	
	
	public static String AdditionalInformation_Menu,ContactPerson_AddContact,ContactPerson_Name, ContactPerson_Phone,ContactPerson_Email,
	ContactPerson_Fax,ContactPerson_Save;
	
	public static String MarkedasClosed_Menu, MarkedasClosed_Add, MarkedasClosed_startdate, MarkedasClosed_enddate, MarkedasClosed_Active,MarkedasClosed_Save;
	
	public static String OtherInformation_Menu, OtherInformation_Discountoffered, OtherInformation_NABL, OtherInformation_websiteURL,
	OtherInformation_accreditations,OtherInformation_NGO,OtherInformation_reportOnlineduration,OtherInformation_isOnline,
	OtherInformation_isSelfCheckIn,OtherInforamtion_isReportOnline;
	
	public static String Social_Menu, Social_Facebook, Social_FaceboolURL,Social_GooglePlus,Social_GooglePlusURL,Social_LinkedIn,Social_LinkedInURL,
	Social_Twitter,Social_TwitterURL;
	
	public static String Address_Menu,Address_Line1,Address_ClickOnCountry,Address_Country,Address_ClicOnState,Address_State,Address_ClickOnCity,
	Address_City,Address_Pincode,Address_Locality,Address_Landmark,Address_Longitude,Address_latitude;
	
	public static String Facilities_Menu,Facilities_DebitCard,Facilities_Bike,Facilities_CreditCard,Facilities_CarParking,Facilities_ambulance,
	Facilities_proBono,Facilities_onlinePayment,Facilities_Premium,Facilities_Cheque,Facilities_Emergency;
	
	public static String SEO_Menu,SEO_Title,SEO_Desc,SEO_Keywords,SEO_URL;
	
	public static String AddDiagnostic_Submit;
	
	public static WebDriver newAdmin_DiagnosticPageProperties()
	{
	
		Diagnostic_ClickOnAddDiagnostic="add";
		DiagnosticCenter_Name="diagnosticCenterName";
		DiagnosticCenter_ShortName="diagnosticCenterShortName";
		DiagnosticCenter_fullname="fullName";
		DiagnosticCenter_email="email";
		DiagnosticCenter_phone="primaryPhoneNumber";
		DiagnosticCenter_password="password";
		
		//MandatoryFields
		MandatoryFields_dateofbirth="dateOfBirth";
		MandatoryFields_desc="diagnosticCenterDescription";
		MandatoryFields_regno="registrationNumber";
		MandatoryFields_dateofreg="dateOfRegistration";
		MandatoryFields_StatusCode="zoyloStatusCode";
		MandatoryFields_languagesSpoken="languagesSpoken";
		MandatoryFields_rating="zoyloRating";
		MandatoryFields_startedyear="establishedYear";
		
		//Additional Information
		
		AdditionalInformation_Menu="additionInfotab";
		ContactPerson_AddContact="//*[@id='zoyDiagAIContact']/div/div[1]/button";
		ContactPerson_Name="contactPersonName";
		ContactPerson_Phone="contactPersonPhone";
		ContactPerson_Email="contactPersonEmail";
		ContactPerson_Fax="contactPersonFax";
		ContactPerson_Save="contacPersonSubmit";
		//Marked as Closed Information
		MarkedasClosed_Menu="zyDCInfoMarkClosed";
		MarkedasClosed_Add="zyAddMarkAsClosed";
		MarkedasClosed_startdate="startDate";
		MarkedasClosed_enddate="endDate";
		MarkedasClosed_Active="isMarkActive";
		MarkedasClosed_Save="markAsCloseSubmit";
		//Other Information
		OtherInformation_Menu="zyDCOtherInfo";
		OtherInformation_Discountoffered="//*[@id='zoyDiagAIOtherInfo']/div[1]/div[1]/div/input";
		OtherInformation_NABL="isNABLAccredited";
		OtherInformation_websiteURL="websiteURL";
		OtherInformation_accreditations="accreditationsReceived";
		OtherInformation_NGO="ngosAssociatedWith";
		OtherInformation_reportOnlineduration="reportOnlineDuration";
		OtherInformation_isOnline="isOnlineAppointmentUsingZoylo";
		OtherInformation_isSelfCheckIn="isSelfCheckInSoftwareAppUsingZoylo";
		OtherInforamtion_isReportOnline="isReportOnline";
		//Social Information
		Social_Menu="zyDCInfoSocial";
		Social_Facebook="zyDocFBActive";
		Social_FaceboolURL="zyDocFBUrl";
		Social_GooglePlus="zyDocGPlusActive";
		Social_GooglePlusURL="zyDocGPlusUrl";
		Social_LinkedIn="zyDocLindnActive";
		Social_LinkedInURL="zyDocLindnUrl";
		Social_Twitter="zyDocTwtActive";
		Social_TwitterURL="zyDocTwtUrl";
		//Address
		Address_Menu="addressTab";
		Address_Line1="addressLine1";
		Address_ClickOnCountry="select2-addressCountry-container";
		Address_Country="addressCountry";
		Address_ClicOnState="select2-addressState-container";
		Address_State="addressState";
		Address_ClickOnCity="select2-addressCity-container";
		Address_City="addressCity";
		Address_Pincode="addressPincode";
		Address_Locality="addressLocality";
		Address_Landmark="addressLandmark";
		Address_Longitude="addressGPSLongitude";
		Address_latitude="addressGPSLatitude";
		//Facilities
		Facilities_Menu="facilitiesTab";
		Facilities_DebitCard="debitCard";
		Facilities_Bike="bikeParking";
		Facilities_CreditCard="creditCard";
		Facilities_CarParking="carParking";
		Facilities_ambulance="ambulance";
		Facilities_proBono="proBono";
		Facilities_onlinePayment="onlinePayment";
		Facilities_Premium="premium";
		Facilities_Cheque="cheque";
		Facilities_Emergency="emergency";
		//SEO
		SEO_Menu="seoTab";
		SEO_Title="seoTitle";
		SEO_Desc="seoDescription";
		SEO_Keywords="seoKeywords";
		SEO_URL="seoUrl";
		AddDiagnostic_Submit="addDiagnosticSubmit";
		
		
		
		
		return driver;
	}
}

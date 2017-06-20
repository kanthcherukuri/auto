package objectRepository;

import org.openqa.selenium.WebDriver;

public class Elements_NewAdminDiagnostic 
{
	public static WebDriver driver;
	public static String Diagnostic_ClickOnAddDiagnostic,DiagnosticCenter_Name,DiagnosticCenter_ShortName,DiagnosticCenter_fullname,DiagnosticCenter_email,DiagnosticCenter_phone,DiagnosticCenter_password;
	public static String MandatoryFields_dateofbirth, MandatoryFields_desc, MandatoryFields_regno, MandatoryFields_dateofreg;
	public static String MandatoryFields_StatusCode,MandatoryFields_languagesSpoken,MandatoryFields_rating,MandatoryFields_startedyear;
	
	public static String Diagnostic_Menu;
	
	public static String HomeVisit_Menu,HomeVisit_Active,HomeVisit_Charge,HomeVisit_ServiceRange,HomeVisit_SlotDuration;
	public static String HomeVisit_AppointmentsPerSlot, HomeVisit_Monday,HomeVisit_AddHomeVisitHoursMonday,HomeVisit_AddHoursActive,
	HomeVisit_AddHomeVisitHoursStartTime,HomeVisit_AddHomeVisitHoursEndTime,HomeVisit_AddHomeVisitHoursSubmit,HomeVisit_Tuesday,HomeVisit_AddHomeVisitHoursTuesday,
	HomeVisit_Wednesday,HomeVisit_AddHomeVisitHoursWednesday,HomeVisit_Thursday,HomeVisit_AddHomeVisitHoursThursday,HomeVisit_Friday,
	HomeVisit_AddHomeVistHoursFriday,HomeVisit_Saturday,HomeVisit_AddHomeVistHoursSaturday;
	
	public static String LabVisit_Menu,LabVisit_SlotDuration,LabVisit_AppointmentsPerSlot,LabVisit_Monday,LabVisit_AddLabVisitHoursMonday,
	LabVisit_AddLabVisitHoursActive, LabVisit_AddLabVisitHoursStartTime,LabVisit_AddLabVisitHoursEndTime,LabVisit_AddLabVisitHoursSubmit,
	LabVisit_Tuesday,  LabVisit_AddLabVisitHoursTuesday,LabVisit_Wednesday,LabVisit_AddLabVisitHoursWednesday,LabVisit_Thursday,
	LabVisit_AddLabVisitHoursThursday,LabVisit_Friday, LabVisit_AddLabVisitHoursFriday,LabVisit_Saturday,LabVisit_AddLabVisitHoursSaturday;
	
	public static String PackageandTests_Menu,HealthPackage_AddPackage,HealthPackage_Status,HealthPackage_ClickOnServiceMode,HealthPackage_LabVisit,
	HealthPackage_HomeVisit,HealthPackage_packageName,HealthPackage_packageDescription,HealthPackage_packageCost,HealthPackage_discountPercentage,
	HealthPackage_zoyloChargePercentage,HealthPackage_averageDuration,HealthPackage_PackagesPerSlot,HealthPackage_PackagesActive,HealthPackage_Save;
	
	public static String PackageTests_Add,PackageTests_TestName,PackageTests_TestDescription,PackageTests_TestActive,PackageTests_TestSave;
	
	public static String DiagnosticTests_Menu,DiagnosticTests_AddTests,DiagnosticTests_TestName,DiagnosticTests_TestDescription,
	DiagnosticTests_AdminStatus,DiagnosticTests_TestCost,DiagnosticTests_DiscountPercentage,DiagnosticTests_ZoyloChargePercentage,
	DiagnosticTests_AverageDuration,DiagnosticTests_TestsPerSlot,DiagnosticTests_TestActive,DiagnosticTests_TestSave,DiagnosticTests_TestCancel;
	
	
	
	
	
	
	
	
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
	
		Diagnostic_Menu="//*[@id='tabs']/li[3]/a/div/div/a";
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
		
		HomeVisit_Menu="homeVisitTab";
		HomeVisit_Active="doesHomeVisit";
		HomeVisit_Charge="homeVisitCharge";
		HomeVisit_ServiceRange="homeVisitServiceRangeKms";
		HomeVisit_SlotDuration="homeVisitSlotDuration";
		HomeVisit_AppointmentsPerSlot="homeVisitAppointmentsPerSlot";
		HomeVisit_Monday="monday";
		HomeVisit_AddHomeVisitHoursMonday="//*[@id='dcHomeVisitMon']/div[1]/div[4]/button";
		HomeVisit_AddHoursActive="isHomeActive";
		HomeVisit_AddHomeVisitHoursStartTime="workHomeStartTime";
		HomeVisit_AddHomeVisitHoursEndTime="workHomeEndTime";
		HomeVisit_AddHomeVisitHoursSubmit="workingHrsSubmit";
		HomeVisit_Tuesday="tuesday";
		HomeVisit_AddHomeVisitHoursTuesday="//*[@id='dcHomeVisitTue']/div[1]/div[4]/button";
		HomeVisit_Wednesday="//a[@href='#dcHomeVisitWed']";
		HomeVisit_AddHomeVisitHoursWednesday="//*[@id='dcHomeVisitWed']/div[1]/div[4]/button";
		HomeVisit_Thursday="thursday";
		HomeVisit_AddHomeVisitHoursThursday="//*[@id='dcHomeVisitThu']/div[1]/div[4]/button";
		HomeVisit_Friday="friday";
		HomeVisit_AddHomeVistHoursFriday="//*[@id='dcHomeVisitFri']/div[1]/div[4]/button";
		HomeVisit_Saturday="saturday";
		HomeVisit_AddHomeVistHoursSaturday="//*[@id='dcHomeVisitSat']/div[1]/div[4]/button";
		
		LabVisit_Menu="labVisitTab";
		LabVisit_SlotDuration="clinicSlotDuration";
		LabVisit_AppointmentsPerSlot="clinicAppointmentsPerSlot";
		LabVisit_Monday="//a[@href='#dcLabVisitMon']";
		LabVisit_AddLabVisitHoursMonday="//*[@id='dcLabVisitMon']/div[1]/div[4]/button";
		LabVisit_AddLabVisitHoursActive="isLabVisitActive";
		LabVisit_AddLabVisitHoursStartTime="workLabStartTime";
		LabVisit_AddLabVisitHoursEndTime="workLabEndTime";
		LabVisit_AddLabVisitHoursSubmit="(//*[@id='workingHrsSubmit'])[2]";
		LabVisit_Tuesday="//a[@href='#dcLabVisitTue']";
		LabVisit_AddLabVisitHoursTuesday="//*[@id='dcLabVisitTue']/div[1]/div[4]/button";
		LabVisit_Wednesday="//a[@href='#dcLabVisitWed']";
		LabVisit_AddLabVisitHoursWednesday="//*[@id='dcLabVisitWed']/div[1]/div[4]/button";
		LabVisit_Thursday="//a[@href='#dcLabVisitThu']";
		LabVisit_AddLabVisitHoursThursday="//*[@id='dcLabVisitThu']/div[1]/div[4]/button";
		LabVisit_Friday="//a[@href='#dcLabVisitFri']" ;
		LabVisit_AddLabVisitHoursFriday="//*[@id='dcLabVisitFri']/div[1]/div[4]/button";
		LabVisit_Saturday="//a[@href='#dcLabVisitSat']";
		LabVisit_AddLabVisitHoursSaturday="//*[@id='dcLabVisitSat']/div[1]/div[4]/button";
		
		PackageandTests_Menu="packageAndTestsTab";
		HealthPackage_AddPackage="//*[@id='zoyDiagPackHealth']/div/div[1]/button";
		HealthPackage_Status="adminStatus";
		HealthPackage_ClickOnServiceMode="select2-serviceMode-container";
		HealthPackage_LabVisit="//*[@id='select2-serviceMode-results']/li[2]";
		HealthPackage_HomeVisit="//*[@id='select2-serviceMode-results']/li[3]";	
		HealthPackage_packageName="packageName";
		HealthPackage_packageDescription="packageDescription";
		HealthPackage_packageCost="packageCost";
		HealthPackage_discountPercentage="discountPercentage";
		HealthPackage_zoyloChargePercentage="zoyloChargePercentage";
		HealthPackage_averageDuration="averageDuration";
		HealthPackage_PackagesPerSlot="averageNumberOfPackagesPerSlot";
		HealthPackage_PackagesActive="isPackagesActive";
		HealthPackage_Save="diagPackagesSave";
		
		PackageTests_Add="//*[@id='zoyDCAddHealthPackageForm']/div/div/button";
		PackageTests_TestName="testName";
		PackageTests_TestDescription="testDescription";
		PackageTests_TestActive="isTestActive";
		PackageTests_TestSave="zoyPackageTestSave";
		
		DiagnosticTests_Menu="zyDCTests";
		DiagnosticTests_AddTests="//*[@id='zoyDiagPackTest']/div/div[1]/button";
		DiagnosticTests_TestName="diagTestName";
		DiagnosticTests_TestDescription="diagTestDescription";
		DiagnosticTests_AdminStatus="diagAdminStatus";
		DiagnosticTests_TestCost="diagTestCost";
		DiagnosticTests_DiscountPercentage="diagDiscountPercentage";
		DiagnosticTests_ZoyloChargePercentage="diagZoyloChargePercentage";
		DiagnosticTests_AverageDuration="diagAverageDuration";
		DiagnosticTests_TestsPerSlot="diagAverageNumberOfTestsPerSlot";
		DiagnosticTests_TestActive="isDiagTestActive";
		DiagnosticTests_TestSave="zyDiagnosticTestSave";
		DiagnosticTests_TestCancel="testCancel";
		
		
		
		
		
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

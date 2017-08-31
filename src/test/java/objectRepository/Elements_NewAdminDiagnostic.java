package objectRepository;

import org.openqa.selenium.WebDriver;

public class Elements_NewAdminDiagnostic 
{
	public static WebDriver driver;
	public static String Diagnostic_ClickOnAddDiagnostic,DiagnosticCenter_Name,DiagnosticCenter_ShortName,DiagnosticCenter_fullname,DiagnosticCenter_email,DiagnosticCenter_phone,DiagnosticCenter_password;
	public static String MandatoryFields_dateofbirth, MandatoryFields_desc, MandatoryFields_regno, MandatoryFields_dateofreg;
	public static String MandatoryFields_StatusCode,MandatoryFields_languagesSpoken,MandatoryFields_rating,MandatoryFields_startedyear;
	
	public static String Diagnostic_Menu,Diagnostic_AppointmentMenu, Diagnostic_AppointmentMenu_Complete;
	
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
	
	public static String Facilities_Menu,Facilities_DebitCard,Facilities_Bike,Facilities_CreditCard,Facilities_CarParking,
	Facilities_onlinePayment,Facilities_Premium,Facilities_Cheque,Facilities_Emergency;
	
	public static String HomeVisit_MondayAssert,HomeVisit_TuesdayAssert,HomeVisit_WednesdayAssert,HomeVisit_ThusdayAssert,
	HomeVisit_FridayAssert,HomeVisit_SaturdayAssert;
	
	public static String LabVisit_MondayAssert,LabVisit_TuesdayAssert,LabVisit_WednesdayAssert,LabVisit_ThursdayAssert,LabVisit_FridayAssert,
	LabVisit_SaturdayAssert, HealthPackage_TestAssert,DiagnosticTests_Assert,ContactPerson_Assert,MarkedasClosed_Assert;
	
	public static String SEO_Menu,SEO_Title,SEO_Desc,SEO_Keywords,SEO_URL;
	
	public static String AddDiagnostic_Submit;
	
	public static String Diagnostic_SearchBox,Diagnostic_ClickOnEdit,HealthPackage_ClickOnEditButton,HealthPackage_CheckPackageName,
	HealthPackage_EditDiscount,HealthPackage_EditFacilitationCharge,DiagnosticTests_ClickOnEdit,DiagnosticTests_EditTestName,
	DiagnosticTests_EditDiscountPercentage,DiagnosticTests_EditZoyloCharge,DiagnosticTests_EditTestSave,DiagnosticTests_EditCancel,
	DiagnosticTests_CheckTestName;
	
	public static String  Diagnostic_AppointmentsUrl,Diagnostic_StatusChange,Reschedule_SelectTommorowMenu,Reschedule_SelectAvailableSlot,
	Reschedule_ClosePopup,Reschedule_SelectNextDay,StatusChange_SubmitCancelledByPatient, StatusChange_SubmitCancelledByDoctor,
	StatusChange_SubmitCompleted,Diagnostic_ClickOnLoginUser,Diagnostic_Logout,DiagnosticLogs_NewCost,DiagnosticLogs_url;
	
	public static String References_ClickReferencemenu,References_ClickOnTestsMenu,References_ClickOnAddButton,References_EntityName,
	References_EntityShortName,References_Description,References_Activate,References_AddSynonym, References_SynonymName,
	References_SaveSynonym, References_Save,References_Edit,References_CheckSynonymName;
	
	public static String Hospital_ClickOnHospitalMenu,Hospital_ClickOnAdd,Hospital_HospitalName,Hospital_ShortName,Hospital_Address,
	Hospital_Longitude,Hospital_Latitude,Hospital_Country,Hospital_State,Hospital_City,Hospital_Pincode,Hospital_CloseContacts,
	Hospital_CloseGallery,Hospital_CloseAwards,Hospital_ClosePackages,Hospital_CloseServices,Hospital_Save,Hospital_ClickOnCountry,
	Hospital_ClickOnState,Hospital_ClickOnCity,Hospital_Cancel,Hospital_NameField,Hospital_ClickOnEdit,Hospital_SelectBikeParking,
	Hospital_SelectCarParking,Hospital_SelectAmbulance,Hospital_SelectPremiumServices,Hospital_SelectICU,Hospital_Update;
	
	public static String Admin_ClickOnAdministrationMenu,Administration_MergeNamesMenu,MergeName_SelectType,
	MergeName_FromValue,MergeName_ToValue,MergeName_Submit,Admin_ClickOnDoctorMenu, Admin_Serachbox,Doctor_GetSpecialisation;
	
	public static String Diagnostic_ActiveCheckBoxList;
	
	
	
	
	
	public static WebDriver newAdmin_DiagnosticPageProperties()
	{
		Diagnostic_ActiveCheckBoxList="//input[@class='no-margin diagnosticCenterActive-class']"; //XPATH
		
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
		HomeVisit_AddHomeVisitHoursMonday="(//button[@data-target='#zoyDiagAddHomeVisitTimings'])[2]";
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
		Facilities_Bike="BIKE_PARKING";
		Facilities_CreditCard="creditCard";
		Facilities_CarParking="CAR_PARKING";
		Facilities_onlinePayment="onlinePayment";
		Facilities_Premium="PREMIUM_SERVICE";
		Facilities_Cheque="cheque";
		Facilities_Emergency="EMERGENCY_SERVICE";
		//SEO
		SEO_Menu="seoTab";
		SEO_Title="seoTitle";
		SEO_Desc="seoDescription";
		SEO_Keywords="seoKeywords";
		SEO_URL="seoUrl";
		AddDiagnostic_Submit="addDiagnosticSubmit";
		
		HomeVisit_MondayAssert="//*[@id='dcHomeVisitMon']/div[2]/table/tbody/tr[2]/td[1]";
		HomeVisit_TuesdayAssert="//*[@id='dcHomeVisitTue']/div[2]/table/tbody/tr[2]/td[1]";
		HomeVisit_WednesdayAssert="//*[@id='dcHomeVisitWed']/div[2]/table/tbody/tr[2]/td[1]";
		HomeVisit_ThusdayAssert="//*[@id='dcHomeVisitThu']/div[2]/table/tbody/tr[2]/td[1]";
		HomeVisit_FridayAssert="//*[@id='dcHomeVisitFri']/div[2]/table/tbody/tr[2]/td[1]";
		HomeVisit_SaturdayAssert="//*[@id='dcHomeVisitSat']/div[2]/table/tbody/tr[2]/td[1]";
		
		LabVisit_MondayAssert="//*[@id='dcLabVisitMon']/div[2]/table/tbody/tr[2]/td[1]";
		LabVisit_TuesdayAssert="//*[@id='dcLabVisitTue']/div[2]/table/tbody/tr[2]/td[1]";
		LabVisit_WednesdayAssert="//*[@id='dcLabVisitWed']/div[2]/table/tbody/tr[2]/td[1]";
		LabVisit_ThursdayAssert="//*[@id='dcLabVisitThu']/div[2]/table/tbody/tr[2]/td[1]";
		LabVisit_FridayAssert="//*[@id='dcLabVisitFri']/div[2]/table/tbody/tr[2]/td[1]";
		LabVisit_SaturdayAssert="//*[@id='dcLabVisitSat']/div[2]/table/tbody/tr[2]/td[1]";
		HealthPackage_TestAssert="//*[@id='zoyDCAddHealthPackageForm']/div/div/div[7]/table/tbody/tr[2]/td[1]";
		DiagnosticTests_Assert="//*[@id='zoyDiagPackTest']/div/div[2]/table/tbody/tr[2]/td[1]";
		ContactPerson_Assert="//*[@id='zoyDiagAIContact']/div/div[2]/table/tbody/tr[2]/td[1]";
		MarkedasClosed_Assert="//*[@id='zoyDiagAIClosed']/div/div[2]/table/tbody/tr[2]/td[1]";

		
		Diagnostic_SearchBox="//input[@class='form-control input-sm']";
		Diagnostic_ClickOnEdit="//button[@class='btn btn-xs edit-btn']";
		HealthPackage_ClickOnEditButton="(//*[@id='0'])[1]";
		HealthPackage_CheckPackageName="//table[@class='table table-bordered text-center']//td[1]";
		HealthPackage_EditDiscount="dp-0";
		HealthPackage_EditFacilitationCharge="zcp-0";
		DiagnosticTests_ClickOnEdit="//i[@class='fa fa-pencil zoyEditTestsBtn']";
		DiagnosticTests_EditTestName="diagEditTestName";
		DiagnosticTests_EditDiscountPercentage="diagEditDiscountPercentage";
		DiagnosticTests_EditZoyloCharge="diagEditZoyloChargePercentage";
		DiagnosticTests_EditTestSave="zyDiagnosticEditTestSave";
		DiagnosticTests_EditCancel="testEditCancel";
		DiagnosticTests_CheckTestName="(//table[@class='table table-bordered text-center'])[17]//td[1]";
		
		
		 Diagnostic_AppointmentsUrl="https://zoyloqa.zoylo.com/admin/zyDiagnosticCenterAppointmentsView";
		 Diagnostic_StatusChange="//select[@class='diagAppointmentsStatusChangeId']";
		 Reschedule_SelectTommorowMenu="//*[@id='cd-1']";
		 Reschedule_SelectAvailableSlot="(//div[@class='panel-collapse collapse in']/ul/li[contains(@class,'timeSlot sp-available-slots')])[1]";
		 Reschedule_ClosePopup="(//button[@class='button-close'])[4]";
		 Reschedule_SelectNextDay="//*[@id='cd-2']";
		 StatusChange_SubmitCancelledByPatient="submitCancelledByPatient";
		 StatusChange_SubmitCancelledByDoctor="submitCancelledByDoctor";
		 StatusChange_SubmitCompleted="submitCompleted";
		 Diagnostic_ClickOnLoginUser="html/body/div[6]/header/div[2]/ul/li/div/button";
		 Diagnostic_Logout="logout";
		 DiagnosticLogs_NewCost="//*[@id='DataTables_Table_0']/tbody/tr/td[5]";
		 DiagnosticLogs_url="https://zoyloqa.zoylo.com/admin/zyDiagnosticCenterPackagesAndTestsLogList";
		 
		 References_ClickReferencemenu=".//*[@id='accordionDiagnostic']/div[6]/a/div/h4/span/i";
		 References_ClickOnTestsMenu="//*[@id='collapseReference']/div/ul/li/a";
		 References_ClickOnAddButton="add";
		 References_EntityName="entityName";
		 References_EntityShortName="entityShortName";
		 References_Description="entityBriefDescription";
		 References_Activate="activeFlag";
		 References_AddSynonym="//button[@class='zoyCommonGreenBtn']";
		 References_SynonymName="synonymName";
		 References_SaveSynonym="zoySynonymSave";
		 References_Save="addZyStandardTestSubmit";
		 References_Edit="(//button[@class='btn btn-xs edit-btn'])[1]";
		 References_CheckSynonymName="//*[@id='insertTestsData']/div/div[4]/div[2]/table/tbody/tr[2]/td[1]";
		 
		 
		 Hospital_ClickOnHospitalMenu="//*[@id='tabs']/li[4]/a/div/div/a";
		 Hospital_ClickOnAdd="add";
		 Hospital_HospitalName="//input[@name='name']";
		 Hospital_ShortName="//input[@name='shortName']";
		 Hospital_Address="//input[@name='addressLine1']";
		 Hospital_Country="html/body/span/span/span[1]/input";
		 Hospital_State="html/body/span/span/span[1]/input";
		 Hospital_City="html/body/span/span/span[1]/input";
		 Hospital_Pincode="//input[@name='pincode']";
		 Hospital_Longitude="//input[@name='gpsLongitude']";
		 Hospital_Latitude="//input[@name='gpslatitude']";
		 Hospital_CloseContacts="(//button[@class='btn btn-primary autoform-remove-item'])[1]";
		 Hospital_CloseGallery="(//button[@type='button'])[161]";
		 Hospital_CloseAwards="(//button[@type='button'])[162]";
		 Hospital_ClosePackages="(//button[@type='button'])[163]";
		 Hospital_CloseServices="(//button[@type='button'])[164]";
		 Hospital_Save="//*[@id='insertHospital']/div/div/div/div/div/button[2]";
		 Hospital_ClickOnCountry="select2-companyCountryOptions-container";
		 Hospital_ClickOnState="select2-companyStateOptions-container";
		 Hospital_ClickOnCity="select2-companyCityOptions-container";
		 Hospital_Cancel="submitCancel";
		 Hospital_NameField="//*[@id='DataTables_Table_0']/tbody/tr[1]/td[1]";
		 Hospital_ClickOnEdit="//button[contains(., 'EDIT')]";
		 Hospital_SelectBikeParking="//input[@name='facilities.isBikeParkingAvailableAtTheHospital']";
		 Hospital_SelectCarParking="//input[@name='facilities.isCarParkingAvailableAtTheHospital']";
		 Hospital_SelectAmbulance="//input[@name='facilities.hasAmbulance']";
		 Hospital_SelectPremiumServices="//input[@name='facilities.hasPremiumServicesAtHospital']";
		 Hospital_SelectICU="//input[@name='facilities.hasIcuAtHospital']";
		 Hospital_Update="//*[@id='updateHospital']/div/div[2]/div/div/div/button[2]";
		 
		 
		 Diagnostic_AppointmentMenu="//div[@id='accordionDiagnostic']/div[2]/a/div/h4";
		 Diagnostic_AppointmentMenu_Complete="//*[@id='collapseDiagnoApmts']/div/ul/li[2]/a";
		 
		 
		 Admin_ClickOnAdministrationMenu="//div[@class='tabLabels']//a[@href='/admin/approveUser']";
		 Administration_MergeNamesMenu="//a[@href='/admin/mergeNames']";
		 MergeName_SelectType="type";
		 MergeName_FromValue="from-value";
		 MergeName_ToValue="to-value";
		 MergeName_Submit="changeNames";
		 Admin_ClickOnDoctorMenu="//div[@class='tabLabels']//a[@href='/admin/serviceProvidersList']";
		 Admin_Serachbox="//input[@type='search']";
		 Doctor_GetSpecialisation="//*[@id='DataTables_Table_0']/tbody/tr/td[7]";
		
		return driver;
	}
}

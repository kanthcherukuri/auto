package objectRepository;

import org.openqa.selenium.WebDriver;

public class Elements_NewAdminDoctors {

public static WebDriver driver;
public static String loginemail, loginpassword, loginbutton;
public static String doctorLabel, addDoctorButton;
public static String firstName, middleName, lastName, shortName, emailID, mobileNumber, password;
public static String Active, workTypeHospital, workTypeHospitalClinic, houseCallActiveCheckBox, houseCallServiceFee, gender, dateOfBirth, medicalRegistrationNumber, Qualification, professionalTag, areaOfSpecialization, lineOfPractice, aboutDoctor;
public static String practiceTab, addOtherClinic;
public static String otherClinicName, otherClinicPhoneNumber, otherClinicFee, otherClinicCountry, otherClinicCountrySelectID, otherClinicState, otherClinicStateSelectID, otherClinicCity, otherClinicCitySelectID, otherClinicAddressLineOne, otherClinicPinCode, otherClinicLongitude, otherClinicLatitude, otherClinicActiveCheckBox, otherClinicFacilitiesTab, otherClinicSave, otherClinicTable_ClinicName, otherClinicCancel, otherClinicFacilities_Ambulance, otherClinicFacilities_assisted, otherClinicFacilities_emergency, otherClinicFacilities_bikeParking, otherClinicFacilities_CarParking, otherClinicFacilities_paymentCredit, otherClinicFacilities_paymentDebit, otherClinicFacilities_paymentCash, otherClinicFacilities_paymentOnline, otherClinicFacilities_paymentCheque, otherClinicFacilities_premiumService, otherClinicFacilities_CleanScore, otherClinicServicesTab, otherClinicServiceAdd, otherClinicServiceName, otherClinicServiceSave;
public static String hospitalGenericInfo, defaultClinicTab, defaultClinicName, defaultClinicconsultationFee, defaultClinicPracticeStartDate, defaultClinicFacilitationCharges;
public static String VacationTab, vacationAddButton, vacationStartDate, vacationEndDate, vacationActiveCheckBox, vacationSave, vacationCancel;
public static String HospitalTab, hospitaladdHospitalBtn, hospitalAddHeading, hospitalpopUpName, hospitalpopUpConsultationFee, hospitalpopUpzoyloCharges, hospitalpopUpActiveCheckBox, hospitalpopUpDefaultCheckBox, hospitalpopUpSaveButton, hospitalTable_hospitalName, hospitalpopUpCancelButton;
public static String galleryTab, galleryUploadButton;
public static String workDaysTab, workDays_addTimeSlotsButton, workDays_workType, workDays_hospitalType, workDays_ClinicType, workDays_workStartTime, workDays_workEndTime, workDays_ActiveCheckBox, workDays_workTimeSave;
public static String workDays_SundayActiveCheckBox, workDays_SundayAddSlotsBtn, workDays_SundayLunchStart, workDays_SundayLunchEnd, workDays_SundayHouseCallStart, workDays_SundayHouseCallEnd;
public static String workDays_MondayTab, workDays_MondayAddSlotsBtn, workDays_MondayActiveCheckBox, workDays_MondayLunchStart, workDays_MondayLunchEnd, workDays_MondayHouseCallStart, workDays_MondayHouseCallEnd;
public static String workDays_TuesdayTab, workDays_TuesdayAddSlotsBtn, workDays_TuesdayActiveCheckBox, workDays_TuesdayLunchStart, workDays_TuesdayLunchEnd, workDays_TuesdayHouseCallStart, workDays_TuesdayHouseCallEnd;
public static String workDays_WednesdayTab, workDays_WednesdayAddSlotsBtn, workDays_WednesdayActiveCheckBox, workDays_WednesdayLunchStart, workDays_WednesdayLunchEnd, workDays_WednesdayHouseCallStart, workDays_WednesdayHouseCallEnd;
public static String workDays_ThursdayTab, workDays_ThursdayAddSlotsBtn, workDays_ThursdayActiveCheckBox, workDays_ThursdayLunchStart, workDays_ThursdayLunchEnd, workDays_ThursdayHouseCallStart, workDays_ThursdayHouseCallEnd;
public static String workDays_FridayTab, workDays_FridayAddSlotsBtn, workDays_FridayActiveCheckBox, workDays_FridayLunchStart, workDays_FridayLunchEnd, workDays_FridayHouseCallStart, workDays_FridayHouseCallEnd;
public static String workDays_SaturdayTab, workDays_SaturdayAddSlotsBtn, workDays_SaturdayActiveCheckBox, workDays_SaturdayLunchStart, workDays_SaturdayLunchEnd, workDays_SaturdayHouseCallStart, workDays_SaturdayHouseCallEnd;
public static String additionalInforTab, socialLink_fbActiveCheckBox, socialLink_fbInput, socialLink_GoogleActiveCheckBox, socialLink_GoogleInput, socialLink_LinkedInActiveCheckBox, socialLink_LinkedInInput, socialLink_TwitterActiveCheckBox, socialLink_TwitterInInput;
public static String additionalInfo_services, additionalInfo_servicesAddButton, additionalInfo_servicesName, additionalInfo_servicesSave, additionalInfo_servicesCancel;
public static String additionalInfo_awardsAndRecognition, additionalInfo_awardsAndRecognitionAdd, additionalInfo_awardsAndRecognitionName, additionalInfo_awardsAndRecognitionSource, additionalInfo_awardsAndRecognitionYear, additionalInfo_awardsAndRecognitionSave, additionalInfo_awardsAndRecognitionCancel;
public static String additionalInfo_OtherInfo, additionalInfo_OtherInfo_ProBonoActiveCheckBox, additionalInfo_OtherInfo_ProBonoFee, additionalInfo_OtherInfo_SecondOpinionActiveCheckBox, additionalInfo_OtherInfo_SecondOpinionFee, additionalInfo_OtherInfo_WaitTime, additionalInfo_OtherInfo_website, additionalInfo_OtherInfo_books, additionalInfo_OtherInfo_blogs, additionalInfo_OtherInfo_journals, additionalInfo_OtherInfo_offersDiscounts, additionalInfo_OtherInfo_membership, additionalInfo_OtherInfo_ngo, additionalInfo_OtherInfo_notes, additionalInfo_OtherInfo_certificates, additionalInfo_OtherInfo_registrationActiveCheckBox, additionalInfo_OtherInfo_verifiedActiveCheckBox, additionalInfo_OtherInfo_ePriscriptionsActiveCheckBox, additionalInfo_OtherInfo_associatedPharmaActiveCheckBox, additionalInfo_OtherInfo_hasDiagnosticActiveCheckBox;
public static String facilitiesTab, facilitiesTab_ambulance, facilitiesTab_assistedOptions, facilitiesTab_emergency, facilitiesTab_bikePark, facilitiesTab_carPark, facilitiesTab_paymentCredit, facilitiesTab_paymentDebit, facilitiesTab_paymentCash, facilitiesTab_paymentOnline, facilitiesTab_paymentChecque, facilitiesTab_paymentPremiumService, facilitiesTab_paymentCleanScore;
public static String addressTab, addressTab_Country, addressTab_CountrySelectID, addressTab_State, addressTab_StateSelectID, addressTab_City, addressTab_CitySelectID, addressTab_completeAddress, addressTab_locality, addressTab_pinCode, addressTab_landMark, addressTab_location, addressTab_pharmaNearBy, addressTab_longitude, addressTab_latitude;
public static String seoInfoTab, seoInfoTab_metaTitle, seoInfoTab_metaDescription, seoInfoTab_metaTags, seoInfoTab_metaKeyWords, seoInfoTab_seoURL, seoInfoTab_scoreCard;
public static String doctorSave, doctorCancel, SearchTab, EditButton, searchResultOnTable;
public static String doctor_referenceTabAssertion, doctor_referencesOption, Add_doctor_reference, doctor_reference_Name, doctor_reference_Description, doctor_reference_ActiveCheckBox;
public static String doctor_reference_practice, doctor_reference_practiceHeader, doctor_reference_practiceAddHeader, doctor_reference_practiceSave, doctor_reference_updatePracticeSave, doctor_reference_practiceEditHeader;
public static String doctor_reference_qualification, doctor_reference_qualificationHeader, doctor_reference_qualificationAddHeader, doctor_reference_qualificationSave, doctor_reference_updateQualificationSave, doctor_reference_qualificationEditHeader;
public static String doctor_reference_specialisation, doctor_reference_specialisationHeader, doctor_reference_specialisationAddHeader, doctor_reference_specialisationSave, doctor_reference_updateSpecialisationSave, doctor_reference_specialisationEditHeader, doctor_reference_specialisation_metaTitle, doctor_reference_specialisation_metaDescription, doctor_reference_specialisation_keyword;
public static String doctor_reference_tag, doctor_reference_tagHeader, doctor_reference_tagAddHeader, doctor_reference_tagSave, doctor_reference_tagEditHeader, doctor_reference_updateTagSave;

	public static WebDriver newAdmin_DoctorPageProperties()
	{
		//LOGIN PAGE
		loginemail="emailAddress"; //ID
		loginpassword="password"; //ID
		loginbutton="//button[text()='Login']"; //XPATH
		
		//GENERIC ADMIN
		doctorLabel="//a[@href='/admin/serviceProvidersList']"; //XPATH
		SearchTab="//div[@class='dataTables_filter']//input[@type='search']"; //XPATH
		EditButton="//button[contains(., 'EDIT')]"; //XPATH
		searchResultOnTable=".//*[@id='DataTables_Table_0']/tbody/tr/td[1]"; //XPATH
		
		//DOCTOR PAGE
		addDoctorButton="add"; //ID
		firstName="firstName"; //ID
		middleName="middleName"; //ID
		lastName="lastName"; //ID
		shortName="shortName"; //ID
		emailID="username"; //ID
		mobileNumber="mobileNumber"; //ID
		password="password"; //ID
		Active="isActive"; //ID
		workTypeHospital="//input[@id='worktype' and @value='hospital']"; //XPATH
		workTypeHospitalClinic="//input[@id='worktype' and @value='hospital-clinics']"; //XPATH
		houseCallActiveCheckBox="doesHouseCalls"; //ID
		houseCallServiceFee="houseCallServiceFee"; //ID
		gender="gender"; //ID
		dateOfBirth="dateOfBirth"; //ID
		medicalRegistrationNumber="medicalRegistrationNumber"; //ID
		Qualification="doctorQualification"; //ID
		professionalTag="tag"; //ID
		areaOfSpecialization="areaOfSpecialisations"; //ID
		lineOfPractice="lineOfPractice"; //ID
		aboutDoctor="about"; //ID
		practiceTab="practiceInfoTab"; //ID
		addOtherClinic="zoyAddOtherClinicsBtn"; //ID
		otherClinicName="zoyOtherClinicsName"; //ID
		otherClinicPhoneNumber="zoyOtherClinicsPhnNum"; //ID
		otherClinicFee="zoyOtherClinicsConFee"; //ID
		otherClinicCountry="select2-zoyOtherClinicsCountry-container"; //ID
		otherClinicCountrySelectID="zoyOtherClinicsCountry"; //ID
		otherClinicState="select2-zoyOtherClinicsState-container"; //ID
		otherClinicStateSelectID="zoyOtherClinicsState"; //ID
		otherClinicCity="select2-zoyOtherClinicsCity-container"; //ID
		otherClinicCitySelectID="zoyOtherClinicsCity";
		otherClinicAddressLineOne="zoyOtherClinicsAddrLine1"; //ID
		otherClinicPinCode="zoyOtherClinicsPincode"; //ID
		otherClinicLongitude="zoyOtherClinicsLng"; //ID
		otherClinicLatitude="zoyOtherClinicsLat"; //ID
		otherClinicActiveCheckBox="zoyOtherClinicsActive"; //ID
		otherClinicFacilitiesTab="//a[@href='#zoyOtherClinicsFacilities']"; //XPATH
		otherClinicFacilities_Ambulance="zoyOtherClinicsAmbulance"; //ID
		otherClinicFacilities_assisted="zoyOtherClinicsAssisted"; //ID
		otherClinicFacilities_emergency="zoyOtherClinicsEmergency"; //ID
		otherClinicFacilities_bikeParking="zoyOtherClinicsBikeParkActive"; //ID
		otherClinicFacilities_CarParking="zoyOtherClinicsCarParkActive"; //ID
		otherClinicFacilities_paymentCredit="zoyOtherClinicsCreditCardActive"; //ID
		otherClinicFacilities_paymentDebit="zoyOtherClinicsDebitCardActive"; //ID
		otherClinicFacilities_paymentCash="zoyOtherClinicsCashPaymentActive"; //ID
		otherClinicFacilities_paymentOnline="zoyOtherClinicsPayOnlineActive"; //ID
		otherClinicFacilities_paymentCheque="zoyOtherClinicsChequeActive"; //ID
		otherClinicFacilities_premiumService="zoyOtherClinicsPremiumServicesAvailable"; //ID
		otherClinicFacilities_CleanScore="zoyOtherClinicsCleanlinessScore"; //ID
		otherClinicServicesTab="//a[@href='#zoyOtherClinicsServices']"; //XPATH
		otherClinicServiceAdd="AddOtherClinicServiceBtn"; //ID
		otherClinicServiceName="zoyOtherClinicServiceName"; //ID
		otherClinicServiceSave="//button[@class='pull-right zoySubmitBtn zoyOtherClinicAddServiceBtn']"; //XPATH
		otherClinicSave="zoyOtherClinicSave"; //ID
		otherClinicTable_ClinicName="//div[@id='zoyDocOtherClinics']//table//td[1]"; //XPATH
		otherClinicCancel="otherClinicCancel"; //ID
		hospitalGenericInfo="//li[contains(., 'Generic Info')]"; //XPATH
		defaultClinicTab="(//ul[@class='zoyDocInfoTabContent']//li)[2]"; //XPATH
		defaultClinicName="clinicName"; //ID
		defaultClinicconsultationFee="consultationFee"; //ID
		defaultClinicPracticeStartDate="practiceStartDate"; //ID
		defaultClinicFacilitationCharges="zoyloFacilitationCharge"; //ID
		VacationTab="//li[@class='zoyDocInfoVactionTab']"; //XPATH
		vacationAddButton="//div[@data-target='#zoyDocAddVacation']"; //XPATH
		vacationStartDate="vacationStartDate"; //ID
		vacationEndDate="vacationEndDate"; //ID
		vacationActiveCheckBox="addVacationActive"; //ID
		vacationSave="//button[@class='pull-right zoySubmitBtn addVacationSave']"; //XPATH
		vacationCancel="addVacationCancel"; //ID
		HospitalTab="//li[@class='zoyDocInfoHospitalTab']"; //XPATH
		hospitaladdHospitalBtn="addHospitalBtn"; //ID
		hospitalAddHeading="hospitalAddPopUp"; //ID
		hospitalpopUpName="zoyDocAddHospitalName"; //ID
		hospitalpopUpConsultationFee="zoyDocAddHospConsFee"; //ID
		hospitalpopUpzoyloCharges="zoyDocAddHospFacCharge"; //ID
		hospitalpopUpActiveCheckBox="zoyDocAddHospActive"; //ID
		hospitalpopUpDefaultCheckBox="zoyDocAddHospDefault"; //ID
		hospitalpopUpSaveButton="zoyDocAddHospSaveBtn"; //ID
		hospitalTable_hospitalName="//div[@id='zoyDocInfoHospital']//table//td[1]"; //XPATH
		hospitalpopUpCancelButton="zoyDocAddHospCancelBtn"; //ID
		galleryTab="//li[@class='zoyDocInfoGalleryTab']"; //XPATH
		galleryUploadButton="doctorImage"; //ID
		workDaysTab="wokringHrsInfoTab"; //ID
		workDays_SundayActiveCheckBox="workingHrsSunMarkAsOpen"; //ID
		workDays_SundayAddSlotsBtn="(//div[@id='addWorkTimingdBtn'])[1]"; //XPATH
		workDays_SundayLunchStart="workingHrsSunLunchStart"; //ID
		workDays_SundayLunchEnd="workingHrsSunLunchEnd"; //ID
		workDays_SundayHouseCallStart="workingHrsSunHouseStart"; //ID
		workDays_SundayHouseCallEnd="workingHrsSunHouseEnd"; //ID
		workDays_addTimeSlotsButton="addWorkTimingdBtn"; //ID
		workDays_workType="workingHrsAddWorkType"; //ID
		workDays_hospitalType="workingHrsAddHospitalName"; //ID
		workDays_ClinicType="workingHrsAddClinicName"; //ID
		workDays_workStartTime="workingHrsStartTime"; //ID
		workDays_workEndTime="workingHrsEndTime"; //ID
		workDays_ActiveCheckBox="workingHrsAddSlotActive"; //ID
		workDays_workTimeSave="workingHrsSlotSaveBtn"; //ID
		workDays_MondayTab="monday"; //ID
		workDays_MondayAddSlotsBtn="(//div[@id='addWorkTimingdBtn'])[2]"; //XPATH
		workDays_MondayActiveCheckBox="workingHrsMonMarkAsOpen"; //ID
		workDays_MondayLunchStart="workingHrsMonLunchStart"; //ID
		workDays_MondayLunchEnd="workingHrsMonLunchEnd"; //ID
		workDays_MondayHouseCallStart="workingHrsMonHouseStart"; //ID
		workDays_MondayHouseCallEnd="workingHrsMonHouseEnd"; //ID
		workDays_TuesdayTab="tuesday"; //ID
		workDays_TuesdayAddSlotsBtn="(//div[@id='addWorkTimingdBtn'])[3]"; //XPATH
		workDays_TuesdayActiveCheckBox="workingHrsTueMarkAsOpen"; //ID
		workDays_TuesdayLunchStart="workingHrsTueLunchStart"; //ID
		workDays_TuesdayLunchEnd="workingHrsTueLunchEnd"; //ID
		workDays_TuesdayHouseCallStart="workingHrsTueHouseStart"; //ID
		workDays_TuesdayHouseCallEnd="workingHrsTueHouseEnd"; //ID
		workDays_WednesdayTab="wednesday"; //ID
		workDays_WednesdayAddSlotsBtn="(//div[@id='addWorkTimingdBtn'])[4]"; //XPATH
		workDays_WednesdayActiveCheckBox="workingHrsWedMarkAsOpen"; //ID
		workDays_WednesdayLunchStart="workingHrsWedLunchStart"; //ID
		workDays_WednesdayLunchEnd="workingHrsWedLunchEnd"; //ID
		workDays_WednesdayHouseCallStart="workingHrsWedHouseStart"; //ID
		workDays_WednesdayHouseCallEnd="workingHrsWedHouseEnd"; //ID
		workDays_ThursdayTab="thursday"; //ID
		workDays_ThursdayAddSlotsBtn="(//div[@id='addWorkTimingdBtn'])[5]"; //XPATH
		workDays_ThursdayActiveCheckBox="workingHrsThuMarkAsOpen"; //ID
		workDays_ThursdayLunchStart="workingHrsThuLunchStart"; //ID
		workDays_ThursdayLunchEnd="workingHrsThuLunchEnd"; //ID
		workDays_ThursdayHouseCallStart="workingHrsThuHouseStart"; //ID
		workDays_ThursdayHouseCallEnd="workingHrsThuHouseEnd"; //ID
		workDays_FridayTab="friday"; //ID
		workDays_FridayAddSlotsBtn="(//div[@id='addWorkTimingdBtn'])[6]"; //XPATH
		workDays_FridayActiveCheckBox="workingHrsFriMarkAsOpen"; //ID
		workDays_FridayLunchStart="workingHrsFriLunchStart"; //ID
		workDays_FridayLunchEnd="workingHrsFriLunchEnd"; //ID
		workDays_FridayHouseCallStart="workingHrsFriHouseStart"; //ID
		workDays_FridayHouseCallEnd="workingHrsFriHouseEnd"; //ID
		workDays_SaturdayTab="saturday";
		workDays_SaturdayAddSlotsBtn="(//div[@id='addWorkTimingdBtn'])[7]"; //XPATH
		workDays_SaturdayActiveCheckBox="workingHrsSatMarkAsOpen"; //ID
		workDays_SaturdayLunchStart="workingHrsSatLunchStart"; //ID
		workDays_SaturdayLunchEnd="workingHrsSatLunchEnd"; //ID
		workDays_SaturdayHouseCallStart="workingHrsSatHouseStart"; //ID
		workDays_SaturdayHouseCallEnd="workingHrsSatHouseEnd"; //ID
		additionalInforTab="additionalInfoTab"; //ID
		socialLink_fbActiveCheckBox="zyDocFBActive"; //ID
		socialLink_fbInput="zyDocFBUrl"; //ID
		socialLink_GoogleActiveCheckBox="zyDocGPlusActive";
		socialLink_GoogleInput="zyDocGPlusUrl"; //ID
		socialLink_LinkedInActiveCheckBox="zyDocLindnActive"; //ID
		socialLink_LinkedInInput="zyDocLindnUrl"; //ID
		socialLink_TwitterActiveCheckBox="zyDocTwtActive"; //ID
		socialLink_TwitterInInput="zyDocTwtUrl"; //ID
		additionalInfo_services="//a[@href='#docServicesTab']"; //XPATH
		additionalInfo_servicesAddButton="zoyDocAddService"; //ID
		additionalInfo_servicesName="zoyDocServiceName"; //ID
		additionalInfo_servicesSave="zoyDocServiceSaveBtn"; //ID
		additionalInfo_servicesCancel="zoyDocServiceCancelBtn"; //ID
		additionalInfo_awardsAndRecognition="//a[@href='#docAwardsTab']"; //XPATH
		additionalInfo_awardsAndRecognitionAdd="//div[@data-target='#zoyDocAddAwards']"; //XPATH
		additionalInfo_awardsAndRecognitionName="zoyDocAwardName"; //ID
		additionalInfo_awardsAndRecognitionSource="zoyDocAwardSource"; //ID
		additionalInfo_awardsAndRecognitionYear="zoyDocAwardYear"; //ID
		additionalInfo_awardsAndRecognitionSave="zoyDocAwardSaveBtn"; //ID
		additionalInfo_awardsAndRecognitionCancel="zoyDocAwardCancelBtn"; //ID
		additionalInfo_OtherInfo="//a[@href='#docOtherInfoTab']"; //XPATH
		additionalInfo_OtherInfo_ProBonoActiveCheckBox="doesProBono"; //ID
		additionalInfo_OtherInfo_ProBonoFee="proBonoServiceFee"; //ID
		additionalInfo_OtherInfo_SecondOpinionActiveCheckBox="isSecondOpinion"; //ID
		additionalInfo_OtherInfo_SecondOpinionFee="secondOpinionServiceFee"; //ID
		additionalInfo_OtherInfo_WaitTime="averageWaitTimeExpected"; //ID
		additionalInfo_OtherInfo_website="website"; //ID
		additionalInfo_OtherInfo_books="books"; //ID
		additionalInfo_OtherInfo_blogs="blogs"; //ID
		additionalInfo_OtherInfo_journals="journals"; //ID
		additionalInfo_OtherInfo_offersDiscounts="offersRewardsAndDiscounts"; //ID
		additionalInfo_OtherInfo_membership="memberships"; //ID
		additionalInfo_OtherInfo_ngo="ngosAssociatedWith"; //ID
		additionalInfo_OtherInfo_notes="notes"; //ID
		additionalInfo_OtherInfo_certificates="certifications"; //ID
		additionalInfo_OtherInfo_registrationActiveCheckBox="registrationNeededAtTheClinic"; //ID
		additionalInfo_OtherInfo_verifiedActiveCheckBox="certifiedAndVerified"; //ID
		additionalInfo_OtherInfo_ePriscriptionsActiveCheckBox="ePrescriptions"; //ID
		additionalInfo_OtherInfo_associatedPharmaActiveCheckBox="hasAssociatedPharmacy"; //ID
		additionalInfo_OtherInfo_hasDiagnosticActiveCheckBox="hasDiagnosticCenter"; //ID
		facilitiesTab="facilitiesInfoTab"; //ID
		facilitiesTab_ambulance="ambulanceEnabled"; //ID
		facilitiesTab_assistedOptions="zoyDocAssOptAtClinic"; //ID
		facilitiesTab_emergency="emergencyAvailable"; //ID
		facilitiesTab_bikePark="isParkingAvailableAtTheClinic"; //ID
		facilitiesTab_carPark="isCarParkingAvailableAtTheClinic"; //ID
		facilitiesTab_paymentCredit="zoyDocCCardActive"; //ID
		facilitiesTab_paymentDebit="zoyDocDCardActive"; //ID
		facilitiesTab_paymentCash="zoyDocCashPayActive"; //ID
		facilitiesTab_paymentOnline="zoyDocPayOnActive"; //ID
		facilitiesTab_paymentChecque="zoyDocChequeActive"; //ID
		facilitiesTab_paymentPremiumService="premiumServicesAvailable"; //ID
		facilitiesTab_paymentCleanScore="cleanlinessScore"; //ID
		addressTab="addressInfoTab"; //ID
		addressTab_Country="select2-zoyDocdefaultCountry-container"; //ID
		addressTab_CountrySelectID="zoyDocdefaultCountry"; //ID
		addressTab_State="select2-zoyDocdefaultState-container"; //ID
		addressTab_StateSelectID="zoyDocdefaultState"; //ID
		addressTab_City="select2-zoyDocdefaultCity-container"; //ID
		addressTab_CitySelectID="zoyDocdefaultCity"; //ID
		addressTab_completeAddress="completeAddress"; //ID
		addressTab_locality="locality"; //ID
		addressTab_pinCode="pincode"; //ID
		addressTab_landMark="landmarkNearBy"; //ID
		addressTab_location="locationAreaSubAreaCity"; //ID
		addressTab_pharmaNearBy="pharmacyNearBy"; //ID
		addressTab_longitude="lng"; //ID
		addressTab_latitude="lat"; //ID
		seoInfoTab="seoInfoTab"; //ID
		seoInfoTab_metaTitle="metaTitle"; //ID
		seoInfoTab_metaDescription="metaTagDescription"; //ID
		seoInfoTab_metaTags="metaTags"; //ID
		seoInfoTab_metaKeyWords="metaKeyWords"; //ID
		seoInfoTab_seoURL="seoURL"; //ID
		seoInfoTab_scoreCard="scoreCard"; //ID
		doctorSave="zoyDocAddProviderBtn"; //ID
		doctorCancel="zoyDocAddProviderCancelBtn"; //ID
		
		//GENERIC REFERENCE
		doctor_referenceTabAssertion="//a[@href='#collapseDoctorReferences']"; //XPATH
		doctor_referencesOption="//div[@id='collapseDoctorReferences']//ul"; //XPATH
		Add_doctor_reference="add"; //ID
		doctor_reference_Name="name"; //ID
		doctor_reference_Description="description"; //ID
		doctor_reference_ActiveCheckBox="isActive"; //ID
		
		//REFERENCE PRACTICE
		doctor_reference_practice="//a[@href='/admin/lineOfPracticeList']"; //XPATH
		doctor_reference_practiceHeader="//h1[contains(., 'Doctor - Practices')]"; //XPATH
		doctor_reference_practiceAddHeader="//h1[contains(., 'Doctor Practice - Add')]"; //XPATH
		doctor_reference_practiceSave="saveLineOfPractices"; //ID
		doctor_reference_updatePracticeSave="updateLineOfPracticeBtn"; //ID
		doctor_reference_practiceEditHeader="//h1[contains(., 'Doctor Practice - Edit')]"; //XPATH
		
		//REFERENCE QUALIFICATION
		doctor_reference_qualification="//a[@href='/admin/doctorQualificationList']"; //XPATH
		doctor_reference_qualificationHeader="//h1[contains(., 'Doctor - Qualifications')]"; //XPATH
		doctor_reference_qualificationAddHeader="//h1[contains(., 'Doctor Qualification - Add')]"; //XPATH
		doctor_reference_qualificationSave="addDoctorQualificationBtn"; //ID
		doctor_reference_updateQualificationSave="editDoctorQualificationBnt"; //ID
		doctor_reference_qualificationEditHeader="//h1[contains(., 'Doctor Qualification - Edit')]"; //XPATH
		
		//REFERENCE SPECIALIZATION
		doctor_reference_specialisation="//a[@href='/admin/areaOfSpecializationList']"; //XPATH
		doctor_reference_specialisationHeader="//h1[contains(., 'Doctor - Specializations')]"; //XPATH
		doctor_reference_specialisationAddHeader="//h1[contains(., 'Doctor Specialization - Add')]"; //XPATH
		doctor_reference_specialisationSave="saveAreaOfSpecialization"; //ID
		doctor_reference_updateSpecialisationSave="updateAreaOfSpecialization";
		doctor_reference_specialisationEditHeader="//h1[contains(., 'Doctor Specialization - Edit')]"; //XPATH
		doctor_reference_specialisation_metaTitle="seoTitle"; //ID
		doctor_reference_specialisation_metaDescription="seoDescription"; //ID
		doctor_reference_specialisation_keyword="seoKeywords"; //ID
		
		//REFERENCE TAGS
		doctor_reference_tag="//a[@href='/admin/providerTagList']"; //XPATH
		doctor_reference_tagHeader="//h1[contains(., 'Doctor - Professional Tags')]"; //XPATh
		doctor_reference_tagAddHeader="//h1[contains(., 'Professional Tag - Add')]"; //XPATh
		doctor_reference_tagSave="saveProfessionalTags"; //ID
		doctor_reference_tagEditHeader="//h1[contains(., 'Professional Tag - Edit')]"; //XPATH
		doctor_reference_updateTagSave="updateProviderTag"; //ID
		
		return driver;
	}
}

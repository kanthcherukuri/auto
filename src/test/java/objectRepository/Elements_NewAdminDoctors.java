package objectRepository;

import org.openqa.selenium.WebDriver;

public class Elements_NewAdminDoctors {

public static WebDriver driver;
public static String doctor_doctorLabel, doctor_addDoctorButton;
public static String doctor_firstName, doctor_middleName, doctor_lastName, doctor_shortName, doctor_emailID, doctor_mobileNumber, doctor_password;
public static String doctor_Active, doctor_workTypeHospital, doctor_workTypeHospitalClinic, doctor_houseCallActiveCheckBox, doctor_houseCallServiceFee, doctor_gender, doctor_dateOfBirth, doctor_medicalRegistrationNumber, doctor_Qualification, doctor_professionalTag, doctor_areaOfSpecialization, doctor_lineOfPractice, doctor_aboutDoctor;
public static String doctor_practiceTab, doctor_addOtherClinic;
public static String doctor_otherClinicName, doctor_otherClinicPhoneNumber, doctor_otherClinicFee, doctor_otherClinicCountry, doctor_otherClinicState, doctor_otherClinicCity, doctor_otherClinicAddressLineOne, doctor_otherClinicPinCode, doctor_otherClinicLongitude, doctor_otherClinicLatitude, doctor_otherClinicActiveCheckBox, doctor_otherClinicFacilitiesTab, doctor_otherClinicSave, doctor_otherClinicCancel, doctor_otherClinicFacilities_Ambulance, doctor_otherClinicFacilities_assisted, doctor_otherClinicFacilities_emergency, doctor_otherClinicFacilities_bikeParking, doctor_otherClinicFacilities_CarParking, doctor_otherClinicFacilities_paymentCredit, doctor_otherClinicFacilities_paymentDebit, doctor_otherClinicFacilities_paymentCash, doctor_otherClinicFacilities_paymentOnline, doctor_otherClinicFacilities_paymentCheque, doctor_otherClinicFacilities_premiumService, doctor_otherClinicFacilities_CleanScore, doctor_otherClinicServicesTab, doctor_otherClinicServiceAdd, doctor_otherClinicServiceName, doctor_otherClinicServiceSave;
public static String doctor_defaultClinicTab, doctor_defaultClinicName, doctor_defaultClinicconsultationFee, doctor_defaultClinicPracticeStartDate, doctor_defaultClinicFacilitationCharges;
public static String doctor_VacationTab, doctor_vacationAddButton, doctor_vacationStartDate, doctor_vacationEndDate, doctor_vacationActiveCheckBox, doctor_vacationSave, doctor_vacationCancel;
public static String doctor_HospitalTab, doctor_hospitaladdHospitalBtn, doctor_hospitalpopUpName, doctor_hospitalpopUpConsultationFee, doctor_hospitalpopUpzoyloCharges, doctor_hospitalpopUpActiveCheckBox, doctor_hospitalpopUpSaveButton, doctor_hospitalpopUpCancelButton;
public static String doctor_galleryTab, doctor_galleryUploadButton;
public static String doctor_workDaysTab, doctor_workDays_addTimeSlotsButton, doctor_workDays_workType, doctor_workDays_hospitalType, doctor_workDays_ClinicType, doctor_workDays_workStartTime, doctor_workDays_workEndTime, doctor_workDays_workTimeSave;
public static String doctor_workDays_SundayActiveCheckBox, doctor_workDays_SundayLunchStart, doctor_workDays_SundayLunchEnd, doctor_workDays_SundayHouseCallStart, doctor_workDays_SundayHouseCallEnd;
public static String doctor_workDays_MondayTab, doctor_workDays_MondayActiveCheckBox, doctor_workDays_MondayLunchStart, doctor_workDays_MondayLunchEnd, doctor_workDays_MondayHouseCallStart, doctor_workDays_MondayHouseCallEnd;
public static String doctor_workDays_TuesdayTab, doctor_workDays_TuesdayActiveCheckBox, doctor_workDays_TuesdayLunchStart, doctor_workDays_TuesdayLunchEnd, doctor_workDays_TuesdayHouseCallStart, doctor_workDays_TuesdayHouseCallEnd;
public static String doctor_workDays_WednesdayTab, doctor_workDays_WednesdayActiveCheckBox, doctor_workDays_WednesdayLunchStart, doctor_workDays_WednesdayLunchEnd, doctor_workDays_WednesdayHouseCallStart, doctor_workDays_WednesdayHouseCallEnd;
public static String doctor_workDays_ThursdayTab, doctor_workDays_ThursdayActiveCheckBox, doctor_workDays_ThursdayLunchStart, doctor_workDays_ThursdayLunchEnd, doctor_workDays_ThursdayHouseCallStart, doctor_workDays_ThursdayHouseCallEnd;
public static String doctor_workDays_FridayTab, doctor_workDays_FridayActiveCheckBox, doctor_workDays_FridayLunchStart, doctor_workDays_FridayLunchEnd, doctor_workDays_FridayHouseCallStart, doctor_workDays_FridayHouseCallEnd;
public static String doctor_workDays_SaturdayTab, doctor_workDays_SaturdayActiveCheckBox, doctor_workDays_SaturdayLunchStart, doctor_workDays_SaturdayLunchEnd, doctor_workDays_SaturdayHouseCallStart, doctor_workDays_SaturdayHouseCallEnd;
public static String doctor_additionalInforTab, doctor_socialLink_fbActiveCheckBox, doctor_socialLink_fbInput, doctor_socialLink_GoogleActiveCheckBox, doctor_socialLink_GoogleInput, doctor_socialLink_LinkedInActiveCheckBox, doctor_socialLink_LinkedInInput, doctor_socialLink_TwitterActiveCheckBox, doctor_socialLink_TwitterInInput;
public static String doctor_additionalInfo_services, doctor_additionalInfo_servicesAddButton, doctor_additionalInfo_servicesName, doctor_additionalInfo_servicesSave, doctor_additionalInfo_servicesCancel;
public static String doctor_additionalInfo_awardsAndRecognition, doctor_additionalInfo_awardsAndRecognitionAdd, doctor_additionalInfo_awardsAndRecognitionName, doctor_additionalInfo_awardsAndRecognitionSource, doctor_additionalInfo_awardsAndRecognitionYear, doctor_additionalInfo_awardsAndRecognitionSave, doctor_additionalInfo_awardsAndRecognitionCancel;
public static String doctor_additionalInfo_OtherInfo;

	public static WebDriver newAdmin_DoctorPageProperties()
	{
		doctor_doctorLabel="//a[@href='/admin/serviceProvidersList']"; //XPATH
		doctor_addDoctorButton="add"; //ID
		doctor_firstName="firstName"; //ID
		doctor_middleName="middleName"; //ID
		doctor_lastName="lastName"; //ID
		doctor_shortName="shortName"; //ID
		doctor_emailID="username"; //ID
		doctor_mobileNumber="mobileNumber"; //ID
		doctor_password="password"; //ID
		doctor_Active="isActive"; //ID
		doctor_workTypeHospital="//input[@id='worktype' and @value='hospital']"; //XPATH
		doctor_workTypeHospitalClinic="//input[@id='worktype' and @value='hospital-clinics']"; //XPATH
		doctor_houseCallActiveCheckBox="doesHouseCalls"; //ID
		doctor_houseCallServiceFee="houseCallServiceFee"; //ID
		doctor_gender="gender"; //ID
		doctor_dateOfBirth="dateOfBirth"; //ID
		doctor_medicalRegistrationNumber="medicalRegistrationNumber"; //ID
		doctor_Qualification="//span[@title='Doctor Qualification']//ul[@class='select2-selection__rendered']"; //XPATH
		doctor_professionalTag="//span[@title='Professional Tag']//ul[@class='select2-selection__rendered']"; //XPATH
		doctor_areaOfSpecialization="//span[@title='Area of Specialization']//ul[@class='select2-selection__rendered']"; //XPATH
		doctor_lineOfPractice="//span[@title='Line of Practice']//ul[@class='select2-selection__rendered']"; //XPATH
		doctor_aboutDoctor="about"; //ID
		doctor_practiceTab="practiceInfoTab"; //ID
		doctor_addOtherClinic="zoyAddOtherClinicsBtn"; //ID
		doctor_otherClinicName="zoyOtherClinicsName"; //ID
		doctor_otherClinicPhoneNumber="zoyOtherClinicsPhnNum"; //ID
		doctor_otherClinicFee="zoyOtherClinicsConFee"; //ID
		doctor_otherClinicCountry="select2-zoyOtherClinicsCountry-container"; //ID
		doctor_otherClinicState="select2-zoyOtherClinicsState-container"; //ID
		doctor_otherClinicCity="select2-zoyOtherClinicsCity-container"; //ID
		doctor_otherClinicAddressLineOne="zoyOtherClinicsAddrLine1"; //ID
		doctor_otherClinicPinCode="zoyOtherClinicsPincode"; //ID
		doctor_otherClinicLongitude="zoyOtherClinicsLng"; //ID
		doctor_otherClinicLatitude="zoyOtherClinicsLat"; //ID
		doctor_otherClinicActiveCheckBox="zoyOtherClinicsActive"; //ID
		doctor_otherClinicFacilitiesTab="//a[@href='#zoyOtherClinicsFacilities']"; //XPATH
		doctor_otherClinicFacilities_Ambulance="zoyOtherClinicsAmbulance"; //ID
		doctor_otherClinicFacilities_assisted="zoyOtherClinicsAssisted"; //ID
		doctor_otherClinicFacilities_emergency="zoyOtherClinicsEmergency"; //ID
		doctor_otherClinicFacilities_bikeParking="zoyOtherClinicsBikeParkActive"; //ID
		doctor_otherClinicFacilities_CarParking="zoyOtherClinicsCarParkActive"; //ID
		doctor_otherClinicFacilities_paymentCredit="zoyOtherClinicsCreditCardActive"; //ID
		doctor_otherClinicFacilities_paymentDebit="zoyOtherClinicsDebitCardActive"; //ID
		doctor_otherClinicFacilities_paymentCash="zoyOtherClinicsCashPaymentActive"; //ID
		doctor_otherClinicFacilities_paymentOnline="zoyOtherClinicsPayOnlineActive"; //ID
		doctor_otherClinicFacilities_paymentCheque="zoyOtherClinicsChequeActive"; //ID
		doctor_otherClinicFacilities_premiumService="zoyOtherClinicsPremiumServicesAvailable"; //ID
		doctor_otherClinicFacilities_CleanScore="zoyOtherClinicsCleanlinessScore"; //ID
		doctor_otherClinicServicesTab="//a[@href='#zoyOtherClinicsServices']"; //XPATH
		doctor_otherClinicServiceAdd="AddOtherClinicServiceBtn"; //ID
		doctor_otherClinicServiceName="zoyOtherClinicServiceName"; //ID
		doctor_otherClinicServiceSave="//button[@class='pull-right zoySubmitBtn zoyOtherClinicAddServiceBtn']"; //XPATH
		doctor_otherClinicSave="zoyOtherClinicSave"; //ID
		doctor_otherClinicCancel="otherClinicCancel"; //ID
		doctor_defaultClinicTab="//li[@class='zoyDocInfoDefaultClinicTab']"; //XPATH
		doctor_defaultClinicName="clinicName"; //ID
		doctor_defaultClinicconsultationFee="consultationFee"; //ID
		doctor_defaultClinicPracticeStartDate="practiceStartDate"; //ID
		doctor_defaultClinicFacilitationCharges="zoyloFacilitationCharge"; //ID
		doctor_VacationTab="//li[@class='zoyDocInfoVactionTab']"; //XPATH
		doctor_vacationAddButton="//div[@data-target='#zoyDocAddVacation']"; //XPATH
		doctor_vacationStartDate="vacationStartDate"; //ID
		doctor_vacationEndDate="vacationEndDate"; //ID
		doctor_vacationActiveCheckBox="addVacationActive"; //ID
		doctor_vacationSave="//button[@class='pull-right zoySubmitBtn addVacationSave']"; //XPATH
		doctor_vacationCancel="addVacationCancel"; //ID
		doctor_HospitalTab="//li[@class='zoyDocInfoHospitalTab']"; //XPATH
		doctor_hospitaladdHospitalBtn="addHospitalBtn"; //ID
		doctor_hospitalpopUpName="select2-zoyDocAddHospitalName-container"; //ID
		doctor_hospitalpopUpConsultationFee="zoyDocAddHospConsFee"; //ID
		doctor_hospitalpopUpzoyloCharges="zoyDocAddHospFacCharge"; //ID
		doctor_hospitalpopUpActiveCheckBox="zoyDocAddHospActive"; //ID
		doctor_hospitalpopUpSaveButton="zoyDocAddHospSaveBtn"; //ID
		doctor_hospitalpopUpCancelButton="zoyDocAddHospCancelBtn"; //ID
		doctor_galleryTab="//li[@class='zoyDocInfoGalleryTab']"; //XPATH
		doctor_galleryUploadButton="doctorImage"; //ID
		doctor_workDaysTab="wokringHrsInfoTab"; //ID
		doctor_workDays_SundayActiveCheckBox="workingHrsSunMarkAsOpen"; //ID
		doctor_workDays_SundayLunchStart="workingHrsSunLunchStart"; //ID
		doctor_workDays_SundayLunchEnd="workingHrsSunLunchEnd"; //ID
		doctor_workDays_SundayHouseCallStart="workingHrsSunHouseStart"; //ID
		doctor_workDays_SundayHouseCallEnd="workingHrsSunHouseEnd"; //ID
		doctor_workDays_addTimeSlotsButton="addWorkTimingdBtn"; //ID
		doctor_workDays_workType="workingHrsAddWorkType"; //ID
		doctor_workDays_hospitalType="workingHrsAddHospitalName"; //ID
		doctor_workDays_ClinicType="workingHrsAddClinicName"; //ID
		doctor_workDays_workStartTime="workingHrsStartTime"; //ID
		doctor_workDays_workEndTime="workingHrsEndTime"; //ID
		doctor_workDays_workTimeSave="workingHrsSlotSaveBtn"; //ID
		doctor_workDays_MondayTab="monday"; //ID
		doctor_workDays_MondayActiveCheckBox="workingHrsMonMarkAsOpen"; //ID
		doctor_workDays_MondayLunchStart="workingHrsMonLunchStart"; //ID
		doctor_workDays_MondayLunchEnd="workingHrsMonLunchEnd"; //ID
		doctor_workDays_MondayHouseCallStart="workingHrsMonHouseStart"; //ID
		doctor_workDays_MondayHouseCallEnd="workingHrsMonHouseEnd"; //ID
		doctor_workDays_TuesdayTab="tuesday"; //ID
		doctor_workDays_TuesdayActiveCheckBox="workingHrsTueMarkAsOpen"; //ID
		doctor_workDays_TuesdayLunchStart="workingHrsTueLunchStart"; //ID
		doctor_workDays_TuesdayLunchEnd="workingHrsTueLunchEnd"; //ID
		doctor_workDays_TuesdayHouseCallStart="workingHrsTueHouseStart"; //ID
		doctor_workDays_TuesdayHouseCallEnd="workingHrsTueHouseEnd"; //ID
		doctor_workDays_WednesdayTab="wednesday"; //ID
		doctor_workDays_WednesdayActiveCheckBox="workingHrsWedMarkAsOpen"; //ID
		doctor_workDays_WednesdayLunchStart="workingHrsWedLunchStart"; //ID
		doctor_workDays_WednesdayLunchEnd="workingHrsWedLunchEnd"; //ID
		doctor_workDays_WednesdayHouseCallStart="workingHrsWedHouseStart"; //ID
		doctor_workDays_WednesdayHouseCallEnd="workingHrsWedHouseEnd"; //ID
		doctor_workDays_ThursdayTab="thursday"; //ID
		doctor_workDays_ThursdayActiveCheckBox="workingHrsThuMarkAsOpen"; //ID
		doctor_workDays_ThursdayLunchStart="workingHrsThuLunchStart"; //ID
		doctor_workDays_ThursdayLunchEnd="workingHrsThuLunchEnd"; //ID
		doctor_workDays_ThursdayHouseCallStart="workingHrsThuHouseStart"; //ID
		doctor_workDays_ThursdayHouseCallEnd="workingHrsThuHouseEnd"; //ID
		doctor_workDays_FridayTab="friday"; //ID
		doctor_workDays_FridayActiveCheckBox="workingHrsFriMarkAsOpen"; //ID
		doctor_workDays_FridayLunchStart="workingHrsFriLunchStart"; //ID
		doctor_workDays_FridayLunchEnd="workingHrsFriLunchEnd"; //ID
		doctor_workDays_FridayHouseCallStart="workingHrsFriHouseStart"; //ID
		doctor_workDays_FridayHouseCallEnd="workingHrsFriHouseEnd"; //ID
		doctor_workDays_SaturdayTab="saturday";
		doctor_workDays_SaturdayActiveCheckBox="workingHrsSatMarkAsOpen"; //ID
		doctor_workDays_SaturdayLunchStart="workingHrsSatLunchStart"; //ID
		doctor_workDays_SaturdayLunchEnd="workingHrsSatLunchEnd"; //ID
		doctor_workDays_SaturdayHouseCallStart="workingHrsSatHouseStart"; //ID
		doctor_workDays_SaturdayHouseCallEnd="workingHrsSatHouseEnd"; //ID
		doctor_additionalInforTab="additionalInfoTab"; //ID
		doctor_socialLink_fbActiveCheckBox="zyDocFBActive"; //ID
		doctor_socialLink_fbInput="zyDocFBUrl"; //ID
		doctor_socialLink_GoogleActiveCheckBox="zyDocGPlusActive";
		doctor_socialLink_GoogleInput="zyDocGPlusUrl"; //ID
		doctor_socialLink_LinkedInActiveCheckBox="zyDocLindnActive"; //ID
		doctor_socialLink_LinkedInInput="zyDocLindnUrl"; //ID
		doctor_socialLink_TwitterActiveCheckBox="zyDocTwtActive"; //ID
		doctor_socialLink_TwitterInInput="zyDocTwtUrl"; //ID
		doctor_additionalInfo_services="//a[@href='#docServicesTab']"; //XPATH
		doctor_additionalInfo_servicesAddButton="zoyDocAddService"; //ID
		doctor_additionalInfo_servicesName="zoyDocServiceName"; //ID
		doctor_additionalInfo_servicesSave="zoyDocServiceSaveBtn"; //ID
		doctor_additionalInfo_servicesCancel="zoyDocServiceCancelBtn"; //ID
		doctor_additionalInfo_awardsAndRecognition="//a[@href='#docAwardsTab']"; //XPATH
		doctor_additionalInfo_awardsAndRecognitionAdd="//div[@data-target='#zoyDocAddAwards']"; //XPATH
		doctor_additionalInfo_awardsAndRecognitionName="zoyDocAwardName"; //ID
		doctor_additionalInfo_awardsAndRecognitionSource="zoyDocAwardSource"; //ID
		doctor_additionalInfo_awardsAndRecognitionYear="zoyDocAwardYear"; //ID
		doctor_additionalInfo_awardsAndRecognitionSave="zoyDocAwardSaveBtn"; //ID
		doctor_additionalInfo_awardsAndRecognitionCancel="zoyDocAwardCancelBtn"; //ID
		doctor_additionalInfo_OtherInfo="//a[@href='#docOtherInfoTab']"; //XPATH
		
		
		//Pending from Additonal Info - other info tab
		
		return driver;
	}
}

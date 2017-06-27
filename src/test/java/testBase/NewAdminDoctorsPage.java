package testBase;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import objectRepository.Elements_NewAdminDoctors;

public class NewAdminDoctorsPage extends LoadPropMac
{
	public WebDriver driver;
	public TestUtils Browser;
	
	public NewAdminDoctorsPage(WebDriver driver)
	{
		this.driver=driver;
		Browser=new TestUtils(driver);
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties();
	}
	
	//Methods from here
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to signIn as an admin
	 * @ Param			: username and password
	 * @ return			: NA
	 */
	public void adminSignIn (String username, String password)
	{
		Browser.waitFortheID(Elements_NewAdminDoctors.loginemail);
		driver.findElement(By.id(Elements_NewAdminDoctors.loginemail)).sendKeys(username);
		driver.findElement(By.id(Elements_NewAdminDoctors.loginpassword)).sendKeys(password);
		driver.findElement(By.xpath(Elements_NewAdminDoctors.loginbutton)).click();	
		Browser.waitFortheID("tabs");
	} //Admin sign in method end ***
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to signIn as an admin user with restricted permissions
	 * @ Param			: username and password
	 * @ return			: NA
	 */
	public void adminUserSignIn(String adminUserName, String adminUserPassword)
	{
		Browser.waitFortheID(Elements_NewAdminDoctors.loginemail);
		driver.findElement(By.id(Elements_NewAdminDoctors.loginemail)).sendKeys(adminUserName);
		driver.findElement(By.id(Elements_NewAdminDoctors.loginpassword)).sendKeys(adminUserPassword);
		driver.findElement(By.xpath(Elements_NewAdminDoctors.loginbutton)).click();
	} //Admin user sign in method end ***
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click doctors tab on admin webmodule
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void click_doctorsTab()
	{
		driver.findElement(By.xpath(Elements_NewAdminDoctors.doctorLabel)).click();
		Browser.waitFortheID(Elements_NewAdminDoctors.addDoctorButton);
	} //Doctors tab click method end ***
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click ADD doctor button on admin webmodule
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void click_addDoctor()
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.addDoctorButton)).click();
		Browser.waitFortheID(Elements_NewAdminDoctors.firstName);
	} //Add doctor method end ***
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click hospital worj type of doctor on admin add doctor screen
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void clickHospitalWorkType() throws Exception
	{
		driver.findElement(By.xpath(Elements_NewAdminDoctors.workTypeHospital)).click();
		Thread.sleep(1500);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to enter generic details of doctor on admin add doctor screen
	 * @ Param			: First, middle and last names, short name, email ID, mobile Number, password
	 * @ return			: NA
	 */
	public void Enter_doctorGenericDetails(String firstName, String MiddleName, String LastName, String ShortName, String emailID, String mobileNumber, String password)
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.firstName)).sendKeys(firstName);
		driver.findElement(By.id(Elements_NewAdminDoctors.middleName)).sendKeys(MiddleName);
		driver.findElement(By.id(Elements_NewAdminDoctors.lastName)).sendKeys(LastName);
		driver.findElement(By.id(Elements_NewAdminDoctors.shortName)).sendKeys(ShortName);
		driver.findElement(By.id(Elements_NewAdminDoctors.emailID)).sendKeys(emailID);
		driver.findElement(By.id(Elements_NewAdminDoctors.mobileNumber)).sendKeys(mobileNumber);
		driver.findElement(By.id(Elements_NewAdminDoctors.password)).sendKeys(password);
	} //Generic details method end ***
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to enter primary information tab details of doctor on admin add doctor screen
	 * @ Param			: is doctor Active, doctor workType, doctor housecall status, doc housecall fee, doctor's gender, doctors DOB, doctor's reg Num, doctors qualification, doctors prof tag, doctors specialization, doctor's practice line, about the doctor
	 * @ return			: NA
	 */
	public void Enter_primaryInfoDetails(String isActiveValue, String houseCallStatus, String houseCallFee, String genderValue, String DOB, String regNum, String qualification, String tag, String specialization, String practiceLine, String aboutDoc) throws Exception
	{
		if(isActiveValue.equalsIgnoreCase("true"))
		{
			driver.findElement(By.id(Elements_NewAdminDoctors.Active)).click();
		}
		else
		{
			System.out.println("Doctor isActive is marked as false");
		}
		if(houseCallStatus.equalsIgnoreCase("true"))
		{
			driver.findElement(By.id(Elements_NewAdminDoctors.houseCallActiveCheckBox)).click();
			driver.findElement(By.id(Elements_NewAdminDoctors.houseCallServiceFee)).sendKeys(houseCallFee);
		}
		else
		{
			System.out.println("House call is marked as false");
		}
		if(genderValue.equalsIgnoreCase("Male"))
		{
			Browser.actionbyid(Elements_NewAdminDoctors.gender, "Male");
			System.out.println("Gender of the doctor being entered is Male");
		}
		else
		{
			Browser.actionbyid(Elements_NewAdminDoctors.gender, "Female");
			System.out.println("Gender of the doctor being entered is Female");
		}
		driver.findElement(By.id(Elements_NewAdminDoctors.dateOfBirth)).click();
		driver.findElement(By.id(Elements_NewAdminDoctors.dateOfBirth)).clear();
		driver.findElement(By.id(Elements_NewAdminDoctors.dateOfBirth)).sendKeys(DOB); //(MM/DD/YYYY)
		driver.findElement(By.id(Elements_NewAdminDoctors.medicalRegistrationNumber)).sendKeys(regNum);
		Browser.selectbyID(Elements_NewAdminDoctors.Qualification, qualification);
		Browser.selectbyID(Elements_NewAdminDoctors.professionalTag, tag);
		Browser.selectbyID(Elements_NewAdminDoctors.areaOfSpecialization, specialization);
		Browser.selectbyID(Elements_NewAdminDoctors.lineOfPractice, practiceLine);
		driver.findElement(By.id(Elements_NewAdminDoctors.aboutDoctor)).sendKeys(aboutDoc);
	} //Primary info method end ***
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to enter primary information tab details of hospital doctor on admin add doctor screen
	 * @ Param			: is doctor Active, doctor workType, doctor housecall status, doc housecall fee, doctor's gender, doctors DOB, doctor's reg Num, doctors qualification, doctors prof tag, doctors specialization, doctor's practice line, about the doctor
	 * @ return			: NA
	 */
	public void Enter_hospitalDoctorPrimaryInfoDetails(String isActiveValue, String genderValue, String DOB, String regNum, String qualification, String tag, String specialization, String practiceLine, String aboutDoc) throws Exception
	{
		if(isActiveValue.equalsIgnoreCase("true"))
		{
			driver.findElement(By.id(Elements_NewAdminDoctors.Active)).click();
		}
		else
		{
			System.out.println("Doctor isActive is marked as false");
		}
		if(genderValue.equalsIgnoreCase("Male"))
		{
			Browser.actionbyid(Elements_NewAdminDoctors.gender, "Male");
			System.out.println("Gender of the doctor being entered is Male");
		}
		else
		{
			Browser.actionbyid(Elements_NewAdminDoctors.gender, "Female");
			System.out.println("Gender of the doctor being entered is Female");
		}
		driver.findElement(By.id(Elements_NewAdminDoctors.dateOfBirth)).click();
		driver.findElement(By.id(Elements_NewAdminDoctors.dateOfBirth)).clear();
		driver.findElement(By.id(Elements_NewAdminDoctors.dateOfBirth)).sendKeys(DOB); //(MM/DD/YYYY)
		driver.findElement(By.id(Elements_NewAdminDoctors.medicalRegistrationNumber)).sendKeys(regNum);
		Browser.selectbyID(Elements_NewAdminDoctors.Qualification, qualification);
		Browser.selectbyID(Elements_NewAdminDoctors.professionalTag, tag);
		Browser.selectbyID(Elements_NewAdminDoctors.areaOfSpecialization, specialization);
		Browser.selectbyID(Elements_NewAdminDoctors.lineOfPractice, practiceLine);
		driver.findElement(By.id(Elements_NewAdminDoctors.aboutDoctor)).sendKeys(aboutDoc);
	} //Primary info method end for hospital***
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to enter other clinic information under practice tab of doctor on admin add doctor screen
	 * @ Param			: ifOtherClinicAvailable, othrClinicName, othrClinicPhoneNumber, othrClinicFee, othrState, othrCity, othrAddressLineOne, othrClinicPinCode, othrClinicLongitude, othrClinicLatitude, othrClinicFacilityStatus, othrClinicAmbulanceStatus, othrClinicEmergencyStatus, othrClinicBikeParkStatus, othrClinicCarParkStatus, othrClincPayCreditStatus, othrClincPayDebitStatus, othrClincPayOnlineStatus, othrClincPayCashStatus, othrClincPayChecqueStatus, othrClinicPremiumServiceStatus
	 * @ return			: NA
	 */
	public void Enter_practiceDetails_otherClinic(String ifOtherClinicAvailable, String othrClinicName, String othrClinicPhoneNumber, String othrClinicFee, String othrClinicState, String othrClinicCity, String othrClinicAddressLineOne, String othrClinicPinCode, String othrClinicLongitude, String othrClinicLatitude, String othrClinicFacilityStatus, String othrClinicAmbulanceStatus, String othrClinicEmergencyStatus, String othrClinicBikeParkStatus, String othrClinicCarParkStatus, String othrClincPayCreditStatus, String othrClincPayDebitStatus, String othrClincPayCashStatus, String othrClincPayOnlineStatus, String othrClincPayChecqueStatus, String othrClinicPremiumServiceStatus) throws Exception
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.practiceTab)).click();
		Browser.waitFortheID(Elements_NewAdminDoctors.addOtherClinic);
		if(ifOtherClinicAvailable.equalsIgnoreCase("true"))
		{
			driver.findElement(By.id(Elements_NewAdminDoctors.addOtherClinic)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.otherClinicName);
			//Other clinic pop up to add
			driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicName)).sendKeys(othrClinicName);
			driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicPhoneNumber)).sendKeys(othrClinicPhoneNumber);
			driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicFee)).sendKeys(othrClinicFee);
			driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicCountry)).click();
			Browser.selectbyID(Elements_NewAdminDoctors.otherClinicCountrySelectID, "India");
			driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicState)).click();
			Browser.selectbyID(Elements_NewAdminDoctors.otherClinicStateSelectID, othrClinicState);
			driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicCity)).click();
			Browser.selectbyID(Elements_NewAdminDoctors.otherClinicCitySelectID, othrClinicCity);
			driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicAddressLineOne)).sendKeys(othrClinicAddressLineOne);
			driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicPinCode)).sendKeys(othrClinicPinCode);
			driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicLongitude)).sendKeys(othrClinicLongitude);
			driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicLatitude)).sendKeys(othrClinicLatitude);
			driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicActiveCheckBox)).click();
			if(othrClinicFacilityStatus.equalsIgnoreCase("true"))
			{
				driver.findElement(By.xpath(Elements_NewAdminDoctors.otherClinicFacilitiesTab)).click();
				Browser.waitFortheID(Elements_NewAdminDoctors.otherClinicFacilities_Ambulance);
				if(othrClinicAmbulanceStatus.equalsIgnoreCase("true"))
				{
					driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicFacilities_Ambulance)).click();
				}
				else
				{
					System.out.println("Ambulance facility for other clinic is not checked");
				}
				if(othrClinicEmergencyStatus.equalsIgnoreCase("true"))
				{
					driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicFacilities_emergency)).click();
				}
				else
				{
					System.out.println("Emergency facility for other clinic is not checked");
				}
				if(othrClinicBikeParkStatus.equalsIgnoreCase("true"))
				{
					driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicFacilities_bikeParking)).click();
				}
				else
				{
					System.out.println("Bike parking facility for other clinic is not checked");
				}
				if(othrClinicCarParkStatus.equalsIgnoreCase("true"))
				{
					driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicFacilities_CarParking)).click();
				}
				else
				{
					System.out.println("Car parking facility for other clinic is not checked");
				}
				if(othrClincPayCreditStatus.equalsIgnoreCase("true"))
				{
					driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicFacilities_paymentCredit)).click();
				}
				else
				{
					System.out.println("Credit payment facility for other clinic is not checked");
				}
				if(othrClincPayDebitStatus.equalsIgnoreCase("true"))
				{
					driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicFacilities_paymentDebit)).click();
				}
				else
				{
					System.out.println("Debit payment facility for other clinic is not checked");
				}
				if(othrClincPayCashStatus.equalsIgnoreCase("true"))
				{
					driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicFacilities_paymentCash)).click();
				}
				else
				{
					System.out.println("Cash payment facility for other clinic is not checked");
				}
				if(othrClincPayOnlineStatus.equalsIgnoreCase("true"))
				{
					driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicFacilities_paymentOnline)).click();
				}
				else
				{
					System.out.println("Online payment facility for other clinic is not checked");
				}
				if(othrClincPayChecqueStatus.equalsIgnoreCase("true"))
				{
					driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicFacilities_paymentCheque)).click();
				}
				else
				{
					System.out.println("Checque payment facility for other clinic is not checked");
				}
				if(othrClinicPremiumServiceStatus.equalsIgnoreCase("true"))
				{
					driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicFacilities_premiumService)).click();
				}
				else
				{
					System.out.println("Premium service facility for other clinic is not checked");
				}
			}
			else
			{
				System.out.println("Other clinic facility is not given for this doctor");
			}
			Thread.sleep(2000);
			driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicSave)).click();
		}
		else
		{
			System.out.println("There is no other clinic associated for this doctor.");
		}
		Thread.sleep(2000);
	} //Practice other clinic method end ****
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to enter default clinic information under practice tab of doctor on admin add doctor screen
	 * @ Param			: defaultClinicName, defaultClinicFee, practiceStartDate
	 * @ return			: NA
	 */
	public void Enter_practiceDetails_DefaultClinic(String defaultClinicName, String defaultClinicFee, String practiceStartDate, String zoyloFacilitationFee)
	{
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.defaultClinicTab);
		driver.findElement(By.xpath(Elements_NewAdminDoctors.defaultClinicTab)).click();
		Browser.waitFortheID(Elements_NewAdminDoctors.defaultClinicName);
		driver.findElement(By.id(Elements_NewAdminDoctors.defaultClinicName)).sendKeys(defaultClinicName);
		driver.findElement(By.id(Elements_NewAdminDoctors.defaultClinicconsultationFee)).sendKeys(defaultClinicFee);
		driver.findElement(By.id(Elements_NewAdminDoctors.defaultClinicPracticeStartDate)).clear();
		driver.findElement(By.id(Elements_NewAdminDoctors.defaultClinicPracticeStartDate)).click();
		driver.findElement(By.id(Elements_NewAdminDoctors.defaultClinicPracticeStartDate)).clear();
		driver.findElement(By.id(Elements_NewAdminDoctors.defaultClinicPracticeStartDate)).sendKeys(practiceStartDate);
		driver.findElement(By.id(Elements_NewAdminDoctors.defaultClinicFacilitationCharges)).sendKeys(zoyloFacilitationFee);
	} //Practice default clinic method end ****
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to enter generic info method end for hospital under practice tab of doctor on admin add doctor screen
	 * @ Param			: practiceStartDate
	 * @ return			: NA
	 */
	public void Enter_HospitalpracticeGenericDetails_DefaultClinic(String practiceStartDate) throws Exception
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.practiceTab)).click();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.hospitalGenericInfo);
		//driver.findElement(By.id(Elements_NewAdminDoctors.defaultClinicPracticeStartDate)).clear();
		driver.findElement(By.id(Elements_NewAdminDoctors.defaultClinicPracticeStartDate)).click();
		driver.findElement(By.id(Elements_NewAdminDoctors.defaultClinicPracticeStartDate)).clear();
		driver.findElement(By.id(Elements_NewAdminDoctors.defaultClinicPracticeStartDate)).sendKeys(practiceStartDate);
		Thread.sleep(1000);
	} //Practice generic info method end for hospital****
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to enter vacation information under practice tab of doctor on admin add doctor screen
	 * @ Param			: vacationStatus, vacationStartDate
	 * @ return			: NA
	 */
	public void Enter_practiceDetails_Vacation(String vacationStatus, String vacationStartDate, String vacationEndDate) throws Exception
	{
		if(vacationStatus.equalsIgnoreCase("true"))
		{
			driver.findElement(By.xpath(Elements_NewAdminDoctors.VacationTab)).click();
			Browser.waitFortheElementXpath(Elements_NewAdminDoctors.vacationAddButton);
			driver.findElement(By.xpath(Elements_NewAdminDoctors.vacationAddButton)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.vacationStartDate);
			driver.findElement(By.id(Elements_NewAdminDoctors.vacationStartDate)).click();
			driver.findElement(By.id(Elements_NewAdminDoctors.vacationStartDate)).clear();
			driver.findElement(By.id(Elements_NewAdminDoctors.vacationStartDate)).sendKeys(vacationStartDate);
			driver.findElement(By.id(Elements_NewAdminDoctors.vacationEndDate)).click();
			driver.findElement(By.id(Elements_NewAdminDoctors.vacationEndDate)).clear();
			driver.findElement(By.id(Elements_NewAdminDoctors.vacationEndDate)).sendKeys(vacationEndDate);
			driver.findElement(By.id(Elements_NewAdminDoctors.vacationActiveCheckBox)).click();
			driver.findElement(By.xpath(Elements_NewAdminDoctors.vacationSave)).click();
		}
		else
		{
			System.out.println("There is no vacation set for this doctor");
		}
		Thread.sleep(1500);
	} //Practice vacation method end ***
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to enter hospital information under practice tab of doctor on admin add doctor screen
	 * @ Param			: hospitalWorkTypeStatus, hospitalName, hospitalFee, zfcForHospital
	 * @ return			: NA
	 */
	public void Enter_practiceDetails_HospitalInfo(String hospitalWorkTypeStatus, String hospitalName, String hospitalFee, String zfcForHospital) throws Exception
	{
		if(hospitalWorkTypeStatus.equalsIgnoreCase("true"))
		{
			driver.findElement(By.xpath(Elements_NewAdminDoctors.HospitalTab)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.hospitaladdHospitalBtn);
			driver.findElement(By.id(Elements_NewAdminDoctors.hospitaladdHospitalBtn)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.hospitalAddHeading);
			driver.findElement(By.id(Elements_NewAdminDoctors.hospitalpopUpName)).click();
			Thread.sleep(3000);
			//Browser.actionbyid(Elements_NewAdminDoctors.hospitalpopUpName, hospitalName);
			Browser.selectbyID(Elements_NewAdminDoctors.hospitalpopUpName, hospitalName);
			driver.findElement(By.id(Elements_NewAdminDoctors.hospitalpopUpConsultationFee)).sendKeys(hospitalFee);
			driver.findElement(By.id(Elements_NewAdminDoctors.hospitalpopUpzoyloCharges)).sendKeys(zfcForHospital);
			driver.findElement(By.id(Elements_NewAdminDoctors.hospitalpopUpActiveCheckBox)).click();
			driver.findElement(By.id(Elements_NewAdminDoctors.hospitalpopUpSaveButton)).click();
		}
		else
		{
			System.out.println("There is no hospital associated against this doctor");
		}
		Thread.sleep(2000);
	} //Practice hospital info method end ***
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to enter hospital information under practice tab of doctor on admin add doctor screen
	 * @ Param			: hospitalWorkTypeStatus, hospitalName, hospitalFee, zfcForHospital
	 * @ return			: NA
	 */
	public void Enter_hospitalDoctor_practiceDetails_HospitalInfo(String hospitalWorkTypeStatus, String hospitalName, String hospitalFee, String zfcForHospital) throws Exception
	{
		if(hospitalWorkTypeStatus.equalsIgnoreCase("true"))
		{
			driver.findElement(By.xpath(Elements_NewAdminDoctors.HospitalTab)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.hospitaladdHospitalBtn);
			driver.findElement(By.id(Elements_NewAdminDoctors.hospitaladdHospitalBtn)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.hospitalAddHeading);
			driver.findElement(By.id(Elements_NewAdminDoctors.hospitalpopUpName)).click();
			Thread.sleep(3000);
			//Browser.actionbyid(Elements_NewAdminDoctors.hospitalpopUpName, hospitalName);
			Browser.selectbyID(Elements_NewAdminDoctors.hospitalpopUpName, hospitalName);
			driver.findElement(By.id(Elements_NewAdminDoctors.hospitalpopUpConsultationFee)).sendKeys(hospitalFee);
			driver.findElement(By.id(Elements_NewAdminDoctors.hospitalpopUpzoyloCharges)).sendKeys(zfcForHospital);
			driver.findElement(By.id(Elements_NewAdminDoctors.hospitalpopUpActiveCheckBox)).click();
			driver.findElement(By.id(Elements_NewAdminDoctors.hospitalpopUpDefaultCheckBox)).click();
			driver.findElement(By.id(Elements_NewAdminDoctors.hospitalpopUpSaveButton)).click();
		}
		else
		{
			System.out.println("There is no hospital associated against this doctor");
		}
		Thread.sleep(2000);
	} //Practice hospital info method end for hospital***
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to upload doctor default image under practice tab of doctor on admin add doctor screen
	 * @ Param			: imageURL
	 * @ return			: NA
	 */
	public void Enter_practiceDetails_GalleryInfo(String imageURL) throws Exception
	{
		String current = System.getProperty("user.dir");
		driver.findElement(By.xpath(Elements_NewAdminDoctors.galleryTab)).click();
		Browser.waitFortheID(Elements_NewAdminDoctors.galleryUploadButton);
		System.out.println("image path"+imageURL);
		driver.findElement(By.id(Elements_NewAdminDoctors.galleryUploadButton)).sendKeys(current+imageURL);
		Thread.sleep(2000);
	} //Practice gallery info method end ***
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to add doctor workTimings on admin add doctor screen
	 * @ Param			: mondayStatus,  MondayworkType,  isMondayHospitalTrue,  mondayHospitalName,  isMondayClinicTrue,  mondayClinicName,  mondayStartTime,  mondayEndTime,  tuesdayStatus,  tuesdayworkType,  istuesdayHospitalTrue,  tuesdayHospitalName,  istuesdayClinicTrue,  tuesdayClinicName,  tuesdayStartTime,  tuesdayEndTime,  wednesdayStatus,  wednesdayworkType,  iswednesdayHospitalTrue,  wednesdayHospitalName,  iswednesdayClinicTrue,  wednesdayClinicName,  wednesdayStartTime,  wednesdayEndTime,  thursdayStatus,  thursdayworkType,  isthursdayHospitalTrue,  thursdayHospitalName,  isthursdayClinicTrue,  thursdayClinicName,  thursdayStartTime,  thursdayEndTime,  fridayStatus,  fridayworkType,  isfridayHospitalTrue,  fridayHospitalName,  isfridayClinicTrue,  fridayClinicName,  fridayStartTime,  fridayEndTime
	 * @ return			: NA
	 */
	public void Enter_workDaysInfo(String mondayStatus, String MondayworkType, String isMondayHospitalTrue, String mondayHospitalName, String isMondayClinicTrue, String mondayClinicName, String mondayStartTime, String mondayEndTime, String tuesdayStatus, String tuesdayworkType, String istuesdayHospitalTrue, String tuesdayHospitalName, String istuesdayClinicTrue, String tuesdayClinicName, String tuesdayStartTime, String tuesdayEndTime, String wednesdayStatus, String wednesdayworkType, String iswednesdayHospitalTrue, String wednesdayHospitalName, String iswednesdayClinicTrue, String wednesdayClinicName, String wednesdayStartTime, String wednesdayEndTime, String thursdayStatus, String thursdayworkType, String isthursdayHospitalTrue, String thursdayHospitalName, String isthursdayClinicTrue, String thursdayClinicName, String thursdayStartTime, String thursdayEndTime, String fridayStatus, String fridayworkType, String isfridayHospitalTrue, String fridayHospitalName, String isfridayClinicTrue, String fridayClinicName, String fridayStartTime, String fridayEndTime) throws Exception
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.workDaysTab)).click();
		//Monday
		if(mondayStatus.equalsIgnoreCase("true"))
		{
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_MondayTab)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_MondayLunchStart);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_MondayActiveCheckBox)).click();
			driver.findElement(By.xpath(Elements_NewAdminDoctors.workDays_MondayAddSlotsBtn)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_workType);
			if(MondayworkType.equalsIgnoreCase("hospital"))
			{
				Browser.selectbyID(Elements_NewAdminDoctors.workDays_workType, "Hospital");
				if(isMondayHospitalTrue.equalsIgnoreCase("true"))
				{
					Browser.selectbyID(Elements_NewAdminDoctors.workDays_hospitalType, mondayHospitalName);
				}
				else
				{
					System.out.println("Selected hospital type and mapped to default clinic.");
				}
			}
			else
			{
				Browser.selectbyID(Elements_NewAdminDoctors.workDays_workType, "Other Clinics");
				if(isMondayClinicTrue.equalsIgnoreCase("true"))
				{
					Browser.selectbyID(Elements_NewAdminDoctors.workDays_ClinicType, mondayClinicName);
				}
				else
				{
					System.out.println("Selected clinic type and mapped to default clinic.");
				}
			}
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workStartTime)).sendKeys(mondayStartTime);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workEndTime)).sendKeys(mondayEndTime);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_ActiveCheckBox)).click();
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workTimeSave)).click();
			Thread.sleep(1500);
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_TuesdayTab);
		}
		else
		{
			System.out.println("Monday slots are not provided for this doctor");
		} // Monday condition end
		//Tuesday
		if(tuesdayStatus.equalsIgnoreCase("true"))
		{
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_TuesdayTab)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_TuesdayActiveCheckBox);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_TuesdayActiveCheckBox)).click();
			driver.findElement(By.xpath(Elements_NewAdminDoctors.workDays_TuesdayAddSlotsBtn)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_workType);
			if(tuesdayworkType.equalsIgnoreCase("hospital"))
			{
				Browser.selectbyID(Elements_NewAdminDoctors.workDays_workType, "Hospital");
				if(istuesdayHospitalTrue.equalsIgnoreCase("true"))
				{
					Browser.selectbyID(Elements_NewAdminDoctors.workDays_hospitalType, tuesdayHospitalName);
				}
				else
				{
					System.out.println("Selected hospital type and mapped to default clinic.");
				}
			}
			else
			{
				Browser.selectbyID(Elements_NewAdminDoctors.workDays_workType, "Other Clinics");
				if(istuesdayClinicTrue.equalsIgnoreCase("true"))
				{
					Browser.selectbyID(Elements_NewAdminDoctors.workDays_ClinicType, tuesdayClinicName);
				}
				else
				{
					System.out.println("Selected clinic type and mapped to default clinic.");
				}
			}
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workStartTime)).sendKeys(tuesdayStartTime);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workEndTime)).sendKeys(tuesdayEndTime);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_ActiveCheckBox)).click();
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workTimeSave)).click();
			Thread.sleep(1500);
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_WednesdayTab);
		}
		else
		{
			System.out.println("Tuesday slots are not provided for this doctor");
		} //Tuesday condition end
		//Wednesday
		if(wednesdayStatus.equalsIgnoreCase("true"))
		{
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_WednesdayTab)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_WednesdayActiveCheckBox);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_WednesdayActiveCheckBox)).click();
			driver.findElement(By.xpath(Elements_NewAdminDoctors.workDays_WednesdayAddSlotsBtn)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_workType);
			if(wednesdayworkType.equalsIgnoreCase("hospital"))
			{
				Browser.selectbyID(Elements_NewAdminDoctors.workDays_workType, "Hospital");
				if(iswednesdayHospitalTrue.equalsIgnoreCase("true"))
				{
					Browser.selectbyID(Elements_NewAdminDoctors.workDays_hospitalType, wednesdayHospitalName);
				}
				else
				{
					System.out.println("Selected hospital type and mapped to default clinic.");
				}
			}
			else
			{
				Browser.selectbyID(Elements_NewAdminDoctors.workDays_workType, "Other Clinics");
				if(iswednesdayClinicTrue.equalsIgnoreCase("true"))
				{
					Browser.selectbyID(Elements_NewAdminDoctors.workDays_ClinicType, wednesdayClinicName);
				}
				else
				{
					System.out.println("Selected clinic type and mapped to default clinic.");
				}
			}
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workStartTime)).sendKeys(wednesdayStartTime);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workEndTime)).sendKeys(wednesdayEndTime);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_ActiveCheckBox)).click();
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workTimeSave)).click();
			Thread.sleep(1500);
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_ThursdayTab);
		}
		else
		{
			System.out.println("Wednesday slots are not provided for this doctor");
		} //Wednesday condition end
		//Thursday
		if(thursdayStatus.equalsIgnoreCase("true"))
		{
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_ThursdayTab)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_ThursdayActiveCheckBox);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_ThursdayActiveCheckBox)).click();
			driver.findElement(By.xpath(Elements_NewAdminDoctors.workDays_ThursdayAddSlotsBtn)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_workType);
			if(thursdayworkType.equalsIgnoreCase("hospital"))
			{
				Browser.selectbyID(Elements_NewAdminDoctors.workDays_workType, "Hospital");
				if(isthursdayHospitalTrue.equalsIgnoreCase("true"))
				{
					Browser.selectbyID(Elements_NewAdminDoctors.workDays_hospitalType, thursdayHospitalName);
				}
				else
				{
					System.out.println("Selected hospital type and mapped to default clinic.");
				}
			}
			else
			{
				Browser.selectbyID(Elements_NewAdminDoctors.workDays_workType, "Other Clinics");
				if(isthursdayClinicTrue.equalsIgnoreCase("true"))
				{
					Browser.selectbyID(Elements_NewAdminDoctors.workDays_ClinicType, thursdayClinicName);
				}
				else
				{
					System.out.println("Selected clinic type and mapped to default clinic.");
				}
			}
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workStartTime)).sendKeys(thursdayStartTime);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workEndTime)).sendKeys(thursdayEndTime);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_ActiveCheckBox)).click();
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workTimeSave)).click();
			Thread.sleep(1500);
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_FridayTab);
		}
		else
		{
			System.out.println("thursday slots are not provided for this doctor");
		} //Thursday condition end
		//Friday
		if(fridayStatus.equalsIgnoreCase("true"))
		{
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_FridayTab)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_FridayActiveCheckBox);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_FridayActiveCheckBox)).click();
			driver.findElement(By.xpath(Elements_NewAdminDoctors.workDays_FridayAddSlotsBtn)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_workType);
			if(fridayworkType.equalsIgnoreCase("hospital"))
			{
				Browser.selectbyID(Elements_NewAdminDoctors.workDays_workType, "Hospital");
				if(isfridayHospitalTrue.equalsIgnoreCase("true"))
				{
					Browser.selectbyID(Elements_NewAdminDoctors.workDays_hospitalType, fridayHospitalName);
				}
				else
				{
					System.out.println("Selected hospital type and mapped to default clinic.");
				}
			}
			else
			{
				Browser.selectbyID(Elements_NewAdminDoctors.workDays_workType, "Other Clinics");
				if(isfridayClinicTrue.equalsIgnoreCase("true"))
				{
					Browser.selectbyID(Elements_NewAdminDoctors.workDays_ClinicType, fridayClinicName);
				}
				else
				{
					System.out.println("Selected clinic type and mapped to default clinic.");
				}
			}
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workStartTime)).sendKeys(fridayStartTime);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workEndTime)).sendKeys(fridayEndTime);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_ActiveCheckBox)).click();
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workTimeSave)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_SaturdayTab);
		}
		else
		{
			System.out.println("Friday slots are not provided for this doctor");
		} //Friday condition end
		Thread.sleep(2000);
	} //work days info method end ***
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to add hospital doctor workTimings on admin add doctor screen
	 * @ Param			: mondayStatus,  MondayworkType,  isMondayHospitalTrue,  mondayHospitalName,  isMondayClinicTrue,  mondayClinicName,  mondayStartTime,  mondayEndTime,  tuesdayStatus,  tuesdayworkType,  istuesdayHospitalTrue,  tuesdayHospitalName,  istuesdayClinicTrue,  tuesdayClinicName,  tuesdayStartTime,  tuesdayEndTime,  wednesdayStatus,  wednesdayworkType,  iswednesdayHospitalTrue,  wednesdayHospitalName,  iswednesdayClinicTrue,  wednesdayClinicName,  wednesdayStartTime,  wednesdayEndTime,  thursdayStatus,  thursdayworkType,  isthursdayHospitalTrue,  thursdayHospitalName,  isthursdayClinicTrue,  thursdayClinicName,  thursdayStartTime,  thursdayEndTime,  fridayStatus,  fridayworkType,  isfridayHospitalTrue,  fridayHospitalName,  isfridayClinicTrue,  fridayClinicName,  fridayStartTime,  fridayEndTime
	 * @ return			: NA
	 */
	public void Enter_hospitalDoctor_workDaysInfo(String mondayStatus, String mondayHospitalName, String mondayStartTime, String mondayEndTime, String tuesdayStatus, String tuesdayHospitalName, String tuesdayStartTime, String tuesdayEndTime, String wednesdayStatus, String wednesdayHospitalName, String wednesdayStartTime, String wednesdayEndTime, String thursdayStatus, String thursdayHospitalName, String thursdayStartTime, String thursdayEndTime, String fridayStatus, String fridayHospitalName, String fridayStartTime, String fridayEndTime) throws Exception
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.workDaysTab)).click();
		//Monday
		if(mondayStatus.equalsIgnoreCase("true"))
		{
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_MondayTab)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_MondayLunchStart);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_MondayActiveCheckBox)).click();
			driver.findElement(By.xpath(Elements_NewAdminDoctors.workDays_MondayAddSlotsBtn)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_ActiveCheckBox);
			Browser.selectbyID(Elements_NewAdminDoctors.workDays_hospitalType, mondayHospitalName);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workStartTime)).sendKeys(mondayStartTime);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workEndTime)).sendKeys(mondayEndTime);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_ActiveCheckBox)).click();
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workTimeSave)).click();
			Thread.sleep(1500);
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_TuesdayTab);
		}
		else
		{
			System.out.println("Monday slots are not provided for this doctor");
		} // Monday condition end
		//Tuesday
		if(tuesdayStatus.equalsIgnoreCase("true"))
		{
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_TuesdayTab)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_TuesdayActiveCheckBox);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_TuesdayActiveCheckBox)).click();
			driver.findElement(By.xpath(Elements_NewAdminDoctors.workDays_TuesdayAddSlotsBtn)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_ActiveCheckBox);
			Browser.selectbyID(Elements_NewAdminDoctors.workDays_hospitalType, tuesdayHospitalName);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workStartTime)).sendKeys(tuesdayStartTime);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workEndTime)).sendKeys(tuesdayEndTime);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_ActiveCheckBox)).click();
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workTimeSave)).click();
			Thread.sleep(1500);
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_WednesdayTab);
		}
		else
		{
			System.out.println("Tuesday slots are not provided for this doctor");
		} //Tuesday condition end
		//Wednesday
		if(wednesdayStatus.equalsIgnoreCase("true"))
		{
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_WednesdayTab)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_WednesdayActiveCheckBox);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_WednesdayActiveCheckBox)).click();
			driver.findElement(By.xpath(Elements_NewAdminDoctors.workDays_WednesdayAddSlotsBtn)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_ActiveCheckBox);
			Browser.selectbyID(Elements_NewAdminDoctors.workDays_hospitalType, wednesdayHospitalName);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workStartTime)).sendKeys(wednesdayStartTime);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workEndTime)).sendKeys(wednesdayEndTime);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_ActiveCheckBox)).click();
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workTimeSave)).click();
			Thread.sleep(1500);
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_ThursdayTab);
		}
		else
		{
			System.out.println("Wednesday slots are not provided for this doctor");
		} //Wednesday condition end
		//Thursday
		if(thursdayStatus.equalsIgnoreCase("true"))
		{
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_ThursdayTab)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_ThursdayActiveCheckBox);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_ThursdayActiveCheckBox)).click();
			driver.findElement(By.xpath(Elements_NewAdminDoctors.workDays_ThursdayAddSlotsBtn)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_ActiveCheckBox);
			Browser.selectbyID(Elements_NewAdminDoctors.workDays_hospitalType, thursdayHospitalName);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workStartTime)).sendKeys(thursdayStartTime);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workEndTime)).sendKeys(thursdayEndTime);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_ActiveCheckBox)).click();
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workTimeSave)).click();
			Thread.sleep(1500);
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_FridayTab);
		}
		else
		{
			System.out.println("thursday slots are not provided for this doctor");
		} //Thursday condition end
		//Friday
		if(fridayStatus.equalsIgnoreCase("true"))
		{
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_FridayTab)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_FridayActiveCheckBox);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_FridayActiveCheckBox)).click();
			driver.findElement(By.xpath(Elements_NewAdminDoctors.workDays_FridayAddSlotsBtn)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_ActiveCheckBox);
			Browser.selectbyID(Elements_NewAdminDoctors.workDays_hospitalType, fridayHospitalName);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workStartTime)).sendKeys(fridayStartTime);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workEndTime)).sendKeys(fridayEndTime);
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_ActiveCheckBox)).click();
			driver.findElement(By.id(Elements_NewAdminDoctors.workDays_workTimeSave)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.workDays_SaturdayTab);
		}
		else
		{
			System.out.println("Friday slots are not provided for this doctor");
		} //Friday condition end
		Thread.sleep(2000);
	} //work days info method end for hospital***
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to add doctor's default clinic facilities on admin add doctor screen
	 * @ Param			:  FacilityStatus,  AmbulanceStatus,  EmergencyStatus,  BikeParkStatus,  CarParkStatus,  PayCreditStatus,  PayDebitStatus,  PayCashStatus,  PayOnlineStatus,  PayChecqueStatus,  PremiumServiceStatus
	 * @ return			: NA
	 */
	public void Enter_defaultFacilities(String FacilityStatus, String AmbulanceStatus, String EmergencyStatus, String BikeParkStatus, String CarParkStatus, String PayCreditStatus, String PayDebitStatus, String PayCashStatus, String PayOnlineStatus, String PayChecqueStatus, String PremiumServiceStatus)
	{
		
		if(FacilityStatus.equalsIgnoreCase("true"))
		{
			driver.findElement(By.id(Elements_NewAdminDoctors.facilitiesTab)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.facilitiesTab_ambulance);
			if(AmbulanceStatus.equalsIgnoreCase("true"))
			{
				driver.findElement(By.id(Elements_NewAdminDoctors.facilitiesTab_ambulance)).click();
			}
			else
			{
				System.out.println("Ambulance facility is not checked");
			}
			if(EmergencyStatus.equalsIgnoreCase("true"))
			{
				driver.findElement(By.id(Elements_NewAdminDoctors.facilitiesTab_emergency)).click();
			}
			else
			{
				System.out.println("Emergency facility is not checked");
			}
			if(BikeParkStatus.equalsIgnoreCase("true"))
			{
				driver.findElement(By.id(Elements_NewAdminDoctors.facilitiesTab_bikePark)).click();
			}
			else
			{
				System.out.println("Bike parking facility is not checked");
			}
			if(CarParkStatus.equalsIgnoreCase("true"))
			{
				driver.findElement(By.id(Elements_NewAdminDoctors.facilitiesTab_carPark)).click();
			}
			else
			{
				System.out.println("Car parking facility is not checked");
			}
			if(PayCreditStatus.equalsIgnoreCase("true"))
			{
				driver.findElement(By.id(Elements_NewAdminDoctors.facilitiesTab_paymentCredit)).click();
			}
			else
			{
				System.out.println("Credit payment facility is not checked");
			}
			if(PayDebitStatus.equalsIgnoreCase("true"))
			{
				driver.findElement(By.id(Elements_NewAdminDoctors.facilitiesTab_paymentDebit)).click();
			}
			else
			{
				System.out.println("Debit payment facility is not checked");
			}
			if(PayCashStatus.equalsIgnoreCase("true"))
			{
				driver.findElement(By.id(Elements_NewAdminDoctors.facilitiesTab_paymentCash)).click();
			}
			else
			{
				System.out.println("Cash payment facility is not checked");
			}
			if(PayOnlineStatus.equalsIgnoreCase("true"))
			{
				driver.findElement(By.id(Elements_NewAdminDoctors.facilitiesTab_paymentOnline)).click();
			}
			else
			{
				System.out.println("Online payment facility is not checked");
			}
			if(PayChecqueStatus.equalsIgnoreCase("true"))
			{
				driver.findElement(By.id(Elements_NewAdminDoctors.facilitiesTab_paymentChecque)).click();
			}
			else
			{
				System.out.println("Checque payment facility is not checked");
			}
			if(PremiumServiceStatus.equalsIgnoreCase("true"))
			{
				driver.findElement(By.id(Elements_NewAdminDoctors.facilitiesTab_paymentPremiumService)).click();
			}
			else
			{
				System.out.println("Premium service facility is not checked");
			}
		}
		else
		{
			System.out.println("Default clinic facility is not given for this doctor");
		}
	} //Facility info method end ***
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to add doctor's default clinic address under address tab on admin add doctor screen
	 * @ Param			: Country, State, City, completeAddress, Locality, pin, longitude, latitude
	 * @ return			: NA
	 */
	public void Enter_addressInfo(String Country, String State, String City, String completeAddress, String Locality, String pin, String longitude, String latitude)
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.addressTab)).click();
		Browser.waitFortheID(Elements_NewAdminDoctors.addressTab_Country);
		driver.findElement(By.id(Elements_NewAdminDoctors.addressTab_Country)).click();
		Browser.selectbyID(Elements_NewAdminDoctors.addressTab_CountrySelectID, Country);
		driver.findElement(By.id(Elements_NewAdminDoctors.addressTab_State)).click();
		Browser.selectbyID(Elements_NewAdminDoctors.addressTab_StateSelectID, State);
		driver.findElement(By.id(Elements_NewAdminDoctors.addressTab_City)).click();
		Browser.selectbyID(Elements_NewAdminDoctors.addressTab_CitySelectID, City);
		driver.findElement(By.id(Elements_NewAdminDoctors.addressTab_completeAddress)).sendKeys(completeAddress);
		driver.findElement(By.id(Elements_NewAdminDoctors.addressTab_locality)).sendKeys(Locality);
		driver.findElement(By.id(Elements_NewAdminDoctors.addressTab_pinCode)).sendKeys(pin);
		driver.findElement(By.id(Elements_NewAdminDoctors.addressTab_longitude)).sendKeys(longitude);
		driver.findElement(By.id(Elements_NewAdminDoctors.addressTab_latitude)).sendKeys(latitude);
	} //Address info method end ***
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click Submit button on admin add doctor's screen
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void clickSubmitDoctor()
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.doctorSave)).click();
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to enter emailID in search bar on admin doctor's screen
	 * @ Param			: emailID
	 * @ return			: NA
	 */
	public void searchDoctorbyEmailID(String emailID)
	{
		driver.findElement(By.xpath(Elements_NewAdminDoctors.SearchTab)).sendKeys(emailID);
		Browser.waitforTextbyxpath(Elements_NewAdminDoctors.searchResultOnTable, emailID);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click on edit button for doctor on admin doctor's screen
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void clickEditbutton()
	{
		driver.findElement(By.xpath(Elements_NewAdminDoctors.EditButton)).click();
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to edit seo information of doctor on admin edit doctor's screen
	 * @ Param			: isSEOInfoTrue
	 * @ return			: NA
	 */
	public void seoInfoEdit(String isSEOInfoTrue, String metaTitle)
	{
		if(isSEOInfoTrue.equalsIgnoreCase("true"))
		{
			driver.findElement(By.id(Elements_NewAdminDoctors.seoInfoTab)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.seoInfoTab_metaTitle);
			driver.findElement(By.id(Elements_NewAdminDoctors.seoInfoTab_metaTitle)).clear();
			driver.findElement(By.id(Elements_NewAdminDoctors.seoInfoTab_metaTitle)).sendKeys(metaTitle);
		}
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click doctor references on admin screen
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void click_doctorReferences()
	{
		driver.findElement(By.xpath(Elements_NewAdminDoctors.doctor_referenceTabAssertion)).click();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_referencesOption);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click practice option of doctor references on admin screen
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void click_doctorReferencePracticeTab()
	{
		driver.findElement(By.xpath(Elements_NewAdminDoctors.doctor_reference_practice)).click();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_reference_practiceHeader);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click practice add button of doctor references on admin screen
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void click_doctorReference_AddBtn()
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.Add_doctor_reference)).click();
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to add practice details of doctor references on admin screen
	 * @ Param			: practiceName, practiceDescription
	 * @ return			: NA
	 */
	public void Enter_practiceDetails(String practiceName, String practiceDescription) throws Exception
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.doctor_reference_Name)).sendKeys(practiceName+Browser.randomalphabets());
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDoctors.doctor_reference_Description)).sendKeys(practiceDescription);
		driver.findElement(By.id(Elements_NewAdminDoctors.doctor_reference_ActiveCheckBox)).click();
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click save button for practice add of doctor references on admin screen
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void click_practiceSaveBtn()
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.doctor_reference_practiceSave)).click();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_reference_practiceHeader);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click save button for edit practice add of doctor references on admin screen
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void click_editPracticeSaveBtn()
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.doctor_reference_updatePracticeSave)).click();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_reference_practiceHeader);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to enter practiceName in search bar on admin doctor's practice screen
	 * @ Param			: practiceName
	 * @ return			: NA
	 */
	public void searchDoctorPracticeByName(String practiceName)
	{
		driver.findElement(By.xpath(Elements_NewAdminDoctors.SearchTab)).sendKeys(practiceName);
		Browser.waitforTextbyxpath(Elements_NewAdminDoctors.searchResultOnTable, practiceName);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click qualification option of doctor references on admin screen
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void click_doctorReferenceQualificationTab()
	{
		driver.findElement(By.xpath(Elements_NewAdminDoctors.doctor_reference_qualification)).click();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_reference_qualificationHeader);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to add qualification details of doctor references on admin screen
	 * @ Param			: practiceName, practiceDescription
	 * @ return			: NA
	 */
	public void Enter_QualificationDetails(String qualificationName, String qualificationDescription) throws Exception
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.doctor_reference_Name)).sendKeys(qualificationName+Browser.randomalphabets());
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDoctors.doctor_reference_Description)).sendKeys(qualificationDescription);
		driver.findElement(By.id(Elements_NewAdminDoctors.doctor_reference_ActiveCheckBox)).click();
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click save button for qualification add of doctor references on admin screen
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void click_qualificationSaveBtn()
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.doctor_reference_qualificationSave)).click();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_reference_qualificationHeader);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to enter qualification in search bar on admin doctor's practice screen
	 * @ Param			: practiceName
	 * @ return			: NA
	 */
	public void searchDoctorQualificationByName(String qualificationName)
	{
		driver.findElement(By.xpath(Elements_NewAdminDoctors.SearchTab)).sendKeys(qualificationName);
		Browser.waitforTextbyxpath(Elements_NewAdminDoctors.searchResultOnTable, qualificationName);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click save button for edit qualification of doctor references on admin screen
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void click_editQualificationSaveBtn()
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.doctor_reference_updateQualificationSave)).click();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_reference_qualificationHeader);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click specialition option of doctor references on admin screen
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void click_doctorReferenceSpecialitionTab()
	{
		driver.findElement(By.xpath(Elements_NewAdminDoctors.doctor_reference_specialisation)).click();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_reference_specialisationHeader);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to add specialisation details of doctor references on admin screen
	 * @ Param			: practiceName, practiceDescription
	 * @ return			: NA
	 */
	public void Enter_specialisationDetails(String specialisationName, String specialisationDescription) throws Exception
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.doctor_reference_Name)).sendKeys(specialisationName+Browser.randomalphabets());
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDoctors.doctor_reference_Description)).sendKeys(specialisationDescription);
		driver.findElement(By.id(Elements_NewAdminDoctors.doctor_reference_ActiveCheckBox)).click();
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click save button for specialisation add of doctor references on admin screen
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void click_specialisationSaveBtn()
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.doctor_reference_specialisationSave)).click();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_reference_specialisationHeader);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to enter specialisation in search bar on admin doctor's specilisation screen
	 * @ Param			: specialisationName
	 * @ return			: NA
	 */
	public void searchDoctorspecialisationByName(String specialisationName)
	{
		driver.findElement(By.xpath(Elements_NewAdminDoctors.SearchTab)).sendKeys(specialisationName);
		Browser.waitforTextbyxpath(Elements_NewAdminDoctors.searchResultOnTable, specialisationName);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click save button for edit specialisation of doctor references on admin screen
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void click_editSpecialisationSaveBtn()
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.doctor_reference_updateSpecialisationSave)).click();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_reference_specialisationHeader);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click tag option of doctor references on admin screen
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void click_doctorReferenceTagTab()
	{
		driver.findElement(By.xpath(Elements_NewAdminDoctors.doctor_reference_tag)).click();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_reference_tagHeader);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to add tag details of doctor references on admin screen
	 * @ Param			: practiceName, practiceDescription
	 * @ return			: NA
	 */
	public void Enter_tagDetails(String tagName, String tagDescription) throws Exception
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.doctor_reference_Name)).sendKeys(tagName+Browser.randomalphabets());
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDoctors.doctor_reference_Description)).sendKeys(tagDescription);
		driver.findElement(By.id(Elements_NewAdminDoctors.doctor_reference_ActiveCheckBox)).click();
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click save button for tag add of doctor references on admin screen
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void click_tagSaveBtn()
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.doctor_reference_tagSave)).click();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_reference_tagHeader);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to enter tag in search bar on admin doctor's tag screen
	 * @ Param			: specialisationName
	 * @ return			: NA
	 */
	public void searchDoctorTagByName(String tagName)
	{
		driver.findElement(By.xpath(Elements_NewAdminDoctors.SearchTab)).sendKeys(tagName);
		Browser.waitforTextbyxpath(Elements_NewAdminDoctors.searchResultOnTable, tagName);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click save button for edit tag of doctor references on admin screen
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void click_editTagSaveBtn()
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.doctor_reference_updateTagSave)).click();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_reference_tagHeader);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click appointments tab and completed appointments
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void click_aptTabToCompletedApt()
	{
		driver.findElement(By.xpath(Elements_NewAdminDoctors.doctor_AppointmentTabAssertion)).click();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_appointmentCompleted);
		driver.findElement(By.xpath(Elements_NewAdminDoctors.doctor_appointmentCompleted)).click();
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.doctor_appointmentHeader);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to search appointments by ID
	 * @ Param			: APTID
	 * @ return			: NA
	 */
	public void search_aptTbyAPTID(String APTID) throws InterruptedException
	{
		driver.findElement(By.xpath(Elements_NewAdminDoctors.SearchTab)).sendKeys(APTID);
		Thread.sleep(2000);
		//Browser.waitforTextbyxpath(Elements_NewAdminDoctors.searchResultOnTable, APTID);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to change apt status to reschedule
	 * @ Param			: status, notification
	 * @ return			: NA
	 */
	public void doctorAptStatusChangeToReschedule(String status, String Notification) throws Exception
	{
		if(driver.findElements(By.xpath(Elements_NewAdminDoctors.doctor_appointmentStatusDropDown)).size()!=0)
		{
			Browser.scrollbyxpath(Elements_NewAdminDoctors.doctor_appointmentStatusDropDown);
			Browser.horizontalScroll();
			//driver.findElement(By.xpath("(//select[@class='appointmentsStatusChangeId'])[1]")).click();
			Thread.sleep(2000);
			Browser.selectbyXpath(Elements_NewAdminDoctors.doctor_appointmentStatusDropDown, status);
			if(status.contains("Reschedule By Patient") || status.contains("Reschedule By Doctor"))
			{
				Browser.selectbyXpath(Elements_NewAdminDoctors.doctor_appointmentStatusDropDown, status);
				//Pop up handler
				String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
				String subWindowHandler = null;

				Set<String> handles = driver.getWindowHandles(); // get all window handles
				Iterator<String> iterator = handles.iterator();
				while (iterator.hasNext())
				{
				    subWindowHandler = iterator.next();
				}
				driver.switchTo().window(subWindowHandler); // switch to popup window
				Thread.sleep(2000);                         // perform operations on popup
				driver.findElement(By.id(Elements_NewAdminDoctors.doctor_appointmentTodayTabID)).click(); //Click today
				driver.findElement(By.id(Elements_NewAdminDoctors.doctor_appointmentReschedule_MorningTab)).click();
				//Morning
				if(driver.findElements(By.xpath(Elements_NewAdminDoctors.doctor_appointmentReschedule_MorningMsg)).size()!=0)
				{
					Thread.sleep(1000);
					driver.findElement(By.id(Elements_NewAdminDoctors.doctor_appointmentReschedule_MorningTab)).click();
					Thread.sleep(1500);
					driver.findElement(By.id(Elements_NewAdminDoctors.doctor_appointmentReschedule_NoonTab)).click(); //Choose afternoon
					//Afternoon
					if(driver.findElements(By.xpath(Elements_NewAdminDoctors.doctor_appointmentReschedule_NoonMsg)).size()!=0)
					{
						Thread.sleep(1000);
						driver.findElement(By.id(Elements_NewAdminDoctors.doctor_appointmentReschedule_NoonTab)).click();
						Thread.sleep(1500);
						driver.findElement(By.id(Elements_NewAdminDoctors.doctor_appointmentReschedule_EveTab)).click(); //Choose evening
						//Evening
						if(driver.findElements(By.xpath(Elements_NewAdminDoctors.doctor_appointmentReschedule_EveMsg)).size()!=0)
						{
							Thread.sleep(1000);
							driver.findElement(By.id(Elements_NewAdminDoctors.doctor_appointmentReschedule_EveTab)).click();
							Thread.sleep(1500);
							driver.findElement(By.id(Elements_NewAdminDoctors.doctor_appointmentReschedule_NightTab)).click(); //Choose night
							//night
							if(driver.findElements(By.xpath(Elements_NewAdminDoctors.doctor_appointmentReschedule_NightMsg)).size()!=0)
							{
								System.out.println("No slots available for current day");
							}
							else
							{
								driver.findElement(By.xpath(Elements_NewAdminDoctors.doctor_appointmentReschedule_availableSlot)).click(); //Choose time slot
								Browser.CheckNotificationMessage(Notification);
								System.out.println("Reschedule in night session");
							}
						}
						else
						{
							driver.findElement(By.xpath(Elements_NewAdminDoctors.doctor_appointmentReschedule_availableSlot)).click(); //Choose time slot
							Browser.CheckNotificationMessage(Notification);
							System.out.println("Reschedule in evening session");
						}
					}
					else
					{
						driver.findElement(By.xpath(Elements_NewAdminDoctors.doctor_appointmentReschedule_availableSlot)).click(); //Choose time slot
						Browser.CheckNotificationMessage(Notification);
						System.out.println("Reschedule in afternoon session");
					}
				}
				else
				{
					driver.findElement(By.xpath(Elements_NewAdminDoctors.doctor_appointmentReschedule_availableSlot)).click(); //Choose time slot
					Browser.CheckNotificationMessage(Notification);
					System.out.println("Reschedule in morning session");
				}
				//(//div[@class='panel-collapse collapse in']//li[@class='sp-available-slots'])[1]
				driver.switchTo().window(parentWindowHandler);  // switch back to parent window
				
			}
		}
		else
		{
			System.out.println("Status change select box is not available");
		}
	} //End of reschedule method
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to change apt status to cancel
	 * @ Param			: status, notification
	 * @ return			: NA
	 */
	public void doctorAptStatusChangeToCancel(String status, String Notification) throws Exception
	{
		if(driver.findElements(By.xpath(Elements_NewAdminDoctors.doctor_appointmentStatusDropDown)).size()!=0)
		{
			Browser.scrollbyxpath(Elements_NewAdminDoctors.doctor_appointmentStatusDropDown);
			Browser.horizontalScroll();
			Thread.sleep(2000);
		if(status.contains("Cancelled By Patient") || status.contains("Cancelled By Doctor"))
		{
			Browser.selectbyXpath(Elements_NewAdminDoctors.doctor_appointmentStatusDropDown, status);
			String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
			String subWindowHandler = null;
			Set<String> handles = driver.getWindowHandles(); // get all window handles
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext())
			{
			    subWindowHandler = iterator.next();
			}
			driver.switchTo().window(subWindowHandler); // switch to popup window
			Thread.sleep(2000);                         // perform operations on popup
			
			if(status.contains("Cancelled By Doctor"))
			{
				driver.findElement(By.id(Elements_NewAdminDoctors.doctor_appointmentCancelByDoctorSubmitBtn)).click();
			}
			else
			{
				driver.findElement(By.id(Elements_NewAdminDoctors.doctor_appointmentCancelByPatientSubmitBtn)).click();
			}
			driver.switchTo().window(parentWindowHandler);  // switch back to parent window
			//Browser.CheckNotificationMessage(Notification);
		}
		}
		else
		{
			System.out.println("Status change select box is not available");
		}
	} //End of cancel method
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to change apt status to complete
	 * @ Param			: status, notification
	 * @ return			: NA
	 */
	public void doctorAptStatusChangeToComplete(String status, String Notification) throws Exception
	{
		if (driver.findElements(By.xpath(Elements_NewAdminDoctors.doctor_appointmentStatusDropDown)).size() != 0) {
			Browser.scrollbyxpath(Elements_NewAdminDoctors.doctor_appointmentStatusDropDown);
			Browser.horizontalScroll();
			Thread.sleep(2000);
			if (status.contains("Completed")) {
				Browser.selectbyXpath(Elements_NewAdminDoctors.doctor_appointmentStatusDropDown, status);
				String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
				String subWindowHandler = null;
				Set<String> handles = driver.getWindowHandles(); // get all window handles
				Iterator<String> iterator = handles.iterator();
				while (iterator.hasNext()) {
					subWindowHandler = iterator.next();
				}
				driver.switchTo().window(subWindowHandler); // switch to popup window
				Thread.sleep(2000); // perform operations on popup

				driver.findElement(By.id(Elements_NewAdminDoctors.doctor_appointmentCompletedSubmitBtn)).click();
				driver.switchTo().window(parentWindowHandler); // switch back to
																// parent window
				//Browser.CheckNotificationMessage(Notification);
			}
		} else {
			System.out.println("Status change select box is not available");
		}
	}
} //End of class

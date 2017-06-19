package testBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import objectRepository.Elements_NewAdminDoctors;
import objectRepository.Elements_Recipients;

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
		Browser.waitFortheID("emailAddress");
		driver.findElement(By.id(Elements_Recipients.Recipient_UserName)).sendKeys(admin_user);
		driver.findElement(By.id(Elements_Recipients.Recipient_Password)).sendKeys(admin_password);
		driver.findElement(By.xpath(Elements_Recipients.Recipient_Button_Login)).click();	
	} //Admin sign in method end ***
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to signIn as an admin user with restricted permissions
	 * @ Param			: username and password
	 * @ return			: NA
	 */
	public void adminUserSignIn(String adminUserName, String adminUserPassword)
	{
		Browser.waitFortheID("emailAddress");
		driver.findElement(By.id(Elements_Recipients.Recipient_UserName)).sendKeys(adminuser_user);
		driver.findElement(By.id(Elements_Recipients.Recipient_Password)).sendKeys(adminuser_password);
		driver.findElement(By.xpath(Elements_Recipients.Recipient_Button_Login)).click();
	} //Admin user sign in method end ***
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click doctors tab on admin webmodule
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void doctorsTab_click()
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
	public void addDoctor_click()
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.addDoctorButton)).click();
		Browser.waitFortheID(Elements_NewAdminDoctors.firstName);
	} //Add doctor method end ***
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to enter generic details of doctor on admin add doctor screen
	 * @ Param			: First, middle and last names, short name, email ID, mobile Number, password
	 * @ return			: NA
	 */
	public void doctorGenericDetails_Enter(String firstName, String MiddleName, String LastName, String ShortName, String emailID, String mobileNumber, String password)
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
	public void primaryInfoDetails_Enter(String isActiveValue, String workTypeValue, String houseCallStatus, String houseCallFee, String genderValue, String DOB, String regNum, String qualification, String tag, String specialization, String practiceLine, String aboutDoc)
	{
		if(isActiveValue.equalsIgnoreCase("true"))
		{
			driver.findElement(By.id(Elements_NewAdminDoctors.Active)).click();
		}
		else
		{
			System.out.println("Doctor isActive is marked as false");
		}
		if(workTypeValue.equalsIgnoreCase("Hospital"))
		{
			driver.findElement(By.xpath(Elements_NewAdminDoctors.workTypeHospital)).click();
		}
		else
		{
			System.out.println("Work type is marked as hospital clinic");
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
		driver.findElement(By.id(Elements_NewAdminDoctors.dateOfBirth)).sendKeys(DOB); //(MM/DD/YYYY)
		driver.findElement(By.id(Elements_NewAdminDoctors.medicalRegistrationNumber)).sendKeys(regNum);
		Browser.selectbyXpath(Elements_NewAdminDoctors.Qualification, qualification);
		Browser.selectbyXpath(Elements_NewAdminDoctors.professionalTag, tag);
		Browser.selectbyXpath(Elements_NewAdminDoctors.areaOfSpecialization, specialization);
		Browser.selectbyXpath(Elements_NewAdminDoctors.lineOfPractice, practiceLine);
		driver.findElement(By.id(Elements_NewAdminDoctors.aboutDoctor)).sendKeys(aboutDoc);
	} //Primary info method end ***
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to enter other clinic information under practice tab of doctor on admin add doctor screen
	 * @ Param			: ifOtherClinicAvailable, othrClinicName, othrClinicPhoneNumber, othrClinicFee, othrState, othrCity, othrAddressLineOne, othrClinicPinCode, othrClinicLongitude, othrClinicLatitude, othrClinicFacilityStatus, othrClinicAmbulanceStatus, othrClinicEmergencyStatus, othrClinicBikeParkStatus, othrClinicCarParkStatus, othrClincPayCreditStatus, othrClincPayDebitStatus, othrClincPayOnlineStatus, othrClincPayCashStatus, othrClincPayChecqueStatus, othrClinicPremiumServiceStatus
	 * @ return			: NA
	 */
	public void practiceDetails_otherClinic_Enter(String ifOtherClinicAvailable, String othrClinicName, String othrClinicPhoneNumber, String othrClinicFee, String othrClinicState, String othrClinicCity, String othrClinicAddressLineOne, String othrClinicPinCode, String othrClinicLongitude, String othrClinicLatitude, String othrClinicFacilityStatus, String othrClinicAmbulanceStatus, String othrClinicEmergencyStatus, String othrClinicBikeParkStatus, String othrClinicCarParkStatus, String othrClincPayCreditStatus, String othrClincPayDebitStatus, String othrClincPayCashStatus, String othrClincPayOnlineStatus, String othrClincPayChecqueStatus, String othrClinicPremiumServiceStatus) throws Exception
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
	} //Practice other clinic method end ****
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to enter default clinic information under practice tab of doctor on admin add doctor screen
	 * @ Param			: defaultClinicName, defaultClinicFee, practiceStartDate
	 * @ return			: NA
	 */
	public void practiceDetails_DefaultClinic_Enter(String defaultClinicName, String defaultClinicFee, String practiceStartDate, String zoyloFacilitationFee)
	{
		driver.findElement(By.xpath(Elements_NewAdminDoctors.defaultClinicTab)).click();
		Browser.waitFortheID(Elements_NewAdminDoctors.defaultClinicName);
		driver.findElement(By.id(Elements_NewAdminDoctors.defaultClinicName)).sendKeys(defaultClinicName);
		driver.findElement(By.id(Elements_NewAdminDoctors.defaultClinicconsultationFee)).sendKeys(defaultClinicFee);
		driver.findElement(By.id(Elements_NewAdminDoctors.defaultClinicPracticeStartDate)).clear();
		driver.findElement(By.id(Elements_NewAdminDoctors.defaultClinicPracticeStartDate)).sendKeys(practiceStartDate);
		driver.findElement(By.id(Elements_NewAdminDoctors.defaultClinicFacilitationCharges)).sendKeys(zoyloFacilitationFee);
	} //Practice default clinic method end ****
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to enter vacation information under practice tab of doctor on admin add doctor screen
	 * @ Param			: vacationStatus, vacationStartDate
	 * @ return			: NA
	 */
	public void practiceDetails_Vacation_Enter(String vacationStatus, String vacationStartDate, String vacationEndDate)
	{
		if(vacationStatus.equalsIgnoreCase("true"))
		{
			driver.findElement(By.xpath(Elements_NewAdminDoctors.VacationTab)).click();
			Browser.waitFortheElementXpath(Elements_NewAdminDoctors.vacationAddButton);
			driver.findElement(By.xpath(Elements_NewAdminDoctors.vacationAddButton)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.vacationStartDate);
			driver.findElement(By.id(Elements_NewAdminDoctors.vacationStartDate)).clear();
			driver.findElement(By.id(Elements_NewAdminDoctors.vacationStartDate)).sendKeys(vacationStartDate);
			driver.findElement(By.id(Elements_NewAdminDoctors.vacationEndDate)).clear();
			driver.findElement(By.id(Elements_NewAdminDoctors.vacationEndDate)).sendKeys(vacationEndDate);
			driver.findElement(By.id(Elements_NewAdminDoctors.vacationActiveCheckBox)).click();
			driver.findElement(By.id(Elements_NewAdminDoctors.vacationSave)).click();
		}
		else
		{
			System.out.println("There is no vacation set for this doctor");
		}
	} //Practice vacation method end ***
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to enter hospital information under practice tab of doctor on admin add doctor screen
	 * @ Param			: hospitalWorkTypeStatus, hospitalName, hospitalFee, zfcForHospital
	 * @ return			: NA
	 */
	public void practiceDetails_HospitalInfo_Enter(String hospitalWorkTypeStatus, String hospitalName, String hospitalFee, String zfcForHospital)
	{
		if(hospitalWorkTypeStatus.equalsIgnoreCase("true"))
		{
			driver.findElement(By.xpath(Elements_NewAdminDoctors.HospitalTab)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.hospitaladdHospitalBtn);
			driver.findElement(By.id(Elements_NewAdminDoctors.hospitaladdHospitalBtn)).click();
			Browser.waitFortheID(Elements_NewAdminDoctors.hospitalpopUpName);
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
	} //Practice hospital info method end ***
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to upload doctor default image under practice tab of doctor on admin add doctor screen
	 * @ Param			: imageURL
	 * @ return			: NA
	 */
	public void practiceDetails_GalleryInfo_Enter(String imageURL) throws Exception
	{
		driver.findElement(By.xpath(Elements_NewAdminDoctors.galleryTab)).click();
		Browser.waitFortheID(Elements_NewAdminDoctors.galleryUploadButton);
		driver.findElement(By.id(Elements_NewAdminDoctors.galleryUploadButton)).sendKeys(imageURL);
		Thread.sleep(5000);
	} //Practice gallery info method end ***
} //End of class

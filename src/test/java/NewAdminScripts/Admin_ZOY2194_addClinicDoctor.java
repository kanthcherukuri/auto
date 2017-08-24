package NewAdminScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import objectRepository.Elements_NewAdminDoctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.NewAdminDoctorsPage;
import testBase.RecipientPage;
import testBase.TestUtils;

//@Authour: Sagar Sen

public class Admin_ZOY2194_addClinicDoctor extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	public RecipientPage RecipientPage;
	public DoctorsPage doctorsPage;
	
	public String password="Zoylo@123";
	
	@DataProvider(name="clinicDoctorDetails")
	public Object[][] clinicDocInfo() throws Exception
	{
		Object[][] clinicDocInformation=TestUtils.getTableArray("TestData/rvmpAdmin_addDoctor.xls", "clinicDoctor", "ZOY2194");
		return(clinicDocInformation);
	}
	
	@Test(dataProvider="clinicDoctorDetails")
	public void addClinicDoctor(String firstName, String MiddleName, String LastName, String ShortName, String emailID, String mobileNumber, String password, String isActiveValue, String houseCallStatus, String houseCallFee, String genderValue, String DOB, String regNum, String qualification, String tag, String specialization, String practiceLine, String aboutDoc, String ifOtherClinicAvailable, String othrClinicName, String othrClinicPhoneNumber, String othrClinicFee, String othrClinicState, String othrClinicCity, String othrClinicAddressLineOne, String othrClinicPinCode, String othrClinicLongitude, String othrClinicLatitude, String othrClinicFacilityStatus, String othrClinicAmbulanceStatus, String othrClinicEmergencyStatus, String othrClinicBikeParkStatus, String othrClinicCarParkStatus, String othrClincPayCreditStatus, String othrClincPayDebitStatus, String othrClincPayCashStatus, String othrClincPayOnlineStatus, String othrClincPayChecqueStatus, String othrClinicPremiumServiceStatus, String defaultClinicName, String defaultClinicFee, String practiceStartDate, String zoyloFacilitationFee, String vacationStatus, String vacationStartDate, String vacationEndDate, String hospitalWorkTypeStatus, String hospitalName, String hospitalFee, String zfcForHospital, String imageURL, String mondayStatus, String MondayworkType, String isMondayHospitalTrue, String mondayHospitalName, String isMondayClinicTrue, String mondayClinicName, String mondayStartTime, String mondayEndTime, String tuesdayStatus, String tuesdayworkType, String istuesdayHospitalTrue, String tuesdayHospitalName, String istuesdayClinicTrue, String tuesdayClinicName, String tuesdayStartTime, String tuesdayEndTime, String wednesdayStatus, String wednesdayworkType, String iswednesdayHospitalTrue, String wednesdayHospitalName, String iswednesdayClinicTrue, String wednesdayClinicName, String wednesdayStartTime, String wednesdayEndTime, String thursdayStatus, String thursdayworkType, String isthursdayHospitalTrue, String thursdayHospitalName, String isthursdayClinicTrue, String thursdayClinicName, String thursdayStartTime, String thursdayEndTime, String fridayStatus, String fridayworkType, String isfridayHospitalTrue, String fridayHospitalName, String isfridayClinicTrue, String fridayClinicName, String fridayStartTime, String fridayEndTime, String FacilityStatus, String AmbulanceStatus, String EmergencyStatus, String BikeParkStatus, String CarParkStatus, String PayCreditStatus, String PayDebitStatus, String PayCashStatus, String PayOnlineStatus, String PayChecqueStatus, String PremiumServiceStatus, String Country, String State, String City, String completeAddress, String Locality, String pin, String longitude, String latitude, String removeFromDB) throws Exception
	{
		admin.click_doctorsTab();
		admin.click_addDoctor();
		admin.Enter_doctorGenericDetails(firstName, MiddleName, LastName, ShortName, emailID, mobileNumber, password);
		admin.Enter_primaryInfoDetails(isActiveValue, houseCallStatus, houseCallFee, genderValue, DOB, regNum, qualification, tag, specialization, practiceLine, aboutDoc);
		
		admin.Enter_practiceDetails_otherClinic(ifOtherClinicAvailable, othrClinicName, othrClinicPhoneNumber, othrClinicFee, othrClinicState, othrClinicCity, othrClinicAddressLineOne, othrClinicPinCode, othrClinicLongitude, othrClinicLatitude, othrClinicFacilityStatus, othrClinicAmbulanceStatus, othrClinicEmergencyStatus, othrClinicBikeParkStatus, othrClinicCarParkStatus, othrClincPayCreditStatus, othrClincPayDebitStatus, othrClincPayCashStatus, othrClincPayOnlineStatus, othrClincPayChecqueStatus, othrClinicPremiumServiceStatus);
		//Assert check point for other clinic data table
		if(ifOtherClinicAvailable.equalsIgnoreCase("true"))
		{
			String verifyClinicName=driver.findElement(By.xpath(Elements_NewAdminDoctors.otherClinicTable_ClinicName)).getText();
			Assert.assertEquals(verifyClinicName, othrClinicName);
		}
		admin.Enter_practiceDetails_DefaultClinic(defaultClinicName, defaultClinicFee, practiceStartDate, zoyloFacilitationFee);
		admin.Enter_practiceDetails_Vacation(vacationStatus, vacationStartDate, vacationEndDate);
		admin.Enter_practiceDetails_HospitalInfo(hospitalWorkTypeStatus, hospitalName, hospitalFee, zfcForHospital);
		//Assert check point for hospital add data table
		if(hospitalWorkTypeStatus.equalsIgnoreCase("true"))
		{
			String verifyHospitalName=driver.findElement(By.xpath(Elements_NewAdminDoctors.hospitalTable_hospitalName)).getText();
			Assert.assertEquals(verifyHospitalName, hospitalName);		
		}
		admin.Enter_practiceDetails_GalleryInfo(imageURL);
		admin.Enter_workDaysInfo(mondayStatus, MondayworkType, isMondayHospitalTrue, mondayHospitalName, isMondayClinicTrue, mondayClinicName, mondayStartTime, mondayEndTime, tuesdayStatus, tuesdayworkType, istuesdayHospitalTrue, tuesdayHospitalName, istuesdayClinicTrue, tuesdayClinicName, tuesdayStartTime, tuesdayEndTime, wednesdayStatus, wednesdayworkType, iswednesdayHospitalTrue, wednesdayHospitalName, iswednesdayClinicTrue, wednesdayClinicName, wednesdayStartTime, wednesdayEndTime, thursdayStatus, thursdayworkType, isthursdayHospitalTrue, thursdayHospitalName, isthursdayClinicTrue, thursdayClinicName, thursdayStartTime, thursdayEndTime, fridayStatus, fridayworkType, isfridayHospitalTrue, fridayHospitalName, isfridayClinicTrue, fridayClinicName, fridayStartTime, fridayEndTime);
		admin.Enter_defaultFacilities(FacilityStatus, AmbulanceStatus, EmergencyStatus, BikeParkStatus, CarParkStatus, PayCreditStatus, PayDebitStatus, PayCashStatus, PayOnlineStatus, PayChecqueStatus, PremiumServiceStatus);
		admin.Enter_addressInfo(Country, State, City, completeAddress, Locality, pin, longitude, latitude);
		admin.clickSubmitDoctor();
		Browser.CheckNotificationMessage("Doctor created successfully");
		
		//*********** ZOY-2450 check registration verification **************\\
		driver.navigate().refresh();
		admin.click_doctorsTab();
		admin.searchDoctorbyEmailID(emailID);
		Browser.scrollbyxpath(Elements_NewAdminDoctors.registrationStatusOnTable);
		String state=Browser.getTextByXpath(Elements_NewAdminDoctors.registrationStatusOnTable);
		if(state.equalsIgnoreCase("NO")){
			Browser.scrollbyxpath(Elements_NewAdminDoctors.EditButton);
			admin.clickEditbutton();
			admin.registrationVerification();
		}
		else{
			System.out.println("Doctor registration is verified");
		}
		
		admin.clickSubmitDoctor();
		Browser.CheckNotificationMessage("Doctor Updated Successfully");
		driver.navigate().refresh();
		admin.click_doctorsTab();
		admin.searchDoctorbyEmailID(emailID);
		Browser.scrollbyxpath(Elements_NewAdminDoctors.registrationStatusOnTable);
		String state1=Browser.getTextByXpath(Elements_NewAdminDoctors.registrationStatusOnTable);
		if(state1.equalsIgnoreCase("YES")){
			System.out.println(emailID+" registration is verified");
		}
		
		//********* TO ACTIVATE DOCTOR FROM ADMIN LIST VIEW AND CHECK ERROR NOTIFICATION ************\\
		if(isActiveValue.equalsIgnoreCase("false"))
		{
			Browser.clickOnTheElementByXpath(Elements_NewAdminDoctors.adminListActiveCheckBox);
			if(driver.findElements(By.xpath("//div[@class='zy-status-wrapper']")).size()!=0)
			{
				String notify=Browser.getTextByXpath("//div[@class='zy-status-wrapper']");
				if(notify.equalsIgnoreCase("Internal server error"))
				{
					System.out.println("Cursor in assert fail condition");
					if(removeFromDB.equalsIgnoreCase("true"))
					{
						String docID=Browser.mongoDB_getID("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "providers", "username", emailID);
						System.out.println("DOC ID retrived is: "+docID);
						Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "zyGlobalGenericSearch", "entityId", docID);
						Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "redisProvidersCache", "providerId", docID);
						Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "providers", "username", emailID);
						Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "users", "username", emailID);
					}
					Assert.fail();
				}
			}
		}
		
		//************** RESET LOGIN PASSWORD **************\\
		admin.clickEditbutton();
		Browser.waitFortheID(Elements_NewAdminDoctors.firstName);
		admin.doctorChangePassword(password);
		admin.click_Profile_Options("Logout");
		
		//************ RECIPIENT BOOK RESCHEDULE AND CANCEL APPOINTMENT *************\\
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");	
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		RecipientPage.searchInZoyloMAP(firstName);
		RecipientPage.bookAppointment();
		//BOOK APPOINTMENT
		String[] Appointmentdetails = RecipientPage.selectDefaultSlot();
		System.out.println("Clinic Name details"+Appointmentdetails[0]);
		System.out.println("Time details"+Appointmentdetails[1]);
		RecipientPage.confirmAppointment("Patient details");
	    RecipientPage.makePayment();
		Assert.assertTrue(Browser.getTextByXpath("//div[@class='book-dtbox']/p[1]/a").contains("Creditsuite")); //Verifying Doctor Name in Thank you Page
		String AppointmentId = Browser.getAppointmentID();
		//RESCHEDULE APPOINTMENT
		RecipientPage.openMyAccounts("Appointments");
		RecipientPage.UpcomingAppointmentForDoctors(AppointmentId, "Reschedule");
		Browser.clickOnTheElementByXpath("(//div[@class='panel-collapse collapse in']/ul/li[@class='sp-available-slots'])");
		Browser.CheckNotificationMessage("Your appointment slot has been successfully CHANGED");
		driver.navigate().refresh();
		//CANCEL APPOINTMENT
		Browser.enterTextByID("aptSearch", AppointmentId);
		Thread.sleep(2000);
		Browser.clickOnTheElementByXpath("//div[@class='patientApmtStatus' and contains(.,'Rescheduled')]/following-sibling::div[1]/div[2]");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='cancelYes']")).click();
		System.out.println("Cancelled Action Is Executed");
		Reporter.log("Clicked On Cancel For Appointment="+AppointmentId);
		Browser.CheckNotificationMessage("Appointment has been CANCELLED");
		RecipientPage.recipientLogout();
		
		//************** LOGIN WITH NEW DOCTOR CREDENTIALS **************\\
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		doctorsPage.SignIn(emailID, password);
		doctorsPage.doctorlogout();
		
		if(removeFromDB.equalsIgnoreCase("true"))
		{
			String docID=Browser.mongoDB_getID("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "providers", "username", emailID);
			System.out.println("DOC ID retrived is: "+docID);
			Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "zyGlobalGenericSearch", "entityId", docID);
			Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "redisProvidersCache", "providerId", docID);
			Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "providers", "username", emailID);
			Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "users", "username", emailID);
			Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "appointment", "bookingNumber", AppointmentId);
		}

		Thread.sleep(5000);
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties(); // loading the Elements
		Browser= new TestUtils(driver);
		RecipientPage = new RecipientPage(driver);
		admin=new NewAdminDoctorsPage(driver);
		doctorsPage=new DoctorsPage(driver);
		admin.adminSignIn(admin_user, admin_password);
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.quit();
	}
}


//@author: Ch.LakshmiKanth

package NewAdminScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.Elements_NewAdminDoctors;
import testBase.LoadPropMac;
import testBase.NewAdminDoctorsPage;
import testBase.TestUtils;

public class Admin_ZOY2447_CheckServerErrorForDoctor extends LoadPropMac {
	
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties(); // loading the Elements
		Browser= new TestUtils(driver);
		admin=new NewAdminDoctorsPage(driver);
		admin.adminSignIn(admin_user, admin_password);
	}
	
	
	@DataProvider(name="ServerError")
	public Object[][] clinicDocInfo() throws Exception
	{
		Object[][] clinicDocInformation=TestUtils.getTableArray("TestData/rvmpAdmin_addDoctor.xls", "Servererror", "ZOY2447");
		return(clinicDocInformation);
	}
	
	
	
	@Test(dataProvider="ServerError")
	public void CheckClinicDoctor(String firstName, String MiddleName, String LastName, String ShortName, String emailID, String mobileNumber, 
	String password, String isActiveValue, String houseCallStatus, String houseCallFee, String genderValue, String DOB, String regNum, 
	String qualification, String tag, String specialization, String practiceLine, String aboutDoc, String ifOtherClinicAvailable, 
	String othrClinicName, String othrClinicPhoneNumber, String othrClinicFee, String othrClinicState, String othrClinicCity,
	String othrClinicAddressLineOne, String othrClinicPinCode, String othrClinicLongitude, String othrClinicLatitude, 
	String othrClinicFacilityStatus, String othrClinicAmbulanceStatus, String othrClinicEmergencyStatus, 
	String othrClinicBikeParkStatus, String othrClinicCarParkStatus, String othrClincPayCreditStatus, String othrClincPayDebitStatus,
	String othrClincPayCashStatus, String othrClincPayOnlineStatus, String othrClincPayChecqueStatus, String othrClinicPremiumServiceStatus,
	String defaultClinicName, String defaultClinicFee, String practiceStartDate, String zoyloFacilitationFee, String vacationStatus,
	String vacationStartDate, String vacationEndDate, String hospitalWorkTypeStatus, String hospitalName, String hospitalFee, 
	String zfcForHospital, String imageURL, String mondayStatus, String MondayworkType, String isMondayHospitalTrue, 
	String mondayHospitalName, String isMondayClinicTrue, String mondayClinicName, String mondayStartTime, String mondayEndTime, 
	String tuesdayStatus, String tuesdayworkType, String istuesdayHospitalTrue, String tuesdayHospitalName, String istuesdayClinicTrue,
	String tuesdayClinicName, String tuesdayStartTime, String tuesdayEndTime, String wednesdayStatus, String wednesdayworkType, 
	String iswednesdayHospitalTrue, String wednesdayHospitalName, String iswednesdayClinicTrue, String wednesdayClinicName, 
	String wednesdayStartTime, String wednesdayEndTime, String thursdayStatus, String thursdayworkType, String isthursdayHospitalTrue, 
	String thursdayHospitalName, String isthursdayClinicTrue, String thursdayClinicName, String thursdayStartTime, String thursdayEndTime, 
	String fridayStatus, String fridayworkType, String isfridayHospitalTrue, String fridayHospitalName, String isfridayClinicTrue, 
	String fridayClinicName, String fridayStartTime, String fridayEndTime, String FacilityStatus, String AmbulanceStatus, String EmergencyStatus, 
	String BikeParkStatus, String CarParkStatus, String PayCreditStatus, String PayDebitStatus, String PayCashStatus, String PayOnlineStatus,
	String PayChecqueStatus, String PremiumServiceStatus, String Country, String State, String City, String completeAddress, String Locality, 
	String pin, String longitude, String latitude) throws Exception
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
		WebDriverWait wait = (new WebDriverWait(driver, 60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//li[@class='parsley-pattern'])[1]")));
		String ActualNotification= driver.findElement(By.xpath("(//li[@class='parsley-pattern'])[1]")).getText();
		System.out.println("ActualNotificationMessage="+ActualNotification);
		Assert.assertEquals(ActualNotification,"This value seems to be invalid.");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//li[@class='parsley-pattern'])[2]")));
		String ActualNotificationMobile= driver.findElement(By.xpath("(//li[@class='parsley-pattern'])[1]")).getText();
		System.out.println("ActualNotificationMessage="+ActualNotificationMobile);
		Assert.assertEquals(ActualNotification,"This value seems to be invalid.");
		
	}
	
	
	
	@AfterClass
	public void closebrowser()
	{
		driver.quit();
	}
}



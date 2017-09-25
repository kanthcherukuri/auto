package testBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import objectRepository.Elements_ZMTusers;

public class ZMTPage extends LoadPropMac
{
	public WebDriver driver;
	public TestUtils Browser;
	
	public ZMTPage(WebDriver driver) throws Exception
	{
		this.driver=driver;
		Browser=new TestUtils(driver);
		Elements_ZMTusers.zmt_UsersPageProperties();
	}
	
	/*
	 * @Author: Sagar Sen
	 * @Desc: This method is used to enter signup details on signUp form.
	 * @Parms: fname, lname, email, country, state, phnum, functionalArea, address
	 * @Return: NA
	 */
	public void SignUpForm_Details(String fname, String lname, String email, String country, String state, String password, String confirmPassword, String phnum, String functionalArea, String address) throws Exception
	{
		Browser.enterTextByID(Elements_ZMTusers.signUp_FirstName, fname);
		Browser.enterTextByID(Elements_ZMTusers.signUp_LastName, lname);
		Browser.enterTextByID(Elements_ZMTusers.signUp_email, email);
		Browser.selectbyID(Elements_ZMTusers.signUp_country, country);
		Thread.sleep(500);
		Browser.selectbyID(Elements_ZMTusers.signUp_state, state);
		Browser.enterTextByID(Elements_ZMTusers.signUp_password, password);
		Browser.enterTextByID(Elements_ZMTusers.signUp_confirmPassword, confirmPassword);
		Browser.enterTextByID(Elements_ZMTusers.signUp_mobileNumber, phnum);
		Browser.selectbyID(Elements_ZMTusers.signUp_functionalArea, functionalArea);
		Browser.enterTextByID(Elements_ZMTusers.signUp_address, address);
	}
	
	/*
	 * @Author: Sagar Sen
	 * @Desc: This method is used to enter contact details on contactus form.
	 * @Parms: 
	 * @Return: NA
	 */
	public void contactUs_Details(String name, String gender, String age, String country, String city, String email, String number, String message) throws Exception
	{
		Browser.enterTextByID(Elements_ZMTusers.contactUs_name, name);
		Browser.selectbyID(Elements_ZMTusers.contactUs_gender, gender);
		Browser.enterTextByID(Elements_ZMTusers.contactUs_age, age);
		Browser.selectbyID(Elements_ZMTusers.contactUs_country, country);
		Thread.sleep(500);
		Browser.selectbyID(Elements_ZMTusers.contactUs_state, city);
		Browser.enterTextByID(Elements_ZMTusers.contactUs_email, email);
		Browser.enterTextByID(Elements_ZMTusers.contactUs_phone, number);
		Browser.enterTextByID(Elements_ZMTusers.contactUs_message, message);
	}
	
	/*
	 * @Author: Sagar Sen
	 * @Desc: This method is used to click either options on profile drop down.
	 * @Parms: NA
	 * @Return: NA
	 */
	public void zmt_Logout()
	{
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmtuserProfileButton);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_LogoutDropDown);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_confirmLogout);
	}
	
	/*
	 * @Author: Sagar Sen
	 * @Desc: This method is used to click submit enquiry button and fill the details.
	 * @Parms: name, email, qury
	 * @Return: NA
	 */
	public void surgeon_submitEnquiry_Details(String name, String email, String qury) throws Exception
	{
		Browser.enterTextByID(Elements_ZMTusers.zmt_enquireFirstName, name);
		Browser.enterTextByID(Elements_ZMTusers.zmt_enquiryEmail, email);
		Browser.enterTextByID(Elements_ZMTusers.zmt_enquiryQury, qury);
		Thread.sleep(500);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_submitEnquiry);
	}
	
	/*
	 * @Author: Sagar Sen
	 * @Desc: This method is used to enter profile details of patient.
	 * @Parms: Pfname	Plname	Pgender	Page	Pphnum	Ppicupload	Paddress	Pmedcondition	Prefdoc	Pcertificates	Vfname	Vlname	Vgender	Vage	Vphnum	Vaddress	Vmedcondition	Vrefdoc
	 * @Return: NA
	 */
	public void patientProfile_details(String Pfname, String Plname, String Pgender, String Page, String Pphnum, String Ppicupload, String Paddress, String Pmedcondition, String Prefdoc, String Pcertificates) throws Exception
	{
		String current = System.getProperty("user.dir");
		Browser.enterTextByID(Elements_ZMTusers.profile_firstName, Pfname);
		Browser.enterTextByID(Elements_ZMTusers.profile_lastName, Plname);
		Browser.selectbyid(Elements_ZMTusers.profile_gender, Pgender);
		Browser.enterTextByID(Elements_ZMTusers.profile_age, Page);
		Browser.enterTextByID(Elements_ZMTusers.profile_phNum, Pphnum);
		Browser.enterTextByID(Elements_ZMTusers.profile_profileImg, current+Ppicupload);
		Thread.sleep(8000);
		Browser.enterTextByID(Elements_ZMTusers.profile_homeAddress, Paddress);
		Browser.enterTextByID(Elements_ZMTusers.profile_medicalCondition, Pmedcondition);
		Browser.clickOnTheElementByID(Elements_ZMTusers.profile_medicalInsuranceCheckBox);
		Browser.enterTextByID(Elements_ZMTusers.profile_insuranceCompName, "Star Health");
		Browser.enterTextByID(Elements_ZMTusers.profile_referalPhysician, Prefdoc);
		Browser.enterTextByID(Elements_ZMTusers.profile_UploadCertificates, current+Pcertificates);
		Thread.sleep(8000);
		Browser.clickOnTheElementByID(Elements_ZMTusers.profile_myAccountSave);
	}
	
	/*
	 * @Author: Ch.LakshmiKanth
	 * @Desc: This method is used to Submit Your Profile In Careers .
	 * @Parms: NA
	 * @Return: NA
	 */
	public void Details_Careers(String fullname,String email,String mobile,String expinyears,String expinmonths,String currentemployee,String applyingfor,String currentctc) {
		
		 
		Browser.enterTextByID(Elements_ZMTusers.careers_fullname, fullname);
		Browser.enterTextByID(Elements_ZMTusers.careers_email,email);
		Browser.enterTextByID(Elements_ZMTusers.careers_mobile, mobile);
		Browser.enterTextByID(Elements_ZMTusers.careers_yearsofexperience, expinyears);
		Browser.enterTextByID(Elements_ZMTusers.careers_monthsofexperirnce, expinmonths);
		Browser.enterTextByID(Elements_ZMTusers.careers_currentemployee, currentemployee);
		Browser.enterTextByID(Elements_ZMTusers.careers_applyingfor, applyingfor);
		Browser.enterTextByID(Elements_ZMTusers.careers_currentctc, currentctc);
		driver.findElement(By.id(Elements_ZMTusers.careers_upload)).sendKeys(System.getProperty("user.dir")+"/Uploads/scroll.pdf");
		Browser.clickOnTheElementByID(Elements_ZMTusers.careers_submit);
	}
	
	public void Hospitals_SubmitEnquiry_Details(String Name, String Email,String Phno,String Query) {
		Browser.enterTextByID(Elements_ZMTusers.Name_TopHospitals, Name);	
		Browser.enterTextByID(Elements_ZMTusers.Email_TopHospitals, Email);
		Browser.enterTextByID(Elements_ZMTusers.Phone_TopHospitals, Phno);
		Browser.enterTextByID(Elements_ZMTusers.Query_TopHospitals, Query);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.Submit_TopHospitals);
	}
	
	public void ListOfHospitals_SubmitEnquiry_Details(String Name, String Email,String Phno,String Query) {
		Browser.enterTextByID(Elements_ZMTusers.Name_TopHospitals, Name);	
		Browser.enterTextByID(Elements_ZMTusers.Email_TopHospitals, Email);
		Browser.enterTextByID(Elements_ZMTusers.Phone_TopHospitals, Phno);
		Browser.enterTextByID(Elements_ZMTusers.Query_TopHospitals, Query);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.Submit_Listofhospitals);
	}
	
	
	public void OtherProfile_Details(String firstname,String lastname,String phone,String specialities,String yearofest,String ICUB,String Surgeons,
			String designation,String specialization,String listoftreatments,String aboutyourself ,String message) {
		
		Browser.enterTextByID("firstName",firstname);
		Browser.enterTextByID("lastName", lastname);
		Browser.enterTextByID("phone", phone);
		Browser.selectbyID("hospitalSpecialities", specialities);
		Browser.enterTextByID("yearOfEstablishment", yearofest);
		Browser.enterTextByID("numberOfICUBeds", ICUB);
		Browser.enterTextByID("totalTeamOfSurgeons", Surgeons);
		Browser.selectbyID("designation", designation);
		Browser.selectbyID("otherSpecialization", specialization);
		Browser.selectbyID("listOfTreatments", listoftreatments);
		Browser.enterTextByID("aboutYourSelf", aboutyourself);
		Browser.enterTextByID("message", message);
		Browser.clickOnTheElementByID("myAccountSave");
	}
}
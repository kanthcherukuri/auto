package NewAdminScripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;
import testBase.LoadPropMac;
import testBase.NewAdminDiagnosticPage;
import testBase.TestUtils;

public class Admin_AddDiagnostic extends LoadPropMac{
	
	public NewAdminDiagnosticPage AdminDiagnostic;
	public TestUtils Browser;
	
	@BeforeClass	 
	 public void LaunchBrowser() throws Exception {		
	 LoadBrowserProperties();
	 driver.get(doctors_Url);		 
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 AdminDiagnostic=new NewAdminDiagnosticPage(driver);	
	 Browser= new TestUtils(driver);
	 AdminDiagnostic.SignIn(Admin_Username, Admin_Password);
	 Thread.sleep(2000);
	 
	  }
	
	@DataProvider(name = "CreateNewDiagnostic")
    public Object[][] createData_DP1() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewDiagnostic.xls","AdminDiagnostic", "TC1");
        return(retObjArr);
    }

	@Test(dataProvider="CreateNewDiagnostic")
	public void CreateNewDiagnosticCenter(String RunMode,String DiagnosticName,String ShortName,String fullname,String email,String phone,String password, 
	String dateofbirth,String desc,String regno,String dateofreg,String rating,String  startedyear,String homevisitvalue,String charge,String range,String appperslot,String mvalue,String starttime,String endtime,
	String tvalue,String tstarttime,String tendtime,String Wvalue,String Wstarttime,String Wendtime,String thvalue,String thstarttime,String thendtime,
	String fvalue,String fstarttime,String fendtime,String Svalue,String Sstarttime,String Sendtime,String labslotduration,String labapptperslot,String Lmvalue,String Lmstarttime,String Lmendtime,
	String Ltvalue,String Ltstarttime,String Ltendtime,String LWvalue,String LWstarttime,String LWendtime,String LThvalue,String LThstarttime,
	String LThendtime,String Lfvalue,String Lfstarttime,String Lfendtime,String LSvalue,String LSstarttime,String LSendtime,String servicemode,String packagename,String packagedesc,String packagecost, String discountpercentage,
	String zoylopercentage,String packageduration,String packageperslot,String testname,String testdesc,String diagTestname,String diagTestdesc,String diagservicemode,String diagTestcost,String diagdiscountper,
	String diagZoyloper,String diagduration,String diagNumofSlots,String Personname,String PersonPhone,String PersonEmail,String PersonFax,String imageURL,String startdate,String enddate,
	String discountoffered,String websiteURL,String accreditations,String ngo,String reportonline,String facebookurl,String googleurl,
	String linkedinurl,String twiterurl,String address, String country,String state,String city,String pincode,String locality,String landmark,
	String longitude,String latitude,String SEOtitle,String SEOdesc,String SEOkeywords,String SEOurl) throws Exception{
		AdminDiagnostic.ClickOnDiagnosticMenu();
		Thread.sleep(2000);
		AdminDiagnostic.ClickOnAddDiagnostic();
		Thread.sleep(2000);
		AdminDiagnostic.EnterDiagnosticDetails(DiagnosticName, ShortName, fullname, email, phone, password);
		AdminDiagnostic.EnterMandatoryFields(dateofbirth, desc, regno, dateofreg, rating, startedyear);
		AdminDiagnostic.EnterHomeVisitDetails(homevisitvalue, charge, range, appperslot, mvalue, starttime, endtime, tvalue, tstarttime, tendtime, Wvalue, 
		Wstarttime, Wendtime,thvalue, thstarttime, thendtime, fvalue, fstarttime, fendtime, Svalue, Sstarttime, Sendtime);
		AdminDiagnostic.EnterLabVisitDetails(labslotduration, labapptperslot, Lmvalue, Lmstarttime, Lmendtime, Ltvalue, Ltstarttime, Ltendtime, 
		LWvalue, LWstarttime, LWendtime, LThvalue, LThstarttime, LThendtime, Lfvalue, Lfstarttime, Lfendtime, LSvalue, LSstarttime, LSendtime);
		AdminDiagnostic.ClickOnPackageAndTestsMenu();
		AdminDiagnostic.AddHealthPackages(servicemode, packagename, packagedesc, packagecost, discountpercentage, zoylopercentage,
		packageduration, packageperslot);
		AdminDiagnostic.AddTestsInHealthPackage(testname, testdesc);
		AdminDiagnostic.SaveAddHealthPackages();
		AdminDiagnostic.CreateDiagnosticTests(diagTestname, diagTestdesc, diagservicemode, diagTestcost, diagdiscountper, 
		diagZoyloper, diagduration, diagNumofSlots);
		AdminDiagnostic.EnterAdditionalContactInformation(Personname, PersonPhone, PersonEmail, PersonFax);
		AdminDiagnostic.AddDiagnosticImage(imageURL);
		AdminDiagnostic.EnterMarkedasClosedInformation(startdate, enddate);
		AdminDiagnostic.EnterOtherInformationdetails(discountoffered, websiteURL, accreditations, ngo, reportonline);
		AdminDiagnostic.EnterSocialInformation(facebookurl, googleurl, linkedinurl, twiterurl);
		AdminDiagnostic.EnterAddressDetails(address, country, state, city, pincode, locality, landmark, longitude, latitude);
		AdminDiagnostic.EnterTheFacilities();
		AdminDiagnostic.EnterDetailsForSEO(SEOtitle, SEOdesc, SEOkeywords, SEOurl);
		AdminDiagnostic.SaveDiagnosticDetails();
		//Browser.CheckNotificationMessage("Diagnostic Center created successfully");	
	}
	
	
}

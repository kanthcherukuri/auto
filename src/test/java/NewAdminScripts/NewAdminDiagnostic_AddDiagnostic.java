package NewAdminScripts;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;
import objectRepository.Elements_NewAdminDiagnostic;
import org.openqa.selenium.By;
import testBase.LoadPropMac;
import testBase.NewAdminDiagnosticPage;
import testBase.TestUtils;

//@Author:Ch.Lakshmi Kanth


public class NewAdminDiagnostic_AddDiagnostic extends LoadPropMac{
	
	public NewAdminDiagnosticPage AdminDiagnostic;
	public TestUtils Browser;
	
	@BeforeClass	 
	 public void beforeClass() throws Exception {		
	 LoadBrowserProperties();
	 driver.get(doctors_Url);		 
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 AdminDiagnostic=new NewAdminDiagnosticPage(driver);	
	 Browser= new TestUtils(driver);
	 AdminDiagnostic.SignIn(Admin_Username, Admin_Password);
	  }

	@Test(priority=1)
	public void ClickandAddDiagnostic() throws Exception{
		
		AdminDiagnostic.ClickOnDiagnosticMenu();
		AdminDiagnostic.ClickOnAddDiagnostic();
	}
	
	@DataProvider(name = "DiagnosticDetails")
    public Object[][] createData_DP1() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","AdminDiagnostic", "TC1");
        return(retObjArr);
    }
	
	@Test(dataProvider="DiagnosticDetails", priority=2)
	public void EnterDiagnosticDetailsAndMandatoryFields(String RunMode,String DiagnosticName,String ShortName,String fullname,String email,String phone,String password, 
	String dateofbirth,String desc,String regno,String dateofreg,String rating,String  startedyear ) throws Exception{
		
		AdminDiagnostic.EnterDiagnosticDetails(DiagnosticName, ShortName, fullname, email, phone, password);
		AdminDiagnostic.EnterMandatoryFields(dateofbirth, desc, regno, dateofreg, rating, startedyear);
	}
	
	@DataProvider(name ="HomeVisitDetails")
    public Object[][] createData_DP2() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","AdminDiagnostic", "TC2");
        return(retObjArr);
    }
	
	@Test(dataProvider="HomeVisitDetails", priority=3)
	public void EnterHomevisitDetails(String RunMode,String homevisitvalue,String charge,String range,String appperslot,String mvalue,String starttime,String endtime,
			String tvalue,String tstarttime,String tendtime,String Wvalue,String Wstarttime,String Wendtime,String thvalue,String thstarttime,String thendtime,
			String fvalue,String fstarttime,String fendtime,String Svalue,String Sstarttime,String Sendtime) throws Exception{
		
		AdminDiagnostic.EnterHomeVisitDetails(homevisitvalue, charge, range, appperslot, mvalue, starttime, endtime, tvalue, tstarttime, tendtime, Wvalue, 
				Wstarttime, Wendtime,thvalue, thstarttime, thendtime, fvalue, fstarttime, fendtime, Svalue, Sstarttime, Sendtime);
		
		Browser.clickOnTheElementByID("monday");
		String Mstarttime=driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HomeVisit_MondayAssert)).getText();
		AssertJUnit.assertEquals(Mstarttime, starttime);
		
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HomeVisit_Tuesday);
		String TuesStarttime=driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HomeVisit_TuesdayAssert)).getText();
		AssertJUnit.assertEquals(TuesStarttime, tstarttime);
		
		Browser.clickOnTheElementByID("wednesday");
		String WebStarttime=driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HomeVisit_WednesdayAssert)).getText();
		AssertJUnit.assertEquals(WebStarttime, Wstarttime);
		
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HomeVisit_Thursday);
		String ThusStarttime=driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HomeVisit_ThusdayAssert)).getText();
		AssertJUnit.assertEquals(ThusStarttime, thstarttime);
		
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.HomeVisit_Friday);
		String FridStarttime=driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HomeVisit_FridayAssert)).getText();
		AssertJUnit.assertEquals(FridStarttime, fstarttime);
		
		Browser.clickOnTheElementByID("saturday");
		String SatStarttime=driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HomeVisit_SaturdayAssert)).getText();
		AssertJUnit.assertEquals(SatStarttime, Sstarttime);
	}
	
	@DataProvider(name ="LabVisitDetails")
    public Object[][] createData_DP3() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","AdminDiagnostic", "TC3");
        return(retObjArr);
    }
	
	@Test(dataProvider="LabVisitDetails", priority=4)
	public void EnterLabvisitDetails(String RunMode,String labslotduration,String labapptperslot,String Lmvalue,String Lmstarttime,String Lmendtime,
			String Ltvalue,String Ltstarttime,String Ltendtime,String LWvalue,String LWstarttime,String LWendtime,String LThvalue,String LThstarttime,
			String LThendtime,String Lfvalue,String Lfstarttime,String Lfendtime,String LSvalue,String LSstarttime,String LSendtime) throws Exception{
		
		AdminDiagnostic.EnterLabVisitDetails(labslotduration, labapptperslot, Lmvalue, Lmstarttime, Lmendtime, Ltvalue, Ltstarttime, Ltendtime, 
		LWvalue, LWstarttime, LWendtime, LThvalue, LThstarttime, LThendtime, Lfvalue, Lfstarttime, Lfendtime, LSvalue, LSstarttime, LSendtime);
		Thread.sleep(2000);

		
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_Monday);
		String labMonStart=driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_MondayAssert)).getText();
		AssertJUnit.assertEquals(labMonStart, Lmstarttime);
		
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_Tuesday);
		String labTueStart=driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_TuesdayAssert)).getText();
		AssertJUnit.assertEquals(labTueStart, Ltstarttime);
		
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_Wednesday); 
		String labWedStart=driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_WednesdayAssert)).getText();
		AssertJUnit.assertEquals(labWedStart, LWstarttime);
		
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_Thursday);
		String labThusStart=driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_ThursdayAssert)).getText();
		AssertJUnit.assertEquals(labThusStart, LThstarttime);
		
		
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_Friday);
		String labFriStart=driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_FridayAssert)).getText();
		AssertJUnit.assertEquals(labFriStart, Lfstarttime);
		
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.LabVisit_Saturday);
		String labSatStart=driver.findElement(By.xpath(Elements_NewAdminDiagnostic.LabVisit_SaturdayAssert)).getText();
		AssertJUnit.assertEquals(labSatStart, LSstarttime);
	}
	
	@DataProvider(name ="HealthPackages")
    public Object[][] createData_DP4() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","AdminDiagnostic", "TC4");
        return(retObjArr);
    }
	
	@Test(dataProvider="HealthPackages", priority=5)
	public void AddHealthPackages(String servicemode,String packagename,String packagedesc,String packagecost, String discountpercentage,
			String zoylopercentage,String packageduration,String packageperslot	) throws Exception{
		
		AdminDiagnostic.ClickOnPackageAndTestsMenu();
		AdminDiagnostic.AddHealthPackages(servicemode, packagename, packagedesc, packagecost, discountpercentage, zoylopercentage,
				packageduration, packageperslot);
	}
	
	@DataProvider(name ="HealthTests")
    public Object[][] createData_DP5() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","AdminDiagnostic", "TC5");
        return(retObjArr);
    }
	
	@Test(dataProvider="HealthTests", priority=6)
	public void AddTestsInHealthPackage(String testname,String testdesc) throws Exception{
		
		AdminDiagnostic.AddTestsInHealthPackage(testname, testdesc);
		String healthtestname=driver.findElement(By.xpath(Elements_NewAdminDiagnostic.HealthPackage_TestAssert)).getText();
		AssertJUnit.assertEquals(healthtestname, testname);
		AdminDiagnostic.SaveAddHealthPackages();
	}
	
	@DataProvider(name ="DiagnosticTests")
    public Object[][] createData_DP6() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","AdminDiagnostic", "TC6");
        return(retObjArr);
    }
	
	@Test(dataProvider="DiagnosticTests", priority=7)
	public void AddDiagnosticTests(String diagTestname,String diagTestdesc,String diagservicemode,String diagTestcost,String diagdiscountper,
			String diagZoyloper,String diagduration,String diagNumofSlots) throws Exception{
		
		AdminDiagnostic.CreateDiagnosticTests(diagTestname, diagTestdesc, diagservicemode, diagTestcost, diagdiscountper, 
				diagZoyloper, diagduration, diagNumofSlots);
		
		String diagTests=driver.findElement(By.xpath(Elements_NewAdminDiagnostic.DiagnosticTests_Assert)).getText();
		AssertJUnit.assertEquals(diagTests,diagTestname);
	}
	
	@DataProvider(name ="AdditionalInformation")
    public Object[][] createData_DP7() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","AdminDiagnostic", "TC7");
        return(retObjArr);
    }
	@Test(dataProvider="AdditionalInformation", priority=8)
	public void AddAdditionalInformation(String Personname,String PersonPhone,String PersonEmail,String PersonFax,String imageURL,String startdate,String enddate,
	String discountoffered,String websiteURL,String accreditations,String ngo,String reportonline,String facebookurl,String googleurl,
	String linkedinurl,String twiterurl) throws Exception{
		
		AdminDiagnostic.EnterAdditionalContactInformation(Personname, PersonPhone, PersonEmail, PersonFax);
		String person=driver.findElement(By.xpath(Elements_NewAdminDiagnostic.ContactPerson_Assert)).getText();
		AssertJUnit.assertEquals(person,Personname);
		AdminDiagnostic.AddDiagnosticImage(imageURL);		
		AdminDiagnostic.EnterMarkedasClosedInformation(startdate, enddate);
		String close=driver.findElement(By.xpath(Elements_NewAdminDiagnostic.MarkedasClosed_Assert)).getText();
		AssertJUnit.assertEquals(close,startdate);
		
		AdminDiagnostic.EnterOtherInformationdetails(discountoffered, websiteURL, accreditations, ngo, reportonline);
		AdminDiagnostic.EnterSocialInformation(facebookurl, googleurl, linkedinurl, twiterurl);
		
	}
	
	@DataProvider(name ="Addressdetails")
    public Object[][] createData_DP8() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","AdminDiagnostic", "TC8");
        return(retObjArr);
    }
	@Test(dataProvider="Addressdetails", priority=9)
	public void EnterAddressFacilitiesSEODetails(String address, String country,String state,String city,String pincode,String locality,String landmark,
			String longitude,String latitude,String SEOtitle,String SEOdesc,String SEOkeywords,String SEOurl) throws Exception{
		
		AdminDiagnostic.EnterAddressDetails(address, country, state, city, pincode, locality, landmark, longitude, latitude);
		AdminDiagnostic.EnterTheFacilities();
		AdminDiagnostic.EnterDetailsForSEO(SEOtitle, SEOdesc, SEOkeywords, SEOurl);
	}
	
	@Test(priority=10)
	public void SaveTheEnterDiagnosticDetails() throws Exception{
		AdminDiagnostic.SaveDiagnosticDetails();
		Browser.CheckNotificationMessage("Diagnostic Center created successfully");
	}
	
}

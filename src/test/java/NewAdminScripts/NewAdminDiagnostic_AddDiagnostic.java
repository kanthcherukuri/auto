package NewAdminScripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.*;


import testBase.LoadPropMac;
import testBase.NewAdminDiagnosticPage;
import testBase.TestUtils;

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
		Thread.sleep(2000);
		AdminDiagnostic.ClickOnAddDiagnostic();
		Thread.sleep(2000);
	}
	
	
	@DataProvider(name = "DiagnosticDetails")
    public Object[][] createData_DP1() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","AdminDiagnostic", "TC1");
        return(retObjArr);
    }
	
	
	@Test(dataProvider="DiagnosticDetails", priority=2,enabled=false)
	public void EnterDiagnosticDetailsAndMandatoryFields(String RunMode,String DiagnosticName,String ShortName,String fullname,String email,String phone,String password, 
	String dateofbirth,String desc,String regno,String dateofreg,String rating,String  startedyear ) throws Exception{
		
		AdminDiagnostic.EnterDiagnosticDetails(DiagnosticName, ShortName, fullname, email, phone, password);
		Thread.sleep(2000);
		AdminDiagnostic.EnterMandatoryFields(dateofbirth, desc, regno, dateofreg, rating, startedyear);
		Thread.sleep(2000);
	}
	
	
	
	@DataProvider(name ="HomeVisitDetails")
    public Object[][] createData_DP2() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","AdminDiagnostic", "TC2");
        return(retObjArr);
    }
	
	@Test(dataProvider="HomeVisitDetails", priority=3,enabled=false)
	public void EnterHomevisitDetails(String RunMode,String homevisitvalue,String charge,String range,String appperslot,String mvalue,String starttime,String endtime,
			String tvalue,String tstarttime,String tendtime,String Wvalue,String Wstarttime,String Wendtime,String thvalue,String thstarttime,String thendtime,
			String fvalue,String fstarttime,String fendtime,String Svalue,String Sstarttime,String Sendtime) throws Exception{
		
		AdminDiagnostic.EnterHomeVisitDetails(homevisitvalue, charge, range, appperslot, mvalue, starttime, endtime, tvalue, tstarttime, tendtime, Wvalue, 
				Wstarttime, Wendtime,thvalue, thstarttime, thendtime, fvalue, fstarttime, fendtime, Svalue, Sstarttime, Sendtime);
		Thread.sleep(2000);
	}
	
	
	
	
	@DataProvider(name ="LabVisitDetails")
    public Object[][] createData_DP3() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","AdminDiagnostic", "TC3");
        return(retObjArr);
    }
	
	@Test(dataProvider="LabVisitDetails", priority=4,enabled=false)
	public void EnterLabvisitDetails(String RunMode,String labslotduration,String labapptperslot,String Lmvalue,String Lmstarttime,String Lmendtime,
			String Ltvalue,String Ltstarttime,String Ltendtime,String LWvalue,String LWstarttime,String LWendtime,String LThvalue,String LThstarttime,
			String LThendtime,String Lfvalue,String Lfstarttime,String Lfendtime,String LSvalue,String LSstarttime,String LSendtime) throws Exception{
		
		AdminDiagnostic.EnterLabVisitDetails(labslotduration, labapptperslot, Lmvalue, Lmstarttime, Lmendtime, Ltvalue, Ltstarttime, Ltendtime, 
		LWvalue, LWstarttime, LWendtime, LThvalue, LThstarttime, LThendtime, Lfvalue, Lfstarttime, Lfendtime, LSvalue, LSstarttime, LSendtime);
		Thread.sleep(2000);
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
		Thread.sleep(1000);
		AdminDiagnostic.AddHealthPackages(servicemode, packagename, packagedesc, packagecost, discountpercentage, zoylopercentage,
				packageduration, packageperslot);
		Thread.sleep(2000);
	}
	
	
	@DataProvider(name ="HealthTests")
    public Object[][] createData_DP5() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","AdminDiagnostic", "TC5");
        return(retObjArr);
    }
	
	@Test(dataProvider="HealthTests", priority=6)
	public void AddTestsInHealthPackage(String testname,String testdesc) throws Exception{
		
		AdminDiagnostic.AddTestsInHealthPackage(testname, testdesc);
		Thread.sleep(2000);
		AdminDiagnostic.SaveAddHealthPackages();
		
	}
	
	
	@DataProvider(name ="DiagnosticTests")
    public Object[][] createData_DP6() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","AdminDiagnostic", "TC6");
        return(retObjArr);
    }
	
	@Test(dataProvider="DiagnosticTests", priority=7)
	public void AddDiagnosticTests(String diagTestname,String diagTestdesc,String servicemode,String diagTestcost,String diagdiscountper,
			String diagZoyloper,String diagduration,String diagNumofSlots) throws Exception{
		
		AdminDiagnostic.CreateDiagnosticTests(diagTestname, diagTestdesc, servicemode, diagTestcost, diagdiscountper, 
				diagZoyloper, diagduration, diagNumofSlots);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

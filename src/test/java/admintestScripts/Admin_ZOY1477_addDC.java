package admintestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.AdminPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Admin_ZOY1477_addDC extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values

	public String dcNameV="Srinivas diagnostics";
	public String dcshrV="Srinivasdc";
	public String dcEmail="srinivas_dc@zoylo.com";
	public String dcNum="7778800003";
	public String ucontactNumber="9000000003";
	public String ucontactEmail="milan33@zoylo.com";

	public String zqa="https://zoyloqa.zoylo.com/admin/zyDiagnosticCenters";
	public String pit="https://pit.zoylo.com/admin/zyDiagnosticCenters";
	//Visit type is only Home Visit and Lab Visit
	public String packageVisit="Lab Visit";
	public String testVisit="Lab Visit";
	
	@DataProvider(name="userGenericDetails")
	public Object[][] userGeneric()
	{
		return new Object[][]
				{
					{dcNameV, dcshrV, "Java One", dcEmail, "Zoylo@123", "Zoylo@123", dcNum, "Approved"}
			
				};
	}
	
	@Test(dataProvider="userGenericDetails", priority=1)
	public void dcUsergenericDetails(String dcName, String dcShortName, String ufullName, String uEmail, String passcode, String confPassCode, String uNum, String stat)
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		//Change environment
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Diagnostic Center')]", "Diagnostic Center");
		driver.findElement(By.id("add")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Diagnostic Center - Add')]", "Diagnostic Center - Add");
		driver.findElement(By.name("diagnosticCenterName")).sendKeys(dcName);
		driver.findElement(By.name("diagnosticCenterShortName")).sendKeys(dcShortName);
		driver.findElement(By.name("user.fullName")).sendKeys(ufullName);
		driver.findElement(By.name("user.email")).sendKeys(uEmail);
		driver.findElement(By.name("user.password")).sendKeys(passcode);
		driver.findElement(By.name("user.confirmPassword")).sendKeys(confPassCode);
		driver.findElement(By.name("primaryPhoneNumber")).sendKeys(uNum);
		
		Browser.actionbyname("zoyloStatusCode", stat);
		
	    Browser.closeSecondTab();
		
	} // End of generic method p1
	
	@DataProvider(name="dcAddress")
	public Object[][] dcaddrs()
	{
		return new Object[][]
				{
					{"Telangana", "Hyderabad", "500082", "Hitech City", "Cyber towers", "76.45", "16.77"}
				};
	}
	
	@Test(dataProvider="dcAddress", priority=2)
	public void diagAddress(String state, String city, String pincode, String locality, String landMark, String lng, String lat)
	{
		driver.findElement(By.name("addresses.0.isActive")).click();
		driver.findElement(By.name("addresses.0.address.addressLine1")).sendKeys("Add line one");
		
		//Country
		driver.findElement(By.xpath(".//*[@id='insertZyDiagnosticCenter']/div/div[2]/fieldset/div[17]/ul/li[1]/div/div[2]/div/div[2]/div[3]/div[2]/div[4]/span[1]/span[1]/span")).click();
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys("India");
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
		
		//State
		driver.findElement(By.xpath(".//*[@id='insertZyDiagnosticCenter']/div/div[2]/fieldset/div[17]/ul/li[1]/div/div[2]/div/div[2]/div[3]/div[2]/div[5]/span[1]/span[1]/span")).click();
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys(state);
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
		
		//City
		driver.findElement(By.xpath(".//*[@id='insertZyDiagnosticCenter']/div/div[2]/fieldset/div[17]/ul/li[1]/div/div[2]/div/div[2]/div[3]/div[2]/div[6]/span[1]/span[1]/span")).click();
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys(city);
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.name("addresses.0.address.addressPincode")).sendKeys(pincode);
		driver.findElement(By.name("addresses.0.address.addressLocality")).sendKeys(locality);
		driver.findElement(By.name("addresses.0.address.addressLandmark")).sendKeys(landMark);
		driver.findElement(By.name("addresses.0.address.addressGPSLongitude")).sendKeys(lng);
		driver.findElement(By.name("addresses.0.address.addressGPSLatitude")).sendKeys(lat);
		
	} //End of address method p2
	
	@DataProvider(name="contactimg")
	public Object[][] contact()
	{
		return new Object[][]
				{
					{"Veever Milan", ucontactNumber, ucontactEmail, "15", "10"}
				};
	}
	
	@Test(dataProvider="contactimg", priority=3)
	public void conimagedetails(String conName, String conNum, String conEmail, String sldu, String appPerslot) throws InterruptedException
	{
		driver.findElement(By.name("contactPersons.0.contactPersonName")).sendKeys(conName);
		driver.findElement(By.name("contactPersons.0.contactPersonPhone")).sendKeys(conNum);
		driver.findElement(By.name("contactPersons.0.contactPersonEmail")).sendKeys(conEmail);
		Browser.scrollbyxpath("//h3[contains(., 'Images List')]");
		driver.findElement(By.xpath("//input[@file-input='imagesList.0.fileRecordId']")).sendKeys(dc_image);
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//input[@name='imagesList.0.isDefault' AND @value='true']")).click();
		driver.findElement(By.name("clinicSlotDuration")).sendKeys(sldu);
		driver.findElement(By.name("clinicAppointmentsPerSlot")).sendKeys(appPerslot);
	} //End of contact and image method , p3
	
	@DataProvider(name="dcTimeslots")
	public Object[][] diagSlots()
	{
		return new Object[][]
				{
					{"Monday", "09:00", "20:00", "Monday", "09:00", "20:00"}
				};
	}
	
	@Test(dataProvider="dcTimeslots", priority=4)
	public void diagnosticSlots(String day, String dayStart, String dayEnd, String hday, String hdayStart, String hDayEnd)
	{
		//LAB VISIT
		Browser.actionbyname("clinicVisitOperatingHours.0.dayCode", day);
		Browser.closeSecondTab();
		
		driver.findElement(By.name("clinicVisitOperatingHours.0.isActive")).click();
		driver.findElement(By.name("clinicVisitOperatingHours.0.workStartTime")).sendKeys(dayStart);
		driver.findElement(By.name("clinicVisitOperatingHours.0.workEndTime")).sendKeys(dayEnd);
		driver.findElement(By.name("clinicVisitOperatingHours.0.isLunchTimeActive")).click();
		
		//HOME VISIT
		Browser.scrollbyxpath(".//*[@id='insertZyDiagnosticCenter']/div/div[2]/fieldset/div[28]/div");
		Browser.actionbyname("homeVisitOperatingHours.0.dayCode", hday);
		Browser.closeSecondTab();
		Browser.scrollbyName("clinicVisitOperatingHours.0.isLunchTimeActive");
		//Browser.waitforElementName("homeVisitOperatingHours.0.isActiv");
		driver.findElement(By.name("homeVisitOperatingHours.0.isActive")).click();
		driver.findElement(By.name("homeVisitOperatingHours.0.workStartTime")).sendKeys(hdayStart);
		driver.findElement(By.name("homeVisitOperatingHours.0.workEndTime")).sendKeys(hDayEnd);
		driver.findElement(By.name("homeVisitOperatingHours.0.isLunchTimeActive")).click();
		
		Browser.scrollbyName("isReportOnline");
	} //End of diagnosticSlots method, p4
	
	@DataProvider(name="testAndPackage")
	public Object[][] tp()
	{
		return new Object[][]
				{
			{"Approved", packageVisit, "Full body checkup", "10", "1", "CBT", "Approved", testVisit, "10", "3"}
				};
	}
	
	@Test(dataProvider="testAndPackage", priority=5)
	public void testPackage(String pStatus, String pType, String pName, String pCost, String pZFC, String tname, String taStatus, String tMode, String tCost, String tZFC) throws Exception
	{
		//Package
		Browser.actionbyname("healthPackages.0.adminStatus", pStatus);
		Browser.closeSecondTab();
		driver.findElement(By.name("healthPackages.0.isActive")).click();
		Browser.actionbyname("healthPackages.0.serviceMode", pType);
		Browser.closeSecondTab();
		driver.findElement(By.name("healthPackages.0.packageName")).sendKeys(pName);
		driver.findElement(By.name("healthPackages.0.packageCost")).sendKeys(pCost);
		driver.findElement(By.name("healthPackages.0.zoyloChargePercentage")).clear();
		driver.findElement(By.name("healthPackages.0.zoyloChargePercentage")).sendKeys(pZFC);
		Browser.scrollbyName("healthPackages.0.averageNumberOfPackagesPerSlot");
		
		//Test
		driver.findElement(By.id("addTests")).click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    
	    //Actions on new tab
	    Browser.waitforTextbyxpath("//h4[contains(., 'Diagnostic Center Test - Add')]", "Diagnostic Center Test - Add");
	    driver.findElement(By.name("testName")).sendKeys(tname);
	    Browser.actionbyname("adminStatus", taStatus);
	    Browser.actionbyname("serviceMode", tMode);
	    driver.findElement(By.name("testCost")).sendKeys(tCost);
	    driver.findElement(By.name("zoyloChargePercentage")).clear();
	    driver.findElement(By.name("zoyloChargePercentage")).sendKeys(tZFC);
	    driver.findElement(By.name("isActive")).click();
	    
	    driver.findElement(By.id("zyInsertDiagnosticCenterTest")).click();
	    
	    if(driver.findElement(By.xpath("html/body/div[6]/div")).isDisplayed())
	    {
	    	driver.close();
			driver.switchTo().window(tabs2.get(0));
	    }
	   //Browser.waitforTextbyxpath("html/body/div[6]/div", "Diagnostic Test  saved successfully");
	   
	   Browser.scrollbyID("zyInsertDiagnosticCenter");
	   driver.findElement(By.id("zyInsertDiagnosticCenter")).click();
	   
	   System.out.println("Diagnostic centre " +dcEmail+ " saved");
	   Thread.sleep(2000);
	    
	}//End of p5
	
	@BeforeClass
	public void launchbrowser() throws Exception
	{
		LoadBrowserProperties();
		Elements_Admin.Admin_PageProperties(); // loading the Elements
		Elements_Recipients.Recipients_PageProperties();
		Browser= new TestUtils(driver);
		admin=new AdminPage(driver);
		driver.get(loginPage_Url);
	}
	
	@AfterClass
	public void closebrowser()
	{
		driver.close();
	}
	
}

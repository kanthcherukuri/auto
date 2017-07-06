package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;



import java.util.concurrent.TimeUnit;
import objectRepository.Elements_Diagnostics;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY960_InManageUpdateAmenities extends LoadPropMac {
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	@BeforeClass
	  public void launchbrowser() throws Exception {
		LoadBrowserProperties();
		 driver.manage().window().maximize();
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		  }
	@Test
	public void DiagnisticManageUpdateAmenities() throws Exception{
		
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		DiagnosticPageZoylo.ScheduleClickOnDiagnosticManage();
		Thread.sleep(1000);
		Browser.clickOnTheElementByID(Elements_Diagnostics.amenitiesbikeparking);
		Browser.clickOnTheElementByID(Elements_Diagnostics.amenitiescarparking);
		Browser.clickOnTheElementByID(Elements_Diagnostics.amenitiespremiunservice);
		Browser.clickOnTheElementByID(Elements_Diagnostics.amenitiesemergencyservices);
		Browser.clickOnTheElementByID(Elements_Diagnostics.amenitiessave);
		Browser.CheckNotificationMessage("Amenities updated successfully");
	}
	
	@AfterClass
	public void closebrowser(){
		driver.quit();
	}

}

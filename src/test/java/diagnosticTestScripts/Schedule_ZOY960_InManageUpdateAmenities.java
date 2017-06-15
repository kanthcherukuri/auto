package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
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
		Thread.sleep(2000);
		DiagnosticPageZoylo.ScheduleClickOnDiagnosticManage();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.amenitiesbikeparking)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.amenitiescarparking)).click();
		Thread.sleep(1000);
		//driver.findElement(By.id(Elements_Diagnostics.amenitiescardswipe)).click();
		//Thread.sleep(1000);
		//driver.findElement(By.id(Elements_Diagnostics.amenitieswashroom)).click();
		//Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.amenitiespremiunservice)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.amenitiesemergencyservices)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Diagnostics.amenitiessave)).click();
		Browser.CheckNotificationMessage("Amenities updated successfully");
	}
	
	@AfterClass
	public void closebrowser(){
		driver.quit();
	}

}

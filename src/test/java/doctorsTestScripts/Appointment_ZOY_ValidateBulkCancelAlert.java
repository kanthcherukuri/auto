
package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY_ValidateBulkCancelAlert extends LoadPropMac{
	public DoctorsPage DoctorsPage;
	public TestUtils Browser;
	
	@BeforeClass
	public void LaunchBrowser() throws Exception {
		
		LoadBrowserProperties(); 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DoctorsPage= new DoctorsPage(driver);
		 Browser=new TestUtils(driver);
		 Browser.openUrl(loginPage_Url);
		 driver.manage().window().maximize();	
		 DoctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
	  } 
	
	
	@DataProvider(name ="AlertAppBulkCancel")
    public Object[][] createData_DP1() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/DoctorProvider.xls","Alert", "ZOYAlertAppBulkCancel");
        return(retObjArr);
    }
	
	
	
	@Test(dataProvider="AlertAppBulkCancel")
	public void CheckAlertforBulkCancel(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		DoctorsPage.DoctorAppointmentBookingForToday(firstname, lastname, mobile, email, problem);
		Thread.sleep(2000);
		DoctorsPage.BulkCancel();
		DoctorsPage.ClickonAlertmenu();
		String alert=driver.findElement(By.xpath("(//span[@id='message'])[1]")).getText();
		System.out.println(alert);
		Assert.assertTrue(alert.contains("Bulk Cancellation by the Doctor"));

		
	}
	
	@AfterMethod
	public void bulkCancelandlogout() throws Exception{
		DoctorsPage.doctorlogout();
	}
	
	@AfterClass
	public void closebrowser(){
		driver.quit();
	}
}

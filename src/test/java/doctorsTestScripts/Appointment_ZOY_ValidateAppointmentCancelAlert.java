package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY_ValidateAppointmentCancelAlert extends LoadPropMac{
	
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
	
	@DataProvider(name ="AlertAppCancel")
    public Object[][] createData_DP1() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/DoctorProvider.xls","Alert", "ZOYAlertAppCancel");
        return(retObjArr);
    }
	
	

	@Test(dataProvider="AlertAppCancel")
	public void CheckAlertforAppointmentCancel(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		
		DoctorsPage.DoctorsAppointmentforTomorrow(firstname, lastname, mobile, email, problem);
		DoctorsPage.ClickView();
		String id=DoctorsPage.getappointmentid();
		DoctorsPage.Cancel(firstname, lastname, mobile, email, problem);
		Browser.CheckNotificationMessage("Appointment has been Cancelled");
		DoctorsPage.ClickonAlertmenu();
		System.out.println("value:"+id);
		String alert=driver.findElement(By.xpath("(//span[@id='message'])[1]")).getText();
		System.out.println(alert);
		Assert.assertTrue(alert.contains("You have CANCELLED the appointment"));
		Thread.sleep(1000);
		Assert.assertTrue(alert.contains(id));
		
		
		}
	
	@AfterMethod
	public void bulkCancelandlogout() throws Exception{
		DoctorsPage.BulkCancel();
		DoctorsPage.doctorlogout();
	}
	
	
	@AfterClass
	public void closebrowser(){
		driver.quit();
	}
}

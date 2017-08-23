package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;




import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;


import objectRepository.Elements_Doctors;


import org.testng.annotations.DataProvider;
import java.util.concurrent.TimeUnit;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY_ValidateAppointmentbookingAlert extends LoadPropMac {
	
	public DoctorsPage DoctorsPage;
	public TestUtils Browser;
	
	@BeforeClass
	public void LaunchBrowser() throws Exception {
		
		LoadBrowserProperties(); 
		 DoctorsPage= new DoctorsPage(driver);
		 Browser=new TestUtils(driver);
		 Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DoctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
	  } 
	
	@DataProvider(name = "AlertAppBk")
    public Object[][] createData_DP1() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/DoctorProvider.xls","Alert", "ZOYAlertAppBK");
        return(retObjArr);
    }
	


	@Test(dataProvider="AlertAppBk")
	public void CheckAlertforAppointmentBooking(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		
		DoctorsPage.DoctorsAppointmentforTomorrow(firstname, lastname, mobile, email, problem);
		String fullname=firstname+" "+lastname;
		Browser.CheckNotificationMessage("Appointment is confirmed. Patient Name: "+fullname); 
		DoctorsPage.ClickView();
		String name=driver.findElement(By.xpath(Elements_Doctors.appointment_getfullnameonclickviewmenu)).getText();
		System.out.println(name);	
		String	AppointmentId=driver.findElement(By.xpath(Elements_Doctors.appointment_getappointmentid)).getText();
		System.out.println(AppointmentId);
		Browser.clickOnTheElementByID(Elements_Doctors.alert_clickonalertmenu);
		Thread.sleep(10000);
		String Alert=driver.findElement(By.xpath("//*[@id='message' and contains(.,'"+name+"')]")).getText();
		System.out.println(Alert);
		Assert.assertTrue(Alert.contains(AppointmentId));
		Thread.sleep(1000);
		Assert.assertTrue(Alert.contains("You have booked an appointment for"));
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

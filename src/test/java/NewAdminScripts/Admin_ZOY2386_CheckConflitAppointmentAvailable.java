package NewAdminScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import objectRepository.Elements_NewAdminDoctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.NewAdminDiagnosticPage;
import testBase.NewAdminDoctorsPage;
import testBase.TestUtils;

public class Admin_ZOY2386_CheckConflitAppointmentAvailable extends LoadPropMac {
	
	public TestUtils Browser;
	public NewAdminDiagnosticPage AdminDiagnostic;
	public NewAdminDoctorsPage admin;
	public DoctorsPage DoctorsPage;
	
	 @BeforeClass
	  public void LaunchBrowser() throws Exception {
		  	LoadBrowserProperties();	 
			 DoctorsPage= new DoctorsPage(driver);	
			 AdminDiagnostic=new NewAdminDiagnosticPage(driver);	
			 admin=new NewAdminDoctorsPage(driver);
			 Browser= new TestUtils(driver);
			 Browser.openUrl(loginPage_Url);
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 DoctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
			  }
	 
	 @DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "Meeraa","K","9966655501","meeraa@gmail.com","Diabetic" }

			};
		}
	 
	 
	 @Test(dataProvider="DP1")
	 public void CheckConflitMessageWhenAppointmentAvalible(String firstname,String lastname,String mobile,String email,String problem) throws Exception {
		 
		 DoctorsPage.DoctorAppointmentBookingForSunday(firstname, lastname, mobile, email, problem);
		 DoctorsPage.doctorlogout();
		 Browser.openUrl(loginPage_Url);
		 AdminDiagnostic.SignIn(Admin_Username, Admin_Password);
		 admin.click_doctorsTab();
		 admin.searchDoctorbyEmailID("kanthzoylo@gmail.com");
		 admin.clickEditbutton();
		 Browser.waitTill(2000);
		 Browser.clickOnTheElementByID(Elements_NewAdminDoctors.workDaysTab);
		 Browser.clickOnTheElementByID(Elements_NewAdminDoctors.workDays_SundayActiveCheckBox);
		 Browser.waitFortheElementXpath(Elements_NewAdminDoctors.notification);
		 String notification=driver.findElement(By.xpath(Elements_NewAdminDoctors.notification)).getText();
		 Assert.assertTrue(notification.contains("Conflict with existing appointment"));
		 Browser.clickOnTheElementByXpath("//i[@class='fa fa-pencil editSlots']");
		 String notificationtwo=driver.findElement(By.xpath(Elements_NewAdminDoctors.notification)).getText();
		 Assert.assertTrue(notificationtwo.contains("Conflict with existing appointment"));
		 Browser.clickOnTheElementByXpath("//i[@class='fa fa-trash-o delSlots']");
		 String notificationthree=driver.findElement(By.xpath(Elements_NewAdminDoctors.notification)).getText();
		 Assert.assertTrue(notificationthree.contains("Conflict with existing appointment"));
		 Thread.sleep(2000);
		 admin.click_Profile_Options("Logout");
		 
	 }
	 
	 @AfterMethod
	 public void CancelAppointment() throws Exception {
		 Browser.openUrl(loginPage_Url); 
		 DoctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
		 DoctorsPage.cancelSundayAppt();
	 }
	 
	 @AfterClass
	 public void Closebrowser() {
		 driver.quit();
	 }
	 
	 

}

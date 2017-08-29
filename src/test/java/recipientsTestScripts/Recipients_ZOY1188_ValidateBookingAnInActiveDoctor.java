package recipientsTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.*;
import org.testng.SkipException;
import org.testng.annotations.*;
/*
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
*/
import testBase.*;
import objectRepository.*;


public class Recipients_ZOY1188_ValidateBookingAnInActiveDoctor extends LoadPropMac {
	 public RecipientPage RecipientPage;
	 public TestUtils Browser;	
	 public NewAdminDoctorsPage admin;
	 @BeforeClass(groups = { "Regression","High" })	
    public void launchBrowser() throws Exception {
  
		  LoadBrowserProperties(); // Create driver instance and launch the browser
		  Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		  RecipientPage = new RecipientPage(driver); // Loading Pages
		  Browser= new TestUtils(driver);   
		  admin=new NewAdminDoctorsPage(driver);
			 
 } 

 
	 @DataProvider(name = "DP1")
		public String[][] createData1() {
			return new String[][] {
					{ "yes","ganeshkumar.m@zoylo.com","Zoylo@123","Avinash" }

			};
		}
	 @Test(dataProvider="DP1",groups = { "Regression","Medium" })
	 public void validateBookingAnInActiveDoctor(String runmode,String Username,String Password,String Doctor ) throws Exception {
	  
		 if(runmode.equals("yes")){
			 			 
			  //Test Starts-Here
			  Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
			  admin.adminSignIn(admin_user, admin_password);
			  Browser.clickOnTheElementByXpath(Elements_NewAdminDoctors.doctorLabel);
			  admin.searchDoctorbyEmailID("aletiavinashreddy@gmail.com");
			  //InACtive Doctor
			  Browser.clickOnTheElementByXpath(Elements_NewAdminDoctors.adminListActiveCheckBox);
			  Thread.sleep(2000);
			  admin.click_Profile_Options("Logout");
			  Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");			  
			  RecipientPage.recipientLogin(Username, Password);
			  Browser.waitFortheElementXpath("//div[@class='pin bounce ']");
			  RecipientPage.goToMyAccounts("My Favourites");
			  Browser.clickOnTheElementByXpath("//*[@id='bookAppointment']/button");
			  String ActualNotification= driver.findElement(By.cssSelector("div.zy-status-wrapper")).getText();
			  Assert.assertEquals(ActualNotification,"Doctor is not working");
			  RecipientPage.recipientLogout();
			  //ACtive -Doctor
			  admin.adminSignIn(admin_user, admin_password);
			  Browser.clickOnTheElementByXpath(Elements_NewAdminDoctors.doctorLabel);
			  admin.searchDoctorbyEmailID("aletiavinashreddy@gmail.com");
			  Browser.clickOnTheElementByXpath(Elements_NewAdminDoctors.adminListActiveCheckBox);
			  Thread.sleep(2000);
			  admin.click_Profile_Options("Logout");
			  Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");			  
			  RecipientPage.recipientLogin(Username, Password);
			  RecipientPage.searchInZoyloMAP("Avinashzoylo Reddy Aleti");
	 
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }
    
	 @AfterClass(groups = { "Regression","High" })
		public void Exit() {
			
			driver.quit();
		} 
    
	

    
    
}
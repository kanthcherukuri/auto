package recipientsTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.openqa.selenium.*;
/*
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
*/
import testBase.*;
import objectRepository.*;

/*
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })

*/
public class Recipients_ZOY1162_ValidateRecipientAppointmentBookingFromMyFavourites extends LoadPropMac {
	 public RecipientPage RecipientPage;
	 public TestUtils Browser;	

	
	
		
	 @BeforeClass(groups = { "Regression","Medium" })	
    public void LaunchBrowser() throws Exception {
  
		  LoadBrowserProperties(); // Create driver instance and launch the browser
		  Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		  RecipientPage = new RecipientPage(driver); // Loading Pages
		  Browser= new TestUtils(driver);   
	
		  	 
 } 


	 @Test(groups = { "Regression","Medium" })
	 public void validateRecipientAppointmentBookingFromMyFavourites() throws Exception {
	   			 
			//Test Starts-Here
			Browser.openUrl(loginPage_Url);
			Thread.sleep(2000);
		    //Verify Recipient Login with valid details
			RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
			RecipientPage.searchInZoyloMAP(Doctor_Name);
			String Fav_DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
			System.out.println("fav"+Fav_DoctorFullName);
			RecipientPage.bookAppointment();
			driver.findElement(By.id("favourites")).click();
			Thread.sleep(2000);
			RecipientPage.goToMyAccount();
			driver.findElement(By.xpath("//li[@id='myFavourites']/a/span/i")).click(); // my account fav
			Browser.waitTill(30);
			String myActFav_DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
			Assert.assertEquals(Fav_DoctorFullName, myActFav_DoctorFullName);
			RecipientPage.bookAppointment();
			RecipientPage.selectDefaultSlot();
			RecipientPage.confirmAppointment("Test details");
		    RecipientPage.makePayment();
			String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
			Assert.assertEquals(SuccessfullMesg, "Thank you for booking appointment with "+myActFav_DoctorFullName+" through Zoylo. Your appointment booking details are below:");
			RecipientPage.openMyAccounts();
			//Verifying the reset of favaourites
			driver.findElement(By.xpath("//li[@id='myFavourites']/a/span/i")).click();
			Thread.sleep(2000);
			RecipientPage.bookAppointment();
			driver.findElement(By.id("favourites")).click();
			RecipientPage.goToMyAccount();
			driver.findElement(By.xpath("//li[@id='myFavourites']/a/span/i")).click(); // my account fav
			Browser.waitTill(30);
			boolean fav_doc= driver.findElements(By.xpath("//h1")) != null;
			System.out.println("fav doc after un check"+fav_doc);
			Assert.assertFalse(fav_doc);
			RecipientPage.goToDoctors();
			 
		
			
	    }
    
	 @AfterClass(groups = { "Regression","Medium" })
		public void Exit() {
			
			driver.quit();
		} 
    
	

    
    
}
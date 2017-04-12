package recipientsTestScripts;



import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;




import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.*;
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
public class Recipients_ZOY1072_ValidateAddDoctorFavourites extends LoadPropMac {
	 public RecipientPage RecipientPage;
	 public TestUtils Browser;	

	
	
		
	 @BeforeClass(groups = { "Regression","High" })	
    public void LaunchBrowser() throws Exception {
  
		  LoadBrowserProperties(); // Create driver instance and launch the browser
		  Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		  RecipientPage = new RecipientPage(driver); // Loading Pages
		  Browser= new TestUtils(driver);   
		  //Test Starts-Here
		  Browser.openUrl(recipient_url);			
	      //Verify Recipient Login with valid details
		  RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		  Thread.sleep(2000);
		  	 
 } 

 

	 @Test(groups = { "Regression","Medium" })
	 public void validateAddDoctorFavourites() throws Exception {
	  
	
			RecipientPage.searchInZoyloMAP(Doctor_Name);
			String Fav_DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
			RecipientPage.bookAppointment();
			driver.findElement(By.xpath("//*[@id='favourites']/a/span[1]")).click();
			RecipientPage.goToMyAccount();
			driver.findElement(By.xpath("//li[@id='myFavourites']/a/span/i")).click(); // my account fav
			Browser.waitTill(30);
			String myActFav_DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
			Assert.assertEquals(Fav_DoctorFullName, myActFav_DoctorFullName);
			
			
			//Verifying the reset of favaourites
			RecipientPage.bookAppointment();
			driver.findElement(By.xpath("//*[@id='favourites']/a/span[1]")).click();
			RecipientPage.goToMyAccount();
			driver.findElement(By.xpath("//li[@id='myFavourites']/a/span/i")).click(); // my account fav
			Browser.waitTill(30);
			boolean fav_doc= driver.findElements(By.xpath("//h1")).isEmpty();
			System.out.println("fav doc after un check"+fav_doc);
			Assert.assertTrue(fav_doc);
			RecipientPage.goToDoctors();
	
			
	    }

	 
	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       driver.close();

	    }
    
	

    
    
}
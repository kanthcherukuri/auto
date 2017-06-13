package recipientsTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
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

/*
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })

*/
public class Recipients_ZOY1072_ValidateAddDoctorFavourites extends LoadPropMac {
	 public RecipientPage RecipientPage;
	 public TestUtils Browser;	

	
	
		
	 @BeforeClass(groups = { "Regression","Medium" })	
    public void LaunchBrowser() throws Exception {
  
		  LoadBrowserProperties(); // Create driver instance and launch the browser
		  Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		  RecipientPage = new RecipientPage(driver); // Loading Pages
		  Browser= new TestUtils(driver);   
		  //Test Starts-Here
		  Browser.openUrl(loginPage_Url);			
	      //Verify Recipient Login with valid details
		  RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		  Thread.sleep(2000);
		  	 
 } 

 
	 @DataProvider(name = "DP1")
		public String[][] createData1() {
			return new String[][] {
					{ "yes","Deepak" }

			};
		}
	 @Test(dataProvider="DP1",groups = { "Regression","Medium" })
	 public void validateAddDoctorFavourites(String runmode,String Doctor ) throws Exception {
	  
		 if(runmode.equals("yes")){
			 			 

			RecipientPage.searchInZoyloMAP(Doctor);
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
 
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }
    
	 
	 @AfterClass(groups = { "Regression","Medium" })
		public void Exit() {
			
			driver.quit();
		} 
    
	

    
    
}
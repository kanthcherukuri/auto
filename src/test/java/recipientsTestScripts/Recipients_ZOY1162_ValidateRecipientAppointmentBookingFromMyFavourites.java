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
public class Recipients_ZOY1162_ValidateRecipientAppointmentBookingFromMyFavourites extends LoadProp {
	 public RecipientPage RecipientPage;
	 public TestUtils Browser;	

	
	
		
	 @BeforeClass(groups = { "Regression","High" })	
    public void LaunchBrowser() throws Exception {
  
		  LoadBrowserProperties(); // Create driver instance and launch the browser
		  Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		  RecipientPage = new RecipientPage(driver); // Loading Pages
		  Browser= new TestUtils(driver);   
	
		  	 
 } 

 
	 @DataProvider(name = "DP1")
	    public Object[][] createData_DP1() throws Exception{
	        Object[][] retObjArr=TestUtils.getTableArray("TestData\\Recipients_TestData.xls","Doctor", "ZOY1072");
	        return(retObjArr);
	    }
	 @Test(dataProvider="DP1",groups = { "Regression","Medium" })
	 public void ValidateRecipientAppointmentBookingFromMyFavourites(String runmode,String Username, String Password,String Doctor ) throws Exception {
	  
		 if(runmode.equals("yes")){
			 			 
			//Test Starts-Here
			Browser.openUrl(recipient_url);
			Thread.sleep(2000);
		    //Verify Recipient Login with valid details
			RecipientPage.recipientLogin(Username, Password);
			Thread.sleep(2000);
			RecipientPage.searchInZoyloMAP(Doctor);
			String Fav_DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
			System.out.println("fav"+Fav_DoctorFullName);
			RecipientPage.bookAppointment();
			driver.findElement(By.xpath("//*[@id='favourites']/a/span[1]")).click();
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
			RecipientPage.openRecipientsMyAccounts();
			//Verifying the reset of favaourites
			driver.findElement(By.xpath("//li[@id='myFavourites']/a/span/i")).click();
			Thread.sleep(2000);
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
    
	 
	 
	 
	 
	 
	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       
	       driver.close();
	       
	      
	    }
    
	

    
    
}
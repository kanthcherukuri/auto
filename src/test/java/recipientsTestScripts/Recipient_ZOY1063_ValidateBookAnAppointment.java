package recipientsTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.openqa.selenium.*;
import org.testng.SkipException;
import org.testng.annotations.*;

import testBase.*;
import objectRepository.*;

public class Recipient_ZOY1063_ValidateBookAnAppointment extends LoadPropMac {
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
		public String[][] createData1() {
			return new String[][] {
					{ "yes","Ganesh" }

			};
		}

	 @Test(dataProvider="DP1",groups = { "Regression","High" })
	 public void validateBookingAnAppointment(String runmode,String Doctor ) throws Exception {
	  
		 if(runmode.equals("yes")){
			 		 
			    //Test Starts-Here
				Browser.openUrl(loginPage_Url);			
				RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
				RecipientPage.searchInZoyloMAP(Doctor_Name);
				String DoctorFullName = Browser.getTextByXpath("//h1");
				String Fee = Browser.getTextByXpath("//div[@class='consultFee']");
				RecipientPage.bookAppointment();
				String[] Appointmentdetails = RecipientPage.selectDefaultSlot();
				System.out.println("Clinic Name details"+Appointmentdetails[0]);
				System.out.println("Time details"+Appointmentdetails[1]);
				RecipientPage.confirmAppointment("Patient details");
			    RecipientPage.makePayment();

				//Verifying Thank you Message in Thank you Page
				Assert.assertEquals(Browser.getTextByXpath("//h5"), "Thank you for booking appointment with "+DoctorFullName+" through Zoylo. Your appointment booking details are below:");
				//Verifying Doctor Name in Thank you Page
				Assert.assertTrue(Browser.getTextByXpath("//div[@class='book-dtbox']/p[1]/a").contains(Doctor_Name));
				//Verifying Clinic Name in Thank you Page
				Assert.assertTrue(Browser.getTextByXpath("//div[@class='book-dtbox']//h3[2]").contains(Appointmentdetails[0]));
				//Verifying Consultation Fee in Thank you Page
				Assert.assertTrue(Browser.getTextByXpath("//div[@class='book-dtbox']//p[2]").contains("Consultation:"+Fee.replace(" ", "")+""));
	 
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }
	  

	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       driver.quit();
	      
	    }
    
	

    
    
}
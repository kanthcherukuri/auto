package recipientsTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
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


public class Recipients_ZOY1095_ValidateHomePageSearch extends LoadPropMac {
	 public HomePage HomePage;
	 public TestUtils Browser;	

	
	
		
	 @BeforeClass(groups = { "Regression","High" })	
    public void LaunchBrowser() throws Exception {
  
		  LoadBrowserProperties(); // Create driver instance and launch the browser
		  Elements_Home.Home_PageProperties();// loading UI Page Elements / Locators
		  
		  HomePage = new HomePage(driver); // Loading Pages
		  Browser= new TestUtils(driver);   
		 // Browser.shareGeoLocation();
		  	 
 } 

	 
	 
	
	 @DataProvider(name = "DP1")
		public String[][] createData1() {
			return new String[][] {
					{ "yes","Hyderabad","Ameerpet","CARDIOLOGY","Ameerpet" },
					{ "yes","Bengalore","Marathahalli","CARDIOLOGY","Marathahalli" },
					{ "yes","Bengalore","Koramangala","","Koramangala" },
					{ "yes","Hyderabad","","","Hyderabad" },
					{ "yes","Hyderabad","","CARDIOLOGY","Hyderabad" },

			};
		}
	 @Test(dataProvider="DP1",groups = { "Regression","High" })
	 public void HomePageSearch(String runmode ,String City, String Locality,String Specialization,String Expected) throws Exception {
		  
		 if(runmode.equals("yes")){
			 //Test Starts - Here
			 Browser.openUrl(base_url);
			 HomePage.searchZoylo(City, Locality, Specialization);
			 Browser.waitFortheElementXpath(Elements_Home.Map_Doctors);
			 String ActualResult = driver.findElement(By.id(Elements_Home.map_AreaName)).getText();
			 //Comparing Actual VS Expected
			 Assert.assertEquals(ActualResult, Expected);	
			
		 }else{
		
			 throw new SkipException("RUNMODE IS OFF");
		 }
	
	    }

	 @AfterClass(groups = { "Regression","High" })
		public void Exit() {
			
			driver.quit();
		} 
    
	

    
    
}